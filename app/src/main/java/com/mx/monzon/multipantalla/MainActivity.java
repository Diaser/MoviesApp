package com.mx.monzon.multipantalla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import com.mx.monzon.multipantalla.adapters.MoviesAdapter;
import com.mx.monzon.multipantalla.model.Movie;

public class MainActivity extends AppCompatActivity implements MoviesAdapter.OnAdapterListener {

    RecyclerView recyclerView;
    MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_movies);
        //Si estás seguro que el tamaño del RecyclerView no se cambiará, puedes añadirlo lo siguiente para mejorar el desempeño
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        TypedArray tArray = getResources().obtainTypedArray(
                R.array.array_images);
        int count = tArray.length();
        int[] ids = new int[count];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = tArray.getResourceId(i, 0);
        }
        //Recycles the TypedArray, to be re-used by a later caller.
        //After calling this function you must not ever touch the typed array again.
        tArray.recycle();
        Movie movie = new Movie(getResources().getStringArray(R.array.movies_name), ids);
        adapter =  new MoviesAdapter(movie.inizialiteList(), this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onMovieClick(int position) {
        Toast.makeText(getApplicationContext(),"posición: "+position,Toast.LENGTH_LONG).show();
    }
}