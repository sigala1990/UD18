import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
		
		//createDB("personas");
		//createTable("personas", "estudiantes");
		//insertData("personas", "estudiantes", "Marc", "Planas", "10", "H");
		//getValues( "personas", "estudiantes");
		deleteRecord( "personas","estudiantes", "1");
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
			String Query = "CREATE DATABASE "+name+" IF NOT EXIST"; //query = linea de comanda
			Statement st = Sql_conexion.createStatement(); //omplim Statement amb la conexion creada anteriorment "Sql_conexion"
			st.executeUpdate(Query); // executar la query creada anteriorment
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos "+name+" de forma exitosa");
			Sql_conexion.close();
			
		}catch (SQLException ex) {
			try {
				Sql_conexion.close();

			}catch (Exception e) {
				// TODO: handle exception
			}
				
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
					+"(ID INT PRIMARY KEY AUTO_INCREMENT, Nombre VARCHAR(50), Apellido VARCHAR(50),"
					+"Edad VARCHAR(3), Sexo VARCHAR(1))";
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
	public static void insertData(String db, String table_name, String name, String lastname, String age, String gender) {
		
		Connection Sql_conexion=conexionDB();
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = Sql_conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + " (Nombre, Apellido, Edad, sexo) VALUE("
					+ "\"" + name + "\", "
					+ "\"" + lastname + "\", "
					+ "\"" + age + "\", "
					+ "\"" + gender + "\"); ";
			Statement st = Sql_conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
			Sql_conexion.close();
		
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	// Metodo que obtiene valores MYSQL
	public static void getValues(String db, String table_name) {
		
		Connection Sql_conexion=conexionDB();
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = Sql_conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = Sql_conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getString("ID")+" "
						+ "Nombre: " + resultSet.getString("Nombre")+ " "
						+ "Apellido: " + resultSet.getString("Apellido")+ " "
						+ "Edad: " + resultSet.getString("Edad")+ " "
						+ "Sexo: " + resultSet.getString("Sexo")+ " "
						);
			}
			Sql_conexion.close();
			
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
	}
	
	// Metodo que elimina valores de nuestra Base de Datos
	public static void deleteRecord(String db, String table_name, String ID) {
		
		Connection Sql_conexion=conexionDB();
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = Sql_conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "DELETE FROM " + table_name + " WHERE ID = \""+ ID + "\"";
			Statement st = Sql_conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos borrados correctamente");
			Sql_conexion.close();
			
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}
	
}
