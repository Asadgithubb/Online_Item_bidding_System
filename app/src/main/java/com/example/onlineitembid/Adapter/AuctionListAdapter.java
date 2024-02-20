package com.example.onlineitembid.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.onlineitembid.Model.ProductModel;
import com.example.onlineitembid.PlaceBidActivity;
import com.example.onlineitembid.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AuctionListAdapter extends RecyclerView.Adapter<AuctionListAdapter.ViewHolder> {

    private Context context;
    private List<ProductModel> productList;
    private String username;

    public AuctionListAdapter(Context context, List<ProductModel> productList, String username) {
        this.context = context;
        this.productList = productList;
        this.username = username;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_all_auction_products, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductModel model = productList.get(position);
        Glide.with(context).load(model.getFoodImage()).into(holder.cvFoodImage);
        holder.tvFoodName.setText(model.getFoodName());
        holder.tvFoodDesc.setText(model.getFoodDesc());
        holder.tvFoodPrice.setText("Price: $" + model.getFoodPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlaceBidActivity.class);
                intent.putExtra("foodImage", model.getFoodImage());
                intent.putExtra("foodName", model.getFoodName());
                intent.putExtra("foodDesc", model.getFoodDesc());
                intent.putExtra("foodPrice", model.getFoodPrice());
                intent.putExtra("phoneNumber", model.getPhoneNumber());
                intent.putExtra("username", model.getUsername());
                intent.putExtra("id", model.getId());
                intent.putExtra("ownName", username);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView cvFoodImage;
        private TextView tvFoodName;
        private TextView tvFoodDesc;
        private TextView tvFoodPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvFoodImage = itemView.findViewById(R.id.cv_foodImage);
            tvFoodName = itemView.findViewById(R.id.tv_foodName);
            tvFoodDesc = itemView.findViewById(R.id.tv_foodDesc);
            tvFoodPrice = itemView.findViewById(R.id.tv_foodPrice);

        }
    }
}
