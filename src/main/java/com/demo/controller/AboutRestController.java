package com.demo.controller;

import com.demo.dto.AboutDTO;
import com.demo.entity.About;
import com.demo.service.inter.AboutServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/about")
public class AboutRestController {

    private final AboutServiceInter aboutService;
    @Autowired
    public AboutRestController(AboutServiceInter aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping("/getAll")
    public List<AboutDTO> getAll()
    {
        return aboutService.getAll();
    }

    @GetMapping("/getAbout/{id}")
    public AboutDTO getAbout(@PathVariable int id)
    {
        return aboutService.getAbout(id);
    }

    @PostMapping("/update")
    public Boolean updateAbout(@RequestBody About about)
    {
        return aboutService.addAndUpdateAbout(about);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteAbout(@PathVariable int id)
    {
        return aboutService.deleteAbout(id);
    }

    @DeleteMapping("/delete/text/{id}")
    public Boolean deleteAboutText(@PathVariable int id)
    {
        return aboutService.deleteAboutText(id);
    }

    @DeleteMapping("/delete/photo/{id}")
    public Boolean deleteAboutPhoto(@PathVariable int id)
    {
        return aboutService.deleteAboutPhoto(id);
    }

}
