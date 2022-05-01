package ej7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// creamos la clase "Proyectos" para customizar el método que obtiene los registros de la tabla "proyectos"
public class Proyectos {

	// credenciales
	private String ip = "192.168.8.113";
	private String user = "remote";
	private String password = "Reus_2022";

	// el método que crea la conexión a la base de datos
	public Connection crearConexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager
					.getConnection("jdbc:mysql://" + ip + ":3306?useTimezone=true&serverTimezone=UTC", user, password);

			System.out.println("Conexión ha sido exitosa");
			return conexion;

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Error al conectarse a la base de datos");
			System.out.println(ex);
			return null;
		}

	}

	// el método que obtiene registros de la tabla "proyectos"
	public void obtenerRegistros(String nombreDatabase, String query) {
		try {
			Connection conexion = crearConexion();
			String queryUseDatabase = "USE " + nombreDatabase;
			Statement statementUseDatabase = conexion.createStatement();
			statementUseDatabase.executeUpdate(queryUseDatabase);
			System.out.println("La base de datos " + nombreDatabase + " está en uso");

			String querySelectData = query;
			Statement statementSelectData = conexion.createStatement();
			ResultSet resultSet = statementSelectData.executeQuery(querySelectData);

			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getString("id") + " "
						+ "Nombre: " + resultSet.getString("nombre") + " " 
						+ "Horas: " + resultSet.getString("horas") + " ");
			}
			System.out.println("Los registros han sido obtenidos correctamente");

		} catch (SQLException ex) {
			System.out.println("Error al obtener los registros");
			System.out.println(ex.getMessage());
		}

	}

}
