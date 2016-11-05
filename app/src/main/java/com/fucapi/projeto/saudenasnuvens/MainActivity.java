package com.fucapi.projeto.saudenasnuvens;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

//import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.Toast;

import com.fucapi.projeto.saudenasnuvens.fragment.ConsultaFragment;
import com.fucapi.projeto.saudenasnuvens.fragment.DependenteFragment;
import com.fucapi.projeto.saudenasnuvens.fragment.ExameFragment;
import com.fucapi.projeto.saudenasnuvens.fragment.GrupoFragment;
import com.fucapi.projeto.saudenasnuvens.fragment.MyAlertDialogFragment;
import com.fucapi.projeto.saudenasnuvens.fragment.VacinaFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // Firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private static FirebaseDatabase fbDatabase;
    private Menu menu;
    //private int mStackLevel;


    // Initialize Firebase Auth


    //private //mUsername

    // Firebase instance variables
    private DatabaseReference mFirebaseDatabaseReference;
    //private FirebaseRecyclerAdapter<FriendlyMessage, MessageViewHolder> mFirebaseAdapter;

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ativando a persistencia offline

        if(fbDatabase == null) {
            fbDatabase = FirebaseDatabase.getInstance();
            fbDatabase.setPersistenceEnabled(true);
        }



        // Initialize Firebase Auth
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();



        if (mFirebaseUser == null) {
            // Not logged in, launch the Log In activity
            loadLogInView();
        } else {
            Toast.makeText(getApplicationContext(), "Bem vindo, "+ mFirebaseUser.getEmail(),
                    Toast.LENGTH_SHORT).show();
            //mUsername = mFirebaseUser.getDisplayName();
            //if (mFirebaseUser.getPhotoUrl() != null) {
            //    mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            //}
        }


        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]
        //Intent intent = new Intent(this, EmailPasswordActivity.class);
        //startActivity(intent);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void loadLogInView() {
        Intent intent = new Intent(this, EmailPasswordActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

     public boolean onCreateOptionsMenu(Menu menu) {
         // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.menu_main, menu);
         return super.onCreateOptionsMenu(menu);
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //MyMessageHandler.debug("menu item selected");
        switch(item.getItemId()){
            case R.id.action_opcao1:
                showDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_grupo) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new GrupoFragment()).commit();

        } else if (id == R.id.nav_dependente) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new DependenteFragment()).commit();

        } else if (id == R.id.nav_vacina) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new VacinaFragment()).commit();

        } else if (id == R.id.nav_consulta) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new ConsultaFragment()).commit();

        } else if (id == R.id.nav_exame) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new ExameFragment()).commit();

        } else if (id == R.id.nav_grupos_cad) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new GrupoFragment()).commit();

        } else if (id == R.id.nav_dependente_cad) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new DependenteFragment()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    void showDialog() {
        DialogFragment newFragment = MyAlertDialogFragment.newInstance(
                R.string.alert_dialog_two_buttons_title);
        newFragment.show(getFragmentManager(), "dialog");

    }

    public void doPositiveClick() {
        // Do stuff here.
        mFirebaseAuth.signOut();
        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("MainActivity");
        ft.remove(prev);
        startActivity(new Intent(this, EmailPasswordActivity.class));
        finish();
        Log.i("FragmentAlertDialog", "Positive click!");
    }

    public void doNegativeClick() {
        // Do stuff here.
        //Intent intent = new Intent(Intent.ACTION_MAIN);
        //intent.addCategory(Intent.CATEGORY_HOME);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //startActivity(intent);
        Log.i("FragmentAlertDialog", "Negative click!");
    }

}
