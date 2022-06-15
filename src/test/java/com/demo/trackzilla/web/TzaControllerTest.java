package com.demo.trackzilla.web;

import com.demo.trackzilla.entity.Application;
import com.demo.trackzilla.repository.ApplicationRepository;
import com.demo.trackzilla.service.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.stream.StreamSupport;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TzaControllerTest {
    @Autowired
    private TzaController controller;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Mock
    private Model model;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void retrieveApplications() throws Exception {
//        String returnValue = controller.retrieveApplications(model);
//        assertEquals("applications", returnValue);
    }

    @Test
    public void retrieveApplicationsFromService() throws Exception {
        Iterable<Application> applications = applicationService.listApplications();

        assertNotNull(applications);
        assertEquals(5, StreamSupport.stream(applications.spliterator(), false).count());
    }

    @Test
    public void retrieveApplicationsFromRepo() throws Exception {
        Iterable<Application> applications = applicationRepository.findAll();

        assertNotNull(applications);
        assertEquals(5, StreamSupport.stream(applications.spliterator(), false).count());
    }
}
