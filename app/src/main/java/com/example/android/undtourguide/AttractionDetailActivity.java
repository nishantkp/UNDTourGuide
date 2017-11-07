package com.example.android.undtourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class AttractionDetailActivity extends AppCompatActivity {

    /**
     * Bundle to receive through Intent from different fragments
     * i.e,
     * {@link ArchitectureFragment} {@link MusicAndNightLifeFragment}
     * {@link RestaurantFragment} {@link ShoppingFragment}
     */
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);

        // Get the bundle sent from different fragments
        bundle = getIntent().getExtras();

        /**
         * Set the title of {@link AttractionDetailActivity} according to fragment identifier
         * i.e,
         * 1    ->  Architecture : meaning intent received from {@link ArchitectureFragment}
         * 2    ->  Music and Nightlife : meaning intent received from {@link MusicAndNightLifeFragment}
         * 3    ->  Restaurant : meaning intent received from {@link RestaurantFragment}
         * 4    ->  Shopping : meaning intent received from {@link ShoppingFragment}
         */
        assert bundle != null;
        int identifier = bundle.getInt(Keys.FRAGMENT_IDENTIFIER);
        switch (identifier) {
            case 1:
                setTitle(getString(R.string.architecture_category));
                break;
            case 2:
                setTitle(getString(R.string.music_and_nightlife_category));
                break;
            case 3:
                setTitle(getString(R.string.restaurant_category));
                break;
            case 4:
                setTitle(R.string.shopping_category);
                break;
        }

        // If Bundle contains phone number, then show the phone icon to perform call operation
        // and phone number in contact section
        View phoneIcon = findViewById(R.id.detail_activity_phone_icon_layout);
        View phoneNumberInContactSection = findViewById(R.id.detail_activity_phone_number_layout);
        if (bundle.containsKey(Keys.ATTRACTION_PHONE_NUMBER_KEY)) {
            phoneIcon.setVisibility(View.VISIBLE);
            phoneNumberInContactSection.setVisibility(View.VISIBLE);

            // Display phone number in Contact section
            showPhoneNumberAndMakeCall();
        } else {
            // If bundle doesn't contain phone number, hide the phone icon
            // and phone number from thr contact section
            phoneIcon.setVisibility(View.GONE);
            phoneNumberInContactSection.setVisibility(View.GONE);
        }

        // Find the ImageView for the image of attraction by id of list_item_attraction_image
        ImageView attractionImage = findViewById(R.id.detail_activity_attraction_image);
        // Get the attraction resource id of image form Bundle and set the image
        attractionImage.setImageResource(bundle.getInt(Keys.ATTRACTION_IMAGE_KEY));

        // Find the textView for the description of the attraction by id of list_item_attraction_description
        TextView attractionDescription = findViewById(R.id.detail_activity_attraction_description);
        // Get the attraction description from Bundle and set the text
        attractionDescription.setText(bundle.getString(Keys.ATTRACTION_DETAIL_KEY));

        // Find the textView for the Name of the attraction by id of list_item_attraction_name
        TextView attractionName = findViewById(R.id.detail_activity_attraction_name);
        // Get the attraction name from Bundle and set the text
        attractionName.setText(bundle.getString(Keys.ATTRACTION_NAME_KEY));

        // Find the textView for the address of the attraction by id of list_item_attraction_address_to_google_maps
        TextView attractionAddress = findViewById(R.id.detail_activity_attraction_address);
        // Get the attraction address from Bundle and set the text
        attractionAddress.setText(bundle.getString(Keys.ATTRACTION_ADDRESS_KEY));

        // Find the TextView for displaying rating with id of rating_text
        TextView ratingText = findViewById(R.id.detail_activity_rating_text);
        // Get the attraction ratting from Bundle and set the text
        ratingText.setText(String.valueOf(bundle.getDouble(Keys.ATTRACTION_RATING_KEY)));

        // Find the RatingBar with id of ratting_bar
        RatingBar ratingBar = findViewById(R.id.detail_activity_ratting_bar);
        // Convert the rating into float from double and set the RatingBar
        ratingBar.setRating((float) bundle.getDouble(Keys.ATTRACTION_RATING_KEY));

        // Find the TextView with id of take_me_to_location and attach a listener to it
        // So when user clicks on TextView, it opens up maps through Intent to show location
        TextView openMaps = findViewById(R.id.detail_activity_take_me_to_location);
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

    /**
     * This function is called to display phone number in
     * Contact section of activity_attraction_detail. and attach a click listener to phone icon
     * So when user clicks on phone icon, they can make a call
     */
    private void showPhoneNumberAndMakeCall() {
        // Find the TextView with Id list_item_attraction_phone_number and set the phone number
        TextView phoneNumber = findViewById(R.id.detail_activity_attraction_phone_number);
        phoneNumber.setText(bundle.getString(Keys.ATTRACTION_PHONE_NUMBER_KEY));

        // Find the ImageView with id detail_activity_phone_icon and attach a listener to it
        // When user clicks on Image, start a new Intent to make a phone call
        ImageView callIcon = findViewById(R.id.detail_activity_phone_icon);
        callIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = bundle.getString(Keys.ATTRACTION_PHONE_NUMBER_KEY);
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);
            }
        });
    }
}