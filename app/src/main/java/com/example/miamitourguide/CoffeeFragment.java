package com.example.miamitourguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CoffeeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CoffeeFragment() {
        // Required empty public constructor
    }

    /**
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CoffeeFragment.
     */
    public static CoffeeFragment newInstance(String param1, String param2) {
        CoffeeFragment fragment = new CoffeeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.places_list, container, false);
        ListView listView = rootView.findViewById(R.id.list_view);
        ArrayList<Places> placesList = new ArrayList<>();

        placesList.add(new Places("Dr Smood", "(786) 675-5415", "701 S Miami Ave Suite 345", R.drawable.dr_smood, "\"Great Coffee and friendly staff! This is my go to coffee place day or night they are open and ready to serve you the best cup of coffee you will ever have!\""));
        placesList.add(new Places("Vice City Bean", "(305) 726-8031", "1657 N Miami Ave unit c, Miami, FL 33136", R.drawable.vice_city_bean  ));
        placesList.add(new Places("Panther Coffee", "(305) 677-3952", "2390 NW 2nd Ave, Miami, FL 33127", R.drawable.panther_coffee  ));
        placesList.add(new Places("ALL DAY", "(305) 699-3447", "1035 N Miami Ave, Miami, FL 33136", R.drawable.all_day));
        placesList.add(new Places("Suite Habana Cafe", "(786) 387-9771", "2609 N Miami Ave, Miami, FL 33127", R.drawable.suite_habana ));
        placesList.add(new Places("Tea Room", "(786) 805-4655", "788 Brickell Plaza, Miami, FL 33131", R.drawable.tea_room  ));
        placesList.add(new Places("Tea & Poets", "(786) 216-7201", "35701 Sunset Dr Unit 126, South Miami, FL 33143", R.drawable.tea_poets  ));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlaceActivity.class);
                intent.putExtra("IMAGE_ID", placesList.get(position).getImgResourceId());
                intent.putExtra("PLACE_NAME", placesList.get(position).getName());
                intent.putExtra("PLACE_PHONE", placesList.get(position).getPhone());
                intent.putExtra("PLACE_ADDRESS", placesList.get(position).getAddress());
                intent.putExtra("PLACE_SUMMARY", placesList.get(position).getPlaceSummary());
                startActivity(intent);
            }
        });

        PlacesAdapter placesAdapter = new PlacesAdapter(getActivity(), placesList);
        listView.setAdapter(placesAdapter);
        return rootView;
    }
}