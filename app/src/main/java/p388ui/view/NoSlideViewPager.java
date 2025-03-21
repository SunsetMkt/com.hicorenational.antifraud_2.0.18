package p388ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class NoSlideViewPager extends ViewPager {

    /* renamed from: a */
    private boolean f24593a;

    public NoSlideViewPager(Context context) {
        super(context);
        this.f24593a = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean executeKeyEvent(KeyEvent keyEvent) {
        return this.f24593a;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f24593a;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f24593a;
    }

    public void setSlide(boolean z) {
        this.f24593a = z;
    }

    public NoSlideViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24593a = false;
    }
}
