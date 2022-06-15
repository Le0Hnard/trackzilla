package com.demo.trackzilla.service;

import com.demo.trackzilla.entity.Application;
import com.demo.trackzilla.exception.ApplicationNotFoundException;
import com.demo.trackzilla.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

//    @Override
//    public Iterable<Application> listApplications() {
//        return applicationRepository.findAll();
//    }

    @Override
    public List<Application> listApplications() {
        return (List<Application>) applicationRepository.findAll();
    }

    @Override
    public Application findApplication(Integer id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);

        if(optionalApplication.isPresent())
            return optionalApplication.get();
        else
            throw new ApplicationNotFoundException("Application Not Found", id);
    }

}
