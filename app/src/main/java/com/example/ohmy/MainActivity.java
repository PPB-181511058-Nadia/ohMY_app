package com.example.ohmy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvView;
    RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private TaskViewModel taskviewmodel;
    //    private List<Task> data;
    //  private ArrayList<Tasks> olddata;
//    private ArrayList<String> TaskName = new ArrayList<>();
//    private ArrayList<String> DueDate = new ArrayList<>();
//    private ArrayList<String> TaskInfo = new ArrayList<>();
    private Button btn, btn_refresh;
    private final int ADD_TASK_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn = findViewById(R.id.addbutton);
        rvView = findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);


        adapter = new RecyclerViewAdapter(this);
        rvView.setAdapter(adapter);


//        rvView.setLayoutManager(new LinearLayoutManager(this));
//        rvView.setAdapter(adapter);

        taskviewmodel = new ViewModelProvider(this).get(TaskViewModel.class);
        taskviewmodel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                adapter.setTasks(tasks);
            }
        });


//    btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Activity2.class);
//                startActivity(intent);
//            }
//        });
//        FloatingActionButton btn = findViewById(R.id.addbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent("com.example.ohmy.Activity2");
                Intent i = new Intent(MainActivity.this, Activity2.class);
//        Bundle bundle = new Bundle();
//
//        i.putExtra(bundle);
                startActivityForResult(i, ADD_TASK_REQUEST_CODE);
            }
        });

    }
//    public void onClick(View v) {
////        Intent i = new Intent("com.example.ohmy.Activity2");
//        Intent i = new Intent(MainActivity.this, Activity2.class);
////        Bundle bundle = new Bundle();
////
////        i.putExtra(bundle);
//        startActivityForResult(i, ADD_TASK_REQUEST_CODE);
//    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_TASK_REQUEST_CODE && resultCode == RESULT_OK) {
//            if (resultCode == RESULT_OK) {
//                Task newTask = (Task) data.getSerializableExtra("newTask");
//                taskviewmodel.insert(newTask);
//            }
//        }
            Task task = new Task(data.getStringExtra(Activity2.EXTRA_REPLYDESKRIPSI),data.getStringExtra(Activity2.EXTRA_REPLYDEADLINE));
            taskviewmodel.insert(task);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (int i = 0; i < taskviewmodel.getAllTasks().getValue().size(); i++) {
            Task t = taskviewmodel.getAllTasks().getValue().get(i);
            taskviewmodel.update(t);
        }
    }
}

        //btn_refresh = findViewById(R.id.button);

        //btn.setOnClickListener(this);

//        data = new List<>();
//        data.add(new Task("Proyek 4", "3 Maret", "Tugas Proyek 4 Kelompok B3; tugas front end homepage"));
//        data.add(new Task("PPL 1", "4 Maret", "Tugas PPL 1"));
//        data.add(new Task("APSI", "6 Maret", "Tugas APSI Praktek"));
//        data.add(new Task("Desain profil", "6 Maret", "Desain profil kabinet masa bakti 2020"));

//        olddata = new ArrayList<>();
//        olddata.addAll(data);

//        adapter = new RecyclerViewAdapter(data, this);
//        rvView.setLayoutManager(new LinearLayoutManager(this));
//        rvView.setAdapter(adapter);

//        Log.d(TAG, "onCreate: started.");
//        dataSet = new ArrayList<>();
//        initData();
//        prosesRecyclerViewAdapter();
////
//        rvView = (RecyclerView) findViewById(R.id.rv_main);
//        rvView.setHasFixedSize(true);
//
//        btn = (Button)findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Activity2.class);
//                startActivity(intent);
//            }
//        });
//
//        /**
//         * Kita menggunakan LinearLayoutManager untuk list standar
//         * yang hanya berisi daftar item
//         * disusun dari atas ke bawah
//         */
//        layoutManager = new LinearLayoutManager(this);
//        rvView.setLayoutManager(layoutManager);
//
//        adapter = new RecyclerViewAdapter(dataSet);
//        rvView.setAdapter(adapter);


//    private void prosesRecyclerViewAdapter(){
//        rvView = (RecyclerView) findViewById(R.id.rv_main);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(TaskName, DueDate, this);
//
//        rvView.setAdapter(adapter);
//        rvView.setLayoutManager(new LinearLayoutManager(this));
//    }
//
//    private void initData(){
//
//       TaskName.add("Proyek 4");
//       DueDate.add("3 Mar");
//       TaskInfo.add("Tugas Proyek 4 Kelompok B3; tugas front end homepage");
//
//       TaskName.add("Desain profil");
//       DueDate.add("5 Mar");
//
//       TaskName.add("PPL 1");
//       DueDate.add("6 Mar");
//
//       TaskName.add("APSI");
//       DueDate.add("9 Mar");
//
//       TaskName.add("Rakoor");
//       DueDate.add("13 Mar");
//
//       TaskName.add("Rapat himpunan");
//       DueDate.add("14 Mar");
//
//    }

//    @Override
//    public void onTaskClicked (Tasks tasks){
//
//    }

//    @Override
//    public void onClick (View v) {
//
//        switch (v.getId()) {
//            case R.id.addbutton:
//                data.add(1,new Tasks());
//                adapter.notifyItemInserted(1);
//
//        }
//
//    }
