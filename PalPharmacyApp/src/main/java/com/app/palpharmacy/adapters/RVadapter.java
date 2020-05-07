package com.app.palpharmacy.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.palpharmacy.R;
import com.app.palpharmacy.activities.PharmacyDetailsActivity;
import com.app.palpharmacy.model.Pharmacy;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class RVadapter extends RecyclerView.Adapter<RVadapter.MyViewHolder> implements Filterable {
    TextView textView;

    RequestOptions option;
    private Context mContext;
    private List<Pharmacy> mData;
    private List<Pharmacy> mDatafiltered;
    String day;
    String opntime;
    String clsetime;


    public RVadapter(Context mContext, List<Pharmacy> mData) {

        this.mContext = mContext;
        this.mData = mData;
        this.mDatafiltered = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.details_row_item, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, PharmacyDetailsActivity.class);
                i.putExtra("anime_name", mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("phone_number", mData.get(viewHolder.getAdapterPosition()).getPhonenumer());
                i.putExtra("anime_description", mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("region_name", mData.get(viewHolder.getAdapterPosition()).getRegion());
                i.putExtra("anime_city", mData.get(viewHolder.getAdapterPosition()).getCity());
                i.putExtra("opening_time", mData.get(viewHolder.getAdapterPosition()).getOpening());
                i.putExtra("closing_time", mData.get(viewHolder.getAdapterPosition()).getClosing());
                i.putExtra("vacation", mData.get(viewHolder.getAdapterPosition()).getVacation());
                i.putExtra("longitude", mData.get(viewHolder.getAdapterPosition()).getLongitude());
                i.putExtra("latitude", mData.get(viewHolder.getAdapterPosition()).getLatitude());
                i.putExtra("anime_img", mData.get(viewHolder.getAdapterPosition()).getImage_url());

                i.putExtra("insurance", mData.get(viewHolder.getAdapterPosition()).getInsurance());

                mContext.startActivity(i);



            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.img_thumbnail.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));
        holder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));

        holder.tv_name.setText(mDatafiltered.get(position).getName());
        holder.tv_city.setText(mDatafiltered.get(position).getCity());
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, hh:mm");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm");
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("EEE");


        String dateTime = simpleDateFormat.format(Calendar.getInstance().getTime());
        String time = simpleDateFormat2.format(Calendar.getInstance().getTime());
        String today = simpleDateFormat3.format(Calendar.getInstance().getTime());
         String day = mData.get(holder.getAdapterPosition()).getVacation().substring(0,3);
          String opntime =  mData.get(holder.getAdapterPosition()).getOpening();
         String clsetime =  mData.get(holder.getAdapterPosition()).getClosing();

//        holder.tv_status.setText(dateTime);
//        holder.tv_status.setText(time);
      //  holder.tv_status.setText(opntime);

        if (today.toLowerCase().equals(day.toLowerCase()))
            holder.tv_status.setText("Close");
        else  {

            if (time.compareTo(opntime)>0 && time.compareTo(clsetime)<0)

            holder.tv_status.setText("Open");
            else
                holder.tv_status.setText("Close");}








        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);

    }


    @Override
    public int getItemCount() {
        return mDatafiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String Key = constraint.toString();
                if (Key.isEmpty()) {
                    mDatafiltered = mData;
                } else {
                    List<Pharmacy> lstfiltered = new ArrayList<>();
                    for (Pharmacy row : mData) {
                        if (row.getName().toLowerCase().contains(Key.toLowerCase())) {
                            lstfiltered.add(row);
                        } else {
                            if (row.getCity().toLowerCase().contains(Key.toLowerCase())) {
                                lstfiltered.add(row);
                            }
                        }

                    }

                    mDatafiltered = lstfiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mDatafiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                mDatafiltered = (List<Pharmacy>) results.values;
                notifyDataSetChanged();

            }
        };
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_region;
        TextView tv_opening;
        TextView tv_vacation;
        ImageView img_thumbnail;
        TextView tv_city;
        LinearLayout view_container;
        LinearLayout container;
        TextView tv_closing;
        TextView tv_Long;
        TextView tv_Lat;
        TextView tv_insurance;

        TextView tv_status;

        public MyViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.anime_name);
            tv_city = itemView.findViewById(R.id.city);
            tv_closing = itemView.findViewById(R.id.closing);
            tv_vacation = itemView.findViewById(R.id.vaction);
            tv_region = itemView.findViewById(R.id.region);
            tv_opening = itemView.findViewById(R.id.opening);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
            tv_status = itemView.findViewById(R.id.textView);
            tv_Long = itemView.findViewById(R.id.mapAPI);
            tv_Lat = itemView.findViewById(R.id.mapAPI);
            tv_insurance = itemView.findViewById(R.id.insurance);

        }
    }

}
