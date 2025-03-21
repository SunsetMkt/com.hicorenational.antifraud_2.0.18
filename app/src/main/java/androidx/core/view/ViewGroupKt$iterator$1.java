package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import h.q2.t.q1.d;
import h.y;
import java.util.Iterator;

/* compiled from: ViewGroup.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002J\t\u0010\b\u001a\u00020\u0002H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "(Landroid/view/ViewGroup;)V", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ViewGroupKt$iterator$1 implements Iterator<View>, d {
    private int index;
    final /* synthetic */ ViewGroup receiver$0;

    ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.receiver$0 = viewGroup;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.receiver$0.getChildCount();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.index--;
        this.receiver$0.removeViewAt(this.index);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @i.c.a.d
    public View next() {
        ViewGroup viewGroup = this.receiver$0;
        int i2 = this.index;
        this.index = i2 + 1;
        View childAt = viewGroup.getChildAt(i2);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }
}
