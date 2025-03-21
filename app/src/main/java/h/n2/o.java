package h.n2;

import h.e1;
import h.g2.y;
import h.g2.z;
import h.q2.t.i0;
import h.z2.c0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FilePathComponents.kt */
/* loaded from: classes2.dex */
class o {
    private static final int a(@i.c.a.d String str) {
        boolean b2;
        int a2;
        int a3 = c0.a((CharSequence) str, File.separatorChar, 0, false, 4, (Object) null);
        if (a3 == 0) {
            if (str.length() > 1) {
                char charAt = str.charAt(1);
                char c2 = File.separatorChar;
                if (charAt == c2 && (a2 = c0.a((CharSequence) str, c2, 2, false, 4, (Object) null)) >= 0) {
                    int a4 = c0.a((CharSequence) str, File.separatorChar, a2 + 1, false, 4, (Object) null);
                    return a4 >= 0 ? a4 + 1 : str.length();
                }
            }
            return 1;
        }
        if (a3 > 0 && str.charAt(a3 - 1) == ':') {
            return a3 + 1;
        }
        if (a3 == -1) {
            b2 = c0.b((CharSequence) str, ':', false, 2, (Object) null);
            if (b2) {
                return str.length();
            }
        }
        return 0;
    }

    @i.c.a.d
    public static final String b(@i.c.a.d File file) {
        i0.f(file, "$this$rootName");
        String path = file.getPath();
        i0.a((Object) path, "path");
        String path2 = file.getPath();
        i0.a((Object) path2, "path");
        int a2 = a(path2);
        if (path == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String substring = path.substring(0, a2);
        i0.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean c(@i.c.a.d File file) {
        i0.f(file, "$this$isRooted");
        String path = file.getPath();
        i0.a((Object) path, "path");
        return a(path) > 0;
    }

    @i.c.a.d
    public static final i d(@i.c.a.d File file) {
        List a2;
        List list;
        i0.f(file, "$this$toComponents");
        String path = file.getPath();
        i0.a((Object) path, "path");
        int a3 = a(path);
        String substring = path.substring(0, a3);
        i0.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String substring2 = path.substring(a3);
        i0.a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
        if (substring2.length() == 0) {
            list = y.b();
        } else {
            a2 = c0.a((CharSequence) substring2, new char[]{File.separatorChar}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(z.a(a2, 10));
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new i(new File(substring), list);
    }

    @i.c.a.d
    public static final File a(@i.c.a.d File file) {
        i0.f(file, "$this$root");
        return new File(b(file));
    }

    @i.c.a.d
    public static final File a(@i.c.a.d File file, int i2, int i3) {
        i0.f(file, "$this$subPath");
        return d(file).a(i2, i3);
    }
}
