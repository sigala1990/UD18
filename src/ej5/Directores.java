package ej5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectionDB;

// creamos la clase "Directores" para customizar el m�todo que obtiene los registros de la tabla "directores"
public class Directores {

	// el m�todo que obtiene registros de la tabla "directores"
	public static void obtenerRegistros(String nombreDatabase, String query) {
		try {
		
			String queryUseDatabase = "USE " + nombreDatabase;
			Statement statementUseDatabase = ConnectionDB.crearConexion().createStatement();
			statementUseDatabase.executeUpdate(queryUseDatabase);
			ResultSet resultSet = statementUseDatabase.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("DNI: " + resultSet.getString("DNI") + " " 
						+ "Nombre y apellidos: "+ resultSet.getString("nombreApellidos") + " " 
						+ "DNI de jefe: "+ resultSet.getString("DNIJefe") + " " 
						+ "Despacho: " + resultSet.getString("despacho") + " ");
			}
			System.out.println("Los registros han sido obtenidos correctamente");

		} catch (SQLException ex) {
			System.out.println("Error al obtener los registros");
			System.out.println(ex.getMessage());
		}

	}

}
