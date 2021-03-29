package com.example.tavernial.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.tavernial.models.Jeux;

import java.util.ArrayList;

public class BaseHelper extends SQLiteOpenHelper {

    private static final String nomBdd = "newbdd";
    private String requete;
    private static final int base_version  = 1;
    private SQLiteDatabase db;


    // table utilisateur
    private static final String table_utilisateur  = "user";
    private static final String utilisateur_id = "id";
    private static final String utilisateur_nom = "nom";
    private static final String utilisateur_prenom = "prenom";
    private static final String utilisateur_email = "email";
    private static final String utilisateur_mdp = "mdp";

    private static final String creation_utilisateur = "CREATE TABLE " + table_utilisateur +
            " ( " + utilisateur_id + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            utilisateur_nom + " VARCHAR(32) NOT NULL , " +
            utilisateur_prenom + " VARCHAR(32) NOT NULL , " +
            utilisateur_email + " VARCHAR(32) NOT NULL , " +
            utilisateur_mdp + " VARCHAR(64) NOT NULL ) ";

    // table jeux
    private static final String table_jeux = "jeux";
    private static final String jeux_id = "id";
    private static final String jeux_nom = "nom";
    private static final String jeux_description = "jeux_description";
    private static final String jeux_prix = "prix";
    private static final String jeux_image = "image";
    private static final String jeux_lien = "lien";


    private static final String creation_jeux = "CREATE TABLE " + table_jeux +
            " ( " + jeux_id + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            jeux_nom + " VARCHAR(32) NOT NULL , " +
            jeux_description + " TEXT NOT NULL , " +
            jeux_prix + " INT NOT NULL , " +
            jeux_image + " TEXT NOT NULL , " +
            jeux_lien + " TEXT NOT NULL )" ;





    public BaseHelper(@Nullable Context context) {

        super(context, nomBdd, null, base_version);

    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(creation_jeux);
        db.execSQL(creation_utilisateur);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + nomBdd +";");
        onCreate(db);
    }

    public boolean utilisateur_insertData(String nom, String prenom, String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(utilisateur_nom, nom);
        contentvalues.put(utilisateur_prenom, prenom);
        contentvalues.put(utilisateur_email, email);
        contentvalues.put(utilisateur_mdp, password);
        long res = db.insert(table_utilisateur, null,contentvalues);

        if (res!=-1)
        {
            return true;
        }
        return false;
    }



    public boolean jeux_insertData(String nom, String desc, int prix, String image, String lien)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(jeux_nom, nom);
        contentvalues.put(jeux_description, desc);
        contentvalues.put(jeux_prix, prix);
        contentvalues.put(jeux_image, image);
        contentvalues.put(jeux_lien, lien);
        long res = db.insert(table_jeux, null,contentvalues);

        if (res!=-1)
        {
            return true;
        }
        return false;
    }



    public String utilisateur_show()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM " + table_utilisateur + " WHERE id > ?", new String[]{"0"});

        String res = null;

        while(c.moveToNext())
        {
            int id = c.getInt(0);
            String nom = c.getString(1);
            String prenom = c.getString(2);
            String email = c.getString(3);
            String password = c.getString(4);
            int pointFid = c.getInt(5);

            res+= Integer.toString(id) +" "+
                    nom +" "+
                    email  +" " +
                    password + " " +
                    Integer.toString(pointFid) + "\n";
        }

        System.out.println(res);
        return res;

    }

    public ArrayList<Jeux> jeux_show()
    {
        System.out.println("je commence a recuperer les jeux");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM " + table_jeux, null);
        System.out.println(c.getColumnCount());
        ArrayList<Jeux> res = new ArrayList<Jeux>();
        int i=0;

        if (c.moveToFirst()) {

            int IndexInt = c.getColumnIndex(jeux_id);
            int Indexname = c.getColumnIndex(jeux_nom);
            int Indexdesc = c.getColumnIndex(jeux_description);
            int Indexprix = c.getColumnIndex(jeux_prix);
            int Indeximage = c.getColumnIndex(jeux_image);
            int Indexlien = c.getColumnIndex(jeux_lien);

            do {
                int id = c.getInt(IndexInt);
                String name = c.getString(Indexname);
                String def = c.getString(Indexdesc);
                int prix = c.getInt(Indexprix);
                String image = c.getString(Indeximage);
                String lien = c.getString(Indexlien);

                res.add(new Jeux(name, def, prix, image, lien));
                res.get(i).setId(id);
                i += 1;

            } while (c.moveToNext());
        } else
        {
            System.out.println("aucun élément trouvé");
        }
        return res;

    }

    public ArrayList<Jeux> jeux_prix_show ()
    {
        System.out.println("je commence a recuperer les jeux");
        SQLiteDatabase db = this.getReadableDatabase();
        String requete = "SELECT prix " +
                "FROM `jeux`" ;
        System.out.println(requete);
        Cursor c = db.rawQuery(requete, null);
        System.out.println(c.getColumnCount());
        ArrayList<Jeux> res = new ArrayList<Jeux>();
        int i=0;

        if (c.moveToFirst()) {

            int IndexInt = c.getColumnIndex(jeux_id);
            int Indexname = c.getColumnIndex(jeux_nom);
            int Indexdef = c.getColumnIndex(jeux_description);
            int Indexprix = c.getColumnIndex(jeux_prix);
            int Indeximage = c.getColumnIndex(jeux_image);

            do {
                int id = c.getInt(IndexInt);
                String name = c.getString(Indexname);
                String def = c.getString(Indexdef);
                int prix = c.getInt(Indexprix);
                String image = c.getString(Indeximage);
                String lien = c.getString(5);

                res.add(new Jeux(name, def, prix, image, lien));
                res.get(i).setId(id);
                i += 1;

            } while (c.moveToNext());
        } else
        {
            System.out.println("aucun élément trouvé");
        }

        return res;
    }

    public ArrayList<Jeux> Jeux_lien_show ()
    {
        System.out.println("je commence a recuperer les jeux");
        SQLiteDatabase db = this.getReadableDatabase();
        String requete = "SELECT lien " +
                "FROM `jeux` ";
        System.out.println(requete);
        Cursor c = db.rawQuery(requete, null);
        System.out.println(c.getColumnCount());
        ArrayList<Jeux> res = new ArrayList<Jeux>();
        int i=0;

        if (c.moveToFirst()) {

            int IndexInt = c.getColumnIndex(jeux_id);
            int Indexname = c.getColumnIndex(jeux_nom);
            int Indexdesc = c.getColumnIndex(jeux_description);
            int Indexprix = c.getColumnIndex(jeux_prix);
            int Indeximage = c.getColumnIndex(jeux_image);

            do {
                int id = c.getInt(IndexInt);
                String name = c.getString(Indexname);
                String desc = c.getString(Indexdesc);
                int prix = c.getInt(Indexprix);
                String image = c.getString(Indeximage);
                String lien = c.getString(5);

                res.add(new Jeux(name, desc, prix, image, lien));
                res.get(i).setId(id);
                i += 1;

            } while (c.moveToNext());
        } else
        {
            System.out.println("aucun élément trouvé");
        }

        return res;
    }




        public boolean connexion(String utilisateur_nom, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT "+ utilisateur_nom+" , "+ utilisateur_mdp +" FROM " + table_utilisateur + " WHERE id > ?", new String[]{"0"});


        while(c.moveToNext())
        {
            String nom = c.getString(0);
            String mdp2 = c.getString(1);

            if (utilisateur_nom.equals(nom))
            {
                return true;
            }

        }

        return false;

    }



    // Pour récuperer un id avec mail et mdp
    public String utilisateurID_show(String utilisateur_nom, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT " + utilisateur_id + " FROM " + table_utilisateur + " WHERE nom = '" + utilisateur_nom + "' and Mdp = '" + password + "'", null); //je comprtend pas pourquoi ca affiche null

        String res = "";
        c.moveToFirst();
        String id = c.getString(0);
        res+= id;

        Log.d("ADebugTag", "Value du resultat de la rq: " + res);
        return res;
    }

    public String utilisateurName_show(String id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT " + utilisateur_prenom + " FROM " + table_utilisateur + " WHERE id = '" + id + "'", null); //je comprtend pas pourquoi ca affiche null

        String res = "";

        while(c.moveToNext())
        {
            String name = c.getString(0);
            res+= name;
        }
        System.out.println(res);
        return res;
    }

    public ArrayList utilisateur_show_id(String id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM " + table_utilisateur + " WHERE id = '" + id + "'", null);
        ArrayList res = new ArrayList();
        if(c.moveToNext())
        {
            int IndexName = c.getColumnIndex(utilisateur_nom);
            int IndexFirstname = c.getColumnIndex(utilisateur_prenom);
            int IndexEmail = c.getColumnIndex(utilisateur_email);

            do {
                String name = c.getString(IndexName);
                //Log.d("myTagA", "name = "+name);
                String firstname = c.getString(IndexFirstname);
                String mail = c.getString(IndexEmail);
                res.add(name);
                res.add(firstname);
                res.add(mail);
            } while (c.moveToNext());
        }
        return res;
    }



}