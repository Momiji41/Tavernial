package com.example.tavernial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class JeuxAdapter extends ArrayAdapter<Jeux> {

    private static final String TAG = "JeuxListAdapter";

    private Context mContext;
    private int mRessource;

    public JeuxAdapter (Context context, int ressource, ArrayList<Jeux> object)
    {
        super(context, ressource, object);
        mContext = context;
        mRessource = ressource;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        String name = getItem(position).getNom();
        String image =getItem(position).getImage();
       // String def = getItem(position).getDef();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mRessource, parent, false);

        TextView articleName = (TextView) convertView.findViewById(R.id.nom);
        ImageView articleImg = (ImageView) convertView.findViewById(R.id.img);
        //TextView articleDef = (TextView) convertView.findViewById(R.id.description);

        Context context = articleImg.getContext();
        articleImg.setImageResource(context.getResources().getIdentifier(image, "drawable", context.getPackageName()));


        articleName.setText(name);
       // articleDef.setText(def);




        return convertView;
    }

}
