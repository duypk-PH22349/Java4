package model;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Table(name="ChiTietSP")
@Entity

public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

//    @ManyToOne
//    @JoinColumn(name="idNSX", nullable=false)
//    private NSX idNSX;
//
//    @ManyToOne
//    @JoinColumn(name="idSP", nullable=false)
//    private SanPham idSP;
//
//    @ManyToOne
//    @JoinColumn(name="idMauSac", nullable=false)
//    private MauSac idMauSac;
//
//    @ManyToOne
//    @JoinColumn(name="idDongSP", nullable=false)
//    private DongSP idDongSP;

    @Column(name = "NamSX")
    private Integer namSX;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private float giaNhap;

    @Column(name = "GiaBan")
    private float giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(UUID id, Integer namSX, String moTa, Integer soLuongTon, float giaNhap, float giaBan) {
        this.id = id;
        this.namSX = namSX;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSP(Integer namSX, String moTa, Integer soLuongTon, float giaNhap, float giaBan) {
        this.namSX = namSX;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNamSX() {
        return namSX;
    }

    public void setNamSX(Integer namSX) {
        this.namSX = namSX;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "ChiTietSP{" +
                "id='" + id + '\'' +
                ", namSX=" + namSX +
                ", moTa='" + moTa + '\'' +
                ", soLuongTon=" + soLuongTon +
                ", giaNhap=" + giaNhap +
                ", giaBan=" + giaBan +
                '}';
    }
}
