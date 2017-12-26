package com.example.lyq.fragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class FragmentPage3 extends Fragment{

	private View view;
    private ScrollView scrollView;

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView text = (TextView) view.findViewById(R.id.textView);
        text.setText(getResources().getString(R.string.content));
        scrollView = (ScrollView) view.findViewById(R.id.id_scrollView);
        return view;
	}

}