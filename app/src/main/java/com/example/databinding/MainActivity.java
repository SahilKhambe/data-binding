package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.databinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<DataModel> dataModelList = new ArrayList<>();
        dataModelList.add(new DataModel("7", "Nougat"));
        dataModelList.add(new DataModel("8", "Oreo"));
        dataModelList.add(new DataModel("9", "Pie"));

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(dataModelList, this);
        binding.setMyAdapter(myRecyclerViewAdapter);


    }

}