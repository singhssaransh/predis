package com.example.saranshsingh.natdis;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivityTsu extends FragmentActivity implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {
    SupportMapFragment sMapFragment;
    android.support.v4.app.FragmentManager supFragMan;
    String lat[],month[],separatedCont[];
    Marker trypos;
    int choice;
    Spinner spinChoice1,spinChoice2;
    ProgressDialog pDialog;
    String strChoice1,strChoice2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tsu);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Fetching From Server, Please wait.");
        pDialog.setCancelable(false);
        /*Spinners*/
        spinChoice1 = (Spinner) findViewById(R.id.spinner1);
        spinChoice1.setOnItemSelectedListener(this);
        spinChoice2 = (Spinner)findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("Time/Month");
        list.add("Location");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter.notifyDataSetChanged();
        spinChoice1.setAdapter(dataAdapter);

        /*Spinners end*/
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {
        //showpDialog();
        int vid=adapterView.getId();
        switch(vid) {

            case R.id.spinner1:
            {
                strChoice1=String.valueOf(spinChoice1.getSelectedItem());
                // et=(EditText) findViewById(R.id.editText);
                //spinChoice2.setEnabled(false);
                //et.setEnabled(false);
                if (strChoice1.contentEquals("Time/Month"))
                {
                    spinChoice2.setEnabled(true);
                    //hidepDialog();
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(1);
                    list.add(2);
                    list.add(3);
                    list.add(4);
                    list.add(5);
                    list.add(6);
                    list.add(7);
                    list.add(8);
                    list.add(9);
                    list.add(10);
                    list.add(11);
                    list.add(12);
                    ArrayAdapter<Integer> dataAdapter1 = new ArrayAdapter<Integer>(
                            this,android.R.layout.simple_spinner_item,list);
                    dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter1.notifyDataSetChanged();
                    spinChoice2.setAdapter(dataAdapter1);
                }
                else if (strChoice1.contentEquals("Location"))
                {
                    //spinChoice2.setEnabled(false);
                    //hidepDialog();
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(0);
                    ArrayAdapter<Integer> dataAdapter2 = new ArrayAdapter<Integer>(
                            this,android.R.layout.simple_spinner_item,list);
                    dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter2.notifyDataSetChanged();
                    spinChoice2.setAdapter(dataAdapter2);
                    //et.setEnabled(true);
                }

                spinChoice2.setOnItemSelectedListener(this);
            }
            break;

            case R.id.spinner2:
            {
                /*Server*/
                //showpDialog();
                URL serv= null;
                int status;
                strChoice2 = String.valueOf(spinChoice2.getSelectedItem());
                try {
                    choice=Integer.parseInt(strChoice2);
                }
                catch (NumberFormatException e)
                {
                    e.getMessage();
                }

                HttpURLConnection urlConnection=null;
                InputStream is=null;
                BufferedReader rd=null;
                try {
                    serv = new URL("http://107.170.79.67:8007/eq/?a="+choice);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    urlConnection=(HttpURLConnection)serv.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    is=urlConnection.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    status=urlConnection.getResponseCode();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    rd = new BufferedReader(new InputStreamReader(is), 4096);
                }
                catch (NullPointerException e)
                {
                    Toast.makeText(getApplicationContext(),"Check data connection",Toast.LENGTH_SHORT).show();
                }
                String line;
                StringBuilder sb =  new StringBuilder();
                try {
                    while ((line = rd.readLine()) != null) {
                        sb.append(line);
                    }
                    rd.close();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                sb.deleteCharAt(0);
                sb.append('[');
                String contents = sb.toString();
                separatedCont = contents.split("\\]");
                for (int i=0;i<separatedCont.length;i++)
                {
                    separatedCont[i]=separatedCont[i].replaceAll("\\[","");
                }
                for (int i=0;i<separatedCont.length;i++)
                {
                    separatedCont[i]=separatedCont[i].trim();
                }


/*Server end*/
                supFragMan = getSupportFragmentManager();
                sMapFragment = SupportMapFragment.newInstance();
                if (sMapFragment.isAdded()) {
                    supFragMan.beginTransaction().hide(sMapFragment).commit();
                }
                if (!sMapFragment.isAdded())
                {
                    supFragMan.beginTransaction().add(R.id.content, sMapFragment).commit();
                }
                else
                    supFragMan.beginTransaction().show(sMapFragment).commit();
                sMapFragment.getMapAsync(this);
            }
            break;
        }

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        if (trypos!=null) {
            trypos.remove();
        }

        if (choice==0) {


            lat= new String[separatedCont.length/2];
            month= new String[separatedCont.length/2];
            int c1=0,c2=0;
            for (int i=0;i<separatedCont.length-1;i+=2)
            {
                lat[c1++]=separatedCont[i].replaceAll(" +",",");
                month[c2++]=separatedCont[i+1].replaceAll("\\.","");

            }
            for (int i=0;i<month.length;i++)
            {
                int s=Integer.parseInt(month[i]);
                if(s==1)
                    month[i]="January";
                if(s==2)
                    month[i]="February";
                if(s==3)
                    month[i]="March";
                if(s==4)
                    month[i]="April";
                if(s==5)
                    month[i]="May";
                if(s==6)
                    month[i]="June";
                if(s==7)
                    month[i]="July";
                if(s==8)
                    month[i]="August";
                if(s==9)
                    month[i]="September";
                if(s==10)
                    month[i]="October";
                if(s==11)
                    month[i]="November";
                if(s==12)
                    month[i]="December";
            }

            //printing markers
            double arr1[] = new double[lat.length];
            double arr2[] = new double[lat.length];
            String arr3[] = new String[2];
            for (int i = 0; i < lat.length; i++) {
                //String[] separatedCont = contents.split("\\]");
                arr3 = lat[i].split(",");
                arr1[i] = Double.parseDouble(arr3[0]);
                arr2[i] = Double.parseDouble(arr3[1]);
            }

            for (int i = 0; i < lat.length; i++) {
                LatLng pos = new LatLng(arr1[i], arr2[i]);
                trypos = googleMap.addMarker(new MarkerOptions().position(pos).title("Prediction").snippet("Month:" + month[i]).flat(false)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
                trypos.showInfoWindow();
            }
        }
        else
        {
            lat= new String[separatedCont.length];
            int c1=0;
            for (int i=0;i<separatedCont.length;i++)
            {
                lat[c1++]=separatedCont[i].replaceAll(" +",",");
            }

            //printing markers
            double arr1[] = new double[lat.length/2];
            double arr2[] = new double[lat.length/2];
            String arr3[] = new String[2];
            for (int i = 0; i < lat.length/2; i++) {
                //String[] separatedCont = contents.split("\\]");
                arr3 = lat[i].split(",");
                arr1[i] = Double.parseDouble(arr3[0]);
                arr2[i] = Double.parseDouble(arr3[1]);
            }

            for (int i = 0; i < lat.length/2; i++) {
                LatLng pos = new LatLng(arr1[i], arr2[i]);
                trypos = googleMap.addMarker(new MarkerOptions().position(pos).title("Prediction").snippet("Month:" + choice).flat(false)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
                trypos.showInfoWindow();
            }
            //hidepDialog();
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                //warn
            }
            else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        1);

            }
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                //warn
            }
            else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        2);

            }
            return;
        }

        googleMap.setMyLocationEnabled(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                }
                return;
            }
            case 2: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
