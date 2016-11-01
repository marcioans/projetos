package com.fucapi.projeto.saudenasnuvens.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fucapi.projeto.saudenasnuvens.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class VacinaFragment extends Fragment {


    public VacinaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vacina, container, false);
    }

}
