package ej7;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectionDB;

// creamos la clase "Cientificos" para customizar el método que obtiene los registros de la tabla "cientificos"
public class Cientificos {

	// el método que obtiene registros de la tabla "cientificos"
	public static void obtenerRegistros(String nombreDatabase, String query) {
		try {
			
			String queryUseDatabase = "USE " + nombreDatabase;
			Statement statementUseDatabase = ConnectionDB.crearConexion().createStatement();
			statementUseDatabase.executeUpdate(queryUseDatabase);
			ResultSet resultSet = statementUseDatabase.executeQuery(query);

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
