package com.thaitv.services;

import com.thaitv.domain.City;
import com.thaitv.domain.HotelSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by thaitv on 7/12/17.
 */
public interface CityService {
  Page<City> findCities(CitySearchCriteria citySearchCriteria, Pageable pageable);

  City getCity(String name, String country);

  Page<HotelSummary> getHotels(City city, Pageable pageable);
}
