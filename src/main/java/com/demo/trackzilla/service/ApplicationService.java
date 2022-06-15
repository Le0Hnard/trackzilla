package com.demo.trackzilla.service;

import com.demo.trackzilla.entity.Application;

import java.util.List;

public interface ApplicationService {
//    Iterable<Application> listApplications();
    List<Application> listApplications();
    Application findApplication(Integer id);
}
