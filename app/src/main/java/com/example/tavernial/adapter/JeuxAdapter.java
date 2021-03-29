package com.example.tavernial.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tavernial.R;
import com.example.tavernial.page_jeux.page_jeux;
import com.example.tavernial.models.listJeux;
import com.example.tavernial.page_jeux.page_jeux2;

import java.util.List;

public class JeuxAdapter extends BaseAdapter {

    //attribut
    private Context context;
    private List<listJeux> listJeuxList;
    private LayoutInflater inflater;

    public JeuxAdapter(Context context, List<listJeux> listJeuxList){
        this.context = context;
        this.listJeuxList = listJeuxList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listJeuxList.size();
    }

    @Override
    public Object getItem(int position) {
        return listJeuxList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.jeux_horizontal, null);

        //get iformation sur le jeux
        listJeux currentjeux = (listJeux) getItem(i);
        String jeuxNom = currentjeux.getNom();
        String nomJeux = currentjeux.getNomJeux();

        //get image view
        ImageView nomJeuxView = view.findViewById(R.id.img);
        String resourceName = nomJeux;
        int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        nomJeuxView.setImageResource(resId);

        //get jeux nom view
        TextView jeuxNomView = view.findViewById(R.id.nom);
        jeuxNomView.setText(jeuxNom);

        view.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if (jeuxNom == "Descent"){
                    Intent otherActivity = new Intent(context.getApplicationContext(), page_jeux.class);
                    context.startActivity(otherActivity);
                }
                if (jeuxNom == "monopoly"){
                    Intent otherActivity = new Intent(context.getApplicationContext(), page_jeux2.class);
                    context.startActivity(otherActivity);
                }
            }
        });

        return view;
    }
}
