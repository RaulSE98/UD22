package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {


	public Connection conexion; 
	
	public Connection getConexion() {
		return conexion;
	}
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(
					"jdbc:mysql://192.168.1.126:3306?userTimezone=true&serverTimezone=UTC", "remote", "Rsantos?1");
			System.out.println("Conectado");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error 404");
		}

	}

	public void closeConnection() {
		try {
			conexion.close();
			System.out.println("Desconectado");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public String manipularBD(String nombre, String accion, String query) {
		try {
			String QueryDB = "USE UD22";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(QueryDB);
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			return ("Datos " + nombre + " correctamente");
		} catch (SQLException e) {
			return ("Error al " + accion + " datos");
		}
	}
	public String Select (String accion, String query) {
		String resultado = "";
		
		try {
			String sql = "Select * from cliente where id = ? " ;
			String QueryDB = "USE UD22";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(QueryDB);
			PreparedStatement consulta = conexion.prepareStatement(sql);
			consulta.setInt(1, Integer.parseInt(query));
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				resultado += res.getString("id") + " ";
				resultado += res.getString("nombre") + " ";
				resultado += res.getString("apellido") + " ";
				resultado += res.getString("direccion") + " ";
				resultado += res.getString("dni") + " ";
				resultado += res.getString("fecha") + " ";
			}
			res.close();
			return resultado;
		} catch (SQLException e) {
			System.out.println(e);
			return "Error al " + accion + " datos";
		}
	}

}
