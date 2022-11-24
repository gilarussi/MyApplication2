package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> s;
    ArrayAdapter arrayAdapter;
    int n=0;
    private static final String TAG = "Swipe Position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s=new ArrayList<String>();
        s.add("one");
        s.add("two");
        s.add("three");
        s.add("four");
        s.add("five");

        SwipeFlingAdapterView swipeFlingAdapterView=(SwipeFlingAdapterView) findViewById(R.id.card);
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.details, R.id.textView,s);
        swipeFlingAdapterView.setAdapter(arrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter()
            {
                s.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {

            }

            @Override
            public void onRightCardExit(Object o)
            {
                Toast.makeText(MainActivity.this, "Right is swiped", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Right Swipe");
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) {

            }
        });
    }
}