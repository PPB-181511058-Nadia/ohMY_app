package com.example.ohmy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
//import android.util.Log;
import android.view.View;
//import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
//Activity two = addTaskActivity
public class Activity2 extends AppCompatActivity {

    public static final String EXTRA_REPLYDESKRIPSI = "com.example.android.deskripsi.REPLY";
    public static final String EXTRA_REPLYDEADLINE = "com.example.android.deadline.REPLY";
    EditText addTasks;
    EditText addDueDate;
   // RecyclerViewAdapter adapter;
//    private List<Task> data;
//    private List<Task> olddata;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Bundle bundle = getIntent().getExtras();

        Toast.makeText(this, Integer.toString(bundle.getInt("taskNumber")), Toast.LENGTH_SHORT).show();

        addTasks = findViewById(R.id.addTasks);
        addDueDate = findViewById(R.id.addDueDate);

        btn = findViewById(R.id.addbutton2);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent();
                if (TextUtils.isEmpty(addTasks.getText())||TextUtils.isEmpty(addDueDate.getText())) {
                    setResult(RESULT_CANCELED, i);
                } else {
                    String name = addTasks.getText().toString();
                    String deadline = addDueDate.getText().toString();
                    i.putExtra(EXTRA_REPLYDESKRIPSI, name);
                    i.putExtra(EXTRA_REPLYDEADLINE, deadline);
                    setResult(RESULT_OK, i);
                }
                finish();
            }
        });

    }
//        public void onClick (View view) {
//                Intent i = new Intent();
//                Task newTask = new Task(addTasks.getText().toString(), addDueDate.getText().toString());
//                i.putExtra("newTask", newTask);
//
//                setResult(RESULT_OK, i);
//                finish();
//            }

            //            @Override
//            public void onClick(View v) {
//                String add_task = addTasks.getText().toString();
//                String add_dd = addDueDate.getText().toString();
//                data.add(1, new Task(add_task, add_dd, ""));
//                adapter.notifyDataSetChanged();
//            }

    //    });
}