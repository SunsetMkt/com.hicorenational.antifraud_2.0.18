package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class bl {

    /* JADX INFO: renamed from: com.xiaomi.push.bl$1 */
    static class AnonymousClass1 implements FilenameFilter {
        AnonymousClass1() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return (TextUtils.isEmpty(str) || str.toLowerCase().endsWith(".lock")) ? false : true;
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.bl$2 */
    static class AnonymousClass2 implements FilenameFilter {
        AnonymousClass2() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return (TextUtils.isEmpty(str) || str.toLowerCase().endsWith(".lock")) ? false : true;
        }
    }

    public static String a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL;
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        byte[] bArrCopyOf = Arrays.copyOf(ay.m159a(str), 16);
        bArrCopyOf[0] = 68;
        bArrCopyOf[15] = 84;
        return bArrCopyOf;
    }

    public static String a(Context context) {
        String strA = bm.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String strA2 = bb.a(20);
        bm.a(context).m186a("sp_client_report_status", "sp_client_report_key", strA2);
        return strA2;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m182a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra(d.c.a.b.a.a.j1, context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra(CommonNetImpl.NAME, "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    public static void a(Context context, List<String> list) {
        if (list == null || list.size() <= 0 || !m182a(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x012e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, String str2) throws Throwable {
        File file;
        RandomAccessFile randomAccessFile;
        Exception e2;
        if (context == null || str == null || str2 == null) {
            return;
        }
        File file2 = new File(context.getFilesDir(), str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(context.getFilesDir(), str);
        if (!file3.exists()) {
            file3.mkdirs();
            return;
        }
        File[] fileArrListFiles = file3.listFiles(new FilenameFilter() { // from class: com.xiaomi.push.bl.1
            AnonymousClass1() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file4, String str3) {
                return (TextUtils.isEmpty(str3) || str3.toLowerCase().endsWith(".lock")) ? false : true;
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        FileLock fileLockLock = null;
        RandomAccessFile randomAccessFile2 = null;
        File file4 = null;
        for (File file5 : fileArrListFiles) {
            if (file5 != null) {
                try {
                } catch (Exception e3) {
                    file = file4;
                    randomAccessFile = randomAccessFile2;
                    e2 = e3;
                } catch (Throwable th) {
                    th = th;
                    file = file4;
                }
                if (!TextUtils.isEmpty(file5.getAbsolutePath())) {
                    file = new File(file5.getAbsolutePath() + ".lock");
                    try {
                        w.m763a(file);
                        randomAccessFile = new RandomAccessFile(file, "rw");
                    } catch (Exception e4) {
                        randomAccessFile = randomAccessFile2;
                        e2 = e4;
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile = randomAccessFile2;
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.release();
                            } catch (IOException e5) {
                                com.xiaomi.channel.commonutils.logger.b.a(e5);
                            }
                        }
                        w.a(randomAccessFile);
                        if (file == null) {
                        }
                    }
                    try {
                        try {
                            fileLockLock = randomAccessFile.getChannel().lock();
                            File file6 = new File(file2.getAbsolutePath() + File.separator + file5.getName() + jCurrentTimeMillis);
                            try {
                                w.b(file5, file6);
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                file5.delete();
                                file6.delete();
                            }
                            file5.delete();
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e7) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e7);
                                }
                            }
                            w.a(randomAccessFile);
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                fileLockLock.release();
                            }
                            w.a(randomAccessFile);
                            if (file == null) {
                                file.delete();
                                throw th;
                            }
                            throw th;
                        }
                    } catch (Exception e8) {
                        e2 = e8;
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        if (fileLockLock != null && fileLockLock.isValid()) {
                            try {
                                fileLockLock.release();
                            } catch (IOException e9) {
                                com.xiaomi.channel.commonutils.logger.b.a(e9);
                            }
                        }
                        w.a(randomAccessFile);
                        if (file != null) {
                        }
                        randomAccessFile2 = randomAccessFile;
                        file4 = file;
                    }
                    file.delete();
                    randomAccessFile2 = randomAccessFile;
                    file4 = file;
                } else {
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e10) {
                            com.xiaomi.channel.commonutils.logger.b.a(e10);
                        }
                    }
                    w.a(randomAccessFile2);
                    if (file4 == null) {
                        file4.delete();
                    }
                }
            } else {
                if (fileLockLock != null) {
                    fileLockLock.release();
                }
                w.a(randomAccessFile2);
                if (file4 == null) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m183a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = com.xiaomi.clientreport.manager.a.a(context).m57a().getMaxFileLength();
        if (file.exists()) {
            try {
                if (file.length() > maxFileLength) {
                    return false;
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return false;
            }
        } else {
            w.m763a(file);
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static File[] m184a(Context context, String str) {
        return new File(context.getFilesDir(), str).listFiles(new FilenameFilter() { // from class: com.xiaomi.push.bl.2
            AnonymousClass2() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return (TextUtils.isEmpty(str2) || str2.toLowerCase().endsWith(".lock")) ? false : true;
            }
        });
    }
}
