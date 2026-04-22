package com.universidad.notificaciones.canales;

import com.universidad.notificaciones.modelo.Notificacion;

public interface CanalNotificacion {

    void enviar(Notificacion notificacion);

}
