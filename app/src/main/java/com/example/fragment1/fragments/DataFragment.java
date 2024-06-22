package com.example.fragment1.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragment1.R;


public class DataFragment extends Fragment {

    //variables
    private EditText textData;
    private Button btnEnviar;

    private DataListener callback;

    public DataFragment() {



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        textData = view.findViewById(R.id.editTextData);//valor del input
        btnEnviar = view.findViewById(R.id.botonEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                String textoEnviar = textData.getText().toString();
                callback.SendData(textoEnviar);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            callback = (DataListener) context;
        } catch (Exception e) {
            throw new ClassCastException();
        }
    }

    public interface DataListener
    {    //clase interna

        void SendData(String text);
    }
}