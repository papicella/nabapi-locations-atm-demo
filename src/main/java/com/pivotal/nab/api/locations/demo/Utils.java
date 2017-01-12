package com.pivotal.nab.api.locations.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class Utils
{
    private static Log logger = LogFactory.getLog(Utils.class);
    private static final JsonParser parser = JsonParserFactory.getJsonParser();

    public static String getLocations (String nabApiKey) throws Exception
    {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "TODO://";

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-nab-key", nabApiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity<String> response = null;

        response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        /*
        Map<String, Object> jsonMap = parser.parseMap(response.getBody());
        Map fxRatesMap = (Map) jsonMap.get("fxRatesResponse");
        List<FxRate> ratesList = (List<FxRate>) fxRatesMap.get("fxRates");
        */

        return "";
    }

}
