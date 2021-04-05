package com.mx.monzon.multipantalla.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mx.monzon.multipantalla.R;
import com.mx.monzon.multipantalla.model.Movie;
import com.mx.monzon.multipantalla.utils.MyUtils;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>{

    List<Movie> list;
    private OnAdapterListener mOnAdapterListener;

    public MoviesAdapter(List<Movie> list, OnAdapterListener onAdapterListener){
        this.mOnAdapterListener = onAdapterListener;
        this.list = list;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        TextView tvName;
        ImageView imageView;
        OnAdapterListener onAdapterListener;

        public MovieViewHolder(@NonNull View itemView, OnAdapterListener onAdapterListener) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view_movies_item);
            tvName = itemView.findViewById(R.id.tv_name_item);
            imageView = itemView.findViewById(R.id.img_movies_item);
            this.onAdapterListener = onAdapterListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            onAdapterListener.onMovieClick(getAdapterPosition());
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_movies_item, viewGroup, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view, mOnAdapterListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder personViewHolder, int i) {
        personViewHolder.tvName.setText(list.get(i).getName());
        //personViewHolder.imageView.setImageResource(list.get(i).getImage());
        //int resource = R.drawable.abcdelamor;
        //int resource2 = list.get(i).getImage();
        //MyUtils.printLog("Adapter","resource " + resource);
        //MyUtils.printLog("Adapter","resource2 " + resource2);
        personViewHolder.imageView.setImageResource(list.get(i).getImage());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public Movie getItem(int position){
        return list.get(position);
    }

    public interface OnAdapterListener{
        void onMovieClick(int position);
    }
}
