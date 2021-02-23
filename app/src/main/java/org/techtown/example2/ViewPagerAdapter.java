package org.techtown.example2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override 
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return FragRain.newInstance();
            case 1:
                return FragSnow.newInstance();
            case 2:
                return FragNight.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position)
        {
            case 0:
                return "빗길운전 안전수칙";
            case 1:
                return "눈길운전 안전수칙";
            case 2:
                return "야간운전 안전수칙";
            default:
                return null;
        }
    }
}
