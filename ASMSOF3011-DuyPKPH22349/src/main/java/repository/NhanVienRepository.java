package repository;

import model.ChucVu;
import model.KhachHang;
import model.NhanVien;
import model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    public List<NhanVien> getAll() {
        List<NhanVien> lists = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM NhanVien", NhanVien.class);
            lists = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lists;
    }

    public NhanVien getById(UUID id){
        NhanVien nhanVien = new NhanVien();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            nhanVien = session.get(NhanVien.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nhanVien;
    }

    public Boolean add(NhanVien nhanVien){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Update
            session.merge(nhanVien);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Delete
            session.delete(nhanVien);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args){
        new NhanVienRepository().getAll().forEach(s -> System.out.println(s));
    }
}
