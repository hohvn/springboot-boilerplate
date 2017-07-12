package com.thaitv.repositories;

import com.thaitv.domain.Hotel;
import com.thaitv.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * Created by thaitv on 7/12/17.
 */
public interface ReviewRepository extends Repository<Review, Long> {
  Page<Review> findByHotel(Hotel hotel, Pageable pageable);

  Review findByHotelAndIndex(Hotel hotel, int index);

  Review save(Review review);
}
