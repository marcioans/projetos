package com.fucapi.projeto.saudenasnuvens;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // Firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    //private //mUsername

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(new Intent(this, EmailPasswordActivity.class));
            finish();
            return;
        } else {
            Toast.makeText(getApplicationContext(), "Bem vindo, "+ mFirebaseUser.getEmail(),
                    Toast.LENGTH_SHORT).show();
            //mUsername = mFirebaseUser.getDisplayName();
            //if (mFirebaseUser.getPhotoUrl() != null) {
            //    mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            //}
        }
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_opcao1:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "Ação Escolhida - 1",
                        Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_opcao2:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Toast.makeText(getApplicationContext(), "Ação Escolhida - 2",
                        Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_opcao3:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                mFirebaseAuth.signOut();
                startActivity(new Intent(this, EmailPasswordActivity.class));
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_grupo) {
            startActivity(new Intent(this, GrupoFragment.class));
            finish();
        } else if (id == R.id.nav_dependente) {

        } else if (id == R.id.nav_vacina) {

        } else if (id == R.id.nav_consulta) {

        } else if (id == R.id.nav_exame) {

        } else if (id == R.id.nav_grupos_cad) {

        } else if (id == R.id.nav_dependente_cad) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
