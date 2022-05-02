package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

	// credenciales
	private static String ip = "192.168.8.113";
	private static String user = "remote";
	private static String password = "Reus_2022";
	private static Connection conexion = null;
	private static Statement statement = null;

	// el método que crea la conexión a la base de datos
	public static Connection crearConexion() {

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager
					.getConnection("jdbc:mysql://" + ip + ":3306?useTimezone=true&serverTimezone=UTC", user, password);

			System.out.println("Conexión ha sido exitosa");
			statement = conexion.createStatement();
			return conexion;

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Error al conectarse a la base de datos");
			System.out.println(ex.getMessage());
			return null;
		}
	
	}
	
	// el método que crea la base de datos
	public static void crearDatabase(String nombreDatabase) {
		try {
			String queryCreateDatabase = "CREATE DATABASE " + nombreDatabase;
		
			statement.executeUpdate(queryCreateDatabase);
			System.out.println("La base de datos " + nombreDatabase + " se ha creado correctamente");

			
		} catch (SQLException ex) {
			System.out.println("Error al crear la base de datos " + nombreDatabase);
			System.out.println(ex.getMessage());
		
		}

	}

	// el método que crea la tabla 
	public static void crearTabla(String nombreDatabase, String nombreTabla) {
		try {
			
			
			String queryUseDatabase = "USE " + nombreDatabase + ";";
			statement.executeUpdate(queryUseDatabase);
			statement.executeUpdate(nombreTabla);
		
			System.out.println("Tabla " + nombreTabla + " creada exitosamente");

	
		} catch (SQLException ex) {
			System.out.println("Error al crear la tabla " + nombreTabla);
			System.out.println(ex.getMessage());
		
		}
	}

	// el método que inserta registros a la base de datos
	public static void executarConsultas(String nombreDatabase, String query) {
		try {
			String queryUseDatabase = "USE " + nombreDatabase;
			statement.executeUpdate(queryUseDatabase);
			statement.executeUpdate(query);
			
			System.out.println("Los registros han sido insertados/actualizados/eliminados correctamente");

		} catch (SQLException ex) {
			System.out.println("Error al insertar los registros");
			System.out.println(ex.getMessage());
		}

	}
		
	public static void cerrarConexion() {
		try {
		conexion.close();
		
		} catch (SQLException ex) {
			System.out.println("Error al cerrar la conexión");
			System.out.println(ex.getMessage());
		}
	}

}
