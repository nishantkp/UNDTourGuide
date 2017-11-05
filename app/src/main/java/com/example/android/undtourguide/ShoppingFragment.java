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
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> shoppingPlaces = new ArrayList<>();
        shoppingPlaces.add(new Attraction("Toronto Eaton Center","220 Yonge St",
                getResources().getString(R.string.toronto_eton_center),R.drawable.toronto_eaton_center,
                "43.654269, -79.380631"));
        shoppingPlaces.add(new Attraction("Yorkville Village","55 Avenue Rd",
                getResources().getString(R.string.yorkville_village),R.drawable.yorkville_villege,
                "43.671573, -79.394954"));
        shoppingPlaces.add(new Attraction("Yorkdale Shopping Center","3401 Dufferin Street, North York",
                getResources().getString(R.string.yorkdale_shopping_center),R.drawable.yorkdale_shopping_center,
                "43.725146, -79.451793"));
        shoppingPlaces.add(new Attraction("Vaughan Mills","1 Bass Pro Mills Dr, Concord",
                getResources().getString(R.string.vaughn_mills),R.drawable.vaughn_mills,
                "43.825132, -79.538091"));
        shoppingPlaces.add(new Attraction("Square One","100 City Centre Dr, Mississauga",
                getResources().getString(R.string.square_one),R.drawable.square_one,
                "43.593287, -79.645891"));
        shoppingPlaces.add(new Attraction("Sherway Gardens","25 The West Mall, Etobicoke",
                getResources().getString(R.string.sherway_garden),R.drawable.sherway_gardens,
                "43.610677, -79.557921"));
        shoppingPlaces.add(new Attraction("Dixie Outlet Malls","1250 S Service Rd, Mississauga",
                getResources().getString(R.string.dixie_outlet_malls),R.drawable.dixie_outlet_mall,
                "43.592933, -79.568024"));
        shoppingPlaces.add(new Attraction("Toronto Premium Outlets","13850 Steeles Avenue W, Halton Hills",
                getResources().getString(R.string.toronto_premium_outlet),R.drawable.toronto_premium_outlet,
                "43.574863, -79.829412"));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), shoppingPlaces);
        ListView listView = rootView.findViewById(R.id.attraction_list);

        // Find the View with ID list_view_header, change the text and attach to ListView
        /*
        View header = View.inflate(getContext(), R.layout.list_view_header, null);
        TextView headerText = header.findViewById(R.id.list_header);
        headerText.setText("Shopping");
        listView.addHeaderView(header);*/

        listView.setAdapter(adapter);

        // Start new activity to show detail about attraction which is clicked in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new Intent to display detail about the list item clicked on
                Intent intent = new Intent(getActivity(), AttractionDetailActivity.class);

                // Get the Attraction item which is clicked on
                Attraction attraction = shoppingPlaces.get(position);

                /** Create a new Bundle to send data to {@link AttractionDetailActivity} */
                Bundle bundle = new Bundle();
                bundle.putString(Keys.ATTRACTION_NAME_KEY, attraction.getAttractionName());
                bundle.putString(Keys.ATTRACTION_ADDRESS_KEY, attraction.getAttractionAddress());
                bundle.putInt(Keys.ATTRACTION_IMAGE_KEY, attraction.getImageResourceId());
                bundle.putString(Keys.ATTRACTION_LOCATION_KEY, attraction.getLocationId());
                bundle.putString(Keys.ATTRACTION_DETAIL_KEY, attraction.getAttractionDescription());
                intent.putExtras(bundle);

                // start new activity
                startActivity(intent);
            }
        });
        return rootView;
    }
}
