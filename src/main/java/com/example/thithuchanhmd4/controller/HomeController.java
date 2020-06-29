package com.example.thithuchanhmd4.controller;

import com.example.thithuchanhmd4.model.MyCity;
import com.example.thithuchanhmd4.model.Nation;
import com.example.thithuchanhmd4.service.MyCityService;
import com.example.thithuchanhmd4.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private MyCityService myCityService;

    @Autowired
    private NationService nationService;

    @ModelAttribute("nation")
    public Page<Nation> countries(@PageableDefault(3) Pageable pageable) {
        return nationService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView showListMyCity(@PageableDefault(size = 3) Pageable pageable,
                                       @RequestParam("keyword") Optional<String> keyword) {
        ModelAndView modelAndView = new ModelAndView("index");
        Page<MyCity> listMyCity;
        if (keyword.isPresent()) {
            listMyCity = myCityService.findByNameContaining(pageable, keyword);
        } else {
            listMyCity = myCityService.findAll(pageable);
        }
        modelAndView.addObject("listMyCitys", listMyCity);
        return modelAndView;
    }

    @GetMapping("/showMyCity/{id}")
    public ModelAndView showDetailMycity(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detailMyCity");
        Optional<MyCity> myCityOptional = myCityService.findById(id);
        modelAndView.addObject("showdetailMycity", myCityOptional.get());
        return modelAndView;
    }

    @GetMapping("/creatMycity")
    public ModelAndView showFormCreatLesson() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("Mycitys", new MyCity());
        return modelAndView;
    }

    @PostMapping("/saveMycity")
    public ModelAndView saveMyCity(@ModelAttribute("product") MyCity myCity) {
        myCityService.save(myCity);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/editMyCity/{id}")
    public ModelAndView showFormEditProduct(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Optional<MyCity> myCity = myCityService.findById(id);
        modelAndView.addObject("editMycitys", myCity);
        return modelAndView;
    }

    @GetMapping("/deleteMycity/{id}")
    public ModelAndView showFormDeleteProduct(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        Optional<MyCity> myCity = myCityService.findById(id);
        modelAndView.addObject("deleteMycity", myCity.get());
        return modelAndView;
    }

    @PostMapping("/deleteMycity")
    public ModelAndView deleteLesson(@ModelAttribute("product") MyCity myCity) {
        myCityService.remove(myCity.getId());
        return new ModelAndView("redirect:/");
    }
}
