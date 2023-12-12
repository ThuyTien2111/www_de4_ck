package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.entity.LoaiSP;
import vn.edu.iuh.fit.entity.SP;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoaiSPDao {
    private EntityManager manager;
    @Autowired
    public LoaiSPDao(EntityManager manager) {
        this.manager = manager;
    }
    @Transactional
    public boolean addLoaiSP(LoaiSP loaiSP){
        try {
            long totalLoai= (long) manager.createQuery("select count(l) from LoaiSP l").getSingleResult();
            loaiSP.setLid(totalLoai+1);
            manager.persist(loaiSP);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public List<LoaiSP> getLoaiSPList(){
        try{
            return manager.createQuery("select l from LoaiSP l", LoaiSP.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public Page<LoaiSP> getAll(int page, int size){
        try{
            List<LoaiSP> loaiSPS=manager.createQuery("select l from LoaiSP l", LoaiSP.class)
                    .setFirstResult(page * size) //first roi toi max
                    .setMaxResults(size)
                    .getResultList();
            long totalLoai= (long) manager.createQuery("select count(l) from LoaiSP l").getSingleResult();
            return new PageImpl<>(loaiSPS, PageRequest.of(page, size), totalLoai);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public List<SP> getSPByLoai(long lid){
        List<SP> list=new ArrayList<>();
        try{
            String sql="SELECT * FROM sanpham\n" +
                    "WHERE LID=?";
            Query query =manager.createNativeQuery(sql, SP.class);
            query.setParameter(1, lid);
            list=query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
