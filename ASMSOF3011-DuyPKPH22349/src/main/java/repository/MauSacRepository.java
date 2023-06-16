package repository;

import model.ChucVu;
import model.KhachHang;
import model.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    public List<MauSac> getAll() {
        List<MauSac> lists = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM MauSac", MauSac.class);
            lists = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lists;
    }

    public MauSac getById(UUID id){
        MauSac mauSac = new MauSac();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            mauSac = session.get(MauSac.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mauSac;
    }

    public Boolean add(MauSac mauSac){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.persist(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(MauSac mauSac) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Update
            session.merge(mauSac);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(MauSac mauSac) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Delete
            session.delete(mauSac);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args){
        new MauSacRepository().getAll().forEach(s -> System.out.println(s));
    }
}
