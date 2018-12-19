package com.vitaly_kuznetsov.onetwotriptestapplication.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vitaly_kuznetsov.onetwotriptestapplication.R;

import java.util.ArrayList;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        findViewById(R.id.text_view_go_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent();
            }
        });

        setRecyclerView();
    }

    private void intent(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void setRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view_choose);
        RecyclerViewAdapter adapter;
        recyclerView.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<ItemPreview> messagePreviewArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            messagePreviewArrayList.add(new ItemPreview());

        adapter = new RecyclerViewAdapter(messagePreviewArrayList, R.layout.view_holder_choose);
        recyclerView.setAdapter(adapter);
    }
}
