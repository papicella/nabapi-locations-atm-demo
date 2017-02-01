package com.pivotal.nab.api.locations.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class Utils
{
    private static Log logger = LogFactory.getLog(Utils.class);
    private static final JsonParser parser = JsonParserFactory.getJsonParser();

    public static String getLocations(String nabApiKey,
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
        logger.info(jsonMap);

        return response.getBody();
    }

}
