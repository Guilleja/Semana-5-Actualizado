package com.proventaja.tiendit.petagram;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private static final String[] TAB_TITLES = new String[]{"INICIO", "PERFIL"};
    private final Context mContext;
    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
}

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;

        switch (position){
            case 1:
                f = PerfilFragment.newInstance();
                break;
            case 0:
                f = InicioFragment.newInstance();
                break;


        }

        return f;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:
                title="Inicio";
                break;
            case 1:
                title="PERFIL";
                break;
        }
        return title;
    }
    @Override
    public int getCount() {
        return 2;
    }
}
