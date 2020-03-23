package com.example.ohmy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DetailTaskActivity extends AppCompatActivity {

    TextView tvTask, tvDate, tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);
        Log.d(TAG, "onCreate: started.");

        tvTask = findViewById(R.id.tv_task);
        tvDate = findViewById(R.id.tv_date);
        tvInfo = findViewById(R.id.tv_info);

        getIncomingExtra();

    }

    private void getIncomingExtra() {
        if((getIntent().hasExtra("nama_task") && getIntent().hasExtra("due_date_task")) && getIntent().hasExtra("info_task")){
            String namaTask = getIntent().getStringExtra("nama_task");
            String duedateTask = getIntent().getStringExtra("due_date_task");
            String infoTask = getIntent().getStringExtra("info_task");

            setDataActivity(namaTask, duedateTask, infoTask);
        }
    }

    private void setDataActivity(String namaTask, String duedateTask, String infoTask) {

        tvTask.setText(namaTask);
        tvDate.setText(duedateTask);
        tvInfo.setText(infoTask);
    }


}
