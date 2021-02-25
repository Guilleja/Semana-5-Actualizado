package com.proventaja.tiendit.petagram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {
    private RecyclerView rv_mascota;
    private ArrayList<Mascota> listaMascotas ;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView tv_nombre;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static PerfilFragment newInstance() {
        PerfilFragment fragment = new PerfilFragment();

        return fragment;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_perfil, container, false);


        rv_mascota = mView.findViewById(R.id.rv_animales_favoritos_perfil);






        return  mView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        //crear una lista de mascotas
        listaMascotas = new ArrayList<>();
        listaMascotas.add(new Mascota(R.drawable.perro1,"5", 5));
        listaMascotas.add(new Mascota(R.drawable.perro1,"4", 5));
        listaMascotas.add(new Mascota(R.drawable.perro1,"1", 3));
        listaMascotas.add(new Mascota(R.drawable.perro1,"6", 4));
        listaMascotas.add(new Mascota(R.drawable.perro1,"2", 3));
        //configuramos el recyclerview
        LinearLayoutManager llma = new LinearLayoutManager(getContext());
        llma.setOrientation(LinearLayoutManager.HORIZONTAL);

        rv_mascota.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rv_mascota.setAdapter(new MascotaPerfilAdapter(getContext(),listaMascotas));
        //setTitle("Petagram");

    }
    }
