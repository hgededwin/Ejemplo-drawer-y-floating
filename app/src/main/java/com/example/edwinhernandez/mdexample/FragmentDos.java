package com.example.edwinhernandez.mdexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by edwinhernandez on 19/12/14.
 */
public class FragmentDos extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.nuevoprueba, container, false);
        return v;
    }
}
