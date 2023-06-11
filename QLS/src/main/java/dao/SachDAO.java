package dao;

import java.util.List;
import model.Sach;

public interface SachDAO {
    List<Sach> getAllSach();
    Sach getSachById(int id);
    List<Sach> searchSachByName(String name);
    void addSach(Sach sach);
    void updateSach(Sach sach);
    void deleteSach(int id);
}