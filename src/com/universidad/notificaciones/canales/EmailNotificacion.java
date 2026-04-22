package com.universidad.notificaciones.canales;

import com.universidad.notificaciones.modelo.Notificacion;

public class EmailNotificacion implements CanalNotificacion {

    private String correoDestino;
    private String asunto;


    public EmailNotificacion(String correoDestino, String asunto) {
        this.correoDestino = correoDestino;
        this.asunto = asunto;
    }


    public String getCorreoDestino() {
        return correoDestino;
    }

    public void setCorreoDestino(String correoDestino) {
        this.correoDestino = correoDestino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @Override
    public void enviar(Notificacion notificacion) {
        System.out.println("Enviando EMAIL a: " + correoDestino);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + notificacion.getMensaje());
    }

    @Override
    public String toString() {
        return "EmailNotificacion{" +
                "correoDestino= " + correoDestino +
                "\n  asunto= " + asunto +
                '}';
    }
}
