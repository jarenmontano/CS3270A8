package edu.weber.cs.w01285331.cs3270a8;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.weber.cs.w01285331.cs3270a8.db.AppDatabase;
import edu.weber.cs.w01285331.cs3270a8.db.Course;

public class CourseViewModel extends ViewModel {
    private LiveData<List<Course>> courseList;

    public LiveData<List<Course>> getAllUsers(Context context){

        AppDatabase db = AppDatabase.getInstance(context);

        courseList = db.courseDOA().getall();

        return courseList;
    }

}
