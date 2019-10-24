package example.com.shivangigotawalatest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import example.com.shivangigotawalatest.Model.Work;
import example.com.shivangigotawalatest.R;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.MyHolder> {
    private Context context;
    private List<Work> workList;

    public WorkAdapter(Context context, List<Work> workList) {
        this.context = context;
        this.workList = workList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.work_info_ist_row, parent, false);
        return new WorkAdapter.MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Work work = workList.get(position);
        holder.tvposition.setText(work.getPosition());
        holder.tvWorkName.setText(work.getName());
        holder.tvWorkStartDate.setText(work.getStartDate());
        holder.tvWorkEndDate.setText(work.getEndDate());
        holder.tvWorkCity.setText(work.getCity());
        holder.tvWorkCountry.setText(work.getCountry());
        holder.tvWorkDesc.setText(work.getDescription());
        StringBuffer tech = new StringBuffer(10);
        for (int i = 0; i < work.getTechnologiesList().size(); i++) {
            tech.append(work.getTechnologiesList().get(i));
            tech.append("\n");
        }
        holder.tvWorkTech.setText(tech.toString());

        if (workList.size() - 1 > position) {
            holder.view.setVisibility(View.VISIBLE);
        } else {
            holder.view.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return workList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvposition, tvWorkName, tvWorkStartDate, tvWorkEndDate, tvWorkCity, tvWorkCountry, tvWorkDesc, tvWorkTech;
        View view;

        public MyHolder(View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.view);
            tvposition = itemView.findViewById(R.id.tv_work_position);
            tvWorkName = itemView.findViewById(R.id.tv_work_name);
            tvWorkStartDate = itemView.findViewById(R.id.tv_work_start_dt);
            tvWorkEndDate = itemView.findViewById(R.id.tv_work_end_dt);
            tvWorkCity = itemView.findViewById(R.id.tv_work_city);
            tvWorkCountry = itemView.findViewById(R.id.tv_work_country);
            tvWorkDesc = itemView.findViewById(R.id.tv_work_description);
            tvWorkTech = itemView.findViewById(R.id.tv_work_tech);
        }
    }
}
