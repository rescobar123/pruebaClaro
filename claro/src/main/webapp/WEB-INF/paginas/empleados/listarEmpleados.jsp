<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="es_GT"/>
<jsp:include page="/WEB-INF/comunes/alertas.jsp"/>
<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <table class="table table-hover ">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Dirección</th>
                                <th>Rol</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista de empleados -->
                            <c:forEach var="empleado" items="${empleados}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${empleado.empleadoNombre}</td>
                                    <td>${empleado.empleadoDirecion}</td>
                                    <td>${empleado.empleadoRol}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>





