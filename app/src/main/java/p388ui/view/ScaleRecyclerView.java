package p388ui.view;

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

/* loaded from: classes2.dex */
public class ScaleRecyclerView extends RecyclerView {

    /* renamed from: f */
    private static final String f24652f = "ScaleRecyclerView";

    /* renamed from: a */
    private float f24653a;

    /* renamed from: b */
    private float f24654b;

    /* renamed from: c */
    private boolean f24655c;

    /* renamed from: d */
    private float f24656d;

    /* renamed from: e */
    private float f24657e;

    public ScaleRecyclerView(Context context) {
        super(context);
        this.f24655c = false;
        this.f24656d = 1.0f;
        this.f24657e = 0.3f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f24653a = x;
            this.f24654b = y;
        } else if (action != 1) {
            if (action == 2) {
                if (y - this.f24654b > 0.0f) {
                    View childAt = getChildAt(0);
                    if (((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition() == 0 && childAt.getTop() >= 0) {
                        this.f24656d = (((y - this.f24654b) * this.f24657e) / getHeight()) + 1.0f;
                        setPivotY(0.0f);
                        setPivotX(getWidth() / 2);
                        ViewCompat.setScaleY(this, this.f24656d);
                        this.f24655c = true;
                    }
                } else {
                    View childAt2 = getChildAt(getChildCount() - 1);
                    if (((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition() + 1 == getAdapter().getItemCount() && childAt2.getBottom() <= getBottom()) {
                        this.f24656d = 1.0f - ((this.f24657e * (y - this.f24654b)) / getHeight());
                        setPivotX(getWidth() / 2);
                        setPivotY(getHeight());
                        ViewCompat.setScaleY(this, this.f24656d);
                        this.f24655c = true;
                    }
                }
            }
        } else if (this.f24655c) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleY", this.f24656d, 1.0f);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(200L);
            ofFloat.start();
            this.f24655c = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ScaleRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24655c = false;
        this.f24656d = 1.0f;
        this.f24657e = 0.3f;
    }

    public ScaleRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24655c = false;
        this.f24656d = 1.0f;
        this.f24657e = 0.3f;
    }
}
