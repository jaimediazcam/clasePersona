/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepersona2;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author jaime
 */
public class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos) {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
    }

    public Persona(String nombre, String apellidos, String fechaNacimiento) throws
            IllegalArgumentException {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);
        }

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento(char separador) {
        String fecha = null;
        if (separador != '-' && separador != '/') {
            throw new IllegalArgumentException();
        } else {
            if (this.fechaNacimiento != null) {
                fecha = String.format("%02d%c%02d%c%04d", this.fechaNacimiento.getDayOfMonth(),
                        separador,
                        this.fechaNacimiento.getMonthValue(), separador, this.fechaNacimiento.getYear());
            }
            return fecha;
        }
    }

    public String getFechaNacimiento() {
        return getFechaNacimiento('-');
    }

    public void setFechaNacimiento(String fechaNacimiento) throws IllegalArgumentException {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }

    private LocalDate generarFecha(String fecha) {
        int dia;
        int mes;
        int anyo;
        if (!fecha.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")
                && !fecha.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")) {
            throw new IllegalArgumentException();
        } else {
            try {
                dia = Integer.parseInt(fecha.subSequence(0, 2).toString());
                mes = Integer.parseInt(fecha.subSequence(3, 5).toString());
                anyo = Integer.parseInt(fecha.subSequence(6, fecha.length()).toString());
                return LocalDate.of(anyo, mes, dia);
            } catch (NumberFormatException | DateTimeException ex1) {
                throw new IllegalArgumentException();
            }
        }
    }
}