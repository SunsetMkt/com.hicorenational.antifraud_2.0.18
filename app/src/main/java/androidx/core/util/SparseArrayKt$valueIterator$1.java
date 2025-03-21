package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SparseArray.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0002\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, m23546d2 = {"androidx/core/util/SparseArrayKt$valueIterator$1", "", "(Landroid/util/SparseArray;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "kotlin.jvm.PlatformType", "()Ljava/lang/Object;", "core-ktx_release"}, m23547k = 1, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SparseArrayKt$valueIterator$1<T> implements Iterator<T>, InterfaceC5569a {
    private int index;
    final /* synthetic */ SparseArray receiver$0;

    SparseArrayKt$valueIterator$1(SparseArray<T> sparseArray) {
        this.receiver$0 = sparseArray;
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
        SparseArray sparseArray = this.receiver$0;
        int i2 = this.index;
        this.index = i2 + 1;
        return (T) sparseArray.valueAt(i2);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }
}
