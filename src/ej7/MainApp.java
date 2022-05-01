package ej7;

import utils.ConnectionDB;

public class MainApp {

	public static void main(String[] args) {
		
		// instanciamos la clase que contiene el método de conexión a BD y los métodos CRUD
		ConnectionDB miConexion = new ConnectionDB();

		// invocamos el método que crea la base de datos
		miConexion.crearDatabase("ud18_ej7");
		
		// invocamos el método que crea la tabla "proyectos"
		miConexion.crearTabla
			("ud18_ej7", 
				"CREATE TABLE proyectos "
				+ "(id CHAR(4) PRIMARY KEY,"
				+ "nombre VARCHAR(255),"
				+ " horas INT)");
		
		// invocamos el método que crea la tabla "cientificos"
		miConexion.crearTabla
			("ud18_ej7", 
				"CREATE TABLE cientificos "
				+ "(DNI VARCHAR(8) PRIMARY KEY,"
				+ " nombreApellidos VARCHAR(255))");
				
		// invocamos el método que crea la tabla "asignado_a"
		miConexion.crearTabla
			("ud18_ej7", 
				"CREATE TABLE asignado_a "
				+ "(id INT PRIMARY KEY,"
				+ " idProyecto CHAR(4),"
				+ " DNICientifico VARCHAR(8),"
				+ " FOREIGN KEY (idProyecto) REFERENCES proyectos (id) "
				+ " ON DELETE CASCADE ON UPDATE CASCADE,"
				+ " FOREIGN KEY (DNICientifico) REFERENCES cientificos (DNI) "
				+ " ON DELETE CASCADE ON UPDATE CASCADE)");

		// invocamos el método que inserta los registros a "proyectos"
		miConexion.insertarRegistros
			("ud18_ej7", 
				"INSERT INTO proyectos VALUES "
				+ " ('A123', 'Prometheus', 100),"
				+ " ('B123', 'Salamandra', 200),"
				+ " ('C123', 'Solaris', 300),"
				+ " ('D123', 'Interstaller', 400),"
				+ " ('E123', 'Nexus', 500)");
		
		// invocamos el método que inserta los registros a "cientificos"
		miConexion.insertarRegistros
			("ud18_ej7", 
				"INSERT INTO cientificos VALUES "
				+ " ('A1234567', 'Veronika Polonchak'),"
				+ " ('B1234567', 'Isidre Planas'), "
				+ " ('C1234567', 'Adria Queralt'),"
				+ " ('D1234567', 'Joan Hurtado'),"
				+ " ('E1234567', 'Octavio Bernal')");
		
		// invocamos el método que inserta los registros a "asignado_a"
		miConexion.insertarRegistros
			("ud18_ej7", 
				"INSERT INTO asignado_a  VALUES "
				+ " (1, 'A123', 'A1234567'),"
				+ " (2, 'B123', 'B1234567'),"
				+ " (3, 'C123', 'C1234567'),"
				+ " (4, 'D123', 'D1234567'),"
				+ " (5, 'E123', 'E1234567')");
		
		// invocamos el método que actualiza los registros en "proyectos"
		miConexion.actualizarRegistros
			("ud18_ej7",
				"UPDATE proyectos SET nombre = 'Plexus' WHERE id = 'D123'");
						
		// invocamos el método que actualiza los registros en "cientificos"
		miConexion.actualizarRegistros
			("ud18_ej7",
				"UPDATE cientificos SET nombreApellidos = 'Verónica Polonchak' WHERE DNI = 'A1234567'");
		
		// invocamos el método que actualiza los registros en "asignado_a"
		miConexion.actualizarRegistros
			("ud18_ej7",
				"UPDATE asignado_a SET DNICientifico = 'A1234567' WHERE id = 5");
		
		// invocamos el método que obtiene los registros de "proyectos"
		Proyectos proyectos = new Proyectos();
		proyectos.obtenerRegistros("ud18_ej7", "SELECT * FROM proyectos");
		
		// invocamos el método que obtiene los registros de "cientificos"
		Cientificos cientificos = new Cientificos();
		cientificos.obtenerRegistros("ud18_ej7", "SELECT * FROM cientificos");
		
		// invocamos el método que obtiene los registros de "asignado_a"
		Asignado_a asignado_a = new Asignado_a();
		asignado_a.obtenerRegistros("ud18_ej7", "SELECT * FROM asignado_a");
		
		// invocamos el método que elimina los registros de "asignado_a"
		miConexion.eliminarRegistros("ud18_ej7", "DELETE FROM asignado_a");
		
		// invocamos el método que elimina los registros de "proyectos"
		miConexion.eliminarRegistros("ud18_ej7", "DELETE FROM proyectos");
		
		// invocamos el método que elimina los registros de "cientificos"
		miConexion.eliminarRegistros("ud18_ej7", "DELETE FROM cientificos");
	

	}

}
