package com.universidad.notificaciones.modelo;

import java.time.LocalDateTime;
import com.universidad.notificaciones.enums.EstadoNotificacion;
import com.universidad.notificaciones.canales.CanalNotificacion;

public class ConfirmacionEvento extends Notificacion {

    private String nombreEvento;
    private LocalDateTime fecha;
    private String lugar;

    public ConfirmacionEvento() {
        super();
    }

    public ConfirmacionEvento(String nombreEvento, LocalDateTime fecha, String lugar, int codigo, String destinatario, LocalDateTime fechaEnvio, EstadoNotificacion estado, CanalNotificacion canal) {
        super(codigo, destinatario, fechaEnvio, estado, canal);
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String generarMensaje() {
        return "Inscripción confirmada al evento: " + nombreEvento +
                " el día " + fecha + " en " + lugar;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n  nombreEvento= " + nombreEvento +
                "\n  fecha= " + fecha +
                "\n  lugar= " + lugar;
    }
}
