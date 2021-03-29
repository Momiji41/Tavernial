package com.example.tavernial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ajoutjeu extends Activity {

    private TextView back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_jeux);

        this.back = findViewById(R.id.accueil);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), start.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}
