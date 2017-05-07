package com.example.saranshsingh.natdis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Saransh Singh on 04-05-2017.
 */

public class ContactsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitig);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        DataObject obj = new DataObject("Australian Government ","+61 1300 555 135");
        results.add(0, obj);

        DataObject obj1 = new DataObject("Canadian Government","(613) 996-8885");
        results.add(1, obj1);

        DataObject obj2 = new DataObject("Chinese Government ","(852) 2829 3010");
        results.add(2, obj2);

        DataObject obj3 = new DataObject("Greek Government ","(210) 368 1212");
        results.add(3, obj3);

        DataObject obj4 = new DataObject("New Zealand Government  ","0800 432 111");
        results.add(4, obj4);

        DataObject obj5 = new DataObject("Republic of Ireland ","353 1 408 2585");
        results.add(5, obj5);

        DataObject obj6 = new DataObject("UK Government  ","0207 008 0000");
        results.add(6, obj6);

        DataObject obj7 = new DataObject("US Government","(202) 647-5225");
        results.add(7, obj7);

        DataObject obj8 = new DataObject("Bangladesh","(880)(2) 882 2705");
        results.add(8, obj8);

        DataObject obj9 = new DataObject("India","+91 11 2309 3054");
        results.add(9, obj9);

        DataObject obj10 = new DataObject("Malaysia","03-2262-6555");
        results.add(10, obj10);

        DataObject obj11 = new DataObject("Sri Lanka" ,"+94 11 536 1938");
        results.add(11, obj11);

        DataObject obj12 = new DataObject("Thailand" ,"(66) 02 643 5262");
        results.add(12, obj12);

        DataObject obj13 = new DataObject("Maldives" ,"+44 20 7224 2149 ");
        results.add(13, obj13);



        return results;
    }
}
