package androidx.core.util;

import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p310s.InterfaceC5512r;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: LruCache.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001aø\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\b\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\b\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\b¨\u0006\u0016"}, m23546d2 = {"lruCache", "Landroid/util/LruCache;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "key", SurveyH5Bean.VALUE, "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LruCacheKt {
    @InterfaceC5816d
    public static final <K, V> LruCache<K, V> lruCache(int i2, @InterfaceC5816d InterfaceC5510p<? super K, ? super V, Integer> interfaceC5510p, @InterfaceC5816d InterfaceC5506l<? super K, ? extends V> interfaceC5506l, @InterfaceC5816d InterfaceC5512r<? super Boolean, ? super K, ? super V, ? super V, C5715y1> interfaceC5512r) {
        C5544i0.m22546f(interfaceC5510p, "sizeOf");
        C5544i0.m22546f(interfaceC5506l, "create");
        C5544i0.m22546f(interfaceC5512r, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(interfaceC5510p, interfaceC5506l, interfaceC5512r, i2, i2);
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ LruCache lruCache$default(int i2, InterfaceC5510p interfaceC5510p, InterfaceC5506l interfaceC5506l, InterfaceC5512r interfaceC5512r, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            interfaceC5510p = LruCacheKt$lruCache$1.INSTANCE;
        }
        InterfaceC5510p interfaceC5510p2 = interfaceC5510p;
        if ((i3 & 4) != 0) {
            interfaceC5506l = LruCacheKt$lruCache$2.INSTANCE;
        }
        InterfaceC5506l interfaceC5506l2 = interfaceC5506l;
        if ((i3 & 8) != 0) {
            interfaceC5512r = LruCacheKt$lruCache$3.INSTANCE;
        }
        InterfaceC5512r interfaceC5512r2 = interfaceC5512r;
        C5544i0.m22546f(interfaceC5510p2, "sizeOf");
        C5544i0.m22546f(interfaceC5506l2, "create");
        C5544i0.m22546f(interfaceC5512r2, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(interfaceC5510p2, interfaceC5506l2, interfaceC5512r2, i2, i2);
    }
}
