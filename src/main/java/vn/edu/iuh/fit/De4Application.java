package vn.edu.iuh.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vn.edu.iuh.fit.dao.LoaiSPDao;
import vn.edu.iuh.fit.dao.SPDao;
import vn.edu.iuh.fit.entity.LoaiSP;
import vn.edu.iuh.fit.entity.SP;

@SpringBootApplication
public class De4Application {

    public static void main(String[] args) {
       ConfigurableApplicationContext context= SpringApplication.run(De4Application.class, args);
        LoaiSPDao loaiSPDao=context.getBean(LoaiSPDao.class);
        SPDao spDao=context.getBean(SPDao.class);
//        for (int i = 1; i <=10 ; i++) {
//            loaiSPDao.addLoaiSP(new LoaiSP("loai"+i));
//        }
//        for (int i = 1; i <=4 ; i++) {
//            spDao.addSP(new SP("sp"+i+36, 6500, new LoaiSP(10)));
//        }
        loaiSPDao.getLoaiSPList().forEach(l->System.out.println(l.toString()));
    }

}
