package edu.weber.cs.w01285331.cs3270a8;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import edu.weber.cs.w01285331.cs3270a8.db.AppDatabase;
import edu.weber.cs.w01285331.cs3270a8.db.Course;


public class CourseEditFragment extends DialogFragment {

    private View root;
    private TextInputEditText id, name, course, start, end;


    public CourseEditFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_CS3270A8_Dialog_Fullscreen);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireDialog().getWindow().setWindowAnimations(R.style.Theme_CS3270A8_DialogAnimation);

        Toolbar toolbar  = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        //can over load the toolbar title genius
        toolbar.setTitle(R.string.newcourstitle);
        toolbar.inflateMenu(R.menu.course_edit_frag_toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.save:
                        sendtoDatabase();
                        return true;
                    default: return false;
                }

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragment_course_edit, container, false);
    }


    @Override
    public void onResume() {
        super.onResume();
         id = root.findViewById(R.id.txtinput_id);
        name = root.findViewById(R.id.txtinput_Name);
        course = root.findViewById(R.id.txtinput_CourseCode);
        start = root.findViewById(R.id.txtinput_Start);
        end = root.findViewById(R.id.txtinput_End);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog =  super.onCreateDialog(savedInstanceState);
        dialog.getWindow().setWindowAnimations(R.style.Theme_CS3270A8_DialogAnimation);

        return dialog;
    }

    public void sendtoDatabase() {

        final String tid = id.getText().toString();
        final String tname = name.getText().toString();
        final String tcourse = course.getText().toString();
        final String tstart = start.getText().toString();
        final String tend = end.getText().toString();
        //clearing the fields
        id.setText("");
        name.setText("");
        course.setText("");
        start.setText("");
        end.setText("");



        new Thread(new Runnable() {
            @Override
            public void run() {
                //ran in the background async

                AppDatabase db = AppDatabase.getInstance(getContext());
                db.courseDOA().insertAll(new Course(tid, tname, tcourse, tstart, tend ));

                LiveData<List<Course>> course = db.courseDOA().getall();

                Log.d("New", "Courses:  " +course.toString());

            }
        }).start();// always remember to start to the thread




    }

}