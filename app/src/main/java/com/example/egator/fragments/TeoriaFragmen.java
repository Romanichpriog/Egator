package com.example.egator.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.egator.R;




public class TeoriaFragmen extends Fragment {
    private String nomZadania;
    private TextView exerciseDiscription;
    private TextView whhatToKnow;
    private TextView linkToSpravochny;


    public TeoriaFragmen() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nomZadania = getArguments().getString("nomer");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_teoria, container, false);
        exerciseDiscription=v.findViewById(R.id.tv_what_to_do);
        whhatToKnow=v.findViewById(R.id.tv_tems_in_exercise);
        linkToSpravochny=v.findViewById(R.id.tv_link_to_teoria);
        exerciseDiscription.setText(getString(getResources().getIdentifier("hto_delat_"+nomZadania,"string","com.example.egator")));
        whhatToKnow.setText(getString(getResources().getIdentifier("hto_znat_"+nomZadania,"string","com.example.egator")));




        return v;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView link_to_materil =view.findViewById(R.id.tv_link_to_teoria);
        String dynamicUrl = getString(getResources().getIdentifier("hte_posmotret_"+nomZadania,"string","com.example.egator"));
        String linkedText = String.format(
                "<a href=\"%s\" text-decoration=\"none\">Подробна справочная информация</a> ", dynamicUrl);
        link_to_materil.setText(Html.fromHtml(linkedText));
        link_to_materil.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
