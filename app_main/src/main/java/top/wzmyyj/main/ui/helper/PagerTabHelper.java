package top.wzmyyj.main.ui.helper;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

import top.wzmyyj.main.R;
import top.wzmyyj.weight.pager.SlideViewPager;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

/**
 * Created on 2019/09/30.
 *
 * Helper that fast implementation of Pager-Tab structure.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class PagerTabHelper {

    private static final int MAX_SIZE = 6;

    private TabLayout mTabLayout;
    private SlideViewPager mViewPager;
    private final PagerTabManager manager = new PagerTabManager();

    public void add(@NonNull Fragment fragment, @NonNull String title, @NonNull Drawable image) {
        manager.add(fragment, title, image);
    }

    @NonNull
    public View getView(@NonNull LayoutInflater inflater,
                        @NonNull FragmentManager fragmentManager, @Nullable ViewGroup parent) {
        View v = inflater.inflate(R.layout.main_pager_wrapper, parent, false);
        mViewPager = v.findViewById(R.id.viewPager);
        mTabLayout = v.findViewById(R.id.tabLayout);
        if (manager.toList().size() == 0) {
            return v;
        }
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(
                fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

            @Override
            public int getCount() {
                return Math.min(manager.size(), MAX_SIZE);
            }

            @NonNull
            @Override
            public Fragment getItem(int p) {
                return manager.toList().get(p).fragment;
            }

        };
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        setTabStyle();
        int which = manager.firstWhich;
        if (which < manager.size()) {
            mViewPager.setCurrentItem(which, false);
        }
        return v;
    }

    @NonNull
    public PagerTabManager getManager() {
        return this.manager;
    }

    @Nullable
    public TabLayout getTabLayout() {
        return mTabLayout;
    }

    @Nullable
    public SlideViewPager getViewPager() {
        return mViewPager;
    }

    public void clear() {
        manager.clear();
        mTabLayout = null;
        mViewPager = null;
    }

    private void setTabStyle() {
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab == null) continue;
            setCustomView(tab);
            if (tab.isSelected()) {
                setTabSelected(tab);
            } else {
                setTabUnselected(tab);
            }
        }
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == null) return;
                setTabSelected(tab);
                mViewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab == null) return;
                setTabUnselected(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab == null) return;
                setTabReselected(tab);
            }
        });
    }

    protected final SparseArray<ImageView> imageArray = new SparseArray<>();
    protected final SparseArray<TextView> textArray = new SparseArray<>();

    protected void setCustomView(@NonNull TabLayout.Tab tab) {
        int p = tab.getPosition();
        View customView = tab.setCustomView(R.layout.main_tab_item).getCustomView();
        if (customView == null) return;
        TextView tv_tab = customView.findViewById(R.id.tv_tab);
        ImageView img_tab = customView.findViewById(R.id.img_tab);
        tv_tab.setText(manager.get(p).title);
        img_tab.setImageDrawable(manager.get(p).select);
        imageArray.put(p, img_tab);
        textArray.put(p, tv_tab);
    }

    protected void setTabSelected(@NonNull TabLayout.Tab tab) {
        int p = tab.getPosition();
        imageArray.get(p).setSelected(true);
        textArray.get(p).setTextColor(manager.selectColor);
    }

    protected void setTabUnselected(@NonNull TabLayout.Tab tab) {
        int p = tab.getPosition();
        imageArray.get(p).setSelected(false);
        textArray.get(p).setTextColor(manager.unSelectColor);
    }

    protected void setTabReselected(@NonNull TabLayout.Tab tab) {

    }

}
