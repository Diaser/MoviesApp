package com.mx.monzon.multipantalla.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mx.monzon.multipantalla.R;
import com.mx.monzon.multipantalla.adapters.MoviesAdapter;
import com.mx.monzon.multipantalla.model.Movie;


public class ShowListFragment extends Fragment implements MoviesAdapter.OnAdapterListener {

    RecyclerView recyclerView;
    MoviesAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_movies);
        //Si estás seguro que el tamaño del RecyclerView no se cambiará, puedes añadirlo lo siguiente para mejorar el desempeño
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TypedArray tArray = getResources().obtainTypedArray(
                R.array.array_images);
        int count = tArray.length();
        int[] ids = new int[count];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = tArray.getResourceId(i, 0);
        }
        tArray.recycle();
        Movie movie = new Movie(getResources().getStringArray(R.array.movies_name), ids);
        adapter =  new MoviesAdapter(movie.inizialiteList(), this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onMovieClick(int position) {
        Toast.makeText(getContext(),"posición: "+position,Toast.LENGTH_LONG).show();
    }
}