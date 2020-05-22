package com.example.egator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import android.os.Bundle;

import com.example.egator.fragments.SubchectActoins;


public class MainActivity extends AppCompatActivity implements SubchectActoins.OnFragmentInteractionListener {
    private NavController navController;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.fragment);
    }


    @Override
    public void onFragmentInteraction(int buttonId) {
        switch (buttonId){
            case R.id.btn_russian_lenguage_teoria:
                navController.navigate(R.id.action_subchectActoins_to_exerciseList);
                break;
            case R.id.btn_russian_lenguage_spravochny_material:
                navController.navigate(R.id.action_subchectActoins_to_spravochniy);
                break;
            case R.id.btn_russian_lenguage_variant:
                navController.navigate(R.id.action_subchectActoins_to_wholeVariant);
                break;
        }
    }
}
