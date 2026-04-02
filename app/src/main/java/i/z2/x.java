package i.z2;

import i.t0;
import java.io.IOException;

/* JADX INFO: compiled from: StringBuilderJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
class x extends w {
    @i.m2.f
    private static final void a(@j.c.a.d StringBuilder sb, int i2, char c2) {
        i.q2.t.i0.f(sb, "$this$set");
        sb.setCharAt(i2, c2);
    }

    @t0(version = "1.3")
    @j.c.a.d
    public static final StringBuilder b(@j.c.a.d StringBuilder sb) {
        i.q2.t.i0.f(sb, "$this$clear");
        sb.setLength(0);
        return sb;
    }

    @i.j
    @t0(version = "1.3")
    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, int i2, int i3, String str) {
        StringBuilder sbReplace = sb.replace(i2, i3, str);
        i.q2.t.i0.a((Object) sbReplace, "this.replace(startIndex, endIndex, value)");
        return sbReplace;
    }

    @i.j
    @t0(version = "1.3")
    @i.m2.f
    private static final StringBuilder b(@j.c.a.d StringBuilder sb, int i2) {
        StringBuilder sbDeleteCharAt = sb.deleteCharAt(i2);
        i.q2.t.i0.a((Object) sbDeleteCharAt, "this.deleteCharAt(index)");
        return sbDeleteCharAt;
    }

    @i.j
    @t0(version = "1.3")
    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, int i2, int i3) {
        StringBuilder sbDelete = sb.delete(i2, i3);
        i.q2.t.i0.a((Object) sbDelete, "this.delete(startIndex, endIndex)");
        return sbDelete;
    }

    static /* synthetic */ void a(StringBuilder sb, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
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

    @i.j
    @t0(version = "1.3")
    @i.m2.f
    private static final void a(@j.c.a.d StringBuilder sb, char[] cArr, int i2, int i3, int i4) {
        sb.getChars(i3, i4, cArr, i2);
    }

    @i.j
    @t0(version = "1.3")
    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, char[] cArr, int i2, int i3) {
        sb.append(cArr, i2, i3 - i2);
        i.q2.t.i0.a((Object) sb, "this.append(value, start\u2026x, endIndex - startIndex)");
        return sb;
    }

    @i.j
    @t0(version = "1.3")
    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, CharSequence charSequence, int i2, int i3) {
        sb.append(charSequence, i2, i3);
        i.q2.t.i0.a((Object) sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @i.j
    @t0(version = "1.3")
    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, int i2, char[] cArr, int i3, int i4) {
        StringBuilder sbInsert = sb.insert(i2, cArr, i3, i4 - i3);
        i.q2.t.i0.a((Object) sbInsert, "this.insert(index, value\u2026x, endIndex - startIndex)");
        return sbInsert;
    }

    @i.j
    @t0(version = "1.3")
    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, int i2, CharSequence charSequence, int i3, int i4) {
        StringBuilder sbInsert = sb.insert(i2, charSequence, i3, i4);
        i.q2.t.i0.a((Object) sbInsert, "this.insert(index, value, startIndex, endIndex)");
        return sbInsert;
    }

    @j.c.a.d
    public static final Appendable a(@j.c.a.d Appendable appendable) throws IOException {
        i.q2.t.i0.f(appendable, "$this$appendln");
        Appendable appendableAppend = appendable.append(f0.a);
        i.q2.t.i0.a((Object) appendableAppend, "append(SystemProperties.LINE_SEPARATOR)");
        return appendableAppend;
    }

    @i.m2.f
    private static final Appendable a(@j.c.a.d Appendable appendable, CharSequence charSequence) throws IOException {
        Appendable appendableAppend = appendable.append(charSequence);
        i.q2.t.i0.a((Object) appendableAppend, "append(value)");
        return a(appendableAppend);
    }

    @i.m2.f
    private static final Appendable a(@j.c.a.d Appendable appendable, char c2) throws IOException {
        Appendable appendableAppend = appendable.append(c2);
        i.q2.t.i0.a((Object) appendableAppend, "append(value)");
        return a(appendableAppend);
    }

    @j.c.a.d
    public static final StringBuilder a(@j.c.a.d StringBuilder sb) {
        i.q2.t.i0.f(sb, "$this$appendln");
        sb.append(f0.a);
        i.q2.t.i0.a((Object) sb, "append(SystemProperties.LINE_SEPARATOR)");
        return sb;
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, StringBuffer stringBuffer) {
        sb.append(stringBuffer);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, CharSequence charSequence) {
        sb.append(charSequence);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, String str) {
        sb.append(str);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, Object obj) {
        sb.append(obj);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, StringBuilder sb2) {
        sb.append((CharSequence) sb2);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, char[] cArr) {
        sb.append(cArr);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, char c2) {
        sb.append(c2);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, boolean z) {
        sb.append(z);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, int i2) {
        sb.append(i2);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, short s) {
        sb.append((int) s);
        i.q2.t.i0.a((Object) sb, "append(value.toInt())");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, byte b2) {
        sb.append((int) b2);
        i.q2.t.i0.a((Object) sb, "append(value.toInt())");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, long j2) {
        sb.append(j2);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, float f2) {
        sb.append(f2);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @i.m2.f
    private static final StringBuilder a(@j.c.a.d StringBuilder sb, double d2) {
        sb.append(d2);
        i.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }
}
