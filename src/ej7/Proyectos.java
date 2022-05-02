package ej7;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectionDB;

// creamos la clase "Proyectos" para customizar el m�todo que obtiene los registros de la tabla "proyectos"
public class Proyectos {

	// el m�todo que obtiene registros de la tabla "proyectos"
	public static void obtenerRegistros(String nombreDatabase, String query) {
		try {
			
			String queryUseDatabase = "USE " + nombreDatabase;
			Statement statementUseDatabase = ConnectionDB.crearConexion().createStatement();
			statementUseDatabase.executeUpdate(queryUseDatabase);
			ResultSet resultSet = statementUseDatabase.executeQuery(query);

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
