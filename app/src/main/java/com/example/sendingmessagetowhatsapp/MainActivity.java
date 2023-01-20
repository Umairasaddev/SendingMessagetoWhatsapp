package com.example.sendingmessagetowhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendbutton = findViewById(R.id.sendbutton);
        final EditText mobileno = findViewById(R.id.mobileno);
        EditText message = findViewById(R.id.message);

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mobilenumber = mobileno.getText().toString();
                String Message = message.getText().toString();
                //now checking if whatsapp is installed or not
                try {
                    boolean installed = appInstalledOrNot("com.whatsapp");
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    //creating message if whatsapp is installed or not
    private boolean appInstalledOrNot(String url) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = getPackageManager();
        boolean appInstalledOrNot;
        try {
            packageManager.getPackageInfo(url, PackageManager.GET_ACTIVITIES);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

        }
    return true;
    }
}