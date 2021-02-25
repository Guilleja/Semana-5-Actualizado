package com.proventaja.tiendit.petagram;

import android.content.Context;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private PresentadorIRecyclerViewFragmentPresenter iReyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IReyclerViewFragmentView iReyclerViewFragmentView, Context context) {
        this.iReyclerViewFragmentView = iReyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {

        iReyclerViewFragmentView.inicializarAdaptadorRV(iReyclerViewFragmentView.crearAdaptador(mascotas));
        iReyclerViewFragmentView.generarLinearLayoutVertical();
    }
}