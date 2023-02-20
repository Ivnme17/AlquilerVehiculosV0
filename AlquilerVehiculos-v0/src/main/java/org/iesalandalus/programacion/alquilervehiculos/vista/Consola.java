package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Consola {
    
    private Scanner scanner;
    
    public Consola() {
        scanner = new Scanner(System.in);
    }
    
    public void mostrarCabecera(String mensaje) {
        System.out.println(mensaje);
        for (int i = 0; i < mensaje.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    
    public void mostrarMenu(String[] opciones) {
        mostrarCabecera("Menu:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i+1) + ". " + opciones[i]);
        }
    }
    
    public String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    
    public int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un número entero.");
            }
        }
    }
    
    public Date leerFecha(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = (Date) formato.parse(scanner.nextLine());
                return fecha;
            } catch (ParseException e) {
                System.out.println("Debe introducir una fecha en formato dd/MM/yyyy.");
            }
        }
    }
    
    public int elegirOpcion(String[] opciones) {
        while (true) {
            mostrarMenu(opciones);
            int opcion = leerEntero("Introduzca la opción deseada: ");
            if (opcion >= 1 && opcion <= opciones.length) {
                return opcion;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

	public void mostrarMenu(String string) {
		// TODO Auto-generated method stub
		
	}

	public int elegirOpcion(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}