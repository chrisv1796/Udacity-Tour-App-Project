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

public class DiningFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public DiningFragment() {
        // Required empty public constructor
    }

    /**
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiningFragment.
     */
    public static DiningFragment newInstance(String param1, String param2) {
        DiningFragment fragment = new DiningFragment();
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

        placesList.add(new Places("The Capital Grille", "(305)374-4500", "444 Brickell Ave, Miami, FL 33131", R.drawable.capital_grille_image, "The Capital Grille is an amazing place to dine! Great prices and very friendly staff. Oh! And the food is great! This is one of my favorite places to go to in Miami! You should definitly stop by and if you do tell Danny I sent you! He might even give you a discount!"  ));
        placesList.add(new Places("KYU", "(786)577-0150", "251 NW 25th St, Miami, FL 33127", R.drawable.kyu_image  ));
        placesList.add(new Places("Bombay Darbar", "(305)444-7272", "2901 Florida Ave, Miami, FL 33133", R.drawable.dombay_darbar  ));
        placesList.add(new Places("Zuma Miami", "(305) 577-0277", "270 Biscayne Blvd Way, Miami, FL 33131", R.drawable.zuma_miami  ));
        placesList.add(new Places("Joe's Stone Crab Restaurant", "(305) 673-0365", "11 Washington Ave, Miami Beach, FL 33139", R.drawable.joes_crab ));
        placesList.add(new Places("Santorini by Georgios", "(305) 672-6624", "101 Ocean Dr, Miami Beach, FL 33139", R.drawable.santorini_georgios  ));
        placesList.add(new Places("CRUST", "(305) 371-7065", "668 NW 5th St, Miami, FL 33128", R.drawable.crust_image  ));
        placesList.add(new Places("KYU", "(786)577-0150", "251 NW 25th St, Miami, FL 33127", R.drawable.kyu_image  ));

        PlacesAdapter placesAdapter = new PlacesAdapter(getActivity(), placesList);
        listView.setAdapter(placesAdapter);

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
    return rootView;
    }
}