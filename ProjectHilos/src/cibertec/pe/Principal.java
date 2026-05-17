package cibertec.pe;

public class Principal {
    public static void main(String[] args) {
        HilosNumeroLetra h1 = new HilosNumeroLetra(1);
        HilosNumeroLetra h2 = new HilosNumeroLetra(2);

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);

        t1.start();
        t2.start();

    }
}
