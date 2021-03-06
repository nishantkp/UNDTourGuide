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
public class MusicAndNightLifeFragment extends Fragment {

    public MusicAndNightLifeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> nightlifePlaces = new ArrayList<>();
        nightlifePlaces.add(new Attraction(getString(R.string.lost_and_found_title)
                , getString(R.string.lost_and_found_Address)
                , getResources().getString(R.string.lost_and_found)
                , R.drawable.lost_and_found
                , "43.644259, -79.399721"
                , 4.5
                , R.drawable.th_lost_and_found));
        nightlifePlaces.add(new Attraction(getString(R.string.cube_title)
                , getString(R.string.cube_address)
                , getResources().getString(R.string.cube)
                , R.drawable.cube
                , "43.649576, -79.394235"
                , 4.9
                , R.drawable.th_cube));
        nightlifePlaces.add(new Attraction(getString(R.string.nest_title)
                , getString(R.string.nest_address)
                , getResources().getString(R.string.nest)
                , R.drawable.nest
                , "43.656264, -79.407060"
                , 4.2
                , R.drawable.th_nest));
        nightlifePlaces.add(new Attraction(getString(R.string.coda_title)
                , getString(R.string.coda_address)
                , getResources().getString(R.string.coda)
                , R.drawable.coda
                , "43.665331, -79.411438"
                , 4.1
                , R.drawable.th_coda));
        nightlifePlaces.add(new Attraction(getString(R.string.union_title)
                , getString(R.string.union_address)
                , getResources().getString(R.string.uniun)
                , R.drawable.union
                , "43.645618, -79.400014"
                , 4.5
                , R.drawable.th_union));
        nightlifePlaces.add(new Attraction(getString(R.string.maison_mercer_title)
                , getString(R.string.maison_mercer_address)
                , getResources().getString(R.string.maison_mercer)
                , R.drawable.maison_mercer
                , "43.645518, -79.390372"
                , 4.7
                , R.drawable.th_maison_mercer));
        nightlifePlaces.add(new Attraction(getString(R.string.efs_toronto_title)
                , getString(R.string.efs_toronto_address)
                , getResources().getString(R.string.efs_toronto)
                , R.drawable.efs_toronto
                , "43.643751, -79.402145"
                , 3.5
                , R.drawable.th_efs_toronto));
        nightlifePlaces.add(new Attraction(getString(R.string.the_rex_title)
                , getString(R.string.the_rex_address)
                , getResources().getString(R.string.the_rex)
                , R.drawable.the_rex
                , "43.650564, -79.388453"
                , 3.9
                , R.drawable.th_the_rex));
        nightlifePlaces.add(new Attraction(getString(R.string.the_reservoir_lounge_title)
                , getString(R.string.the_reservoir_lounge_address)
                , getResources().getString(R.string.reservoir_loundge)
                , R.drawable.the_reservoir_loundge
                , "43.648566, -79.374627"
                , 4.0
                , R.drawable.the_reservoir_loundge));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), nightlifePlaces);
        ListView listView = rootView.findViewById(R.id.attraction_list);
        listView.setAdapter(adapter);

        // Start new activity to show detail about attraction which is clicked in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new Intent to display detail about the list item clicked on
                Intent intent = new Intent(getActivity(), AttractionDetailActivity.class);

                // Get the Attraction item which is clicked on
                Attraction attraction = nightlifePlaces.get(position);

                /** Create a new Bundle to send data to {@link AttractionDetailActivity} */
                Bundle bundle = new Bundle();
                bundle.putString(Keys.ATTRACTION_NAME_KEY, attraction.getAttractionName());
                bundle.putString(Keys.ATTRACTION_ADDRESS_KEY, attraction.getAttractionAddress());
                bundle.putInt(Keys.ATTRACTION_IMAGE_KEY, attraction.getImageResourceId());
                bundle.putString(Keys.ATTRACTION_LOCATION_KEY, attraction.getLocationId());
                bundle.putString(Keys.ATTRACTION_DETAIL_KEY, attraction.getAttractionDescription());
                bundle.putDouble(Keys.ATTRACTION_RATING_KEY, attraction.getAttractionRating());
                bundle.putInt(Keys.FRAGMENT_IDENTIFIER, 2);

                /**
                 * When identifier is,
                 * 1    ->  ArchitectureFragment
                 * 2    ->  MusicAndNightlifeFragment
                 * 3    ->  RestaurantFragment
                 * 4    ->  ShoppingFragment
                 * That means intent send from specific fragment and it helps in providing title
                 * for {@link AttractionDetailActivity}
                 */
                intent.putExtras(bundle);

                // start new activity
                startActivity(intent);
            }
        });
        return rootView;
    }
}