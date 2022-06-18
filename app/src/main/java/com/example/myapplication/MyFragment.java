package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    int index ;

    public MyFragment(int i) {
        index = i;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.image);
        if(index == 1){
            imageView.setBackgroundResource(R.drawable.one);
        } else if(index == 2){
            imageView.setBackgroundResource(R.drawable.two);
        } else if(index == 3){
            imageView.setBackgroundResource(R.drawable.threee);
        } else if(index == 4){
            imageView.setBackgroundResource(R.drawable.four);
        } else if(index == 5){
            imageView.setBackgroundResource(R.drawable.five);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.aimage, null);
    }
}
