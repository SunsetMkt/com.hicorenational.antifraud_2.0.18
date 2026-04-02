package ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class ScaleRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14615f = "ScaleRecyclerView";
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f14616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f14618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f14619e;

    public ScaleRecyclerView(Context context) {
        super(context);
        this.f14617c = false;
        this.f14618d = 1.0f;
        this.f14619e = 0.3f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = x;
            this.f14616b = y;
        } else if (action != 1) {
            if (action == 2) {
                if (y - this.f14616b > 0.0f) {
                    View childAt = getChildAt(0);
                    if (((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition() == 0 && childAt.getTop() >= 0) {
                        this.f14618d = (((y - this.f14616b) * this.f14619e) / getHeight()) + 1.0f;
                        setPivotY(0.0f);
                        setPivotX(getWidth() / 2);
                        ViewCompat.setScaleY(this, this.f14618d);
                        this.f14617c = true;
                    }
                } else {
                    View childAt2 = getChildAt(getChildCount() - 1);
                    if (((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition() + 1 == getAdapter().getItemCount() && childAt2.getBottom() <= getBottom()) {
                        this.f14618d = 1.0f - ((this.f14619e * (y - this.f14616b)) / getHeight());
                        setPivotX(getWidth() / 2);
                        setPivotY(getHeight());
                        ViewCompat.setScaleY(this, this.f14618d);
                        this.f14617c = true;
                    }
                }
            }
        } else if (this.f14617c) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleY", this.f14618d, 1.0f);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.start();
            this.f14617c = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ScaleRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14617c = false;
        this.f14618d = 1.0f;
        this.f14619e = 0.3f;
    }

    public ScaleRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14617c = false;
        this.f14618d = 1.0f;
        this.f14619e = 0.3f;
    }
}
