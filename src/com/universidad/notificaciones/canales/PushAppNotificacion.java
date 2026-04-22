package com.universidad.notificaciones.canales;
import com.universidad.notificaciones.modelo.Notificacion;

public class PushAppNotificacion implements CanalNotificacion {

    private String tokenDispositivo;

    public PushAppNotificacion(String tokenDispositivo) {
        this.tokenDispositivo = tokenDispositivo;
    }

    public String getTokenDispositivo() {
        return tokenDispositivo;
    }

    public void setTokenDispositivo(String tokenDispositivo) {
        this.tokenDispositivo = tokenDispositivo;
    }

    @Override
    public void enviar(Notificacion notificacion) {
        System.out.println("Enviando PUSH al dispositivo: " + tokenDispositivo);
        System.out.println("Mensaje: " + notificacion.getMensaje());
    }

    @Override
    public String toString() {
        return "PushAppNotificacion{" +
                "tokenDispositivo= " + tokenDispositivo +
                '}';
    }
}
