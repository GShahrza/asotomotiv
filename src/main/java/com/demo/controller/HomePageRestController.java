package com.demo.controller;

import com.demo.dto.HomePageDTO;
import com.demo.entity.HomePage;
import com.demo.service.inter.HomePageServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("homePage")
public class HomePageRestController {

    private final HomePageServiceInter homePageService;

    public HomePageRestController(HomePageServiceInter homePageService) {
        this.homePageService = homePageService;
    }

    @GetMapping("/getAll")
    public List<HomePageDTO> getAllHomePage()
    {
        return homePageService.findAllHomePage();
    }

    @GetMapping("/getOne/{id}")
    public HomePageDTO getByHomePage(@PathVariable int id){
        return homePageService.findById(id);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody HomePage homePage){
        return homePageService.updateHomePage(homePage);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable int id){
        return homePageService.deleteHomePage(id);
    }
}
