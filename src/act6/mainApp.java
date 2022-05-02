package act6;

import java.sql.Statement;

import UtilSql.Sql;

public class mainApp {

	private static Statement statement = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String queryCreatePiezas = "CREATE TABLE PIEZAS ("
				+ "codigo int auto_increment primary key,"
				+ "nombre nvarchar(100));";
		String queryCreateProveedores = "CREATE TABLE PROVEEDORES ("
				+ "id char(4) primary key,"
				+ "nombre nvarchar(100));";
		String queryCreateSuministra = "CREATE TABLE SUMINISTRA ("
				+ "suministraID int auto_increment primary key,"
				+ "precio int,"
				+ "idProveedor char(4),"
				+ "codigoPieza int,"
				+ "key (codigoPieza, idProveedor),"
				+ "FOREIGN KEY (codigoPieza) REFERENCES PIEZAS (codigo) ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "FOREIGN KEY (idProveedor) REFERENCES PROVEEDORES (id) ON UPDATE CASCADE ON DELETE CASCADE);";
		
		String queryInsertPiezas = "INSERT INTO PIEZAS (nombre) values "
				+ "(\"tornillo\"),"
				+ "(\"tuerca\");";
		String queryInsertProveedores = "INSERT INTO PROVEEDORES (id,nombre) values"
				+ "(\"ARD\",\"leroymerlin\"),"
				+ "(\"TOR\",\"BAUHAUS\");";
		String queryInsertSuministra = "INSERT INTO SUMINISTRA (precio , codigoPieza, idProveedor) values"
				+ "(20,2,\"ARD\"),"
				+ "(33,1, \"TOR\");";
		
		String queryUpdatePiezas = "UPDATE PIEZAS "
				+ "SET nombre = \"Dinamo\""
				+ "WHERE nombre = \"tornillo\";";
		String queryUpdateProveedores = "UPDATE PROVEEDORES "
				+ "SET nombre = \"RAT\""
				+ "WHERE nombre = \"ARD\";";
		String queryUpdateSuministra = "UPDATE SUMINISTRA "
				+ "SET precio = 500 "
				+ "WHERE precio = 20;";
		
		String queryDeletePiezas = "DELETE FROM PIEZAS WHERE nombre = \"Dinamo\";";
		String queryDeleteProveedores = "DELETE FROM PROVEEDORES WHERE nombre  = \"BAUHAUS\";";
		String queryDeleteSuministra = "DELETE FROM SUMINISTRA WHERE codigoPieza = 1;";
		
		Sql.crearConnection();
		Sql.crearDB("PIEZAS_PROVEEDORES");
		//createTable
		System.out.println("--------CREATE TABLE---------");
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryCreatePiezas);
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryCreateProveedores);
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryCreateSuministra);
		//Insert
		System.out.println("--------INSERT TABLE---------");
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryInsertPiezas);
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryInsertProveedores);
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryInsertSuministra);
		//Update
		System.out.println("--------UPDATE TABLE---------");
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryUpdatePiezas);
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryUpdateProveedores);
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryUpdateSuministra);
		//Delete
		System.out.println("--------DELETE TABLE---------");
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryDeletePiezas);
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryDeleteProveedores);
		Sql.inyeccionSQL("PIEZAS_PROVEEDORES", queryDeleteSuministra);
		//select
		Sql.getValues("PIEZAS_PROVEEDORES", "PIEZAS");
		Sql.getValues("PIEZAS_PROVEEDORES", "PROVEEDORES");
		Sql.getValues("PIEZAS_PROVEEDORES", "SUMINISTRA");
		Sql.cerrarConnection();
	}
	

}
