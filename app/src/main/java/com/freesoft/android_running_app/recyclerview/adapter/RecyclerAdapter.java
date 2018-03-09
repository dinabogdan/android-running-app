package com.freesoft.android_running_app.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freesoft.android_running_app.R;
import com.freesoft.android_running_app.beans.Route;

import java.util.List;

import lombok.AllArgsConstructor;

/**
 * Created by c026dinab on 3/9/2018.
 */

@AllArgsConstructor
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Route> routes;

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.route_recyclerview_row, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.tvRouteName.setText(routes.get(position).getRouteName());
    }

    @Override
    public int getItemCount() {
        return (routes != null ? routes.size() : 0);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRouteName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvRouteName = itemView.findViewById(R.id.tv_routeName);
        }
    }

}
