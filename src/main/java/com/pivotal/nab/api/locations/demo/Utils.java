package com.pivotal.nab.api.locations.demo;

import com.pivotal.nab.api.locations.demo.beans.Atm;
import com.pivotal.nab.api.locations.demo.beans.Location;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils
{
    private static Log logger = LogFactory.getLog(Utils.class);
    private static final JsonParser parser = JsonParserFactory.getJsonParser();

    public static List<Location> getLocations(String nabApiKey,
                                      String swLat,
                                      String neLat,
                                      String neLng,
                                      String swLng) throws Exception
    {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.developer.nab.com.au/v2/locations?locationType=atm&searchCriteria=geo&swLat=%s&swLng=%s&neLat=%s&neLng=%s&fields=extended&v=1";

        logger.info(String.format(uri, swLat, swLng, neLat, neLng));

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-nab-key", nabApiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity<String> response = null;

        response = restTemplate.exchange(String.format(uri, swLat, swLng, neLat, neLng), HttpMethod.GET, entity, String.class);

        Map<String, Object> jsonMap = parser.parseMap(response.getBody());
        Map locationsMap = (Map) jsonMap.get("locationSearchResponse");
        List locationsList = (List) locationsMap.get("locations");

        logger.info("Number of locations = " + locationsList.size());

        List<Location> returnLocationList = new ArrayList<Location>();

        for (Object item: locationsList)
        {
            Map m = (Map) item;
            Location loc = new Location();
            loc.setApiStructType((String)m.get("apiStructType"));

            Map m2 = (Map) m.get("atm");
            Atm atm = new Atm();
            atm.setDescription((String)m2.get("description"));
            atm.setAddress1((String)m2.get("address1"));
            atm.setSuburb((String)m2.get("suburb"));
            atm.setState((String)m2.get("state"));
            atm.setPostcode((String)m2.get("postcode"));
            atm.setHours((String)m2.get("hours"));
            atm.setLatitude((Double)m2.get("latitude"));
            atm.setLongitude((Double)m2.get("longitude"));

            loc.setAtm(atm);

            returnLocationList.add(loc);
        }

        logger.info(returnLocationList);

        return returnLocationList;
    }

}