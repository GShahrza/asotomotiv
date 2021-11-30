package com.demo.service.inter;

import com.demo.dto.AboutDTO;
import com.demo.entity.About;

import java.util.List;


public interface AboutServiceInter {

    List<AboutDTO> getAll();

    AboutDTO getAbout(int id);

    Boolean addAndUpdateAbout(About about);

    Boolean deleteAbout(int id);

    Boolean deleteAboutPhoto(int id);

    Boolean deleteAboutText(int id);
}
