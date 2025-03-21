package p286h.p323z2;

import p286h.InterfaceC5339j;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: StringBuilderJVM.kt */
/* renamed from: h.z2.x */
/* loaded from: classes2.dex */
class C5753x extends C5752w {
    @InterfaceC5426f
    /* renamed from: a */
    private static final void m24116a(@InterfaceC5816d StringBuilder sb, int i2, char c2) {
        C5544i0.m22546f(sb, "$this$set");
        sb.setCharAt(i2, c2);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: b */
    public static final StringBuilder m24119b(@InterfaceC5816d StringBuilder sb) {
        C5544i0.m22546f(sb, "$this$clear");
        sb.setLength(0);
        return sb;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final StringBuilder m24102a(@InterfaceC5816d StringBuilder sb, int i2, int i3, String str) {
        StringBuilder replace = sb.replace(i2, i3, str);
        C5544i0.m22521a((Object) replace, "this.replace(startIndex, endIndex, value)");
        return replace;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    private static final StringBuilder m24120b(@InterfaceC5816d StringBuilder sb, int i2) {
        StringBuilder deleteCharAt = sb.deleteCharAt(i2);
        C5544i0.m22521a((Object) deleteCharAt, "this.deleteCharAt(index)");
        return deleteCharAt;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final StringBuilder m24101a(@InterfaceC5816d StringBuilder sb, int i2, int i3) {
        StringBuilder delete = sb.delete(i2, i3);
        C5544i0.m22521a((Object) delete, "this.delete(startIndex, endIndex)");
        return delete;
    }

    /* renamed from: a */
    static /* synthetic */ void m24118a(StringBuilder sb, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = sb.length();
        }
        sb.getChars(i3, i4, cArr, i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final void m24117a(@InterfaceC5816d StringBuilder sb, char[] cArr, int i2, int i3, int i4) {
        sb.getChars(i3, i4, cArr, i2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final StringBuilder m24115a(@InterfaceC5816d StringBuilder sb, char[] cArr, int i2, int i3) {
        sb.append(cArr, i2, i3 - i2);
        C5544i0.m22521a((Object) sb, "this.append(value, start…x, endIndex - startIndex)");
        return sb;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final StringBuilder m24107a(@InterfaceC5816d StringBuilder sb, CharSequence charSequence, int i2, int i3) {
        sb.append(charSequence, i2, i3);
        C5544i0.m22521a((Object) sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final StringBuilder m24104a(@InterfaceC5816d StringBuilder sb, int i2, char[] cArr, int i3, int i4) {
        StringBuilder insert = sb.insert(i2, cArr, i3, i4 - i3);
        C5544i0.m22521a((Object) insert, "this.insert(index, value…x, endIndex - startIndex)");
        return insert;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final StringBuilder m24103a(@InterfaceC5816d StringBuilder sb, int i2, CharSequence charSequence, int i3, int i4) {
        StringBuilder insert = sb.insert(i2, charSequence, i3, i4);
        C5544i0.m22521a((Object) insert, "this.insert(index, value, startIndex, endIndex)");
        return insert;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final Appendable m24092a(@InterfaceC5816d Appendable appendable) {
        C5544i0.m22546f(appendable, "$this$appendln");
        Appendable append = appendable.append(C5732f0.f20686a);
        C5544i0.m22521a((Object) append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final Appendable m24094a(@InterfaceC5816d Appendable appendable, CharSequence charSequence) {
        Appendable append = appendable.append(charSequence);
        C5544i0.m22521a((Object) append, "append(value)");
        return m24092a(append);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final Appendable m24093a(@InterfaceC5816d Appendable appendable, char c2) {
        Appendable append = appendable.append(c2);
        C5544i0.m22521a((Object) append, "append(value)");
        return m24092a(append);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final StringBuilder m24095a(@InterfaceC5816d StringBuilder sb) {
        C5544i0.m22546f(sb, "$this$appendln");
        sb.append(C5732f0.f20686a);
        C5544i0.m22521a((Object) sb, "append(SystemProperties.LINE_SEPARATOR)");
        return sb;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24110a(@InterfaceC5816d StringBuilder sb, StringBuffer stringBuffer) {
        sb.append(stringBuffer);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24106a(@InterfaceC5816d StringBuilder sb, CharSequence charSequence) {
        sb.append(charSequence);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24109a(@InterfaceC5816d StringBuilder sb, String str) {
        sb.append(str);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24108a(@InterfaceC5816d StringBuilder sb, Object obj) {
        sb.append(obj);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24111a(@InterfaceC5816d StringBuilder sb, StringBuilder sb2) {
        sb.append((CharSequence) sb2);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24114a(@InterfaceC5816d StringBuilder sb, char[] cArr) {
        sb.append(cArr);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24097a(@InterfaceC5816d StringBuilder sb, char c2) {
        sb.append(c2);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24113a(@InterfaceC5816d StringBuilder sb, boolean z) {
        sb.append(z);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24100a(@InterfaceC5816d StringBuilder sb, int i2) {
        sb.append(i2);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24112a(@InterfaceC5816d StringBuilder sb, short s) {
        sb.append((int) s);
        C5544i0.m22521a((Object) sb, "append(value.toInt())");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24096a(@InterfaceC5816d StringBuilder sb, byte b2) {
        sb.append((int) b2);
        C5544i0.m22521a((Object) sb, "append(value.toInt())");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24105a(@InterfaceC5816d StringBuilder sb, long j2) {
        sb.append(j2);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24099a(@InterfaceC5816d StringBuilder sb, float f2) {
        sb.append(f2);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final StringBuilder m24098a(@InterfaceC5816d StringBuilder sb, double d2) {
        sb.append(d2);
        C5544i0.m22521a((Object) sb, "append(value)");
        return m24095a(sb);
    }
}
