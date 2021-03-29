package com.example.tavernial.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tavernial.R;
import com.example.tavernial.menu.start;

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
