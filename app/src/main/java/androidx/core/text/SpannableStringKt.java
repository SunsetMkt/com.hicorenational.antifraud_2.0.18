package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5642k;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SpannableString.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0086\b¨\u0006\r"}, m23546d2 = {"clearSpans", "", "Landroid/text/Spannable;", "set", "start", "", "end", "span", "", "range", "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(@InterfaceC5816d Spannable spannable) {
        C5544i0.m22546f(spannable, "$receiver");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        C5544i0.m22521a((Object) spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(@InterfaceC5816d Spannable spannable, int i2, int i3, @InterfaceC5816d Object obj) {
        C5544i0.m22546f(spannable, "$receiver");
        C5544i0.m22546f(obj, "span");
        spannable.setSpan(obj, i2, i3, 17);
    }

    @InterfaceC5816d
    public static final Spannable toSpannable(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "$receiver");
        SpannableString valueOf = SpannableString.valueOf(charSequence);
        C5544i0.m22521a((Object) valueOf, "SpannableString.valueOf(this)");
        return valueOf;
    }

    public static final void set(@InterfaceC5816d Spannable spannable, @InterfaceC5816d C5642k c5642k, @InterfaceC5816d Object obj) {
        C5544i0.m22546f(spannable, "$receiver");
        C5544i0.m22546f(c5642k, "range");
        C5544i0.m22546f(obj, "span");
        spannable.setSpan(obj, c5642k.getStart().intValue(), c5642k.getEndInclusive().intValue(), 17);
    }
}
