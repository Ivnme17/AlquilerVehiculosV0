package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos {

    private List<Turismo> coleccionTurismos;

    public Turismos() {
        this.coleccionTurismos = new ArrayList<>();
    }

    public List<Turismo> get() {
        return new ArrayList<>(coleccionTurismos);
    }

    public int getCantidad() {
        return coleccionTurismos.size();
    }

    public void insertar(Turismo turismo) throws OperationNotSupportedException {
    	 if (turismo == null) {
         	throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
         }
    	if (turismo != null && !coleccionTurismos.contains(turismo)) {
            coleccionTurismos.add(turismo);
            }else { throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
            }
        }

    public Turismo buscar(Turismo turismo) {
        int index = coleccionTurismos.indexOf(turismo);
        if (index >= 0) {
            return coleccionTurismos.get(index);
        }else if (turismo==null){
            throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
        }
		return null;
    }

    public void borrar(Turismo turismo) throws OperationNotSupportedException {
    	if (turismo == null) {
        	throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
        }
    
    	if (!coleccionTurismos.remove(turismo)) {
            throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula."); 
}
}
}