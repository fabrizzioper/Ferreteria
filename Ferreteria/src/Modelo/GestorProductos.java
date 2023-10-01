/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author fabri
 */
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class GestorProductos {

    //private static final String URL = "jdbc:sqlserver://localhost\\DESKTOP3IQNDMC\\SQLEXPRESS:1433;databaseName=FerreteriaDB;user=sa;password=root;encrypt=true;trustServerCertificate=true";
    //private static final String URLMYSQL = "jdbc:mysql://localhost:3306/ferreteriadb?serverTimezone=UTC&user=root&password=root";
    private static final String URLMYSQLCLOUD = "jdbc:mysql://b5x93bie3lb14tmgnstn-mysql.services.clever-cloud.com:3306/b5x93bie3lb14tmgnstn?serverTimezone=UTC&user=ud0btdzocqaqw9jc&password=EspxIszKOedcrAT88x7G";

    public static void insertarProducto(Productos producto) {
        try (Connection conexion = DriverManager.getConnection(URLMYSQLCLOUD)) {
            String consultaSQL = "INSERT INTO Productos (nombre, descripcion, cantidad, precio) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL)) {
                preparedStatement.setString(1, producto.getNombre());
                preparedStatement.setString(2, producto.getDescripcion());
                preparedStatement.setInt(3, producto.getCantidad());
                preparedStatement.setDouble(4, producto.getPrecio());
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Producto insertado exitosamente.");
                    // Mostrar un mensaje de diálogo para indicar que la inserción fue exitosa
                    JOptionPane.showMessageDialog(null, "Producto insertado exitosamente.");
                } else {
                    System.out.println("No se pudo insertar el producto.");
                    JOptionPane.showMessageDialog(null, "No se pudo insertar el producto.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar el producto: " + e.getMessage());
        }
    }

    public static void eliminarProducto(int ID) {
        try (Connection conexion = DriverManager.getConnection(URLMYSQLCLOUD)) {
            String consultaSQL = "DELETE FROM Productos WHERE ID = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL)) {
                preparedStatement.setInt(1, ID);
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Producto eliminado exitosamente.");
                    // Mostrar un mensaje de diálogo para indicar que la eliminación fue exitosa
                    JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");
                } else {
                    System.out.println("No se pudo eliminar el producto.");
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el producto: " + e.getMessage());
        }
    }

    public static void modificarProducto(int ID, String nuevoNombre, String nuevaDescripcion, int nuevaCantidad, double nuevoPrecio) {
        try (Connection conexion = DriverManager.getConnection(URLMYSQLCLOUD)) {
            String consultaSQL = "UPDATE Productos SET Nombre = ?, Descripcion = ?, Cantidad = ?, Precio = ? WHERE ID = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL)) {
                preparedStatement.setString(1, nuevoNombre);
                preparedStatement.setString(2, nuevaDescripcion);
                preparedStatement.setInt(3, nuevaCantidad);
                preparedStatement.setDouble(4, nuevoPrecio);
                preparedStatement.setInt(5, ID);

                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Producto modificado exitosamente.");
                    // Mostrar un mensaje de diálogo para indicar que la modificación fue exitosa
                    JOptionPane.showMessageDialog(null, "Producto modificado exitosamente.");
                } else {
                    System.out.println("No se pudo modificar el producto.");
                    JOptionPane.showMessageDialog(null, "No se pudo modificar el producto.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar el producto: " + e.getMessage());
        }
    }

    public static List<Productos> obtenerTodosLosProductos() {
        List<Productos> productos = new ArrayList<>();

        try (Connection conexion = DriverManager.getConnection(URLMYSQLCLOUD)) {
            String consultaSQL = "SELECT * FROM Productos";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL); ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int ID = resultSet.getInt("ID");
                    String nombre = resultSet.getString("Nombre");
                    String descripcion = resultSet.getString("Descripcion");
                    int cantidad = resultSet.getInt("Cantidad");
                    double precio = resultSet.getDouble("Precio");

                    Productos producto = new Productos(nombre, descripcion, cantidad, precio);
                    producto.setID(ID);

                    productos.add(producto);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener productos: " + e.getMessage());
        }

        return productos;
    }

    public static List<Productos> buscarProductosPorCodigo(int codigo) {
        List<Productos> productosEncontrados = new ArrayList<>();

        try (Connection conexion = DriverManager.getConnection(URLMYSQLCLOUD)) {
            String consultaSQL = "SELECT * FROM Productos WHERE ID = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL)) {
                preparedStatement.setInt(1, codigo);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int ID = resultSet.getInt("ID");
                        String nombre = resultSet.getString("Nombre");
                        String descripcion = resultSet.getString("Descripcion");
                        int cantidad = resultSet.getInt("Cantidad");
                        double precio = resultSet.getDouble("Precio");

                        Productos productoEncontrado = new Productos(nombre, descripcion, cantidad, precio);
                        productoEncontrado.setID(ID);
                        productosEncontrados.add(productoEncontrado);
                    }

                    if (productosEncontrados.isEmpty()) {
                        System.out.println("No se encontró ningún producto con el código " + codigo);
                        JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el código " + codigo, "Producto no encontrado", JOptionPane.WARNING_MESSAGE);
                    } else {
                        System.out.println("Productos encontrado.");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar los productos por código: " + e.getMessage());
        }

        return productosEncontrados;
    }

    
    public static List<Productos> buscarProductoPorNombre(String nombre) {
        List<Productos> productosEncontrados = new ArrayList<>();

        try (Connection conexion = DriverManager.getConnection(URLMYSQLCLOUD)) {
            String consultaSQL = "SELECT * FROM Productos WHERE Nombre LIKE ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL)) {
                preparedStatement.setString(1, "%" + nombre + "%");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int ID = resultSet.getInt("ID");
                        String nombreProducto = resultSet.getString("Nombre");
                        String descripcion = resultSet.getString("Descripcion");
                        int cantidad = resultSet.getInt("Cantidad");
                        double precio = resultSet.getDouble("Precio");

                        Productos producto = new Productos(nombreProducto, descripcion, cantidad, precio);
                        producto.setID(ID);

                        productosEncontrados.add(producto);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar productos por nombre: " + e.getMessage());
        }

        return productosEncontrados;
    }

    private static NodoProducto obtenerNodoProducto(ResultSet resultSet) throws SQLException {
        int ID = resultSet.getInt("ID");
        String nombre = resultSet.getString("Nombre");
        String descripcion = resultSet.getString("Descripcion");
        int cantidad = resultSet.getInt("Cantidad");
        double precio = resultSet.getDouble("Precio");

        Productos producto = new Productos(nombre, descripcion, cantidad, precio);
        producto.setID(ID);

        return new NodoProducto(producto);
    }

    // Método para cargar la información de la base de datos en nodos (árbol binario)
    public static NodoProducto cargarProductosEnArbol() {
        NodoProducto raiz = null;

        try (Connection conexion = DriverManager.getConnection(URLMYSQLCLOUD)) {
            String consultaSQL = "SELECT * FROM Productos";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL); ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    NodoProducto nodoProducto = obtenerNodoProducto(resultSet);
                    raiz = insertarEnArbol(raiz, nodoProducto);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar productos en el árbol: " + e.getMessage());
        }

        return raiz;
    }

    // Método para insertar un nodo en el árbol binario
    private static NodoProducto insertarEnArbol(NodoProducto raiz, NodoProducto nodo) {
        if (raiz == null) {
            return nodo;
        }

        if (nodo.getProducto().getID() < raiz.getProducto().getID()) {
            raiz.setIzquierdo(insertarEnArbol(raiz.getIzquierdo(), nodo));
        } else if (nodo.getProducto().getID() > raiz.getProducto().getID()) {
            raiz.setDerecho(insertarEnArbol(raiz.getDerecho(), nodo));
        }

        return raiz;
    }

    public static List<Productos> ordenarProductosPorPrecioAscendente() {
        List<Productos> productosOrdenados = obtenerTodosLosProductos();

        // Ordenar la lista de productos por precio de menor a mayor
        Collections.sort(productosOrdenados, Comparator.comparingDouble(Productos::getPrecio));

        return productosOrdenados;
    }

    public static List<Productos> ordenarProductosPorPrecioDescendente() {
        List<Productos> productosOrdenados = obtenerTodosLosProductos();

        // Ordenar la lista de productos por precio de mayor a menor
        Collections.sort(productosOrdenados, (p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio()));

        return productosOrdenados;
    }

}
