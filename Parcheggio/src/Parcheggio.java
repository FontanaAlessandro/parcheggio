
public class Parcheggio {
    private final Macchina[] parcheggio;
    private int nAuto = 0;
    private int pos = 0;


    public Parcheggio() {parcheggio = new Macchina[15];}


    public void aggiungiMacchina(Macchina m) throws ParcheggioPienoException, StessaMacchinaException {

        if (nAuto == 15) {
            throw new ParcheggioPienoException("PARCHEGGIO PIENO]]]");
        }
        
        for (int i = 0; i < 10; i++) {
            if (parcheggio[i] != null && m.getTarga().equals(parcheggio[i].getTarga())) {
                throw new StessaMacchinaException("VEICOLO GIA NEL PARCHEGGIO]]]");
            }
        }
        parcheggio[pos] = m;
        
        nAuto++;
        for (int i = pos; i < 10; i++) {
            if(parcheggio[i] == null) {
                pos = i;
                break;
            }
        }
    }


    public int rimuoviMacchina(String targa) throws MacchinaNonEsistenteException, ParcheggioVuotoException {

        boolean check = false;
        
        if (nAuto == 0) {
            throw new ParcheggioVuotoException("IL PARCHEGGIO E VUOTO]]]");
        }


        for (int i = 0; i < 10; i++) {
            if (parcheggio[i] != null && targa.equals(parcheggio[i].getTarga())) {
                check = true;
                break;
            }
        }

        if (!check) {
            throw new MacchinaNonEsistenteException("IL VEICOLO NON ESISTE]]]");
        }

        int time = 0;
        int i2 = 0;

        for (int i = 0; i < parcheggio.length; i++) {

            if (parcheggio[i] != null) {
                System.out.println("In posizione " + i + " veicolo " + parcheggio[i].getTarga() + " entrato al timestamp: " + parcheggio[i].getIngresso());

                if (parcheggio[i].getTarga().equals(targa)) {
                    parcheggio[i].setUscita(System.currentTimeMillis());
                    time = (int) ((parcheggio[i].getUscita().getTime() - parcheggio[i].getIngresso().getTime()) / 1000);
                    i2 = i;
                }
            }
        }

        parcheggio[i2] = null;
        nAuto--;

        if(pos > i2) {
            pos = i2;
        }

        return time;
    }
    

    public void getStats(long l) {

        if(nAuto == 0) {
            System.out.println("Parcheggio vuoto");
        } else {
            long l2 = 0;

            for (int i = 0; i < 10; i++) {
                if (parcheggio[i] != null) {
                    l2 += (l - parcheggio[i].getIngresso().getTime());
                }

            }

            System.out.println("Numero di veicoli nel parcheggio = " + nAuto);

            for (int i = 0; i < parcheggio.length; i++) {
                if (parcheggio[i] != null) {
                    System.out.println("In posizione " + i + " veicolo " + parcheggio[i].getTarga() + " entrato al timestamp: " + parcheggio[i].getIngresso());
                }
            }

            System.out.println("Il tempo medio di permanenza nel parcheggio è di " + (l2 / nAuto) / 1000 + " secondi.");

        }
    }
}