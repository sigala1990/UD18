package act06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
		
		//createDB("tienda");
		//createTable("tienda", "piezas");
		//insertData("tienda", "piezas", "tornillo");
		//insertData("tienda", "piezas", "tornillo_1");
		//insertData("tienda", "piezas", "tornillo_2");
		//insertData("tienda", "piezas", "tornillo_3");
		//insertData("tienda", "piezas", "tornillo_4");

		//createTable("tienda", "proveedores");
		//insertData("tienda", "proveedores", "Tesca");
		//insertData("tienda", "proveedores", "Tesca_1");
		//insertData("tienda", "proveedores", "Tesca_2");
		//insertData("tienda", "proveedores", "Tesca_3");
		//insertData("tienda", "proveedores", "Tesca_4");
		
		//createTable("tienda", "suministra");
		//insertData("tienda", "suministra", "10");
		insertData("tienda", "suministra", "20");
		insertData("tienda", "suministra", "30");
		insertData("tienda", "suministra", "40");
		insertData("tienda", "suministra", "50");


	}
	
	// Conexion a la base de datos
	public static Connection conexionDB() {
		Connection conexion=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.17:3306?useTimezone=true&serverTimezone=UTC", "remote", "Reus_2022");
			System.out.println("Server Connected");
			return conexion;
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
			return conexion;
		}
		
	}

	// Metodo que crea Base de Datos
	public static void createDB(String name) {
		
		
		Connection Sql_conexion=conexionDB(); //
		
		try {// sentencia Query //establecer conexion // executar query despues de conexion
			String Query = "CREATE DATABASE "+name; //query = linea de comanda
			Statement st = Sql_conexion.createStatement(); //omplim Statement amb la conexion creada anteriorment "Sql_conexion"
			st.executeUpdate(Query); // executar la query creada anteriorment
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos "+name+" de forma exitosa");
			Sql_conexion.close();
			
		}catch (SQLException ex) {
			try {
				Sql_conexion.close();

			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("Base de datos no creada");
			}
			System.out.println("Base de datos no creada_2");
			System.out.println(ex.getMessage());
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	// Metodo que crea Tablas MYSQL
	public static void createTable(String db, String name) {
		
		Connection Sql_conexion=conexionDB();
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb= Sql_conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE "+name+""
					+"(ID INT PRIMARY KEY AUTO_INCREMENT, Nombre VARCHAR(100))";
			Statement st= Sql_conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con exito!");
			Sql_conexion.close();
			
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
			
		}
		
	}
	
	// Metodo que inserta datos en tablas MYSQL
	public static void insertData(String db, String table_name, String name) {
		
		Connection Sql_conexion=conexionDB();
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = Sql_conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + " (Nombre) VALUE("
					+ "\"" + name + "\"); ";
			Statement st = Sql_conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
			Sql_conexion.close();
		
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}


}
