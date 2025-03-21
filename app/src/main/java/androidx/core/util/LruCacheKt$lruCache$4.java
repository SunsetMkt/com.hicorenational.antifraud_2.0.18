package androidx.core.util;

import android.util.LruCache;
import bean.SurveyH5Bean;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p310s.InterfaceC5512r;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LruCache.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0005J/\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u00012\b\u0010\u000b\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, m23546d2 = {"androidx/core/util/LruCacheKt$lruCache$4", "Landroid/util/LruCache;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;II)V", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", SurveyH5Bean.VALUE, "(Ljava/lang/Object;Ljava/lang/Object;)I", "core-ktx_release"}, m23547k = 1, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    final /* synthetic */ InterfaceC5506l $create;
    final /* synthetic */ int $maxSize;
    final /* synthetic */ InterfaceC5512r $onEntryRemoved;
    final /* synthetic */ InterfaceC5510p $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(InterfaceC5510p interfaceC5510p, InterfaceC5506l interfaceC5506l, InterfaceC5512r interfaceC5512r, int i2, int i3) {
        super(i3);
        this.$sizeOf = interfaceC5510p;
        this.$create = interfaceC5506l;
        this.$onEntryRemoved = interfaceC5512r;
        this.$maxSize = i2;
    }

    @Override // android.util.LruCache
    @InterfaceC5817e
    protected V create(@InterfaceC5816d K k2) {
        C5544i0.m22546f(k2, "key");
        return (V) this.$create.invoke(k2);
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z, @InterfaceC5816d K k2, @InterfaceC5816d V v, @InterfaceC5817e V v2) {
        C5544i0.m22546f(k2, "key");
        C5544i0.m22546f(v, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), k2, v, v2);
    }

    @Override // android.util.LruCache
    protected int sizeOf(@InterfaceC5816d K k2, @InterfaceC5816d V v) {
        C5544i0.m22546f(k2, "key");
        C5544i0.m22546f(v, SurveyH5Bean.VALUE);
        return ((Number) this.$sizeOf.invoke(k2, v)).intValue();
    }
}
