package edu.weber.cs.w01285331.cs3270a8;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.List;

import edu.weber.cs.w01285331.cs3270a8.databinding.ActivityMainBinding;
import edu.weber.cs.w01285331.cs3270a8.db.AppDatabase;
import edu.weber.cs.w01285331.cs3270a8.db.Course;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add a Course", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                FragmentManager fm = getSupportFragmentManager();
                CourseEditFragment c = new CourseEditFragment();
                c.show(fm, "Course");
            }
        });
        loaddb();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private void loaddb(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                //ran in the background async

                AppDatabase db = AppDatabase.getInstance(getApplicationContext());
                LiveData<List<Course>> course = db.courseDOA().getall();



            }
        }).start();// always remember to start to the thread

    }
}