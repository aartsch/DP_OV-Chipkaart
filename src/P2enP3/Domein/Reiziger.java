package P2enP3.Domein;

import P4.Domein.OVChipkaart;

import java.sql.Date;
import java.util.List;

public class Reiziger {
    private Adres adres;
    private List<OVChipkaart> ovChipkaarten;
    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;


    public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.id = id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public String getVoorletters() {
        return voorletters;
    }
    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Adres getAdres() {
        return adres;
    }

    public String getNaam() {
        return achternaam;
    }

    public void addOvChipkaart(OVChipkaart ovChipkaart) {
        ovChipkaarten.add(ovChipkaart);
    }

    public void deleteOvChipkaart(OVChipkaart ovChipkaart) {
        for(OVChipkaart i : ovChipkaarten) {
            if(i == ovChipkaart) {
                ovChipkaarten.remove(i);
            }
        }
    }

    public OVChipkaart getOvChipkaarten() {
        return (OVChipkaart) ovChipkaarten;
    }

    public void setOvChipkaarten(List<OVChipkaart> ovChipkaarten) {
        this.ovChipkaarten = ovChipkaarten;
    }

    public String toString() {
        return "Reiziger{" +
                "id=" + id +
                ", voorletters='" + voorletters + '\'' +
                ", tussenvoegsel='" + tussenvoegsel + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", geboortedatum=" + geboortedatum +
                " " + adres + " " + ovChipkaarten ;
    }
}
