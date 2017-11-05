package com.example.android.undtourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
                "geo:43.646257, -79.409191?z=18"));
        restaurantPlaces.add(new Attraction("Barbque Smokehouse","1299 Roncesvalles Avenue",
                getResources().getString(R.string.barbqe_smokehouse),R.drawable.barbque_smokehouse,
                "geo:43.647955, -79.449589?z=18"));
        restaurantPlaces.add(new Attraction("Il Fornello","576 Danforth Avenue",
                getResources().getString(R.string.il_fornello),R.drawable.il_fornello,
                "geo:43.678641, -79.347077?z=18"));
        restaurantPlaces.add(new Attraction("Uncle Betty's Dinner","2590 Yonge Street",
                getResources().getString(R.string.uncle_bettys),R.drawable.uncle_bettys_diner,
                "geo:43.714368, -79.400314?z=18"));
        restaurantPlaces.add(new Attraction("The Ace","231a Roncesvalles Avenue",
                getResources().getString(R.string.the_ace),R.drawable.the_ace,
                "geo:43.646100, -79.448782?z=18"));
        restaurantPlaces.add(new Attraction("Magic Oven","798 Danforth Avenue",
                getResources().getString(R.string.magic_oven),R.drawable.magic_oven,
                "geo:43.682893, -79.326474?z=18"));
        restaurantPlaces.add(new Attraction("Mandarin","2200 Yonge Street",
                getResources().getString(R.string.mandarin),R.drawable.mandarin,
                "geo:43.705844, -79.398479?z=18"));
        restaurantPlaces.add(new Attraction("The Old Spaghetti Factory","54 The Esplanade",
                getResources().getString(R.string.the_old_spaghetti_factory),R.drawable.the_old_spaghetti_factory,
                "geo:43.646956, -79.374389?z=18"));
        restaurantPlaces.add(new Attraction("PAN on The Danforth","516 Danforth Avenue",
                getResources().getString(R.string.pan_on_danforth),R.drawable.pan_on_denforth,
                "geo:43.678370, -79.348710?z=18"));
        restaurantPlaces.add(new Attraction("Libson by Night","802 Dundas Street West",
                getResources().getString(R.string.lisbon_by_night),R.drawable.libson_by_night,
                "geo:43.651886, -79.408764?z=18"));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), restaurantPlaces);
        ListView listView = rootView.findViewById(R.id.attraction_list);

        // Find the View with ID list_view_header, change the text and attach to ListView
        /*
        View header = View.inflate(getContext(), R.layout.list_view_header, null);
        TextView headerText = header.findViewById(R.id.list_header);
        headerText.setText("Restaurant");
        listView.addHeaderView(header);*/

        listView.setAdapter(adapter);
        return rootView;
    }
}
