package com.ever.cal;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.ever.cal.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends DialogFragment {
Context contex;
ListView listView;
ArrayList<savelist>arrayList;
    public BlankFragment(Context contex, ArrayList<savelist>arrayList) {
        this.contex=contex;
        this.arrayList=arrayList;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_blank, container, false);
      ListView listView=  v.findViewById(R.id.list);
      adapterdia adapterdia=new adapterdia(contex,arrayList);
     listView.setAdapter(adapterdia);




       return v;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog= super.onCreateDialog(savedInstanceState);

     dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

    return dialog;
    }
}
