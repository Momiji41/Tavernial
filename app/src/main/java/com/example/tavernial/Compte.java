package com.example.tavernial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Compte extends Activity {

    private TextView back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moncompte);
















        this.back = findViewById(R.id.accueil);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), start.class);
                startActivity(otherActivity);
                finish();
            }
        });

        Button compte = findViewById(R.id.ajout);

        compte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), ajoutjeu.class);
                startActivity(otherActivity);
                finish();
            }
        });







        Button deconnect = findViewById(R.id.deco);

        deconnect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Session session = new Session(getApplication());
                session.setusename("");
                Intent connexion = new Intent(Compte.this, MainActivity.class);
                startActivity(connexion);
                finish();
            }
        });
    }
}
