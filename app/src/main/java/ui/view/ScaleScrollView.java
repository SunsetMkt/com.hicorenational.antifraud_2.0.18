package ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: classes2.dex */
public class ScaleScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14620f = "ScaleRecyclerView";
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f14621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f14623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f14624e;

    public ScaleScrollView(Context context) {
        super(context);
        this.f14622c = false;
        this.f14623d = 1.0f;
        this.f14624e = 0.3f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = x;
            this.f14621b = y;
        } else if (action != 1) {
            if (action == 2 && y - this.f14621b > 0.0f && getScrollY() == 0) {
                this.f14623d = (((y - this.f14621b) * this.f14624e) / getHeight()) + 1.0f;
                setPivotY(0.0f);
                setPivotX(getWidth() / 2);
                ViewCompat.setScaleY(this, this.f14623d);
                this.f14622c = true;
            }
        } else if (this.f14622c) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleY", this.f14623d, 1.0f);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.start();
            this.f14622c = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ScaleScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14622c = false;
        this.f14623d = 1.0f;
        this.f14624e = 0.3f;
    }

    public ScaleScrollView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14622c = false;
        this.f14623d = 1.0f;
        this.f14624e = 0.3f;
    }
}
