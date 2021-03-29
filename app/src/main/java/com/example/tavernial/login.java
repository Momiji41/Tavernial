package com.example.tavernial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends Activity {

    TextView back;
    TextView back2;
    EditText nom, prenom, email, password, confirmPassword;
    Button inscription;
    BaseHelper bdd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        bdd = new BaseHelper(this);

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);
        inscription = (Button) findViewById(R.id.inscription);

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Ecriture dans la bdd si mdp pareil que confirmation
                System.out.println("Demande d'inscription");

                //on regarde si tous les champs sont remplis
                if (nom.length()==0)
                {
                    nom.setError("Saisissez votre nom");
                }
                if (prenom.length()==0)
                {
                    prenom.setError("Saisissez un username");
                }
                if (email.length()==0)
                {
                    email.setError("Saisissez votre email");
                }
                if (password.length()==0)
                {
                    password.setError("Saisissez un mot de passe");
                }
                if (confirmPassword.length()==0)
                {
                    confirmPassword.setError("Saisissez une nouvelle fois votre mot de passe");
                }

                //erreur si le mot de passe n'est pas répété deux fois a l'identique
                if(confirmPassword.getText().toString().equals(password.getText().toString()))
                {
                    bdd.utilisateur_insertData(nom.getText().toString(), prenom.getText().toString(), email.getText().toString(), password.getText().toString());

                    Intent accueil = new Intent(login.this, start.class);
                    startActivity(accueil);
                }

                else
                {
                    confirmPassword.setError("Saisissez deux fois le même mot de passe");
                }

            }
        });

        this.back = findViewById(R.id.accueil);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.back2 = findViewById(R.id.retour);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });




       // this.inscription = findViewById(R.id.inscription);

       // inscription.setOnClickListener(new View.OnClickListener() {
        //    @Override
          //  public void onClick(View view) {
           //     Intent otherActivity = new Intent(getApplicationContext(), start.class);
           //     startActivity(otherActivity);
          //      finish();
       //     }
      //  });
    }
}
