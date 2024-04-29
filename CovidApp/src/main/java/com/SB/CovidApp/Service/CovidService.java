package com.SB.CovidApp.Service;

import com.SB.CovidApp.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class CovidService {

    //Util util;
@Autowired
RestTemplate restTemplate;
    public Integer getCovidData(String stateName,String cityName){

        Map<String,Object> forObject = restTemplate.getForObject(Util.COVID_API, Map.class);// restTemplate used to consume the covid API
       // Map<String, Object> city = (Map<String, Object>) forObject.get("Delhi");// in API we have data in key value pair so using map.
        Map<String, Object> city = (Map<String, Object>) forObject.get(stateName);
        Map<String, Object> districtData = (Map<String, Object>) city.get("districtData"); //again used map to fetch the data key is district and its value is in Object form
        Map<String, Object> City = (Map<String, Object>) districtData.get(cityName);
        Integer active = (Integer)City.get("active");
        return active;

    }
}
