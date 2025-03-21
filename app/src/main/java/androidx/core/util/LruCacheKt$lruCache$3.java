package androidx.core.util;

import androidx.exifinterface.media.ExifInterface;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5512r;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LruCache.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u0002H\u00042\b\u0010\t\u001a\u0004\u0018\u0001H\u0004H\n¢\u0006\u0004\b\n\u0010\u000b"}, m23546d2 = {"<anonymous>", "", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>", "invoke", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V"}, m23547k = 3, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$3<K, V> extends AbstractC5547j0 implements InterfaceC5512r<Boolean, K, V, V, C5715y1> {
    public static final LruCacheKt$lruCache$3 INSTANCE = new LruCacheKt$lruCache$3();

    public LruCacheKt$lruCache$3() {
        super(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p286h.p309q2.p310s.InterfaceC5512r
    public /* bridge */ /* synthetic */ C5715y1 invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
        invoke(bool.booleanValue(), (boolean) obj, obj2, obj3);
        return C5715y1.f20665a;
    }

    public final void invoke(boolean z, @InterfaceC5816d K k2, @InterfaceC5816d V v, @InterfaceC5817e V v2) {
        C5544i0.m22546f(k2, "<anonymous parameter 1>");
        C5544i0.m22546f(v, "<anonymous parameter 2>");
    }
}
