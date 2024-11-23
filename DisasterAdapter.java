package com.example.concertticket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.concertticket.databinding.ItemDisasterBinding;

public class DisasterAdapter extends RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder> {
    private List<com.example.concertticket.Disaster> disasterList;
//    private OnClickDisaster onClickDisaster;

    public DisasterAdapter(List<com.example.concertticket.Disaster> list) {
        disasterList = list;
    }


    @NonNull
    @Override
    public ItemDisasterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDisasterBinding binding =
                ItemDisasterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemDisasterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ItemDisasterViewHolder holder, int position) {
        holder.bind(disasterList.get(position));
    }

    @Override
    public int getItemCount() {
        return disasterList.size(); }

    public class ItemDisasterViewHolder extends RecyclerView.ViewHolder{
        private ItemDisasterBinding binding;

        public ItemDisasterViewHolder(ItemDisasterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(com.example.concertticket.Disaster data){
            binding.txtDisasterName.setText(data.getDisasterName());
            binding.txtDisasterType.setText(data.getDisasterType());
        }
    }
}
