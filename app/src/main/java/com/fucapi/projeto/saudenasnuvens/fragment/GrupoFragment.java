package com.fucapi.projeto.saudenasnuvens.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.fucapi.projeto.saudenasnuvens.MainActivity;
import com.fucapi.projeto.saudenasnuvens.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GrupoFragment extends Fragment {


    public GrupoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grupo, container, false);
        Button b = (Button) view.findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity().getApplicationContext()
                        ,"estou no fragmento", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

}
