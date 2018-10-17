package com.example.barclays.tourguideapp;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailAttraction extends AppCompatActivity {

    final String PACKAGE_NAME = "com.android.chrome";
    CustomTabsClient customTabsClient;
    CustomTabsSession customTabsSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_attraction);

        TextView detailAddress = findViewById(R.id.detail_address);
        TextView detailContent = findViewById(R.id.detail_content);
        ImageView detailImage = findViewById(R.id.detail_image);
        final TextView detailWebsite = findViewById(R.id.detail_website);

        /*
         * Retrieving contents of the ArrayList<CustomList> attractionList and displaying them
         */
        final Bundle extras = getIntent().getExtras();
        if (extras != null){
            String title = extras.getString("title");
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(title);

            String description = extras.getString("description");
            detailContent.setText(description);

            String address = extras.getString("address");
            detailAddress.setText(address);

            final String url = extras.getString("url");
            if (url != null){
                detailWebsite.setText(getString(R.string.visit_site));
                detailWebsite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                            builder.setToolbarColor(ContextCompat.getColor(DetailAttraction.this, R.color.colorPrimary));
                            builder.setCloseButtonIcon(BitmapFactory.decodeResource(getResources(), android.R.drawable.btn_star));
                            builder.setShowTitle(true);

                            CustomTabsServiceConnection customTabsServiceConnection = new CustomTabsServiceConnection() {
                                @Override
                                public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
                                    customTabsClient = client;
                                    client.warmup(0L);
                                    customTabsSession = client.newSession(null);
                                }

                                @Override
                                public void onServiceDisconnected(ComponentName name) {
                                    customTabsClient = null;
                                }
                            };

                            CustomTabsClient.bindCustomTabsService(DetailAttraction.this, PACKAGE_NAME, customTabsServiceConnection);

                            CustomTabsIntent customTabsIntent = builder.build();
                            customTabsIntent.launchUrl(DetailAttraction.this, Uri.parse(url));
                        }

                });

            }else {
                detailWebsite.setVisibility(View.GONE);
            }

            int myImage = extras.getInt("image");
            detailImage.setImageResource(myImage);
        }



    }//end of onCreate

}//end of public class
