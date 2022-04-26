package com.example.listeview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView LstView1 ;
    EditText inputTxt;
    Button Add , Update ;

    ArrayList<String> Names = new ArrayList<String>();
    ArrayAdapter MyAd;

    Integer val;
    String item;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LstView1 = (ListView) findViewById(R.id.listeview1);
        Add = (Button) findViewById(R.id.button);
        Update = (Button) findViewById(R.id.button2);
        inputTxt = (EditText) findViewById(R.id.inputTxt1);


        // Setup listView
        Names.add("Abdessalam");
        Names.add("Benayyad");


        MyAd = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Names);
        LstView1.setAdapter(MyAd);


        // Add items
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String v = inputTxt.getText().toString();
                    Names.add(v);
                    MyAd.notifyDataSetChanged();

                    inputTxt.setText("");
            }
        });

        // Update items
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v = inputTxt.getText().toString();
                Names.set(val,v);
                MyAd.notifyDataSetChanged();

                inputTxt.setText("");
            }
        });

        // listView
        LstView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  item = adapterView.getItemAtPosition(i).toString() + "has been selected";
                  val = i;
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });



    }
}