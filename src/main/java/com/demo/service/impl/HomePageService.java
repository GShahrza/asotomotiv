package com.demo.service.impl;

import com.demo.dto.HomePageDTO;
import com.demo.entity.HomePage;
import com.demo.repository.HomePageRepository;
import com.demo.service.inter.HomePageServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService implements HomePageServiceInter {

    private final HomePageRepository homePageRepository;
    @Autowired
    public HomePageService(HomePageRepository homePageRepository) {
        this.homePageRepository = homePageRepository;
    }

    @Override
    public List<HomePageDTO> findAllHomePage()
    {
        try
        {
            List<HomePageDTO> homePageDTOS = new ArrayList<>();
            homePageRepository.findAll().forEach(homePage -> homePageDTOS.add(new HomePageDTO(homePage)));
            return homePageDTOS;
        }catch (Exception ex)
        {
            return new ArrayList<>();
        }
    }

    @Override
    public HomePageDTO findById(int id)
    {
        try
        {
            return new HomePageDTO(homePageRepository.findById(id).get());
        }catch (Exception ex)
        {
            return new HomePageDTO();
        }
    }

    @Override
    public Boolean updateHomePage(HomePage homePage)
    {
        try
        {
            homePageRepository.save(homePage);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteHomePage(int id)
    {
        try
        {
            homePageRepository.delete(homePageRepository.findById(id).get());
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }
}
