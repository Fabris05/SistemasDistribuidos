/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.ConexionDB;
import Entidades.Pedido;
import Interfaces.PedidoData;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author fabri
 */
public class PedidoSQLData implements PedidoData {

    @Override
    public List<Pedido> findAllPedidos() {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = null;
        List<Pedido> listaPedidos = new ArrayList<>(); // Inicializar la lista fuera del bucle

        try {
            conn = conexiondb.Connected();
            PreparedStatement pstm = conn.prepareStatement(BUSCAR_PEDIDOS);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();

                pedido.setCodigo(rs.getString("Codigo_Pedido"));
                pedido.setCliente(rs.getString("cliente"));
                pedido.setNumDocumento(rs.getString("numeroDocumento"));
                pedido.setFecha(rs.getDate("Fecha"));
                pedido.setSubTotal(rs.getDouble("SubTotal"));
                pedido.setIgv(rs.getDouble("IGV"));
                pedido.setTotal(rs.getDouble("Total"));

                listaPedidos.add(pedido);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexiondb.Discconet();
        }

        return listaPedidos; // Devolver la lista fuera del bucle
    }


    @Override
    public void agregarPedido(Pedido pedido, List<Pedido> productosPedido, HttpServletRequest request) {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = null;
        PreparedStatement pstmPedido = null;
        PreparedStatement pstmDetallePedido = null;

        try {
            conn = conexiondb.Connected();
            conn.setAutoCommit(false);

            // Generar y asignar código de pedido
            String codigoPedido = generarCodigo();
            pedido.setCodigo(codigoPedido);

            // Insertar el pedido principal
            pstmPedido = conn.prepareStatement(AGREGAR_NUEVO_PEDIDO, Statement.RETURN_GENERATED_KEYS);
            pstmPedido.setString(1, codigoPedido);
            pstmPedido.setString(2, pedido.getIdCliente());
            pstmPedido.setDate(3, getCurrentDateTimeAsSqlDate());
            pstmPedido.setDouble(4, pedido.getSubTotal());
            pstmPedido.setDouble(5, pedido.getIgv());
            pstmPedido.setDouble(6, pedido.getTotal());
            pstmPedido.setInt(7, pedido.getIdUser());
            pstmPedido.executeUpdate();

            // Obtener el ID generado del pedido principal
            int idPedido = 0;
            ResultSet generatedKeys = pstmPedido.getGeneratedKeys();
            if (generatedKeys.next()) {
                idPedido = generatedKeys.getInt(1);
            }

            // Insertar los productos del pedido en batch
            pstmDetallePedido = conn.prepareStatement(AGREGAR_DETALLE_PEDIDO);
            for (Pedido pedidoDetalle : productosPedido) {
                pstmDetallePedido.setInt(1, idPedido);
                pstmDetallePedido.setString(2, pedidoDetalle.getCodigoProducto());
                pstmDetallePedido.setString(3, pedidoDetalle.getNombreProducto());
                pstmDetallePedido.setInt(4, pedidoDetalle.getCantidadProducto());
                pstmDetallePedido.setDouble(5, pedidoDetalle.getPrecioU());
                pstmDetallePedido.setDouble(6, pedidoDetalle.getPrecioF());
                pstmDetallePedido.addBatch();
            }

            pstmDetallePedido.executeBatch();
            conn.commit();

            // Generar la boleta después de confirmar la transacción
            this.generarBoleta(idPedido, codigoPedido, request);

        } catch (SQLException | ServletException | IOException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Revertir transacción en caso de error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            // Cerrar recursos en el bloque finally
            if (pstmPedido != null) {
                try {
                    pstmPedido.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmDetallePedido != null) {
                try {
                    pstmDetallePedido.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Restaurar el auto-commit
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void generarBoleta(int idPedido, String codigoPedido, HttpServletRequest request) throws ServletException, IOException {
    try {
        ServletContext context = request.getServletContext();
//        String realPath = context.getRealPath("/");
        String outputDirPath = "C:/Users/fabri/OneDrive/Imágenes/Documentos/NetBeansProjects/Project_SD/src/main/webapp/ReportesJasper/Boletas/";
        String outputFilePath = outputDirPath + codigoPedido + ".pdf";
        System.out.println("Guardando el reporte en: " + outputFilePath);

        // Crear directorio si no existe
        File outputDir = new File(outputDirPath);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        // Crear un nuevo documento PDF
        PdfWriter writer = new PdfWriter(outputFilePath);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc, PageSize.A4);

        // Agregar la cabecera con información de la empresa
        float[] headerColumnWidths = {1};
        Table headerTable = new Table(headerColumnWidths).setWidth(UnitValue.createPercentValue(100)).setFixedLayout();
        headerTable.setTextAlignment(TextAlignment.RIGHT);
        headerTable.setBorder(null);
        headerTable.addCell(new Cell().add(new Paragraph("Nombre de la empresa: Empresa XYZ")).setBorder(null));
        headerTable.addCell(new Cell().add(new Paragraph("RUC: 123456789")).setBorder(null));
        headerTable.addCell(new Cell().add(new Paragraph("Celular: 987654321")).setBorder(null));
        headerTable.addCell(new Cell().add(new Paragraph("Correo Electrónico: info@empresa.com")).setBorder(null));
        headerTable.addCell(new Cell().add(new Paragraph("Dirección: Calle Falsa 123")).setBorder(null));
        document.add(headerTable);

        // Agregar una línea divisoria
        document.add(new Paragraph("---------------------------------------------------------------------------------------").setTextAlignment(TextAlignment.CENTER));

        // Obtener la lista de productos del pedido
        List<Pedido> listadoPedidos = this.findAllDetallePedidos(idPedido);
        if (listadoPedidos == null || listadoPedidos.isEmpty()) {
            System.out.println("No se encontraron detalles para el pedido con ID: " + idPedido);
            return;
        }

        // Crear la tabla con los productos
        float[] columnWidths = {2, 5, 2, 2, 2};
        Table table = new Table(columnWidths).setWidth(UnitValue.createPercentValue(100)).setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell(new Cell().add(new Paragraph("Código")));
        table.addHeaderCell(new Cell().add(new Paragraph("Producto")));
        table.addHeaderCell(new Cell().add(new Paragraph("Cantidad")));
        table.addHeaderCell(new Cell().add(new Paragraph("Precio U")));
        table.addHeaderCell(new Cell().add(new Paragraph("Precio F")));

        for (Pedido p : listadoPedidos) {
            String codigoProducto = p.getCodigo()!= null ? p.getCodigo() : "N/A";
            String nombreProducto = p.getNombreProducto() != null ? p.getNombreProducto() : "N/A";
            String cantidadProducto = String.valueOf(p.getCantidadProducto());
            String precioUnitario = String.valueOf(p.getPrecioU());
            String precioFinal = String.valueOf(p.getPrecioF());
            
            table.addCell(new Cell().add(new Paragraph(codigoProducto)));
            table.addCell(new Cell().add(new Paragraph(nombreProducto)));
            table.addCell(new Cell().add(new Paragraph(cantidadProducto)));
            table.addCell(new Cell().add(new Paragraph(precioUnitario)));
            table.addCell(new Cell().add(new Paragraph(precioFinal)));
        }

        document.add(table);

        // Agregar el pie de página (vacío por ahora)
        Paragraph footer = new Paragraph("Pie de página")
                .setTextAlignment(TextAlignment.CENTER);
        document.add(footer);

        // Cerrar el documento
        document.close();

        System.out.println("Reporte generado y guardado con éxito.");
    } catch (Exception ex) {
        System.out.println("Error al generar el reporte de boleta: " + ex.getMessage());
        ex.printStackTrace();
    }
}

    @Override
    public String generarCodigo() {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        String codigoPedido = "";
        String sql = "SELECT MAX(CAST(SUBSTRING(Codigo_Pedido, 3) AS UNSIGNED)) AS MaxId FROM Pedido";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                int maxId = rs.getInt("MaxId");
                maxId++; // Incrementar el ID máximo en 1

                // Formatear el nuevo ID asegurando que tenga una longitud máxima de 12 caracteres
                codigoPedido = String.format("V-%010d", maxId);
            } else {
                // Si no hay registros en la tabla, el primer ID será V-0000000001
                codigoPedido = "V-0000000001";
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexiondb.Discconet();
        }
        return codigoPedido;
    }

    public static java.sql.Date getCurrentDateTimeAsSqlDate() {
        java.util.Date currentDate = new java.util.Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = sdf.format(currentDate);

        try {
            java.util.Date parsedDate = sdf.parse(formattedDateTime);

            Timestamp timestamp = new Timestamp(parsedDate.getTime());

            java.sql.Date sqlDate = new java.sql.Date(timestamp.getTime());

            return sqlDate;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Pedido> findAllDetallePedidos(int idPedido) {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        try {
            PreparedStatement pstm = conn.prepareStatement(BUSCAR_DETALLE_PEDIDO);
            pstm.setInt(1, idPedido);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                List<Pedido> listaProductos = new ArrayList<>();
                Pedido detallePedido = new Pedido();
                detallePedido.setCodigo(rs.getString("codigoProducto"));
                detallePedido.setNombreProducto(rs.getString("nombreProducto"));
                detallePedido.setCantidadProducto(rs.getInt("Cantidad"));
                detallePedido.setPrecioU(rs.getDouble("Precio_Unit"));
                detallePedido.setPrecioF(rs.getDouble("Total"));

                listaProductos.add(detallePedido);
                return listaProductos;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

        }
        return null;
    }

}
