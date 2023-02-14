package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner units;
    private TextView inch,ft,m,mm,km,cm,dm,mile,yd,μm;
    double valueToBeConverted;
    String unitOfValue;
    String toStringValue;
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            unitOfValue = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For our custom toolbar
        Toolbar toolbar = findViewById(R.id.customToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Unit Converter");

        EditText value = findViewById(R.id.value);
        value.setText("0.0");


        Button btn = findViewById(R.id.convert);



        units = findViewById(R.id.units);
        units.setOnItemSelectedListener(this);

        inch = findViewById(R.id.inch);
        ft = findViewById(R.id.ft);
        yd = findViewById(R.id.yd);
        m = findViewById(R.id.m);
        dm = findViewById(R.id.dm);
        cm = findViewById(R.id.cm);
        mm = findViewById(R.id.mm);
        μm = findViewById(R.id.μm);
        km = findViewById(R.id.km);
        mile = findViewById(R.id.mile);



        String unitsArr[] = {"inch","ft","yd","m","dm","cm","mm","μm","km","mile"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, unitsArr);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        units.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                String selectedItem = units.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(),String.valueOf(valueToBeConverted),Toast.LENGTH_SHORT).show();
                toStringValue = value.getText().toString();
                try{
                    valueToBeConverted = Double.parseDouble(toStringValue);
                } catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Enter valid number", Toast.LENGTH_SHORT).show();
                }
                displayConversions(selectedItem,valueToBeConverted);
            }
        });
    }

    private void displayConversions(String selectedUnit, double valueToBeConverted) {

        if (selectedUnit.equals("inch")) {
            inch.setText(String.valueOf(valueToBeConverted * 1) + " in");
            ft.setText(String.valueOf(valueToBeConverted * 0.08333333) + " ft");
            yd.setText(String.valueOf(valueToBeConverted * 0.0277778) + " yd");
            m.setText(String.valueOf(valueToBeConverted * 0.0254) + " m");
            dm.setText(String.valueOf(valueToBeConverted * 0.254) + " dm");
            cm.setText(String.valueOf(valueToBeConverted * 2.54) + " cm");
            mm.setText(String.valueOf(valueToBeConverted * 25.4) + " mm");
            μm.setText(String.valueOf(valueToBeConverted * 25400) + " μm");
            km.setText(String.valueOf(valueToBeConverted * 0.000000000000254) + " km");
            mile.setText(String.valueOf(valueToBeConverted * 0.00000000000015783) + " mile");
        } else if (selectedUnit.equals("ft")) {
            inch.setText(String.valueOf(valueToBeConverted * 12) + " in");
            ft.setText(String.valueOf(String.valueOf(valueToBeConverted * 1) + " ft"));
            yd.setText(String.valueOf(valueToBeConverted * 0.333333) + " yd");
            m.setText(String.valueOf(valueToBeConverted * 0.3048) + " m");
            dm.setText(String.valueOf(valueToBeConverted * 3.048) + " dm");
            cm.setText(String.valueOf(valueToBeConverted * 30.48) + " cm");
            mm.setText(String.valueOf(valueToBeConverted * 304.8) + " mm");
            μm.setText(String.valueOf(valueToBeConverted * 304800) + " μm");
            km.setText(String.valueOf(valueToBeConverted * 0.0003048) + " km");
            mile.setText(String.valueOf(valueToBeConverted * 0.000189394) + " mile");
        } else if (selectedUnit.equals("yd")) {
            inch.setText(String.valueOf(valueToBeConverted * 36) + "in");
            ft.setText(String.valueOf(valueToBeConverted * 3) + " ft");
            yd.setText(String.valueOf(valueToBeConverted * 1) + " yd");
            m.setText(String.valueOf(valueToBeConverted * 0.9144) + " m");
            dm.setText(String.valueOf(valueToBeConverted * 9.144) + " dm");
            cm.setText(String.valueOf(valueToBeConverted * 91.44) + " cm");
            mm.setText(String.valueOf(valueToBeConverted * 914.4) + " mm");
            μm.setText(String.valueOf(valueToBeConverted * 914400) + " μm");
            km.setText(String.valueOf(valueToBeConverted * 0.00094144) + " km");
            mile.setText(String.valueOf(valueToBeConverted * 0.0000568182) + " mile");
        } else if (selectedUnit.equals("m")) {
            inch.setText(String.valueOf(valueToBeConverted * 39.3701) + " in");
            ft.setText(String.valueOf(valueToBeConverted * 3.28084) + " ft");
            yd.setText(String.valueOf(valueToBeConverted * 1.09361) + " yd");
            m.setText(String.valueOf(valueToBeConverted * 1) + " m");
            dm.setText(String.valueOf(valueToBeConverted * 10) + " dm");
            cm.setText(String.valueOf(valueToBeConverted * 100) + " cm");
            mm.setText(String.valueOf(valueToBeConverted * 1000) + " mm");
            μm.setText(String.valueOf(valueToBeConverted * 1000000) + " μm");
            km.setText(String.valueOf(valueToBeConverted * 0.001) + " km");
            mile.setText(String.valueOf(valueToBeConverted * 0.000621371) + " mile");
        } else if (selectedUnit.equals("dm")) {
            inch.setText(String.valueOf(valueToBeConverted * 3.93701) + " in");
            ft.setText(String.valueOf(valueToBeConverted * 0.328084) + " ft");
            yd.setText(String.valueOf(valueToBeConverted * 0.109361) + " yd");
            m.setText(String.valueOf(valueToBeConverted * 0.1) + " m");
            dm.setText(String.valueOf(valueToBeConverted * 1) + " dm");
            cm.setText(String.valueOf(valueToBeConverted * 10) + " cm");
            mm.setText(String.valueOf(valueToBeConverted * 100) + " mm");
            μm.setText(String.valueOf(valueToBeConverted * 100000) + " μm");
            km.setText(String.valueOf(valueToBeConverted * 0.00001) + " km");
            mile.setText(String.valueOf(valueToBeConverted * 0.0000062137) + " mile");
        } else if (selectedUnit.equals("cm")) {
            inch.setText(String.valueOf(valueToBeConverted * 0.393701) + " in");
            ft.setText(String.valueOf(valueToBeConverted * 0.0328084) + " ft");
            yd.setText(String.valueOf(valueToBeConverted * 0.0109361) + " yd");
            m.setText(String.valueOf(valueToBeConverted * 0.01) + " m");
            dm.setText(String.valueOf(valueToBeConverted * 0.1) + " dm");
            cm.setText(String.valueOf(valueToBeConverted * 1) + " cm");
            mm.setText(String.valueOf(valueToBeConverted * 10) + " mm");
            μm.setText(String.valueOf(valueToBeConverted * 10000) + " μm");
            km.setText(String.valueOf(valueToBeConverted * 0.000001) + " km");
            mile.setText(String.valueOf(valueToBeConverted * 0.00000062137) + " mile");
        } else if (selectedUnit.equals("mm")) {
            inch.setText(String.valueOf(valueToBeConverted * 0.393701) + " in");
            ft.setText(String.valueOf(valueToBeConverted * 0.00328184) + " ft");
            yd.setText(String.valueOf(valueToBeConverted * 0.00109361) + " yd");
            m.setText(String.valueOf(valueToBeConverted * 0.001) + " m");
            dm.setText(String.valueOf(valueToBeConverted * 0.01) + " dm");
            cm.setText(String.valueOf(valueToBeConverted * 0.1) + " cm");
            mm.setText(String.valueOf(valueToBeConverted * 1) + " mm");
            μm.setText(String.valueOf(valueToBeConverted * 1000) + " μm");
            km.setText(String.valueOf(valueToBeConverted * 0.0000001) + " km");
            mile.setText(String.valueOf(valueToBeConverted * 0.000000062137) + " mile");
        }
        else if(selectedUnit.equals("μm")) {
        inch.setText(String.valueOf(valueToBeConverted * 0.000003937) + " in");
        ft.setText(String.valueOf(valueToBeConverted * 0.00000032808) + " ft");
        yd.setText(String.valueOf(valueToBeConverted * 0.00000010936) + " yd");
        m.setText(String.valueOf(valueToBeConverted * 0.0000001) + " m");
        dm.setText(String.valueOf(valueToBeConverted * 0.000001) + " dm");
        cm.setText(String.valueOf(valueToBeConverted * 0.00001) + " cm");
        mm.setText(String.valueOf(valueToBeConverted * 0.001) + " mm");
        μm.setText(String.valueOf(valueToBeConverted * 1) + " μm");
        km.setText(String.valueOf(valueToBeConverted * 0.0000000001) + " km");
        mile.setText(String.valueOf(valueToBeConverted * 0.000000000062137) + " mile");
    }
            else if(selectedUnit.equals("km")) {
            inch.setText(String.valueOf(valueToBeConverted * 39370.1) + "1 in");
            ft.setText(String.valueOf(valueToBeConverted * 3280.84) + " ft");
            yd.setText(String.valueOf(valueToBeConverted * 1093.61) + " yd");
            m.setText(String.valueOf(valueToBeConverted * 1000) + " m");
            dm.setText(String.valueOf(valueToBeConverted * 10000) + " dm");
            cm.setText(String.valueOf(valueToBeConverted * 100000) + " cm");
            mm.setText(String.valueOf(valueToBeConverted * 1000000) + " mm");
            μm.setText(String.valueOf(valueToBeConverted * 1000000000) + " μm");
            km.setText(String.valueOf(valueToBeConverted * 1) + " km");
            mile.setText(String.valueOf(valueToBeConverted * 0.621371) + " mile");
        }
        else if(selectedUnit.equals("mile")) {
            inch.setText(String.valueOf(valueToBeConverted * 63360) + "1 in");
            ft.setText(String.valueOf(valueToBeConverted * 5280) + " ft");
            yd.setText(String.valueOf(valueToBeConverted * 1760) + " yd");
            m.setText(String.valueOf(valueToBeConverted * 1609.34) + " m");
            dm.setText(String.valueOf(valueToBeConverted * 16093.4) + " dm");
            cm.setText(String.valueOf(valueToBeConverted * 160934) + " cm");
            mm.setText(String.valueOf(valueToBeConverted * 1.609000000) + " mm");
            μm.setText(String.valueOf(valueToBeConverted * 1.609000000000) + " μm");
            km.setText(String.valueOf(valueToBeConverted * 1.60934) + " km");
            mile.setText(String.valueOf(valueToBeConverted * 1) + " mile");
        }
        else{
            Toast.makeText(getApplicationContext(), "Select the unit of given value", Toast.LENGTH_SHORT).show();
        }
    }
}
