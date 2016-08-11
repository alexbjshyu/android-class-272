package com.example.familyfirst.simpleui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    RadioGroup radioGroup;
    ListView listView;
    Spinner spinner;
    Order order;

    String drink = "Black Tea";

    List<Order> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        //textView.setText("Hello Android!!!!");
        editText = (EditText)findViewById(R.id.editText);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        listView = (ListView)findViewById(R.id.listView);
        spinner = (Spinner)findViewById(R.id.spinner);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId == R.id.blackTeaRadioButton)
                {
                    drink = "Black Tea";
                }
                else if (checkedId == R.id.greenTeaRadioButton)
                {
                    drink = "Green Tea";
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Order order = (Order)parent.getAdapter().getItem(position);
                Toast.makeText(MainActivity.this,order.note,Toast.LENGTH_LONG).show();
            }
        });

        setupListView();
        setupSpinner();

        Log.d("DEBUG","MainActivity OnCreate");
    }

    private void setupSpinner()
    {
        String[] storeInfo = getResources().getStringArray(R.array.storeInfo);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,storeInfo);
                spinner.setAdapter(adapter);
    }

    private void setupListView()
    {
       // String[] data = new String[]{"1","2","3","4","5","6","7"};

//        List<Map<String, String>> mapList = new ArrayList<>();
//
//        for(Order order : data)
//        {
//            Map<String, String> item = new HashMap<>();
//
//            item.put("note", order.note);
//            item.put("storeInfo",order.storeInfo);
//            item.put("drink",order.drink);
//
//            mapList.add(item);
//        }
//
//        String[] from = {"note","storeInfo","drink"};
//        int[] to = {R.id.noteTextView,R.id.storeInfoTextView,R.id.drinkTextView};
//
//        SimpleAdapter adapter = new SimpleAdapter(this,mapList,R.layout.listview_order_item,from,to);

          OrderAdapter adapter = new OrderAdapter(this,data);
          listView.setAdapter(adapter);
    }


    public void click(View view)
    {
        String text = editText.getText().toString();
        String result = text+"Order: " + drink;


        textView.setText(result);

        editText.setText("");

        Order order = new Order();

        order.note = text;
        order.drink = drink;
        order.storeInfo = (String)spinner.getSelectedItem();

        data.add(order);
        setupListView();

    }

    public void goToMenu(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this, DrinkMenuActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("DEBUG","MainActivity OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DEBUG","MainActivity OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("DEBUG","MainActivity OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("DEBUG","MainActivity OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("DEBUG","MainActivity OnDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("DEBUG","MainActivity OnRestart");
    }
}



