package example.com.shivangigotawalatest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import example.com.shivangigotawalatest.R;


public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.MyHolder> {

    private Context context;
    private List<String> languageList;

    public LanguageAdapter(Context context, List<String> languageList) {
        this.context = context;
        this.languageList = languageList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lang_info_ist_row, parent, false);
        return new LanguageAdapter.MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        StringBuffer tech = new StringBuffer(10);
        tech.append(languageList.get(position));
        tech.append("\n");
        holder.tvLang.setText(tech.toString());
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvLang;
        public MyHolder(View itemView) {
            super(itemView);
            tvLang = itemView.findViewById(R.id.tv_lang);
        }
    }
}
