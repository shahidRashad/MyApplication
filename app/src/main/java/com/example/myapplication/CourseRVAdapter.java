package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {

    private ArrayList<CourseModel> courseModelArrayList;
    private Context context;

    public CourseRVAdapter(ArrayList<CourseModel> courseModelArrayList, Context context) {
        this.courseModelArrayList = courseModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_view_activity,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseModel model = courseModelArrayList.get(position);
        holder.NameCourse.setText(model.getCourseName());
        holder.DurCourse.setText(model.getCourseDeuration());
        holder.TrackCourse.setText(model.getCourseTrack());
        holder.DescCourse.setText(model.getCourseDescription());

    }

    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView NameCourse, DurCourse, TrackCourse, DescCourse;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            NameCourse = (TextView) itemView.findViewById(R.id.tvnameCOurse);
            DurCourse = (TextView) itemView.findViewById(R.id.tvdueCourse);
            TrackCourse = (TextView) itemView.findViewById(R.id.tvtrackCourse);
            DescCourse = (TextView) itemView.findViewById(R.id.tvdescCourse);
        }
    }
}
