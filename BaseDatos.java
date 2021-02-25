package com.proventaja.tiendit.petagram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {

        super(context, ConstantesBasedeDatos.DATABASE_NAME, null, ConstantesBasedeDatos.DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBasedeDatos.TABLE_PERROS
                + "(" + ConstantesBasedeDatos.TABLE_PERROS_ID   + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBasedeDatos.TABLE_PERROS_NOMBRE       + " TEXT," +
                ConstantesBasedeDatos.TABLE_PERROS_IMAGEN         + " INTEGER" +
                ")";

        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesBasedeDatos.TABLE_MEGUSTA_PERROS
                + "(" + ConstantesBasedeDatos.TABLE_MEGUSTA_PERROS_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBasedeDatos.TABLE_MEGUSTA_PERROS_NOMBRE_ID     + " INTEGER," +
                ConstantesBasedeDatos.TABLE_MEGUSTA_PERRO_NUMERO_MEGUSTA    + " INTEGER," +
                " FOREIGN KEY (" + ConstantesBasedeDatos.TABLE_MEGUSTA_PERROS_ID + ") " +
                " REFERENCES " + ConstantesBasedeDatos.TABLE_PERROS + "(" + ConstantesBasedeDatos.TABLE_PERROS_ID +")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBasedeDatos.TABLE_PERROS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBasedeDatos.TABLE_MEGUSTA_PERROS);

        this.onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBasedeDatos.TABLE_PERROS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);


        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));

        String    queryLikes = "SELECT COUNT ( " + ConstantesBasedeDatos.TABLE_MEGUSTA_PERRO_NUMERO_MEGUSTA + ")" +
                    " FROM " + ConstantesBasedeDatos.TABLE_MEGUSTA_PERROS +
                    " WHERE " + ConstantesBasedeDatos.TABLE_PERROS_NOMBRE + " = " + mascotaActual.getId();

         Cursor   registroLikes = db.rawQuery(queryLikes, null);
            if(registroLikes.moveToNext()){
                mascotaActual.setCalificacion(registroLikes.getInt(0));
            }else{

                mascotaActual.setCalificacion(0);
            }


            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;
    }
    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBasedeDatos.TABLE_PERROS, null, contentValues);
        db.close();
    }
    public void insertarMegustaMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBasedeDatos.TABLE_MEGUSTA_PERROS, null, contentValues);
        db.close();
    }

    public int obtenerMeGustaMascota(Mascota mascota){

        int likes = 0;

        String query = "SELECT COUNT ( " + ConstantesBasedeDatos.TABLE_MEGUSTA_PERRO_NUMERO_MEGUSTA + ")" +
                " FROM " + ConstantesBasedeDatos.TABLE_MEGUSTA_PERROS +
                " WHERE " + ConstantesBasedeDatos.TABLE_PERROS_NOMBRE + " = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while(registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
        }
