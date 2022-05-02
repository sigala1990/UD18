package ej7;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectionDB;

// creamos la clase "Asignado_a" para customizar el método que obtiene los registros de la tabla "asignado_a"
public class Asignado_a {

	// el método que obtiene registros de la tabla "asignado_a"
	public static void obtenerRegistros(String nombreDatabase, String query) {
		try {
			
			String queryUseDatabase = "USE " + nombreDatabase;
			Statement statementUseDatabase = ConnectionDB.crearConexion().createStatement();
			statementUseDatabase.executeUpdate(queryUseDatabase);
			ResultSet resultSet = statementUseDatabase.executeQuery(query);
			
			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getString("id") + " " 
						+ "ID de proyecto: " + resultSet.getString("idProyecto") + " " 
						+ "DNI de cientifico: " + resultSet.getString("DNICientifico") + " ");
			}
			System.out.println("Los registros han sido obtenidos correctamente");

		} catch (SQLException ex) {
			System.out.println("Error al obtener los registros");
			System.out.println(ex.getMessage());
		}

	}

}
