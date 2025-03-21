package p388ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes2.dex */
public class ScaleScrollView extends NestedScrollView {

    /* renamed from: f */
    private static final String f24658f = "ScaleRecyclerView";

    /* renamed from: a */
    private float f24659a;

    /* renamed from: b */
    private float f24660b;

    /* renamed from: c */
    private boolean f24661c;

    /* renamed from: d */
    private float f24662d;

    /* renamed from: e */
    private float f24663e;

    public ScaleScrollView(Context context) {
        super(context);
        this.f24661c = false;
        this.f24662d = 1.0f;
        this.f24663e = 0.3f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f24659a = x;
            this.f24660b = y;
        } else if (action != 1) {
            if (action == 2 && y - this.f24660b > 0.0f && getScrollY() == 0) {
                this.f24662d = (((y - this.f24660b) * this.f24663e) / getHeight()) + 1.0f;
                setPivotY(0.0f);
                setPivotX(getWidth() / 2);
                ViewCompat.setScaleY(this, this.f24662d);
                this.f24661c = true;
            }
        } else if (this.f24661c) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleY", this.f24662d, 1.0f);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(200L);
            ofFloat.start();
            this.f24661c = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ScaleScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24661c = false;
        this.f24662d = 1.0f;
        this.f24663e = 0.3f;
    }

    public ScaleScrollView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24661c = false;
        this.f24662d = 1.0f;
        this.f24663e = 0.3f;
    }
}
