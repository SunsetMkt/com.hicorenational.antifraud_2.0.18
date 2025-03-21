package p286h.p306n2;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.taobao.accs.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5262g0;
import p286h.p289g2.C5309w;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5724b0;
import p286h.p323z2.C5726c0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Utils.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a(\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a(\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006+"}, m23546d2 = {"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", RequestParameters.PREFIX, "suffix", "directory", "createTempFile", "copyRecursively", "", Constants.KEY_TARGET, "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", DispatchConstants.OTHER, "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/io/FilesKt")
/* renamed from: h.n2.r */
/* loaded from: classes2.dex */
class C5459r extends C5458q {

    /* compiled from: Utils.kt */
    /* renamed from: h.n2.r$a */
    static final class a extends AbstractC5547j0 implements InterfaceC5510p {
        public static final a INSTANCE = new a();

        a() {
            super(2);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5510p
        @InterfaceC5816d
        public final Void invoke(@InterfaceC5816d File file, @InterfaceC5816d IOException iOException) {
            C5544i0.m22546f(file, "<anonymous parameter 0>");
            C5544i0.m22546f(iOException, "exception");
            throw iOException;
        }
    }

    /* compiled from: Utils.kt */
    /* renamed from: h.n2.r$b */
    static final class b extends AbstractC5547j0 implements InterfaceC5510p<File, IOException, C5715y1> {
        final /* synthetic */ InterfaceC5510p $onError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC5510p interfaceC5510p) {
            super(2);
            this.$onError = interfaceC5510p;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5510p
        public /* bridge */ /* synthetic */ C5715y1 invoke(File file, IOException iOException) {
            invoke2(file, iOException);
            return C5715y1.f20665a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@InterfaceC5816d File file, @InterfaceC5816d IOException iOException) {
            C5544i0.m22546f(file, "f");
            C5544i0.m22546f(iOException, "e");
            if (((EnumC5462u) this.$onError.invoke(file, iOException)) == EnumC5462u.TERMINATE) {
                throw new C5464w(file);
            }
        }
    }

    /* renamed from: a */
    public static /* synthetic */ File m22373a(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return m22372a(str, str2, file);
    }

    /* renamed from: b */
    public static /* synthetic */ File m22382b(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return m22381b(str, str2, file);
    }

    @InterfaceC5817e
    /* renamed from: c */
    public static final File m22383c(@InterfaceC5816d File file, @InterfaceC5816d File file2) {
        C5544i0.m22546f(file, "$this$relativeToOrNull");
        C5544i0.m22546f(file2, "base");
        String m22393i = m22393i(file, file2);
        if (m22393i != null) {
            return new File(m22393i);
        }
        return null;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final File m22385d(@InterfaceC5816d File file, @InterfaceC5816d File file2) {
        C5544i0.m22546f(file, "$this$relativeToOrSelf");
        C5544i0.m22546f(file2, "base");
        String m22393i = m22393i(file, file2);
        return m22393i != null ? new File(m22393i) : file;
    }

    @InterfaceC5816d
    /* renamed from: e */
    public static final File m22387e(@InterfaceC5816d File file, @InterfaceC5816d File file2) {
        boolean m23749b;
        C5544i0.m22546f(file, "$this$resolve");
        C5544i0.m22546f(file2, "relative");
        if (C5456o.m22334c(file2)) {
            return file2;
        }
        String file3 = file.toString();
        C5544i0.m22521a((Object) file3, "this.toString()");
        if (!(file3.length() == 0)) {
            m23749b = C5726c0.m23749b((CharSequence) file3, File.separatorChar, false, 2, (Object) null);
            if (!m23749b) {
                return new File(file3 + File.separatorChar + file2);
            }
        }
        return new File(file3 + file2);
    }

    @InterfaceC5816d
    /* renamed from: f */
    public static final File m22388f(@InterfaceC5816d File file, @InterfaceC5816d File file2) {
        C5544i0.m22546f(file, "$this$resolveSibling");
        C5544i0.m22546f(file2, "relative");
        C5450i m22335d = C5456o.m22335d(file);
        return m22387e(m22387e(m22335d.m22311c(), m22335d.m22314f() == 0 ? new File("..") : m22335d.m22309a(0, m22335d.m22314f() - 1)), file2);
    }

    /* renamed from: g */
    public static final boolean m22389g(@InterfaceC5816d File file, @InterfaceC5816d File file2) {
        C5544i0.m22546f(file, "$this$startsWith");
        C5544i0.m22546f(file2, DispatchConstants.OTHER);
        C5450i m22335d = C5456o.m22335d(file);
        C5450i m22335d2 = C5456o.m22335d(file2);
        if (!(!C5544i0.m22531a(m22335d.m22311c(), m22335d2.m22311c())) && m22335d.m22314f() >= m22335d2.m22314f()) {
            return m22335d.m22313e().subList(0, m22335d2.m22314f()).equals(m22335d2.m22313e());
        }
        return false;
    }

    @InterfaceC5816d
    /* renamed from: h */
    public static final String m22390h(@InterfaceC5816d File file, @InterfaceC5816d File file2) {
        C5544i0.m22546f(file, "$this$toRelativeString");
        C5544i0.m22546f(file2, "base");
        String m22393i = m22393i(file, file2);
        if (m22393i != null) {
            return m22393i;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + '.');
    }

    @InterfaceC5816d
    /* renamed from: i */
    public static final String m22392i(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "$this$extension");
        String name = file.getName();
        C5544i0.m22521a((Object) name, CommonNetImpl.NAME);
        return C5726c0.m23734b(name, '.', "");
    }

    @InterfaceC5816d
    /* renamed from: j */
    public static final String m22394j(@InterfaceC5816d File file) {
        String m23578a;
        C5544i0.m22546f(file, "$this$invariantSeparatorsPath");
        if (File.separatorChar == '/') {
            String path = file.getPath();
            C5544i0.m22521a((Object) path, "path");
            return path;
        }
        String path2 = file.getPath();
        C5544i0.m22521a((Object) path2, "path");
        m23578a = C5724b0.m23578a(path2, File.separatorChar, '/', false, 4, (Object) null);
        return m23578a;
    }

    @InterfaceC5816d
    /* renamed from: k */
    public static final String m22395k(@InterfaceC5816d File file) {
        String m23789e;
        C5544i0.m22546f(file, "$this$nameWithoutExtension");
        String name = file.getName();
        C5544i0.m22521a((Object) name, CommonNetImpl.NAME);
        m23789e = C5726c0.m23789e(name, ".", (String) null, 2, (Object) null);
        return m23789e;
    }

    @InterfaceC5816d
    /* renamed from: l */
    public static final File m22396l(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "$this$normalize");
        C5450i m22335d = C5456o.m22335d(file);
        File m22311c = m22335d.m22311c();
        List<File> m22374a = m22374a(m22335d.m22313e());
        String str = File.separator;
        C5544i0.m22521a((Object) str, "File.separator");
        return m22380b(m22311c, C5262g0.m19786a(m22374a, str, null, null, 0, null, null, 62, null));
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final File m22372a(@InterfaceC5816d String str, @InterfaceC5817e String str2, @InterfaceC5817e File file) {
        C5544i0.m22546f(str, RequestParameters.PREFIX);
        File createTempFile = File.createTempFile(str, str2, file);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            C5544i0.m22521a((Object) createTempFile, "dir");
            return createTempFile;
        }
        throw new IOException("Unable to create temporary directory " + createTempFile + '.');
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final File m22381b(@InterfaceC5816d String str, @InterfaceC5817e String str2, @InterfaceC5817e File file) {
        C5544i0.m22546f(str, RequestParameters.PREFIX);
        File createTempFile = File.createTempFile(str, str2, file);
        C5544i0.m22521a((Object) createTempFile, "File.createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final File m22384c(@InterfaceC5816d File file, @InterfaceC5816d String str) {
        C5544i0.m22546f(file, "$this$resolveSibling");
        C5544i0.m22546f(str, "relative");
        return m22388f(file, new File(str));
    }

    /* renamed from: d */
    public static final boolean m22386d(@InterfaceC5816d File file, @InterfaceC5816d String str) {
        C5544i0.m22546f(file, "$this$startsWith");
        C5544i0.m22546f(str, DispatchConstants.OTHER);
        return m22389g(file, new File(str));
    }

    /* renamed from: h */
    public static final boolean m22391h(@InterfaceC5816d File file) {
        C5544i0.m22546f(file, "$this$deleteRecursively");
        while (true) {
            boolean z = true;
            for (File file2 : C5458q.m22367e(file)) {
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

    /* renamed from: i */
    private static final String m22393i(@InterfaceC5816d File file, File file2) {
        List m19839c;
        C5450i m22369a = m22369a(C5456o.m22335d(file));
        C5450i m22369a2 = m22369a(C5456o.m22335d(file2));
        if (!C5544i0.m22531a(m22369a.m22311c(), m22369a2.m22311c())) {
            return null;
        }
        int m22314f = m22369a2.m22314f();
        int m22314f2 = m22369a.m22314f();
        int i2 = 0;
        int min = Math.min(m22314f2, m22314f);
        while (i2 < min && C5544i0.m22531a(m22369a.m22313e().get(i2), m22369a2.m22313e().get(i2))) {
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = m22314f - 1;
        if (i3 >= i2) {
            while (!C5544i0.m22531a((Object) m22369a2.m22313e().get(i3).getName(), (Object) "..")) {
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
        if (i2 < m22314f2) {
            if (i2 < m22314f) {
                sb.append(File.separatorChar);
            }
            m19839c = C5262g0.m19839c((Iterable) m22369a.m22313e(), i2);
            String str = File.separator;
            C5544i0.m22521a((Object) str, "File.separator");
            C5309w.m21715a(m19839c, sb, str, null, null, 0, null, null, 124, null);
        }
        return sb.toString();
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final File m22379b(@InterfaceC5816d File file, @InterfaceC5816d File file2) {
        C5544i0.m22546f(file, "$this$relativeTo");
        C5544i0.m22546f(file2, "base");
        return new File(m22390h(file, file2));
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final File m22380b(@InterfaceC5816d File file, @InterfaceC5816d String str) {
        C5544i0.m22546f(file, "$this$resolve");
        C5544i0.m22546f(str, "relative");
        return m22387e(file, new File(str));
    }

    /* renamed from: a */
    public static /* synthetic */ File m22371a(File file, File file2, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 8192;
        }
        return m22370a(file, file2, z, i2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final File m22370a(@InterfaceC5816d File file, @InterfaceC5816d File file2, boolean z, int i2) {
        C5544i0.m22546f(file, "$this$copyTo");
        C5544i0.m22546f(file2, Constants.KEY_TARGET);
        if (file.exists()) {
            if (file2.exists()) {
                if (z) {
                    if (!file2.delete()) {
                        throw new C5449h(file, file2, "Tried to overwrite the destination, but failed to delete it.");
                    }
                } else {
                    throw new C5449h(file, file2, "The destination file already exists.");
                }
            }
            if (file.isDirectory()) {
                if (!file2.mkdirs()) {
                    throw new C5451j(file, file2, "Failed to create target directory.");
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
                        C5443b.m22245a(fileInputStream, fileOutputStream, i2);
                        C5444c.m22275a(fileOutputStream, (Throwable) null);
                        C5444c.m22275a(fileInputStream, (Throwable) null);
                    } finally {
                    }
                } finally {
                }
            }
            return file2;
        }
        throw new C5461t(file, null, "The source file doesn't exist.", 2, null);
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m22377a(File file, File file2, boolean z, InterfaceC5510p interfaceC5510p, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            interfaceC5510p = a.INSTANCE;
        }
        return m22376a(file, file2, z, (InterfaceC5510p<? super File, ? super IOException, ? extends EnumC5462u>) interfaceC5510p);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a0 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean m22376a(@p324i.p336c.p337a.InterfaceC5816d java.io.File r11, @p324i.p336c.p337a.InterfaceC5816d java.io.File r12, boolean r13, @p324i.p336c.p337a.InterfaceC5816d p286h.p309q2.p310s.InterfaceC5510p<? super java.io.File, ? super java.io.IOException, ? extends p286h.p306n2.EnumC5462u> r14) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p286h.p306n2.C5459r.m22376a(java.io.File, java.io.File, boolean, h.q2.s.p):boolean");
    }

    /* renamed from: a */
    public static final boolean m22375a(@InterfaceC5816d File file, @InterfaceC5816d File file2) {
        C5544i0.m22546f(file, "$this$endsWith");
        C5544i0.m22546f(file2, DispatchConstants.OTHER);
        C5450i m22335d = C5456o.m22335d(file);
        C5450i m22335d2 = C5456o.m22335d(file2);
        if (m22335d2.m22315g()) {
            return C5544i0.m22531a(file, file2);
        }
        int m22314f = m22335d.m22314f() - m22335d2.m22314f();
        if (m22314f < 0) {
            return false;
        }
        return m22335d.m22313e().subList(m22314f, m22335d.m22314f()).equals(m22335d2.m22313e());
    }

    /* renamed from: a */
    public static final boolean m22378a(@InterfaceC5816d File file, @InterfaceC5816d String str) {
        C5544i0.m22546f(file, "$this$endsWith");
        C5544i0.m22546f(str, DispatchConstants.OTHER);
        return m22375a(file, new File(str));
    }

    /* renamed from: a */
    private static final C5450i m22369a(@InterfaceC5816d C5450i c5450i) {
        return new C5450i(c5450i.m22311c(), m22374a(c5450i.m22313e()));
    }

    /* renamed from: a */
    private static final List<File> m22374a(@InterfaceC5816d List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != 46) {
                    if (hashCode == 1472 && name.equals("..")) {
                        if (arrayList.isEmpty() || !(!C5544i0.m22531a((Object) ((File) C5309w.m21735r((List) arrayList)).getName(), (Object) ".."))) {
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
