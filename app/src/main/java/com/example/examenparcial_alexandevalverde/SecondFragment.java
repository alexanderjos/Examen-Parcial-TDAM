package com.example.examenparcial_alexandevalverde;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.examenparcial_alexandevalverde.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String Usuario = SecondFragmentArgs.fromBundle(getArguments()).getUsuario();
        binding.txtBienvenida.setText("Hola "+Usuario);
        binding.btnMapaCalor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String descripcion = binding.edtDescripcion.getText().toString();
                int selectImpacto = binding.rgImpacto.getCheckedRadioButtonId();
                int selectProbabilidad = binding.rgProbabilidad.getCheckedRadioButtonId();

                String mensaje = "";
                Boolean validacion = true;
                if (descripcion.isEmpty()||descripcion.equals(" ")){
                    mensaje = "Por favor, escribe una descripción.";
                    validacion = false;
                }
                if (selectImpacto == -1) {
                    mensaje = "Por favor, selecciona un impacto.";
                    validacion = false;
                }
                if (selectProbabilidad == -1) {
                    mensaje = "Por favor, selecciona una probabilidad.";
                    validacion = false;
                } 
                if (validacion==true) {
                    RadioButton selectRadio = binding.getRoot().findViewById(selectImpacto);
                    String textoSelecionadoImpacto = selectRadio.getText().toString();
                    RadioButton selectRadio1 = binding.getRoot().findViewById(selectProbabilidad);
                    String textoProbabiliad = selectRadio1.getText().toString();
                    SecondFragmentDirections.ActionSecondFragmentToMapaCalor action1 =
                            SecondFragmentDirections.actionSecondFragmentToMapaCalor(textoSelecionadoImpacto,textoProbabiliad,descripcion);
                    NavHostFragment.findNavController(SecondFragment.this).navigate(action1);
                        
                    

                }else {
                    Toast.makeText(getActivity(), "Error: "+mensaje, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}