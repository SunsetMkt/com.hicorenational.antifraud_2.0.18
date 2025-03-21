package p358k.p359a.p360a.p361a;

import android.content.Context;
import android.text.TextUtils;
import cn.cloudwalk.libproject.util.FileUtil;
import com.hihonor.honorid.p162d.p163a.C2165b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xmlpull.v1.XmlSerializer;
import p031c.p075c.p076a.p081b.p082a.C1192b;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: FileUtil.java */
/* renamed from: k.a.a.a.c */
/* loaded from: classes2.dex */
public class C5849c {

    /* renamed from: a */
    private static FileOutputStream f21131a;

    /* renamed from: b */
    private static FileInputStream f21132b;

    /* renamed from: c */
    private static Properties f21133c;

    /* renamed from: d */
    private static volatile String f21134d;

    /* renamed from: e */
    private static AtomicBoolean f21135e = new AtomicBoolean(false);

    /* renamed from: a */
    public static boolean m24631a(File file) {
        File[] listFiles;
        C5863e.m24692b(FileUtil.TAG, "deleteFile : file.getName", true);
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                m24631a(file2);
            }
        }
        return file.delete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
    
        r3 = com.hihonor.honorid.p162d.p163a.C2165b.m6302a(r9, r3);
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String m24633b(android.content.Context r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p358k.p359a.p360a.p361a.C5849c.m24633b(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: c */
    public static void m24635c(Context context, String str) {
        f21134d = str;
        m24634b(context, "encryptversion", str);
    }

    /* renamed from: a */
    public static boolean m24630a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return m24631a(new File(context.getFilesDir(), str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m24632a(java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            java.lang.String r0 = "IOException "
            java.lang.String r1 = "FileUtil"
            r2 = 0
            if (r7 == 0) goto L98
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            if (r3 != 0) goto L98
            if (r8 == 0) goto L98
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto L98
            if (r9 != 0) goto L19
            goto L98
        L19:
            r3 = 0
            r4 = 1
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            boolean r6 = r5.exists()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            if (r6 != 0) goto L2f
            boolean r5 = r5.mkdirs()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            if (r5 != 0) goto L2f
            return r2
        L2d:
            r7 = move-exception
            goto L8e
        L2f:
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r6.<init>()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r6.append(r7)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r6.append(r8)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            java.lang.String r7 = r6.toString()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L4f java.lang.RuntimeException -> L5b java.io.IOException -> L6b java.io.FileNotFoundException -> L7b
            r7.write(r9)     // Catch: java.lang.Exception -> L50 java.lang.RuntimeException -> L5c java.io.IOException -> L6c java.io.FileNotFoundException -> L7c java.lang.Throwable -> L8b
            r7.close()     // Catch: java.io.IOException -> L67
            goto L6a
        L4f:
            r7 = r3
        L50:
            java.lang.String r8 = "Exception "
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r8, r4)     // Catch: java.lang.Throwable -> L8b
            if (r7 == 0) goto L6a
            r7.close()     // Catch: java.io.IOException -> L67
            goto L6a
        L5b:
            r7 = r3
        L5c:
            java.lang.String r8 = "RuntimeException "
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r8, r4)     // Catch: java.lang.Throwable -> L8b
            if (r7 == 0) goto L6a
            r7.close()     // Catch: java.io.IOException -> L67
            goto L6a
        L67:
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r4)
        L6a:
            return r4
        L6b:
            r7 = r3
        L6c:
            java.lang.String r8 = "writeAgreement IOException"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r8, r4)     // Catch: java.lang.Throwable -> L8b
            if (r7 == 0) goto L7a
            r7.close()     // Catch: java.io.IOException -> L77
            goto L7a
        L77:
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r4)
        L7a:
            return r2
        L7b:
            r7 = r3
        L7c:
            java.lang.String r8 = "writeAgreement FileNotFoundException"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r8, r4)     // Catch: java.lang.Throwable -> L8b
            if (r7 == 0) goto L8a
            r7.close()     // Catch: java.io.IOException -> L87
            goto L8a
        L87:
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r4)
        L8a:
            return r2
        L8b:
            r8 = move-exception
            r3 = r7
            r7 = r8
        L8e:
            if (r3 == 0) goto L97
            r3.close()     // Catch: java.io.IOException -> L94
            goto L97
        L94:
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r1, r0, r4)
        L97:
            throw r7
        L98:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p358k.p359a.p360a.p361a.C5849c.m24632a(java.lang.String, java.lang.String, byte[]):boolean");
    }

    /* renamed from: a */
    public static String m24627a(Context context) {
        if (f21135e.compareAndSet(false, true)) {
            f21134d = m24633b(context, "encryptversion");
        }
        return f21134d;
    }

    /* renamed from: a */
    private static void m24628a(Context context, String str, String str2) {
        String str3;
        File filesDir = context.getFilesDir();
        if (filesDir == null || filesDir.getPath() == null) {
            return;
        }
        if (new File(filesDir.getPath() + "/settings.properties").exists()) {
            FileInputStream openFileInput = context.openFileInput("settings.properties");
            f21132b = openFileInput;
            if (openFileInput != null) {
                f21133c.load(openFileInput);
            } else {
                C5863e.m24692b(FileUtil.TAG, "inStream is null", true);
            }
        }
        f21131a = context.openFileOutput("settings.properties", 0);
        String[] m2282a = C1192b.m2282a();
        int length = m2282a.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str3 = str2;
                break;
            } else {
                if (str.equals(m2282a[i2])) {
                    str3 = C2165b.m6303b(context, str2);
                    break;
                }
                i2++;
            }
        }
        int i3 = 0;
        while (str3.length() > 8388588 && i3 < 3) {
            i3++;
            C5863e.m24692b(FileUtil.TAG, i3 + " mValue.length() is " + str3.length(), true);
            int length2 = m2282a.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    break;
                }
                if (str.equals(m2282a[i4])) {
                    str3 = C2165b.m6303b(context, str2);
                    break;
                }
                i4++;
            }
        }
        if (str3.length() > 8388588) {
            C5863e.m24691a(FileUtil.TAG, "final mValue.length() is " + str3.length(), true);
            return;
        }
        f21133c.setProperty(str, str3);
        FileOutputStream fileOutputStream = f21131a;
        if (fileOutputStream != null) {
            f21133c.store(fileOutputStream, "accountagent");
        } else {
            C5863e.m24692b(FileUtil.TAG, "outStream is null", true);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:24:0x005a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* renamed from: b */
    public static synchronized void m24634b(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.Class<k.a.a.a.c> r0 = p358k.p359a.p360a.p361a.C5849c.class
            monitor-enter(r0)
            r1 = 1
            if (r3 == 0) goto L86
            if (r5 == 0) goto L86
            if (r4 != 0) goto Lc
            goto L86
        Lc:
            r2 = 0
            p358k.p359a.p360a.p361a.C5849c.f21131a = r2     // Catch: java.lang.Throwable -> L8f
            p358k.p359a.p360a.p361a.C5849c.f21132b = r2     // Catch: java.lang.Throwable -> L8f
            java.util.Properties r2 = new java.util.Properties     // Catch: java.lang.Throwable -> L8f
            r2.<init>()     // Catch: java.lang.Throwable -> L8f
            p358k.p359a.p360a.p361a.C5849c.f21133c = r2     // Catch: java.lang.Throwable -> L8f
            m24628a(r3, r4, r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            java.io.FileOutputStream r3 = p358k.p359a.p360a.p361a.C5849c.f21131a     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L8f
            if (r3 == 0) goto L2c
            java.io.FileOutputStream r3 = p358k.p359a.p360a.p361a.C5849c.f21131a     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L8f
            goto L2c
        L25:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "setProperties IOException"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
        L2c:
            java.io.FileInputStream r3 = p358k.p359a.p360a.p361a.C5849c.f21132b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            if (r3 == 0) goto L61
            java.io.FileInputStream r3 = p358k.p359a.p360a.p361a.C5849c.f21132b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            goto L61
        L36:
            r3 = move-exception
            goto L63
        L38:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "IOException"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r3, r4, r1)     // Catch: java.lang.Throwable -> L36
            java.io.FileOutputStream r3 = p358k.p359a.p360a.p361a.C5849c.f21131a     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L8f
            if (r3 == 0) goto L50
            java.io.FileOutputStream r3 = p358k.p359a.p360a.p361a.C5849c.f21131a     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L8f
            goto L50
        L49:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "setProperties IOException"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
        L50:
            java.io.FileInputStream r3 = p358k.p359a.p360a.p361a.C5849c.f21132b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            if (r3 == 0) goto L61
            java.io.FileInputStream r3 = p358k.p359a.p360a.p361a.C5849c.f21132b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            goto L61
        L5a:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "IOException"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
        L61:
            monitor-exit(r0)
            return
        L63:
            java.io.FileOutputStream r4 = p358k.p359a.p360a.p361a.C5849c.f21131a     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8f
            if (r4 == 0) goto L74
            java.io.FileOutputStream r4 = p358k.p359a.p360a.p361a.C5849c.f21131a     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8f
            r4.close()     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8f
            goto L74
        L6d:
            java.lang.String r4 = "FileUtil"
            java.lang.String r5 = "setProperties IOException"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r4, r5, r1)     // Catch: java.lang.Throwable -> L8f
        L74:
            java.io.FileInputStream r4 = p358k.p359a.p360a.p361a.C5849c.f21132b     // Catch: java.io.IOException -> L7e java.lang.Throwable -> L8f
            if (r4 == 0) goto L85
            java.io.FileInputStream r4 = p358k.p359a.p360a.p361a.C5849c.f21132b     // Catch: java.io.IOException -> L7e java.lang.Throwable -> L8f
            r4.close()     // Catch: java.io.IOException -> L7e java.lang.Throwable -> L8f
            goto L85
        L7e:
            java.lang.String r4 = "FileUtil"
            java.lang.String r5 = "IOException"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24691a(r4, r5, r1)     // Catch: java.lang.Throwable -> L8f
        L85:
            throw r3     // Catch: java.lang.Throwable -> L8f
        L86:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "at least 1 param is null"
            p358k.p359a.p360a.p361a.p363j.C5863e.m24692b(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r0)
            return
        L8f:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p358k.p359a.p360a.p361a.C5849c.m24634b(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public static void m24629a(XmlSerializer xmlSerializer, String str, String str2) {
        try {
            xmlSerializer.startTag("", str);
            xmlSerializer.text(str2);
            xmlSerializer.endTag("", str);
        } catch (IOException unused) {
            C5863e.m24691a(FileUtil.TAG, "IOException ", true);
        } catch (IllegalArgumentException unused2) {
            C5863e.m24691a(FileUtil.TAG, "IllegalArgumentException  ", true);
        } catch (IllegalStateException unused3) {
            C5863e.m24691a(FileUtil.TAG, "IllegalStateException ", true);
        } catch (Exception unused4) {
            C5863e.m24691a(FileUtil.TAG, "Exception ", true);
        }
    }
}
