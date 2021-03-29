package com.example.tavernial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView inscription;
    EditText ndc, mdp;
    BaseHelper bdd;
    Button connexion;

    protected void onCreate(Bundle savedInstanceState) {
        Session session = new Session(getApplication());
        session.setusename("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bdd = new BaseHelper(this);
        ndc = (EditText) findViewById(R.id.Nom_de_compte);
        mdp = (EditText) findViewById(R.id.m_d_p);
        connexion = findViewById(R.id.valider);

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // faire lecture bdd et verifier si bon id et bon mdp


                boolean connect = false;
                if (ndc.length()==0)
                {
                    ndc.setError("Saisissez un username");
                }
                if (mdp.length()==0)
                {
                    mdp.setError("Saisissez votre mot de passe");
                }
                // verif des infos avec la bdd
                if(bdd.connexion(ndc.getText().toString(), mdp.getText().toString()))
                {

                    Session session = new Session(getApplication());
                    String a = ndc.getText().toString();
                    String b = mdp.getText().toString();
                    String id = bdd.utilisateurID_show(a, b);
                    //Log.d("myTag", "id");
                    //Log.d("ADebugTag", "Value: " + id);
                    session.setusename(id);



                    Intent accueil = new Intent(MainActivity.this, start.class);
                    startActivity(accueil);
                }
            }
                                            }
        );

        this.inscription = findViewById(R.id.inscription);

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), login.class);
                startActivity(otherActivity);
                finish();
            }
        });

        /**Button connexion = findViewById(R.id.valider);

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent connec = new Intent(getApplicationContext(), start.class);
                startActivity(connec);
                finish();
            }
        });**/
    }
}