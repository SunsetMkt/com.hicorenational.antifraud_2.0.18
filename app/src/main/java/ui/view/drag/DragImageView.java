package ui.view.drag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import util.g1;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"AppCompatCustomView"})
public class DragImageView extends ImageView {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f14675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f14677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f14678h;

    public DragImageView(Context context) {
        super(context);
        this.f14676f = false;
        this.f14675e = context;
    }

    public static int b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public boolean a() {
        return this.f14676f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.a = getMeasuredWidth();
        this.f14672b = getMeasuredHeight();
        this.f14673c = b(this.f14675e);
        this.f14674d = a(this.f14675e) - g1.d(this.f14675e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f14676f = false;
            this.f14677g = motionEvent.getX();
            this.f14678h = motionEvent.getY();
        } else if (action == 1) {
            setPressed(false);
        } else if (action == 2) {
            float x = motionEvent.getX() - this.f14677g;
            float y = motionEvent.getY() - this.f14678h;
            if (Math.abs(x) > 10.0f || Math.abs(y) > 10.0f) {
                this.f14676f = true;
                int left = (int) (getLeft() + x);
                int i2 = this.a + left;
                int top = (int) (getTop() + y);
                int i3 = this.f14672b + top;
                if (left < 0) {
                    i2 = this.a + 0;
                    left = 0;
                } else {
                    int i4 = this.f14673c;
                    if (i2 > i4) {
                        left = i4 - this.a;
                        i2 = i4;
                    }
                }
                if (top < 0) {
                    i3 = this.f14672b + 0;
                    top = 0;
                } else {
                    int i5 = this.f14674d;
                    if (i3 > i5) {
                        top = i5 - this.f14672b;
                        i3 = i5;
                    }
                }
                layout(left, top, i2, i3);
            }
        } else if (action == 3) {
            setPressed(false);
        }
        return true;
    }

    public static int a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public DragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14676f = false;
        this.f14675e = context;
    }
}
