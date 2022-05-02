package ej2;

import utils.ConnectionDB;

public class MainApp {

	public static void main(String[] args) {
		
		// invocamos el método que establece la conexión
		ConnectionDB.crearConexion();
		
		// invocamos el método que crea la base de datos
		ConnectionDB.crearDatabase("ud18_ej2");
		
	
		// invocamos el método que crea la tabla "departamentos"
		ConnectionDB.crearTabla
			("ud18_ej2", 
				"CREATE TABLE departamentos "
				+ " (codigo INT PRIMARY KEY,"
				+ " nombre VARCHAR(100),"
				+ " presupuesto INT)");
	
		// invocamos el método que crea la tabla "empleados"
	    ConnectionDB.crearTabla
			("ud18_ej2", 
				"CREATE TABLE empleados "
				+ " (DNI VARCHAR(8) PRIMARY KEY,"
				+ " nombre VARCHAR(100),"
				+ " apellidos VARCHAR(255),"
				+ " departamento INT,"
				+ " FOREIGN KEY (departamento) REFERENCES departamentos (codigo) "
				+ " ON DELETE CASCADE ON UPDATE CASCADE)");

		// invocamos el método que inserta los registros a "departamentos"
	    ConnectionDB.executarConsultas
			("ud18_ej2", 
				"INSERT INTO departamentos VALUES "
				+ " (1, 'RRHH', 10000),"
				+ " (2, 'Marketing', 15000),"
				+ " (3, 'Contabilidad', 10000),"
				+ " (4, 'Ventas', 15000),"
				+ " (5, 'Compras', 15000)");
		
		// invocamos el método que inserta los registros a "empleados"
	    ConnectionDB.executarConsultas
			("ud18_ej2", 
				"INSERT INTO empleados VALUES "
				+ " ('A1234567', 'Veronika', 'Polonchak', 1),"
				+ " ('B1234567', 'Isidre', 'Planas', 2),"
				+ " ('C1234567', 'Adria', 'Queralt', 3),"
				+ " ('D1234567', 'Joan', 'Hurtado', 4),"
				+ " ('E1234567', 'Octavio', 'Bernal', 5)");
		
		// invocamos el método que actualiza los registros en "departamentos"
	    ConnectionDB.executarConsultas
			("ud18_ej2",
				"UPDATE departamentos SET nombre = 'Contabilidad y finanzas' WHERE codigo = 3");
		
		// invocamos el método que actualiza los registros en "empleados"
	    ConnectionDB.executarConsultas
			("ud18_ej2",
				"UPDATE empleados SET nombre = 'Verónica' WHERE DNI = 'A1234567'");
	
		// invocamos el método que obtiene los registros de "departamentos"
		Departamentos.obtenerRegistros("ud18_ej2", "SELECT * FROM departamentos");
		
		// invocamos el método que obtiene los registros de "empleados"
		Empleados.obtenerRegistros("ud18_ej2", "SELECT * FROM empleados");
		
		// invocamos el método que elimina los registros de "empleados"
		ConnectionDB.executarConsultas("ud18_ej2", "DELETE FROM empleados");
		
		// invocamos el método que elimina los registros de "departamentos"
		ConnectionDB.executarConsultas("ud18_ej2", "DELETE FROM departamentos");

		// invocamos el método que cierra la conexión
		ConnectionDB.cerrarConexion();
		
	}

}
