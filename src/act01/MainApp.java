package act01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
		
		//createDB("informatica");
		//createTable("informatica", "fabricantes");
		//insertData("informatica", "fabricantes", "Marc");
		//insertData("informatica", "fabricantes", "Jan");
		//insertData("informatica", "fabricantes", "Eva");
		//insertData("informatica", "fabricantes", "Ana");
		//insertData("informatica", "fabricantes", "Jordi");
		
		//createTable("informatica", "articulos");
		//insertData("informatica", "articulos", "Tuerca", "10", "20");
		insertData("informatica", "articulos", "Tuerca2", "20", "40");
		insertData("informatica", "articulos", "Tuerca3", "30", "60");
		insertData("informatica", "articulos", "Tuerca4", "40", "80");
		insertData("informatica", "articulos", "Tuerca5", "50", "100");
		
		

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
	public static void insertData(String db, String table_name, String name, String price, String maker) {
		
		Connection Sql_conexion=conexionDB();
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = Sql_conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + " (Nombre, Precio, Fabricante) VALUE("
					+ "\"" + name + "\", "
					+ "\"" + price + "\", "
					+ "\"" + maker + "\"); ";
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
