package com.example.tavernial.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.tavernial.BDD.Session;
import com.example.tavernial.R;
import com.example.tavernial.adapter.JeuxAdapter;
import com.example.tavernial.models.listJeux;

import java.util.ArrayList;
import java.util.List;

public class start extends Activity {

    //private ImageView jeux;
    //BaseHelper bdd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String id;
        setContentView(R.layout.start);
       // bdd = new BaseHelper(this);

       Session session = new Session(getApplication());
        id = session.getusename();

        List<listJeux> listJeuxList = new ArrayList<>();
        listJeuxList.add(new listJeux("Descent", "jeux1"));
        listJeuxList.add(new listJeux("monopoly", "jeux2"));
        listJeuxList.add(new listJeux("Cluedo", "jeux3"));

        //get list view
        ListView jeuxListView = findViewById(R.id.jeuxlistView);
        jeuxListView.setAdapter(new JeuxAdapter(this, listJeuxList));


        Button compte = findViewById(R.id.Votre_comtpe);

        compte.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (id.equals("")){
                    Intent connexion = new Intent(start.this, MainActivity.class);
                    startActivity(connexion);
                }
                else {
                    Intent account = new Intent(start.this, Compte.class);
                    startActivity(account);
                }

            }
        });






        /**compte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), Compte.class);
                startActivity(otherActivity);
                finish();
            }
        });**/








    }
}