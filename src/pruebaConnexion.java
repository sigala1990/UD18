import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import UtilSql.Sql;

public class pruebaConnexion {

	public static void main(String[] args) {
			
		String queryFabricantes = "CREATE TABLE FABRICANTES (" + "codigo int auto_increment primary key,"
				+ "nombre nvarchar(100));";
		String queryArticulos = "CREATE TABLE ARTICULOS ("
				+ "codigo int auto_increment primary key,"
				+ "nombre nvarchar(100)," 
				+ "precio int," 
				+ "fabricante int," 
				+ "key ( fabricante ),"
				+ "FOREIGN KEY (fabricante) REFERENCES FABRICANTES (codigo) ON UPDATE CASCADE ON DELETE CASCADE);";

		crearDB("tiendaInformaticaUD18");
		crearTable("tiendaInformaticaUD18", queryFabricantes);
		crearTable("tiendaInformaticaUD18", queryArticulos);
		//crearTable("tiendaInformaticaUD18", q);

	}

	public static void crearDB(String name) {
		try {
			String query = "CREATE DATABASE " + name;
			Statement st = Sql.crearConnection().createStatement();
			st.executeUpdate(query);
			System.out.println("Tabla " + name + " creada correctamente.");
			Sql.cerrarConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			Sql.cerrarConnection();
		}
	}

	public static void crearTable(String db, String query) {
		try {
			Statement stdb = Sql.crearConnection().createStatement();
			String querydb = "USE " + db + ";";
			stdb.executeUpdate(querydb); // ejecutamos USE "database";
			stdb.executeUpdate(query);
			Sql.cerrarConnection();
		} catch (SQLException e) {
			System.out.println("Error al crear " + query.substring(0, 20));
			System.out.println(e.getMessage());
			Sql.cerrarConnection();
		}
	}
}
