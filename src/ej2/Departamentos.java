package ej2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectionDB;

// creamos la clase "Departamentos" para customizar el método que obtiene los registros de la tabla "departamentos"
public class Departamentos {

	// el método que obtiene registros de la base de datos
	public static void obtenerRegistros(String nombreDatabase, String query) {
		try {
			
			String queryUseDatabase = "USE " + nombreDatabase;
			Statement statementUseDatabase = ConnectionDB.crearConexion().createStatement();
			statementUseDatabase.executeUpdate(queryUseDatabase);
			ResultSet resultSet = statementUseDatabase.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("codigo") + " "
						+ "Nombre: " + resultSet.getString("nombre") + " "
						+ "Presupuesto: " + resultSet.getString("presupuesto") + " ");
			}
			System.out.println("Los registros han sido obtenidos correctamente");

		} catch (SQLException ex) {
			System.out.println("Error al obtener los registros");
			System.out.println(ex.getMessage());
		}

	}

}
