package p388ui.view.swip;

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
import com.hicorenational.antifraud.C2113R;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class SwipBackLayout extends FrameLayout {

    /* renamed from: a */
    private View f25002a;

    /* renamed from: b */
    private int f25003b;

    /* renamed from: c */
    private int f25004c;

    /* renamed from: d */
    private int f25005d;

    /* renamed from: e */
    private int f25006e;

    /* renamed from: f */
    private Scroller f25007f;

    /* renamed from: g */
    private int f25008g;

    /* renamed from: h */
    private boolean f25009h;

    /* renamed from: i */
    private boolean f25010i;

    /* renamed from: j */
    private boolean f25011j;

    /* renamed from: k */
    private Activity f25012k;

    /* renamed from: l */
    private List<ViewPager> f25013l;

    /* renamed from: m */
    private Drawable f25014m;

    public SwipBackLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public static SwipBackLayout m26045a(Activity activity) {
        return new SwipBackLayout(activity);
    }

    /* renamed from: c */
    private void m26047c() {
        int scrollX = this.f25002a.getScrollX();
        this.f25007f.startScroll(this.f25002a.getScrollX(), 0, -scrollX, 0, Math.abs(scrollX));
        postInvalidate();
    }

    /* renamed from: d */
    private void m26048d() {
        int scrollX = this.f25008g + this.f25002a.getScrollX();
        this.f25007f.startScroll(this.f25002a.getScrollX(), 0, (-scrollX) + 1, 0, Math.abs(scrollX));
        postInvalidate();
    }

    private void setContentView(View view) {
        this.f25002a = (View) view.getParent();
    }

    /* renamed from: b */
    public boolean m26050b() {
        return this.f25011j;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f25007f.computeScrollOffset()) {
            this.f25002a.scrollTo(this.f25007f.getCurrX(), this.f25007f.getCurrY());
            postInvalidate();
            if (this.f25007f.isFinished() && this.f25010i) {
                this.f25012k.finish();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View view;
        super.dispatchDraw(canvas);
        if (this.f25014m == null || (view = this.f25002a) == null) {
            return;
        }
        int left = view.getLeft() - this.f25014m.getIntrinsicWidth();
        this.f25014m.setBounds(left, this.f25002a.getTop(), this.f25014m.getIntrinsicWidth() + left, this.f25002a.getBottom());
        this.f25014m.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f25011j) {
            return false;
        }
        ViewPager m26044a = m26044a(this.f25013l, motionEvent);
        if (m26044a != null && m26044a.getCurrentItem() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int rawX = (int) motionEvent.getRawX();
            this.f25006e = rawX;
            this.f25004c = rawX;
            this.f25005d = (int) motionEvent.getRawY();
        } else if (action == 2 && ((int) motionEvent.getRawX()) - this.f25004c > this.f25003b && Math.abs(((int) motionEvent.getRawY()) - this.f25005d) < this.f25003b) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            this.f25008g = getWidth();
            m26046a(this.f25013l, this);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f25011j) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            this.f25009h = false;
            if (this.f25002a.getScrollX() <= (-this.f25008g) / 2) {
                this.f25010i = true;
                m26048d();
            } else {
                m26047c();
                this.f25010i = false;
            }
        } else if (action == 2) {
            int rawX = (int) motionEvent.getRawX();
            int i2 = this.f25006e - rawX;
            this.f25006e = rawX;
            if (rawX - this.f25004c > this.f25003b && Math.abs(((int) motionEvent.getRawY()) - this.f25005d) < this.f25003b) {
                this.f25009h = true;
            }
            if (rawX - this.f25004c >= 0 && this.f25009h) {
                this.f25002a.scrollBy(i2, 0);
            }
        }
        return true;
    }

    public void setInterEvent(boolean z) {
        this.f25011j = z;
    }

    public SwipBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public void m26049a() {
        ViewGroup viewGroup = (ViewGroup) this.f25012k.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        viewGroup.addView(this);
    }

    public SwipBackLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25011j = false;
        this.f25013l = new LinkedList();
        this.f25012k = (Activity) context;
        this.f25003b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f25007f = new Scroller(context);
        this.f25014m = getResources().getDrawable(C2113R.drawable.swip_left_shadow);
    }

    /* renamed from: a */
    private void m26046a(List<ViewPager> list, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewPager) {
                list.add((ViewPager) childAt);
            } else if (childAt instanceof ViewGroup) {
                m26046a(list, (ViewGroup) childAt);
            }
        }
    }

    /* renamed from: a */
    private ViewPager m26044a(List<ViewPager> list, MotionEvent motionEvent) {
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
