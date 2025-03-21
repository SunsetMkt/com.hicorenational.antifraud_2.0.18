package p286h.p306n2;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p286h.C5226e1;
import p286h.p289g2.C5315y;
import p286h.p289g2.C5318z;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5726c0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: FilePathComponents.kt */
/* renamed from: h.n2.o */
/* loaded from: classes2.dex */
class C5456o {
    /* renamed from: a */
    private static final int m22330a(@InterfaceC5816d String str) {
        boolean m23749b;
        int m23650a;
        int m23650a2 = C5726c0.m23650a((CharSequence) str, File.separatorChar, 0, false, 4, (Object) null);
        if (m23650a2 == 0) {
            if (str.length() > 1) {
                char charAt = str.charAt(1);
                char c2 = File.separatorChar;
                if (charAt == c2 && (m23650a = C5726c0.m23650a((CharSequence) str, c2, 2, false, 4, (Object) null)) >= 0) {
                    int m23650a3 = C5726c0.m23650a((CharSequence) str, File.separatorChar, m23650a + 1, false, 4, (Object) null);
                    return m23650a3 >= 0 ? m23650a3 + 1 : str.length();
                }
            }
            return 1;
        }
        if (m23650a2 > 0 && str.charAt(m23650a2 - 1) == ':') {
            return m23650a2 + 1;
        }
        if (m23650a2 == -1) {
            m23749b = C5726c0.m23749b((CharSequence) str, ':', false, 2, (Object) null);
            if (m23749b) {
                return str.length();
            }
        }
        return 0;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m22333b(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "$this$rootName");
        String path = file.getPath();
        C5544i0.m22521a((Object) path, "path");
        String path2 = file.getPath();
        C5544i0.m22521a((Object) path2, "path");
        int m22330a = m22330a(path2);
        if (path == null) {
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        String substring = path.substring(0, m22330a);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: c */
    public static final boolean m22334c(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "$this$isRooted");
        String path = file.getPath();
        C5544i0.m22521a((Object) path, "path");
        return m22330a(path) > 0;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final C5450i m22335d(@InterfaceC5816d File file) {
        List m23700a;
        List list;
        C5544i0.m22546f(file, "$this$toComponents");
        String path = file.getPath();
        C5544i0.m22521a((Object) path, "path");
        int m22330a = m22330a(path);
        String substring = path.substring(0, m22330a);
        C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String substring2 = path.substring(m22330a);
        C5544i0.m22521a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
        if (substring2.length() == 0) {
            list = C5315y.m21775b();
        } else {
            m23700a = C5726c0.m23700a((CharSequence) substring2, new char[]{File.separatorChar}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(C5318z.m21796a(m23700a, 10));
            Iterator it = m23700a.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new C5450i(new File(substring), list);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final File m22331a(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "$this$root");
        return new File(m22333b(file));
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final File m22332a(@InterfaceC5816d File file, int i2, int i3) {
        C5544i0.m22546f(file, "$this$subPath");
        return m22335d(file).m22309a(i2, i3);
    }
}
