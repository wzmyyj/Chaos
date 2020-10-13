package top.wzmyyj.weight.pager;

import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/09/30.
 *
 * @author feling
 * @version 1.0.0
 * @since 1.0.0
 */
public class PagerTabManager {

    private List<Wrapper> wrapperList = new ArrayList<>();

    List<Wrapper> toList() {
        return wrapperList;
    }

    Wrapper get(int p){
        return wrapperList.get(p);
    }

    public int size(){
        return wrapperList.size();
    }

    public void clear() {
        wrapperList.clear();
    }


    public void add(@NonNull Fragment fragment, @NonNull String title, @NonNull Drawable image) {
        wrapperList.add(new Wrapper(fragment, title, image));
    }


    class Wrapper {
        @NonNull
        Fragment fragment;
        @NonNull
        String title;
        @NonNull
        Drawable select;

        private Wrapper(@NonNull Fragment fragment, @NonNull String title, @NonNull Drawable select) {
            this.fragment = fragment;
            this.title = title;
            this.select = select;
        }
    }


    @ColorInt
    int selectColor = 0xff666666;
    @ColorInt
    int unSelectColor = 0xffbbbbbb;


    public void setSelectColor(@ColorInt int color) {
        this.selectColor = color;
    }

    public void setUnSelectColor(@ColorInt int color) {
        this.unSelectColor = color;
    }

    int firstWhich = 0;

    public void setFirstWhich(int firstWhich) {
        this.firstWhich = firstWhich;
    }

}
