/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.ConexionDB;
import Entidades.Categoria;
import Interfaces.CategoriaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabri
 */
public class CategoriaSQLData implements CategoriaData {

    @Override
    public List<Categoria> findCategorias() {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
        List<Categoria> list=new ArrayList<Categoria>();
        try{
            PreparedStatement pstm=conn.prepareStatement(BUSCAR_ID_NOMBRE_CATEGORIA);
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                Categoria categoria=new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setCategoria(rs.getString("categoria"));
                list.add(categoria);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }
    
}
