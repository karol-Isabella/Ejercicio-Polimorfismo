package com.universidad.notificaciones.canales;
import com.universidad.notificaciones.modelo.Notificacion;

public class SMSNotificacion implements CanalNotificacion {

    private String numeroTelefono;

    public SMSNotificacion(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public void enviar(Notificacion notificacion) {
        System.out.println("Enviando SMS a: " + numeroTelefono);
        System.out.println("Mensaje: " + notificacion.getMensaje());
    }

    @Override
    public String toString() {
        return "SMSNotificacion{" +
                "numeroTelefono= " + numeroTelefono  +
                '}';
    }
}
