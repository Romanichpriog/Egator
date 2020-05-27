package com.example.egator.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.egator.R;
import com.example.egator.adapters.ZadanieListAdapter;
import com.example.egator.view.Otvet;

import java.util.ArrayList;
import java.util.List;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;


public class Practica extends Fragment {
    private RecyclerView zadaniaList;
    private NavController navController;
    private ZadanieListAdapter adapter;
    private ArrayList<Otvet> otvetList;




    public Practica() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        otvetList=getArguments().getParcelableArrayList("masivzadani");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_practica, container, false);
        zadaniaList= view.findViewById(R.id.rv_zadania_list);
        navController=Navigation.findNavController(container);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        zadaniaList.setLayoutManager(linearLayoutManager);
        zadaniaList.setHasFixedSize(true);
        adapter = new ZadanieListAdapter(navController,otvetList.size(),otvetList);
        zadaniaList.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
