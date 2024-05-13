<%-- 
    Document   : header
    Created on : 5 may. 2024, 01:14:25
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>

        .navbar .nav-item:not(:last-child) {
            margin-right: 30px;
        }
        .dropdown-toggle::after {
            transition: transform 0.15s linear;
        }
        
        .show.dropdown .dropdown-toggle::after {
            transform: translateY(3px);
        }
    </style>
    </head>
    
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            
            <div class="container-fluid">
                <div class="d-flex col justify-content-center">
                    
                </div>
                <!-- comment
                <a class="navbar-brand">
                    <img class="logo horizontal-logo" src="" >
                    
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                -->
 
                <div class="collapse navbar-collapse" id="navbarSupportedContend">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#" style="color: white;">Menú Principal</a>
                        </li>
                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white;">
                                Cliente
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown1">
                                <a class="dropdown-item" href="../SistemasDistribuidos/Clientes">Mis clientes</a>
                                <a class="dropdown-item" href="../SistemasDistribuidos/Agregar_Cliente">Añadir cliente</a>
                            </div>
                        </li>
                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white;">
                                Productos
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                                <a class="dropdown-item" href="../SistemasDistribuidos/Clientes">Mis productos</a>
                                <a class="dropdown-item" href="../SistemasDistribuidos/Cliente_Agregar.jsp">Añadir producto</a>
                            </div>
                        </li>
                    </ul>
                    <div class="d-flex col justify-content-end">
                        <form action="CerrarSesion" method="post">
                            <button class="btn btn-info btn-sm">
                                <a class="btn btn-info btn-sm" href="../login.jsp" role="button" id="cerrarSesion">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-power" viewBox="0 0 16 16">
                                    <path d="M7.5 1v7h1V1z"/>
                                    <path d="M3 8.812a5 5 0 0 1 2.578-4.375l-.485-.874A6 6 0 1 0 11 3.616l-.501.865A5 5 0 1 1 3 8.812"/>
                                    </svg>
                                </a>
                            </button>
                        </form>
                    </div>
              
                </div>
            </div>
            
        </nav>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
    
</html>
