package com.thaitv.controllers;

import com.thaitv.domain.City;
import com.thaitv.services.CitySearchCriteria;
import com.thaitv.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by thaitv on 7/12/17.
 */
@Controller
public class SampleController {

  @Autowired
  private CityService cityService;

  @GetMapping("/")
  @ResponseBody
  @Transactional(readOnly = true)
  public String helloWorld() {
    return this.cityService.getCity("Bath", "UK").getName();
  }

  @GetMapping("/list")
  @ResponseBody
  @Transactional(readOnly = true)
  public int list() {
    CitySearchCriteria criteria = new CitySearchCriteria("B");
    Page<City> cities = this.cityService.findCities(criteria, new PageRequest(0, 10));

    return cities.getSize();
  }

}
