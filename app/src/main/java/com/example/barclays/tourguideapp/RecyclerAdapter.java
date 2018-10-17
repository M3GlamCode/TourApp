package com.example.barclays.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private ArrayList<CustomList> attractionList;
    private Context context;

    public RecyclerAdapter(Context context, ArrayList<CustomList> attractionList) {
        this.attractionList = attractionList;
        this.context = context;
    }

    public interface ClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }

    /**
     * Custom ViewHolder with click listeners
     */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        ImageView imageView;
        TextView titleText, contentText;
        ClickListener clickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

                imageView = itemView.findViewById(R.id.attraction_image);
                titleText = itemView.findViewById(R.id.attraction_title);
                contentText = itemView.findViewById(R.id.attraction_content);
                itemView.setOnClickListener(this);

        }

        public void setClickListener(ClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }
    //end of custom ViewHolder

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        /*
         * Setting custom layout of the RecyclerView
         */
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_attraction, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return attractionList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

            CustomList currentList = attractionList.get(position);

            myViewHolder.imageView.setImageResource(currentList.getAttractionImage());
            myViewHolder.titleText.setText(currentList.getAttractionTitle());
            myViewHolder.contentText.setText(currentList.getAttractionContent());

            myViewHolder.setClickListener(new ClickListener() {
                @Override
                public void onClick(View view, int position, boolean isLongClick) {
                    /*
                     * Retrieving the description from the array defined in the strings.xml
                     */
                    String[] description = context.getResources().getStringArray(R.array.attraction_description);
                    final String itemDescription = description[position];

                    String url = attractionList.get(position).getAttractionUrl();

                    /*
                     * Retrieving the addresses from the array defined in the strings.xml
                     */
                    String[] address = context.getResources().getStringArray(R.array.attraction_address);
                    final String itemAddress = address[position];

                    /*
                     * Retrieving data from the ArrayList<CustomList> attractionList
                     */
                    String title = String.valueOf(attractionList.get(position).getAttractionTitle());
                    //String content = String.valueOf(attractionList.get(position).getAttractionContent());
                    int image = attractionList.get(position).getAttractionImage();

                    /*
                     * Passing data from the ArrayList<CustomList> attractionList to the next activity
                     */
                    Intent i = new Intent(context, DetailAttraction.class);
                    i.putExtra("title", title);
                    i.putExtra("image", image);
                    i.putExtra("description", itemDescription);
                    i.putExtra("address", itemAddress);
                    if (attractionList.get(position).getAttractionUrl() != null){
                        i.putExtra("url", url);
                    }

                    context.startActivity(i);

                }
            });
    }
}//end of public class
