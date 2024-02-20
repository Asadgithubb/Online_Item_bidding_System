package com.example.onlineitembid.payment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.PackageManager;

import com.example.onlineitembid.R;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Replace with the actual IDs of your JazzCash and EasyPaisa buttons
        Button btn_jazzCash = findViewById(R.id.jazzcash_button);
        ImageButton imageButtonJazzCash = findViewById(R.id.imageButton);
        Button btn_easyPaisa = findViewById(R.id.easypaisa_button);
        ImageButton imageButtonEasyPaisa = findViewById(R.id.imageButton2);

        btn_jazzCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJazzCash();
            }
        });

        imageButtonJazzCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJazzCash();
            }
        });

        btn_easyPaisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEasyPaisa();
            }
        });

        imageButtonEasyPaisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEasyPaisa();
            }
        });

        // Chat button click listener
        Button btn_chat = findViewById(R.id.chat);
        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMessagingApp();
            }
        });
    }

    private void openJazzCash() {
        // Package name of JazzCash app
        String packageName = "com.jazz.JazzCash - Your Mobile Account";

        // Check if JazzCash app is installed
        if (isAppInstalled(packageName)) {
            // Open JazzCash app
            Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        } else {
            // JazzCash app is not installed, open JazzCash website for further steps
            Uri jazzCashUri = Uri.parse("https://play.google.com/store/apps/details?id=com.techlogix.mobilinkcustomer&hl=en&gl=US");
            Intent intent = new Intent(Intent.ACTION_VIEW, jazzCashUri);
            startActivity(intent);
        }
    }

    private void openEasyPaisa() {
        // Package name of EasyPaisa app
        String packageName = "com.telenor.phoenix";

        // Check if EasyPaisa app is installed
        if (isAppInstalled(packageName)) {
            // Open EasyPaisa app
            Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        } else {
            // EasyPaisa app is not installed, open EasyPaisa website for further steps
            Uri easyPaisaUri = Uri.parse("https://play.google.com/store/apps/details?id=pk.com.telenor.phoenix&hl=en&gl=US");
            Intent intent = new Intent(Intent.ACTION_VIEW, easyPaisaUri);
            startActivity(intent);
        }
    }

    private void openMessagingApp() {
        // Create an intent to open the default messaging app
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:"));
        startActivity(intent);
    }

    private boolean isAppInstalled(String packageName) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
