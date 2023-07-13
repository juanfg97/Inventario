package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modelo.Computadora;

public class daoComputadora {
	//atributos
 Conexion cx;

 //constructor
 public daoComputadora(){
	 cx = new Conexion();
 }
 //metodo insertarcomputadora
 public boolean insertarcomputadora(Computadora computer) {
	 PreparedStatement ps=null;
	 try {
		ps=cx.conectar().prepareStatement("INSERT INTO inventario VALUES(?,?,?,?,?,?)");
		ps.setInt(1, computer.getCodigo());
		ps.setString(2, computer.getMarca());
		ps.setString(3, computer.getProcesador());
		ps.setDouble(4, computer.getMemoria());
		ps.setString(5, computer.getSistema());
		ps.setDouble(6, computer.getPrecio());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	
 }
 //metodo para copiar los datos de la base de datos a un arraylist
 public ArrayList<Computadora> consultaComputadoras (){
	 ArrayList<Computadora> lista = new ArrayList<Computadora>();
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 try {
		ps=cx.conectar().prepareStatement("SELECT * FROM inventario");
		rs=ps.executeQuery();
		while(rs.next()) {
			Computadora computer = new Computadora();
			computer.setCodigo(rs.getInt("Codigo"));
			computer.setMarca(rs.getString("Marca"));
			computer.setProcesador(rs.getString("Procesador"));
			computer.setMemoria(rs.getDouble("Memoriaram"));
			computer.setSistema(rs.getString("Sistemaoperativo"));
			computer.setPrecio(rs.getDouble("Precio"));
			lista.add(computer);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 return lista;
	 }
 //metodp para eliminar computadora
 public boolean eliminarcomputadora(int Codigo) {
	 PreparedStatement ps=null;
	 try {
		ps=cx.conectar().prepareStatement("DELETE FROM inventario WHERE Codigo=?");
		ps.setInt(1, Codigo);
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
 }
 //metodo para editar computadora
 public boolean editarcomputadora(Computadora computer) {
	 PreparedStatement ps=null;
	 try {
		ps=cx.conectar().prepareStatement("UPDATE inventario SET Marca=?,Procesador=?,Memoriaram=?,Sistemaoperativo=?,Precio=? WHERE Codigo=?");
	
		ps.setString(1, computer.getMarca());
		ps.setString(2, computer.getProcesador());
		ps.setDouble(3, computer.getMemoria());
		ps.setString(4, computer.getSistema());
		ps.setDouble(5, computer.getPrecio());
		ps.setInt(6,computer.getCodigo());
		ps.executeUpdate();
		cx.desconectar();
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
 }
}

