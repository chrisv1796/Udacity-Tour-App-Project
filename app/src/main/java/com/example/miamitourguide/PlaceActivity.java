package com.example.miamitourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        int imageReourceID = getIntent().getIntExtra("IMAGE_ID", 0);
        String placeName = getIntent().getStringExtra("PLACE_NAME");
        String placePhone = getIntent().getStringExtra("PLACE_PHONE");
        String placeAddress = getIntent().getStringExtra("PLACE_ADDRESS");
        String placeSummary = getIntent().getStringExtra("PLACE_SUMMARY");

        ImageView placeImage = findViewById(R.id.place_activity_image_view);
        TextView placeNameTextView = findViewById(R.id.place_activity_text_view);
        TextView placePhoneTextView = findViewById(R.id.place_activity_phone);
        TextView placeAddressTextView = findViewById(R.id.place_activity_address);
        TextView placeSummaryTextView = findViewById(R.id.place_summary_text_view);

        placeImage.setImageResource(imageReourceID);
        placePhoneTextView.setText(placePhone);
        placeAddressTextView.setText(placeAddress);
        placeNameTextView.setText(placeName);
        placeSummaryTextView.setText(placeSummary);

    }
}