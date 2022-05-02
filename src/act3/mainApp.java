package act3;

import java.sql.ResultSetMetaData;
import java.sql.Statement;

import UtilSql.Sql;

public class mainApp {
	
	private static Statement statement = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String queryCrearAlmacenes = "CREATE TABLE ALMACENES("
				+ "codigo int auto_increment primary key,"
				+ "lugar nvarchar(100) ,"
				+ "capacidad int);";
		String queryCrearCajas = "CREATE TABLE CAJAS("
				+ "numreferencia char(5) primary key,"
				+ "contenido nvarchar(100),"
				+ "valor int,"
				+ "almacen int,"
				+ "key (almacen),"
				+ "FOREIGN KEY (almacen) REFERENCES ALMACENES (codigo) ON UPDATE CASCADE ON DELETE CASCADE);";
		
		String queryInsertAlmacenes = "INSERT INTO ALMACENES (lugar, capacidad) values"
				+ "(\"Girona\",2000),"
				+ "(\"Bcn\",50000),"
				+ "(\"Reus\",200);";
		String queryInsertCajas= "INSERT INTO CAJAS (numreferencia, contenido,valor,almacen) values"
				+ "(30,\"cosas\",300, 3),"
				+ "(44,\"muchas\",12, 2);" ;
		
		String queryUpdateAlmacenes = "UPDATE ALMACENES "
				+ " SET lugar = \"Tarragona\" "
				+ " WHERE lugar = \"Girona\";";
		String queryUpdateCajas = "UPDATE CAJAS "
				+ "SET contenido = \"muchascosas\" "
				+ "WHERE contenido = \"cosas\";";
		
		String queryDeleteAlmacenes = "DELETE FROM ALMACENES WHERE lugar = \"Tarragona\";";
		String queryDeleteCajas = "DELETE FROM CAJAS WHERE numreferencia = \"30\";";
		
		Sql.crearConnection();
		Sql.crearDB("GRANDESALMACENES");
		//create table
		System.out.println("--------CREATE TABLE---------");
		Sql.inyeccionSQL("GRANDESALMACENES", queryCrearAlmacenes);	
		Sql.inyeccionSQL("GRANDESALMACENES", queryCrearCajas);
		//insert
		System.out.println("--------INSERT TABLE---------");
		Sql.inyeccionSQL("GRANDESALMACENES", queryInsertAlmacenes);
		Sql.inyeccionSQL("GRANDESALMACENES", queryInsertCajas);
		//update
		System.out.println("--------UPDATE TABLE---------");
		Sql.inyeccionSQL("GRANDESALMACENES", queryUpdateAlmacenes);
		Sql.inyeccionSQL("GRANDESALMACENES", queryUpdateCajas);
		//delete
		System.out.println("--------DELETE TABLE---------");
		Sql.inyeccionSQL("GRANDESALMACENES", queryDeleteAlmacenes);
		Sql.inyeccionSQL("GRANDESALMACENES", queryDeleteCajas);
		//select
		Sql.getValues("GRANDESALMACENES","ALMACENES");
		Sql.getValues("GRANDESALMACENES","CAJAS");
		Sql.cerrarConnection();
	}
	
}
