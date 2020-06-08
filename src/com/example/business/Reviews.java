package com.example.business;

import java.io.Serializable;

public class Reviews implements Serializable{


	private static final long serialVersionUID = 1L;
	private int id;
	private String movieName;
	private String reviewContent;
	private float rating;
	
	
	public Reviews(int id, String movieName, String reviewContent,
			float rating) {
		
		setId(id);
		setMovieName(movieName);
		setReviewContent(reviewContent);
		setRating(rating);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getReviewContent() {
		return reviewContent;
	}


	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
}
