package p388ui.view.drag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class RemovableView extends FrameLayout {

    /* renamed from: a */
    private final Context f24826a;

    /* renamed from: b */
    private boolean f24827b;

    /* renamed from: c */
    private boolean f24828c;

    /* renamed from: d */
    private boolean f24829d;

    /* renamed from: e */
    private float f24830e;

    /* renamed from: f */
    private float f24831f;

    /* renamed from: g */
    private int f24832g;

    /* renamed from: h */
    private int f24833h;

    /* renamed from: i */
    private int f24834i;

    public RemovableView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    private void m25929b() {
    }

    /* renamed from: a */
    public boolean m25930a() {
        return this.f24827b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f24829d) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && rawX >= 0.0f && rawX <= this.f24832g) {
                        if (rawY >= this.f24834i && rawY <= this.f24833h + r2) {
                            float f2 = rawX - this.f24830e;
                            float f3 = rawY - this.f24831f;
                            if (!this.f24827b) {
                                this.f24827b = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= 2.0d;
                            }
                            float x = getX() + f2;
                            float y = getY() + f3;
                            float width = this.f24832g - getWidth();
                            float height = this.f24833h - getHeight();
                            float min = x < 0.0f ? 0.0f : Math.min(x, width);
                            float min2 = y >= 0.0f ? Math.min(y, height) : 0.0f;
                            setX(min);
                            setY(min2);
                            this.f24830e = rawX;
                            this.f24831f = rawY;
                        }
                    }
                } else if (this.f24828c && this.f24827b) {
                    int i2 = this.f24832g;
                    if (this.f24830e <= (i2 >> 1)) {
                        this.f24830e = 0.0f;
                        animate().setInterpolator(new LinearInterpolator()).setDuration(200L).x(this.f24830e).start();
                    } else {
                        this.f24830e = i2 - getWidth();
                        animate().setInterpolator(new LinearInterpolator()).setDuration(200L).x(this.f24830e).start();
                    }
                }
            } else {
                this.f24827b = false;
                this.f24830e = rawX;
                this.f24831f = rawY;
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    int[] iArr = new int[2];
                    viewGroup.getLocationInWindow(iArr);
                    this.f24833h = viewGroup.getMeasuredHeight();
                    this.f24832g = viewGroup.getMeasuredWidth();
                    this.f24834i = iArr[1];
                }
            }
        }
        boolean z = this.f24827b;
        return z ? z : super.onTouchEvent(motionEvent);
    }

    public RemovableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemovableView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24827b = true;
        this.f24828c = true;
        this.f24829d = true;
        this.f24832g = 0;
        this.f24833h = 0;
        this.f24834i = 0;
        this.f24826a = context;
        m25929b();
    }
}
