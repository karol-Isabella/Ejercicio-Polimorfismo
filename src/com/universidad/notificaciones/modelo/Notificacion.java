package com.universidad.notificaciones.modelo;
import java.time.LocalDateTime;

import com.universidad.notificaciones.canales.CanalNotificacion;
import com.universidad.notificaciones.enums.EstadoNotificacion;
public abstract class Notificacion {

    private int codigo;
    private String destinatario;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private EstadoNotificacion estado;
    private CanalNotificacion canal;

    public Notificacion(){}

    public Notificacion (int codigo, String destinatario, LocalDateTime fechaEnvio, EstadoNotificacion estado, CanalNotificacion canal) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.fechaEnvio=fechaEnvio;
        this.estado=estado;
        this.canal=canal;
    }

    public int getCodigo (){
        return codigo;
    }
    public void setCodigo(int codigo){
        this.codigo=codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario){
        this.destinatario=destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }
    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public EstadoNotificacion getEstado() {
        return estado;
    }
    public void setEstado(EstadoNotificacion estado) {
        this.estado = estado;
    }

    public CanalNotificacion getCanal() {
        return canal;
    }

    public void setCanal(CanalNotificacion canal) {
        this.canal = canal;
    }
    public void enviar() {
        this.mensaje = generarMensaje(); // cada subclase define su mensaje
        canal.enviar(this); // usa el canal (polimorfismo)
        this.estado = EstadoNotificacion.ENVIADA;
        this.fechaEnvio = LocalDateTime.now();
    }

    public abstract String generarMensaje();

    @Override
    public String toString() {
        return "\n  codigo=" + codigo +
                "\n destinatario= " + destinatario +
                "\n mensaje= " + mensaje +
                "\n fechaEnvio= " + fechaEnvio +
                "\n estado= " + estado;
    }

}
