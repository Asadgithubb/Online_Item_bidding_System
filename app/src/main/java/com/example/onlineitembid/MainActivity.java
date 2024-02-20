package com.example.onlineitembid;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.onlineitembid.payment.Payment;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView seller = findViewById(R.id.seller);
        TextView bidder = findViewById(R.id.bidder);
        TextView winnerlist = findViewById(R.id.winnerlist);
        TextView paymentclick = findViewById(R.id.paymentclick);
        TextView helpclick = findViewById(R.id.helpclick);
        TextView exit = findViewById(R.id.exit);

        // Get the username from the previous activity
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // Set click listeners for the TextViews
        winnerlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent winnerListIntent = new Intent(MainActivity.this, WinnerList.class);
                winnerListIntent.putExtra("username", username);
                startActivity(winnerListIntent);
            }
        });

        seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myProductsIntent = new Intent(MainActivity.this, MyProducts.class);
                myProductsIntent.putExtra("username", username);
                startActivity(myProductsIntent);
            }
        });

        bidder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent auctionListIntent = new Intent(MainActivity.this, AuctionList.class);
                auctionListIntent.putExtra("username", username);
                startActivity(auctionListIntent);
            }
        });

        paymentclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Payment.class);
                intent.putExtra("Name", username);
                startActivity(intent);
            }
        });

        helpclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = "asadnz1716@gmail.com";  // Replace with the actual email
                String userPhoneNumber = "+923057424800";   // Replace with the actual phone number
                String message = "Email:" + userEmail + "\nph_No: " + userPhoneNumber;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Admin Info")
                        .setMessage(message)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                builder.show();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApp();
            }
        });
    }
    private void exitApp() {
        // Creating a dialog with two options (Logout or Exit)
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you Sure tou want to")
                .setItems(new CharSequence[]{"Logout", "Exit"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                // Logout option selected
                                logout();
                                break;
                            case 1:
                                // Exit option selected
                                finishAffinity();
                                break;
                        }
                    }
                });
        builder.show();
    }
    private void logout() {
        Intent loginIntent = new Intent(this, UserSignin.class);
        startActivity(loginIntent);
    }
}
