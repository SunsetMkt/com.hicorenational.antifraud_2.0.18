package p388ui.view.drag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import util.C7264c1;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class DragImageView extends ImageView {

    /* renamed from: a */
    private int f24780a;

    /* renamed from: b */
    private int f24781b;

    /* renamed from: c */
    private int f24782c;

    /* renamed from: d */
    private int f24783d;

    /* renamed from: e */
    private Context f24784e;

    /* renamed from: f */
    private boolean f24785f;

    /* renamed from: g */
    private float f24786g;

    /* renamed from: h */
    private float f24787h;

    public DragImageView(Context context) {
        super(context);
        this.f24785f = false;
        this.f24784e = context;
    }

    /* renamed from: b */
    public static int m25889b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    /* renamed from: a */
    public boolean m25890a() {
        return this.f24785f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f24780a = getMeasuredWidth();
        this.f24781b = getMeasuredHeight();
        this.f24782c = m25889b(this.f24784e);
        this.f24783d = m25888a(this.f24784e) - C7264c1.m26296d(this.f24784e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f24785f = false;
            this.f24786g = motionEvent.getX();
            this.f24787h = motionEvent.getY();
        } else if (action == 1) {
            setPressed(false);
        } else if (action == 2) {
            float x = motionEvent.getX() - this.f24786g;
            float y = motionEvent.getY() - this.f24787h;
            if (Math.abs(x) > 10.0f || Math.abs(y) > 10.0f) {
                this.f24785f = true;
                int left = (int) (getLeft() + x);
                int i2 = this.f24780a + left;
                int top = (int) (getTop() + y);
                int i3 = this.f24781b + top;
                if (left < 0) {
                    i2 = this.f24780a + 0;
                    left = 0;
                } else {
                    int i4 = this.f24782c;
                    if (i2 > i4) {
                        left = i4 - this.f24780a;
                        i2 = i4;
                    }
                }
                if (top < 0) {
                    i3 = this.f24781b + 0;
                    top = 0;
                } else {
                    int i5 = this.f24783d;
                    if (i3 > i5) {
                        top = i5 - this.f24781b;
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

    /* renamed from: a */
    public static int m25888a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public DragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24785f = false;
        this.f24784e = context;
    }
}
