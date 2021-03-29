package com.example.tavernial.page_jeux;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tavernial.R;
import com.example.tavernial.menu.start;

public class page_jeux2 extends Activity {

    private TextView back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_jeux2);

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