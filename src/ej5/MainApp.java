package ej5;

import utils.ConnectionDB;

public class MainApp {

	public static void main(String[] args) {
		
		// instanciamos la clase que contiene el método de conexión a BD y los métodos CRUD
		ConnectionDB miConexion = new ConnectionDB();

		// invocamos el método que crea la base de datos
		miConexion.crearDatabase("ud18_ej5");
		
		// invocamos el método que crea la tabla "despachos"
		miConexion.crearTabla
			("ud18_ej5", 
				"CREATE TABLE despachos "
				+ "(numero INT PRIMARY KEY,"
				+ " capacidad INT)");
			
		// invocamos el método que crea la tabla "directores"
		miConexion.crearTabla
			("ud18_ej5", 
				"CREATE TABLE directores "
				+ "(DNI VARCHAR(8) PRIMARY KEY,"
				+ " nombreApellidos VARCHAR(255),"
				+ " DNIJefe VARCHAR(8),"
				+ " despacho INT,"
				+ " FOREIGN KEY (DNIJefe) REFERENCES directores (DNI) "
				+ " ON DELETE CASCADE ON UPDATE CASCADE,"
				+ " FOREIGN KEY (despacho) REFERENCES despachos (numero)"
				+ " ON DELETE CASCADE ON UPDATE CASCADE)");

		// invocamos el método que inserta los registros a "despachos"
		miConexion.insertarRegistros
			("ud18_ej5", 
				"INSERT INTO despachos VALUES "
				+ " (1, 5),"
				+ " (2, 5),"
				+ " (3, 5),"
				+ " (4, 5),"
				+ " (5, 5)");
		
		// invocamos el método que inserta los registros a "directores"
		miConexion.insertarRegistros
			("ud18_ej5", 
				"INSERT INTO directores VALUES "
				+ "('A1234567', 'Veronika Polonchak', 'A1234567', 1),"
				+ " ('B1234567', 'Isidre Planas', 'A1234567', 2), "
				+ "('C1234567', 'Adria Queralt', 'A1234567', 3),"
				+ "('D1234567', 'Joan Hurtado', 'A1234567', 4),"
				+ " ('E1234567', 'Octavio Bernal', 'A1234567', 5)");
		
		// invocamos el método que actualiza los registros en "despachos"
		miConexion.actualizarRegistros
			("ud18_ej5",
				"UPDATE despachos SET capacidad = '10' WHERE numero = 5");
				
		// invocamos el método que actualiza los registros en "directores"
		miConexion.actualizarRegistros
			("ud18_ej5",
				"UPDATE directores SET DNIJefe = 'D1234567'");
		
		// invocamos el método que obtiene los registros de "despachos"
		Despachos despachos = new Despachos();
		despachos.obtenerRegistros("ud18_ej5", "SELECT * FROM despachos");
		
		// invocamos el método que obtiene los registros de "directores"
		Directores directores = new Directores();
		directores.obtenerRegistros("ud18_ej5", "SELECT * FROM directores");
		
		// invocamos el método que elimina los registros de "directores"
		miConexion.eliminarRegistros("ud18_ej5", "DELETE FROM directores"); 
		
		// invocamos el método que elimina los registros de "despachos"
		miConexion.eliminarRegistros("ud18_ej5", "DELETE FROM despachos");

	}

}
