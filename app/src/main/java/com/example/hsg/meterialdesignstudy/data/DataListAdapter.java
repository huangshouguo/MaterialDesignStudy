package com.example.hsg.meterialdesignstudy.data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hsg.meterialdesignstudy.R;

import java.util.List;

/**
 * Created by hsg on 18/07/2017.
 */

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.ViewHolder> {

    private List<DataBean> dataBeanList;

    public DataListAdapter() {
        this.dataBeanList = DataFactory.getData(10);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageDrawable(this.dataBeanList.get(position).drawable);
        holder.textView.setText(this.dataBeanList.get(position).text);
    }

    @Override
    public int getItemCount() {
        return this.dataBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image_view);
            this.textView = itemView.findViewById(R.id.text);
        }
    }
}
