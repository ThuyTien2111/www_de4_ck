package vn.edu.iuh.fit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loaisp")
public class LoaiSP {
    @Id
    @Column(name = "LID")
    private long lid;
    @Column(name = "TenLoai", columnDefinition = "varchar(50)")
    private String ten_loai;

    public LoaiSP() {
    }

    public LoaiSP(long lid, String ten_loai) {
        this.lid = lid;
        this.ten_loai = ten_loai;
    }

    public LoaiSP(long lid) {
        this.lid = lid;
    }

    public LoaiSP(String ten_loai) {
        this.ten_loai = ten_loai;
    }

    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }

    public String getTen_loai() {
        return ten_loai;
    }

    public void setTen_loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }

    @Override
    public String toString() {
        return "LoaiSP{" +
                "lid=" + lid +
                ", ten_loai='" + ten_loai + '\'' +
                '}';
    }
}
