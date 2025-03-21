package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import h.q2.t.q1.d;
import h.y;
import java.util.Iterator;

/* compiled from: Menu.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002J\t\u0010\b\u001a\u00020\u0002H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"androidx/core/view/MenuKt$iterator$1", "", "Landroid/view/MenuItem;", "(Landroid/view/Menu;)V", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class MenuKt$iterator$1 implements Iterator<MenuItem>, d {
    private int index;
    final /* synthetic */ Menu receiver$0;

    MenuKt$iterator$1(Menu menu) {
        this.receiver$0 = menu;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.receiver$0.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.index--;
        this.receiver$0.removeItem(this.index);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @i.c.a.d
    public MenuItem next() {
        Menu menu = this.receiver$0;
        int i2 = this.index;
        this.index = i2 + 1;
        MenuItem item = menu.getItem(i2);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }
}
