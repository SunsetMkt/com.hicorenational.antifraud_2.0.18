package com.bumptech.glide.p133n;

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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: DiskLruCache.java */
/* renamed from: com.bumptech.glide.n.a */
/* loaded from: classes.dex */
public final class C1801a implements Closeable {

    /* renamed from: o */
    static final String f5101o = "journal";

    /* renamed from: p */
    static final String f5102p = "journal.tmp";

    /* renamed from: q */
    static final String f5103q = "journal.bkp";

    /* renamed from: r */
    static final String f5104r = "libcore.io.DiskLruCache";

    /* renamed from: s */
    static final String f5105s = "1";

    /* renamed from: t */
    static final long f5106t = -1;

    /* renamed from: u */
    private static final String f5107u = "CLEAN";

    /* renamed from: v */
    private static final String f5108v = "DIRTY";

    /* renamed from: w */
    private static final String f5109w = "REMOVE";

    /* renamed from: x */
    private static final String f5110x = "READ";

    /* renamed from: a */
    private final File f5111a;

    /* renamed from: b */
    private final File f5112b;

    /* renamed from: c */
    private final File f5113c;

    /* renamed from: d */
    private final File f5114d;

    /* renamed from: e */
    private final int f5115e;

    /* renamed from: f */
    private long f5116f;

    /* renamed from: g */
    private final int f5117g;

    /* renamed from: i */
    private Writer f5119i;

    /* renamed from: k */
    private int f5121k;

    /* renamed from: h */
    private long f5118h = 0;

    /* renamed from: j */
    private final LinkedHashMap<String, d> f5120j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l */
    private long f5122l = 0;

    /* renamed from: m */
    final ThreadPoolExecutor f5123m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* renamed from: n */
    private final Callable<Void> f5124n = new a();

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.n.a$a */
    class a implements Callable<Void> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (C1801a.this) {
                if (C1801a.this.f5119i == null) {
                    return null;
                }
                C1801a.this.m4591l();
                if (C1801a.this.m4587h()) {
                    C1801a.this.m4590k();
                    C1801a.this.f5121k = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.n.a$b */
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

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.n.a$c */
    public final class c {

        /* renamed from: a */
        private final d f5126a;

        /* renamed from: b */
        private final boolean[] f5127b;

        /* renamed from: c */
        private boolean f5128c;

        /* synthetic */ c(C1801a c1801a, d dVar, a aVar) {
            this(dVar);
        }

        /* renamed from: c */
        private InputStream m4602c(int i2) throws IOException {
            synchronized (C1801a.this) {
                if (this.f5126a.f5135f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f5126a.f5134e) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f5126a.m4620a(i2));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        private c(d dVar) {
            this.f5126a = dVar;
            this.f5127b = dVar.f5134e ? null : new boolean[C1801a.this.f5117g];
        }

        /* renamed from: a */
        public File m4603a(int i2) throws IOException {
            File m4622b;
            synchronized (C1801a.this) {
                if (this.f5126a.f5135f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f5126a.f5134e) {
                    this.f5127b[i2] = true;
                }
                m4622b = this.f5126a.m4622b(i2);
                if (!C1801a.this.f5111a.exists()) {
                    C1801a.this.f5111a.mkdirs();
                }
            }
            return m4622b;
        }

        /* renamed from: b */
        public String m4606b(int i2) throws IOException {
            InputStream m4602c = m4602c(i2);
            if (m4602c != null) {
                return C1801a.m4579b(m4602c);
            }
            return null;
        }

        /* renamed from: b */
        public void m4607b() {
            if (this.f5128c) {
                return;
            }
            try {
                m4604a();
            } catch (IOException unused) {
            }
        }

        /* renamed from: c */
        public void m4608c() throws IOException {
            C1801a.this.m4573a(this, true);
            this.f5128c = true;
        }

        /* renamed from: a */
        public void m4605a(int i2, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(m4603a(i2)), C1803c.f5152b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                C1803c.m4632a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                C1803c.m4632a(outputStreamWriter2);
                throw th;
            }
        }

        /* renamed from: a */
        public void m4604a() throws IOException {
            C1801a.this.m4573a(this, false);
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.n.a$d */
    private final class d {

        /* renamed from: a */
        private final String f5130a;

        /* renamed from: b */
        private final long[] f5131b;

        /* renamed from: c */
        File[] f5132c;

        /* renamed from: d */
        File[] f5133d;

        /* renamed from: e */
        private boolean f5134e;

        /* renamed from: f */
        private c f5135f;

        /* renamed from: g */
        private long f5136g;

        /* synthetic */ d(C1801a c1801a, String str, a aVar) {
            this(str);
        }

        private d(String str) {
            this.f5130a = str;
            this.f5131b = new long[C1801a.this.f5117g];
            this.f5132c = new File[C1801a.this.f5117g];
            this.f5133d = new File[C1801a.this.f5117g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < C1801a.this.f5117g; i2++) {
                sb.append(i2);
                this.f5132c[i2] = new File(C1801a.this.f5111a, sb.toString());
                sb.append(".tmp");
                this.f5133d[i2] = new File(C1801a.this.f5111a, sb.toString());
                sb.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m4616b(String[] strArr) throws IOException {
            if (strArr.length != C1801a.this.f5117g) {
                throw m4611a(strArr);
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.f5131b[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    throw m4611a(strArr);
                }
            }
        }

        /* renamed from: a */
        public String m4621a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f5131b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }

        /* renamed from: b */
        public File m4622b(int i2) {
            return this.f5133d[i2];
        }

        /* renamed from: a */
        private IOException m4611a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public File m4620a(int i2) {
            return this.f5132c[i2];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.n.a$e */
    public final class e {

        /* renamed from: a */
        private final String f5138a;

        /* renamed from: b */
        private final long f5139b;

        /* renamed from: c */
        private final long[] f5140c;

        /* renamed from: d */
        private final File[] f5141d;

        /* synthetic */ e(C1801a c1801a, String str, long j2, File[] fileArr, long[] jArr, a aVar) {
            this(str, j2, fileArr, jArr);
        }

        /* renamed from: a */
        public c m4623a() throws IOException {
            return C1801a.this.m4569a(this.f5138a, this.f5139b);
        }

        /* renamed from: b */
        public long m4625b(int i2) {
            return this.f5140c[i2];
        }

        /* renamed from: c */
        public String m4626c(int i2) throws IOException {
            return C1801a.m4579b(new FileInputStream(this.f5141d[i2]));
        }

        private e(String str, long j2, File[] fileArr, long[] jArr) {
            this.f5138a = str;
            this.f5139b = j2;
            this.f5141d = fileArr;
            this.f5140c = jArr;
        }

        /* renamed from: a */
        public File m4624a(int i2) {
            return this.f5141d[i2];
        }
    }

    private C1801a(File file, int i2, int i3, long j2) {
        this.f5111a = file;
        this.f5115e = i2;
        this.f5112b = new File(file, f5101o);
        this.f5113c = new File(file, f5102p);
        this.f5114d = new File(file, f5103q);
        this.f5117g = i3;
        this.f5116f = j2;
    }

    /* renamed from: g */
    private void m4586g() {
        if (this.f5119i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m4587h() {
        int i2 = this.f5121k;
        return i2 >= 2000 && i2 >= this.f5120j.size();
    }

    /* renamed from: i */
    private void m4588i() throws IOException {
        m4575a(this.f5113c);
        Iterator<d> it = this.f5120j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i2 = 0;
            if (next.f5135f == null) {
                while (i2 < this.f5117g) {
                    this.f5118h += next.f5131b[i2];
                    i2++;
                }
            } else {
                next.f5135f = null;
                while (i2 < this.f5117g) {
                    m4575a(next.m4620a(i2));
                    m4575a(next.m4622b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* renamed from: j */
    private void m4589j() throws IOException {
        C1802b c1802b = new C1802b(new FileInputStream(this.f5112b), C1803c.f5151a);
        try {
            String m4630d = c1802b.m4630d();
            String m4630d2 = c1802b.m4630d();
            String m4630d3 = c1802b.m4630d();
            String m4630d4 = c1802b.m4630d();
            String m4630d5 = c1802b.m4630d();
            if (!f5104r.equals(m4630d) || !"1".equals(m4630d2) || !Integer.toString(this.f5115e).equals(m4630d3) || !Integer.toString(this.f5117g).equals(m4630d4) || !"".equals(m4630d5)) {
                throw new IOException("unexpected journal header: [" + m4630d + ", " + m4630d2 + ", " + m4630d4 + ", " + m4630d5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    m4583d(c1802b.m4630d());
                    i2++;
                } catch (EOFException unused) {
                    this.f5121k = i2 - this.f5120j.size();
                    if (c1802b.m4629c()) {
                        m4590k();
                    } else {
                        this.f5119i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5112b, true), C1803c.f5151a));
                    }
                    C1803c.m4632a(c1802b);
                    return;
                }
            }
        } catch (Throwable th) {
            C1803c.m4632a(c1802b);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public synchronized void m4590k() throws IOException {
        if (this.f5119i != null) {
            m4577a(this.f5119i);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5113c), C1803c.f5151a));
        try {
            bufferedWriter.write(f5104r);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f5115e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f5117g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.f5120j.values()) {
                if (dVar.f5135f != null) {
                    bufferedWriter.write("DIRTY " + dVar.f5130a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f5130a + dVar.m4621a() + '\n');
                }
            }
            m4577a(bufferedWriter);
            if (this.f5112b.exists()) {
                m4576a(this.f5112b, this.f5114d, true);
            }
            m4576a(this.f5113c, this.f5112b, false);
            this.f5114d.delete();
            this.f5119i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5112b, true), C1803c.f5151a));
        } catch (Throwable th) {
            m4577a(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m4591l() throws IOException {
        while (this.f5118h > this.f5116f) {
            m4596c(this.f5120j.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f5119i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f5120j.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f5135f != null) {
                dVar.f5135f.m4604a();
            }
        }
        m4591l();
        m4577a(this.f5119i);
        this.f5119i = null;
    }

    public synchronized void flush() throws IOException {
        m4586g();
        m4591l();
        m4580b(this.f5119i);
    }

    public synchronized boolean isClosed() {
        return this.f5119i == null;
    }

    /* renamed from: d */
    private void m4583d(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i2);
        if (indexOf2 == -1) {
            substring = str.substring(i2);
            if (indexOf == 6 && str.startsWith(f5109w)) {
                this.f5120j.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i2, indexOf2);
        }
        d dVar = this.f5120j.get(substring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, substring, aVar);
            this.f5120j.put(substring, dVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(f5107u)) {
            String[] split = str.substring(indexOf2 + 1).split(AbstractC1191a.f2568g);
            dVar.f5134e = true;
            dVar.f5135f = null;
            dVar.m4616b(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith(f5108v)) {
            dVar.f5135f = new c(this, dVar, aVar);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith(f5110x)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* renamed from: b */
    public synchronized e m4594b(String str) throws IOException {
        m4586g();
        d dVar = this.f5120j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f5134e) {
            return null;
        }
        for (File file : dVar.f5132c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f5121k++;
        this.f5119i.append((CharSequence) f5110x);
        this.f5119i.append(' ');
        this.f5119i.append((CharSequence) str);
        this.f5119i.append('\n');
        if (m4587h()) {
            this.f5123m.submit(this.f5124n);
        }
        return new e(this, str, dVar.f5136g, dVar.f5132c, dVar.f5131b, null);
    }

    /* renamed from: c */
    public synchronized boolean m4596c(String str) throws IOException {
        m4586g();
        d dVar = this.f5120j.get(str);
        if (dVar != null && dVar.f5135f == null) {
            for (int i2 = 0; i2 < this.f5117g; i2++) {
                File m4620a = dVar.m4620a(i2);
                if (m4620a.exists() && !m4620a.delete()) {
                    throw new IOException("failed to delete " + m4620a);
                }
                this.f5118h -= dVar.f5131b[i2];
                dVar.f5131b[i2] = 0;
            }
            this.f5121k++;
            this.f5119i.append((CharSequence) f5109w);
            this.f5119i.append(' ');
            this.f5119i.append((CharSequence) str);
            this.f5119i.append('\n');
            this.f5120j.remove(str);
            if (m4587h()) {
                this.f5123m.submit(this.f5124n);
            }
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public synchronized long m4598e() {
        return this.f5116f;
    }

    /* renamed from: f */
    public synchronized long m4599f() {
        return this.f5118h;
    }

    /* renamed from: a */
    public static C1801a m4570a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 > 0) {
            File file2 = new File(file, f5103q);
            if (file2.exists()) {
                File file3 = new File(file, f5101o);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m4576a(file2, file3, false);
                }
            }
            C1801a c1801a = new C1801a(file, i2, i3, j2);
            if (c1801a.f5112b.exists()) {
                try {
                    c1801a.m4589j();
                    c1801a.m4588i();
                    return c1801a;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    c1801a.m4595c();
                }
            }
            file.mkdirs();
            C1801a c1801a2 = new C1801a(file, i2, i3, j2);
            c1801a2.m4590k();
            return c1801a2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m4579b(InputStream inputStream) throws IOException {
        return C1803c.m4631a((Reader) new InputStreamReader(inputStream, C1803c.f5152b));
    }

    @TargetApi(26)
    /* renamed from: b */
    private static void m4580b(Writer writer) throws IOException {
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

    /* renamed from: c */
    public void m4595c() throws IOException {
        close();
        C1803c.m4633a(this.f5111a);
    }

    /* renamed from: d */
    public File m4597d() {
        return this.f5111a;
    }

    /* renamed from: a */
    private static void m4575a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m4576a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m4575a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    public c m4592a(String str) throws IOException {
        return m4569a(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized c m4569a(String str, long j2) throws IOException {
        m4586g();
        d dVar = this.f5120j.get(str);
        a aVar = null;
        if (j2 != -1 && (dVar == null || dVar.f5136g != j2)) {
            return null;
        }
        if (dVar != null) {
            if (dVar.f5135f != null) {
                return null;
            }
        } else {
            dVar = new d(this, str, aVar);
            this.f5120j.put(str, dVar);
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f5135f = cVar;
        this.f5119i.append((CharSequence) f5108v);
        this.f5119i.append(' ');
        this.f5119i.append((CharSequence) str);
        this.f5119i.append('\n');
        m4580b(this.f5119i);
        return cVar;
    }

    /* renamed from: a */
    public synchronized void m4593a(long j2) {
        this.f5116f = j2;
        this.f5123m.submit(this.f5124n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m4573a(c cVar, boolean z) throws IOException {
        d dVar = cVar.f5126a;
        if (dVar.f5135f == cVar) {
            if (z && !dVar.f5134e) {
                for (int i2 = 0; i2 < this.f5117g; i2++) {
                    if (cVar.f5127b[i2]) {
                        if (!dVar.m4622b(i2).exists()) {
                            cVar.m4604a();
                            return;
                        }
                    } else {
                        cVar.m4604a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f5117g; i3++) {
                File m4622b = dVar.m4622b(i3);
                if (z) {
                    if (m4622b.exists()) {
                        File m4620a = dVar.m4620a(i3);
                        m4622b.renameTo(m4620a);
                        long j2 = dVar.f5131b[i3];
                        long length = m4620a.length();
                        dVar.f5131b[i3] = length;
                        this.f5118h = (this.f5118h - j2) + length;
                    }
                } else {
                    m4575a(m4622b);
                }
            }
            this.f5121k++;
            dVar.f5135f = null;
            if (!(dVar.f5134e | z)) {
                this.f5120j.remove(dVar.f5130a);
                this.f5119i.append((CharSequence) f5109w);
                this.f5119i.append(' ');
                this.f5119i.append((CharSequence) dVar.f5130a);
                this.f5119i.append('\n');
            } else {
                dVar.f5134e = true;
                this.f5119i.append((CharSequence) f5107u);
                this.f5119i.append(' ');
                this.f5119i.append((CharSequence) dVar.f5130a);
                this.f5119i.append((CharSequence) dVar.m4621a());
                this.f5119i.append('\n');
                if (z) {
                    long j3 = this.f5122l;
                    this.f5122l = 1 + j3;
                    dVar.f5136g = j3;
                }
            }
            m4580b(this.f5119i);
            if (this.f5118h > this.f5116f || m4587h()) {
                this.f5123m.submit(this.f5124n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    @TargetApi(26)
    /* renamed from: a */
    private static void m4577a(Writer writer) throws IOException {
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
