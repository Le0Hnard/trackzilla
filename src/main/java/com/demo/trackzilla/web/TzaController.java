package com.demo.trackzilla.web;

import com.demo.trackzilla.entity.Application;
import com.demo.trackzilla.entity.Ticket;
import com.demo.trackzilla.exception.ApplicationNotFoundException;
import com.demo.trackzilla.resolver.Query;
import com.demo.trackzilla.service.ApplicationService;
import com.demo.trackzilla.service.ReleaseService;
import com.demo.trackzilla.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// For Spring MVC (using templating engine)
//@Controller
//public class TzaController {
//    private ApplicationService applicationService;
//    private TicketService ticketService;
//    private ReleaseService releaseService;
//
//    @Autowired
//    public void setApplicationService(ApplicationService applicationService) {
//        this.applicationService = applicationService;
//    }
//
//    @Autowired
//    public void setTicketService(TicketService ticketService) {
//        this.ticketService = ticketService;
//    }
//
//    @Autowired
//    public void setReleaseService(ReleaseService releaseService) {
//        this.releaseService = releaseService;
//    }
//
//    @GetMapping("/applications")
//    public String retrieveApplications(Model model){
//        model.addAttribute("applications", applicationService.listApplications());
//        return "applications";
//    }
//
//    @GetMapping("/tickets")
//    public String retrieveTickets(Model model){
//        model.addAttribute("tickets", ticketService.listTickets());
//        return "tickets";
//    }
//
//    @GetMapping("/releases")
//    public String retrieveReleases(Model model){
//        model.addAttribute("releases", releaseService.listReleases());
//        return "releases";
//    }
//}

// For REST API
@RestController
@RequestMapping("/tza")
public class TzaController {
    private ApplicationService applicationService;
    private TicketService ticketService;
//    private Query query;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) { this.applicationService = applicationService; }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

//    @Autowired
//    public void setQuery(Query query) {
//        this.query = query;
//    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> list = ticketService.listTickets();
        return new ResponseEntity<List<Ticket>>(list, HttpStatus.OK);
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> list = applicationService.listApplications();
        return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
//        List<Application> list = (List<Application>) query.findAllApplications();
//        return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<Application>(applicationService.findApplication(id),
                    HttpStatus.OK);
        } catch (ApplicationNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application Not Found");
        }
    }
}
