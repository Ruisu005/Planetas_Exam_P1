package com.example.planetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class DetallePlanetas extends AppCompatActivity {

    private String planetNombre;
    private int planetImage;

    public String getPlanetNombre() {
        return planetNombre;
    }

    public void setPlanetNombre(String planetNombre) {
        this.planetNombre = planetNombre;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_planetas);

        SharedPreferences sharedPreferences = getSharedPreferences("PlanetData", MODE_PRIVATE);
        String planetName = sharedPreferences.getString("planetName", "");
        int planetImage = sharedPreferences.getInt("planetImage", 0);

        TextView textViewPlanetName = findViewById(R.id.textViewPlanetName);
        ImageView imageViewPlanet = findViewById(R.id.imageViewPlanet);
        TextView textViewInfo = findViewById(R.id.textViewPlanetInfo);

        textViewPlanetName.setText(planetName);
        imageViewPlanet.setImageResource(planetImage);

        Spinner spinnerOptions = findViewById(R.id.spinnerOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planet_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(adapter);

        spinnerOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedOption = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Opción seleccionada: " + selectedOption, Toast.LENGTH_SHORT).show();

                selectedOption = adapterView.getItemAtPosition(i).toString();
                String planetInfo = "";

                switch (selectedOption) {
                    case "Mercurio":
                        planetInfo = "Mercurio: Clima extremo con temperaturas que varían desde los -173°C hasta los 427°C.\n\n" +
                                "Superficie rocosa con numerosos cráteres de impacto.\n\n" +
                                "No se ha encontrado flora en Mercurio debido a su falta de atmósfera y condiciones extremas.\n\n" +
                                "No se ha encontrado fauna en Mercurio debido a su falta de atmósfera y condiciones extremas.";
                        break;
                    case "Venus":
                        planetInfo = "Venus: Clima extremadamente caliente con temperaturas constantes de alrededor de 462°C.\n\n" +
                                "Superficie rocosa con volcanes y extensas llanuras.\n\n" +
                                "No se ha encontrado flora en Venus debido a su atmósfera tóxica y condiciones inhóspitas.\n\n" +
                                "No se ha encontrado fauna en Venus debido a su atmósfera tóxica y condiciones inhóspitas.";
                        break;
                    case "Tierra":
                        planetInfo = "Tierra: Clima diverso, desde polos fríos hasta regiones ecuatoriales cálidas.\n\n" +
                                "Varios tipos de terrenos, incluyendo montañas, llanuras, océanos y cuerpos de agua.\n\n" +
                                "Amplia variedad de plantas que incluyen bosques, praderas, selvas y desiertos.\n\n" +
                                "Abundante vida animal, incluyendo mamíferos, aves, reptiles, anfibios y peces.";
                        break;
                    case "Marte":
                        planetInfo = "Marte: Clima frío con temperaturas que oscilan entre los -153°C y los 20°C.\n\n" +
                                "Superficie con montañas, valles, cañones y llanuras.\n\n" +
                                "No se ha encontrado flora en Marte debido a su atmósfera delgada y condiciones inhóspitas.\n\n" +
                                "No se ha encontrado fauna en Marte debido a su atmósfera delgada y condiciones inhóspitas.";
                        break;
                    case "Júpiter":
                        planetInfo = "Júpiter: No tiene una superficie sólida y su atmósfera está compuesta principalmente de hidrógeno y helio.\n\n" +
                                "Un planeta gigante gaseoso con una estructura en capas y una gran mancha roja.\n\n" +
                                "No se ha encontrado flora en Júpiter debido a su atmósfera gaseosa y condiciones extremas.\n\n" +
                                "No se ha encontrado fauna en Júpiter debido a su atmósfera gaseosa y condiciones extremas.";
                        break;
                    case "Saturno":
                        planetInfo = "Saturno: No tiene una superficie sólida y su atmósfera está compuesta principalmente de hidrógeno y helio.\n\n" +
                                "Conocido por sus anillos compuestos de partículas de hielo y rocas.\n\n" +
                                "No se ha encontrado flora en Saturno debido a su atmósfera gaseosa y condiciones extremas.\n\n" +
                                "No se ha encontrado fauna en Saturno debido a su atmósfera gaseosa y condiciones extremas.";
                        break;
                    case "Urano":
                        planetInfo = "Urano: Clima frío con una temperatura promedio de -195°C.\n\n" +
                                "Un planeta de hielo y gas con una atmósfera compuesta principalmente de hidrógeno y helio.\n\n" +
                                "No se ha encontrado flora en Urano debido a su atmósfera gaseosa y condiciones extremas.\n\n" +
                                "No se ha encontrado fauna en Urano debido a su atmósfera gaseosa y condiciones extremas.";
                        break;
                    case "Neptuno":
                        planetInfo = "Neptuno: Clima frío con vientos extremadamente rápidos y una temperatura promedio de -214°C.\n\n" +
                                "Un planeta de hielo y gas con una atmósfera compuesta principalmente de hidrógeno, helio y metano.\n\n" +
                                "No se ha encontrado flora en Neptuno debido a su atmósfera gaseosa y condiciones extremas.\n\n" +
                                "No se ha encontrado fauna en Neptuno debido a su atmósfera gaseosa y condiciones extremas.";
                        break;
                }

                textViewInfo.setText(planetInfo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        }
    }