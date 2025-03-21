package com.huawei.hms.opendevice;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/* compiled from: StreamUtil.java */
/* renamed from: com.huawei.hms.opendevice.m */
/* loaded from: classes.dex */
public abstract class AbstractC2475m {
    /* renamed from: a */
    public static void m7503a(File file) throws IOException {
        if (file.exists()) {
            return;
        }
        if (file.getParentFile() == null) {
            HMSLog.m7715e("StreamUtil", "parent file is null.");
            throw new IOException("parent file is null");
        }
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            HMSLog.m7715e("StreamUtil", "make parent dirs failed.");
            throw new IOException("make parent dirs failed");
        }
        if (file.createNewFile()) {
            return;
        }
        HMSLog.m7715e("StreamUtil", "create file failed.");
        throw new IOException("create file failed");
    }

    /* renamed from: a */
    public static String m7502a(String str) {
        InputStreamReader inputStreamReader;
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (FileNotFoundException unused) {
                            bufferedReader = bufferedReader2;
                            HMSLog.m7715e("StreamUtil", "file not exist.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            return sb.toString();
                        } catch (IOException unused2) {
                            bufferedReader = bufferedReader2;
                            HMSLog.m7715e("StreamUtil", "read value IOException.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            throw th;
                        }
                    }
                    IOUtils.closeQuietly((Reader) inputStreamReader);
                    IOUtils.closeQuietly((Reader) bufferedReader2);
                } catch (FileNotFoundException unused3) {
                } catch (IOException unused4) {
                }
            } catch (FileNotFoundException unused5) {
                inputStreamReader = null;
            } catch (IOException unused6) {
                inputStreamReader = null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
            return sb.toString();
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
