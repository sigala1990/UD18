package act1;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import UtilSql.Sql;

public class mainApp {
	
	private static Statement statement = null;
	public static void main(String[] args) {
		
		String queryFabricantes = "CREATE TABLE FABRICANTES (" 
				+ "codigo int auto_increment primary key,"
				+ "nombre nvarchar(100));";
		String queryArticulos = "CREATE TABLE ARTICULOS ("
				+ "codigo int auto_increment primary key,"
				+ "nombre nvarchar(100)," 
				+ "precio int," 
				+ "fabricante int," 
				+ "key ( fabricante ),"
				+ "FOREIGN KEY (fabricante) REFERENCES FABRICANTES (codigo) ON UPDATE CASCADE ON DELETE CASCADE);";

		String queryInsertFabricantes = "INSERT INTO FABRICANTES (nombre) values "
				+ "(\"ford\"),"
				+ "(\"tomate\");";
		String queryInsertArticulos = "INSERT INTO ARTICULOS (nombre, precio, fabricante) values"
				+ "(\"manzana \", 200, 1),"
				+ "(\"pera \", 300,2),"
				+ "(\"tomate \",100,1);";
		
		String queryUpdateFabricante = "UPDATE FABRICANTES "
				+ " SET nombre = \"fordFiesta\" "
				+ " WHERE nombre = \"ford\";";
		
		String queryUpdateArticulos = "UPDATE ARTICULOS "
				+ " SET nombre = \"kiwi\", precio = 50, fabricante = 3"
				+ " WHERE nombre = \"manzana\";";
		
		String queryDeleteFabricante = "DELETE FROM FABRICANTES WHERE nombre = \"tomate\";";
		
		String queryDeleteArticulos = "DELETE FROM ARTICULOS WHERE nombre = \"pera\";";
		//String queryUpdateArticulos = ""
		try {
			statement = Sql.crearConnection().createStatement();	
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		Sql.crearDB("tiendaInformaticaUD18");
		//create table
		Sql.inyeccionSQL("tiendaInformaticaUD18", queryFabricantes);
		Sql.inyeccionSQL("tiendaInformaticaUD18", queryArticulos); 
		//insert 
		Sql.inyeccionSQL("tiendaInformaticaUD18", queryInsertFabricantes);
		Sql.inyeccionSQL("tiendaInformaticaUD18", queryInsertArticulos);
		//update
		Sql.inyeccionSQL("tiendaInformaticaUD18", queryUpdateFabricante);
		Sql.inyeccionSQL("tiendaInformaticaUD18", queryUpdateArticulos);
		//delete
		Sql.inyeccionSQL("tiendaInformaticaUD18", queryDeleteFabricante);
		Sql.inyeccionSQL("tiendaInformaticaUD18", queryDeleteArticulos);
		//select
		getValues("tiendaInformaticaUD18","FABRICANTES");
		Sql.cerrarConnection();
		
	}

	public static void getValues(String db, String table_name) {
		try {
			String querydb = "USE "+db+";";
			statement.executeUpdate(querydb);
			
			String Query = "SELECT * FROM "+ table_name;
			java.sql.ResultSet resultSet = statement.executeQuery(Query);			
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			while(resultSet.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if(i > 1)System.out.println("\n");
					  String columnValue = resultSet.getString(i);
				        System.out.print(columnValue + " " + rsmd.getColumnName(i));
				}
				
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	

}
