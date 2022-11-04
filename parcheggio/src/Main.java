import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner tastiera = new Scanner(System.in);

        Parcheggio p = new Parcheggio();
        String scelta;
        int posizione = 0;
        System.out.println("inserire targa o x per uscire");
        scelta = tastiera.next();
        try {
            while (!scelta.equals("x")) {
                p.aggiungiMacchina(new Macchina(scelta,
                        System.currentTimeMillis()), posizione);
                posizione++;
                System.out.println("\n\ninserire targa o x per uscire");
                scelta = tastiera.next();
            }
        } catch (ParcheggioPienoException | MacchinaGiaEntrataException e) {
            System.out.println("errore: " + e.getMessage());
        }

        System.out.println("che macchina vuoi far uscire");
        long secondi = p.rimuoviMacchina(tastiera.next());
        System.out.println("sono passati " + secondi);
    }
}