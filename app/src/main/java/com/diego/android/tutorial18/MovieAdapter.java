package com.diego.android.tutorial18;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego on 3/13/16.
 */
public class MovieAdapter extends ArrayAdapter<MovieDataProvider> {

    List<MovieDataProvider> list = new ArrayList<>();

    public MovieAdapter(Context context, int resource) {
        super(context, resource);

    }

    @Override
    public void add(MovieDataProvider obj){
        super.add(obj);
        list.add(obj);
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public MovieDataProvider getItem(int position){
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row;
        row = convertView;
        DataHandler dataHandler;
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.layout_movie_row, parent, false);
            dataHandler = new DataHandler(  (ImageView)row.findViewById(R.id.image_view_movie_poster),
                                            (TextView)row.findViewById(R.id.text_view_movie_title),
                                            (TextView)row.findViewById(R.id.text_view_movie_rating));
            row.setTag(dataHandler);

        }else{
            dataHandler = (DataHandler) row.getTag();
        }

        MovieDataProvider item = this.getItem(position);

        dataHandler.movie_poster.setImageResource(item.getMovie_poster_resource());
        dataHandler.movie_title.setText(item.getMovie_title());
        dataHandler.movie_rating.setText(item.getMovie_rating());

        return row;

    }

    protected static class DataHandler{
        ImageView movie_poster;
        TextView movie_title;
        TextView movie_rating;



        public DataHandler(ImageView movie_poster, TextView movie_title, TextView movie_rating){
            this.movie_poster = movie_poster;
            this.movie_title = movie_title;
            this.movie_rating = movie_rating;
        }

        public ImageView getMovie_poster() {
            return movie_poster;
        }

        public void setMovie_poster(ImageView movie_poster) {
            this.movie_poster = movie_poster;
        }

        public TextView getMovie_title() {
            return movie_title;
        }

        public void setMovie_title(TextView movie_title) {
            this.movie_title = movie_title;
        }

        public TextView getMovie_rating() {
            return movie_rating;
        }

        public void setMovie_rating(TextView movie_rating) {
            this.movie_rating = movie_rating;
        }
    }
}
