package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 13/03/2021
 */
public class StringAdapter extends ArrayAdapter<String>{

    private int mResource;
    private int mTextViewResource;
    private LayoutInflater mLayoutInflater;
    private List<String> mItems = new ArrayList<String>();

    public StringAdapter(Context context, int resource, int textViewResource){
        super(context, resource, textViewResource);
        mResource = resource;
        mTextViewResource = textViewResource;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mItems.add("LUCAS");
        mItems.add("YAN");
        mItems.add("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null) {
            convertView = mLayoutInflater.inflate(mResource, null);
            viewHolder = new ViewHolder();
            viewHolder.itemTextview = (TextView) convertView.findViewById(mTextViewResource);   // basically findViewById is a very expensive call, as there are many android devices with minimal memory, what we did
            convertView.setTag(viewHolder);                                                     // here is that we have allowed convertView.findViewById cached to viewHolder, so its less laggy and provides a smoother experience.
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final String item = mItems.get(position);
        viewHolder.itemTextview.setText(item);

        return convertView;
    }

    static class ViewHolder{
        TextView itemTextview;
    }
}
