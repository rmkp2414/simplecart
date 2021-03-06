package com.apiit.shoppingcart;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.apiit.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    List<Product> modelList;
    Context context;

    Product selectingItem;
    String receivingItemName,receivingItemDescription,receivingItemImage,receivingItemCategory,receivingItemPrice;
    int productid;


    public OrderAdapter(Context context, List<Product> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        // here we will find the position and start setting the output on our views
       receivingItemName         = modelList.get(position).getName();
       receivingItemDescription  = modelList.get(position).getDescription();
       receivingItemPrice        = modelList.get(position).getPrice();
       receivingItemCategory     = modelList.get(position).getCategory();
       receivingItemImage           =         modelList.get(position).getImages()[0];

       productid                 = modelList.get(position).getId();

        holder.itemName.setText(receivingItemName);
        holder.itemDescription.setText(receivingItemDescription);
        holder.itemCategory.setText(receivingItemCategory);
        holder.itemPrice.setText(receivingItemPrice);
        Picasso.with(context).load(receivingItemImage).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
       return modelList.size();
    }

    // in order to make our views responsive we can implement onclicklistener on our recyclerview
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // here we will find the views on which we will inflate our data
        TextView itemName, itemDescription,itemCategory,itemPrice;
        ImageView imageView;
        int itemId;

        public ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemDescription = itemView.findViewById(R.id.itemDescription);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            itemCategory = itemView.findViewById(R.id.itemCategory);
            imageView = itemView.findViewById(R.id.itemImage);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // lets get the position of the view in list and then work on it
            int position = getAdapterPosition();

            Intent intent = new Intent(context, ItemDetails.class);

            intent.putExtra("productid",productid);
            intent.putExtra("itemName",modelList.get(position).getName());
            intent.putExtra("imgUri",modelList.get(position).getImages()[0]);
            intent.putExtra("itemPrice",modelList.get(position).getPrice());
            intent.putExtra("itemDesc",modelList.get(position).getDescription());
            intent.putExtra("itemCat",modelList.get(position).getCategory() );
            context.startActivity(intent);
        }
    }
}