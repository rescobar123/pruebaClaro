<div class="container">
    <div class="row justify-content-center">
        <div class="col-xl-10 col-lg-12 col-md-9">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-login-image">
                            <img width="500" src="https://gratisography.com/wp-content/uploads/2020/06/gratisography-ominous-landscape-800x525.jpg">
                        </div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Bienvenido!</h1>
                                </div>
                               <form action="${pageContext.request.contextPath}/ServletControlador?accion=login"
                                method="POST">
                                    <p class="text-center text-muted"><i class="zmdi zmdi-account-circle zmdi-hc-5x"></i></p>
                                    <p class="text-center text-muted text-uppercase">Inicia sesión con tu cuenta</p>
                                    <div class="form-group label-floating">
                                        <input id="UserName"  name="usuario" type="text" class="form-control form-control-user"   placeholder="Enter username...">
                                    </div>
                                    <div class="form-group label-floating">
                                        <input  class="form-control form-control-user" id="UserPass" name="clave" type="password" placeholder="Password" >
                                    </div>
                                    <div class="form-group text-center">
                                        <input class="btn btn-primary btn-user btn-block" type="submit" value="Iniciar sesión" class="btn btn-info" style="color: #FFF;">
                                    </div>
                                </form>
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>
