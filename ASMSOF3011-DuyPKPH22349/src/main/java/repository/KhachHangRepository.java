package repository;

import model.ChucVu;
import model.KhachHang;
import model.MauSac;
import model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {
    public List<KhachHang> getAll() {
        List<KhachHang> lists = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM KhachHang", KhachHang.class);
            lists = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lists;
    }

    public KhachHang getById(UUID id){
        KhachHang khachHang = new KhachHang();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            khachHang = session.get(KhachHang.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return khachHang;
    }

    public Boolean add(KhachHang khachHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.persist(khachHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public Boolean update(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            // Update
            session.merge(khachHang);
            // Commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void delete(KhachHang khachHang){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
//        new KhachHangRepository().getAll().forEach(s -> System.out.println(s));

    }

}
