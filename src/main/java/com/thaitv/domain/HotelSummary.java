package com.thaitv.domain;

/**
 * Created by thaitv on 7/12/17.
 */
public interface HotelSummary {

  City getCity();

  String getName();

  Double getAverageRating();

  default Integer getAverageRatingRounded() {
    return getAverageRating() == null ? null : (int) Math.round(getAverageRating());
  }
}
