package P5.Domein;

import P4.Domein.OVChipkaart;

import java.util.List;

public class Product {
    private int productNummer;
    private String naam;
    private String beschrijving;
    private int prijs;
    private List<OVChipkaart>  ovChipkaarten;

    public Product(int productNummer, String naam, String beschrijving, int prijs) {
        this.productNummer = productNummer;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

    public int getProductNummer() {
        return productNummer;
    }

    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public void addOvChipkaart(OVChipkaart ovChipkaart) {
        ovChipkaarten.add(ovChipkaart);
    }

    public void deleteOvChipkaart(OVChipkaart ovChipkaart) {
        ovChipkaarten.remove(ovChipkaart);
    }

    public List<OVChipkaart> getOvChipkaarten() {
        return ovChipkaarten;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productNummer=" + productNummer +
                ", naam='" + naam + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", prijs=" + prijs +
                ", ovChipkaart=" + ovChipkaarten +
                '}';
    }
}
