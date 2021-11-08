package com.example.annab.birdtracking.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.annab.birdtracking.R;

public class MainMenu extends Activity
{

    public Button btnOverview;
    public Button btnMap;
    public Button btnAddRecords;
    public Button btnSettings;


    public void init()
    {

        btnOverview = (Button) findViewById(R.id.btnOverview);
        btnMap = (Button) findViewById(R.id.btnMap);
        btnAddRecords = (Button) findViewById(R.id.btnAddRecords);
        btnSettings = (Button) findViewById(R.id.btnSettings);

        btnOverview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent toy = new Intent(MainMenu.this, Overview.class);
                startActivity(toy);
            }

        });
        btnMap.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent toy = new Intent(MainMenu.this, MapActivity.class);
                startActivity(toy);
            }

        });
        btnAddRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent toy = new Intent(MainMenu.this, AddRecords.class);
                startActivity(toy);
            }

        });
        btnSettings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent toy = new Intent(MainMenu.this, Settings.class);
                startActivity(toy);
            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)// All activities need to implement the onCreate() method. Gets called when the activity objetc get created. its used to perform basic setuo such as layout.
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu); //locate the  view from activity_main_menu

        init();

    }

}
