import java.sql.Timestamp;

public class Macchina {
    private String targa;
    Timestamp ingresso, uscita;

    public Macchina(String targa, long ingresso) {
        this.targa = targa;
        this.ingresso = new Timestamp(ingresso);
        System.out.println("Ingresso veicolo " + targa + " al timestamp " + this.ingresso);
    }

    public void setUscita(Timestamp uscita) {
        this.uscita = uscita;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }

    public Timestamp getIngresso() {
        return ingresso;
    }

    public Timestamp getUscita() {
        return uscita;
    }
}
