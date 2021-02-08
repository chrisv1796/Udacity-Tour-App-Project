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

        placesList.add(new Places(getString(R.string.dr_smood), getString(R.string.dr_smood_phone), getString(R.string.dr_smood_address), R.drawable.tea_poets, getString(R.string.dr_smood_summary)));
        placesList.add(new Places(getString(R.string.vice_city_bean), getString(R.string.vice_city_bean_phone), getString(R.string.vice_city_bean_address), R.drawable.tea_poets));
        placesList.add(new Places(getString(R.string.suite_habana), getString(R.string.suite_habana_phone), getString(R.string.suite_habana_address), R.drawable.suite_habana));
        placesList.add(new Places(getString(R.string.tea_room), getString(R.string.tea_room_phone), getString(R.string.tea_room_address), R.drawable.tea_poets));
        placesList.add(new Places(getString(R.string.tea_poets), getString(R.string.tea_poets_phone), getString(R.string.tea_poets_address), R.drawable.tea_poets));

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