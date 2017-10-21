package com.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaPractice {

	Predicate<Movie> isVhsPred = Movie::isVhs;

	Function<Movie, Double> mapMovieToPrice = Movie::getPrice;

	Consumer<Double> printPrice = System.out::println;

	public void methodWithStream(Predicate<Movie> isVhsPred, Function<Movie, Double> mapMovieToPrice,
			Consumer<Double> printPrice, List<Movie> movies) {
		movies.stream().filter(isVhsPred).map(mapMovieToPrice).forEach(printPrice);
	}

	/**
	 * 
	 * Exercise to print out the prices of only the vhs tapes in the movie collection
	 */
	public static void main(String[] args) {
		LambdaPractice lp = new LambdaPractice();
		List<Movie> movies = new ArrayList<>();
		movies = Arrays.asList(new Movie("vhs", 1.0), new Movie("betamax", 2.0), new Movie("betamax", 2.0), new Movie("vhs", 3.0));

		//with stream passing into a method
		lp.methodWithStream(lp.isVhsPred, lp.mapMovieToPrice, lp.printPrice, movies);
		
		//use the lambdas in the class instead of defining them here
		movies.stream().filter(lp.isVhsPred).map(lp.mapMovieToPrice).forEach(lp.printPrice);
		
		//with stream all in one line
		movies.stream().filter(Movie::isVhs).map(Movie::getPrice).forEach(System.out::println);
		
		//without stream you must actually use the method names defined in the functional interfaces
		for(Movie movie: movies){
			if(lp.isVhsPred.test(movie)){
				lp.printPrice.accept(lp.mapMovieToPrice.apply(movie));
			}
		}
		
	}

}

class Movie {

	private String type;
	private Double price;

	public Movie(String type, Double price) {
		this.type = type;
		this.price = price;
	}

	public boolean isVhs() {
		if (type.equalsIgnoreCase("vhs"))
			return true;
		return false;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
