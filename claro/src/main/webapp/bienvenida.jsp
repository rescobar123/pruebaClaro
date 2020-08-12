<jsp:include page="WEB-INF/comunes/cabecero.jsp"/>

<jsp:include page="WEB-INF/comunes/menu.jsp"/>
<jsp:include page="WEB-INF/comunes/alertas.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-9">
            <div class="card">
                <h1>${empleado.empleadoNombre} <br><b>${empleado.empleadoRol}</b> </h1>
            </div>
        </div>

    </div>
</div>

<jsp:include page="WEB-INF/comunes/piePagina.jsp"/>
