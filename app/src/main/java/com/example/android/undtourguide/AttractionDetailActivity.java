package com.example.android.undtourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AttractionDetailActivity extends AppCompatActivity {

    /**
     * Bundle to receive through Intent from different fragments
     */
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);

        // Get the intent
        bundle = getIntent().getExtras();

        // Find the ImageView for the image of attraction by id of list_item_attraction_image
        ImageView attractionImage = findViewById(R.id.list_item_attraction_image);
        // Get the attraction resource id of image form Bundle and set the image
        attractionImage.setImageResource(bundle.getInt(Keys.ATTRACTION_IMAGE_KEY));

        // Find the textView for the description of the attraction by id of list_item_attraction_description
        TextView attractionDescription = findViewById(R.id.list_item_attraction_description);
        // Get the attraction description from Bundle and set the text
        attractionDescription.setText(bundle.getString(Keys.ATTRACTION_DETAIL_KEY));

        // Find the textView for the Name of the attraction by id of list_item_attraction_name
        TextView attractionName = findViewById(R.id.list_item_attraction_name);
        // Get the attraction name from Bundle and set the text
        attractionName.setText(bundle.getString(Keys.ATTRACTION_NAME_KEY));

        // Find the textView for the address of the attraction by id of list_item_attraction_address_to_google_maps
        TextView attractionAddress = findViewById(R.id.list_item_attraction_address_to_google_maps);
        // Get the attraction address from Bundle and set the text
        attractionAddress.setText(bundle.getString(Keys.ATTRACTION_ADDRESS_KEY));

        // Find the TextView with id of take_me_to_location and attach a listener to it
        // So when user clicks on TextView, it opens up maps through Intent to show location
        TextView openMaps = findViewById(R.id.take_me_to_location);
        openMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getMapsURIString(bundle.getString(Keys.ATTRACTION_LOCATION_KEY))));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * This function is called to generate URI string for map
     * When this URI is passed, it will show marker on the map with name of particular attraction
     * clicked on
     *
     * @param locationId Location string in format (Latitude, Longitude)
     * @return URI for maps in format
     * "geo : Latitude , Longitude ?q = <Latitude> <Longitude> (Label Name)"
     */
    private String getMapsURIString(String locationId) {
        String[] latitudeAndLongitude = locationId.split(",");
        String latitude = latitudeAndLongitude[0];
        String longitude = latitudeAndLongitude[1];
        return "geo:" + latitude + "," + longitude
                + "?q=<" + latitude + ">,<" + longitude + ">,("
                + bundle.getString(Keys.ATTRACTION_NAME_KEY) + ")";
    }
}