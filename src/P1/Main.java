package P1;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String url = "jbdc:postgresql://localhost/bedrijf?user=postgres&pzassword=password";

        try {
            Connection conn = DriverManager.getConnection(url);

            Statement st = conn.createStatement();
            String query = "SELECT * from Reiziger";
            //select

            String achternaam;
            String voorletters;
            Date geboortedatum;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                voorletters = rs.getString("voorletters");
                achternaam = rs.getString("achternaam");
                geboortedatum = rs.getDate("geboortedatum");
                System.out.println(voorletters + "." + achternaam + " " + geboortedatum);
            }
            rs.close();
            st.close();
            conn.close();

        }
        catch (SQLException sqlex) {
            System.err.println("SQLException 1" + sqlex.getMessage());
        }
    }
}
