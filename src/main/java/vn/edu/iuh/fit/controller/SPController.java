package vn.edu.iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.convert.SPForm;
import vn.edu.iuh.fit.dao.LoaiSPDao;
import vn.edu.iuh.fit.dao.SPDao;
import vn.edu.iuh.fit.entity.LoaiSP;
import vn.edu.iuh.fit.entity.SP;

import java.util.List;
import java.util.Map;

@Controller
public class SPController {
    private SPDao spDao;
    private LoaiSPDao loaiSPDao;
    @Autowired
    public SPController(SPDao spDao, LoaiSPDao loaiSPDao) {
        this.spDao = spDao;
        this.loaiSPDao = loaiSPDao;
    }

    @GetMapping("/sp")
    public String getAllSP(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "5") int size,
                           Model model){
        Page<SP> sps=spDao.getAll(page, size);
        model.addAttribute("sps", sps.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("totalSP", sps.getTotalPages());

        return "sp";
    }
    @GetMapping("/add")
    public String getAddSPForm(Model model){
        List<LoaiSP> loaiSPS=loaiSPDao.getLoaiSPList();
        model.addAttribute("loaiSPS", loaiSPS);
        return "add-sp";
    }
    @PostMapping ("/add")
    public String addSPForm(@ModelAttribute SPForm spForm, Model model){
        double price= Double.parseDouble(spForm.getPrice());
        long lid= Long.parseLong(spForm.getType());
        spDao.addSP(new SP(spForm.getName(), price, new LoaiSP(lid)));
        return "redirect:/sp";
    }
    @GetMapping("/update/{spid}")
    public String getUpdateSPForm(@PathVariable long spid, Model model){
        SP sp=spDao.getSP(spid);
        List<LoaiSP> loaiSPS=loaiSPDao.getLoaiSPList();
        model.addAttribute("sp", sp);
        model.addAttribute("loaiSPS", loaiSPS);
        model.addAttribute("spid", spid);
        return "update-sp";
    }
    @PostMapping("/update/{spid}")
    public String updateSPForm(@PathVariable long spid, @ModelAttribute SPForm spForm, Model model){
        double price= Double.parseDouble(spForm.getPrice());
        long lid= Long.parseLong(spForm.getType());
        spDao.updateSP(new SP(spid, spForm.getName(), price, new LoaiSP(lid)));
        return "redirect:/sp";
    }


}
