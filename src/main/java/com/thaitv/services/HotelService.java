package com.thaitv.services;

import com.thaitv.domain.City;
import com.thaitv.domain.Hotel;
import com.thaitv.domain.Review;
import com.thaitv.domain.ReviewDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by thaitv on 7/12/17.
 */
public interface HotelService {
  Hotel getHotel(City city, String name);

  Page<Review> getReviews(Hotel hotel, Pageable pageable);

  Review getReview(Hotel hotel, int index);

  Review addReview(Hotel hotel, ReviewDetails reviewDetails);

  ReviewsSummary getReviewSummary(Hotel hotel);
}
