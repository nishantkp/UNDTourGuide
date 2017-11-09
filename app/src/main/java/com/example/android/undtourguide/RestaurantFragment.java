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
        restaurantPlaces.add(new Attraction(getString(R.string.terroni_title), getString(R.string.terroni_address),
                getResources().getString(R.string.terroni), R.drawable.terroni,
                "43.646257, -79.409191", 3.9, "(416) 504-1992"));
        restaurantPlaces.add(new Attraction(getString(R.string.smokehouse_title), getString(R.string.smokehouse_address),
                getResources().getString(R.string.barbqe_smokehouse), R.drawable.barbque_smokehouse,
                "43.647955, -79.449589", 3.8, "(416) 532-7700"));
        restaurantPlaces.add(new Attraction(getString(R.string.il_fornello_title), getString(R.string.il_fornello_address),
                getResources().getString(R.string.il_fornello), R.drawable.il_fornello,
                "43.678641, -79.347077", 4.5, "(416) 466-2931"));
        restaurantPlaces.add(new Attraction(getString(R.string.uncle_betty_title), getString(R.string.uncle_betty_address),
                getResources().getString(R.string.uncle_bettys), R.drawable.uncle_bettys_diner,
                "43.714368, -79.400314", 4.8, "(416) 483-2590"));
        restaurantPlaces.add(new Attraction(getString(R.string.the_ace_title), getString(R.string.the_ace_address),
                getResources().getString(R.string.the_ace), R.drawable.the_ace,
                "43.646100, -79.448782", 4.0, "(416) 792-7729"));
        restaurantPlaces.add(new Attraction(getString(R.string.magic_oven_title), getString(R.string.magic_oven_address),
                getResources().getString(R.string.magic_oven), R.drawable.magic_oven,
                "43.682893, -79.326474", 4.1, "(416) 462-0333"));
        restaurantPlaces.add(new Attraction(getString(R.string.mandarin_title), getString(R.string.mandarin_address),
                getResources().getString(R.string.mandarin), R.drawable.mandarin,
                "43.705844, -79.398479", 4.5, "(416) 486-2222"));
        restaurantPlaces.add(new Attraction(getString(R.string.spaghetti_factory_title), getString(R.string.spaghetti_factory_address),
                getResources().getString(R.string.the_old_spaghetti_factory), R.drawable.the_old_spaghetti_factory,
                "43.646956, -79.374389", 3.7, "(416) 864-9761"));
        restaurantPlaces.add(new Attraction(getString(R.string.pan_title), getString(R.string.pan_address),
                getResources().getString(R.string.pan_on_danforth), R.drawable.pan_on_denforth,
                "43.678370, -79.348710", 3.9, "(416) 466-8158"));
        restaurantPlaces.add(new Attraction(getString(R.string.libson_title), getString(R.string.libson_address),
                getResources().getString(R.string.lisbon_by_night), R.drawable.libson_by_night,
                "43.651886, -79.408764", 4.1, "(416) 603-6522"));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), restaurantPlaces);
        ListView listView = rootView.findViewById(R.id.attraction_list);
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
                bundle.putDouble(Keys.ATTRACTION_RATING_KEY, attraction.getAttractionRating());
                bundle.putString(Keys.ATTRACTION_PHONE_NUMBER_KEY, attraction.getAttractionPhoneNumber());

                /**
                 * When identifier is,
                 * 1    ->  ArchitectureFragment
                 * 2    ->  MusicAndNightlifeFragment
                 * 3    ->  RestaurantFragment
                 * 4    ->  ShoppingFragment
                 * That means intent send from specific fragment and it helps in providing title
                 * for {@link AttractionDetailActivity}
                 */
                bundle.putInt(Keys.FRAGMENT_IDENTIFIER, 3);
                intent.putExtras(bundle);

                // start new activity
                startActivity(intent);
            }
        });
        return rootView;
    }
}
