package com.example.travelingproblemkomiwonazer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

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
    static int NumerMiasta = 0;
    static int[][] two_dim_cost_matric = new int[1000][1000];
    static boolean[] visited_copy_array = new boolean[1000];//odwiedzony
    static int no_of_vertices=16,current_vertex=0,max = 999, min = 1,total_min_cost=0;
    public void JakieStartoweMiasto(String CO){
        switch (CO){
            case"Gdynia":
                NumerMiasta =0;
                break;
            case"Gdansk":
                NumerMiasta =1;
                break;
            case"Krakow":
                NumerMiasta =2;
                break;
            case"Warszawa":
                NumerMiasta =3;
                break;
            case"Lodz":
                NumerMiasta =4;
                break;
            case"Poznan":
                NumerMiasta =5;
                break;
            case"SuchyDwor":
                NumerMiasta =6;
                break;
            case"Koleczkowo":
                NumerMiasta =7;
                break;
            case"Pierwoszyno":
                NumerMiasta =8;
                break;
            case"Kosakowo":
                NumerMiasta =9;
                break;
            case"Puck":
                NumerMiasta =10;
                break;
            case"Ruda":
                NumerMiasta =11;
                break;
            case"MałoCyce":
                NumerMiasta =12;
                break;
            case"Chojnice":
                NumerMiasta =13;
                break;
            case"Adowo":
                NumerMiasta =14;
                break;
            case"Stulejowo":
                NumerMiasta =15;
                break;
        }



    }

    public static void inputs(){
        for (int i = 0;i<no_of_vertices; i++)
        {
            for(int j=0;j<no_of_vertices;j++)
            {
                if(i==j)// wynik tych samych miast
                {
                    two_dim_cost_matric[i][j]=0;
                }
                else
                {


                    //System.out.print(("Podaj kosz miedzy miastami: "+(FirstMiasto)+" --> "+(LastMiast)+": "));
                    two_dim_cost_matric[i][j]=(int)Math.floor(Math.random()*(max-min+1)+min);
                }
            }
        }
        System.out.print("\n");
        System.out.print("\n");
        for(int i=0;i<no_of_vertices;i++){
            for(int j=0;j<no_of_vertices;j++){
                System.out.print(two_dim_cost_matric[i][j]+"    ");

            }
            System.out.println();
        }


    }
    public  static  int next_visit(int c_vertex){
        int MIN = Integer.MAX_VALUE;
        int cost_spent =0, next_vertex = Integer.MAX_VALUE;
        for(int i=0;i<no_of_vertices;i++)
        {
            if(two_dim_cost_matric[c_vertex-1][i]!=0 &&!visited_copy_array[i])
            {
                if(two_dim_cost_matric[c_vertex][i]+two_dim_cost_matric[i][c_vertex]<MIN)
                {
                    MIN = two_dim_cost_matric[c_vertex-1][i]+two_dim_cost_matric[i][c_vertex-1];
                    cost_spent = two_dim_cost_matric[c_vertex-1][i];
                    next_vertex = i;
                }
            }
        }
        if(MIN != Integer.MAX_VALUE)
        {
            total_min_cost+=cost_spent;
        }
        return next_vertex+1;
    }
    public static void shortest_distance(int c_vertex){


        visited_copy_array[c_vertex-1]=true;
        System.out.print(startMiast+"--->");
        int nxt_visit = next_visit(c_vertex);
        if(nxt_visit==Integer.MAX_VALUE+1){
            System.out.print(current_vertex);
            total_min_cost+=two_dim_cost_matric[c_vertex-1][current_vertex-1];

            return;
        }
        shortest_distance(nxt_visit);
    }


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
                int wybraneMiasto = 0;

                if (dropdown != null && dropdown.getSelectedItem() != null) {
                    startMiast = dropdown.getSelectedItem().toString();
                    JakieStartoweMiasto(startMiast);
                    current_vertex = NumerMiasta;
                    inputs();
                    Log.d("creation","\nSciezka:");
                    //shortest_distance(current_vertex);//wywala program




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