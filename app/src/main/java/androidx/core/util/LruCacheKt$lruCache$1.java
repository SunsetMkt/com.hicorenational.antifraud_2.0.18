package androidx.core.util;

import androidx.exifinterface.media.ExifInterface;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LruCache.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, m23546d2 = {"<anonymous>", "", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "<anonymous parameter 0>", "<anonymous parameter 1>", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m23547k = 3, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$1<K, V> extends AbstractC5547j0 implements InterfaceC5510p<K, V, Integer> {
    public static final LruCacheKt$lruCache$1 INSTANCE = new LruCacheKt$lruCache$1();

    public LruCacheKt$lruCache$1() {
        super(2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(@InterfaceC5816d K k2, @InterfaceC5816d V v) {
        C5544i0.m22546f(k2, "<anonymous parameter 0>");
        C5544i0.m22546f(v, "<anonymous parameter 1>");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p286h.p309q2.p310s.InterfaceC5510p
    public /* bridge */ /* synthetic */ Integer invoke(Object obj, Object obj2) {
        return Integer.valueOf(invoke2((LruCacheKt$lruCache$1<K, V>) obj, obj2));
    }
}
