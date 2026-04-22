package com.universidad.notificaciones.modelo;

import java.time.LocalDateTime;
import com.universidad.notificaciones.enums.EstadoNotificacion;
import com.universidad.notificaciones.canales.CanalNotificacion;

public class CancelacionClase extends Notificacion {

    private String motivo;
    private String materia;

    public CancelacionClase() {
        super();
    }

    public CancelacionClase(String motivo, String materia, int codigo, String destinatario, LocalDateTime fechaEnvio, EstadoNotificacion estado, CanalNotificacion canal) {
        super(codigo, destinatario, fechaEnvio, estado, canal);
        this.motivo = motivo;
        this.materia = materia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String generarMensaje() {
        return "La clase de " + materia + " ha sido cancelada. Motivo: " + motivo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n  materia= " + materia  +
                "\n  motivo= " + motivo;
    }
}
