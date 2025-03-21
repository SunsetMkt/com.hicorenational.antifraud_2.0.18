package androidx.core.text;

import android.text.TextUtils;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: String.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\b¨\u0006\u0002"}, m23546d2 = {"htmlEncode", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class StringKt {
    @InterfaceC5816d
    public static final String htmlEncode(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "$receiver");
        String htmlEncode = TextUtils.htmlEncode(str);
        C5544i0.m22521a((Object) htmlEncode, "TextUtils.htmlEncode(this)");
        return htmlEncode;
    }
}
