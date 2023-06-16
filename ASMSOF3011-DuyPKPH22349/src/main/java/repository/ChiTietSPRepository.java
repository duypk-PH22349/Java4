package repository;

import model.ChiTietSP;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    public List<ChiTietSP> getAll() {
        List<ChiTietSP> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP ", ChiTietSP.class);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public ChiTietSP getById(UUID id){
        ChiTietSP chiTietSP = new ChiTietSP();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            chiTietSP = session.get(ChiTietSP.class, id);

        }catch (Exception e){
            e.printStackTrace();
        }
        return chiTietSP;
    }

    public Boolean add(ChiTietSP  chiTietSP){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.persist(chiTietSP);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(ChiTietSP chiTietSP) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Update
            session.merge(chiTietSP);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(ChiTietSP chiTietSP) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Delete
            session.delete(chiTietSP);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



    public static void main(String[] args){
        new ChiTietSPRepository().getAll().forEach(s -> System.out.println(s));
    }
}
