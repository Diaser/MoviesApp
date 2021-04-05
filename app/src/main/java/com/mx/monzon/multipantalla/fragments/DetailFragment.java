package com.mx.monzon.multipantalla.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mx.monzon.multipantalla.R;
import com.mx.monzon.multipantalla.model.Movie;

public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private TextView tvname, tvDescription;
    private ImageView image;
    private Movie movie;
    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(Movie param1) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.movie = (Movie) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvname = view.findViewById(R.id.tv_name_item);
        tvDescription = view.findViewById(R.id.tv_description);
        image = view.findViewById(R.id.image);
        upDateMovie(movie);
        scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    //do something
                    scaleGestureDetector.onTouchEvent(event);
                }
                return true;
            }
        });

    }
    public void upDateMovie(Movie movie){
        if(movie != null){
            tvname.setText(movie.getName());
            tvDescription.setText(movie.getDescription());
            image.setImageResource(movie.getImage());
        }
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            image.setScaleX(mScaleFactor);
            image.setScaleY(mScaleFactor);
            return true;
        }
    }

}