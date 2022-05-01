package ej7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// creamos la clase "Cientificos" para customizar el m�todo que obtiene los registros de la tabla "cientificos"
public class Cientificos {

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

	// el m�todo que obtiene registros de la tabla "cientificos"
	public void obtenerRegistros(String nombreDatabase, String query) {
		try {
			Connection conexion = crearConexion();
			String queryUseDatabase = "USE " + nombreDatabase;
			Statement statementUseDatabase = conexion.createStatement();
			statementUseDatabase.executeUpdate(queryUseDatabase);
			System.out.println("La base de datos " + nombreDatabase + " est� en uso");

			String querySelectData = query;
			Statement statementSelectData = conexion.createStatement();
			ResultSet resultSet = statementSelectData.executeQuery(querySelectData);

			while (resultSet.next()) {
				System.out.println("DNI: " + resultSet.getString("DNI") + " " 
						+ "Nombre y apellidos: " + resultSet.getString("nombreApellidos") + " ");
			}
			System.out.println("Los registros han sido obtenidos correctamente");

		} catch (SQLException ex) {
			System.out.println("Error al obtener los registros");
			System.out.println(ex.getMessage());
		}

	}

}
