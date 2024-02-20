package com.example.onlineitembid.Admin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.onlineitembid.Admin.AdminActivity;
import com.example.onlineitembid.R;
import com.example.onlineitembid.UserSignin;

public class Adminpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);

        CardView contributeCard = findViewById(R.id.contributeCard);
        CardView logoutCard = findViewById(R.id.logoutCard);

        contributeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for contributeCard
                navigateToAdminActivity();
            }
        });

        logoutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for logoutCard
                showLogoutDialog();
            }
        });
    }

    private void navigateToAdminActivity() {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
        // You can add additional logic here if needed
    }

    private void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout or Exit?")
                .setMessage("Are you sure you want to logout or exit?")
                .setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Perform logout actions if needed
                        navigateToSignInPage();
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Close the app
                        finishAffinity();
                    }
                })
                .show();
    }

    private void navigateToSignInPage() {
        // Navigate to the sign-in page
        // For example:
        Intent intent = new Intent(this, UserSignin.class);
        startActivity(intent);
        finishAffinity(); // Close all activities in the current task
    }
}