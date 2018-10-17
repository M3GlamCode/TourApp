package com.example.barclays.tourguideapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class AttractionFragment extends android.support.v4.app.Fragment {

    public ArrayList<CustomList> attractionList;

    public AttractionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_attraction, container, false);

        attractionList = new ArrayList<>();
        attractionList.add(new CustomList(getString(R.string.bomas_of_kenya), getString(R.string.description_one), R.drawable.bomas_of_kenya, "http://www.bomasofkenya.co.ke/"));
        attractionList.add(new CustomList(getString(R.string.giraffe_centre), getString(R.string.description_two), R.drawable.giraffe_centre,"http://giraffecenter.org/"));
        attractionList.add(new CustomList(getString(R.string.nairobi_national_museum), getString(R.string.description_three), R.drawable.nairobi_national_museum));
        attractionList.add(new CustomList(getString(R.string.nairobi_national_park), getString(R.string.description_four), R.drawable.nairobi_national_park, "http://www.kws.go.ke/parks/nairobi-national-park"));

        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(), attractionList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return v;
    }

}//end of public class
