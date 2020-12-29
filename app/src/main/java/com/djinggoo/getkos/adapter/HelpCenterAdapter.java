package com.djinggoo.getkos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.djinggoo.getkos.R;
import com.djinggoo.getkos.data.HelpCenter;

import java.util.List;

public class HelpCenterAdapter extends RecyclerView.Adapter<HelpCenterAdapter.ViewHolder> {

    private List<HelpCenter> helpCenters;

    public HelpCenterAdapter(List<HelpCenter> helpCenters) {
        this.helpCenters = helpCenters;
    }

    @NonNull
    @Override
    public HelpCenterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.helpcenter_contents_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HelpCenterAdapter.ViewHolder holder, int position) {
        HelpCenter helpCenter = helpCenters.get(position);
        holder.title.setText(helpCenter.getTitle());
        holder.description.setText(helpCenter.getDescription());

        Boolean isExpendable = helpCenters.get(position).getExpandable();
        holder.cardViewSubContainer.setVisibility(isExpendable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return helpCenters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;

        LinearLayout cardViewContainer;
        RelativeLayout cardViewSubContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.helpcenter_title);
            description = itemView.findViewById(R.id.helpcenter_description);

            cardViewContainer = itemView.findViewById(R.id.cardview_container);
            cardViewSubContainer = itemView.findViewById(R.id.cardview_sub_container);

            cardViewContainer.setOnClickListener(view -> {
                HelpCenter helpCenter = helpCenters.get(getAdapterPosition());
                helpCenter.setExpandable(!helpCenter.getExpandable());
                notifyItemChanged(getAdapterPosition());
            });


        }
    }

}
