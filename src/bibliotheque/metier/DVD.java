package bibliotheque.metier;

import java.time.LocalTime;
import java.util.List;

public class DVD extends Ouvrage{
    private long code;
    private LocalTime dureeTotal;
    private byte nbreBonus;
    private List<String> autresLangues;
    private List<String> sousTitres;
    public DVD(){

    }

    public DVD(long code, LocalTime dureeTotal, byte nbreBonus, List<String> autresLangues, List<String> sousTitres) {
        this.code = code;
        this.dureeTotal = dureeTotal;
        this.nbreBonus = nbreBonus;
        this.autresLangues = autresLangues;
        this.sousTitres = sousTitres;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public LocalTime getDureeTotal() {
        return dureeTotal;
    }

    public void setDureeTotal(LocalTime dureeTotal) {
        this.dureeTotal = dureeTotal;
    }

    public byte getNbreBonus() {
        return nbreBonus;
    }

    public void setNbreBonus(byte nbreBonus) {
        this.nbreBonus = nbreBonus;
    }

    public List<String> getAutresLangues() {
        return autresLangues;
    }

    public void setAutresLangues(List<String> autresLangues) {
        this.autresLangues = autresLangues;
    }

    public List<String> getSousTitres() {
        return sousTitres;
    }

    public void setSousTitres(List<String> sousTitres) {
        this.sousTitres = sousTitres;
    }
    public double amendeRetard(int njours){
        return 0;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "code=" + code +
                ", dureeTotal=" + dureeTotal +
                ", nbreBonus=" + nbreBonus +
                ", autresLangues=" + autresLangues +
                ", sousTitres=" + sousTitres +
                '}';
    }
}
