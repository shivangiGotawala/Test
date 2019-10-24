package example.com.shivangigotawalatest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import example.com.shivangigotawalatest.Model.Education;
import example.com.shivangigotawalatest.R;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.MyHolder> {

    private Context context;
    private List<Education> educationListList;

    public EducationAdapter(Context context, List<Education> educationListList) {
        this.context = context;
        this.educationListList = educationListList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_info_ist_row, parent, false);

        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Education education = educationListList.get(position);
        holder.tvTitle.setText(education.getTitle());
        holder.tvEduStartDate.setText(education.getStartDate());
        holder.tvEduEndDate.setText(education.getEndDate());
        holder.ttvEduName.setText(education.getName());
        holder.tvEduCity.setText(education.getCity());
        holder.tvEduCountry.setText(education.getCountry());
        if (educationListList.size() - 1 > position) {
            holder.view.setVisibility(View.VISIBLE);
        } else {
            holder.view.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return educationListList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        LinearLayout llTitle, llStartDate, llEndDate, llName, llCity, llCoutry;
        TextView tvTitle, tvEduStartDate, tvEduEndDate, ttvEduName, tvEduCity, tvEduCountry;
        View view;

        public MyHolder(View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.view);
            llTitle = itemView.findViewById(R.id.ll_title);
            llStartDate = itemView.findViewById(R.id.ll_edu_start_dt);
            llEndDate = itemView.findViewById(R.id.ll_edu_end_date);
            llName = itemView.findViewById(R.id.ll_edu_name);
            llCity = itemView.findViewById(R.id.ll_edu_city);
            llCoutry = itemView.findViewById(R.id.ll_edu_country);
            tvTitle = itemView.findViewById(R.id.tv_edu_title);
            tvEduStartDate = itemView.findViewById(R.id.tv_edu_start_dt);
            tvEduEndDate = itemView.findViewById(R.id.tv_edu_end_dt);
            ttvEduName = itemView.findViewById(R.id.tv_edu_name);
            tvEduCity = itemView.findViewById(R.id.tv_edu_city);
            tvEduCountry = itemView.findViewById(R.id.tv_edu_country);
        }
    }
}

