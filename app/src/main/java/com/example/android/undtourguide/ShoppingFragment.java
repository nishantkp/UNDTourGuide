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
        shoppingPlaces.add(new Attraction(getString(R.string.eaton_center_title)
                , getString(R.string.eaton_center_address)
                , getResources().getString(R.string.toronto_eton_center)
                , R.drawable.toronto_eaton_center
                , "43.654269, -79.380631"
                , 4.5
                , R.drawable.th_toronto_eaton_center));
        shoppingPlaces.add(new Attraction(getString(R.string.yorkville_vilage_title)
                , getString(R.string.yorkville_village_address)
                , getResources().getString(R.string.yorkville_village)
                , R.drawable.yorkville_villege
                , "43.671573, -79.394954"
                , 4.1
                , R.drawable.th_yorkville_villege));
        shoppingPlaces.add(new Attraction(getString(R.string.yorkdale_shopping_title)
                , getString(R.string.yorkdale_shopping_address)
                , getResources().getString(R.string.yorkdale_shopping_center)
                , R.drawable.yorkdale_shopping_center
                , "43.725146, -79.451793"
                , 4.2
                , R.drawable.th_yorkdale_shopping_center));
        shoppingPlaces.add(new Attraction(getString(R.string.vaughn_mills_title)
                , getString(R.string.vaughn_mills_address)
                , getResources().getString(R.string.vaughn_mills)
                , R.drawable.vaughn_mills
                , "43.825132, -79.538091"
                , 4.2
                , R.drawable.th_vaughn_mills));
        shoppingPlaces.add(new Attraction(getString(R.string.square_one_title)
                , getString(R.string.square_one_address)
                , getResources().getString(R.string.square_one)
                , R.drawable.square_one
                , "43.593287, -79.645891"
                , 4.5
                , R.drawable.th_square_one));
        shoppingPlaces.add(new Attraction(getString(R.string.sherway_garderns_title)
                , getString(R.string.sherway_gardens_address)
                , getResources().getString(R.string.sherway_garden)
                , R.drawable.sherway_gardens
                , "43.610677, -79.557921"
                , 4.8
                , R.drawable.th_sherway_gardens));
        shoppingPlaces.add(new Attraction(getString(R.string.dixie_mall_title)
                , getString(R.string.dixie_mall_address)
                , getResources().getString(R.string.dixie_outlet_malls)
                , R.drawable.dixie_outlet_mall
                , "43.592933, -79.568024"
                , 3.8
                , R.drawable.th_dixie_outlet_mall));
        shoppingPlaces.add(new Attraction(getString(R.string.toronto_outlets_title)
                , getString(R.string.toronto_outlets_address)
                , getResources().getString(R.string.toronto_premium_outlet)
                , R.drawable.toronto_premium_outlet
                , "43.574863, -79.829412"
                , 4.1
                , R.drawable.th_toronto_premium_outlet));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), shoppingPlaces);
        ListView listView = rootView.findViewById(R.id.attraction_list);
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
                bundle.putDouble(Keys.ATTRACTION_RATING_KEY, attraction.getAttractionRating());

                /**
                 * When identifier is,
                 * 1    ->  ArchitectureFragment
                 * 2    ->  MusicAndNightlifeFragment
                 * 3    ->  RestaurantFragment
                 * 4    ->  ShoppingFragment
                 * That means intent send from specific fragment and it helps in providing title
                 * for {@link AttractionDetailActivity}
                 */
                bundle.putInt(Keys.FRAGMENT_IDENTIFIER, 4);
                intent.putExtras(bundle);

                // start new activity
                startActivity(intent);
            }
        });
        return rootView;
    }
}
