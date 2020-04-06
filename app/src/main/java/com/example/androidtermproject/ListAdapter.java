package com.example.androidtermproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidtermproject.business.MemDataStoreSingleton;

import java.util.List;
import java.util.jar.Attributes;

public class ListAdapter extends ArrayAdapter {
    private List<MemDataStoreSingleton> EmployeesData;
    private final LayoutInflater layoutInflater;
    private final int layoutResource;


    public ListAdapter(@NonNull Context context, int resource, List<MemDataStoreSingleton> EmployeesData) {
        super(context, resource);
        this.EmployeesData = EmployeesData;
        this.layoutInflater = LayoutInflater.from(context);
        this.layoutResource = resource;
    }

    @Override
    public int getCount() {
        return EmployeesData.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null)
            v = layoutInflater.inflate(layoutResource, parent, false);
        EditText EName=v.findViewById(R.id.Name);
        EditText EId=v.findViewById(R.id.ID);
        //String Name=EmployeesData.get().getEmployees();
        //String ID =
        EName.setText(Name);
        EId.setText(ID);


        return v;
    }
}
