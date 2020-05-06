package com.app.palpharmacy.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.palpharmacy.R;

import java.util.List;

public class fragmentadapter extends RecyclerView.Adapter<fragmentadapter.MyViewHolder> {

    Context mcontext;
    List<pharm> mData;

    public fragmentadapter(Context mcontext, List<pharm> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mcontext).inflate(R.layout.layout, parent, false);
        MyViewHolder vholder = new MyViewHolder(v);
        return vholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_pharmname.setText(mData.get(position).getPharname());
        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_end.setText(mData.get(position).getEndtime());
        holder.image.setImageResource(mData.get(position).getImage());

    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_pharmname;
        private TextView tv_title;
        private TextView tv_end;
        private ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_pharmname = (TextView) itemView.findViewById(R.id.tvproname);
            tv_title = (TextView) itemView.findViewById(R.id.tvtitle);
            tv_end = (TextView) itemView.findViewById(R.id.tvtime);
            image = (ImageView) itemView.findViewById(R.id.imageview);

        }
    }

}
