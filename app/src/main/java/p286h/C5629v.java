package p286h;

import com.taobao.accs.common.Constants;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* renamed from: h.v */
/* loaded from: classes2.dex */
public class C5629v {
    @InterfaceC5816d
    /* renamed from: a */
    public static <T> InterfaceC5604s<T> m22990a(@InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5495a, "initializer");
        return new C5191a1(interfaceC5495a, null, 2, null);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static <T> InterfaceC5604s<T> m22991a(@InterfaceC5816d EnumC5682x enumC5682x, @InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a) {
        C5544i0.m22546f(enumC5682x, Constants.KEY_MODE);
        C5544i0.m22546f(interfaceC5495a, "initializer");
        int i2 = C5609t.f20465a[enumC5682x.ordinal()];
        if (i2 == 1) {
            return new C5191a1(interfaceC5495a, null, 2, null);
        }
        if (i2 == 2) {
            return new C5605s0(interfaceC5495a);
        }
        if (i2 == 3) {
            return new C5720z1(interfaceC5495a);
        }
        throw new C5718z();
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5604s<T> m22992a(@InterfaceC5817e Object obj, @InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5495a, "initializer");
        return new C5191a1(interfaceC5495a, obj);
    }
}
