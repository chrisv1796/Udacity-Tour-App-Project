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

        placesList.add(new Places(getString(R.string.capital_grille), getString(R.string.capital_grille_phone), getString(R.string.capital_grille_address), R.drawable.crust_image, getString(R.string.capital_grille_summary)));
        placesList.add(new Places(getString(R.string.bombay_darbar), getString(R.string.bombay_darbar_phone), getString(R.string.bombay_darbar_address), R.drawable.tea_poets));
        placesList.add(new Places(getString(R.string.santorini), getString(R.string.santorini_phone), getString(R.string.santorini_address), R.drawable.crust_image));
        placesList.add(new Places(getString(R.string.crust), getString(R.string.crust_phone), getString(R.string.crust_address), R.drawable.crust_image));
        placesList.add(new Places(getString(R.string.joes_crab), getString(R.string.crust_phone), getString(R.string.crust_address), R.drawable.crust_image));

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