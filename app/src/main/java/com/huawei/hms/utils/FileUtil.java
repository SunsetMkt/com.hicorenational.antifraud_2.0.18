package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;

    /* renamed from: a */
    private static boolean f7929a = false;

    /* renamed from: b */
    private static ScheduledExecutorService f7930b = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: com.huawei.hms.utils.FileUtil$a */
    class RunnableC2539a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ File f7931a;

        /* renamed from: b */
        final /* synthetic */ long f7932b;

        /* renamed from: c */
        final /* synthetic */ String f7933c;

        RunnableC2539a(File file, long j2, String str) {
            this.f7931a = file;
            this.f7932b = j2;
            this.f7933c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            IOException iOException;
            RandomAccessFile randomAccessFile;
            Throwable th;
            File file = this.f7931a;
            if (file == null) {
                HMSLog.m7715e(cn.cloudwalk.libproject.util.FileUtil.TAG, "In writeFile Failed to get local file.");
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile == null || !(parentFile.mkdirs() || parentFile.isDirectory())) {
                HMSLog.m7715e(cn.cloudwalk.libproject.util.FileUtil.TAG, "In writeFile, Failed to create directory.");
                return;
            }
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    long length = this.f7931a.length();
                    if (length > this.f7932b) {
                        String canonicalPath = this.f7931a.getCanonicalPath();
                        if (!this.f7931a.delete()) {
                            HMSLog.m7715e(cn.cloudwalk.libproject.util.FileUtil.TAG, "last file delete failed.");
                        }
                        randomAccessFile2 = new RandomAccessFile(new File(canonicalPath), "rw");
                    } else {
                        randomAccessFile = new RandomAccessFile(this.f7931a, "rw");
                        try {
                            randomAccessFile.seek(length);
                            randomAccessFile2 = randomAccessFile;
                        } catch (IOException e2) {
                            iOException = e2;
                            randomAccessFile2 = randomAccessFile;
                            HMSLog.m7716e(cn.cloudwalk.libproject.util.FileUtil.TAG, "writeFile exception:", iOException);
                            IOUtils.closeQuietly(randomAccessFile2);
                        } catch (Throwable th2) {
                            th = th2;
                            IOUtils.closeQuietly(randomAccessFile);
                            throw th;
                        }
                    }
                    randomAccessFile2.writeBytes(this.f7933c + System.getProperty("line.separator"));
                } catch (IOException e3) {
                    iOException = e3;
                    randomAccessFile2 = randomAccessFile2;
                }
                IOUtils.closeQuietly(randomAccessFile2);
            } catch (Throwable th3) {
                randomAccessFile = null;
                th = th3;
            }
        }
    }

    public static boolean verifyHash(String str, File file) {
        byte[] digest = SHA256.digest(file);
        return digest != null && HEX.encodeHexString(digest, true).equalsIgnoreCase(str);
    }

    public static void writeFile(File file, String str, long j2) {
        f7930b.execute(new RunnableC2539a(file, j2, str));
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j2, int i2) {
        if (file != null && file.isFile() && file.exists()) {
            if (!f7929a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.m7715e(cn.cloudwalk.libproject.util.FileUtil.TAG, "file delete failed.");
                }
                f7929a = true;
            }
            writeFile(file2, str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + j2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i2, LOCAL_REPORT_FILE_MAX_SIZE);
        }
    }
}
