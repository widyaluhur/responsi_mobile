package com.example.covid.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.R;
import com.example.covid.model.kasus.ContentItem;

import java.util.List;

public class KasusAdapter extends RecyclerView.Adapter<KasusAdapter.ViewHolder>{

    List<ContentItem> item;

    public KasusAdapter(List<ContentItem> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_kasus, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KasusAdapter.ViewHolder holder, int position) {
        holder.bind(item.get(position));
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggal, tvSembuh, tvMeninggal, tvTerkonfirmasi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvSembuh = itemView.findViewById(R.id.tv_sembuh);
            tvMeninggal = itemView.findViewById(R.id.tv_meninggal);
            tvTerkonfirmasi = itemView.findViewById(R.id.tv_terkonfirmasi);
        }

        @SuppressLint("SetTextI18n")
        void bind(ContentItem item){
            tvTanggal.setText(item.getTanggal());
            tvSembuh.setText(item.getConfirmationSelesai() + " Kasus");
            tvMeninggal.setText(item.getConfirmationMeninggal() + " Kasus");
            tvTerkonfirmasi.setText(item.getConfirmationDiisolasi() + " Kasus");
        }
    }
}
