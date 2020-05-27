package com.example.egator.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.egator.R;


public class text_dlia_zadania extends Fragment {
    private String text_pomoshnik;
    private TextView pokaz;


    public text_dlia_zadania() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text_pomoshnik = getArguments().getString("text");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_text_dlia_zadania, container, false);
        pokaz= view.findViewById(R.id.tv_textdlia_zadania);
        pokaz.setText(text_pomoshnik);
        return view;
    }

}
