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
public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> restaurantPlaces = new ArrayList<>();
        restaurantPlaces.add(new Attraction("Terroni","720 Queen Street West",
                getResources().getString(R.string.terroni),R.drawable.terroni,
                "43.646257, -79.409191",3.9));
        restaurantPlaces.add(new Attraction("Barbque Smokehouse","1299 Roncesvalles Avenue",
                getResources().getString(R.string.barbqe_smokehouse),R.drawable.barbque_smokehouse,
                "43.647955, -79.449589",3.8));
        restaurantPlaces.add(new Attraction("Il Fornello","576 Danforth Avenue",
                getResources().getString(R.string.il_fornello),R.drawable.il_fornello,
                "43.678641, -79.347077",4.5));
        restaurantPlaces.add(new Attraction("Uncle Betty's Dinner","2590 Yonge Street",
                getResources().getString(R.string.uncle_bettys),R.drawable.uncle_bettys_diner,
                "43.714368, -79.400314",4.8));
        restaurantPlaces.add(new Attraction("The Ace","231a Roncesvalles Avenue",
                getResources().getString(R.string.the_ace),R.drawable.the_ace,
                "43.646100, -79.448782",4.0));
        restaurantPlaces.add(new Attraction("Magic Oven","798 Danforth Avenue",
                getResources().getString(R.string.magic_oven),R.drawable.magic_oven,
                "43.682893, -79.326474",4.1));
        restaurantPlaces.add(new Attraction("Mandarin","2200 Yonge Street",
                getResources().getString(R.string.mandarin),R.drawable.mandarin,
                "43.705844, -79.398479",4.5));
        restaurantPlaces.add(new Attraction("The Old Spaghetti Factory","54 The Esplanade",
                getResources().getString(R.string.the_old_spaghetti_factory),R.drawable.the_old_spaghetti_factory,
                "43.646956, -79.374389",3.7));
        restaurantPlaces.add(new Attraction("PAN on The Danforth","516 Danforth Avenue",
                getResources().getString(R.string.pan_on_danforth),R.drawable.pan_on_denforth,
                "43.678370, -79.348710",3.9));
        restaurantPlaces.add(new Attraction("Libson by Night","802 Dundas Street West",
                getResources().getString(R.string.lisbon_by_night),R.drawable.libson_by_night,
                "43.651886, -79.408764",4.1));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), restaurantPlaces);
        ListView listView = rootView.findViewById(R.id.attraction_list);

        // Find the View with ID list_view_header, change the text and attach to ListView
        /*
        View header = View.inflate(getContext(), R.layout.list_view_header, null);
        TextView headerText = header.findViewById(R.id.list_header);
        headerText.setText("Restaurant");
        listView.addHeaderView(header);*/

        listView.setAdapter(adapter);

        // Start new activity to show detail about attraction which is clicked in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new Intent to display detail about the list item clicked on
                Intent intent = new Intent(getActivity(), AttractionDetailActivity.class);

                // Get the Attraction item which is clicked on
                Attraction attraction = restaurantPlaces.get(position);

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
