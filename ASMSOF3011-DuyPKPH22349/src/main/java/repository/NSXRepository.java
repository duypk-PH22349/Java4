package repository;

import model.ChucVu;
import model.KhachHang;
import model.NSX;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NSXRepository {
    public List<NSX> getAll() {
        List<NSX> lists = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM NSX", NSX.class);
            lists = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lists;
    }

    public NSX getById(UUID id){
        NSX nsx = new NSX();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            nsx = session.get(NSX.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nsx;
    }

    public Boolean add(NSX nsx){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.persist(nsx);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(NSX nsx) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Update
            session.merge(nsx);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(NSX nsx) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Delete
            session.delete(nsx);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args){
        new NSXRepository().getAll().forEach(s -> System.out.println(s));
    }
}
