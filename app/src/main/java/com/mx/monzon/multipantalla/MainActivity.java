package com.mx.monzon.multipantalla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.mx.monzon.multipantalla.fragments.DetailFragment;
import com.mx.monzon.multipantalla.fragments.ShowListFragment;
import com.mx.monzon.multipantalla.model.Movie;

public class MainActivity extends AppCompatActivity implements ShowListFragment.OnShowListListener {
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) !=null
        && savedInstanceState == null){
            ShowListFragment fragment = new ShowListFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.setReorderingAllowed(true).add(R.id.fragment_container, fragment, null).addToBackStack(null).commit();
        }
    }
    @Override
    public void onItemSelected(Movie movie) {
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_detail);
        if(findViewById(R.id.fragment_detail) != null)
            detailFragment.upDateMovie(movie);
        else{
            DetailFragment fragment =  DetailFragment.newInstance(movie);
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.setReorderingAllowed(true).replace(R.id.fragment_container, fragment, null).addToBackStack(null).commit();
        }
    }
}