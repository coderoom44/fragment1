package com.example.fragment1.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.fragment1.R;
import com.example.fragment1.fragments.DataFragment;
import com.example.fragment1.fragments.DetailsFragment;

public class MainActivity extends FragmentActivity
        implements DataFragment.DataListener

{
    private boolean isMultipanel;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setMultipanel(); //configuera main activity para alojar el fragment

    }

    private void setMultipanel()
    {
        isMultipanel =
                getSupportFragmentManager().findFragmentById(R.id.detailsFragment)!=null;
    }

    @Override
    public void SendData(String text)
    {
        if(isMultipanel)
        {
            DetailsFragment detailsFragment =
                    (DetailsFragment)getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(text);
        }
        else
        {
            Intent intent =  new Intent(this, DetailsActivity.class);
            intent.putExtra("text",text);
            startActivity(intent);
        }

    }
}