package com.example.examenparcial_alexandevalverde;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenparcial_alexandevalverde.databinding.FragmentMapaCalorBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapaCalor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapaCalor extends Fragment {

    private FragmentMapaCalorBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MapaCalor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapaCalor.
     */
    // TODO: Rename and change types and number of parameters
    public static MapaCalor newInstance(String param1, String param2) {
        MapaCalor fragment = new MapaCalor();
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
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMapaCalorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String Descripcion = MapaCalorArgs.fromBundle(getArguments()).getDescripcion();
        String Impacto = MapaCalorArgs.fromBundle(getArguments()).getImpacto();
        String Probabilidad = MapaCalorArgs.fromBundle(getArguments()).getProbabilidad();
        binding.txtDescripcion.setText(Descripcion);
        //Parte de la logica de los Botones
        if (Impacto.equals("Alto") && Probabilidad.equals("Bajo")) {
            binding.btn1.setText("R"); // Impacto Alto, Probabilidad Baja
        } else if (Impacto.equals("Alto") && Probabilidad.equals("Medio")) {
            binding.btn2.setText("R"); // Impacto Alto, Probabilidad Media
        } else if (Impacto.equals("Alto") && Probabilidad.equals("Alto")) {
            binding.btn3.setText("R"); // Impacto Alto, Probabilidad Alta
        } else if (Impacto.equals("Medio") && Probabilidad.equals("Bajo")) {
            binding.btn4.setText("R"); // Impacto Medio, Probabilidad Baja
        } else if (Impacto.equals("Medio") && Probabilidad.equals("Medio")) {
            binding.btn5.setText("R"); // Impacto Medio, Probabilidad Media
        } else if (Impacto.equals("Medio") && Probabilidad.equals("Alto")) {
            binding.btn6.setText("R"); // Impacto Medio, Probabilidad Alta
        } else if (Impacto.equals("Bajo") && Probabilidad.equals("Bajo")) {
            binding.btn7.setText("R"); // Impacto Bajo, Probabilidad Baja
        } else if (Impacto.equals("Bajo") && Probabilidad.equals("Medio")) {
            binding.btn8.setText("R"); // Impacto Bajo, Probabilidad Media
        } else if (Impacto.equals("Bajo") && Probabilidad.equals("Alto")) {
            binding.btn9.setText("R"); // Impacto Bajo, Probabilidad Alta
        }


        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });


    }
}