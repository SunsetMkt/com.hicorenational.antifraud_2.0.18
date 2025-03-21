package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.p312q1.InterfaceC5572d;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ViewGroup.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002J\t\u0010\b\u001a\u00020\u0002H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m23546d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "(Landroid/view/ViewGroup;)V", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, m23547k = 1, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ViewGroupKt$iterator$1 implements Iterator<View>, InterfaceC5572d {
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
    @InterfaceC5816d
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
