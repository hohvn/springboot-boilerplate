package com.thaitv.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.NaturalId;

/**
 * Created by thaitv on 7/12/17.
 */
@Entity
public class Hotel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "hotel_generator", sequenceName = "hotel_sequence", initialValue = 28)
  @GeneratedValue(generator = "hotel_generator")
  private Long id;

  @ManyToOne(optional = false)
  @NaturalId
  private City city;

  @Column(nullable = false)
  @NaturalId
  private String name;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false)
  private String zip;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
  private Set<Review> reviews;

  protected Hotel() {

  }

  public Hotel(City city, String name) {
    this.city = city;
    this.name = name;
  }

  public City getCity() {
    return city;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getZip() {
    return zip;
  }
}
