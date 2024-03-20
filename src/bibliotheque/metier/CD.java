package bibliotheque.metier;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class CD extends Ouvrage{
    private long code;
    private byte nbrePlages;
    private String dureeTotal;
    public CD(){

    }

    public CD(String titre, byte ageMin, LocalDate dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre, long code, byte nbrePlages, String dureeTotal) {
        super(titre, ageMin, dateParution, typeOuvrage, prixLocation, langue, genre);
        this.code = code;
        this.nbrePlages = nbrePlages;
        this.dureeTotal = dureeTotal;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public byte getNbrePlages() {
        return nbrePlages;
    }

    public void setNbrePlages(byte nbrePlages) {
        this.nbrePlages = nbrePlages;
    }

    public String getDureeTotal() {
        return dureeTotal;
    }

    public void setDureeTotal(String dureeTotal) {
        this.dureeTotal = dureeTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CD cd = (CD) o;
        return code == cd.code;
    }


    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    public double amendeRetard(int njours){
        return 0;
    }

    @Override
    public String toString() {
        return super.toString()+
                "CD{" +
                "code=" + code +
                ", nbrePlages=" + nbrePlages +
                ", dureeTotal=" + dureeTotal +
                "} "+
                super.toString();
    }
}
