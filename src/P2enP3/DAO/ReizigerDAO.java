package P2enP3.DAO;

import P2enP3.Domein.Reiziger;

import java.sql.Date;
import java.util.List;

public interface ReizigerDAO {

    boolean save(Reiziger reiziger);
    boolean update(Reiziger reiziger);
    boolean delete(Reiziger reiziger);
    Reiziger findById(int id);
    List<Reiziger> findByGbdatum(Date datum);
    List<Reiziger> findAll();

}
