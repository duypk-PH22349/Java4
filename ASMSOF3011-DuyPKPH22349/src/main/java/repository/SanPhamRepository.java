package repository;

import model.ChucVu;
import model.KhachHang;
import model.NSX;
import model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    public List<SanPham> getAll() {
        List<SanPham> lists = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM SanPham", SanPham.class);
            lists = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lists;
    }

    public SanPham getById(UUID id){
        SanPham sanPham = new SanPham();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            sanPham = session.get(SanPham.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sanPham;
    }

    public Boolean add(SanPham sanPham){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.persist(sanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Update
            session.merge(sanPham);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Delete
            session.delete(sanPham);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args){
        new SanPhamRepository().getAll().forEach(s -> System.out.println(s));
    }
}
