package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Artikal {
    private String sifra;
    private String naziv;
    private double cijena;


    public Artikal() {
    }

    public Artikal(String podatak){
        String[] artikal = podatak.split(",");
        sifra = artikal[0];
        naziv = artikal[1];
        cijena = Double.parseDouble(artikal[2]);
    }


    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        String sifra = this.sifra+","+naziv+","+cijena;
        return sifra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artikal)) return false;

        Artikal artikal = (Artikal) o;

        if (Double.compare(artikal.getCijena(), getCijena()) != 0) return false;
        if (getSifra() != null ? !getSifra().equals(artikal.getSifra()) : artikal.getSifra() != null) return false;
        return getNaziv() != null ? getNaziv().equals(artikal.getNaziv()) : artikal.getNaziv() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getSifra() != null ? getSifra().hashCode() : 0;
        result = 31 * result + (getNaziv() != null ? getNaziv().hashCode() : 0);
        temp = Double.doubleToLongBits(getCijena());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> artikli){
        for (int i = 0; i < artikli.size(); i++) {
            for (int j = i+1; j < artikli.size();j++) {
                if(artikli.get(i).equals(artikli.get(j)))artikli.remove(j);
            }
        }
        return artikli;
    }

}
