package com.example.uas_taufik_ti445;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.CardViewHolder> {
    private List<Even> evens;
    private Context context;

    public RvAdapter(Context context) {
        this.context = context;
    }

    public List<Even> getListEven() {
        return evens;
    }

    public void setListEven(List evens) {
        this.evens = evens;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_layout, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, final int position) {
        final String
                nama = getListEven().get(position).getNama(),
                email = getListEven().get(position).getEmail();

        final int id = getListEven().get(position).getId();

        holder.et_nama.setText(nama);
        holder.et_email.setText(email);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putInt("b_id", id);
                b.putString("b_nama", nama);
                b.putString("b_email", email);

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtras(b);

                //context.startActivity(intent);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ((Activity) context).startActivityForResult(intent, 1, b);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return evens.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView et_nama, et_email;

        public CardViewHolder(View view) {
            super(view);
            et_nama = (TextView) itemView.findViewById(R.id.tv_nama);
            et_email = (TextView) itemView.findViewById(R.id.tv_email);
        }
    }


}
