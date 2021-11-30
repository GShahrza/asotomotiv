package com.demo.service.impl;

import com.demo.dto.AboutDTO;
import com.demo.entity.About;
import com.demo.repository.AboutRepository;
import com.demo.repository.PhotosRepository;
import com.demo.service.inter.AboutServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AboutService implements AboutServiceInter {

    private final AboutRepository aboutRepository;


    private final PhotosRepository photosRepository;
    @Autowired
    public AboutService(AboutRepository aboutRepository,PhotosRepository photosRepository)
    {
        this.aboutRepository = aboutRepository;
        this.photosRepository = photosRepository;
    }

    @Override
    public List<AboutDTO> getAll(){
        try{
            List<AboutDTO> aboutDTOList = new ArrayList<>();
            aboutRepository.findAll().forEach(about -> aboutDTOList.add(new AboutDTO(about)) );

            return aboutDTOList;
        }catch (Exception ex){
            return new ArrayList<>();
        }
    }
    @Override
    public AboutDTO getAbout(int id)
    {
        try
        {
            return new AboutDTO(aboutRepository.findById(id).get());
        }catch (Exception e)
        {
            return new AboutDTO();
        }
    }

    @Override
    public Boolean addAndUpdateAbout(About about)
    {
        try
        {
            aboutRepository.save(about);
            return true;
        }catch (RuntimeException e)
        {
            return  false;
        }
    }

    @Override
    public Boolean deleteAbout(int id)
    {
        try
        {
            aboutRepository.delete(aboutRepository.findById(id).get());
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteAboutPhoto(int id)
    {
        try
        {
            About about = aboutRepository.findById(id).get();
            about.getPhoto().setImages(null);
            photosRepository.save(about.getPhoto());
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteAboutText(int id)
    {
        try
        {
            About about = aboutRepository.findById(id).get();
            about.setTexts(null);
            aboutRepository.save(about);

            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }
}
