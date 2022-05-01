package ej2;

import utils.ConnectionDB;

public class MainApp {

	public static void main(String[] args) {
		
		// instanciamos la clase que contiene el m�todo de conexi�n a BD y los m�todos CRUD
		ConnectionDB miConexion = new ConnectionDB();

		// invocamos el m�todo que crea la base de datos
		miConexion.crearDatabase("ud18_ej2");
		
		// invocamos el m�todo que crea la tabla "departamentos"
		miConexion.crearTabla
			("ud18_ej2", 
				"CREATE TABLE departamentos "
				+ " (codigo INT PRIMARY KEY,"
				+ " nombre VARCHAR(100),"
				+ " presupuesto INT)");
		
		// invocamos el m�todo que crea la tabla "empleados"
		miConexion.crearTabla
			("ud18_ej2", 
				"CREATE TABLE empleados "
				+ " (DNI VARCHAR(8) PRIMARY KEY,"
				+ " nombre VARCHAR(100),"
				+ " apellidos VARCHAR(255),"
				+ " departamento INT,"
				+ " FOREIGN KEY (departamento) REFERENCES departamentos (codigo) "
				+ " ON DELETE CASCADE ON UPDATE CASCADE)");

		// invocamos el m�todo que inserta los registros a "departamentos"
		miConexion.insertarRegistros
			("ud18_ej2", 
				"INSERT INTO departamentos VALUES "
				+ " (1, 'RRHH', 10000),"
				+ " (2, 'Marketing', 15000),"
				+ " (3, 'Contabilidad', 10000),"
				+ " (4, 'Ventas', 15000),"
				+ " (5, 'Compras', 15000)");
		
		// invocamos el m�todo que inserta los registros a "empleados"
		miConexion.insertarRegistros
			("ud18_ej2", 
				"INSERT INTO empleados VALUES "
				+ " ('A1234567', 'Veronika', 'Polonchak', 1),"
				+ " ('B1234567', 'Isidre', 'Planas', 2),"
				+ " ('C1234567', 'Adria', 'Queralt', 3),"
				+ " ('D1234567', 'Joan', 'Hurtado', 4),"
				+ " ('E1234567', 'Octavio', 'Bernal', 5)");
		
		// invocamos el m�todo que actualiza los registros en "departamentos"
		miConexion.actualizarRegistros
			("ud18_ej2",
				"UPDATE departamentos SET nombre = 'Contabilidad y finanzas' WHERE codigo = 3");
		
		// invocamos el m�todo que actualiza los registros en "empleados"
		miConexion.actualizarRegistros
			("ud18_ej2",
				"UPDATE empleados SET nombre = 'Ver�nica' WHERE DNI = 'A1234567'");
	
		// invocamos el m�todo que obtiene los registros de "departamentos"
		Departamentos departamentos = new Departamentos();
		departamentos.obtenerRegistros("ud18_ej2", "SELECT * FROM departamentos");
		
		// invocamos el m�todo que obtiene los registros de "empleados"
		Empleados empleados = new Empleados();
		empleados.obtenerRegistros("ud18_ej2", "SELECT * FROM empleados");
		
		// invocamos el m�todo que elimina los registros de "empleados"
		miConexion.eliminarRegistros("ud18_ej2", "DELETE FROM empleados");
		
		// invocamos el m�todo que elimina los registros de "departamentos"
		miConexion.eliminarRegistros("ud18_ej2", "DELETE FROM departamentos");

	}

}
