package com.example.edwinhernandez.mdexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout drawerLayoutt;
    private ListView listView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private Toolbar toolbar;

    private FloatingActionButton btnFlota;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] navigationDrawerItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = mDrawerTitle = getTitle();
        toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        setSupportActionBar(toolbar);

        navigationDrawerItems = getResources().getStringArray(R.array.navigation_drawer_items);
        drawerLayoutt = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        // set up the drawer's list view with items and click listener
        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, navigationDrawerItems));
        listView.setOnItemClickListener(new DrawerItemClickListener());

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayoutt, toolbar, R.string.app_name, R.string.app_name);
        drawerLayoutt.setDrawerListener(actionBarDrawerToggle);

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        if (savedInstanceState == null) {
            selectItem(0);
        }




/*

        //Creando el Dataset, recuerda que esto no siempre es hardcodeado
        ArrayList<Pusheen> pusheens = new ArrayList<>();

        Pusheen pusheen = new Pusheen();
        pusheen.setId(1);
        pusheen.setName("Pusheen");
        pusheen.setPasTime("Blogger");
        pusheens.add(pusheen);

        Pusheen pusheen2 = new Pusheen();
        pusheen2.setId(2);
        pusheen2.setName("Pusheen");
        pusheen2.setPasTime("Sculpor");
        pusheens.add(pusheen2);

        Pusheen pusheen3 = new Pusheen();
        pusheen3.setId(3);
        pusheen3.setName("Stormy");
        pusheen3.setPasTime("Mage");
        pusheens.add(pusheen3);

        Pusheen pusheen4 = new Pusheen();
        pusheen4.setId(4);
        pusheen4.setName("Pusheen");
        pusheen4.setPasTime("Tribute");
        pusheens.add(pusheen4);

        Pusheen pusheen5 = new Pusheen();
        pusheen5.setId(5);
        pusheen5.setName("Stormy");
        pusheen5.setPasTime("adventurer");
        pusheens.add(pusheen5);
        //Fin de nuestro dataset

        //Configuración del recyclerView, con nuestro dataSet y nuestro Adapter

        //Aqui buscamos el Widget recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        //A pesar del tamaño de la pantalla, asegurar que los elementos se vean siempre igual.
        recyclerView.setHasFixedSize(true);

        //Configuramos la animación por defecto
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Ahora le pasamos nuestro dataset y la forma en que se vera cada fila.
        recyclerView.setAdapter(new PusheenAdapter(pusheens, R.layout.row));

        //Importante, ahora podemos indicar si mostrar los elementos como fila o como grilla, en este
        //caso setLayoutManager() esta  configurado como grilla de una columna, es por es eso que se ve
        //como fila, recordar que el mismo resultado se obtiene con
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));*/

        FloatingActionButton button;
        button = (FloatingActionButton) findViewById(R.id.btnFloat);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BTNFloat.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
        Fragment fragment = new DummyFragment();
      /*  Bundle args = new Bundle();
        args.putInt(DummyFragment.ARG_MENU_INDEX, position);
        fragment.setArguments(args);
*/
        switch (position){
            case 0:
                fragment = new FragmentInicio();
                break;
            case 1:
                fragment = new FragmentNuevo();
                break;
            case 2:
                fragment = new FragmentDos();
                break;
        }
        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // update selected item and title, then close the drawer
        listView.setItemChecked(position, true);
        setTitle(navigationDrawerItems[position]);
        drawerLayoutt.closeDrawer(listView);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setIcon(android.R.color.transparent);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    public static class DummyFragment extends Fragment {
        public static final String ARG_MENU_INDEX = "index";

        public DummyFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.dummy_fragment, container, false);
            int index = getArguments().getInt(ARG_MENU_INDEX);
            String text = String.format("Menu at index %s", index);
            ((TextView) rootView.findViewById(R.id.textView)).setText(text);
            getActivity().setTitle(text);
            return rootView;
        }
    }


}
