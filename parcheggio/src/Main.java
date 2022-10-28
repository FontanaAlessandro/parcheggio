import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Macchina[] parcheggio = new Macchina[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Inserisci targa " + (i + 1));
            parcheggio[i] = new Macchina(in.next(), System.currentTimeMillis());
        }
        System.out.println("Fai uscire un'auto");
        String exit = in.next();
        long secondi;
        int index = 0;
        for (Macchina macchina : parcheggio) {
            if (macchina != null) {
                System.out.println("In posizione " + index + " veicolo " + macchina.getTarga() + "al timestamp "+macchina.getIngresso().getTime());
                if (macchina.getTarga().equals(exit)) {
                    macchina.setUscita(System.currentTimeMillis());
                    secondi = (macchina.getUscita().getTime() - parcheggio[index])
                }
            }
        }
    }
}