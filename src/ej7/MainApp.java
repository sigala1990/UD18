package ej7;

import utils.ConnectionDB;

public class MainApp {

	public static void main(String[] args) {
		
		// invocamos el método que establece la conexión
		ConnectionDB.crearConexion();
		
		// invocamos el método que crea la base de datos
		ConnectionDB.crearDatabase("ud18_ej7");
		
		// invocamos el método que crea la tabla "proyectos"
		ConnectionDB.crearTabla
			("ud18_ej7", 
				"CREATE TABLE proyectos "
				+ "(id CHAR(4) PRIMARY KEY,"
				+ "nombre VARCHAR(255),"
				+ " horas INT)");
		
		// invocamos el método que crea la tabla "cientificos"
		ConnectionDB.crearTabla
			("ud18_ej7", 
				"CREATE TABLE cientificos "
				+ "(DNI VARCHAR(8) PRIMARY KEY,"
				+ " nombreApellidos VARCHAR(255))");
				
		// invocamos el método que crea la tabla "asignado_a"
		ConnectionDB.crearTabla
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
		ConnectionDB.executarConsultas
			("ud18_ej7", 
				"INSERT INTO proyectos VALUES "
				+ " ('A123', 'Prometheus', 100),"
				+ " ('B123', 'Salamandra', 200),"
				+ " ('C123', 'Solaris', 300),"
				+ " ('D123', 'Interstaller', 400),"
				+ " ('E123', 'Nexus', 500)");
		
		// invocamos el método que inserta los registros a "cientificos"
		ConnectionDB.executarConsultas
			("ud18_ej7", 
				"INSERT INTO cientificos VALUES "
				+ " ('A1234567', 'Veronika Polonchak'),"
				+ " ('B1234567', 'Isidre Planas'), "
				+ " ('C1234567', 'Adria Queralt'),"
				+ " ('D1234567', 'Joan Hurtado'),"
				+ " ('E1234567', 'Octavio Bernal')");
		
		// invocamos el método que inserta los registros a "asignado_a"
		ConnectionDB.executarConsultas
			("ud18_ej7", 
				"INSERT INTO asignado_a  VALUES "
				+ " (1, 'A123', 'A1234567'),"
				+ " (2, 'B123', 'B1234567'),"
				+ " (3, 'C123', 'C1234567'),"
				+ " (4, 'D123', 'D1234567'),"
				+ " (5, 'E123', 'E1234567')");
		
		// invocamos el método que actualiza los registros en "proyectos"
		ConnectionDB.executarConsultas
			("ud18_ej7",
				"UPDATE proyectos SET nombre = 'Plexus' WHERE id = 'D123'");
						
		// invocamos el método que actualiza los registros en "cientificos"
		ConnectionDB.executarConsultas
			("ud18_ej7",
				"UPDATE cientificos SET nombreApellidos = 'Verónica Polonchak' WHERE DNI = 'A1234567'");
		
		// invocamos el método que actualiza los registros en "asignado_a"
		ConnectionDB.executarConsultas
			("ud18_ej7",
				"UPDATE asignado_a SET DNICientifico = 'A1234567' WHERE id = 5");
		
		// invocamos el método que obtiene los registros de "proyectos"
		Proyectos.obtenerRegistros("ud18_ej7", "SELECT * FROM proyectos");
		
		// invocamos el método que obtiene los registros de "cientificos"
		Cientificos.obtenerRegistros("ud18_ej7", "SELECT * FROM cientificos");
		
		// invocamos el método que obtiene los registros de "asignado_a"
		Asignado_a.obtenerRegistros("ud18_ej7", "SELECT * FROM asignado_a");
		
		// invocamos el método que elimina los registros de "asignado_a"
		ConnectionDB.executarConsultas("ud18_ej7", "DELETE FROM asignado_a");
		
		// invocamos el método que elimina los registros de "proyectos"
		ConnectionDB.executarConsultas("ud18_ej7", "DELETE FROM proyectos");
		
		// invocamos el método que elimina los registros de "cientificos"
		ConnectionDB.executarConsultas("ud18_ej7", "DELETE FROM cientificos");
	
		// invocamos el método que cierra la conexión
		ConnectionDB.cerrarConexion();

	}

}
