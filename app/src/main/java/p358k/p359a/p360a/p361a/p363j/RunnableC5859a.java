package p358k.p359a.p360a.p361a.p363j;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import p358k.p359a.p360a.p361a.p363j.C5861c;

/* compiled from: FileLogger.java */
/* renamed from: k.a.a.a.j.a */
/* loaded from: classes2.dex */
public class RunnableC5859a implements C5861c.a, Runnable {

    /* renamed from: b */
    private Thread f21141b;

    /* renamed from: d */
    private File f21143d;

    /* renamed from: a */
    private final BlockingQueue<String> f21140a = new LinkedBlockingQueue();

    /* renamed from: c */
    private volatile boolean f21142c = true;

    /* renamed from: a */
    private static void m24660a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: b */
    private void m24661b(String str) {
        if (this.f21143d.length() + str.length() > 3145728) {
            this.f21143d.renameTo(new File(this.f21143d.getPath() + ".bak"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* renamed from: c */
    private void m24662c(String str) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Closeable closeable;
        Closeable closeable2;
        OutputStreamWriter outputStreamWriter;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(this.f21143d, true);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
                } catch (FileNotFoundException unused) {
                    outputStreamWriter = 0;
                } catch (IOException unused2) {
                    outputStreamWriter = 0;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException | IOException unused3) {
                closeable = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        } catch (FileNotFoundException | IOException unused4) {
            fileOutputStream = null;
            closeable = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
            closeable2 = outputStreamWriter;
        } catch (FileNotFoundException | IOException unused5) {
            bufferedOutputStream2 = bufferedOutputStream;
            closeable = outputStreamWriter;
            bufferedOutputStream = bufferedOutputStream2;
            closeable2 = closeable;
            m24660a(closeable2);
            m24660a(bufferedOutputStream);
            m24660a(fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream2 = outputStreamWriter;
            m24660a(bufferedOutputStream2);
            m24660a(bufferedOutputStream);
            m24660a(fileOutputStream);
            throw th;
        }
        m24660a(closeable2);
        m24660a(bufferedOutputStream);
        m24660a(fileOutputStream);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21142c = true;
        if (this.f21143d != null) {
            while (this.f21142c) {
                try {
                    String poll = this.f21140a.poll(1L, TimeUnit.SECONDS);
                    if (poll != null) {
                        m24661b(poll);
                        m24662c(poll);
                    }
                } catch (InterruptedException | Exception unused) {
                    return;
                }
            }
        }
    }

    @Override // p358k.p359a.p360a.p361a.p363j.C5861c.a
    /* renamed from: a */
    public void mo24664a(String str) {
        if (str == null || this.f21143d == null) {
            return;
        }
        this.f21140a.offer(str);
    }

    /* renamed from: a */
    public void m24663a(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null) {
            return;
        }
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            this.f21143d = file;
            Thread thread = new Thread(this, "hnid-log-thread");
            this.f21141b = thread;
            thread.start();
        }
    }
}
