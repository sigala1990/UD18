package ej2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectionDB;

// creamos la clase "Empleados" para customizar el método que obtiene los registros de la tabla "empleados"
public class Empleados {


	// el método que obtiene registros de la tabla "empleados"
	public static void obtenerRegistros(String nombreDatabase, String query) {
		try {
			
			String queryUseDatabase = "USE " + nombreDatabase;
			Statement statementUseDatabase = ConnectionDB.crearConexion().createStatement();
			statementUseDatabase.executeUpdate(queryUseDatabase);
			System.out.println("La base de datos " + nombreDatabase + " está en uso");

			//String querySelectData = query;
			//Statement statementSelectData = ConnectionDB.crearConexion().createStatement();
			ResultSet resultSet = statementUseDatabase.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("DNI: " + resultSet.getString("DNI") + " " 
						+ "Nombre: "+ resultSet.getString("nombre") + " "
						+ "Apellidos: " + resultSet.getString("apellidos") + " "
						+ "Departamento: " + resultSet.getString("departamento") + " ");
			}
			System.out.println("Los registros han sido obtenidos correctamente");

		} catch (SQLException ex) {
			System.out.println("Error al obtener los registros");
			System.out.println(ex.getMessage());
		}

	}

}
