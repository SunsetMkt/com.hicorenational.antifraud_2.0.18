package com.huawei.hms.framework.network.grs.p178h;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.huawei.hms.framework.network.grs.h.c */
/* loaded from: classes.dex */
public class C2384c {

    /* renamed from: a */
    private static final String f7441a = "c";

    /* renamed from: a */
    public static String m6980a(String str, Context context) {
        Logger.m6794d(f7441a, "Io getConfigContent, fileName: " + str);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                if (!new File(str).isDirectory()) {
                    inputStream = context.getAssets().open(str);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            byteArrayOutputStream.flush();
                            return byteArrayOutputStream.toString("UTF-8");
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
            } catch (IOException unused) {
                Logger.m6805w(f7441a, "local config file is not exist.filename is {%s}", str);
            }
            return "";
        } finally {
            IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
            IoUtils.closeSecure(inputStream);
        }
    }
}
