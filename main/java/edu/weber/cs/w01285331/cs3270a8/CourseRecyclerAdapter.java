package edu.weber.cs.w01285331.cs3270a8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.weber.cs.w01285331.cs3270a8.db.Course;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.ViewHolder> {
    private List<Course> courseList;


    public CourseRecyclerAdapter(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setUserList(List<Course> list){
        courseList.clear();
        courseList.addAll(list);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_view,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = courseList.get(position);
        if(course != null){
            holder.course  = course;
            holder.tv1.setText(course.getName());
            holder.itemroot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // do something first video 46 minutes explains
                    //need to send probably the course id back so then it can be send to main
                    // fragment then to the view fragment to then either update or delete
                    //must set up an interface
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    //this manages the individual items and is connected to layout course_view.xml
    public class ViewHolder extends RecyclerView.ViewHolder{
        public View itemroot;
        public TextView tv1;
        public Course course;

        public ViewHolder (View view){
            super(view);

            itemroot = view;
            tv1 = itemroot.findViewById(R.id.tvLine1);

        }



    }
}
