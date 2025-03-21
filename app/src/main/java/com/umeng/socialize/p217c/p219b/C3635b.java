package com.umeng.socialize.p217c.p219b;

import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: FileUtil.java */
/* renamed from: com.umeng.socialize.c.b.b */
/* loaded from: classes2.dex */
public class C3635b {

    /* renamed from: a */
    private static final C3635b f13584a = new C3635b();

    private C3635b() {
    }

    /* renamed from: a */
    public static C3635b m12631a() {
        return f13584a;
    }

    /* renamed from: b */
    public File m12633b() throws IOException {
        File file = new File(m12634c(), m12635d());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

    /* renamed from: c */
    public File m12634c() {
        File file = new File(ContextUtil.getContext().getExternalFilesDir(null), C3636c.f13585a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: d */
    public String m12635d() {
        return SocializeUtils.hexdigest(String.valueOf(System.currentTimeMillis())) + ".jpg";
    }

    /* renamed from: a */
    public byte[] m12632a(File file) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    try {
                        fileInputStream.close();
                        byteArrayOutputStream2.close();
                    } catch (IOException e2) {
                        SLog.error(UmengText.IMAGE.CLOSE, e2);
                    }
                    return byteArray;
                } catch (Throwable th) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th;
                    try {
                        SLog.error(UmengText.IMAGE.READ_IMAGE_ERROR, th);
                        if (fileInputStream != null) {
                            try {
                            } catch (IOException e3) {
                                return DefaultClass.getBytes();
                            }
                        }
                        return DefaultClass.getBytes();
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e32) {
                                SLog.error(UmengText.IMAGE.CLOSE, e32);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }
}
