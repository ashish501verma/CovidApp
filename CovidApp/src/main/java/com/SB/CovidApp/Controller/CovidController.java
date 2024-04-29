package com.SB.CovidApp.Controller;

import com.SB.CovidApp.Service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/covid")
@CrossOrigin
public class CovidController {


    @Autowired
    CovidService covidService;
//@GetMapping("/citywise/{state}/{city}")//passing state name and city name in url
@GetMapping("/citywise/{state}/{city}")
public String getCovidCases(@PathVariable String state,@PathVariable String city){// path variable used to have dynamic variables.
    Integer covidData = covidService.getCovidData(state,city);
   // return "Ashish";
    return "Covid Active cases in "+state+"'s "+city+" is/are "+ covidData+".";
}


}
