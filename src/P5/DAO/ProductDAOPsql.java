package P5.DAO;

import P2enP3.Domein.Reiziger;
import P4.DAO.OVChipkaartDAO;
import P4.DAO.OVChipkaartDAOPsql;
import P4.Domein.OVChipkaart;
import P5.Domein.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOPsql implements ProductDAO {
    private Connection conn;
    private OVChipkaartDAO odao;

    public ProductDAOPsql(Connection conn) {
        this.conn = conn;

    }

    @Override
    public boolean save(Product product) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?)");
            ps.setInt(1, product.getProductNummer());
            ps.setString(2, product.getNaam());
            ps.setString(3, product.getBeschrijving());
            ps.setInt(4, product.getPrijs());
            int execute = ps.executeUpdate();

            if (execute == 1) {
                product.addOvChipkaart(((OVChipkaart) product.getOvChipkaarten()).getKaartNummer());
                odao.save((OVChipkaart) product.getOvChipkaarten());
                ((OVChipkaart) product.getOvChipkaarten()).addProduct(product);
                ps.close();
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE product SET VALUES (?, ?, ?, ?)");
            ps.setInt(1, product.getProductNummer());
            ps.setString(2, product.getNaam());
            ps.setString(3, product.getBeschrijving());
            ps.setInt(4, product.getPrijs());

            OVChipkaart op1 = (OVChipkaart) product.getOvChipkaarten();
            odao.update(op1);

            // Bij de opdracht staat dat je hier aanzienlijk meer code moet schrijven maar ik zie niet waarom dit nodig is
            int execute = ps.executeUpdate();

            if (execute == 1) {
                ps.close();
                return true;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Product product) {
        try {
            Statement statement = conn.createStatement();
            int i = statement.executeUpdate("DELETE FROM product WHERE product_nummer=" + product.getProductNummer());

            if (i == 1) {
                odao.delete((OVChipkaart) product.getOvChipkaarten());
                product.deleteOvChipkaart(((OVChipkaart) product.getOvChipkaarten()).getKaartNummer());
                statement.close();
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findByOvchipkaart(OVChipkaart ovChipkaart) {
        List<Product> producten = new ArrayList<Product>();
        try {
            int productNummer;
            String naam;
            String beschrijving;
            int prijs;


            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM product p join ov_chipkaart_product ovp on (p.kaart_nummer = ovp.kaart_nummer) WHERE kaart_nummer =" + ovChipkaart.getKaartNummer());
            while (rs.next()) {
                productNummer = rs.getInt("product_nummer");
                naam = rs.getString("naam");
                beschrijving = rs.getString("beschrijving");
                prijs = rs.getInt("prijs");

                Product product = new Product(productNummer, naam, beschrijving, prijs);
                producten.add(product);

            }
            rs.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return producten;
    }

    @Override
    public List<Product> findAll() {
        List<Product> producten = new ArrayList<Product>();
        try {
            int productNummer;
            String naam;
            String beschrijving;
            int prijs;



            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM product p join ov_chipkaart_product ovp on (p.product_nummer = ovp.product_nummer)");
            while (rs.next()) {
                productNummer = rs.getInt("product_nummer");
                naam = rs.getString("naam");
                beschrijving = rs.getString("beschrijving");
                prijs = rs.getInt("prijs");

                Product product = new Product(productNummer, naam, beschrijving, prijs );
                producten.add(product);

            }
            rs.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return producten;
    }
}
