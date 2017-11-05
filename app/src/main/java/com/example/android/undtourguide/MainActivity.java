package com.example.android.undtourguide;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // When user first open the app, show summary
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_body, new OverviewFragment())
                .commit();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_to:
                /** When user clicks on T.O. option start {@link OverviewFragment} */
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_body, new OverviewFragment())
                        .commit();
                break;
            case R.id.nav_architecture:
                /** When user clicks on Architecture option start {@link ArchitectureFragment} */
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_body, new ArchitectureFragment())
                        .commit();
                break;
            case R.id.nav_restaurant:
                /** When user clicks on Restaurant option start {@link RestaurantFragment} */
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_body, new RestaurantFragment())
                        .commit();
                break;
            case R.id.nav_shopping:
                /** When user clicks on Shopping option start {@link ShoppingFragment} */
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_body, new ShoppingFragment())
                        .commit();
                break;
            case R.id.nav_nightlife:
                /** When user clicks on Music and Nightlife option start {@link MusicAndNightLifeFragment} */
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_body, new MusicAndNightLifeFragment())
                        .commit();
                break;
            default:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_body, new OverviewFragment())
                        .commit();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}