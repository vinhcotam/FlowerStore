package com.example.flowerstore;

import android.content.*;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

public class flowerAdapter extends ArrayAdapter<flower> {
    private Context context;
    private int layout;
    private ArrayList<flower> flowerList;

    public flowerAdapter(Context context, int layout, List<flower> object) {
        super(context,layout,object);
        this.context = context;
        this.layout = layout;
        this.flowerList = flowerList;
    }


}
