package com.example.travelingproblemkomiwonazer;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.travelingproblemkomiwonazer.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    private Button StartButton;
    private Button SSButton;
    static String startMiast="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        Spinner dropdown = findViewById(R.id.spinnerMiasta);
        String[] items= new String[]{"Gdynia",
                "Gdansk",
                "Krakow",
                "Warszawa",
                "Łódz", 
                "Poznan", 
                "SuchyDwor",
                "Koleczkowo", 
                "Pierwoszyno,",
                "Kosakowo",
                "Puck",
                "Ruda",
                "MaloCyce",
                "Chojcnice",
                "Adowo",
                "Stulejowo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        StartButton = findViewById(R.id.ButtonStart);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wybraneMiasto=0;

                if(dropdown != null && dropdown.getSelectedItem() !=null ) {
                    startMiast = dropdown.getSelectedItem().toString();
                    Toast.makeText(MainActivity.this, startMiast, Toast.LENGTH_SHORT).show();
                        

                } else  {

                }

            }
        });
        SSButton = findViewById(R.id.ButtonSS);
        SSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        };




}