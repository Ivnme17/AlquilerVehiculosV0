package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {
    OPCION_1("Texto de la opción 1"),
    OPCION_2("Texto de la opción 2"),
    OPCION_3("Texto de la opción 3");

    private final String texto;

    Opcion(String texto) {
        this.texto = texto;
    }

    public static boolean esOrdinalValido(int ordinal) {
        return ordinal >= 0 && ordinal < values().length;
    }

    public static Opcion get(int ordinal) {
        if (esOrdinalValido(ordinal)) {
            return values()[ordinal];
        } else {
            throw new IllegalArgumentException("Ordinal inválido: " + ordinal);
        }
    }

    @Override
    public String toString() {
        return ordinal() + ": " + texto;
    }
}