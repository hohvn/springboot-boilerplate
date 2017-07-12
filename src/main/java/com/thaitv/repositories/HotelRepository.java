package com.thaitv.repositories;

import com.thaitv.domain.City;
import com.thaitv.domain.Hotel;
import com.thaitv.domain.HotelSummary;
import com.thaitv.domain.RatingCount;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Created by thaitv on 7/12/17.
 */
public interface HotelRepository extends Repository<Hotel, Long> {
  Hotel findByCityAndName(City city, String name);

  @Query("select h.city as city, h.name as name, avg(r.rating) as averageRating "
      + "from Hotel h left outer join h.reviews r where h.city = ?1 group by h")
  Page<HotelSummary> findByCity(City city, Pageable pageable);

  @Query("select r.rating as rating, count(r) as count "
      + "from Review r where r.hotel = ?1 group by r.rating order by r.rating DESC")
  List<RatingCount> findRatingCounts(Hotel hotel);
}
