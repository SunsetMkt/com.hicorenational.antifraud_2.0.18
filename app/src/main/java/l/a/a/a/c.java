package l.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import cn.cloudwalk.libproject.util.FileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: FileUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static FileOutputStream a;

    /* JADX INFO: renamed from: b */
    private static FileInputStream f12664b;

    /* JADX INFO: renamed from: c */
    private static Properties f12665c;

    /* JADX INFO: renamed from: d */
    private static volatile String f12666d;

    /* JADX INFO: renamed from: e */
    private static AtomicBoolean f12667e = new AtomicBoolean(false);

    public static boolean a(File file) {
        File[] fileArrListFiles;
        l.a.a.a.j.e.b(FileUtil.TAG, "deleteFile : file.getName", true);
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        return file.delete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x0084, code lost:
    
        r3 = com.hihonor.honorid.d.a.b.a(r9, r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:? A[Catch: all -> 0x00f0, DONT_GENERATE, FINALLY_INSNS, SYNTHETIC, TRY_LEAVE, TryCatch #10 {, blocks: (B:126:0x005b, B:130:0x0068, B:132:0x006c, B:128:0x005f, B:143:0x008e, B:147:0x009b, B:149:0x009f, B:145:0x0092, B:155:0x00b2, B:159:0x00bf, B:170:0x00de, B:157:0x00b6, B:176:0x00ec, B:182:0x00fb, B:185:0x0106, B:184:0x00ff, B:180:0x00f2, B:164:0x00cd, B:168:0x00da, B:166:0x00d1, B:153:0x00a9, B:162:0x00c4), top: B:202:0x0005, inners: #1, #3, #5, #6, #7, #9, #11, #12, #13, #14 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String b(Context context, String str) {
        FileOutputStream fileOutputStreamOpenFileOutput;
        Properties properties;
        int i2;
        FileInputStream fileInputStreamOpenFileInput = null;
        try {
            try {
                try {
                    properties = new Properties();
                    i2 = 0;
                    fileOutputStreamOpenFileOutput = !new File(context.getFilesDir().getPath() + "/settings.properties").exists() ? context.openFileOutput("settings.properties", 0) : null;
                } catch (FileNotFoundException unused) {
                    fileOutputStreamOpenFileOutput = null;
                } catch (Throwable unused2) {
                    fileOutputStreamOpenFileOutput = null;
                }
                try {
                    fileInputStreamOpenFileInput = context.openFileInput("settings.properties");
                    if (fileInputStreamOpenFileInput != null) {
                        properties.load(fileInputStreamOpenFileInput);
                    } else {
                        l.a.a.a.j.e.b(FileUtil.TAG, "getProperties inStream is null", true);
                    }
                    String property = properties.getProperty(str);
                    if (TextUtils.isEmpty(property)) {
                        if (fileOutputStreamOpenFileOutput == null) {
                            if (fileInputStreamOpenFileInput != null) {
                            }
                            return property;
                        }
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused3) {
                            l.a.a.a.j.e.a(FileUtil.TAG, "getProperties IOException / ", true);
                        }
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException unused4) {
                                l.a.a.a.j.e.a(FileUtil.TAG, "getProperties IOException / ", true);
                            }
                        }
                        return property;
                    }
                    String[] strArrA = d.c.a.b.a.b.a();
                    int length = strArrA.length;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        if (str.equals(strArrA[i2])) {
                            break;
                        }
                        i2++;
                    }
                    if (fileOutputStreamOpenFileOutput == null) {
                        if (fileInputStreamOpenFileInput != null) {
                        }
                        return property;
                    }
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused5) {
                        l.a.a.a.j.e.a(FileUtil.TAG, "getProperties IOException / ", true);
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused6) {
                            l.a.a.a.j.e.a(FileUtil.TAG, "getProperties IOException / ", true);
                        }
                    }
                    return property;
                } catch (FileNotFoundException unused7) {
                    l.a.a.a.j.e.a(FileUtil.TAG, "Can not find the file settings.properties", true);
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused8) {
                            l.a.a.a.j.e.a(FileUtil.TAG, "getProperties IOException / ", true);
                        }
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    return "";
                } catch (Throwable unused9) {
                    l.a.a.a.j.e.a(FileUtil.TAG, "Throwable / ", true);
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused10) {
                            l.a.a.a.j.e.a(FileUtil.TAG, "getProperties IOException / ", true);
                        }
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    return "";
                }
            } catch (IOException unused11) {
                l.a.a.a.j.e.a(FileUtil.TAG, "getProperties IOException / ", true);
                return "";
            }
        } finally {
        }
    }

    public static void c(Context context, String str) {
        f12666d = str;
        b(context, "encryptversion", str);
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(context.getFilesDir(), str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, String str2, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream;
        File file;
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || bArr == null) {
            return false;
        }
        ?? r3 = 0;
        try {
        } catch (IOException unused) {
            l.a.a.a.j.e.a(FileUtil.TAG, "IOException ", true);
        }
        try {
            try {
                file = new File(str);
            } catch (FileNotFoundException unused2) {
                fileOutputStream = null;
            } catch (IOException unused3) {
                fileOutputStream = null;
            } catch (RuntimeException unused4) {
                fileOutputStream = null;
            } catch (Exception unused5) {
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                if (r3 == 0) {
                }
            }
            if (!file.exists() && !file.mkdirs()) {
                return false;
            }
            fileOutputStream = new FileOutputStream(new File(str + str2));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (FileNotFoundException unused6) {
            } catch (IOException unused7) {
                l.a.a.a.j.e.a(FileUtil.TAG, "writeAgreement IOException", true);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused8) {
                        l.a.a.a.j.e.a(FileUtil.TAG, "IOException ", true);
                    }
                }
                return false;
            } catch (RuntimeException unused9) {
                l.a.a.a.j.e.a(FileUtil.TAG, "RuntimeException ", true);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return true;
            } catch (Exception unused10) {
                l.a.a.a.j.e.a(FileUtil.TAG, "Exception ", true);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return true;
            }
            return true;
            l.a.a.a.j.e.a(FileUtil.TAG, "writeAgreement FileNotFoundException", true);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused11) {
                    l.a.a.a.j.e.a(FileUtil.TAG, "IOException ", true);
                }
            }
            return false;
        } catch (Throwable th2) {
            r3 = str;
            th = th2;
            if (r3 == 0) {
                try {
                    r3.close();
                    throw th;
                } catch (IOException unused12) {
                    l.a.a.a.j.e.a(FileUtil.TAG, "IOException ", true);
                    throw th;
                }
            }
            throw th;
        }
    }

    public static String a(Context context) {
        if (f12667e.compareAndSet(false, true)) {
            f12666d = b(context, "encryptversion");
        }
        return f12666d;
    }

    private static void a(Context context, String str, String str2) throws IOException {
        String strB;
        File filesDir = context.getFilesDir();
        if (filesDir == null || filesDir.getPath() == null) {
            return;
        }
        if (new File(filesDir.getPath() + "/settings.properties").exists()) {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput("settings.properties");
            f12664b = fileInputStreamOpenFileInput;
            if (fileInputStreamOpenFileInput != null) {
                f12665c.load(fileInputStreamOpenFileInput);
            } else {
                l.a.a.a.j.e.b(FileUtil.TAG, "inStream is null", true);
            }
        }
        a = context.openFileOutput("settings.properties", 0);
        String[] strArrA = d.c.a.b.a.b.a();
        int length = strArrA.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                strB = str2;
                break;
            } else {
                if (str.equals(strArrA[i2])) {
                    strB = com.hihonor.honorid.d.a.b.b(context, str2);
                    break;
                }
                i2++;
            }
        }
        int i3 = 0;
        while (strB.length() > 8388588 && i3 < 3) {
            i3++;
            l.a.a.a.j.e.b(FileUtil.TAG, i3 + " mValue.length() is " + strB.length(), true);
            int length2 = strArrA.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    break;
                }
                if (str.equals(strArrA[i4])) {
                    strB = com.hihonor.honorid.d.a.b.b(context, str2);
                    break;
                }
                i4++;
            }
        }
        if (strB.length() > 8388588) {
            l.a.a.a.j.e.a(FileUtil.TAG, "final mValue.length() is " + strB.length(), true);
            return;
        }
        f12665c.setProperty(str, strB);
        FileOutputStream fileOutputStream = a;
        if (fileOutputStream != null) {
            f12665c.store(fileOutputStream, "accountagent");
        } else {
            l.a.a.a.j.e.b(FileUtil.TAG, "outStream is null", true);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:104:0x005a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static synchronized void b(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.Class<l.a.a.a.c> r0 = l.a.a.a.c.class
            monitor-enter(r0)
            r1 = 1
            if (r3 == 0) goto L86
            if (r5 == 0) goto L86
            if (r4 != 0) goto Lc
            goto L86
        Lc:
            r2 = 0
            l.a.a.a.c.a = r2     // Catch: java.lang.Throwable -> L8f
            l.a.a.a.c.f12664b = r2     // Catch: java.lang.Throwable -> L8f
            java.util.Properties r2 = new java.util.Properties     // Catch: java.lang.Throwable -> L8f
            r2.<init>()     // Catch: java.lang.Throwable -> L8f
            l.a.a.a.c.f12665c = r2     // Catch: java.lang.Throwable -> L8f
            a(r3, r4, r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            java.io.FileOutputStream r3 = l.a.a.a.c.a     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L8f
            if (r3 == 0) goto L2c
            java.io.FileOutputStream r3 = l.a.a.a.c.a     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L8f
            goto L2c
        L25:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "setProperties IOException"
            l.a.a.a.j.e.a(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
        L2c:
            java.io.FileInputStream r3 = l.a.a.a.c.f12664b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            if (r3 == 0) goto L61
            java.io.FileInputStream r3 = l.a.a.a.c.f12664b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            goto L61
        L36:
            r3 = move-exception
            goto L63
        L38:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "IOException"
            l.a.a.a.j.e.a(r3, r4, r1)     // Catch: java.lang.Throwable -> L36
            java.io.FileOutputStream r3 = l.a.a.a.c.a     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L8f
            if (r3 == 0) goto L50
            java.io.FileOutputStream r3 = l.a.a.a.c.a     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L49 java.lang.Throwable -> L8f
            goto L50
        L49:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "setProperties IOException"
            l.a.a.a.j.e.a(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
        L50:
            java.io.FileInputStream r3 = l.a.a.a.c.f12664b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            if (r3 == 0) goto L61
            java.io.FileInputStream r3 = l.a.a.a.c.f12664b     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            r3.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L8f
            goto L61
        L5a:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "IOException"
            l.a.a.a.j.e.a(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
        L61:
            monitor-exit(r0)
            return
        L63:
            java.io.FileOutputStream r4 = l.a.a.a.c.a     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8f
            if (r4 == 0) goto L74
            java.io.FileOutputStream r4 = l.a.a.a.c.a     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8f
            r4.close()     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8f
            goto L74
        L6d:
            java.lang.String r4 = "FileUtil"
            java.lang.String r5 = "setProperties IOException"
            l.a.a.a.j.e.a(r4, r5, r1)     // Catch: java.lang.Throwable -> L8f
        L74:
            java.io.FileInputStream r4 = l.a.a.a.c.f12664b     // Catch: java.io.IOException -> L7e java.lang.Throwable -> L8f
            if (r4 == 0) goto L85
            java.io.FileInputStream r4 = l.a.a.a.c.f12664b     // Catch: java.io.IOException -> L7e java.lang.Throwable -> L8f
            r4.close()     // Catch: java.io.IOException -> L7e java.lang.Throwable -> L8f
            goto L85
        L7e:
            java.lang.String r4 = "FileUtil"
            java.lang.String r5 = "IOException"
            l.a.a.a.j.e.a(r4, r5, r1)     // Catch: java.lang.Throwable -> L8f
        L85:
            throw r3     // Catch: java.lang.Throwable -> L8f
        L86:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "at least 1 param is null"
            l.a.a.a.j.e.b(r3, r4, r1)     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r0)
            return
        L8f:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: l.a.a.a.c.b(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void a(XmlSerializer xmlSerializer, String str, String str2) {
        try {
            xmlSerializer.startTag("", str);
            xmlSerializer.text(str2);
            xmlSerializer.endTag("", str);
        } catch (IOException unused) {
            l.a.a.a.j.e.a(FileUtil.TAG, "IOException ", true);
        } catch (IllegalArgumentException unused2) {
            l.a.a.a.j.e.a(FileUtil.TAG, "IllegalArgumentException  ", true);
        } catch (IllegalStateException unused3) {
            l.a.a.a.j.e.a(FileUtil.TAG, "IllegalStateException ", true);
        } catch (Exception unused4) {
            l.a.a.a.j.e.a(FileUtil.TAG, "Exception ", true);
        }
    }
}
