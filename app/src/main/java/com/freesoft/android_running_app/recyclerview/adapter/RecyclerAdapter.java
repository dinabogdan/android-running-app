package com.freesoft.android_running_app.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freesoft.android_running_app.R;
import com.freesoft.android_running_app.beans.Route;

import java.util.List;

/**
 * Created by c026dinab on 3/9/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Route> routes;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRouteName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvRouteName = itemView.findViewById(R.id.tv_routeName);
        }
    }

}
