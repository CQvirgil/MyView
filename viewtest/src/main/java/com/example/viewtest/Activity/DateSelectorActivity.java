package com.example.viewtest.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.viewtest.R;
import com.example.viewtest.UI.DateSelector.DateBean;
import com.example.viewtest.UI.DateSelector.DateSelectorAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateSelectorActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_pack);
        recyclerView = findViewById(R.id.act_date_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,5));
        List<DateBean> dateBeans = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int maximum = calendar.getMaximum(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        for (int i = 0; i < maximum; i++){
            int date = calendar.get(Calendar.DAY_OF_MONTH);
            DateBean dateBean = new DateBean();
            dateBean.setDate(date + i + "");
            dateBeans.add(dateBean);
        }
        DateSelectorAdapter adapter = new DateSelectorAdapter(dateBeans, this);
        recyclerView.setAdapter(adapter);
    }
}
