package com.example.prodigy_ad_02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prodigy_ad_02.R;
import com.example.prodigy_ad_02.Task;
import com.example.prodigy_ad_02.TaskAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText taskInput;
    Button addButton;
    RecyclerView taskRecyclerView;
    ArrayList<Task> taskList;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskInput = findViewById(R.id.taskInput);
        addButton = findViewById(R.id.addButton);
        taskRecyclerView = findViewById(R.id.taskRecyclerView);

        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, taskList);

        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskRecyclerView.setAdapter(taskAdapter);

        addButton.setOnClickListener(v -> {
            String taskTitle = taskInput.getText().toString().trim();
            if (!taskTitle.isEmpty()) {
                taskList.add(new Task(taskTitle));
                taskAdapter.notifyItemInserted(taskList.size() - 1);
                taskInput.setText("");
            } else {
                Toast.makeText(MainActivity.this, "Enter a task", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
