package com.thaitv.services;

import com.thaitv.domain.Rating;

/**
 * Created by thaitv on 7/12/17.
 */
public interface ReviewsSummary {
  long getNumberOfReviewsWithRating(Rating rating);
}
