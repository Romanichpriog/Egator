package com.example.egator.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.egator.R;
import com.example.egator.adapters.ExerciseListAdapter;


public class ExerciseList extends Fragment {
    private RecyclerView exerciseList;
    private ExerciseListAdapter exerciseListAdapter;


    public ExerciseList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_exercise_list, container, false);
        NavController navController = Navigation.findNavController(container);
        exerciseList=view.findViewById(R.id.rv_exercise_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        exerciseList.setLayoutManager(linearLayoutManager);
        exerciseList.setHasFixedSize(true);
        exerciseListAdapter = new ExerciseListAdapter(26,navController);
        exerciseList.setAdapter(exerciseListAdapter);

        return view;
    }

}
