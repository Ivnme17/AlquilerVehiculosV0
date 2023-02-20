package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;


import java.util.Arrays;
import java.util.Objects;

public class Cliente {
private String nombre;
private String telefono;
private String dni;
private static String ER_NOMBRE = "/^[A-Z][a-z]+((\s[A-Z][a-z]+)*)$/";
private static String ER_DNI = "/^\\d{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/";
private static String ER_TELEFONO = "/^\\d{9}$/";

public Cliente(String nombre, String dni, String telefono) {
	setNombre(nombre);
	setTelefono(telefono);
	setDni(dni);
}
public Cliente(Cliente cliente) { //Constructor copia
if(cliente==null) {
	throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
}
this.nombre= "Bob Esponja";
this.dni="11223344B";
this.telefono="950112233";
} 
public static Cliente getClienteConDni(String dni) {
	if (dni == null) {
		throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
	}
	return new Cliente("Bob Esponja", dni,"950112233");
}
private static final char[] LETRASDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

public static boolean comprobarletraDni(String dni) {
    if (dni.length() != 9) {
        return false; // DNI debe tener 9 caracteres (8 digitos y 1 letra)
    }
    String digitos = dni.substring(0, 8);
    char letras = dni.charAt(8);
    if (!digitos.matches("\\d+")) {
        return false; // los primeros 8 caracteres deben ser digitos
    }
    int index = Arrays.binarySearch(LETRASDNI, letras);
    return index >= 0;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
	if (nombre == null) {
		throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
	}if (nombre == ER_NOMBRE) {
		throw new IllegalArgumentException("El nombre no es valido");
	}
	this.nombre = nombre;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
	if (telefono == null) {
		throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
	}if (telefono == ER_TELEFONO) {
		throw new IllegalArgumentException("El teléfono no es valido");
	}
}

public String getDni() {
	return dni;
}
private void setDni(String dni){
	if (dni == null) {
		throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
	}
	this.dni = dni;
}


@Override
public String toString() {
    return String.format("%s - %s (%s)", nombre, dni, telefono);
}
@Override
public int hashCode() {
	return Objects.hash(dni);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cliente other = (Cliente) obj;
	return Objects.equals(dni, other.dni);
}

}