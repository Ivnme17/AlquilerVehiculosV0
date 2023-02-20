package org.iesalandalus.programacion.alquilervehiculos.dominio;

	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.util.Objects;

	public class Alquiler {
	public DateTimeFormatter FORMATO_FECHA;
	private  int PRECIO_DIA;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Turismo turismo;

	public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
	}
	public Alquiler(Alquiler alquiler) { //Constructor copia llamando a los  constructores copia de la clase turismo y cliente
	   this(new Cliente(alquiler.getCliente()), new Turismo(alquiler.getTurismo()), alquiler.getFechaAlquiler());	
	}
	private void setFechaAlquiler(LocalDate fechaAlquiler) {
		if(fechaAlquiler == null) {
			throw new NullPointerException("ERROR: La fecha no puede ser nula.");
		}
		LocalDate hoy = LocalDate.now();
	    if (fechaAlquiler.isAfter(hoy)) {
	      throw new IllegalArgumentException("La fecha de alquiler no puede ser posterior a hoy");
	    }
		this.fechaAlquiler = fechaAlquiler;
	}

	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		LocalDate hoy = LocalDate.now();
	    if (fechaDevolucion.isBefore(fechaAlquiler) || fechaDevolucion.isAfter(hoy)) {
	      throw new IllegalArgumentException("La fecha de devolución no es adecuada");
	    }
		this.fechaDevolucion = fechaDevolucion;
	}
	  public void devolver(LocalDate fechaDevolucion) throws IllegalArgumentException {
		    setFechaDevolucion(fechaDevolucion);
		  }

	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private void setTurismo(Turismo turismo) {
		this.turismo = turismo;
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Turismo getTurismo() {
		return turismo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, fechaDevolucion, turismo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(fechaDevolucion, other.fechaDevolucion) && Objects.equals(turismo, other.turismo);
	}
	@Override
	public String toString() {
		return String.format(
				"Alquiler [FORMATO_FECHA=%s, PRECIO_DIA=%s, fechaAlquiler=%s, fechaDevolucion=%s, cliente=%s, turismo=%s]",
				FORMATO_FECHA, PRECIO_DIA, fechaAlquiler, fechaDevolucion, cliente, turismo);
	}

}

