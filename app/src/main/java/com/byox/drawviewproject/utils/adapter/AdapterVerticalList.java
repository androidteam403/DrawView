package com.byox.drawviewproject.utils.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byox.drawviewproject.R;
import com.byox.drawviewproject.databinding.AdapterVerticalListBinding;

import java.util.List;

public class AdapterVerticalList extends RecyclerView.Adapter<AdapterVerticalList.ViewHolder> {
    private Context context;
    private List<AdapterVericalListModel> adapterVericalListModelList;
    private AdapterCallback mListener;

    public AdapterVerticalList(Context context, List<AdapterVericalListModel> adapterVericalListModelList, AdapterCallback mListener) {
        this.context = context;
        this.adapterVericalListModelList = adapterVericalListModelList;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterVerticalListBinding adapterVerticalListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.adapter_vertical_list, parent, false);
        return new AdapterVerticalList.ViewHolder(adapterVerticalListBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AdapterVericalListModel adapterVericalListModel = adapterVericalListModelList.get(position);
        final int pos = position;
        holder.adapterVerticalListBinding.setVariable(1, adapterVericalListModel);
        holder.adapterVerticalListBinding.name.setTextColor(adapterVericalListModel.isSelected() ? context.getResources().getColor(R.color.blue) : context.getResources().getColor(R.color.black));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onVerticalListItemClick(pos);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return adapterVericalListModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AdapterVerticalListBinding adapterVerticalListBinding;

        public ViewHolder(AdapterVerticalListBinding adapterVerticalListBinding) {
            super(adapterVerticalListBinding.getRoot());
            this.adapterVerticalListBinding = adapterVerticalListBinding;
        }
    }

    public static class AdapterVericalListModel {
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
