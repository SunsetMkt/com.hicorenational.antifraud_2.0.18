package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Locale.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m23546d2 = {"layoutDirection", "", "Ljava/util/Locale;", "getLayoutDirection", "(Ljava/util/Locale;)I", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(@InterfaceC5816d Locale locale) {
        C5544i0.m22546f(locale, "$receiver");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
