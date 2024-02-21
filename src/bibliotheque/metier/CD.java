package bibliotheque.metier;

import java.time.LocalTime;

public class CD extends Ouvrage{
    private long code;
    private byte nbrePlages;
    private LocalTime dureeTotal;
    public CD(){

    }

    public CD(long code, byte nbrePlages, LocalTime dureeTotal) {
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

    public LocalTime getDureeTotal() {
        return dureeTotal;
    }

    public void setDureeTotal(LocalTime dureeTotal) {
        this.dureeTotal = dureeTotal;
    }

    public double amendeRetard(int njours){
        return 0;
    }

    @Override
    public String toString() {
        return "CD{" +
                "code=" + code +
                ", nbrePlages=" + nbrePlages +
                ", dureeTotal=" + dureeTotal +
                '}';
    }
}
