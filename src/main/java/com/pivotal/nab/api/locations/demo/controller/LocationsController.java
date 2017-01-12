package com.pivotal.nab.api.locations.demo.controller;

import com.pivotal.nab.api.locations.demo.beans.NabApiKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LocationsController
{
    private static Log logger = LogFactory.getLog(LocationsController.class);

    @Autowired
    NabApiKey nabApiKey;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String locationPage(Model model) throws Exception
    {
        logger.info("Invoking LocationsController");
        logger.info(nabApiKey.toString());

        return "locationsapi";
    }
}
