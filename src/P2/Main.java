package P2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

    }
    private static void testReizigerDAO(ReizigerDAO rdao) throws SQLException {
        System.out.println("\n---------- Test ReizigerDAO -------------");

        // Haal alle reizigers op uit de database
        List<Reiziger> reizigers = rdao.findAll();
        System.out.println("[Test] ReizigerDAO.findAll() geeft de volgende reizigers:");
        for (Reiziger r : reizigers) {
            System.out.println(r);
        }
        System.out.println();

        // Maak een nieuwe reiziger aan en persisteer deze in de database
        String gbdatum = "1981-03-14";
        Reiziger sietske = new Reiziger(77, "S", "", "Boers", java.sql.Date.valueOf(gbdatum));
        System.out.print("[Test] Eerst " + reizigers.size() + " reizigers, na ReizigerDAO.save() ");
        rdao.save(sietske);
        reizigers = rdao.findAll();
        System.out.println(reizigers.size() + " reizigers\n");

        // Voeg aanvul
    }

    private static void testAdresDAO(AdresDAO adao) throws SQLException {
        System.out.println("\n---------- Test AdresDAO -------------");


        List<Adres> adres = adao.findAll();
        System.out.println("[Test] adresDAO.findAll() geeft de volgende Adressen:");
        for (Adres a : adres) {
            System.out.println(a);
        }
        System.out.println();

        Adres zuidzijde= new Adres(1, "3405CM");
        System.out.print("[Test] Eerst " + adres.size() + " adresseen, na ReizigerDAO.save() ");
        adao.save(zuidzijde);
        adres = adao.findAll();
        System.out.println(adres.size() + "adres\n");

        // Voeg aanvul
    }
}

