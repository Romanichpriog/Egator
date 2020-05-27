package com.example.egator.fragments;


import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavType;
import androidx.navigation.Navigation;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.egator.R;
import com.example.egator.view.Otvet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.example.egator.utils.NetvorkUtils.genetayedURL;
import static com.example.egator.utils.NetvorkUtils.getResponseFromURL;


public class TeoriaFragmen extends Fragment {
    private ProgressBar indikator;
    private String nomZadania;
    private TextView exerciseDiscription;
    private TextView whhatToKnow;
    private TextView linkToSpravochny;
    private Button perehodic;
    private NavController navController;

    class EgatorQuaryClass extends AsyncTask<URL, Void,String> {

        @Override
        protected void onPreExecute(){
            indikator.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            String response = null;
            try {
                response = getResponseFromURL(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;

        }

        @Override
        protected void onPostExecute(String response){
            indikator.setVisibility(View.INVISIBLE);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Log.i("response",response);
            if (response!=null && response!="") {

                List<String> objects= new ArrayList<>();
                response = response.substring(1,response.length()-1);
                for (String reval : response.split(Pattern.quote("}"))){
                    objects.add(reval.substring(1,reval.length())+"}");
                }
                String firs ="{"+objects.get(0);
                objects.remove(0);
                objects.add(0,firs);
                String last =objects.get(objects.size()-1);
                last=last.substring(0,last.length()-1)+"}";
                objects.remove(objects.size()-1);
                objects.add(last);


                ArrayList<Otvet> getNomer = new ArrayList<>();
                for(int i =0;i<objects.size();i++){
                    getNomer.add(gson.fromJson(objects.get(i),Otvet.class));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("masivzadani",getNomer);
                navController.navigate(R.id.action_teoriaFragmen_to_practica,bundle);






            }else{

            }
        }
    }


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
        indikator=v.findViewById(R.id.pb_load_indicator);
        whhatToKnow=v.findViewById(R.id.tv_tems_in_exercise);
        linkToSpravochny=v.findViewById(R.id.tv_link_to_teoria);
        perehodic=v.findViewById(R.id.btn_go_to_zadania);
        navController = Navigation.findNavController(container);
        exerciseDiscription.setText(getString(getResources().getIdentifier("hto_delat_"+nomZadania,"string","com.example.egator")));
        whhatToKnow.setText(getString(getResources().getIdentifier("hto_znat_"+nomZadania,"string","com.example.egator")));
        perehodic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL generatedURL= genetayedURL("4");
                new EgatorQuaryClass().execute(generatedURL);




            }
        });




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
