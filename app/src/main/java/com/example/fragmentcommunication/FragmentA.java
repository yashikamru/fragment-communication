package com.example.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {
    private MyFragmentAListener listener;
    private EditText e;
    private Button b;

    public interface MyFragmentAListener {
        void onInputASent(CharSequence c);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container,false);
        e = v.findViewById(R.id.edittext1);
        b = v.findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = e.getText();
                listener.onInputASent(input);
            }
        });

        return v;
    }

    public  void updateEditTextofFragmentA(CharSequence newdata){
        e.setText(newdata);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof MyFragmentAListener){
            listener = (MyFragmentAListener) context;
        }else{
            throw new RuntimeException(context.toString()+"Your activity should implement the interface of FragmentA");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
