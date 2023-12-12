package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.entity.LoaiSP;
import vn.edu.iuh.fit.entity.SP;

import java.util.List;

@Repository
public class SPDao {
    private EntityManager manager;
    @Autowired
    public SPDao(EntityManager manager) {
        this.manager = manager;
    }
    @Transactional
    public boolean addSP(SP sp){
        try {
            long totalSP= (long) manager.createQuery("select count(s) from SP s").getSingleResult();
            sp.setSp_id(totalSP+1);
            manager.persist(sp);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public boolean updateSP(SP sp){
        try {
            manager.merge(sp);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public List<SP> getSPList(){
        try{
            return manager.createQuery("select s from SP s", SP.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public Page<SP> getAll(int page, int size){
        try{
            List<SP> SPS=manager.createQuery("select s from SP s", SP.class)
                    .setFirstResult(page * size) //first roi toi max
                    .setMaxResults(size)
                    .getResultList();
            long totalSP= (long) manager.createQuery("select count(s) from SP s").getSingleResult();
            return new PageImpl<>(SPS, PageRequest.of(page, size), totalSP);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public SP getSP(long spid){
        try{
            return manager.find(SP.class, spid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
