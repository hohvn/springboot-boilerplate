package com.thaitv.services;

import com.thaitv.domain.City;
import com.thaitv.domain.Hotel;
import com.thaitv.domain.Rating;
import com.thaitv.domain.RatingCount;
import com.thaitv.domain.Review;
import com.thaitv.domain.ReviewDetails;
import com.thaitv.repositories.HotelRepository;
import com.thaitv.repositories.ReviewRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Created by thaitv on 7/12/17.
 */
@Component("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {
  private final HotelRepository hotelRepository;

  private final ReviewRepository reviewRepository;

  public HotelServiceImpl(HotelRepository hotelRepository, ReviewRepository reviewRepository) {
    this.hotelRepository = hotelRepository;
    this.reviewRepository = reviewRepository;
  }


  @Override
  public Hotel getHotel(City city, String name) {
    Assert.notNull(city, "The City must not be null");
    Assert.hasLength(name, "The Name must not be empty");
    return this.hotelRepository.findByCityAndName(city, name);
  }

  @Override
  public Page<Review> getReviews(Hotel hotel, Pageable pageable) {
    Assert.notNull(hotel, "The Hotel must not be null");

    return this.reviewRepository.findByHotel(hotel, pageable);
  }

  @Override
  public Review getReview(Hotel hotel, int index) {
    Assert.notNull(hotel, "The Hotel must not be null");

    return this.reviewRepository.findByHotelAndIndex(hotel, index);
  }

  @Override
  public Review addReview(Hotel hotel, ReviewDetails reviewDetails) {
    Review review = new Review(hotel, 1, reviewDetails);
    return this.reviewRepository.save(review);
  }

  @Override
  public ReviewsSummary getReviewSummary(Hotel hotel) {
    Assert.notNull(hotel, "The Hotel must not be null");
    List<RatingCount> ratingCounts = this.hotelRepository.findRatingCounts(hotel);
    return new ReviewsSummaryImpl(ratingCounts);
  }

  private static class ReviewsSummaryImpl implements ReviewsSummary {

    private final Map<Rating, Long> ratingCount;

    public ReviewsSummaryImpl(List<RatingCount> ratingCounts) {
      this.ratingCount = new HashMap<>();
      for (RatingCount ratingCount : ratingCounts) {
        this.ratingCount.put(ratingCount.getRating(), ratingCount.getCount());
      }
    }

    @Override
    public long getNumberOfReviewsWithRating(Rating rating) {
      Long count = this.ratingCount.get(rating);
      return count == null ? 0 : count;
    }
  }
}
