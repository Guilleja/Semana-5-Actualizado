package com.proventaja.tiendit.petagram;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.proventaja.tiendit.petagram.ConstantesBasedeDatos.DATABASE_NAME;
//import static com.proventaja.tiendit.petagram.ConstantesBasedeDatos.TABLE_PERROS_IMAGEN;
import static com.proventaja.tiendit.petagram.ConstantesBasedeDatos.TABLE_MEGUSTA_PERROS_ID;
import static com.proventaja.tiendit.petagram.ConstantesBasedeDatos.TABLE_MEGUSTA_PERROS_NOMBRE_ID;
import static com.proventaja.tiendit.petagram.ConstantesBasedeDatos.TABLE_PERROS_IMAGEN;
import static com.proventaja.tiendit.petagram.ConstantesBasedeDatos.TABLE_PERROS_NOMBRE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {
    private RecyclerView rv_mascota;
    private TextView tv_mascota_nombre;
    private ImageView iv_ofertas_item_imagen1;
    public Context context;
    private ArrayList<Mascota> listaMascotas;
    private static final int LIKE = 1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static InicioFragment newInstance() {
        InicioFragment fragment = new InicioFragment();

        return fragment;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        //crear una lista de mascotas


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_inicio, container, false);
        rv_mascota = mView.findViewById(R.id.rv_animales);
        tv_mascota_nombre = mView.findViewById(R.id.tv_mascota_nombre);
        iv_ofertas_item_imagen1 = mView.findViewById(R.id.iv_ofertas_item_imagen1);
      /*  listaMascotas = new ArrayList<>();
        listaMascotas.add(new Mascota(R.drawable.perro1,"Pepe", 5));
        listaMascotas.add(new Mascota(R.drawable.perro2,"Blue ", 3));
        listaMascotas.add(new Mascota(R.drawable.perro3,"Locote ", 2));
        listaMascotas.add(new Mascota(R.drawable.perro4,"Berna", 5));
        listaMascotas.add(new Mascota(R.drawable.perro5,"Ponche", 4));
        listaMascotas.add(new Mascota(R.drawable.perro6,"Lala", 5));
        listaMascotas.add(new Mascota(R.drawable.perro7,"Lucas", 4));
        //configuramos el recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rv_mascota.setLayoutManager(llm);
        rv_mascota.setAdapter(new MascotaAdapter(getContext(),listaMascotas));

        return mView;*/
      return mView;

          }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // getActivity().setTitle("Petragram");
    }
}
