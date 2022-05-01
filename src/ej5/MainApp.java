package ej5;

import utils.ConnectionDB;

public class MainApp {

	public static void main(String[] args) {
		
		// invocamos el método que establece la conexión
		ConnectionDB.crearConexion();
		
		// invocamos el método que crea la base de datos
		ConnectionDB.crearDatabase("ud18_ej5");
		
		// invocamos el método que crea la tabla "despachos"
		ConnectionDB.crearTabla
			("ud18_ej5", 
				"CREATE TABLE despachos "
				+ "(numero INT PRIMARY KEY,"
				+ " capacidad INT)");
			
		// invocamos el método que crea la tabla "directores"
		ConnectionDB.crearTabla
			("ud18_ej5", 
				"CREATE TABLE directores "
				+ "(DNI VARCHAR(8) PRIMARY KEY,"
				+ " nombreApellidos VARCHAR(255),"
				+ " DNIJefe VARCHAR(8),"
				+ " despacho INT,"
				+ " FOREIGN KEY (DNIJefe) REFERENCES directores (DNI)"
				+ " ON DELETE CASCADE ON UPDATE CASCADE,"
				+ " FOREIGN KEY (despacho) REFERENCES despachos (numero)"
				+ " ON DELETE CASCADE ON UPDATE CASCADE)");

		// invocamos el método que inserta los registros a "despachos"
		ConnectionDB.executarConsultas
			("ud18_ej5", 
				"INSERT INTO despachos VALUES "
				+ " (1, 5),"
				+ " (2, 5),"
				+ " (3, 5),"
				+ " (4, 5),"
				+ " (5, 5)");
		
		// invocamos el método que inserta los registros a "directores"
		ConnectionDB.executarConsultas
			("ud18_ej5", 
				"INSERT INTO directores VALUES "
				+ "('A1234567', 'Veronika Polonchak', 'A1234567', 1),"
				+ " ('B1234567', 'Isidre Planas', 'A1234567', 2), "
				+ "('C1234567', 'Adria Queralt', 'A1234567', 3),"
				+ "('D1234567', 'Joan Hurtado', 'A1234567', 4),"
				+ " ('E1234567', 'Octavio Bernal', 'A1234567', 5)");
		
		// invocamos el método que actualiza los registros en "despachos"
		ConnectionDB.executarConsultas
			("ud18_ej5",
				"UPDATE despachos SET capacidad = '10' WHERE numero = 5");
				
		// invocamos el método que actualiza los registros en "directores"
		ConnectionDB.executarConsultas
			("ud18_ej5",
				"UPDATE directores SET DNIJefe = 'D1234567'");
		
		// invocamos el método que obtiene los registros de "despachos"
		Despachos.obtenerRegistros("ud18_ej5", "SELECT * FROM despachos");
		
		// invocamos el método que obtiene los registros de "directores"
		Directores.obtenerRegistros("ud18_ej5", "SELECT * FROM directores");
		
		// invocamos el método que elimina los registros de "directores"
		ConnectionDB.executarConsultas("ud18_ej5", "DELETE FROM directores"); 
		
		// invocamos el método que elimina los registros de "despachos"
		ConnectionDB.executarConsultas("ud18_ej5", "DELETE FROM despachos");
		
		// invocamos el método que cierra la conexión
		ConnectionDB.cerrarConexion();

	}

}
