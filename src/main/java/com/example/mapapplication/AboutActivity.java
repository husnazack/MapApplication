package com.example.mapapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Get the Instagram TextView
        TextView textViewInstagram = findViewById(R.id.textViewInstagram);
        // Set an onClickListener to open Instagram when clicked
        textViewInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.instagram.com";
                openURL(url);
            }
        });

        // Get the Twitter TextView
        TextView textViewTwitter = findViewById(R.id.textViewTwitter);
        // Set an onClickListener to open Twitter when clicked
        textViewTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://twitter.com";
                openURL(url);
            }
        });

        // Get the Facebook TextView
        TextView textViewFacebook = findViewById(R.id.textViewFacebook);
        // Set an onClickListener to open Facebook when clicked
        textViewFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com";
                openURL(url);
            }
        });

//        // Get the Website TextView
//        TextView textViewWebsite = findViewById(R.id.textViewWebsite);
//        // Set an onClickListener to open the Website when clicked
//        textViewWebsite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = "http://www.example.com";
//                openURL(url);
//            }
//        });
    }

    // Function to open the URL
    private void openURL(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    // Function to open Instagram
    public void openInstagram(View view) {
        String url = "https://www.instagram.com";
        openURL(url);
    }

    // Function to open Twitter
    public void openTwitter(View view) {
        String url = "https://twitter.com";
        openURL(url);
    }

    // Function to open Facebook
    public void openFacebook(View view) {
        String url = "https://www.facebook.com";
        openURL(url);
    }

    public void shareContent(View view) {
        // Create an Intent to share the content
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the content to share!");

        // Start the share activity
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }

    // Function to open a phone call
    public void openPhoneCall(View view) {
        String phoneNumber = "012-34567890";
        Uri uri = Uri.parse("tel:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    // Function to open the default email application
    public void openEmail(View view) {
        String emailAddress = "example@example.com";
        Uri uri = Uri.parse("mailto:" + emailAddress);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    // Function to open the website in the default web browser
    public void openWebsite(View view) {
        String websiteUrl = "http://www.hospitality.com";
        Uri uri = Uri.parse(websiteUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}