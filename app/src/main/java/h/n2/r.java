package h.n2;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.taobao.accs.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.g2.g0;
import h.q2.t.i0;
import h.q2.t.j0;
import h.y;
import h.y1;
import h.z2.b0;
import h.z2.c0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Utils.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a(\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a(\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006+"}, d2 = {"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", RequestParameters.PREFIX, "suffix", "directory", "createTempFile", "copyRecursively", "", Constants.KEY_TARGET, "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", DispatchConstants.OTHER, "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/io/FilesKt")
/* loaded from: classes2.dex */
class r extends q {

    /* compiled from: Utils.kt */
    static final class a extends j0 implements h.q2.s.p {
        public static final a INSTANCE = new a();

        a() {
            super(2);
        }

        @Override // h.q2.s.p
        @i.c.a.d
        public final Void invoke(@i.c.a.d File file, @i.c.a.d IOException iOException) {
            i0.f(file, "<anonymous parameter 0>");
            i0.f(iOException, "exception");
            throw iOException;
        }
    }

    /* compiled from: Utils.kt */
    static final class b extends j0 implements h.q2.s.p<File, IOException, y1> {
        final /* synthetic */ h.q2.s.p $onError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(h.q2.s.p pVar) {
            super(2);
            this.$onError = pVar;
        }

        @Override // h.q2.s.p
        public /* bridge */ /* synthetic */ y1 invoke(File file, IOException iOException) {
            invoke2(file, iOException);
            return y1.f16671a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@i.c.a.d File file, @i.c.a.d IOException iOException) {
            i0.f(file, "f");
            i0.f(iOException, "e");
            if (((u) this.$onError.invoke(file, iOException)) == u.TERMINATE) {
                throw new w(file);
            }
        }
    }

    public static /* synthetic */ File a(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return a(str, str2, file);
    }

    public static /* synthetic */ File b(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return b(str, str2, file);
    }

    @i.c.a.e
    public static final File c(@i.c.a.d File file, @i.c.a.d File file2) {
        i0.f(file, "$this$relativeToOrNull");
        i0.f(file2, "base");
        String i2 = i(file, file2);
        if (i2 != null) {
            return new File(i2);
        }
        return null;
    }

    @i.c.a.d
    public static final File d(@i.c.a.d File file, @i.c.a.d File file2) {
        i0.f(file, "$this$relativeToOrSelf");
        i0.f(file2, "base");
        String i2 = i(file, file2);
        return i2 != null ? new File(i2) : file;
    }

    @i.c.a.d
    public static final File e(@i.c.a.d File file, @i.c.a.d File file2) {
        boolean b2;
        i0.f(file, "$this$resolve");
        i0.f(file2, "relative");
        if (o.c(file2)) {
            return file2;
        }
        String file3 = file.toString();
        i0.a((Object) file3, "this.toString()");
        if (!(file3.length() == 0)) {
            b2 = c0.b((CharSequence) file3, File.separatorChar, false, 2, (Object) null);
            if (!b2) {
                return new File(file3 + File.separatorChar + file2);
            }
        }
        return new File(file3 + file2);
    }

    @i.c.a.d
    public static final File f(@i.c.a.d File file, @i.c.a.d File file2) {
        i0.f(file, "$this$resolveSibling");
        i0.f(file2, "relative");
        i d2 = o.d(file);
        return e(e(d2.c(), d2.f() == 0 ? new File("..") : d2.a(0, d2.f() - 1)), file2);
    }

    public static final boolean g(@i.c.a.d File file, @i.c.a.d File file2) {
        i0.f(file, "$this$startsWith");
        i0.f(file2, DispatchConstants.OTHER);
        i d2 = o.d(file);
        i d3 = o.d(file2);
        if (!(!i0.a(d2.c(), d3.c())) && d2.f() >= d3.f()) {
            return d2.e().subList(0, d3.f()).equals(d3.e());
        }
        return false;
    }

    @i.c.a.d
    public static final String h(@i.c.a.d File file, @i.c.a.d File file2) {
        i0.f(file, "$this$toRelativeString");
        i0.f(file2, "base");
        String i2 = i(file, file2);
        if (i2 != null) {
            return i2;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + '.');
    }

    @i.c.a.d
    public static final String i(@i.c.a.d File file) {
        i0.f(file, "$this$extension");
        String name = file.getName();
        i0.a((Object) name, CommonNetImpl.NAME);
        return c0.b(name, '.', "");
    }

    @i.c.a.d
    public static final String j(@i.c.a.d File file) {
        String a2;
        i0.f(file, "$this$invariantSeparatorsPath");
        if (File.separatorChar == '/') {
            String path = file.getPath();
            i0.a((Object) path, "path");
            return path;
        }
        String path2 = file.getPath();
        i0.a((Object) path2, "path");
        a2 = b0.a(path2, File.separatorChar, '/', false, 4, (Object) null);
        return a2;
    }

    @i.c.a.d
    public static final String k(@i.c.a.d File file) {
        String e2;
        i0.f(file, "$this$nameWithoutExtension");
        String name = file.getName();
        i0.a((Object) name, CommonNetImpl.NAME);
        e2 = c0.e(name, ".", (String) null, 2, (Object) null);
        return e2;
    }

    @i.c.a.d
    public static final File l(@i.c.a.d File file) {
        i0.f(file, "$this$normalize");
        i d2 = o.d(file);
        File c2 = d2.c();
        List<File> a2 = a(d2.e());
        String str = File.separator;
        i0.a((Object) str, "File.separator");
        return b(c2, g0.a(a2, str, null, null, 0, null, null, 62, null));
    }

    @i.c.a.d
    public static final File a(@i.c.a.d String str, @i.c.a.e String str2, @i.c.a.e File file) {
        i0.f(str, RequestParameters.PREFIX);
        File createTempFile = File.createTempFile(str, str2, file);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            i0.a((Object) createTempFile, "dir");
            return createTempFile;
        }
        throw new IOException("Unable to create temporary directory " + createTempFile + '.');
    }

    @i.c.a.d
    public static final File b(@i.c.a.d String str, @i.c.a.e String str2, @i.c.a.e File file) {
        i0.f(str, RequestParameters.PREFIX);
        File createTempFile = File.createTempFile(str, str2, file);
        i0.a((Object) createTempFile, "File.createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    @i.c.a.d
    public static final File c(@i.c.a.d File file, @i.c.a.d String str) {
        i0.f(file, "$this$resolveSibling");
        i0.f(str, "relative");
        return f(file, new File(str));
    }

    public static final boolean d(@i.c.a.d File file, @i.c.a.d String str) {
        i0.f(file, "$this$startsWith");
        i0.f(str, DispatchConstants.OTHER);
        return g(file, new File(str));
    }

    public static final boolean h(@i.c.a.d File file) {
        i0.f(file, "$this$deleteRecursively");
        while (true) {
            boolean z = true;
            for (File file2 : q.e(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                        break;
                    }
                }
                z = false;
            }
            return z;
        }
    }

    private static final String i(@i.c.a.d File file, File file2) {
        List c2;
        i a2 = a(o.d(file));
        i a3 = a(o.d(file2));
        if (!i0.a(a2.c(), a3.c())) {
            return null;
        }
        int f2 = a3.f();
        int f3 = a2.f();
        int i2 = 0;
        int min = Math.min(f3, f2);
        while (i2 < min && i0.a(a2.e().get(i2), a3.e().get(i2))) {
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = f2 - 1;
        if (i3 >= i2) {
            while (!i0.a((Object) a3.e().get(i3).getName(), (Object) "..")) {
                sb.append("..");
                if (i3 != i2) {
                    sb.append(File.separatorChar);
                }
                if (i3 != i2) {
                    i3--;
                }
            }
            return null;
        }
        if (i2 < f3) {
            if (i2 < f2) {
                sb.append(File.separatorChar);
            }
            c2 = g0.c((Iterable) a2.e(), i2);
            String str = File.separator;
            i0.a((Object) str, "File.separator");
            h.g2.w.a(c2, sb, str, null, null, 0, null, null, 124, null);
        }
        return sb.toString();
    }

    @i.c.a.d
    public static final File b(@i.c.a.d File file, @i.c.a.d File file2) {
        i0.f(file, "$this$relativeTo");
        i0.f(file2, "base");
        return new File(h(file, file2));
    }

    @i.c.a.d
    public static final File b(@i.c.a.d File file, @i.c.a.d String str) {
        i0.f(file, "$this$resolve");
        i0.f(str, "relative");
        return e(file, new File(str));
    }

    public static /* synthetic */ File a(File file, File file2, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 8192;
        }
        return a(file, file2, z, i2);
    }

    @i.c.a.d
    public static final File a(@i.c.a.d File file, @i.c.a.d File file2, boolean z, int i2) {
        i0.f(file, "$this$copyTo");
        i0.f(file2, Constants.KEY_TARGET);
        if (file.exists()) {
            if (file2.exists()) {
                if (z) {
                    if (!file2.delete()) {
                        throw new h(file, file2, "Tried to overwrite the destination, but failed to delete it.");
                    }
                } else {
                    throw new h(file, file2, "The destination file already exists.");
                }
            }
            if (file.isDirectory()) {
                if (!file2.mkdirs()) {
                    throw new j(file, file2, "Failed to create target directory.");
                }
            } else {
                File parentFile = file2.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        h.n2.b.a(fileInputStream, fileOutputStream, i2);
                        c.a(fileOutputStream, (Throwable) null);
                        c.a(fileInputStream, (Throwable) null);
                    } finally {
                    }
                } finally {
                }
            }
            return file2;
        }
        throw new t(file, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ boolean a(File file, File file2, boolean z, h.q2.s.p pVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            pVar = a.INSTANCE;
        }
        return a(file, file2, z, (h.q2.s.p<? super File, ? super IOException, ? extends u>) pVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean a(@i.c.a.d java.io.File r11, @i.c.a.d java.io.File r12, boolean r13, @i.c.a.d h.q2.s.p<? super java.io.File, ? super java.io.IOException, ? extends h.n2.u> r14) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h.n2.r.a(java.io.File, java.io.File, boolean, h.q2.s.p):boolean");
    }

    public static final boolean a(@i.c.a.d File file, @i.c.a.d File file2) {
        i0.f(file, "$this$endsWith");
        i0.f(file2, DispatchConstants.OTHER);
        i d2 = o.d(file);
        i d3 = o.d(file2);
        if (d3.g()) {
            return i0.a(file, file2);
        }
        int f2 = d2.f() - d3.f();
        if (f2 < 0) {
            return false;
        }
        return d2.e().subList(f2, d2.f()).equals(d3.e());
    }

    public static final boolean a(@i.c.a.d File file, @i.c.a.d String str) {
        i0.f(file, "$this$endsWith");
        i0.f(str, DispatchConstants.OTHER);
        return a(file, new File(str));
    }

    private static final i a(@i.c.a.d i iVar) {
        return new i(iVar.c(), a(iVar.e()));
    }

    private static final List<File> a(@i.c.a.d List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != 46) {
                    if (hashCode == 1472 && name.equals("..")) {
                        if (arrayList.isEmpty() || !(!i0.a((Object) ((File) h.g2.w.r((List) arrayList)).getName(), (Object) ".."))) {
                            arrayList.add(file);
                        } else {
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                } else if (name.equals(".")) {
                }
            }
            arrayList.add(file);
        }
        return arrayList;
    }
}
