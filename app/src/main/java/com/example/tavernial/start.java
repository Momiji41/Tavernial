package com.example.tavernial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class start extends Activity {

    //private ImageView jeux;
    BaseHelper bdd;
    ListView listPerso;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String id;
        setContentView(R.layout.start);
        bdd = new BaseHelper(this);


        Session session = new Session(getApplication());
        id = session.getusename();



        Button compte = findViewById(R.id.Votre_comtpe);

        /**compte.setOnClickListener(new View.OnClickListener() {
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
        });**/
        compte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), Compte.class);
                startActivity(otherActivity);
                finish();
            }
        });

        ArrayList<Jeux> listeJeux = new ArrayList<Jeux>(){};
        final ListView listPerso = findViewById(R.id.listView);


       /** bdd.jeux_insertData("Descent", "jeux trop bien", 50, "descend","https://www.amazon.fr/Asmodee-FFDES01-Descent-Version-Anglaise/dp/1616611898/ref=sr_1_1?__mk_fr_FR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=descent&qid=1616174589&sr=8-1");

        JeuxAdapter adapter = new JeuxAdapter(this, R.layout.jeux_horizontal, listeJeux);
        listPerso.setAdapter(adapter);

        listeJeux = bdd.jeux_show();**/


        /** this.jeux = findViewById(R.id.jeux);

         jeux.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Intent otherActivity = new Intent(getApplicationContext(), page_jeux.class);
        startActivity(otherActivity);
        finish();
        }
        });**/
    }
}