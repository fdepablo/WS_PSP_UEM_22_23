package Hilos;

import java.util.LinkedList;
import java.util.Queue;

public class BufferEmails {
    private Queue<Email> emailEnBuffer;


    public BufferEmails() {
        emailEnBuffer = new LinkedList<>();
    }

    public Queue<Email> getEmailsEnBuffer() {
        return emailEnBuffer;
    }

    public synchronized void agregarMensaje(Email email, String nombre) {

        while (emailEnBuffer.size() > 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (email.getDestinatario().equalsIgnoreCase("pikachu@gmail.com")) {
            System.out.println("\nALERTA!!!!\nDestinatario prohibido, se ha bloqueado el deposito del email en el buffer por el hilo " + nombre + "\n" +
                    "El email se ha borrado y el hilo prosigue con sus tareas de consumir emails\n");
        } else {
            emailEnBuffer.add(email);
        }
        notify();
    }

    public synchronized String consumirMensaje(String nombre) {
        while (emailEnBuffer.size() == 0) {
            try {

                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Email aux = emailEnBuffer.poll();
        String email = "-------------------------------------------------------------------\nID: " +
                aux.getId() + "\nDestinatario: " +
                aux.getDestinatario() + "\nRemitente: " +
                aux.getRemitente() + "\nAsunto: " +
                aux.getAsunto() + "\nCuerpo del texto: " +
                aux.getCuerpoTxt() + "\n" +
                "---------- Email consumido del buffer por " + nombre + "------------------";

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        notify();

        return email;
    }

}
