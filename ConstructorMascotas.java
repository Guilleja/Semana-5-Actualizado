package com.proventaja.tiendit.petagram;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

public class ConstructorMascotas{
    private static boolean INSERTAR_REGISTROS = false;
    private static final int LIKE = 1;
    private Context context;


    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {

        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);

        return db.obtenerTodasMascotas();

    }
    public ArrayList<Mascota> obtenerConsulta() {

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerTodasMascotas();

    }


    public void insertarMascotas(BaseDatos db){

        if(!INSERTAR_REGISTROS) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBasedeDatos.TABLE_PERROS_NOMBRE, "Lucas");
            contentValues.put(ConstantesBasedeDatos.TABLE_PERROS_IMAGEN, R.drawable.perro1 );
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBasedeDatos.TABLE_PERROS_NOMBRE, "Blue");
            contentValues.put(ConstantesBasedeDatos.TABLE_PERROS_IMAGEN, R.drawable.perro2 );
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBasedeDatos.TABLE_PERROS_NOMBRE, "Unkiki");
            contentValues.put(ConstantesBasedeDatos.TABLE_PERROS_IMAGEN, R.drawable.perro3 );
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBasedeDatos.TABLE_PERROS_NOMBRE, "Unkika");
            contentValues.put(ConstantesBasedeDatos.TABLE_PERROS_IMAGEN, R.drawable.perro4 );
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBasedeDatos.TABLE_PERROS_NOMBRE, "Lasie");
            contentValues.put(ConstantesBasedeDatos.TABLE_PERROS_IMAGEN, R.drawable.perro5 );
            db.insertarMascota(contentValues);

            INSERTAR_REGISTROS = true;
        }
        public void darMegustaMascota( Mascota mascota){

            BaseDatos db = new BaseDatos(context);
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBasedeDatos.TABLE_MEGUSTA_PERROS_ID,mascota.getId());
            contentValues.put(ConstantesBasedeDatos.TABLE_MEGUSTA_PERRO_NUMERO_MEGUSTA, LIKE);
            db.insertarMegustaMascota(contentValues);
        }

        public int obtenerMeGustaMascotas(Mascota mascota){

            BaseDatos db = new BaseDatos(context);
            return db.obtenerMeGustaMascota(mascota);
        }
}}
