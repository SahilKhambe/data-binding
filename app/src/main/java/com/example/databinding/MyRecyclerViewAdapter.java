package com.example.databinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.databinding.databinding.RowItemBinding;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> implements CustomClickListener {

    private List<DataModel> dataModelList;
    private Context context;

    public MyRecyclerViewAdapter(List<DataModel> dataModelList, Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {

        DataModel dataModel = dataModelList.get(position);
        holder.bind(dataModel);
        holder.rowItemBinding.setItemClickListener(this);

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    @Override
    public void cardClicked(DataModel f) {

        Toast.makeText(context, "You Clicked..." +f.androidNames, Toast.LENGTH_SHORT).show();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public RowItemBinding rowItemBinding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowItemBinding= DataBindingUtil.bind(itemView);
        }

        public void bind(Object obj){

            rowItemBinding.setVariable(BR.model, obj);
            rowItemBinding.executePendingBindings();

        }

    }
}
