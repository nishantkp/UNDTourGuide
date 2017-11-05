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
        nightlifePlaces.add(new Attraction("Lost and Found", "577 King Street West",
                getResources().getString(R.string.lost_and_found), R.drawable.lost_and_found,
                "geo:43.644259, -79.399721?z=18"));
        nightlifePlaces.add(new Attraction("Cube", "314 Queen Street West",
                getResources().getString(R.string.cube), R.drawable.cube,
                "geo:43.649576, -79.394235?z=18"));
        nightlifePlaces.add(new Attraction("Nest", "423 College Street",
                getResources().getString(R.string.nest), R.drawable.nest,
                "geo:43.656264, -79.407060?z=18"));
        nightlifePlaces.add(new Attraction("Coda", "794 Bathurst Street",
                getResources().getString(R.string.coda), R.drawable.coda,
                "geo:43.665331, -79.411438?z=18"));
        nightlifePlaces.add(new Attraction("Union", "473 Adelaide Street West",
                getResources().getString(R.string.uniun), R.drawable.union,
                "geo:43.645618, -79.400014?z=18"));
        nightlifePlaces.add(new Attraction("Maison Mercer", "15 Mercer Street",
                getResources().getString(R.string.maison_mercer), R.drawable.maison_mercer,
                "geo:43.645518, -79.390372?z=18"));
        nightlifePlaces.add(new Attraction("EFS Toronto", "647 King Street West",
                getResources().getString(R.string.efs_toronto), R.drawable.efs_toronto,
                "geo:43.643751, -79.402145?z=18"));
        nightlifePlaces.add(new Attraction("The Rex", "149 Queen Street West",
                getResources().getString(R.string.the_rex), R.drawable.the_rex,
                "geo:43.650564, -79.388453?z=18"));
        nightlifePlaces.add(new Attraction("The Reservoir Lounge", "52 Wellington Street",
                getResources().getString(R.string.reservoir_loundge), R.drawable.the_reservoir_loundge,
                "geo:43.648566, -79.374627?z=18"));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), nightlifePlaces);
        ListView listView = rootView.findViewById(R.id.attraction_list);

        // Attach a header to ListView
        /*
        View header = View.inflate(getContext(), R.layout.list_view_header, null);
        TextView headerText = header.findViewById(R.id.list_header);
        headerText.setText("Music and Nightlife");
        listView.addHeaderView(header);*/

        listView.setAdapter(adapter);

        // Start new activity to show detail about attraction which is clicked in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Create a new Intent to display detail about the list item clicked on
                Intent intent = new Intent(getActivity(), AttractionDetailActivity.class);

                // start new activity
                startActivity(intent);
            }
        });
        return rootView;
    }
}