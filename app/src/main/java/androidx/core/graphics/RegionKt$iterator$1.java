package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Region.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\t\u001a\u00020\u0005H\u0096\u0002J\t\u0010\n\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m23546d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "(Landroid/graphics/Region;)V", "hasMore", "", "iterator", "Landroid/graphics/RegionIterator;", "rect", "hasNext", "next", "core-ktx_release"}, m23547k = 1, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class RegionKt$iterator$1 implements Iterator<Rect>, InterfaceC5569a {
    private boolean hasMore;
    private final RegionIterator iterator;
    final /* synthetic */ Region receiver$0;
    private final Rect rect = new Rect();

    RegionKt$iterator$1(Region region) {
        this.receiver$0 = region;
        this.iterator = new RegionIterator(this.receiver$0);
        this.hasMore = this.iterator.next(this.rect);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasMore;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @InterfaceC5816d
    public Rect next() {
        if (!this.hasMore) {
            throw new IndexOutOfBoundsException();
        }
        Rect rect = new Rect(this.rect);
        this.hasMore = this.iterator.next(this.rect);
        return rect;
    }
}
