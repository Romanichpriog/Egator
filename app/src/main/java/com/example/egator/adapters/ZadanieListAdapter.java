package com.example.egator.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.egator.R;
import com.example.egator.view.Otvet;

import java.util.ArrayList;

public class ZadanieListAdapter extends RecyclerView.Adapter<ZadanieListAdapter.ZadanieViewHolder>{
    private NavController navController;
    private int numberItems;
    private ArrayList<Otvet> otvetList;
    private String[] feedBack = new String[numberItems];

    public ZadanieListAdapter(NavController navController, int numberItems, ArrayList<Otvet> otvetList) {
        this.navController = navController;
        this.numberItems = numberItems;
        this.otvetList = otvetList;
    }

    @NonNull
    @Override
    public ZadanieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem= R.layout.zadanie_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);



        View view = inflater.inflate(layoutIdForListItem,parent,false);
        ZadanieViewHolder viewHolder = new ZadanieViewHolder(view,navController,otvetList);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ZadanieViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class ZadanieViewHolder extends RecyclerView.ViewHolder{


        private NavController navController;
        private ArrayList<Otvet> otvetList;
        TextView zadanie;
        TextView uslovie;
        EditText vvod;
        Button toText;
        Button save;



        public ZadanieViewHolder(@NonNull View itemView, final NavController navController, final ArrayList<Otvet> otvetList) {
            super(itemView);
            this.navController = navController;
            this.otvetList = otvetList;





            zadanie=itemView.findViewById(R.id.tv_textdlia_zadania);
            uslovie=itemView.findViewById(R.id.tv_uslovie);
            save=itemView.findViewById(R.id.btn_save);
            vvod=itemView.findViewById(R.id.et_otvet_polzovatelia);
            toText=itemView.findViewById(R.id.btn_go_to_zadania);




        }
        public void bind(int listIndex){

            if(otvetList.get(listIndex).getUslovie()!="null"){
                uslovie.setText(otvetList.get(listIndex).getUslovie());
            }
            zadanie.setText(otvetList.get(listIndex).getTextzadania());
            if(listIndex<3 | listIndex>20){
                toText.setVisibility(View.VISIBLE);
            }else {
                toText.setVisibility(View.INVISIBLE);
            }
        }







    }
}
