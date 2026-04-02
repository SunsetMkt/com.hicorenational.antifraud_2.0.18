package l.a.a.a.j;

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
import l.a.a.a.j.c;

/* JADX INFO: compiled from: FileLogger.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements c.a, Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Thread f12669b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f12671d;
    private final BlockingQueue<String> a = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f12670c = true;

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void b(String str) {
        if (this.f12671d.length() + ((long) str.length()) > 3145728) {
            this.f12671d.renameTo(new File(this.f12671d.getPath() + ".bak"));
        }
    }

    private void c(String str) throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2 = null;
        outputStreamWriter2 = null;
        bufferedOutputStream = null;
        outputStreamWriter2 = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(this.f12671d, true);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
                } catch (FileNotFoundException unused) {
                    outputStreamWriter = null;
                } catch (IOException unused2) {
                    outputStreamWriter = null;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException | IOException unused3) {
                outputStreamWriter = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        } catch (FileNotFoundException | IOException unused4) {
            fileOutputStream = null;
            outputStreamWriter = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
        } catch (FileNotFoundException | IOException unused5) {
            bufferedOutputStream2 = bufferedOutputStream;
            bufferedOutputStream = bufferedOutputStream2;
        } catch (Throwable th4) {
            th = th4;
            outputStreamWriter2 = outputStreamWriter;
            a(outputStreamWriter2);
            a(bufferedOutputStream);
            a(fileOutputStream);
            throw th;
        }
        a(outputStreamWriter);
        a(bufferedOutputStream);
        a(fileOutputStream);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12670c = true;
        if (this.f12671d != null) {
            while (this.f12670c) {
                try {
                    String strPoll = this.a.poll(1L, TimeUnit.SECONDS);
                    if (strPoll != null) {
                        b(strPoll);
                        c(strPoll);
                    }
                } catch (InterruptedException | Exception unused) {
                    return;
                }
            }
        }
    }

    @Override // l.a.a.a.j.c.a
    public void a(String str) {
        if (str == null || this.f12671d == null) {
            return;
        }
        this.a.offer(str);
    }

    public void a(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null) {
            return;
        }
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            this.f12671d = file;
            Thread thread = new Thread(this, "hnid-log-thread");
            this.f12669b = thread;
            thread.start();
        }
    }
}
