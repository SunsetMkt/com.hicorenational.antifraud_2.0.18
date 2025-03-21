package p388ui.view.drag.vert;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: c */
    private static final int[] f24850c = {R.attr.listDivider};

    /* renamed from: d */
    public static final int f24851d = 0;

    /* renamed from: e */
    public static final int f24852e = 1;

    /* renamed from: a */
    private Drawable f24853a;

    /* renamed from: b */
    private int f24854b;

    public DividerItemDecoration(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f24850c);
        this.f24853a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(i2);
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
            this.f24853a.setBounds(right, paddingTop, this.f24853a.getIntrinsicHeight() + right, height);
            this.f24853a.draw(canvas);
        }
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            new RecyclerView(recyclerView.getContext());
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            this.f24853a.setBounds(paddingLeft, bottom, width, this.f24853a.getIntrinsicHeight() + bottom);
            this.f24853a.draw(canvas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, int i2, RecyclerView recyclerView) {
        if (this.f24854b == 1) {
            rect.set(0, 0, 0, this.f24853a.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.f24853a.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        if (this.f24854b == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.f24854b = i2;
    }
}
