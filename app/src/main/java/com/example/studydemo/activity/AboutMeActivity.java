package com.example.studydemo.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studydemo.R;
import com.example.studydemo.adapter.StudyTeamItemListAdapter;
import com.example.studydemo.domain.vo.StudyTeamItemBean;

import java.util.LinkedList;

public class AboutMeActivity extends AppCompatActivity {
    private ListView listView;
    private StudyTeamItemListAdapter adapter;
    private LinkedList<StudyTeamItemBean> items;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me);
        listView = findViewById(R.id.study_team_list);

        adapter = new StudyTeamItemListAdapter(this, items = new LinkedList<>());
        listView.setAdapter(adapter);

        for (int i = 0; i < 3; i++) {
            items.add(new StudyTeamItemBean("Huan", 999, "test"));
            items.add(new StudyTeamItemBean("Sun", 999, "test"));
            items.add(new StudyTeamItemBean("Joe", 999, "test"));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
