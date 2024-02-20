package com.example.onlineitembid.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.onlineitembid.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private List<FoodModel> foodList;
    private Context context;

    public FoodAdapter(List<FoodModel> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_admin_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodModel food = foodList.get(position);

        // Set data to views
        holder.tvProductName.setText(food.getFoodName());
        holder.tvProductDescription.setText(food.getFoodDesc());
        holder.tvProductPrice.setText(food.getFoodPrice());
        holder.tvUsername.setText(food.getUsername());
        holder.tvPhoneNumber.setText(food.getPhoneNumber());

        // Load image using Glide or Picasso (add the necessary dependencies)
        // Example using Glide:
        Glide.with(context).load(food.getFoodImage()).into(holder.ivProductImage);

        // Handle approve and reject buttons based on isApproved status
        holder.btnApprove.setVisibility(food.isApproved() ? View.GONE : View.VISIBLE);
        holder.btnReject.setVisibility(food.isApproved() ? View.GONE : View.VISIBLE);

        // Set click listeners for buttons if needed
        // Implement your logic for approve and reject actions
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivProductImage;
        TextView tvProductName, tvProductDescription, tvProductPrice, tvUsername, tvPhoneNumber;
        Button btnApprove, btnReject;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProductImage = itemView.findViewById(R.id.ivProductImage);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductDescription = itemView.findViewById(R.id.tvProductDescription);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            btnApprove = itemView.findViewById(R.id.btnApprove);
            btnReject = itemView.findViewById(R.id.btnReject);
        }
    }
}
