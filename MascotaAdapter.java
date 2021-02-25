package com.proventaja.tiendit.petagram;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>  {


     ArrayList<Mascota> mascotas;

   private Activity activity;
    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity){

        this.mascotas = mascotas;
        this.activity = activity;

    }
    //inflaa el molde
    @Override
    public MascotaAdapter.MascotaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mascotas_item, viewGroup, false);
        MascotaViewHolder mvh = new MascotaViewHolder(v);
        return mvh;
    }

    //remplazar el contenido del modle
    @Override
    public void onBindViewHolder( MascotaAdapter.MascotaViewHolder holder, int i) {
        Mascota mascota = mascotas.get(i);
        holder.iv_imagen.setImageResource(mascota.getImagen());
        holder.tv_nombre.setText(mascota.getNombre());
        holder.tv_calificacion.setText(String.valueOf(mascota.getCalificacion()));

        holder.btnLike.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darMegustaMascota(mascota);
                holder.btnLike.setText(String.valueOf(constructorMascotas.darMegustaMascota(mascota)+" Likes"));
            }
        });



          }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    public static class MascotaViewHolder extends RecyclerView.ViewHolder {


        public ImageView iv_imagen;
        public TextView tv_nombre;
        public TextView tv_calificacion;
        public ImageButton btnLike;


        public MascotaViewHolder(View v) {
            super(v);
            iv_imagen=v.findViewById(R.id.iv_ofertas_item_imagen1);
            tv_nombre= v.findViewById(R.id.tv_mascota_nombre);
            tv_calificacion = v.findViewById(R.id.tv_mascota_puntaje);
            btnLike =v.findViewById(R.id.iv_huesito_izq);

        }
    }
}
