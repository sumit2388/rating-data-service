package io.javabrains.ratingdataservice;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	private static final Logger log = LoggerFactory.getLogger(RatingResource.class);
	
	// to check port number in ribbon client 
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId){
		log.info("sumit rating movie id");
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId){
		log.info("sumit rating");

		 List<Rating> ratings = Arrays.asList(new Rating("1234:"+port, 4),new Rating("5678:"+port, 3) );
		 
		 UserRating rating = new UserRating();
		 rating.setUserRating(ratings);
		 return rating;
	} 
}
