package p286h.p306n2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: FileTreeWalk.kt */
/* renamed from: h.n2.q */
/* loaded from: classes2.dex */
class C5458q extends C5457p {
    /* renamed from: a */
    public static /* synthetic */ C5452k m22366a(File file, EnumC5454m enumC5454m, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            enumC5454m = EnumC5454m.TOP_DOWN;
        }
        return m22365a(file, enumC5454m);
    }

    @InterfaceC5816d
    /* renamed from: e */
    public static final C5452k m22367e(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "$this$walkBottomUp");
        return m22365a(file, EnumC5454m.BOTTOM_UP);
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final C5452k m22368f(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "$this$walkTopDown");
        return m22365a(file, EnumC5454m.TOP_DOWN);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5452k m22365a(@InterfaceC5816d File file, @InterfaceC5816d EnumC5454m enumC5454m) {
        C5544i0.m22546f(file, "$this$walk");
        C5544i0.m22546f(enumC5454m, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        return new C5452k(file, enumC5454m);
    }
}
