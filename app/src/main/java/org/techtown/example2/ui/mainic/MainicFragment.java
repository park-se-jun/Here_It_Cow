package org.techtown.example2.ui.mainic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.techtown.example2.R;
import org.techtown.example2.ViewPagerAdapter;

import org.techtown.example2.ui.home.HomeViewModel;

public class MainicFragment extends Fragment{
    private MainicViewModel mainicViewModel;
    private FragmentPagerAdapter fragmentPagerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mainicViewModel =
                new ViewModelProvider(this).get(MainicViewModel.class);
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        ViewPager viewPager = root.findViewById(R.id.vviewpager);
        fragmentPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        TabLayout tabLayout = root.findViewById(R.id.tabLayout2);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }

}
