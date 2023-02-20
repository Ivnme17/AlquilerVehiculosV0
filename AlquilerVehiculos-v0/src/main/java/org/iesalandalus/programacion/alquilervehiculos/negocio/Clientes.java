package org.iesalandalus.programacion.alquilervehiculos.negocio;

import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.dominio.Cliente;

public class Clientes {
    private List<Cliente> lista;

    public Clientes() {
        lista = new ArrayList<>();
    }

    public List<Cliente> get() {
        return new ArrayList<>(lista);
    }

    public int getCantidad() {
        return lista.size();
    }

    public void insertar(Cliente cliente) {
        if (cliente != null && !lista.contains(cliente)) {
            lista.add(cliente);
        }
    }

    public Cliente buscar(Cliente cliente) {
    	if (cliente == null) {
    		throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
    	}
        int indice = lista.indexOf(cliente);
        if (indice != -1) {
            return lista.get(indice);
        }
        return null;
    }

    public void borrar(Cliente cliente) throws Exception {
        if (!lista.remove(cliente)) {
            throw new Exception("El cliente no existe en la lista");
        }
    }

    public void modificar(Cliente cliente, String nombre, String telefono) throws Exception {
        if (cliente != null && lista.contains(cliente)) {
            if (nombre != null && !nombre.isBlank()) {
                cliente.setNombre(nombre);
            }
            if (telefono != null && !telefono.isBlank()) {
                cliente.setTelefono(telefono);
            }
        } else {
            throw new Exception("El cliente no existe en la lista");
        }
    }
}