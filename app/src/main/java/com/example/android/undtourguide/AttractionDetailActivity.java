package com.example.android.undtourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class AttractionDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);

        // Get the intent
        Bundle bundle = getIntent().getExtras();

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
    }
}