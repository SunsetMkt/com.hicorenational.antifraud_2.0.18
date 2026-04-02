package ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleDividerDecoration extends RecyclerView.ItemDecoration {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f14635b = new Paint();

    public SimpleDividerDecoration(Context context) {
        this.f14635b.setColor(context.getResources().getColor(R.color.line_color));
        this.a = context.getResources().getDimensionPixelSize(R.dimen.dp_1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.bottom = this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        for (int i2 = 0; i2 < childCount - 1; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            canvas.drawRect(paddingLeft, childAt.getBottom(), width, childAt.getBottom() + this.a, this.f14635b);
        }
    }
}
