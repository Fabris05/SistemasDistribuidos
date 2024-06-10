<%-- 
    Document   : login
    Created on : 4 may. 2024, 14:16:30
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Inicio de Sesion</title>
        <style>
            #container-form{
                box-shadow: 0 0 8px whitesmoke;
                border-radius: 5px;
            }
        </style>
    </head>
    <body>
        <div class="d-flex justify-content-center align-items-center vw-100 vh-100 bg-light text-dark bg-dark">
            
            <div class="col-4 justify-content-center p-4 mb-5 bg-white " id="container-form">
                
                <div class="d-flex justify-content-center">
                    <h1 class="justify-content-center">Inicio de Sesión</h1>
                </div>
                <div class="d-flex justify-content-center mt-2">
                    <svg xmlns="http://www.w3.org/2000/svg" width="65" height="65" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1"/>
                    </svg>
                </div>
                <form action="Login" method="POST">
                    <div class="mt-4">
                        <label class="form-label fw-bold">Usuario</label>
                        <input type="text" class="form-control" name="txtUsuario" placeholder="Ingrese su usuario" autocomplete="off" required="on">
                    </div>
                    <div class="mt-4">
                        <label class="form-label fw-bold">Contraseña</label>
                        <input type="password" class="form-control" name="txtPass" placeholder="Ingrese su contraseña" required="on">
                    </div>

                    <div class="d-flex col mt-4 justify-content-center">
                        <button type="submit" class="btn btn-success gap-1" name="validad" value="Aceptar" style="display: flex; align-items: center;">
                            <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0z"/>
                            <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z"/>
                            </svg>
                            &nbsp;
                            <span class="fw-bold">Iniciar Sesión</span>
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
