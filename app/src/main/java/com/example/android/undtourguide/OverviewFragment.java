package com.example.android.undtourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {

    public OverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_overview, container, false);

        // Find ImageView with ID overview_image and set the image resource
        ImageView torontoImage = rootView.findViewById(R.id.overview_image);
        torontoImage.setImageResource(R.drawable.toronto_1);

        // Find the TextView with ID overview_text and set the text
        TextView overviewText = rootView.findViewById(R.id.overview_text);
        overviewText.setText(getString(R.string.overview_text));

        // Find the ImageVIew with ID overview_image2 and set the image resource
        ImageView torontoImageSecond = rootView.findViewById(R.id.overview_image2);
        torontoImageSecond.setImageResource(R.drawable.toronto_2);

        // Find the ImageView with ID overview_image3 and set the image resource
        ImageView torontoImageThree = rootView.findViewById(R.id.overview_image3);
        torontoImageThree.setImageResource(R.drawable.toronto_3);

        // FInd the ImageVIew with ID overview_image4 and set the image resource
        ImageView torontoImageFour = rootView.findViewById(R.id.overview_image4);
        torontoImageFour.setImageResource(R.drawable.toronto_4);

        return rootView;
    }
}