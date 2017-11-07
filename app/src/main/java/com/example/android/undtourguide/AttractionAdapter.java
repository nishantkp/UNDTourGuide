package com.example.android.undtourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter to display list item for each category i.e Architecture, Shopping
 * Music and Nightlife, Restaurant etc.
 * Created by Nishant on 11/4/2017.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    AttractionAdapter(Context context, ArrayList<Attraction> attraction) {
        super(context, 0, attraction);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Attraction object located at this position in the list
        Attraction currentAttraction = getItem(position);

        // Find the ImageView in list_item.xml by Id for displaying attraction image
        ImageView attractionImage = listItemView.findViewById(R.id.list_item_image);
        assert currentAttraction != null;
        // Get the image of attraction and set the image
        attractionImage.setImageResource(currentAttraction.getImageResourceId());

        // Find the TextView in list_item.xml by Id for displaying attraction name
        TextView attractionName = listItemView.findViewById(R.id.attraction_name);
        // Get the name from attractionName object
        // Set the attraction name on TextView
        attractionName.setText(currentAttraction.getAttractionName());

        // Find the TextView in list_item.cml by id for displaying attraction address
        TextView attractionAddress = listItemView.findViewById(R.id.attraction_address);
        // Get the address from attractionName object
        // Set the attraction address on TextView
        if(currentAttraction.hasPhoneNumber()){
            attractionAddress.setText(currentAttraction.getAttractionPhoneNumber());
            attractionAddress.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        } else {
            attractionAddress.setText(currentAttraction.getAttractionAddress());
            attractionAddress.setTextColor(ContextCompat.getColor(getContext(), R.color.secondaryTextColor));
        }

        return listItemView;
    }
}
