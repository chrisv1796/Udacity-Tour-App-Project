package com.example.miamitourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PlacesAdapter extends ArrayAdapter<Places> {

    private Context mContext;
    private List<Places> placesList = new ArrayList<>();

    public PlacesAdapter(@NonNull Context context, ArrayList<Places> list) {
        super(context, 0, list);
        mContext = context;
        placesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);

        Places currentPlace = placesList.get(position);
        ImageView placeImageView = listItem.findViewById(R.id.place_image);
        placeImageView.setImageResource(currentPlace.getImgResourceId());

        TextView placeName = listItem.findViewById(R.id.name_text_view);
        placeName.setText(currentPlace.getName());
        TextView placeAddress = listItem.findViewById(R.id.address_text_view);
        placeAddress.setText(currentPlace.getAddress());
        TextView placePhoneNumber = listItem.findViewById(R.id.phone_text_view);
        placePhoneNumber.setText(currentPlace.getPhone());
        return listItem;
    }
}
