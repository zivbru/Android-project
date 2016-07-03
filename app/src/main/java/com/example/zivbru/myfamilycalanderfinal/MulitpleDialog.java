package com.example.zivbru.myfamilycalanderfinal;

import android.app.AlertDialog;
import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import java.net.InterfaceAddress;
import java.util.ArrayList;


public class MulitpleDialog extends DialogFragment {


    public MulitpleDialog() {

    }

    boolean[] selected = new boolean[15];
    String[] data ;

    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Users list");
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), "CANCEL", Toast.LENGTH_LONG).show();
            }
        });
        builder.setMultiChoiceItems(data, selected, new
                DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        selected[which] = isChecked;
                    }
                });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String selects = "";
                for (int i = 0; i < selected.length; i++) {
                    if (selected[i]) selects = selects + " " + data[i];
                }
                Toast.makeText(getActivity(), "OK " + selects,
                        Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "CANCEL",
                                Toast.LENGTH_LONG).show();
                    }
                });
        return builder.create();


    }

    public void setData(ArrayList<String> arrayList){
        data= arrayList.toArray(new String[arrayList.size()]);
        selected= new boolean[arrayList.size()];


    }

    public interface GetSelectedUsers {
        void done(boolean[] selected);
    }
}
