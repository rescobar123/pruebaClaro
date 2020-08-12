<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Agregar Empleado</h4>
                    </div>
                    <form action="${pageContext.request.contextPath}/ServletControlador?accion=agregarEmpleado"
                          method="POST" class="was-validated">

                        <div class="modal-body">
                            <div class="form-group">
                                <label for="nombre">Nombre Completo</label>
                                <input type="text" class="form-control" name="nombre" required>
                            </div>
                            <div class="form-group">
                                <label for="apellido">Dirección</label>
                                <input type="text" class="form-control" name="direccion" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" maxlength="50" class="form-control" name="email" required>
                            </div>
                            <div class="form-group">
                                <label for="Password">Contraseña</label>
                                <input type="password" maxlength="15" class="form-control" name="pass" required>
                            </div>
                            <div class="form-group">
                                <label for="telefono">Grupo</label>
                                <select class="form-control" name="rol" required>
                                    <option selected disabled >Selecciona un Rol</option>
                                    <option value="Administrador">Administrador</option>
                                    <option value="Tecnico">Tecnico</option>
                                    <option value="Supervisor">Supervisor</option>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" type="submit">Guardar</button>
                        </div>    
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
