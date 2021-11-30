package com.demo.service.inter;

import com.demo.dto.HomePageDTO;
import com.demo.entity.HomePage;
import com.demo.entity.Users;

import java.util.List;

public interface HomePageServiceInter {

    List<HomePageDTO> findAllHomePage();

    HomePageDTO findById(int id);

    Boolean updateHomePage(HomePage homePage);

    Boolean deleteHomePage(int id);
}
