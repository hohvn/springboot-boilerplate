package com.thaitv.services;

import java.io.Serializable;
import org.springframework.util.Assert;

/**
 * Created by thaitv on 7/12/17.
 */
public class CitySearchCriteria implements Serializable {
  private static final long serialVersionUID = 1L;

  private String name;

  public CitySearchCriteria() {

  }

  public CitySearchCriteria(String name) {
    Assert.notNull(name, "Name must not be null");
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
