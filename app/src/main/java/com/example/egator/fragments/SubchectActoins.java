package com.example.egator.fragments;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.egator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubchectActoins extends Fragment {
    private OnFragmentInteractionListener mListener;

    private Button russianLenguageTeoria;
    private Button russianLenguageSpravochnyMaterial;
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
        russianLenguageSpravochnyMaterial = v.findViewById(R.id.btn_russian_lenguage_spravochny_material);
        russianLenguageVariant = v.findViewById(R.id.btn_russian_lenguage_variant);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate();
            }
        };


        return v;
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);



    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
    public void navigate
}
