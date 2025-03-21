package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* renamed from: com.xiaomi.push.dd */
/* loaded from: classes2.dex */
public class C4156dd implements LoggerInterface {

    /* renamed from: a */
    private static volatile C4156dd f14872a;

    /* renamed from: a */
    private Context f14876a;

    /* renamed from: a */
    private Handler f14877a;

    /* renamed from: b */
    private String f14878b;

    /* renamed from: a */
    private static final SimpleDateFormat f14874a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: a */
    public static String f14873a = "/MiPushLog";

    /* renamed from: a */
    private static List<Pair<String, Throwable>> f14875a = Collections.synchronizedList(new ArrayList());

    private C4156dd(Context context) {
        this.f14876a = context;
        if (context.getApplicationContext() != null) {
            this.f14876a = context.getApplicationContext();
        }
        this.f14878b = this.f14876a.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f14877a = new Handler(handlerThread.getLooper());
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.f14878b = str;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(final String str, final Throwable th) {
        this.f14877a.post(new Runnable() { // from class: com.xiaomi.push.dd.1
            @Override // java.lang.Runnable
            public void run() {
                C4156dd.f14875a.add(new Pair(String.format("%1$s %2$s %3$s ", C4156dd.f14874a.format(new Date()), C4156dd.this.f14878b, str), th));
                if (C4156dd.f14875a.size() > 20000) {
                    int size = (C4156dd.f14875a.size() - 20000) + 50;
                    for (int i2 = 0; i2 < size; i2++) {
                        try {
                            if (C4156dd.f14875a.size() > 0) {
                                C4156dd.f14875a.remove(0);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                    C4156dd.f14875a.add(new Pair(String.format("%1$s %2$s %3$s ", C4156dd.f14874a.format(new Date()), C4156dd.this.f14878b, "flush " + size + " lines logs."), null));
                }
                try {
                    C4156dd.this.m14278a();
                } catch (Exception unused2) {
                    String unused3 = C4156dd.this.f14878b;
                }
            }
        });
    }

    /* renamed from: a */
    public static C4156dd m14274a(Context context) {
        if (f14872a == null) {
            synchronized (C4156dd.class) {
                if (f14872a == null) {
                    f14872a = new C4156dd(context);
                }
            }
        }
        return f14872a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14278a() {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        File file;
        BufferedWriter bufferedWriter = null;
        try {
            file = new File(this.f14876a.getFilesDir(), f14873a);
        } catch (Exception unused) {
            fileLock = null;
            randomAccessFile = null;
        } catch (Throwable th) {
            th = th;
            fileLock = null;
            randomAccessFile = null;
        }
        if (!C4407v.m16354a(file)) {
            String str = "Cannot wirte internal file: " + file;
            return;
        }
        if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
            File file2 = new File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                    while (!f14875a.isEmpty()) {
                        try {
                            Pair<String, Throwable> remove = f14875a.remove(0);
                            String str2 = (String) remove.first;
                            if (remove.second != null) {
                                str2 = (str2 + "\n") + Log.getStackTraceString((Throwable) remove.second);
                            }
                            bufferedWriter2.write(str2 + "\n");
                        } catch (Exception unused2) {
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused4) {
                                }
                            }
                            if (randomAccessFile == null) {
                                return;
                            }
                            randomAccessFile.close();
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused6) {
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    throw th;
                                } catch (IOException unused7) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    File file3 = new File(file, "log1.txt");
                    if (file3.length() >= 1048576) {
                        File file4 = new File(file, "log0.txt");
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                        file3.renameTo(file4);
                    }
                    if (0 != 0) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException unused8) {
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused9) {
                        }
                    }
                } catch (Exception unused10) {
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception unused11) {
                fileLock = null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused12) {
            }
        }
    }
}
