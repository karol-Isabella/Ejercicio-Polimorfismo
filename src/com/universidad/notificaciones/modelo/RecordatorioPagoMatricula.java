package com.universidad.notificaciones.modelo;

import java.time.LocalDateTime;
import com.universidad.notificaciones.enums.EstadoNotificacion;
import com.universidad.notificaciones.canales.CanalNotificacion;

public class RecordatorioPagoMatricula extends Notificacion {

    private LocalDateTime fechaLimite;
    private double valor;

    public RecordatorioPagoMatricula() {
        super();
    }

    public RecordatorioPagoMatricula(LocalDateTime fechaLimite, double valor, int codigo, String destinatario, LocalDateTime fechaEnvio, EstadoNotificacion estado, CanalNotificacion canal) {
        super(codigo, destinatario, fechaEnvio, estado, canal);
        this.fechaLimite = fechaLimite;
        this.valor = valor;
    }

    public LocalDateTime getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDateTime fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String generarMensaje() {
        return "Recuerda pagar tu matrícula antes de " + fechaLimite +
                ". Valor: $" + valor;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n  fechaLimite= " + fechaLimite +
                "\n  valor= " + valor;
    }
}

