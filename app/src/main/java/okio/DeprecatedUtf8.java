package okio;

import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: -DeprecatedUtf8.kt */
@InterfaceC5216c(message = "changed in Okio 2.x")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, m23546d2 = {"Lokio/-DeprecatedUtf8;", "", "()V", "size", "", "string", "", "beginIndex", "", "endIndex", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: okio.-DeprecatedUtf8, reason: invalid class name */
/* loaded from: classes2.dex */
public final class DeprecatedUtf8 {
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "string.utf8Size()", imports = {"okio.utf8Size"}))
    public final long size(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "string");
        return Utf8.size$default(str, 0, 0, 3, null);
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to extension function", replaceWith = @InterfaceC5467o0(expression = "string.utf8Size(beginIndex, endIndex)", imports = {"okio.utf8Size"}))
    public final long size(@InterfaceC5816d String str, int i2, int i3) {
        C5544i0.m22546f(str, "string");
        return Utf8.size(str, i2, i3);
    }
}
