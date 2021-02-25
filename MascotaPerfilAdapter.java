package com.proventaja.tiendit.petagram;

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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MascotaPerfilAdapter extends RecyclerView.Adapter<MascotaPerfilAdapter.MascotaPerfilViewHolder>  {

    private ArrayList<Mascota> items;
    private Context ctx;
    public MascotaPerfilAdapter(Context _ctx, ArrayList<Mascota> _mascota){
        ctx = _ctx;
        items = _mascota;


    }
    //inflaa el molde
    @Override
    public MascotaPerfilAdapter.MascotaPerfilViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_mascotas_perfil_item, viewGroup, false);
        MascotaPerfilViewHolder mv = new MascotaPerfilViewHolder(v);
        return mv;
    }

    //remplazar el contenido del modle
    @Override
    public void onBindViewHolder( MascotaPerfilAdapter.MascotaPerfilViewHolder holder, int i) {
        final Mascota item = items.get(i);
        holder.iv_imagen.setImageResource(item.getImagen());
        holder.tv_nombre.setText(item.getNombre());
        holder.tv_calificacion.setText(String.valueOf(item.getCalificacion()));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    public static class MascotaPerfilViewHolder extends RecyclerView.ViewHolder {

        public ImageView iv_imagen;
        public TextView tv_nombre;
        public TextView tv_calificacion;

        public MascotaPerfilViewHolder(View v) {
            super(v);
            iv_imagen=v.findViewById(R.id.iv_ofertas_item_imagen1);
            tv_nombre= v.findViewById(R.id.tv_mascota_nombre);
            tv_calificacion = v.findViewById(R.id.tv_mascota_puntaje);



        }
    }
}
