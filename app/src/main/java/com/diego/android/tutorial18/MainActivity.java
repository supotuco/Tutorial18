package com.diego.android.tutorial18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView list_view_movie_list;
    int[] movie_poster_resource = {R.drawable.img_avengers, R.drawable.img_dark_kinght, R.drawable.img_jurassic_park};
    String[] movie_title;
    String[] movie_rating;
    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view_movie_list = (ListView) findViewById(R.id.list_view_movie_list);
        movie_title = getResources().getStringArray(R.array.movie_titles);
        movie_rating = getResources().getStringArray(R.array.movie_ratings);
        movieAdapter = new MovieAdapter(getApplicationContext(), R.layout.layout_movie_row);

        MovieDataProvider[] movieDataProviders = new MovieDataProvider[movie_title.length];
        for(int i = 0; i < movieDataProviders.length; i = i + 1){
            movieDataProviders[i] = new MovieDataProvider(  movie_poster_resource[i],
                                                            movie_title[i],
                                                            movie_rating[i]);
            movieAdapter.add(movieDataProviders[i]);
        }


        list_view_movie_list.setAdapter(movieAdapter);

    }
}
