package androidx.core.util;

import android.util.LongSparseArray;
import h.q2.t.q1.a;
import h.y;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: LongSparseArray.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0002\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"androidx/core/util/LongSparseArrayKt$valueIterator$1", "", "(Landroid/util/LongSparseArray;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "kotlin.jvm.PlatformType", "()Ljava/lang/Object;", "core-ktx_release"}, k = 1, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LongSparseArrayKt$valueIterator$1<T> implements Iterator<T>, a {
    private int index;
    final /* synthetic */ LongSparseArray receiver$0;

    LongSparseArrayKt$valueIterator$1(LongSparseArray<T> longSparseArray) {
        this.receiver$0 = longSparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.receiver$0.size();
    }

    @Override // java.util.Iterator
    public T next() {
        LongSparseArray longSparseArray = this.receiver$0;
        int i2 = this.index;
        this.index = i2 + 1;
        return (T) longSparseArray.valueAt(i2);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }
}
