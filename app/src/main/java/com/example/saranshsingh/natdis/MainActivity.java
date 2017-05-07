package com.example.saranshsingh.natdis;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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

    /*@Override
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
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();
        Intent intent=null;
        if (id == R.id.eq) {
            //fragmentManager.beginTransaction().replace(R.id.content_frame, new first()).commit();
            intent=new Intent(this, MainActivityEquake.class);
        } else if (id == R.id.tsu) {
            //fragmentManager.beginTransaction().replace(R.id.content_frame, new second()).commit();
            intent=new Intent(this, MainActivityTsu.class);
            // use instead-> intent = new Intent(this, Activity_0.class);

        } else if (id == R.id.hurric) {
            intent=new Intent(this,MainActivityHur.class);

        } else if (id == R.id.mitig) {
            intent=new Intent(this, MitigActivity.class);

        } else if (id == R.id.contact) {
            intent=new Intent(this, ContactsActivity.class);
        }
        startActivity(intent);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
/*
for activity instead of fragment
public void selectItem(int position) {
    Intent intent = null;
    switch(position) {
        case 0:
            intent = new Intent(this, Activity_0.class);
            break;
        case 1:
            intent = new Intent(this, Activity_1.class);
            break;

        ...


        case 4:
            intent = new Intent(this, Activity_4.class);
            break;

        default :
            intent = new Intent(this, Activity_0.class); // Activity_0 as default
            break;
    }

    startActivity(intent);
}
Finally, add this method to your DrawerItemClickListener :

private class DrawerItemClickListener implements ListView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        selectItem(position);
        drawerLayout.closeDrawer(drawerListView);

    }
}
 */
