package com.universidad.notificaciones.modelo;

import java.time.LocalDateTime;
import com.universidad.notificaciones.enums.EstadoNotificacion;
import com.universidad.notificaciones.canales.CanalNotificacion;

public class PublicacionCalificaciones extends Notificacion {

    private String curso;
    private double nota;


    public PublicacionCalificaciones() {
        super();
    }

    public PublicacionCalificaciones(String curso, double nota, int codigo, String destinatario, LocalDateTime fechaEnvio, EstadoNotificacion estado, CanalNotificacion canal) {

        super(codigo, destinatario, fechaEnvio, estado, canal);
        this.curso = curso;
        this.nota = nota;
    }


    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }


    @Override
    public String generarMensaje() {
        return "Se han publicado tus calificaciones. Curso: " + curso +
                ", Nota: " + nota;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n  curso= " + curso +
                "\n  nota= " + nota;
    }
}
