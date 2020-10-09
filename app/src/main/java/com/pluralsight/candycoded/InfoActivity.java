package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***
    public void createMapIntent(View view){
        final String address = "618 E South St Orlando, FL 32801";
        Uri uri = Uri.parse("geo:0,0?q=" + address);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }else{
            Toast.makeText(this, getString(R.string.google_maps_not_available), Toast.LENGTH_SHORT).show();
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
    public void createPhoneIntent(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);

        final String phoneNumber = "0123456789";
        Uri uri = Uri.parse("tel:" + phoneNumber);

        intent.setData(uri);

        startActivity(intent);
    }
}
