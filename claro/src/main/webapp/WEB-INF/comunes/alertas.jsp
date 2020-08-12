<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${respuesta == 2}">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong> ${mensajeRespuesta}</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
<c:if test="${respuesta == 3}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>${mensajeRespuesta}</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
