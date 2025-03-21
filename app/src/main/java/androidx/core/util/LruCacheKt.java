package androidx.core.util;

import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.s.l;
import h.q2.s.p;
import h.q2.s.r;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;

/* compiled from: LruCache.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001aø\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\b\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\b\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\b¨\u0006\u0016"}, d2 = {"lruCache", "Landroid/util/LruCache;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "key", SurveyH5Bean.VALUE, "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LruCacheKt {
    @d
    public static final <K, V> LruCache<K, V> lruCache(int i2, @d p<? super K, ? super V, Integer> pVar, @d l<? super K, ? extends V> lVar, @d r<? super Boolean, ? super K, ? super V, ? super V, y1> rVar) {
        i0.f(pVar, "sizeOf");
        i0.f(lVar, "create");
        i0.f(rVar, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(pVar, lVar, rVar, i2, i2);
    }

    @d
    public static /* bridge */ /* synthetic */ LruCache lruCache$default(int i2, p pVar, l lVar, r rVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            pVar = LruCacheKt$lruCache$1.INSTANCE;
        }
        p pVar2 = pVar;
        if ((i3 & 4) != 0) {
            lVar = LruCacheKt$lruCache$2.INSTANCE;
        }
        l lVar2 = lVar;
        if ((i3 & 8) != 0) {
            rVar = LruCacheKt$lruCache$3.INSTANCE;
        }
        r rVar2 = rVar;
        i0.f(pVar2, "sizeOf");
        i0.f(lVar2, "create");
        i0.f(rVar2, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(pVar2, lVar2, rVar2, i2, i2);
    }
}
