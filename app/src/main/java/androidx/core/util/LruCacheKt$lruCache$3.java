package androidx.core.util;

import androidx.exifinterface.media.ExifInterface;
import h.q2.s.r;
import h.q2.t.i0;
import h.q2.t.j0;
import h.y;
import h.y1;
import i.c.a.d;
import i.c.a.e;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LruCache.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u0002H\u00042\b\u0010\t\u001a\u0004\u0018\u0001H\u0004H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>", "invoke", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V"}, k = 3, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$3<K, V> extends j0 implements r<Boolean, K, V, V, y1> {
    public static final LruCacheKt$lruCache$3 INSTANCE = new LruCacheKt$lruCache$3();

    public LruCacheKt$lruCache$3() {
        super(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.q2.s.r
    public /* bridge */ /* synthetic */ y1 invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
        invoke(bool.booleanValue(), (boolean) obj, obj2, obj3);
        return y1.f16671a;
    }

    public final void invoke(boolean z, @d K k2, @d V v, @e V v2) {
        i0.f(k2, "<anonymous parameter 1>");
        i0.f(v, "<anonymous parameter 2>");
    }
}
