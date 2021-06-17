package com.byox.drawviewproject.utils.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byox.drawviewproject.R;
import com.byox.drawviewproject.databinding.AdapterHorizontalListBinding;

import java.util.List;

public class AdapterHorizontalList extends RecyclerView.Adapter<AdapterHorizontalList.ViewHolder> {
    private Context context;
    private List<AdapterHorizontalList.AdapterHorizontalListModel> adapterHorizontalListModelList;
    private AdapterCallback mListener;

    public AdapterHorizontalList(Context context, List<AdapterHorizontalListModel> adapterHorizontalListModelList, AdapterCallback mListener) {
        this.context = context;
        this.adapterHorizontalListModelList = adapterHorizontalListModelList;
        this.mListener = mListener;
    }

    @Override
    public AdapterHorizontalList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterHorizontalListBinding adapterHorizontalListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.adapter_horizontal_list, parent, false);
        return new AdapterHorizontalList.ViewHolder(adapterHorizontalListBinding);
    }

    @Override
    public void onBindViewHolder(AdapterHorizontalList.ViewHolder holder, int position) {
        AdapterHorizontalListModel adapterHorizontalListModel = adapterHorizontalListModelList.get(position);
        final int pos = position;
        holder.adapterHorizontalListBinding.setVariable(1, adapterHorizontalListModel);
        holder.adapterHorizontalListBinding.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onHorizontalListItemClick(pos);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return adapterHorizontalListModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AdapterHorizontalListBinding adapterHorizontalListBinding;

        public ViewHolder(AdapterHorizontalListBinding adapterHorizontalListBinding) {
            super(adapterHorizontalListBinding.getRoot());
            this.adapterHorizontalListBinding = adapterHorizontalListBinding;
        }
    }

    public static class AdapterHorizontalListModel {
        private String name;
        private boolean isSelected;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }
    }
}
