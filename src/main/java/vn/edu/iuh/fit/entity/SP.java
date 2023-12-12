package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sanpham")
public class SP {
    @Id
    @Column(name = "SPID")
    private long sp_id;
    @Column(name = "TenSP", columnDefinition = "varchar(255)")
    private String ten_sp;
    @Column(name = "DonGia")
    private double don_gia;
    @ManyToOne
    @JoinColumn(name = "LID")
    private LoaiSP loaiSP;

    public SP() {
    }

    public SP(long sp_id, String ten_sp, double don_gia, LoaiSP loaiSP) {
        this.sp_id = sp_id;
        this.ten_sp = ten_sp;
        this.don_gia = don_gia;
        this.loaiSP = loaiSP;
    }

    public SP(String ten_sp, double don_gia, LoaiSP loaiSP) {
        this.ten_sp = ten_sp;
        this.don_gia = don_gia;
        this.loaiSP = loaiSP;
    }

    public long getSp_id() {
        return sp_id;
    }

    public void setSp_id(long sp_id) {
        this.sp_id = sp_id;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public double getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(double don_gia) {
        this.don_gia = don_gia;
    }

    public LoaiSP getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(LoaiSP loaiSP) {
        this.loaiSP = loaiSP;
    }

    @Override
    public String toString() {
        return "SP{" +
                "sp_id=" + sp_id +
                ", ten_sp='" + ten_sp + '\'' +
                ", don_gia=" + don_gia +
                ", loaiSP=" + loaiSP +
                '}';
    }
}
