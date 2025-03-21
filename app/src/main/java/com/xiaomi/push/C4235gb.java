package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/* renamed from: com.xiaomi.push.gb */
/* loaded from: classes2.dex */
public class C4235gb {

    /* renamed from: a */
    private static boolean f15447a = false;

    /* renamed from: com.xiaomi.push.gb$a */
    static class a implements Runnable {

        /* renamed from: a */
        private Context f15448a;

        /* renamed from: a */
        private InterfaceC4238ge f15449a;

        public a(Context context, InterfaceC4238ge interfaceC4238ge) {
            this.f15449a = interfaceC4238ge;
            this.f15448a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4235gb.m14956c(this.f15448a, this.f15449a);
        }
    }

    /* renamed from: a */
    public static void m14952a(Context context, InterfaceC4238ge interfaceC4238ge) {
        C4076ae.m13698a(context).m13703a(new a(context, interfaceC4238ge));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bb  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m14956c(android.content.Context r11, com.xiaomi.push.InterfaceC4238ge r12) {
        /*
            java.lang.String r0 = "/"
            java.lang.String r1 = "/tdReadTemp"
            boolean r2 = com.xiaomi.push.C4235gb.f15447a
            if (r2 != 0) goto Ldd
            r2 = 1
            com.xiaomi.push.C4235gb.f15447a = r2
            java.io.File r2 = new java.io.File
            java.io.File r3 = r11.getFilesDir()
            java.lang.String r4 = "tiny_data.data"
            r2.<init>(r3, r4)
            boolean r3 = r2.exists()
            java.lang.String r5 = "TinyData no ready file to get data."
            if (r3 != 0) goto L22
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13347a(r5)
            return
        L22:
            m14951a(r11)
            byte[] r3 = com.xiaomi.push.service.C4376ba.m16053a(r11)
            r6 = 0
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            java.io.File r8 = r11.getFilesDir()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            java.lang.String r9 = "tiny_data.lock"
            r7.<init>(r8, r9)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            com.xiaomi.push.C4408w.m16360a(r7)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            java.lang.String r9 = "rw"
            r8.<init>(r7, r9)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            java.nio.channels.FileChannel r7 = r8.getChannel()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            java.nio.channels.FileLock r6 = r7.lock()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            java.io.File r7 = new java.io.File     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r9.<init>()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            java.io.File r10 = r11.getFilesDir()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r9.append(r10)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r9.append(r1)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r9.append(r0)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r9.append(r4)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r7.<init>(r9)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            r2.renameTo(r7)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> Lc8
            if (r6 == 0) goto L90
            boolean r2 = r6.isValid()
            if (r2 == 0) goto L90
            r6.release()     // Catch: java.io.IOException -> L74
            goto L90
        L74:
            r2 = move-exception
            goto L8d
        L76:
            r2 = move-exception
            goto L7d
        L78:
            r11 = move-exception
            r8 = r6
            goto Lc9
        L7b:
            r2 = move-exception
            r8 = r6
        L7d:
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13351a(r2)     // Catch: java.lang.Throwable -> Lc8
            if (r6 == 0) goto L90
            boolean r2 = r6.isValid()
            if (r2 == 0) goto L90
            r6.release()     // Catch: java.io.IOException -> L8c
            goto L90
        L8c:
            r2 = move-exception
        L8d:
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13351a(r2)
        L90:
            com.xiaomi.push.C4408w.m16356a(r8)
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.io.File r7 = r11.getFilesDir()
            r6.append(r7)
            r6.append(r1)
            r6.append(r0)
            r6.append(r4)
            java.lang.String r0 = r6.toString()
            r2.<init>(r0)
            boolean r0 = r2.exists()
            if (r0 != 0) goto Lbb
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13347a(r5)
            return
        Lbb:
            m14953a(r11, r12, r2, r3)
            r12 = 0
            com.xiaomi.push.C4234ga.m14947a(r12)
            m14954b(r11)
            com.xiaomi.push.C4235gb.f15447a = r12
            return
        Lc8:
            r11 = move-exception
        Lc9:
            if (r6 == 0) goto Ld9
            boolean r12 = r6.isValid()
            if (r12 == 0) goto Ld9
            r6.release()     // Catch: java.io.IOException -> Ld5
            goto Ld9
        Ld5:
            r12 = move-exception
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13351a(r12)
        Ld9:
            com.xiaomi.push.C4408w.m16356a(r8)
            throw r11
        Ldd:
            java.lang.String r11 = "TinyData extractTinyData is running"
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13347a(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C4235gb.m14956c(android.content.Context, com.xiaomi.push.ge):void");
    }

    /* renamed from: a */
    private static void m14953a(Context context, InterfaceC4238ge interfaceC4238ge, File file, byte[] bArr) {
        BufferedInputStream bufferedInputStream;
        int m16368a;
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                bufferedInputStream2 = null;
                loop0: while (true) {
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        try {
                            int read = bufferedInputStream.read(bArr2);
                            if (read == -1) {
                                break loop0;
                            }
                            if (read == 4) {
                                m16368a = C4410y.m16368a(bArr2);
                                if (m16368a < 1 || m16368a > 30720) {
                                    break loop0;
                                }
                                byte[] bArr3 = new byte[m16368a];
                                int read2 = bufferedInputStream.read(bArr3);
                                if (read2 != m16368a) {
                                    AbstractC4022b.m13361d("TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + m16368a);
                                    break loop0;
                                }
                                byte[] m15241a = C4260h.m15241a(bArr, bArr3);
                                if (m15241a != null && m15241a.length != 0) {
                                    C4243gj c4243gj = new C4243gj();
                                    C4276hp.m15566a(c4243gj, m15241a);
                                    c4243gj.m14987a("item_size", String.valueOf(m15241a.length));
                                    arrayList.add(c4243gj);
                                    i2++;
                                    i3 += m15241a.length;
                                    if (i2 >= 8 || i3 >= 30720) {
                                    }
                                }
                                AbstractC4022b.m13361d("TinyData read from cache file failed cause decrypt fail");
                            } else {
                                AbstractC4022b.m13361d("TinyData read from cache file failed cause lengthBuffer error. size:" + read);
                                break loop0;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            bufferedInputStream2 = bufferedInputStream;
                            AbstractC4022b.m13351a(e);
                            C4408w.m16356a((Closeable) bufferedInputStream2);
                        } catch (Throwable th) {
                            th = th;
                            C4408w.m16356a((Closeable) bufferedInputStream);
                            throw th;
                        }
                    }
                    C4236gc.m14959a(context, interfaceC4238ge, arrayList);
                    arrayList.clear();
                }
                AbstractC4022b.m13361d("TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + m16368a);
                C4236gc.m14959a(context, interfaceC4238ge, arrayList);
                if (file != null && file.exists() && !file.delete()) {
                    AbstractC4022b.m13347a("TinyData delete reading temp file failed");
                }
                C4408w.m16356a((Closeable) bufferedInputStream);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
        }
    }

    /* renamed from: b */
    private static void m14954b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* renamed from: a */
    private static void m14951a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
