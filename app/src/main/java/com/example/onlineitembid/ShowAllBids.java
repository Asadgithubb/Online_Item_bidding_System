package com.example.onlineitembid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.onlineitembid.Adapter.ShowAllBidProduct;
import com.example.onlineitembid.Model.ProductModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowAllBids extends AppCompatActivity {

    RecyclerView rv_showAllFood;
    String username = "";
    List<ProductModel> mList = new ArrayList<>();
    ShowAllBidProduct mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_bids);

        rv_showAllFood = findViewById(R.id.rv_showAllOrders);
        rv_showAllFood.setHasFixedSize(true);
        rv_showAllFood.setLayoutManager(new LinearLayoutManager(ShowAllBids.this));

        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        getAllOrders();
    }

    private void getAllOrders() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userId = firebaseUser != null ? firebaseUser.getUid() : null;

        if (userId != null) {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference()
                    .child(RegistrationActivity.RESTAURANT_FOOD)  // Update with the correct reference
                    .child(username);

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    mList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        ProductModel restaurantFood = dataSnapshot.getValue(ProductModel.class);
                        if (restaurantFood != null && restaurantFood.getId().equals(userId)) {
                            mList.add(restaurantFood);
                        }
                    }
                    mAdapter = new ShowAllBidProduct(ShowAllBids.this, mList, username);
                    rv_showAllFood.setAdapter(mAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle error
                }
            });
        }
    }
}
