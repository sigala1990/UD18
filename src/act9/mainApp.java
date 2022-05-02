package act9;

import java.sql.Statement;

import UtilSql.Sql;

public class mainApp {

	private static Statement statement = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String queryFACULTAD = "CREATE TABLE FACULTAD ("
				+ "codigo int auto_increment primary key,"
				+ "nombre nvarchar(100));";
		String queryINVESTIGADORES = "CREATE TABLE INVESTIGADORES ("
				+ "dni varchar(8) primary key,"
				+ "nomApels nvarchar(255),"
				+ "facultad int,"
				+ "key (facultad),"
				+ "FOREIGN KEY (facultad) REFERENCES FACULTAD (codigo)ON UPDATE CASCADE ON DELETE CASCADE);";
		String queryEQUIPOS = "CREATE TABLE EQUIPOS ("
				+ "numserie char(4) primary key,"
				+ "nombre nvarchar(100),"
				+ "facultad int,"
				+ "key (facultad),"
				+ "FOREIGN KEY (facultad) REFERENCES FACULTAD (codigo) ON UPDATE CASCADE ON DELETE CASCADE);";
		String queryRESERVA = "CREATE TABLE RESERVAS ("
				+ "reservaID int auto_increment primary key,"
				+ "comienzo datetime,"
				+ "fin datetime,"
				+ "dni varchar(8),"
				+ "numserie char(4),"
				+ "key (dni, numSerie),"
				+ "FOREIGN KEY (dni) REFERENCES INVESTIGADORES (dni)  ON UPDATE CASCADE ON DELETE CASCADE,"
				+ "FOREIGN KEY (numserie) REFERENCES EQUIPOS ( numserie) ON UPDATE CASCADE ON DELETE CASCADE)";
		
		String queryInsertFACULTAD = "INSERT INTO FACULTAD (nombre) values "
				+ "(\"facultadGuay\"),"
				+ "(\"facultadDificil\"),"
				+ "(\"facultadGatuna\"),"
				+ "(\"facultadCulumbia\");";
		String queryInsertINVESTIGADORES = "INSERT INTO INVESTIGADORES (dni,nomApels,facultad) values "
				+ "(4444444,\"Gadget\",1),"
				+ "(2222222,\"Sherlock\",2),"
				+ "(1111111,\"Miau\",3),"
				+ "(3333333,\"Watson\",4);";
		String queryInsertEQUIPOS = "INSERT INTO EQUIPOS (numserie, nombre,facultad) values "
				+ "(\"QWER\",\"Tigers\",1),"
				+ "(\"EQWR\", \"Panteras\",2),"
				+ "(\"QAZW\", \"Dolphins\",3),"
				+ "(\"ASDW\", \"Lions\",4);";
		String queryInsertRESERVA = "INSERT INTO RESERVAS (comienzo, fin, dni,numserie) values "
				+ "('2022-03-12T04:33:44','2022-03-12T04:33:44',1111111,\"QWER\"),"
				+ "('2022-03-12T04:33:44','2022-03-12T04:33:44',2222222,\"EQWR\"),"
				+ "('2022-03-12T04:33:44','2022-03-12T04:33:44',3333333,\"QAZW\"),"
				+ "('2022-03-12T04:33:44','2022-03-12T04:33:44',4444444,\"ASDW\");";
		String queryUpdateFACULTAD = "UPDATE FACULTAD "
				+ "SET nombre = \"facultadGuay\""
				+ "WHERE nombre = \"facultadDificil\";";
		String queryUpdateINVESTIGADORES = "UPDATE INVESTIGADORES "
				+ "SET nomApels = \"Emma Watson\" "
				+ "WHERE nomApels = \"Watson\";";
		String queryUpdateEQUIPOS = "UPDATE EQUIPOS "
				+ "SET numserie = \"QWER\" "
				+ "WHERE facultad = 1;";
		String queryUpdateRESERVA = "UPDATE RESERVAS "
				+ "SET dni = 4444444 "
				+ "WHERE dni = \"2222222\";";
		String queryDeleteFACULTAD = "DELETE FROM FACULTAD WHERE nombre = \"facultadCulumbia\";";
		String queryDeleteINVESTIGADORES = "DELETE FROM INVESTIGADORES WHERE nomApels = \"Gadget\";";
		String queryDeleteEQUIPOS = "DELETE FROM EQUIPOS WHERE facultad = 2;";
		String queryDeleteRESERVA = "DELETE FROM RESERVAS WHERE numserie = \"QWER\";";
		
		Sql.crearConnection();
		Sql.crearDB("Investigadores");
		System.out.println("--------CREATE TABLE---------");
		Sql.inyeccionSQL("Investigadores", queryFACULTAD);
		Sql.inyeccionSQL("Investigadores", queryINVESTIGADORES);
		Sql.inyeccionSQL("Investigadores", queryEQUIPOS);
		Sql.inyeccionSQL("Investigadores", queryRESERVA);
		System.out.println("--------INSERTS---------");
		Sql.inyeccionSQL("Investigadores", queryInsertFACULTAD);
		Sql.inyeccionSQL("Investigadores", queryInsertINVESTIGADORES);
		Sql.inyeccionSQL("Investigadores", queryInsertEQUIPOS);
		Sql.inyeccionSQL("Investigadores", queryInsertRESERVA);
		System.out.println("--------UPDATE---------");
		Sql.inyeccionSQL("Investigadores", queryUpdateFACULTAD);
		Sql.inyeccionSQL("Investigadores", queryUpdateINVESTIGADORES);
		Sql.inyeccionSQL("Investigadores", queryUpdateEQUIPOS);
		Sql.inyeccionSQL("Investigadores", queryUpdateRESERVA);
		//select
		Sql.getValues("Investigadores", "FACULTAD"); 
		Sql.getValues("Investigadores", "INVESTIGADORES"); 
		Sql.getValues("Investigadores", "EQUIPOS"); 
		Sql.getValues("Investigadores", "RESERVAS"); 
		System.out.println("--------DELETE---------");
		Sql.inyeccionSQL("Investigadores", queryDeleteFACULTAD);
		Sql.inyeccionSQL("Investigadores", queryDeleteINVESTIGADORES);
		Sql.inyeccionSQL("Investigadores", queryDeleteEQUIPOS);
		Sql.inyeccionSQL("Investigadores", queryDeleteRESERVA);
	

		Sql.cerrarConnection();
	}

	
}
