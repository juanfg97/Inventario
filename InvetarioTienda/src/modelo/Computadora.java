package modelo;

public class Computadora {
	//Atributos
private int codigo;
private String marca,procesador;
private double memoria;
private String sistema;
private double precio;
//Constructor
public Computadora() {
	
}
//Metodos getter y setter
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getProcesador() {
	return procesador;
}
public void setProcesador(String procesador) {
	this.procesador = procesador;
}
public double getMemoria() {
	return memoria;
}
public void setMemoria(double memoria) {
	this.memoria = memoria;
}
public String getSistema() {
	return sistema;
}
public void setSistema(String sistema) {
	this.sistema = sistema;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}

}
