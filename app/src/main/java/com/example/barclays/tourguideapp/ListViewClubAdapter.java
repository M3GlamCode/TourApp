package com.example.barclays.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewClubAdapter extends ArrayAdapter<CustomList> {

    public ListViewClubAdapter(Activity activity, ArrayList<CustomList> clubList) {
        super(activity, 0, clubList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View listViewItem, @NonNull ViewGroup parent) {

        if (listViewItem == null){
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.list_club, parent, false);
        }

        CustomList currentItem = getItem(position);

        TextView clubTitle = listViewItem.findViewById(R.id.club_title);
        clubTitle.setText(currentItem.getClubTitle());

        TextView clubAddress = listViewItem.findViewById(R.id.club_address);
        clubAddress.setText(currentItem.getClubAddress());

        TextView clubHours = listViewItem.findViewById(R.id.club_hours);
        clubHours.setText(currentItem.getClubHours());

        TextView clubPhone = listViewItem.findViewById(R.id.club_phone);
        clubPhone.setText(currentItem.getClubPhoneNumber());

        AppCompatRatingBar clubRatingBar = listViewItem.findViewById(R.id.club_rating_bar);
        clubRatingBar.setRating((float) currentItem.getClubStarRating());

        TextView clubRating = listViewItem.findViewById(R.id.club_rating_number);
        clubRating.setText(String.valueOf(currentItem.getClubStarRating()));

        return listViewItem;
    }
}//end of public class
