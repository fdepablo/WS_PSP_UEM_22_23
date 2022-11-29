package Hilos;

public abstract class Hilo implements Runnable {
    protected int valorInicial;

    public Hilo(BufferEmails buffer, String nombre) {
        this.buffer = buffer;
        this.nombre = nombre;
    }

    protected BufferEmails buffer;
    protected String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BufferEmails getBuffer() {
        return buffer;
    }

    public void setBuffer(BufferEmails buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

    }
}
