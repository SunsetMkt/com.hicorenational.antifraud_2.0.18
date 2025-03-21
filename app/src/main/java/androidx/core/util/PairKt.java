package androidx.core.util;

import androidx.exifinterface.media.ExifInterface;
import p286h.C5334i0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Pair.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004H\u0086\n¢\u0006\u0002\u0010\u0005\u001a2\u0010\u0006\u001a\n \u0002*\u0004\u0018\u0001H\u0003H\u0003\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004H\u0086\n¢\u0006\u0002\u0010\u0005\u001a1\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\bH\u0086\b\u001aA\u0010\t\u001a\u001e\u0012\f\u0012\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u0001H\u0003H\u00030\b\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004H\u0086\b¨\u0006\n"}, m23546d2 = {"component1", "F", "kotlin.jvm.PlatformType", ExifInterface.LATITUDE_SOUTH, "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "toAndroidPair", "Lkotlin/Pair;", "toKotlinPair", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class PairKt {
    public static final <F, S> F component1(@InterfaceC5816d android.util.Pair<F, S> pair) {
        C5544i0.m22546f(pair, "$receiver");
        return (F) pair.first;
    }

    public static final <F, S> S component2(@InterfaceC5816d android.util.Pair<F, S> pair) {
        C5544i0.m22546f(pair, "$receiver");
        return (S) pair.second;
    }

    @InterfaceC5816d
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@InterfaceC5816d C5334i0<? extends F, ? extends S> c5334i0) {
        C5544i0.m22546f(c5334i0, "$receiver");
        return new android.util.Pair<>(c5334i0.getFirst(), c5334i0.getSecond());
    }

    @InterfaceC5816d
    public static final <F, S> C5334i0<F, S> toKotlinPair(@InterfaceC5816d android.util.Pair<F, S> pair) {
        C5544i0.m22546f(pair, "$receiver");
        return new C5334i0<>(pair.first, pair.second);
    }
}
