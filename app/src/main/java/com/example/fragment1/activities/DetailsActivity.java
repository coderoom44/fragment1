package com.example.fragment1.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fragment1.R;
import com.example.fragment1.fragments.DetailsFragment;

public class DetailsActivity extends AppCompatActivity
{
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);

        if(getIntent().getExtras()!=null)
        {
            text = getIntent().getStringExtra("text");
        }

        DetailsFragment detailsFragment =
                (DetailsFragment)getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(text);

    }
}