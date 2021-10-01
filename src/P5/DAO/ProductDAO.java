package P5.DAO;

import P2enP3.Domein.Reiziger;
import P4.Domein.OVChipkaart;
import P5.Domein.Product;

import java.util.List;

public interface ProductDAO {
    public boolean save(Product product);

    public boolean update(Product product);

    public boolean delete(Product product);

    public List<Product> findByOvchipkaart(OVChipkaart ovChipkaart);

    public List<Product> findAll();
}