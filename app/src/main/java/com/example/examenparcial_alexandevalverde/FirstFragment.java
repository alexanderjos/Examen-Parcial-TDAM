package com.example.examenparcial_alexandevalverde;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.examenparcial_alexandevalverde.databinding.FragmentFirstBinding;

import java.util.HashMap;
import java.util.Map;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    Map<String, String> usuarios = new HashMap<>();

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        usuarios.put("Alexander","1234");
        usuarios.put("Valverde","4321");
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = binding.edtUsuario.getText().toString();
                String contraseña = binding.edtContraseA.getText().toString();
                boolean validacion = true;
                if (usuario.isEmpty()||usuario.equals(" ")){
                    validacion = false;
                }
                if (contraseña.equals(" ")||contraseña.isEmpty()){
                    validacion = false;
                }
                if(validacion == true){
                    String contraseñaCorrecta;
                    contraseñaCorrecta = usuarios.get(usuario);
                    if (contraseña.equals(contraseñaCorrecta)){
                        FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                                FirstFragmentDirections.actionFirstFragmentToSecondFragment(usuario);
                        NavHostFragment.findNavController(FirstFragment.this).navigate(action);
                    }else {
                        Toast.makeText(getActivity(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Debe llenar los campos", Toast.LENGTH_SHORT).show();
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