package com.example.barclays.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<CustomList> {

    public ListViewAdapter(Activity activity, ArrayList<CustomList> hotelList) {
        super(activity, 0,hotelList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View listViewItem, @NonNull ViewGroup parent) {

        if (listViewItem == null){
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.list_hotel, parent, false);
        }

        CustomList currentItem = getItem(position);

        ImageView hotelImage = listViewItem.findViewById(R.id.hotel_image);
        hotelImage.setImageResource(currentItem.getHotelImage());

        TextView hotelName = listViewItem.findViewById(R.id.hotel_name);
        hotelName.setText(currentItem.getHotelTitle());

        TextView hotelDescription = listViewItem.findViewById(R.id.hotel_description);
        hotelDescription.setText(currentItem.getHotelContent());

        AppCompatRatingBar ratingBar = listViewItem.findViewById(R.id.rating_bar);
        ratingBar.setRating((float) currentItem.getStarRating());

        TextView rating = listViewItem.findViewById(R.id.rating_number);
        rating.setText(String.valueOf(currentItem.getStarRating()));

        return listViewItem;
    }

}//end of public class
