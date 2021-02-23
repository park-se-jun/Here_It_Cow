package org.techtown.example2;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import androidx.viewpager.widget.ViewPager;

public class FragRain extends Fragment {
    private View view;
    public static FragRain newInstance(){
        FragRain fragRain = new FragRain();
        return fragRain;
    }
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.frag_rain,container,false);
        return view;
    }
}
