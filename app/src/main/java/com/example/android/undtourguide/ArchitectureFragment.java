package com.example.android.undtourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArchitectureFragment extends Fragment {

    public ArchitectureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> architecturePlaces = new ArrayList<Attraction>();
        architecturePlaces.add(new Attraction("CN Tower", "301 Front St W",
                getResources().getString(R.string.cn_tower), R.drawable.cn_tower,
                "geo:43.642482,-79.387074?z=18"));
        architecturePlaces.add(new Attraction("New City Hall", "100 Queen St W",
                getResources().getString(R.string.new_city_hall), R.drawable.new_city_hall,
                "geo:43.653311,-79.383988?z=18"));
        architecturePlaces.add(new Attraction("Old City Hall", "60 Queen St W",
                getResources().getString(R.string.old_city_hall), R.drawable.old_city_hall,
                "geo:43.652453, -79.381980?z=18"));
        architecturePlaces.add(new Attraction("Art Gallery of Ontario", "317 Dundas St W",
                getResources().getString(R.string.art_gallary_of_ontario), R.drawable.art_galary_of_ontario,
                "geo:43.653759, -79.392656?z=18"));
        architecturePlaces.add(new Attraction("Royal Ontario Museum", "100 Queens Park",
                getResources().getString(R.string.royal_ontario_museum), R.drawable.royal_ontario_museum,
                "geo:43.667656, -79.394521?z=18"));
        architecturePlaces.add(new Attraction("Commerce Court North", "199 Bay St, Ground Floor",
                getResources().getString(R.string.commerce_court_north), R.drawable.commerce_court_north,
                "geo:43.648623, -79.379242?z=18"));
        architecturePlaces.add(new Attraction("Roy Thompson Hall", "60 Simcoe St",
                getResources().getString(R.string.royal_ontario_museum), R.drawable.roy_thompson_hall,
                "geo:43.646491, -79.386469?z=18"));
        architecturePlaces.add(new Attraction("Union Station", "Toronto, ON M5J 1E6",
                getResources().getString(R.string.union_station), R.drawable.union_station,
                "geo:43.645076, -79.380849?z=18"));
        architecturePlaces.add(new Attraction("The Royal York", "100 Front St W",
                getResources().getString(R.string.the_royal_york), R.drawable.the_royal_york,
                "geo:43.645803, -79.381302?z=18"));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), architecturePlaces);
        ListView listView = rootView.findViewById(R.id.attraction_list);

        // Attach a header to ListView
        /*
        View header = View.inflate(getContext(), R.layout.list_view_header, null);
        TextView headerText = header.findViewById(R.id.list_header);
        headerText.setText("Architecture");
        listView.addHeaderView(header);*/

        listView.setAdapter(adapter);

        // Start new activity to show detail about attraction which is clicked in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new Intent to display detail about the list item clicked on
                Intent intent = new Intent(getActivity(), AttractionDetailActivity.class);

                // Get the Attraction item which is clicked on
                Attraction attraction = architecturePlaces.get(position);

                /** Create a new Bundle to send data to {@link AttractionDetailActivity} */
                Bundle bundle = new Bundle();
                bundle.putString(Keys.ATTRACTION_NAME_KEY, attraction.getAttractionName());
                bundle.putString(Keys.ATTRACTION_ADDRESS_KEY, attraction.getAttractionAddress());
                bundle.putInt(Keys.ATTRACTION_IMAGE_KEY, attraction.getImageResourceId());
                bundle.putString(Keys.ATTRACTION_LOCATION_KEY, attraction.getLocationId());
                bundle.putInt(Keys.ATTRACTION_IMAGE_KEY, attraction.getImageResourceId());

                // start new activity
                startActivity(intent);
            }
        });
        return rootView;
    }
}