
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parcheggio p = new Parcheggio();
        String scelta;

        do {
            System.out.println();
            System.out.println("a = aggiungi auto");
            System.out.println("r = rimuovi auto");
            System.out.println("s = ottieni statistiche");
            System.out.println("esci = esci dal programma");
            System.out.println();
            scelta = in.next();

            if (scelta.toUpperCase().equals("A")) {

                try {
                    System.out.println("Inserire targa:");
                    String targa1 = in.next();
                    p.aggiungiMacchina(new Macchina(targa1, System.currentTimeMillis()));

                } catch (ParcheggioPienoException | StessaMacchinaException e) {
                    System.out.println("[[[ERRORE " + e.getMessage());

                }
            }
            else if (scelta.toUpperCase().equals("R")) {

                System.out.println("Inserire targa:");
                long secondi = 0;

                try {
                    secondi = p.rimuoviMacchina(in.next());
                } catch (MacchinaNonEsistenteException | ParcheggioVuotoException e) {
                    System.out.println("[[[ERRORE " + e.getMessage());
                }

                System.out.println("sono passati " + secondi + " secondi da quando il veicolo è entrato nel parcheggio");
            }
            else if (scelta.toUpperCase().equals("S")) {
                long millis = System.currentTimeMillis();
                System.out.println("Statistiche: ");
                p.getStats(millis);
            }
            else if (scelta.toUpperCase().equals("ESCI")) {
                System.exit(0);
            }

        }while(true);

    }
}