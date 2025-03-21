package androidx.core.text;

import android.text.TextUtils;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: CharSequence.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0086\b¨\u0006\u0005"}, m23546d2 = {"isDigitsOnly", "", "", "trimmedLength", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "$receiver");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "$receiver");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
