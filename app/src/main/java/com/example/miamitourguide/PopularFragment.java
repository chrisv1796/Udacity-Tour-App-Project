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

public class PopularFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public PopularFragment() {
        // Required empty public constructor
    }

    /**
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PopularFragment.
     */
    public static PopularFragment newInstance(String param1, String param2) {
        PopularFragment fragment = new PopularFragment();
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

        placesList.add(new Places(getString(R.string.elleven_miami), getString(R.string.elleven_miami_phone), getString(R.string.elleven_miami_address), R.drawable.eleven_miami, getString(R.string.elleven_miami_summary)));
        placesList.add(new Places(getString(R.string.club_space), getString(R.string.club_space_phone), getString(R.string.club_space_address), R.drawable.club_space  ));
        placesList.add(new Places(getString(R.string.blackbird), getString(R.string.blackbird_phone), getString(R.string.blackbird_address), R.drawable.blackbird  ));
        placesList.add(new Places(getString(R.string.el_patio), getString(R.string.el_patio_phone), getString(R.string.el_patio_address), R.drawable.el_patio  ));
        placesList.add(new Places(getString(R.string.ball_chain), getString(R.string.ball_chain_phone), getString(R.string.ball_chain_address), R.drawable.ball_chain ));
        placesList.add(new Places(getString(R.string.shots), getString(R.string.shots_phone), getString(R.string.shots_address), R.drawable.shots_miami  ));
        placesList.add(new Places(getString(R.string.redbar), getString(R.string.redbar_phone), getString(R.string.redbar_address), R.drawable.redbar_brickell  ));

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