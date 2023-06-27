package com.example.planetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String planetList[] = {"Mercurio", "Venus", "Tierra", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno"};
    int planetsImagen[] = {R.drawable.mercurio, R.drawable.venus, R.drawable.tierra, R.drawable.marte, R.drawable.jupiter, R.drawable.saturno, R.drawable.urano, R.drawable.neptuno};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), planetList, planetsImagen);
        listView.setAdapter(customBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedPlanet = planetList[i];
                int selectedPlanetImage = planetsImagen[i];
                Toast.makeText(getApplicationContext(), "Haz Seleccionado " + selectedPlanet, Toast.LENGTH_SHORT).show();

                SharedPreferences sharedPreferences = getSharedPreferences("PlanetData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("planetName", selectedPlanet);
                editor.putInt("planetImage", selectedPlanetImage);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, DetallePlanetas.class);
                startActivity(intent);
            }
        });

    }
}