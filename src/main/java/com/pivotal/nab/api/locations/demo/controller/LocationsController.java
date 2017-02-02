package com.pivotal.nab.api.locations.demo.controller;

import com.pivotal.nab.api.locations.demo.Utils;
import com.pivotal.nab.api.locations.demo.beans.Location;
import com.pivotal.nab.api.locations.demo.beans.NabApiKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @RequestMapping(value="/search", method = RequestMethod.POST)
    public String searchAtms
            (@RequestParam(value="swLat") String swLat,
             @RequestParam(value="neLat") String neLat,
             @RequestParam(value="neLng") String neLng,
             @RequestParam(value="swLng") String swLng,
             Model model) throws Exception
    {
        logger.info("Invoking LocationsController POST search action");
        logger.info(nabApiKey.toString());

        List<Location> locationList = Utils.getLocations(nabApiKey.getNabApiKey(), swLat, neLat, neLng, swLng);

        model.addAttribute("locationList", locationList);

        return "locationsapi";
    }
}
