package ui.view.drag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class RemovableView extends FrameLayout {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f14695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f14696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14699i;

    public RemovableView(Context context) {
        this(context, null);
    }

    private void b() {
    }

    public boolean a() {
        return this.f14692b;
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
        if (this.f14694d) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && rawX >= 0.0f && rawX <= this.f14697g) {
                        if (rawY >= this.f14699i && rawY <= this.f14698h + r2) {
                            float f2 = rawX - this.f14695e;
                            float f3 = rawY - this.f14696f;
                            if (!this.f14692b) {
                                this.f14692b = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= 2.0d;
                            }
                            float x = getX() + f2;
                            float y = getY() + f3;
                            float width = this.f14697g - getWidth();
                            float height = this.f14698h - getHeight();
                            float fMin = x < 0.0f ? 0.0f : Math.min(x, width);
                            float fMin2 = y >= 0.0f ? Math.min(y, height) : 0.0f;
                            setX(fMin);
                            setY(fMin2);
                            this.f14695e = rawX;
                            this.f14696f = rawY;
                        }
                    }
                } else if (this.f14693c && this.f14692b) {
                    int i2 = this.f14697g;
                    if (this.f14695e <= (i2 >> 1)) {
                        this.f14695e = 0.0f;
                        animate().setInterpolator(new LinearInterpolator()).setDuration(200L).x(this.f14695e).start();
                    } else {
                        this.f14695e = i2 - getWidth();
                        animate().setInterpolator(new LinearInterpolator()).setDuration(200L).x(this.f14695e).start();
                    }
                }
            } else {
                this.f14692b = false;
                this.f14695e = rawX;
                this.f14696f = rawY;
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    int[] iArr = new int[2];
                    viewGroup.getLocationInWindow(iArr);
                    this.f14698h = viewGroup.getMeasuredHeight();
                    this.f14697g = viewGroup.getMeasuredWidth();
                    this.f14699i = iArr[1];
                }
            }
        }
        boolean z = this.f14692b;
        return z ? z : super.onTouchEvent(motionEvent);
    }

    public RemovableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemovableView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14692b = true;
        this.f14693c = true;
        this.f14694d = true;
        this.f14697g = 0;
        this.f14698h = 0;
        this.f14699i = 0;
        this.a = context;
        b();
    }
}
