package com.example.androidtermproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidtermproject.models.Employee;
import com.example.androidtermproject.models.IEmployee;

import java.util.List;

public class ListAdapter extends ArrayAdapter<IEmployee> {
    private List<IEmployee> EmployeesData;
    Context mContext;
    private static class ViewHolder {
        TextView eName;
        TextView eId;
        TextView eAge;
        TextView ePost;

    }

    public ListAdapter(@NonNull Context context, List<IEmployee> EmployeesData) {
        super(context, R.layout.listview_layout, EmployeesData);
        this.EmployeesData = EmployeesData;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Employee o = (Employee) getItem(position);
        ViewHolder viewHolder;
        final View result;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview_layout, parent, false);
            viewHolder.eId = (TextView) convertView.findViewById(R.id.ID);
            viewHolder.eName = (TextView) convertView.findViewById(R.id.Name);
            viewHolder.eAge=(TextView)convertView.findViewById(R.id.Age);
            viewHolder.ePost=(TextView)convertView.findViewById(R.id.Post);
            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        Log.i("Adapter", "getView: "+ o.toString());
        viewHolder.eName.setText("NAME : "+o.getName());
        viewHolder.eId.setText("ID  : " + o.getId());
        viewHolder.eAge.setText("AGE : "+o.getAge());
        viewHolder.ePost.setText("POST : "+o.getRole());
        // Return the completed view to render on scree
        return convertView;
    }
}
