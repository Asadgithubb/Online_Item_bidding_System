package com.example.onlineitembid.Admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineitembid.Adapter.AdminProductAdapter;
import com.example.onlineitembid.Model.ProductModel;
import com.example.onlineitembid.R;
import com.example.onlineitembid.RegistrationActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    private RecyclerView rvAdminItems;
    private AdminProductAdapter adminAdapter;
    private List<ProductModel> adminItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        rvAdminItems = findViewById(R.id.rv_adminItems);
        rvAdminItems.setLayoutManager(new LinearLayoutManager(this));
        adminItemList = new ArrayList<>();
        adminAdapter = new AdminProductAdapter(this, adminItemList);
        rvAdminItems.setAdapter(adminAdapter);

        // Fetch items from Firebase
        fetchAdminItems();
    }

    private void fetchAdminItems() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            String username = firebaseUser.getDisplayName(); // Assuming the username is stored in display name
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(RegistrationActivity.RESTAURANT_FOOD);
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    adminItemList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String restaurantKey = dataSnapshot.getKey();
                        for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                            String foodKey = itemSnapshot.getKey();
                            ProductModel product = itemSnapshot.getValue(ProductModel.class);
                            if (product != null) {
                                // Set the keys in the product model
                                product.setRestaurantKey(restaurantKey);
                                product.setFoodKey(foodKey);
                                adminItemList.add(product);
                            }
                        }
                    }
                    adminAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle error if needed
                }
            });
        }
    }


}
