package com.apiit.shoppingcart;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category_Model> categoryModelList;

    public CategoryAdapter(List<Category_Model> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_item,viewGroup,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder viewHolder, int position) {

        int icon = categoryModelList.get(position).getCategoryIconLink();
//        String name = categoryModelList.get(position).getCategoryname();
//        viewHolder.setCategory(name,position);
        viewHolder.setCategory(position);
        viewHolder.setCategoryIcon(icon);
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView categoryIcon;
        //private TextView categoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryIcon = itemView.findViewById(R.id.category_icon);
          //  categoryName = itemView.findViewById(R.id.category_name);
        }

        private void setCategoryIcon(int icon){
            categoryIcon.setImageResource(icon);
        }

//        private void setCategory(final String name, final int position){
            private void setCategory(final int position){
          //  categoryName.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                        Intent categoryIntent = new Intent(itemView.getContext(), MainActivity.class);
                        if(position==0){
                        categoryIntent.putExtra("category", "Home");
                        }
                        if(position==1){
                            categoryIntent.putExtra("category", "Gents");
                        }
                        if(position==2){
                            categoryIntent.putExtra("category", "Ladies");
                        }
                        if(position==3){
                            categoryIntent.putExtra("category", "Kids");
                        }
                        itemView.getContext().startActivity(categoryIntent);

                }
            });
        }
    }
}
