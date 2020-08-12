package web;

import datos.EmpleadoDaoJDBC;
import dominio.Empleado;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "inicio":
                    break;
                case "listarEmpleados":
                    this.listarEmpleado(request, response, 1);//1 = Para cuando se liste
                    break;
                case "addEmpleado":
                    this.agregarEmpleado(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
                    break;
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "agregarEmpleado":
                    this.insertarEmpleado(request, response);
                    break;
                case "login":
                    this.login(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        
        //Creamos el agente
        Empleado empleado = new Empleado("",usuario,clave);  
        Empleado empleadoLogin = new EmpleadoDaoJDBC().login(empleado);
        if (empleadoLogin != null) {
            String mensajeRespuesta = "Bienvenido " + empleadoLogin.getEmpleadoNombre();
            sesion.setAttribute("empleado", empleadoLogin);
            String jspListarAgentes = "bienvenida.jsp";
            sesion.setAttribute("respuesta", 2);
            sesion.setAttribute("mensajeRespuesta", mensajeRespuesta);
            request.getRequestDispatcher(jspListarAgentes).forward(request, response);
        } else {
            
           this.accionDefault(request, response);//No se realizo la inserción
        }
    }



    private void insertarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String rol = request.getParameter("rol");

        //Creamos el agente
        Empleado empleado = new Empleado(nombre, direccion, rol, email, pass);
        int registrosAlterados = new EmpleadoDaoJDBC().insertar(empleado);
        System.out.println("registrosAlterados = " + registrosAlterados);
        if (registrosAlterados == 1) {
            String mensajeRespuesta = "El empleado " + nombre + " Fue creado con éxito!";
            sesion.setAttribute("mensajeRespuesta", mensajeRespuesta);
            this.listarEmpleado(request, response, 2);//2 Inserción con exito

        } else {
            String mensajeRespuesta = "No se creo el empleado, Revise los Datos";
            sesion.setAttribute("mensajeRespuesta", mensajeRespuesta);
           this.listarEmpleado(request, response, 3);//No se realizo la inserción
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("index.jsp");
    }
    private void agregarEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("addEmpleado.jsp");
    }

    private void listarEmpleado(HttpServletRequest request, HttpServletResponse response, int accion) throws ServletException, IOException {
        List<Empleado> empleados = new EmpleadoDaoJDBC().listar();
        System.out.println("empleado = " + empleados);
        HttpSession sesion = request.getSession();//Obtener la sesion
        sesion.setAttribute("empleados", empleados);
        sesion.setAttribute("totalEmpleados", empleados.size());
        String jspListarAgentes = "empleados.jsp";
        switch (accion) {
            case 1:
                sesion.setAttribute("respuesta", 1);
                request.getRequestDispatcher(jspListarAgentes).forward(request, response);
                break;
            case 2:
                sesion.setAttribute("respuesta", 2);
                response.sendRedirect(jspListarAgentes);
                break;
            case 3:
                sesion.setAttribute("respuesta", 3);
                request.getRequestDispatcher(jspListarAgentes).forward(request, response);
                break;
            default:
                sesion.setAttribute("respuesta", 1);
                request.getRequestDispatcher(jspListarAgentes).forward(request, response);
                break;

        }

    }
}
