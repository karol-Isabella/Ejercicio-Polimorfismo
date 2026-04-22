package com.universidad.notificaciones.main;


import java.time.LocalDateTime;
import java.util.Scanner;

import com.universidad.notificaciones.modelo.*;
import com.universidad.notificaciones.canales.*;
import com.universidad.notificaciones.enums.EstadoNotificacion;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== SISTEMA DE NOTIFICACIONES ===");

        System.out.println("Seleccione tipo de notificación:");
        System.out.println("1. Publicación de calificaciones");
        System.out.println("2. Cancelación de clase");
        System.out.println("3. Recordatorio pago matrícula");
        System.out.println("4. Confirmación de evento");

        int tipo = sc.nextInt();
        sc.nextLine();


        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Destinatario: ");
        String destinatario = sc.nextLine();


        System.out.println("Seleccione canal:");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. Push");

        int canalOpcion = sc.nextInt();
        sc.nextLine();

        CanalNotificacion canal = null;

        switch (canalOpcion) {
            case 1:
                System.out.print("Correo destino: ");
                String correo = sc.nextLine();
                System.out.print("Asunto: ");
                String asunto = sc.nextLine();
                canal = new EmailNotificacion(correo, asunto);
                break;

            case 2:
                System.out.print("Número teléfono: ");
                String numero = sc.nextLine();
                canal = new SMSNotificacion(numero);
                break;

            case 3:
                System.out.print("Token dispositivo: ");
                String token = sc.nextLine();
                canal = new PushAppNotificacion(token);
                break;
        }

        Notificacion notificacion = null;

        switch (tipo) {

            case 1:
                System.out.print("Curso: ");
                String curso = sc.nextLine();
                System.out.print("Nota: ");
                double nota = sc.nextDouble();

                notificacion = new PublicacionCalificaciones(
                        curso, nota,
                        codigo, destinatario,
                        null, EstadoNotificacion.PENDIENTE, canal
                );
                break;

            case 2:
                System.out.print("Materia: ");
                String materia = sc.nextLine();
                System.out.print("Motivo: ");
                String motivo = sc.nextLine();

                notificacion = new CancelacionClase(
                        motivo, materia,
                        codigo, destinatario,
                        null, EstadoNotificacion.PENDIENTE, canal
                );
                break;

            case 3:
                System.out.print("Valor: ");
                double valor = sc.nextDouble();
                sc.nextLine();

                System.out.print("Fecha límite (YYYY-MM-DDTHH:MM): ");
                String fechaTexto = sc.nextLine();
                LocalDateTime fechaLimite = LocalDateTime.parse(fechaTexto);

                notificacion = new RecordatorioPagoMatricula(
                        fechaLimite, valor,
                        codigo, destinatario,
                        null, EstadoNotificacion.PENDIENTE, canal
                );
                break;

            case 4:
                System.out.print("Nombre evento: ");
                String nombre = sc.nextLine();

                System.out.print("Fecha (YYYY-MM-DDTHH:MM): ");
                String fechaEv = sc.nextLine();
                LocalDateTime fechaEvento = LocalDateTime.parse(fechaEv);

                System.out.print("Lugar: ");
                String lugar = sc.nextLine();

                notificacion = new ConfirmacionEvento(
                        nombre, fechaEvento, lugar,
                        codigo, destinatario,
                        null, EstadoNotificacion.PENDIENTE, canal
                );
                break;
        }


        if (notificacion != null) {
            notificacion.enviar();
            System.out.println("\n--- RESULTADO ---");
            System.out.println(notificacion);
        } else {
            System.out.println("Error al crear la notificación.");
        }

        sc.close();
    }
}
