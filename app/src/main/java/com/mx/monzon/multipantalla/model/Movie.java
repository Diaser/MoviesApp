package com.mx.monzon.multipantalla.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String name;
    private int image;
    private String[] names;
    private int[] images;

    public Movie(String[] names, int[] images){
        this.names =  names;
        this.images =  images;
    }
    private Movie(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public List<Movie> inizialiteList(){
        List<Movie> list = new ArrayList<>();
        for (int i=0; i< names.length; i++ )
        {
            Movie movie = new Movie();
            movie.setName(this.names[i]);
            movie.setImage(this.images[i]);
            list.add(movie);
        }
        return  list;
    }


}
