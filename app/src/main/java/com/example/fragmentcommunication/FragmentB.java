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

public class FragmentB extends Fragment {
    private MyFragmentBListener listener;
    private EditText e;
    private Button b;

    public interface MyFragmentBListener {
        void onInputBSent(CharSequence c);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container,false);
        e = v.findViewById(R.id.edittext1);
        b = v.findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = e.getText();
                listener.onInputBSent(input);
            }
        });

        return v;
    }

    public  void updateEditTextofFragmentB(CharSequence newdata){
        e.setText(newdata);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof MyFragmentBListener){
            listener = (MyFragmentBListener) context;
        }else{
            throw new RuntimeException(context.toString()+"Your activity should implement the interface of FragmentB");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
