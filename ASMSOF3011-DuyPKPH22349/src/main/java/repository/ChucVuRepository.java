package repository;

import model.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ChucVuRepository {
    public List<ChucVu> getAll() {
        List<ChucVu> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu ", ChucVu.class);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public ChucVu getById(UUID id){
        ChucVu  chucVu = new ChucVu();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            chucVu = session.get(ChucVu.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return chucVu;
    }

    //add
    public Boolean add(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            //Add
            session.persist(chucVu);
            //Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update
    public Boolean update(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Update
            session.merge(chucVu);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete
    public Boolean delete(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Delete
            session.delete(chucVu);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new ChucVuRepository().getAll().forEach(s -> System.out.println(s));
//        System.out.println(new LopHocRepository().getOne(1L));
//          ChucVu cv = new ChucVu("7996B7AD-A607-45A3-B501-573630886E78", "maCv4","ten4");
//          System.out.println(new ChucVuRepository().add(cv));
//        ChucVu cv = new ChucVu("8888B7AD-A607-45A3-B501-573630886E37", "maCv6","ten6");
//        System.out.println(new ChucVuRepository().delete(cv));
//        new ChucVuRepository().getAll().forEach(s -> System.out.println(s));
    }
}

