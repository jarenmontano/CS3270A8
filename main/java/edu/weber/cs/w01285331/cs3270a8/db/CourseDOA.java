package edu.weber.cs.w01285331.cs3270a8.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDOA {
    // lists all of the objects
    @Query("Select * from course")
    LiveData<List<Course>> getall();

    //gets a specific course
    @Query("Select * from Course where _id =:id ")
    Course getUserByID(int id);

    //this will update a selected course/edit
    @Update
    void updateUsers(Course... courses);

    //add a new course
    @Insert
    void insertAll(Course... courses);

    //delet a selected course
    @Delete
    void deleteCourse(Course course);

}
