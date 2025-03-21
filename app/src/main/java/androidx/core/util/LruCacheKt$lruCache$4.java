package androidx.core.util;

import android.util.LruCache;
import bean.SurveyH5Bean;
import h.q2.s.l;
import h.q2.s.p;
import h.q2.s.r;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import i.c.a.e;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LruCache.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0005J/\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u00012\b\u0010\u000b\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"androidx/core/util/LruCacheKt$lruCache$4", "Landroid/util/LruCache;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;II)V", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", SurveyH5Bean.VALUE, "(Ljava/lang/Object;Ljava/lang/Object;)I", "core-ktx_release"}, k = 1, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    final /* synthetic */ l $create;
    final /* synthetic */ int $maxSize;
    final /* synthetic */ r $onEntryRemoved;
    final /* synthetic */ p $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(p pVar, l lVar, r rVar, int i2, int i3) {
        super(i3);
        this.$sizeOf = pVar;
        this.$create = lVar;
        this.$onEntryRemoved = rVar;
        this.$maxSize = i2;
    }

    @Override // android.util.LruCache
    @e
    protected V create(@d K k2) {
        i0.f(k2, "key");
        return (V) this.$create.invoke(k2);
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z, @d K k2, @d V v, @e V v2) {
        i0.f(k2, "key");
        i0.f(v, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), k2, v, v2);
    }

    @Override // android.util.LruCache
    protected int sizeOf(@d K k2, @d V v) {
        i0.f(k2, "key");
        i0.f(v, SurveyH5Bean.VALUE);
        return ((Number) this.$sizeOf.invoke(k2, v)).intValue();
    }
}
