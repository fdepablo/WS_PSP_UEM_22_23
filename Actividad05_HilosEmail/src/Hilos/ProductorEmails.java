package Hilos;

public class ProductorEmails extends Hilo {

    public ProductorEmails(BufferEmails buffer, String nombre, int valorInicial) {
        super(buffer, nombre);
        this.valorInicial = valorInicial;
    }

    @Override
    public void run() {
        for (int i = valorInicial-9; i < valorInicial+1; i++) {
            buffer.agregarMensaje(this.crearEmail(i),nombre);
        }
    }

    public Email crearEmail(int id) {
        Email aux = new Email(id, "pibe@gmail.com", "tratamiento de hilos", "Este mensaje es el correo con el identificador unico " + id  + " creado por el " + nombre, "Este mail es un ejemplo");
        String email = "----------------------------------------------------------\nID: " +
                aux.getId() + "\nDestinatario: " +
                aux.getDestinatario() + "\nRemitente: " +
                aux.getRemitente() + "\nAsunto: "+
                aux.getAsunto() + "\nCuerpo del texto: " +
                aux.getCuerpoTxt() + "\n" +
                "---------- Email creado en buffer por " + nombre + "------------------";
        System.out.println(email);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return aux;
    }

}
