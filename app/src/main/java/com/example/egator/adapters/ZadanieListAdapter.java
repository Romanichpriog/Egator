package com.example.egator.adapters;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.NavType;
import androidx.recyclerview.widget.RecyclerView;

import com.example.egator.R;
import com.example.egator.view.Otvet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        int layoutIdForListItem= R.layout.exrcise_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);



        View view = inflater.inflate(layoutIdForListItem,parent,false);
        ZadanieViewHolder viewHolder = new ZadanieViewHolder(view,navController,otvetList,feedBack);



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

        private String[] feedback;
        private NavController navController;
        private ArrayList<Otvet> otvetList;

        public String[] getFeedback() {
            return feedback;
        }

        public ZadanieViewHolder(@NonNull View itemView, NavController navController, ArrayList<Otvet> otvetList, String[] feedback) {
            super(itemView);
            this.navController = navController;
            this.otvetList = otvetList;
            this.feedback=feedback;
        }

        TextView zadanie;
        TextView uslovie;
        EditText vvod;
        Button toText;
        Button save;



        public ZadanieViewHolder(@NonNull View itemView) {
            super(itemView);

            save=itemView.findViewById(R.id.btn_save);
            zadanie = itemView.findViewById(R.id.tv_text_zadania);
            uslovie = itemView.findViewById(R.id.tv_uslovie);
            vvod = itemView.findViewById(R.id.et_otvet_polzovatelia);
            toText = itemView.findViewById(R.id.btn_pereiti_v_text);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    feedback[getAdapterPosition()]=vvod.getText().toString();

                }
            });
            toText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    String textDliaPeredachi=otvetList.get(getAdapterPosition()).getText();
                    bundle.putString("text",textDliaPeredachi);
                    navController.navigate(R.id.action_practica_to_text_dlia_zadania,bundle);
                }
            });
        }
        public void bind(int position){
            //if (feedback[position]!=null){
                //vvod.setText(feedBack[position]);
            //}
            zadanie.setText(otvetList.get(position).getTextzadania());
            if (otvetList.get(position).getUslovie()!= "null"){
                uslovie.setText(otvetList.get(position).getUslovie());
            }else {
                uslovie.setText("");
            }
            if (position<3 | position>20){
                toText.setVisibility(View.VISIBLE);
                toText.setClickable(true);
                toText.setText("Text");
            }else {
                toText.setVisibility(View.INVISIBLE);
                toText.setClickable(false);
                toText.setText("");
            }


        }
    }
}
