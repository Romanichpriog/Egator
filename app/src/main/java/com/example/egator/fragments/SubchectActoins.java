package com.example.egator.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.egator.R;

public class SubchectActoins extends Fragment implements View.OnClickListener {

    private NavController navController;
    private Button russianLenguageTeoria;
    private Button russianLenguageVariant;









    public SubchectActoins() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_subchect_actoins, container, false);
        russianLenguageTeoria = v.findViewById(R.id.btn_russian_lenguage_teoria);
        russianLenguageVariant = v.findViewById(R.id.btn_russian_lenguage_variant);
        navController= Navigation.findNavController(container);



        return v;
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        russianLenguageVariant.setOnClickListener(this);
        russianLenguageTeoria.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_russian_lenguage_teoria:
                navController.navigate(R.id.action_subchectActoins_to_exerciseList);
                break;
            case R.id.btn_russian_lenguage_variant:
                navController.navigate(R.id.action_subchectActoins_to_practica);
                break;
        }
    }
}







