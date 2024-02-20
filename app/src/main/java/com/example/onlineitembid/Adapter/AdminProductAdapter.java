package com.example.onlineitembid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.onlineitembid.Model.ProductModel;
import com.example.onlineitembid.R;
import com.example.onlineitembid.RegistrationActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdminProductAdapter extends RecyclerView.Adapter<AdminProductAdapter.ViewHolder> {

    private Context context;
    private List<ProductModel> adminItemList;

    public AdminProductAdapter(Context context, List<ProductModel> adminItemList) {
        this.context = context;
        this.adminItemList = adminItemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_admin_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductModel product = adminItemList.get(position);

        holder.tvProductName.setText(product.getFoodName());
        holder.tvProductDescription.setText(product.getFoodDesc());
        holder.tvProductPrice.setText("Price: $" + product.getFoodPrice());
        holder.tvUsername.setText("Username: " + product.getUsername());
        holder.tvPhoneNumber.setText("Contact: " + product.getPhoneNumber());

        // Load product image using Glide (replace 'R.id.ivProductImage' with your actual resource ID)
        Glide.with(context)
                .load(product.getFoodImage())
                .into(holder.ivProductImage);

        holder.btnApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update the isApproved field to true in the database
                updateIsApprovedStatus(product.getRestaurantKey(), product.getFoodKey());
            }
        });

        holder.btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle reject button click
            }
        });

    }

    @Override
    public int getItemCount() {
        return adminItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvProductName;
        TextView tvProductDescription;
        TextView tvProductPrice;
        TextView tvUsername;
        TextView tvPhoneNumber;
        ImageView ivProductImage;
        Button btnApprove;
        Button btnReject;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductDescription = itemView.findViewById(R.id.tvProductDescription);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            ivProductImage = itemView.findViewById(R.id.ivProductImage);
            btnApprove = itemView.findViewById(R.id.btnApprove);
            btnReject = itemView.findViewById(R.id.btnReject);
        }
    }

    private void updateIsApprovedStatus(String restaurantKey, String foodKey) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference()
                .child(RegistrationActivity.RESTAURANT_FOOD)
                .child(restaurantKey)
                .child(foodKey);

        // Update the isApproved field to true
        reference.child("isApproved").setValue(true)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Update successful
                        Toast.makeText(context, "Item approved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Update failed
                        Toast.makeText(context, "Approval failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
