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
public class ClubFragment extends android.support.v4.app.Fragment {

    public ClubFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_club, container, false);

        ArrayList<CustomList> clubList = new ArrayList<>();
        clubList.add(new CustomList(getString(R.string.gipsy), getString(R.string.gipsy_location),
                getString(R.string.gipsy_hours), getString(R.string.gipsy_phone),
                4.0));
        clubList.add(new CustomList(getString(R.string.havana), getString(R.string.havana_location),
                getString(R.string.havana_hours), getString(R.string.havana_phone),
                4.7));
        clubList.add(new CustomList(getString(R.string.klub), getString(R.string.klub_location),
                getString(R.string.klub_hours), getString(R.string.klub_phone),
                3.7));
        clubList.add(new CustomList(getString(R.string.bacchu), getString(R.string.bacchu_location),
                getString(R.string.bacchu_hours), getString(R.string.bacchu_phone),
                4.2));
        clubList.add(new CustomList(getString(R.string.pavement), getString(R.string.pavement_location),
                getString(R.string.pavement_hours), getString(R.string.pavement_phone),
                4.0));

        ListViewClubAdapter adapter = new ListViewClubAdapter(getActivity(), clubList);

        ListView listView = v.findViewById(R.id.list_view_club);
        listView.setAdapter(adapter);

        return v;
    }

}//end of public class
