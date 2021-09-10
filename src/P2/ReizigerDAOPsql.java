package P2;

import java.sql.*;
import java.util.List;

public abstract class ReizigerDAOPsql implements ReizigerDAO {


    @Override
    public List<Reiziger> findAll() {
        Connection connection = Main.getConnection();
        try {
            int reizigerId;
            String voorletters;
            String tussenvoegsel;
            String achternaam;
            Date geboortedatum;

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM reiziger");
            while (rs.next()) {
                reizigerId = rs.getInt("reiziger_id");
                voorletters = rs.getString("voorletters");
                tussenvoegsel = rs.getString("tussenvoegsel");
                achternaam = rs.getString("achternaam");
                geboortedatum = rs.getDate("geboortedatum");
                System.out.println(reizigerId + "." + voorletters + " " + tussenvoegsel + " " + achternaam + " " + geboortedatum);
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
    public List<Reiziger> findByGbdatum(String datum) {
        Connection connection = Main.getConnection();
        try {
            int reizigerId;
            String voorletters;
            String tussenvoegsel;
            String achternaam;
            Date geboortedatum;

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM reiziger WHERE geboortedatum=?");
            ps.setString(1, datum);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                reizigerId = rs.getInt("reiziger_id");
                voorletters = rs.getString("voorletters");
                tussenvoegsel = rs.getString("tussenvoegsel");
                achternaam = rs.getString("achternaam");
                geboortedatum = rs.getDate("geboortedatum");
                System.out.println(reizigerId + "." + voorletters + " " + tussenvoegsel + " " + achternaam + " " + geboortedatum);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

        @Override
    public Reiziger findById(int id) {
            Connection connection = Main.getConnection();
            try {
                int reizigerId;
                String voorletters;
                String tussenvoegsel;
                String achternaam;
                Date geboortedatum;

                PreparedStatement ps = connection.prepareStatement("SELECT * FROM reiziger WHERE reiziger_id=?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    reizigerId = rs.getInt("reiziger_id");
                    voorletters = rs.getString("voorletters");
                    tussenvoegsel = rs.getString("tussenvoegsel");
                    achternaam = rs.getString("achternaam");
                    geboortedatum = rs.getDate("geboortedatum");
                    System.out.println(reizigerId + "." + voorletters + " " + tussenvoegsel + " " + achternaam + " " + geboortedatum);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return null;

        }

    @Override
    public boolean delete(Reiziger reiziger) {
        Connection connection = Main.getConnection();
        try {
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("DELETE FROM reiziger WHERE reiziger_id=" + reiziger);

            if(i == 1) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Reiziger reiziger) {
        Connection connection = Main.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE reiziger set reiziger_id=?, voorletters=?, tussenvoegsel=?,achternaam=?, geboortedatum=?");
            ps.setString(1, reiziger.getNaam());

            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
        }

    } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return false;}

        @Override
    public boolean save(Reiziger reiziger) {
        Connection connection = Main.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO reiziger VALUES (?, NULL, NULL, NULL, NULL)");
            ps.setString(1, reiziger.getNaam());
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
