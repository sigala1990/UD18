package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

	// credenciales
	private String ip = "192.168.8.113";
	private String user = "remote";
	private String password = "Reus_2022";

	// el m�todo que crea la conexi�n a la base de datos
	public Connection crearConexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager
					.getConnection("jdbc:mysql://" + ip + ":3306?useTimezone=true&serverTimezone=UTC", user, password);

			System.out.println("Conexi�n ha sido exitosa");
			return conexion;

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Error al conectarse a la base de datos");
			System.out.println(ex);
			return null;
		}

	}

	// el m�todo que crea la base de datos
	public void crearDatabase(String nombreDatabase) {
		try {
			Connection conexion = crearConexion();
			String queryCreateDatabase = "CREATE DATABASE " + nombreDatabase;
			Statement statementCreateDatabase = conexion.createStatement();
			statementCreateDatabase.executeUpdate(queryCreateDatabase);
			System.out.println("La base de datos " + nombreDatabase + " se ha creado correctamente");

		} catch (SQLException ex) {
			System.out.println("Error al crear la base de datos " + nombreDatabase);
			System.out.println(ex.getMessage());
		}

	}

	// el m�todo que crea la tabla 
	public void crearTabla(String nombreDatabase, String nombreTabla) {
		try {
			Connection conexion = crearConexion();
			String queryUseDatabase = "USE " + nombreDatabase;
			Statement statementUseDatabase = conexion.createStatement();
			statementUseDatabase.executeUpdate(queryUseDatabase);
			System.out.println("La base de datos " + nombreDatabase + " est� en uso");

			String queryCreateTable = nombreTabla;
			Statement statementCreateTable = conexion.createStatement();
			statementCreateTable.executeUpdate(queryCreateTable);
			System.out.println("Tabla " + nombreTabla + " creada exitosamente");

		} catch (SQLException ex) {
			System.out.println("Error al crear la tabla " + nombreTabla);
			System.out.println(ex.getMessage());

		}
	}

	// el m�todo que inserta registros a la base de datos
	public void insertarRegistros(String nombreDatabase, String query) {
		try {
			Connection conexion = crearConexion();
			String queryUseDatabase = "USE " + nombreDatabase;
			Statement statementUseDatabase = conexion.createStatement();
			statementUseDatabase.executeUpdate(queryUseDatabase);
			System.out.println("La base de datos " + nombreDatabase + " est� en uso");

			String queryInsertData = query;
			Statement statementInsertData = conexion.createStatement();
			statementInsertData.executeUpdate(queryInsertData);
			System.out.println("Los registros han sido insertados correctamente");

		} catch (SQLException ex) {
			System.out.println("Error al insertar los registros");
			System.out.println(ex.getMessage());
		}

	}
	
	// el m�todo que actualiza registros en la base de datos
		public void actualizarRegistros(String nombreDatabase, String query) {
			try {
				Connection conexion = crearConexion();
				String queryUseDatabase = "USE " + nombreDatabase;
				Statement statementUseDatabase = conexion.createStatement();
				statementUseDatabase.executeUpdate(queryUseDatabase);
				System.out.println("La base de datos " + nombreDatabase + " est� en uso");

				String queryUpdateData = query;
				Statement statementUpdateData = conexion.createStatement();
				statementUpdateData.executeUpdate(queryUpdateData);
				System.out.println("Los registros han sido actualizados correctamente");

			} catch (SQLException ex) {
				System.out.println("Error al actualizar los registros");
				System.out.println(ex.getMessage());
			}

		}

	// el m�todo que elimina registros
	public void eliminarRegistros(String nombreDatabase, String query) {
		try {
			Connection conexion = crearConexion();
			String queryUseDatabase = "USE " + nombreDatabase;
			Statement statementUseDatabase = conexion.createStatement();
			statementUseDatabase.executeUpdate(queryUseDatabase);
			System.out.println("La base de datos " + nombreDatabase + " est� en uso");

			String queryDeleteData = query;
			Statement statementInsertData = conexion.createStatement();
			statementInsertData.executeUpdate(queryDeleteData);
			System.out.println("Los registros han sido eliminados correctamente");

		} catch (SQLException ex) {
			System.out.println("Error al eliminar los registros");
			System.out.println(ex.getMessage());
		}

	}

}
