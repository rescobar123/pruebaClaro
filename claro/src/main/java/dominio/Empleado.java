package dominio;

/**
 *
 * @author rescobar
 */
public class Empleado {
    private int idEmpleado;
    private String empleadoNombre;
    private String empleadoDirecion;
    private String empleadoRol;
    private String empleadoEmail;
    private String empleadoPassword;

    public Empleado(String empleadoNombre, String empleadoRol) {
        this.empleadoNombre = empleadoNombre;
        this.empleadoRol = empleadoRol;
    }

    public Empleado(String empleadoRol, String empleadoEmail, String empleadoPassword) {
        this.empleadoRol = empleadoRol;
        this.empleadoEmail = empleadoEmail;
        this.empleadoPassword = empleadoPassword;
    }
    
    public Empleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    
    public Empleado(String empleadoNombre, String empleadoDirecion, String empleadoRol, String empleadoEmail, String empleadoPassword) {
        this.empleadoNombre = empleadoNombre;
        this.empleadoDirecion = empleadoDirecion;
        this.empleadoRol = empleadoRol;
        this.empleadoEmail = empleadoEmail;
        this.empleadoPassword = empleadoPassword;
    }

    
    public Empleado(int idEmpleado, String empleadoNombre, String empleadoDirecion, String empleadoRol, String empleadoEmail, String empleadoPassword) {
        this.idEmpleado = idEmpleado;
        this.empleadoNombre = empleadoNombre;
        this.empleadoDirecion = empleadoDirecion;
        this.empleadoRol = empleadoRol;
        this.empleadoEmail = empleadoEmail;
        this.empleadoPassword = empleadoPassword;
    }



    public String getEmpleadoNombre() {
        return empleadoNombre;
    }

    public void setEmpleadoNombre(String empleadoNombre) {
        this.empleadoNombre = empleadoNombre;
    }

    public String getEmpleadoDirecion() {
        return empleadoDirecion;
    }

    public void setEmpleadoDirecion(String empleadoDirecion) {
        this.empleadoDirecion = empleadoDirecion;
    }

    public String getEmpleadoRol() {
        return empleadoRol;
    }

    public void setEmpleadoRol(String empleadoRol) {
        this.empleadoRol = empleadoRol;
    }

    public String getEmpleadoEmail() {
        return empleadoEmail;
    }

    public void setEmpleadoEmail(String empleadoEmail) {
        this.empleadoEmail = empleadoEmail;
    }

    public String getEmpleadoPassword() {
        return empleadoPassword;
    }

    public void setEmpleadoPassword(String empleadoPassword) {
        this.empleadoPassword = empleadoPassword;
    }

    
}
