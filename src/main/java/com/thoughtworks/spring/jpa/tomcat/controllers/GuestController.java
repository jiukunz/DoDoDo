package com.thoughtworks.spring.jpa.tomcat.controllers;

import com.thoughtworks.spring.jpa.tomcat.dao.GuestDao;
import com.thoughtworks.spring.jpa.tomcat.entities.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by dwwang on 1/22/15.
 */
@Controller
public class GuestController {
    @Autowired
    private GuestDao guestDao;

    @RequestMapping(value="/guest")
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null) {
            guestDao.persist(new Guest(name));
        }

        List<Guest> allGuests = guestDao.getAllGuests();
        // Prepare the result view (guest.jsp):
        return new ModelAndView("guest", "guests", allGuests);
    }
}
