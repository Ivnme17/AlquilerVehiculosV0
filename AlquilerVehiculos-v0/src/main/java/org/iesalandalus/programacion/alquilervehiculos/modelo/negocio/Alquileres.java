package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.OperationNotSupportedException;


public class Alquileres {
    private List<Alquiler> Coleccionalquileres;

    public Alquileres() {
        Coleccionalquileres = new ArrayList<>();
    }

    public List<Alquiler> get(Turismo turismo) {
		ArrayList<Alquiler> arrayAlquileresCliente = new ArrayList<>();

		for (Alquiler alquilerLista : Coleccionalquileres) {
			if (alquilerLista.getTurismo().equals(turismo)) {
				arrayAlquileresCliente.add(alquilerLista);}}
		return arrayAlquileresCliente;
			
		}

    public List<Alquiler> get(Cliente cliente) {
		ArrayList<Alquiler> arrayAlquileresCliente = new ArrayList<>();

		for (Alquiler alquilerLista2 : Coleccionalquileres) {
			if (alquilerLista2.getCliente().equals(cliente)) {
				arrayAlquileresCliente.add(alquilerLista2);
			}
		}

		return arrayAlquileresCliente;
	}
    public int getCantidad() {
        return Coleccionalquileres.size();
    }

    public boolean comprobarAlquiler(Alquiler alquiler) {
        if (alquiler == null || Coleccionalquileres.contains(alquiler)) {
            return false;
        }
        for (Alquiler a : Coleccionalquileres) {
            if (a.getCliente().equals(alquiler.getCliente()) && a.getFechaDevolucion() == null) {
                return false;
            }
            if (a.getTurismo().equals(alquiler.getTurismo()) && a.getFechaDevolucion() == null) {
                return false;
            }
            if (a.getCliente().equals(alquiler.getCliente()) && a.getTurismo().equals(alquiler.getTurismo())
                    && a.getFechaAlquiler().isBefore(alquiler.getFechaDevolucion())
                    && (a.getFechaDevolucion() == null || a.getFechaDevolucion().isAfter(alquiler.getFechaAlquiler()))) {
                return false;
            }
        }
        return true;
    }

    public void insertar(Alquiler alquiler) throws OperationNotSupportedException  {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}

		if (!Coleccionalquileres.contains(alquiler)) {
			comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
			Coleccionalquileres.add(alquiler);
		}

		

	}


	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler)
			throws OperationNotSupportedException {
		for (Alquiler alquiler : Coleccionalquileres) {
		
			if (alquiler.getFechaDevolucion() == null) {

				if (alquiler.getCliente().equals(cliente)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
				}
				if (alquiler.getTurismo().equals(turismo)) {

					throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
				}

			} else {
				
				if (alquiler.getCliente().equals(cliente) && (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)
						|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler))) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				}
				if (alquiler.getTurismo().equals(turismo) && (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)
						|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler))) {
					throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
				}
			}
		}
	}

	public void devolver(Alquiler alquiler , LocalDate fechaDevolucion) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		}

		if (Coleccionalquileres.contains(alquiler)) {
			
			alquiler.devolver(fechaDevolucion);
			
		}else {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}

	}

	public Alquiler buscar(Alquiler alquiler) {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}

		
		if (Coleccionalquileres.indexOf(alquiler) == -1) { 
											
			alquiler=null;  
		}else {
			Coleccionalquileres.get(Coleccionalquileres.indexOf(alquiler));
		}

		return alquiler; 

	}


    public void borrar(Alquiler alquiler) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}

		if (Coleccionalquileres.contains(alquiler)) { 
			Coleccionalquileres.remove(alquiler);
		}else {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}

		
	}

}
    