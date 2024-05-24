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
    </head>
    <body>
        <div class="d-flex justify-content-center align-items-center vw-100 vh-100 bg-light text-dark">
            <div class="col-4 align-items-center justify-content-center border border-dark rounded p-4 mb-5 bg-white">
                
                <div class="d-flex justify-content-center">
                    <h1 class="justify-content-center">Inicio de Sesión</h1>
                </div>
                <form action="Login" method="POST">
                    <div class="mt-4">
                        <label class="form-label">Usuario</label>
                        <input type="text" class="form-control" name="txtUsuario" placeholder="Ingrese su usuario" autocomplete="off">
                    </div>
                    <div class="mt-4">
                        <label class="form-label">Contraseña</label>
                        <input type="password" class="form-control" name="txtPass" placeholder="Ingrese su contraseña">
                    </div>

                    <div class="d-flex col mt-4 justify-content-center">
                        <button type="submit" class="btn btn-primary" name="validad" value="Aceptar">Iniciar Sesión</button>
                        
                    </div>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
