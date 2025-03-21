package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4100bb;
import com.xiaomi.push.C4408w;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.xiaomi.push.service.ae */
/* loaded from: classes2.dex */
public class C4353ae {

    /* renamed from: a */
    private static long f16504a = 0;

    /* renamed from: a */
    private static boolean f16505a = false;

    /* renamed from: b */
    private static long f16506b;

    /* renamed from: com.xiaomi.push.service.ae$a */
    public static class a {

        /* renamed from: a */
        int f16507a;

        /* renamed from: a */
        byte[] f16508a;

        public a(byte[] bArr, int i2) {
            this.f16508a = bArr;
            this.f16507a = i2;
        }
    }

    /* renamed from: com.xiaomi.push.service.ae$b */
    public static class b {

        /* renamed from: a */
        public long f16509a;

        /* renamed from: a */
        public Bitmap f16510a;

        public b(Bitmap bitmap, long j2) {
            this.f16510a = bitmap;
            this.f16509a = j2;
        }
    }

    /* renamed from: a */
    public static b m15864a(Context context, String str, boolean z) {
        Bitmap m15869b;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0L);
        try {
            try {
                m15869b = m15869b(context, str);
            } catch (Exception e2) {
                e = e2;
            }
            if (m15869b != null) {
                bVar.f16510a = m15869b;
                C4408w.m16356a((Closeable) null);
                return bVar;
            }
            a m15863a = m15863a(str, z);
            if (m15863a == null) {
                C4408w.m16356a((Closeable) null);
                return bVar;
            }
            bVar.f16509a = m15863a.f16507a;
            byte[] bArr = m15863a.f16508a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int m15861a = m15861a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = m15861a;
                        bVar.f16510a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e3) {
                        e = e3;
                        byteArrayInputStream = byteArrayInputStream2;
                        AbstractC4022b.m13351a(e);
                        C4408w.m16356a((Closeable) byteArrayInputStream);
                        return bVar;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayInputStream = byteArrayInputStream2;
                        C4408w.m16356a((Closeable) byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f16510a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            m15867a(context, m15863a.f16508a, str);
            C4408w.m16356a((Closeable) byteArrayInputStream);
            return bVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: b */
    private static synchronized Bitmap m15869b(Context context, String str) {
        Bitmap bitmap;
        File file;
        synchronized (C4353ae.class) {
            FileInputStream fileInputStream = null;
            Bitmap bitmap2 = null;
            try {
                file = new File(m15865a(context), C4100bb.m13879a(str));
            } catch (Throwable th) {
                th = th;
                bitmap = null;
            }
            if (!file.exists()) {
                return null;
            }
            if (System.currentTimeMillis() - file.lastModified() > 1209600000) {
                AbstractC4022b.m13347a("The pic cache has expired.");
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                bitmap2 = BitmapFactory.decodeStream(fileInputStream2);
                file.setLastModified(System.currentTimeMillis());
                C4408w.m16356a((Closeable) fileInputStream2);
                bitmap = bitmap2;
            } catch (Throwable th2) {
                Bitmap bitmap3 = bitmap2;
                fileInputStream = fileInputStream2;
                th = th2;
                bitmap = bitmap3;
                try {
                    AbstractC4022b.m13361d("Load bmp from cache error: " + th);
                    return bitmap;
                } finally {
                    C4408w.m16356a((Closeable) fileInputStream);
                }
            }
            return bitmap;
        }
    }

    /* renamed from: b */
    private static synchronized void m15870b(Context context) {
        String str;
        File file;
        synchronized (C4353ae.class) {
            if (f16505a) {
                return;
            }
            f16504a = 0L;
            f16506b = 0L;
            try {
                file = new File(m15865a(context));
            } catch (Throwable th) {
                try {
                    AbstractC4022b.m13361d("Init pic cache error: " + th);
                    f16505a = true;
                    str = "Init pic cache finish.";
                } finally {
                    f16505a = true;
                    AbstractC4022b.m13356b("Init pic cache finish.");
                }
            }
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        f16504a += file2.length();
                        if (f16506b <= 0) {
                            f16506b = file2.lastModified();
                        } else {
                            f16506b = Math.min(f16506b, file2.lastModified());
                        }
                    }
                }
                f16505a = true;
                str = "Init pic cache finish.";
                AbstractC4022b.m13356b(str);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0101, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0104, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e4, code lost:
    
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e2, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0106: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:67:0x0106 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.service.C4353ae.a m15863a(java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4353ae.m15863a(java.lang.String, boolean):com.xiaomi.push.service.ae$a");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* renamed from: a */
    public static Bitmap m15862a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        int m15861a;
        Uri parse = Uri.parse(str);
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(parse);
                try {
                    m15861a = m15861a((Context) context, inputStream);
                    inputStream2 = context.getContentResolver().openInputStream(parse);
                } catch (IOException e2) {
                    e = e2;
                    inputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    context = 0;
                    C4408w.m16356a((Closeable) context);
                    C4408w.m16356a((Closeable) inputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                inputStream2 = null;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                context = 0;
                inputStream = null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = m15861a;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                C4408w.m16356a((Closeable) inputStream2);
                C4408w.m16356a((Closeable) inputStream);
                return decodeStream;
            } catch (IOException e4) {
                e = e4;
                AbstractC4022b.m13351a(e);
                C4408w.m16356a((Closeable) inputStream2);
                C4408w.m16356a((Closeable) inputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    private static int m15861a(Context context, InputStream inputStream) {
        int i2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth != -1 && options.outHeight != -1) {
            int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
            int i3 = options.outWidth;
            if (i3 <= round || (i2 = options.outHeight) <= round) {
                return 1;
            }
            return Math.min(i3 / round, i2 / round);
        }
        AbstractC4022b.m13347a("decode dimension failed for bitmap.");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* renamed from: a */
    private static void m15867a(Context context, byte[] bArr, String str) {
        if (bArr == null) {
            AbstractC4022b.m13347a("cannot save small icon cause bitmap is null");
            return;
        }
        m15866a(context);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                File file = new File(m15865a(context));
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, C4100bb.m13879a((String) str));
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                str = new FileOutputStream(file2);
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(str);
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.flush();
                        f16504a += file2.length();
                        if (f16506b <= 0) {
                            f16506b = file2.lastModified();
                        } else {
                            f16506b = Math.min(f16506b, file2.lastModified());
                        }
                        C4408w.m16356a(bufferedOutputStream2);
                        str = str;
                    } catch (Exception e2) {
                        e = e2;
                        bufferedOutputStream = bufferedOutputStream2;
                        AbstractC4022b.m13361d("Save pic error: " + e);
                        C4408w.m16356a(bufferedOutputStream);
                        str = str;
                        C4408w.m16356a((Closeable) str);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        C4408w.m16356a(bufferedOutputStream);
                        C4408w.m16356a((Closeable) str);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                str = 0;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
            }
            C4408w.m16356a((Closeable) str);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    private static synchronized void m15866a(Context context) {
        File file;
        long j2;
        synchronized (C4353ae.class) {
            m15870b(context);
            if (f16504a >= 62914560 || System.currentTimeMillis() - f16506b >= 1209600000) {
                try {
                    file = new File(m15865a(context));
                } catch (Throwable th) {
                    AbstractC4022b.m13361d("Clear pic cache error: " + th);
                }
                if (!file.exists()) {
                    AbstractC4022b.m13347a("The pic cache dir do not exists.");
                    return;
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    m15868a(listFiles);
                    long j3 = f16504a;
                    int length = listFiles.length - 1;
                    while (true) {
                        if (length < 0) {
                            j2 = 0;
                            break;
                        }
                        File file2 = listFiles[length];
                        if (file2 != null) {
                            if (j3 <= 31457280 && System.currentTimeMillis() - file2.lastModified() <= 864000000) {
                                j2 = file2.lastModified();
                                break;
                            }
                            j3 -= file2.length();
                            file2.delete();
                        }
                        length--;
                    }
                    f16504a = Math.max(j3, 0L);
                    f16506b = j2;
                } else {
                    AbstractC4022b.m13347a("The pic cache file list is null.");
                }
            }
        }
    }

    /* renamed from: a */
    private static void m15868a(File[] fileArr) {
        if (fileArr != null) {
            try {
                if (fileArr.length > 1) {
                    Arrays.sort(fileArr, new Comparator<File>() { // from class: com.xiaomi.push.service.ae.1
                        @Override // java.util.Comparator
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            if (file == file2) {
                                return 0;
                            }
                            if (file == null) {
                                return 1;
                            }
                            if (file2 == null) {
                                return -1;
                            }
                            long lastModified = file.lastModified() - file2.lastModified();
                            if (lastModified == 0) {
                                return 0;
                            }
                            return lastModified < 0 ? 1 : -1;
                        }
                    });
                }
            } catch (Throwable th) {
                AbstractC4022b.m13361d("Sort pic cache error: " + th);
            }
        }
    }

    /* renamed from: a */
    private static String m15865a(Context context) {
        return context.getCacheDir().getPath() + File.separator + "mipush_icon";
    }
}
