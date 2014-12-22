package com.example.edwinhernandez.mdexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edwinhernandez on 19/12/14.
 */
public class FragmentDos extends Fragment {
    List<ContactInfo> lista;
    ContactInfo uno,dos;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.activity_fragmento3, container, false);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        uno= new ContactInfo();
        uno.name="Edwin";
        uno.email="correo@dominiodeedwin.com";
        uno.surname="breve descrpcion";
        uno.titulo="Titulo Edwin";

        dos= new ContactInfo();
        dos.name="Daniel";
        dos.email="correo@dominiodedaniel.com";
        dos.surname="no se que sea esto";
        dos.titulo="Titulo Daniel";

        lista= new ArrayList<>();
        lista.add(uno);
        lista.add(dos);

        RecyclerView recList = (RecyclerView)getActivity().findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getBaseContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        ContactAdapter mAdapter = new ContactAdapter(lista);
        recList.setAdapter(mAdapter);

    }
}
