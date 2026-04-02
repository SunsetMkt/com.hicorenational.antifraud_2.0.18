package ui.view.swip;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.hicorenational.antifraud.R;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SwipBackLayout extends FrameLayout {
    private View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Scroller f14822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Activity f14827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<ViewPager> f14828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Drawable f14829m;

    public SwipBackLayout(Context context) {
        this(context, null);
    }

    public static SwipBackLayout a(Activity activity) {
        return new SwipBackLayout(activity);
    }

    private void c() {
        int scrollX = this.a.getScrollX();
        this.f14822f.startScroll(this.a.getScrollX(), 0, -scrollX, 0, Math.abs(scrollX));
        postInvalidate();
    }

    private void d() {
        int scrollX = this.f14823g + this.a.getScrollX();
        this.f14822f.startScroll(this.a.getScrollX(), 0, (-scrollX) + 1, 0, Math.abs(scrollX));
        postInvalidate();
    }

    private void setContentView(View view) {
        this.a = (View) view.getParent();
    }

    public boolean b() {
        return this.f14826j;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f14822f.computeScrollOffset()) {
            this.a.scrollTo(this.f14822f.getCurrX(), this.f14822f.getCurrY());
            postInvalidate();
            if (this.f14822f.isFinished() && this.f14825i) {
                this.f14827k.finish();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View view;
        super.dispatchDraw(canvas);
        if (this.f14829m == null || (view = this.a) == null) {
            return;
        }
        int left = view.getLeft() - this.f14829m.getIntrinsicWidth();
        this.f14829m.setBounds(left, this.a.getTop(), this.f14829m.getIntrinsicWidth() + left, this.a.getBottom());
        this.f14829m.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f14826j) {
            return false;
        }
        ViewPager viewPagerA = a(this.f14828l, motionEvent);
        if (viewPagerA != null && viewPagerA.getCurrentItem() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int rawX = (int) motionEvent.getRawX();
            this.f14821e = rawX;
            this.f14819c = rawX;
            this.f14820d = (int) motionEvent.getRawY();
        } else if (action == 2 && ((int) motionEvent.getRawX()) - this.f14819c > this.f14818b && Math.abs(((int) motionEvent.getRawY()) - this.f14820d) < this.f14818b) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            this.f14823g = getWidth();
            a(this.f14828l, this);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f14826j) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            this.f14824h = false;
            if (this.a.getScrollX() <= (-this.f14823g) / 2) {
                this.f14825i = true;
                d();
            } else {
                c();
                this.f14825i = false;
            }
        } else if (action == 2) {
            int rawX = (int) motionEvent.getRawX();
            int i2 = this.f14821e - rawX;
            this.f14821e = rawX;
            if (rawX - this.f14819c > this.f14818b && Math.abs(((int) motionEvent.getRawY()) - this.f14820d) < this.f14818b) {
                this.f14824h = true;
            }
            if (rawX - this.f14819c >= 0 && this.f14824h) {
                this.a.scrollBy(i2, 0);
            }
        }
        return true;
    }

    public void setInterEvent(boolean z) {
        this.f14826j = z;
    }

    public SwipBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a() {
        ViewGroup viewGroup = (ViewGroup) this.f14827k.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        viewGroup.addView(this);
    }

    public SwipBackLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14826j = false;
        this.f14828l = new LinkedList();
        this.f14827k = (Activity) context;
        this.f14818b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f14822f = new Scroller(context);
        this.f14829m = getResources().getDrawable(R.drawable.swip_left_shadow);
    }

    private void a(List<ViewPager> list, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewPager) {
                list.add((ViewPager) childAt);
            } else if (childAt instanceof ViewGroup) {
                a(list, (ViewGroup) childAt);
            }
        }
    }

    private ViewPager a(List<ViewPager> list, MotionEvent motionEvent) {
        if (list != null && list.size() != 0) {
            Rect rect = new Rect();
            for (ViewPager viewPager : list) {
                viewPager.getHitRect(rect);
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return viewPager;
                }
            }
        }
        return null;
    }
}
