package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.util.Date;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public class Vista {
	
	    private Controlador controlador;

	    public void setControlador(Controlador controlador) {
	        if (controlador != null) {
	            this.controlador = controlador;
	        }
	    }

	    public void comenzar() {
	        Consola consola = new Consola();
	        boolean salir = false;

	        while (!salir) {
	            consola.mostrarMenu(new String[] {
	                "Opción 1",
	                "Opción 2",
	                "Salir"
	            });

	            int opcion = consola.elegirOpcion(3);

	            switch (opcion) {
	                case 1:
	                    ejecutarOpcion1(consola);
	                    break;
	                case 2:
	                    ejecutarOpcion2(consola);
	                    break;
	                case 3:
	                    salir = true;
	                    break;
	            }
	        }

	        terminar();
	    }

	    public void terminar() {
	        Consola consola = new Consola();
	        consola.mostrarMenu("¡Hasta luego!");
	    }

	    public void ejecutar(int opcion) {
	        Consola consola = new Consola();

	        switch (opcion) {
	            case 1:
	                ejecutarOpcion1(consola);
	                break;
	            case 2:
	                ejecutarOpcion2(consola);
	                break;
	        }
	    }

	    private void ejecutarOpcion1(Consola consola) {
	        consola.mostrarCabecera("Opción 1");
	        String cadena = consola.leerCadena("Introduzca una cadena:");
	        int entero = consola.leerEntero("Introduzca un número entero:");
	        Date fecha = consola.leerFecha("Introduzca una fecha:");
	        controlador.realizarAccion1(cadena, entero, fecha);
	    }

	    private void ejecutarOpcion2(Consola consola) {
	        consola.mostrarCabecera("Opción 2");
	        int entero = consola.leerEntero("Introduzca un número entero:");
	        controlador.realizarAccion2(entero);
	    }

		public void setControlador1(Controlador controlador2) {
			
		}

		public void comenzar1() {
			// TODO Auto-generated method stub
			
		}

		public void terminar1() {
			
		}
	}
