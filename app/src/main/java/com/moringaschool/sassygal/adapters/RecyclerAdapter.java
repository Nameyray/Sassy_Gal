package com.moringaschool.sassygal.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moringaschool.sassygal.R;
import com.moringaschool.sassygal.models.ProductColor;
import com.moringaschool.sassygal.models.Response;
import com.moringaschool.sassygal.ui.MakeupDetailActivity;
import com.moringaschool.sassygal.ui.ViewProducts;

import org.parceler.Parcels;

import java.nio.charset.StandardCharsets;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {

    private Context context;
    private List<Response> list;

    //constructor for the list and context
    public RecyclerAdapter(Context context, List<Response> list) {
        this.context = context;
        this.list = list;
    }


    //implement methods for the adapter class
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.product_strip, parent, false);
        MyHolder myHolder= new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).asBitmap()
                .placeholder(R.drawable.img_1)
                .load(list.get(position)
                        .getImageLink())
                .into(holder.img);
        holder.title.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDescription());



        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewProducts.class);
                intent.putExtra("Product",list.get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
//creating the inner class with its constructor//
    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.img)
        ImageView img;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        int itemPosition = getLayoutPosition();
        Intent intent = new Intent(context, MakeupDetailActivity.class);
        intent.putExtra("position", itemPosition);
        intent.putExtra("makeups", Parcels.wrap(list));
        context.startActivity(intent);

    }
}
}
