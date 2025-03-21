package com.xiaomi.push;

import java.io.File;
import java.util.HashMap;

/* renamed from: com.xiaomi.push.v */
/* loaded from: classes2.dex */
public class C4407v {

    /* renamed from: a */
    private static final HashMap<String, String> f16832a = new HashMap<>();

    static {
        f16832a.put("FFD8FF", "jpg");
        f16832a.put("89504E47", "png");
        f16832a.put("47494638", "gif");
        f16832a.put("474946", "gif");
        f16832a.put("424D", "bmp");
    }

    /* renamed from: a */
    public static long m16353a(File file) {
        long j2 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                j2 += listFiles[i2].isDirectory() ? m16353a(listFiles[i2]) : listFiles[i2].length();
            }
        } catch (Exception e2) {
            String str = "Get folder size error: " + e2.getMessage();
        }
        return j2;
    }

    /* renamed from: a */
    public static boolean m16354a(File file) {
        long length;
        if (file == null) {
            return false;
        }
        try {
            if (!file.exists()) {
                return true;
            }
            if (file.isDirectory()) {
                length = m16353a(file);
            } else {
                length = file.length();
            }
            return length < 104857600;
        } catch (Exception e2) {
            String str = "Check if internal file can be written error :" + e2.getMessage();
            return false;
        }
    }
}
