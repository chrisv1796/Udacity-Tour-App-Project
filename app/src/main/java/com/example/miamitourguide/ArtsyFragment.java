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

public class ArtsyFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ArtsyFragment() {
    }

    /**
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArtsyFragment.
     */
    public static ArtsyFragment newInstance(String param1, String param2) {
        ArtsyFragment fragment = new ArtsyFragment();
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

        placesList.add(new Places(getString(R.string.rubell_museum), getString(R.string.rubell_museum_phone), getString(R.string.rubell_museum_address), R.drawable.vizcaya_garden, getString(R.string.rubell_museum_summary)));
        placesList.add(new Places(getString(R.string.art_tech), getString(R.string.art_tech_phone), getString(R.string.art_tech_address), R.drawable.art_tech_house));
        placesList.add(new Places(getString(R.string.avant), getString(R.string.avant_phone), getString(R.string.avant_address), R.drawable.yeelen_gallery));
        placesList.add(new Places(getString(R.string.vizcaya), getString(R.string.vizcaya_phone), getString(R.string.vizcaya_address), R.drawable.vizcaya_garden));
        placesList.add(new Places(getString(R.string.zoo_miami), getString(R.string.zoo_miami_phone), getString(R.string.zoo_miami_address), R.drawable.vizcaya_garden));

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