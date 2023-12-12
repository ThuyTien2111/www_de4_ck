package vn.edu.iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.dao.LoaiSPDao;
import vn.edu.iuh.fit.entity.LoaiSP;
import vn.edu.iuh.fit.entity.SP;

import java.util.List;

@Controller
public class LoaiSPControll {
    private LoaiSPDao loaiSPDao;
    @Autowired
    public LoaiSPControll(LoaiSPDao loaiSPDao) {
        this.loaiSPDao = loaiSPDao;
    }
    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }
    @GetMapping("/loaisp")
    public String getAllLoai(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "3") int size,
                             Model model){
        Page<LoaiSP> loaiSPS=loaiSPDao.getAll(page, size);
        model.addAttribute("loaiSPS", loaiSPS.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("totalLoai", loaiSPS.getTotalPages());
        return "loai-sp";
    }
    @GetMapping("/viewsp/{lid}")
    public String getSPByLoai(@PathVariable long lid, Model model){
        List<SP> sps=loaiSPDao.getSPByLoai(lid);
        model.addAttribute("sps", sps);
        return "sp-by-loai";
    }

}
