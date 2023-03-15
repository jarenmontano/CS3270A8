package edu.weber.cs.w01285331.cs3270a8.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Course {

    @PrimaryKey(autoGenerate = true)
    private int _id;

    @ColumnInfo(name = "id")
    private String cid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "course_code")
    private String courseCode;

    @ColumnInfo(name = "start")
    private String startAt;

    @ColumnInfo(name = "end")
    private String endAt;

    //add constructor here

    @Ignore
    public Course(String cid, String name, String courseCode, String startAt, String endAt) {
        this.cid = cid;
        this.name = name;
        this.courseCode = courseCode;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public Course(int _id, String cid, String name, String courseCode, String startAt, String endAt) {
        this._id = _id;
        this.cid = cid;
        this.name = name;
        this.courseCode = courseCode;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    @Override
    public String toString() {
        return "Course{" +
                "_id=" + _id +
                ", cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", startAt='" + startAt + '\'' +
                ", endAt='" + endAt + '\'' +
                '}';
    }
}
