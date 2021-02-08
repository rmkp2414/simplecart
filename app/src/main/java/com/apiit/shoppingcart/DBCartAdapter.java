package com.apiit.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apiit.shoppingcart.CartItem;
import com.apiit.shoppingcart.R;

import java.util.List;

public class DBCartAdapter extends RecyclerView.Adapter<DBCartAdapter.ViewHolder> {

    private List<CartItem> cartItemModelsList;
    String receivingItemName,receivingItemImage,receivingItemPrice,receivingItemQty,receivingItemSize;
    Context context;
    public DBCartAdapter( Context context,List<CartItem> cartItemModelsList) {
        this.cartItemModelsList = cartItemModelsList;
        this.context = context;
    }

    @NonNull
    @Override
    public DBCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cartlist,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DBCartAdapter.ViewHolder holder, int position) {
        String itemName, itemSize, itemPrice, itemQty;

        receivingItemName         = cartItemModelsList.get(position).getProductName();
//        receivingItemImage  =       cartItemModelsList.get(position).getProductImage();
        receivingItemImage        = "https://i.pinimg.com/564x/ea/f4/5f/eaf45f252f7e3e70971605ee3d8cea91.jpg";
        receivingItemPrice        = String.valueOf(cartItemModelsList.get(position).getSoldPrice());// .getProductPrice();
        receivingItemSize       = cartItemModelsList.get(position).getSize();
        receivingItemQty    = String.valueOf(cartItemModelsList.get(position).getQuantity());
//       receivingItemImage        = modelList.get(position).getImages()[0];


        holder.itemName.setText(receivingItemName);
        holder.itemSize.setText(receivingItemSize);
        holder.itemQty.setText(receivingItemQty);
        holder.itemPrice.setText(receivingItemPrice);
        //Picasso.with(context).load(receivingItemImage).into(holder.imageView);
//do we need to show an image here

    }

    @Override
    public int getItemCount() {
        return cartItemModelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView itemName, itemSize, itemPrice, itemQty;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.itemNameInCart);
            itemPrice = itemView.findViewById(R.id.priceInCart);
            itemQty = itemView.findViewById(R.id.qtyInCart);
            itemSize = itemView.findViewById(R.id.sizeInCart);
        }

    }
}
