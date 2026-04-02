package com.bumptech.glide.n;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {
    static final String o = "journal";
    static final String p = "journal.tmp";
    static final String q = "journal.bkp";
    static final String r = "libcore.io.DiskLruCache";
    static final String s = "1";
    static final long t = -1;
    private static final String u = "CLEAN";
    private static final String v = "DIRTY";
    private static final String w = "REMOVE";
    private static final String x = "READ";
    private final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f3343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f3344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f3345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f3348g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Writer f3350i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3352k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f3349h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<String, d> f3351j = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f3353l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f3354m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Callable<Void> f3355n = new CallableC0062a();

    /* JADX INFO: renamed from: com.bumptech.glide.n.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskLruCache.java */
    class CallableC0062a implements Callable<Void> {
        CallableC0062a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f3350i == null) {
                    return null;
                }
                a.this.l();
                if (a.this.h()) {
                    a.this.k();
                    a.this.f3352k = 0;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(CallableC0062a callableC0062a) {
            this();
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class c {
        private final d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f3356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3357c;

        /* synthetic */ c(a aVar, d dVar, CallableC0062a callableC0062a) {
            this(dVar);
        }

        private InputStream c(int i2) throws IOException {
            synchronized (a.this) {
                if (this.a.f3363f != this) {
                    throw new IllegalStateException();
                }
                if (!this.a.f3362e) {
                    return null;
                }
                try {
                    return new FileInputStream(this.a.a(i2));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        private c(d dVar) {
            this.a = dVar;
            this.f3356b = dVar.f3362e ? null : new boolean[a.this.f3348g];
        }

        public File a(int i2) throws IOException {
            File fileB;
            synchronized (a.this) {
                if (this.a.f3363f != this) {
                    throw new IllegalStateException();
                }
                if (!this.a.f3362e) {
                    this.f3356b[i2] = true;
                }
                fileB = this.a.b(i2);
                if (!a.this.a.exists()) {
                    a.this.a.mkdirs();
                }
            }
            return fileB;
        }

        public String b(int i2) throws IOException {
            InputStream inputStreamC = c(i2);
            if (inputStreamC != null) {
                return a.b(inputStreamC);
            }
            return null;
        }

        public void b() {
            if (this.f3357c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void c() throws IOException {
            a.this.a(this, true);
            this.f3357c = true;
        }

        public void a(int i2, String str) throws Throwable {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(a(i2)), com.bumptech.glide.n.c.f3376b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                com.bumptech.glide.n.c.a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                com.bumptech.glide.n.c.a(outputStreamWriter2);
                throw th;
            }
        }

        public void a() throws IOException {
            a.this.a(this, false);
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private final class d {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f3359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        File[] f3360c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        File[] f3361d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f3362e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c f3363f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f3364g;

        /* synthetic */ d(a aVar, String str, CallableC0062a callableC0062a) {
            this(str);
        }

        private d(String str) {
            this.a = str;
            this.f3359b = new long[a.this.f3348g];
            this.f3360c = new File[a.this.f3348g];
            this.f3361d = new File[a.this.f3348g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.f3348g; i2++) {
                sb.append(i2);
                this.f3360c[i2] = new File(a.this.a, sb.toString());
                sb.append(".tmp");
                this.f3361d[i2] = new File(a.this.a, sb.toString());
                sb.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.f3348g) {
                throw a(strArr);
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.f3359b[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    throw a(strArr);
                }
            }
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f3359b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        public File b(int i2) {
            return this.f3361d[i2];
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i2) {
            return this.f3360c[i2];
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class e {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f3366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f3367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final File[] f3368d;

        /* synthetic */ e(a aVar, String str, long j2, File[] fileArr, long[] jArr, CallableC0062a callableC0062a) {
            this(str, j2, fileArr, jArr);
        }

        public c a() throws IOException {
            return a.this.a(this.a, this.f3366b);
        }

        public long b(int i2) {
            return this.f3367c[i2];
        }

        public String c(int i2) throws IOException {
            return a.b(new FileInputStream(this.f3368d[i2]));
        }

        private e(String str, long j2, File[] fileArr, long[] jArr) {
            this.a = str;
            this.f3366b = j2;
            this.f3368d = fileArr;
            this.f3367c = jArr;
        }

        public File a(int i2) {
            return this.f3368d[i2];
        }
    }

    private a(File file, int i2, int i3, long j2) {
        this.a = file;
        this.f3346e = i2;
        this.f3343b = new File(file, o);
        this.f3344c = new File(file, p);
        this.f3345d = new File(file, q);
        this.f3348g = i3;
        this.f3347f = j2;
    }

    private void g() {
        if (this.f3350i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        int i2 = this.f3352k;
        return i2 >= 2000 && i2 >= this.f3351j.size();
    }

    private void i() throws IOException {
        a(this.f3344c);
        Iterator<d> it = this.f3351j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f3363f == null) {
                while (i2 < this.f3348g) {
                    this.f3349h += next.f3359b[i2];
                    i2++;
                }
            } else {
                next.f3363f = null;
                while (i2 < this.f3348g) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    private void j() throws IOException {
        com.bumptech.glide.n.b bVar = new com.bumptech.glide.n.b(new FileInputStream(this.f3343b), com.bumptech.glide.n.c.a);
        try {
            String strD = bVar.d();
            String strD2 = bVar.d();
            String strD3 = bVar.d();
            String strD4 = bVar.d();
            String strD5 = bVar.d();
            if (!r.equals(strD) || !"1".equals(strD2) || !Integer.toString(this.f3346e).equals(strD3) || !Integer.toString(this.f3348g).equals(strD4) || !"".equals(strD5)) {
                throw new IOException("unexpected journal header: [" + strD + ", " + strD2 + ", " + strD4 + ", " + strD5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    d(bVar.d());
                    i2++;
                } catch (EOFException unused) {
                    this.f3352k = i2 - this.f3351j.size();
                    if (bVar.c()) {
                        k();
                    } else {
                        this.f3350i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3343b, true), com.bumptech.glide.n.c.a));
                    }
                    com.bumptech.glide.n.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bumptech.glide.n.c.a(bVar);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() throws IOException {
        if (this.f3350i != null) {
            a(this.f3350i);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3344c), com.bumptech.glide.n.c.a));
        try {
            bufferedWriter.write(r);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f3346e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f3348g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.f3351j.values()) {
                if (dVar.f3363f != null) {
                    bufferedWriter.write("DIRTY " + dVar.a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.a + dVar.a() + '\n');
                }
            }
            a(bufferedWriter);
            if (this.f3343b.exists()) {
                a(this.f3343b, this.f3345d, true);
            }
            a(this.f3344c, this.f3343b, false);
            this.f3345d.delete();
            this.f3350i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3343b, true), com.bumptech.glide.n.c.a));
        } catch (Throwable th) {
            a(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() throws IOException {
        while (this.f3349h > this.f3347f) {
            c(this.f3351j.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f3350i == null) {
            return;
        }
        for (d dVar : new ArrayList(this.f3351j.values())) {
            if (dVar.f3363f != null) {
                dVar.f3363f.a();
            }
        }
        l();
        a(this.f3350i);
        this.f3350i = null;
    }

    public synchronized void flush() throws IOException {
        g();
        l();
        b(this.f3350i);
    }

    public synchronized boolean isClosed() {
        return this.f3350i == null;
    }

    private void d(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i2 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i2);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i2);
            if (iIndexOf == 6 && str.startsWith(w)) {
                this.f3351j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iIndexOf2);
        }
        d dVar = this.f3351j.get(strSubstring);
        CallableC0062a callableC0062a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0062a);
            this.f3351j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(u)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(d.c.a.b.a.a.f10074g);
            dVar.f3362e = true;
            dVar.f3363f = null;
            dVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(v)) {
            dVar.f3363f = new c(this, dVar, callableC0062a);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith(x)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public synchronized e b(String str) throws IOException {
        g();
        d dVar = this.f3351j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f3362e) {
            return null;
        }
        for (File file : dVar.f3360c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f3352k++;
        this.f3350i.append((CharSequence) x);
        this.f3350i.append(' ');
        this.f3350i.append((CharSequence) str);
        this.f3350i.append('\n');
        if (h()) {
            this.f3354m.submit(this.f3355n);
        }
        return new e(this, str, dVar.f3364g, dVar.f3360c, dVar.f3359b, null);
    }

    public synchronized boolean c(String str) throws IOException {
        g();
        d dVar = this.f3351j.get(str);
        if (dVar != null && dVar.f3363f == null) {
            for (int i2 = 0; i2 < this.f3348g; i2++) {
                File fileA = dVar.a(i2);
                if (fileA.exists() && !fileA.delete()) {
                    throw new IOException("failed to delete " + fileA);
                }
                this.f3349h -= dVar.f3359b[i2];
                dVar.f3359b[i2] = 0;
            }
            this.f3352k++;
            this.f3350i.append((CharSequence) w);
            this.f3350i.append(' ');
            this.f3350i.append((CharSequence) str);
            this.f3350i.append('\n');
            this.f3351j.remove(str);
            if (h()) {
                this.f3354m.submit(this.f3355n);
            }
            return true;
        }
        return false;
    }

    public synchronized long e() {
        return this.f3347f;
    }

    public synchronized long f() {
        return this.f3349h;
    }

    public static a a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 > 0) {
            File file2 = new File(file, q);
            if (file2.exists()) {
                File file3 = new File(file, o);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i2, i3, j2);
            if (aVar.f3343b.exists()) {
                try {
                    aVar.j();
                    aVar.i();
                    return aVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.c();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i2, i3, j2);
            aVar2.k();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(InputStream inputStream) throws IOException {
        return com.bumptech.glide.n.c.a((Reader) new InputStreamReader(inputStream, com.bumptech.glide.n.c.f3376b));
    }

    @TargetApi(26)
    private static void b(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void c() throws IOException {
        close();
        com.bumptech.glide.n.c.a(this.a);
    }

    public File d() {
        return this.a;
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public c a(String str) throws IOException {
        return a(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized c a(String str, long j2) throws IOException {
        g();
        d dVar = this.f3351j.get(str);
        CallableC0062a callableC0062a = null;
        if (j2 != -1 && (dVar == null || dVar.f3364g != j2)) {
            return null;
        }
        if (dVar != null) {
            if (dVar.f3363f != null) {
                return null;
            }
        } else {
            dVar = new d(this, str, callableC0062a);
            this.f3351j.put(str, dVar);
        }
        c cVar = new c(this, dVar, callableC0062a);
        dVar.f3363f = cVar;
        this.f3350i.append((CharSequence) v);
        this.f3350i.append(' ');
        this.f3350i.append((CharSequence) str);
        this.f3350i.append('\n');
        b(this.f3350i);
        return cVar;
    }

    public synchronized void a(long j2) {
        this.f3347f = j2;
        this.f3354m.submit(this.f3355n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) throws IOException {
        d dVar = cVar.a;
        if (dVar.f3363f == cVar) {
            if (z && !dVar.f3362e) {
                for (int i2 = 0; i2 < this.f3348g; i2++) {
                    if (cVar.f3356b[i2]) {
                        if (!dVar.b(i2).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f3348g; i3++) {
                File fileB = dVar.b(i3);
                if (z) {
                    if (fileB.exists()) {
                        File fileA = dVar.a(i3);
                        fileB.renameTo(fileA);
                        long j2 = dVar.f3359b[i3];
                        long length = fileA.length();
                        dVar.f3359b[i3] = length;
                        this.f3349h = (this.f3349h - j2) + length;
                    }
                } else {
                    a(fileB);
                }
            }
            this.f3352k++;
            dVar.f3363f = null;
            if (!(dVar.f3362e | z)) {
                this.f3351j.remove(dVar.a);
                this.f3350i.append((CharSequence) w);
                this.f3350i.append(' ');
                this.f3350i.append((CharSequence) dVar.a);
                this.f3350i.append('\n');
            } else {
                dVar.f3362e = true;
                this.f3350i.append((CharSequence) u);
                this.f3350i.append(' ');
                this.f3350i.append((CharSequence) dVar.a);
                this.f3350i.append((CharSequence) dVar.a());
                this.f3350i.append('\n');
                if (z) {
                    long j3 = this.f3353l;
                    this.f3353l = 1 + j3;
                    dVar.f3364g = j3;
                }
            }
            b(this.f3350i);
            if (this.f3349h > this.f3347f || h()) {
                this.f3354m.submit(this.f3355n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    @TargetApi(26)
    private static void a(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
