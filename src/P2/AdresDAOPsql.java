package P2;

import java.sql.*;
import java.util.List;

public class AdresDAOPsql implements AdresDAO {
    private Connection conn;
    private ReizigerDAO rdao;

    public ReizigerDAO getReizgerDAO() {
        return rdao;
    }

    @Override
    public boolean update(Adres adres) {
        Connection connection = Main.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE adres set adres_id=1, postcode=?, huisnummer=?,straat=?, woonplaats=?, reiziger_id=?");
            ps.setString(1, adres.getPostcode());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return false;
    }



    @Override
    public boolean delete(Adres adres) {
        Connection connection = Main.getConnection();
        try {
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("DELETE FROM adres WHERE adres_id=" + adres);

            if(i == 1) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        Connection connection = Main.getConnection();
        try {
            int adresId;
            String postcode;
            String huisnummer;
            String straat;
            String woonplaats;
            int reiziger_id;

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM adres WHERE reiziger_id=?");;
            ps.setString(1, reiziger.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                adresId = rs.getInt("adres_id");
                postcode = rs.getString("postcode");
                huisnummer = rs.getString("huisnummer");
                straat = rs.getString("straat");
                woonplaats = rs.getString("woonplaats");
                reiziger_id = rs.getInt("reiziger_id");

                System.out.println(adresId + "." + postcode + " " +  huisnummer + " " + straat + " " + woonplaats + " van reiziger: " + reiziger_id);
            }
            rs.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    }

    @Override
    public List<Adres> findAll() {
        Connection connection = Main.getConnection();
        try {
            int adresId;
            String postcode;
            String huisnummer;
            String straat;
            String woonplaats;
            int reiziger_id;

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM adres");
            while (rs.next()) {
                adresId = rs.getInt("adres_id");
                postcode = rs.getString("postcode");
                huisnummer = rs.getString("huisnummer");
                straat = rs.getString("straat");
                woonplaats = rs.getString("woonplaats");
                reiziger_id = rs.getInt("reiziger_id");

                System.out.println(adresId + "." + postcode + " " +  huisnummer + " " + straat + " " + woonplaats + " van reiziger: " + reiziger_id);
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean save(Adres adres) {
        Connection connection = Main.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO adres VALUES (NULL, ?, NULL, NULL, NULL)");
            ps.setString(1, adres.getPostcode());
            int execute = ps.executeUpdate();

            if(execute == 1) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}

