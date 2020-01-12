package id.abu.sistemabsensipolindra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.abu.sistemabsensipolindra.R;
import id.abu.sistemabsensipolindra.models.Schedule;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    private List<Schedule> schedules;
    private Context context;

    public ScheduleAdapter(List<Schedule> schedules, Context context) {
        this.schedules = schedules;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_schedule, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Schedule schedule = schedules.get(position);
        holder.label_matkul.setText(schedule.getCourse());
        holder.label_kelas.setText(schedule.getClass_room());
        holder.label_start.setText(schedule.getStart_at());
        holder.label_end.setText(schedule.getEnd_at());
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView label_matkul;
        public TextView label_kelas;
        public TextView label_start;
        public TextView label_end;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            label_matkul = itemView.findViewById(R.id.label_matkul);
            label_kelas = itemView.findViewById(R.id.label_kelas);
            label_start = itemView.findViewById(R.id.label_start);
            label_end = itemView.findViewById(R.id.label_end);
        }
    }
}