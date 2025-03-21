package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SpannedString.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\u001a:\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0004*\u00020\nH\u0086\b¨\u0006\u000b"}, m23546d2 = {"getSpans", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/text/Spanned;", "start", "", "end", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "toSpanned", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SpannedStringKt {
    private static final <T> T[] getSpans(@InterfaceC5816d Spanned spanned, int i2, int i3) {
        C5544i0.m22518a(4, ExifInterface.GPS_DIRECTION_TRUE);
        T[] tArr = (T[]) spanned.getSpans(i2, i3, Object.class);
        C5544i0.m22521a((Object) tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    static /* bridge */ /* synthetic */ Object[] getSpans$default(Spanned spanned, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = spanned.length();
        }
        C5544i0.m22518a(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] spans = spanned.getSpans(i2, i3, Object.class);
        C5544i0.m22521a((Object) spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    @InterfaceC5816d
    public static final Spanned toSpanned(@InterfaceC5816d CharSequence charSequence) {
        C5544i0.m22546f(charSequence, "$receiver");
        SpannedString valueOf = SpannedString.valueOf(charSequence);
        C5544i0.m22521a((Object) valueOf, "SpannedString.valueOf(this)");
        return valueOf;
    }
}
