package es.uniovi.imovil.jcgranda.courses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by arias on 19/02/2016.
 */
public class CourseRecyclerViewAdapter extends RecyclerView.Adapter <CourseRecyclerViewAdapter.ViewHolder> {

    public LayoutInflater inflater = null;
    private final List<Course> courses;

    public final class ViewHolder extends RecyclerView.ViewHolder {

        TextView courseName;
        TextView teacherName;

        public ViewHolder(View itemView) {
            super(itemView);

            courseName= (TextView) itemView.findViewById(R.id.nameTextView);
            teacherName= (TextView) itemView.findViewById(R.id.teacherTextView);
        }
    }

    public CourseRecyclerViewAdapter(Context context, List<Course> courses) {

        if (context == null || courses == null ) {
            throw new IllegalArgumentException();
        }

        this.courses = courses;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = inflater.inflate(R.layout.list_item_course2, parent, false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.courseName.setText(courses.get(position).getName());
        holder.teacherName.setText(courses.get(position).getTeacher());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public void addCourse(Course course) {

        if (course == null) {
            throw new IllegalArgumentException();
        }

        courses.add(course);

        // Importante: notificar que ha cambiado el dataset
        notifyDataSetChanged();
    }
}
