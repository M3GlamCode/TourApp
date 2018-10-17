package com.example.barclays.tourguideapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class HotelFragment extends android.support.v4.app.Fragment {

    public ArrayList<CustomList> hotelList;

    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hotel, container, false);

        hotelList = new ArrayList<>();
        hotelList.add(new CustomList(getString(R.string.hilton), R.drawable.hilton_hotel, getString(R.string.content_hilton), 4.3));
        hotelList.add(new CustomList(getString(R.string.intercontinental), R.drawable.intercontinental_hotel, getString(R.string.content_intercontinental), 4.4));
        hotelList.add(new CustomList(getString(R.string.safari_park), R.drawable.safari_park_hotel, getString(R.string.content_safari_park), 4.5));
        hotelList.add(new CustomList(getString(R.string.clarion), R.drawable.clarion_hotel, getString(R.string.content_clarion), 3.9));
        hotelList.add(new CustomList(getString(R.string.crowne_plaza), R.drawable.crowne_plaza_hotel, getString(R.string.content_crowne_plaza), 4.4));
        hotelList.add(new CustomList(getString(R.string.ambassadeur), R.drawable.ambassadeur_hotel, getString(R.string.content_ambassadeur), 3.7));

        ListViewAdapter adapter = new ListViewAdapter(getActivity(), hotelList);

        ListView listView = v.findViewById(R.id.list_view_hotel);
        listView.setAdapter(adapter);

        return v;
    }

}
