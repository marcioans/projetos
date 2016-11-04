package com.fucapi.projeto.saudenasnuvens.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
//import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
//import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fucapi.projeto.saudenasnuvens.MainActivity;
import com.fucapi.projeto.saudenasnuvens.R;

import static com.fucapi.projeto.saudenasnuvens.R.layout.fragment_my_alert_dialog;


public class MyAlertDialogFragment extends DialogFragment {



    public MyAlertDialogFragment() {
        // Required empty public constructor
    }


    public static MyAlertDialogFragment newInstance(int title) {
        MyAlertDialogFragment frag = new MyAlertDialogFragment();
        Bundle args = new Bundle();
        args.putInt("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int title = getArguments().getInt("title");

        return new AlertDialog.Builder(getActivity())
                .setIcon(R.drawable.ic_menu_share)
                .setTitle(title)
                .setPositiveButton(R.string.alert_dialog_ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((MainActivity)getActivity()).doPositiveClick();
                            }
                        }
                )
                .setNegativeButton(R.string.alert_dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((MainActivity)getActivity()).doNegativeClick();
                            }
                        }
                )
                .create();
    }

}
