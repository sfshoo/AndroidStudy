package com.example.studydemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.studydemo.R;
import com.example.studydemo.domain.vo.StudyTeamItemBean;

import java.util.List;

public class StudyTeamItemListAdapter extends BaseAdapter {
    private Context context;
    private List<StudyTeamItemBean> studyTeamItems;

    public StudyTeamItemListAdapter(Context context, List<StudyTeamItemBean> studyTeamItems) {
        this.context = context;
        this.studyTeamItems = studyTeamItems;
    }

    @Override
    public int getCount() {
        if (null != studyTeamItems) {
            return studyTeamItems.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return studyTeamItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.study_team_item, null);
        TextView name = itemView.findViewById(R.id.name);
        TextView age = itemView.findViewById(R.id.age);
        TextView description = itemView.findViewById(R.id.description);

        StudyTeamItemBean item = studyTeamItems.get(position);
        name.setText(item.getName());
        age.setText(String.valueOf(item.getAge()));
        description.setText(item.getDescription());
        return itemView;
    }
}
