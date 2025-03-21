package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4096ay;
import com.xiaomi.push.C4100bb;
import com.xiaomi.push.C4243gj;
import com.xiaomi.push.C4260h;
import com.xiaomi.push.C4276hp;
import com.xiaomi.push.C4305o;
import com.xiaomi.push.C4408w;
import com.xiaomi.push.C4410y;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;

/* renamed from: com.xiaomi.push.service.ba */
/* loaded from: classes2.dex */
public class C4376ba {

    /* renamed from: a */
    public static final Object f16682a = new Object();

    /* renamed from: a */
    public static void m16052a(final Context context, final C4243gj c4243gj) {
        if (C4374az.m16044a(c4243gj.m15004e())) {
            C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.push.service.ba.1
                @Override // java.lang.Runnable
                public void run() {
                    RandomAccessFile randomAccessFile;
                    synchronized (C4376ba.f16682a) {
                        FileLock fileLock = null;
                        try {
                            File file = new File(context.getFilesDir(), "tiny_data.lock");
                            C4408w.m16360a(file);
                            randomAccessFile = new RandomAccessFile(file, "rw");
                        } catch (Exception e2) {
                            e = e2;
                            randomAccessFile = null;
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile = null;
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (IOException e3) {
                                    AbstractC4022b.m13351a(e3);
                                }
                            }
                            C4408w.m16356a(randomAccessFile);
                            throw th;
                        }
                        try {
                            try {
                                fileLock = randomAccessFile.getChannel().lock();
                                C4376ba.m16056c(context, c4243gj);
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e4) {
                                        AbstractC4022b.m13351a(e4);
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileLock != null && fileLock.isValid()) {
                                    fileLock.release();
                                }
                                C4408w.m16356a(randomAccessFile);
                                throw th;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            AbstractC4022b.m13351a(e);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e6) {
                                    AbstractC4022b.m13351a(e6);
                                }
                            }
                            C4408w.m16356a(randomAccessFile);
                        }
                        C4408w.m16356a(randomAccessFile);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    /* renamed from: c */
    public static void m16056c(Context context, C4243gj c4243gj) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        ?? m16053a = m16053a(context);
        try {
            try {
                byte[] m15242b = C4260h.m15242b(m16053a, C4276hp.m15567a(c4243gj));
                if (m15242b != null && m15242b.length >= 1) {
                    if (m15242b.length > 30720) {
                        AbstractC4022b.m13347a("TinyData write to cache file failed case too much data content item:" + c4243gj.m15001d() + "  ts:" + System.currentTimeMillis());
                        C4408w.m16356a((Closeable) null);
                        C4408w.m16356a((Closeable) null);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(C4410y.m16369a(m15242b.length));
                        bufferedOutputStream3.write(m15242b);
                        bufferedOutputStream3.flush();
                        C4408w.m16356a((Closeable) null);
                        C4408w.m16356a(bufferedOutputStream3);
                        return;
                    } catch (IOException e2) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e2;
                        AbstractC4022b.m13349a("TinyData write to cache file failed cause io exception item:" + c4243gj.m15001d(), e);
                        m16053a = bufferedOutputStream2;
                        C4408w.m16356a((Closeable) null);
                        C4408w.m16356a((Closeable) m16053a);
                        return;
                    } catch (Exception e3) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e3;
                        AbstractC4022b.m13349a("TinyData write to cache file  failed item:" + c4243gj.m15001d(), e);
                        m16053a = bufferedOutputStream;
                        C4408w.m16356a((Closeable) null);
                        C4408w.m16356a((Closeable) m16053a);
                        return;
                    } catch (Throwable th) {
                        m16053a = bufferedOutputStream3;
                        th = th;
                        C4408w.m16356a((Closeable) null);
                        C4408w.m16356a((Closeable) m16053a);
                        throw th;
                    }
                }
                AbstractC4022b.m13347a("TinyData write to cache file failed case encryption fail item:" + c4243gj.m15001d() + "  ts:" + System.currentTimeMillis());
                C4408w.m16356a((Closeable) null);
                C4408w.m16356a((Closeable) null);
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream2 = null;
            } catch (Exception e5) {
                e = e5;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                m16053a = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    public static byte[] m16053a(Context context) {
        String m15709a = C4305o.m15706a(context).m15709a("mipush", "td_key", "");
        if (TextUtils.isEmpty(m15709a)) {
            m15709a = C4100bb.m13878a(20);
            C4305o.m15706a(context).m15710a("mipush", "td_key", m15709a);
        }
        return m16054a(m15709a);
    }

    /* renamed from: a */
    private static byte[] m16054a(String str) {
        byte[] copyOf = Arrays.copyOf(C4096ay.m13840a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }
}
