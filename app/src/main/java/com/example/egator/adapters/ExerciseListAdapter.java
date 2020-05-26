package com.example.egator.adapters;



import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.egator.R;



public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ExerciseButtonViewHolder>{


    private NavController navController;
    private int numberItems;


    public ExerciseListAdapter(int numberItems, NavController navController) {
        this.numberItems = numberItems;
        this.navController=navController;
    }



    @NonNull
    @Override
    public ExerciseButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem= R.layout.exrcise_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);



        View view = inflater.inflate(layoutIdForListItem,parent,false);
        ExerciseButtonViewHolder viewHolder = new ExerciseButtonViewHolder(view,navController);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseButtonViewHolder holder, int position) {
        holder.bind(position);
    }



    @Override
    public int getItemCount() {
        return numberItems;
    }

    class ExerciseButtonViewHolder extends RecyclerView.ViewHolder{
        final NavController navController;
        Button exerciseButton;




        public ExerciseButtonViewHolder(@NonNull View itemView, final NavController navController) {
            super(itemView);
            this.navController=navController;


            exerciseButton=itemView.findViewById(R.id.btn_exersice_list);
            exerciseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    String adapterPosition = String.valueOf(getAdapterPosition()+1);
                    bundle.putString("nomer",adapterPosition);
                    navController.navigate(R.id.action_exerciseList_to_teoriaFragmen,bundle);
                }
            });
        }


        public void bind (int listIndex){
            Context context = itemView.getContext();
            String nomer = context.getString(R.string.nomer_zadania);
            exerciseButton.setText(nomer+String.valueOf(listIndex+1));
        }
    }
}
