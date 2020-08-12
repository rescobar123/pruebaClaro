package datos;

import dominio.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rescobar
 */
public class EmpleadoDaoJDBC {
    //CRUD (Create, Read(leer), Update, Delete)

    private static final String SQL_SELECT = "SELECT IdEmpleado, EmpleadoNombre, EmpleadoDireccion, "
            + "EmpleadoRol, EmpleadoEmail, EmpleadoPassword"
            + " FROM Empleado";
    private static final String SQL_SELECT_BY_ID = "SELECT IdEmpleado, EmpleadoNombre, EmpleadoDireccion, "
            + "EmpleadoRol, EmpleadoEmail, EmpleadoPassword"
            + " FROM Empleado WHERE IdEmpleado = ?";
    private static final String SQL_INSERT = "INSERT INTO Empleado(EmpleadoNombre, EmpleadoDireccion, "
            + "EmpleadoRol, EmpleadoEmail, EmpleadoPassword)"
            + " VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Empleado "
            + "SET EmpleadoNombre= ?, EmpleadoDireccion=? WHERE IdEmpleado = ?";
    private static final String SQL_DELETE = "DELETE FROM Empleado "
            + "WHERE IdEmpleado = ?";
    private static final String SQL_SELECT_BY_EMAIL_PASS = "SELECT  EmpleadoNombre, EmpleadoRol"
            + " FROM Empleado WHERE EmpleadoEmail = ? AND EmpleadoPassword = ?";
    public List<Empleado> listar() {

        Connection conn = null;//Variable para guardar la conexion
        PreparedStatement stmt = null;//Variable para guadar la consulta
        ResultSet rs = null;//Variable para gudar el resultado

        List<Empleado> empleados = new ArrayList<>();//Creamos una lista de tipo empleado e iniciamos la lista
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmpleado = rs.getInt("IdEmpleado");
                String empleadoNombre = rs.getString("EmpleadoNombre");
                String empleadoDireccion = rs.getString("EmpleadoDireccion");
                String empleadoRol = rs.getString("EmpleadoRol");
                String empleadoEmail = rs.getString("EmpleadoEmail");
                String empleadoPassword = rs.getString("EmpleadoPassword");

                Empleado empleado = new Empleado(idEmpleado, empleadoNombre, empleadoDireccion,
                        empleadoRol, empleadoEmail, empleadoPassword);
                empleados.add(empleado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return empleados;
    }

    public Empleado login(Empleado empleado) {

        Connection conn = null;//Variable para guardar la conexion
        PreparedStatement stmt = null;//Variable para guadar la consulta
        ResultSet rs = null;//Variable para gudar el resultado
        Empleado empleado2 = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_EMAIL_PASS);
            stmt.setString(1, empleado.getEmpleadoEmail());
            stmt.setString(2, empleado.getEmpleadoPassword());
            rs = stmt.executeQuery();
            rs.absolute(1);//Obtener el registro 1 de la consulta
            String empleadoNombre = rs.getString("EmpleadoNombre");
            String empleadoRol = rs.getString("EmpleadoRol");

            empleado2 = new Empleado(empleadoNombre, empleadoRol);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return empleado2;
    }

    //insert
    public int insertar(Empleado empleado) {
        int rows = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            //Le mandamos los parametros a insertar
            stmt.setString(1, empleado.getEmpleadoNombre());
            stmt.setString(2, empleado.getEmpleadoDirecion());
            stmt.setString(3, empleado.getEmpleadoRol());
            stmt.setString(4, empleado.getEmpleadoEmail());
            stmt.setString(5, empleado.getEmpleadoPassword());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

}
