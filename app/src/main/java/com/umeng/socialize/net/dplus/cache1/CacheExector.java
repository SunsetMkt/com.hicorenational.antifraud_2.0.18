package com.umeng.socialize.net.dplus.cache1;

import android.text.TextUtils;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class CacheExector {

    /* renamed from: a */
    private static final String f13727a = "CacheExector";

    /* renamed from: b */
    private final int f13728b = 32;

    /* renamed from: c */
    private final int f13729c = 5120;

    /* renamed from: d */
    private final int f13730d = 8;

    /* renamed from: e */
    private String f13731e;

    public CacheExector(String str) {
        this.f13731e = null;
        this.f13731e = str;
    }

    /* renamed from: a */
    private double m12673a(long j2) {
        if (j2 <= 0) {
            return 0.0d;
        }
        return j2 / 1024.0d;
    }

    /* renamed from: a */
    private File m12675a() {
        if (TextUtils.isEmpty(this.f13731e)) {
            return null;
        }
        File file = new File(this.f13731e);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        String str = "Couldn't create directory" + this.f13731e;
        return null;
    }

    /* renamed from: b */
    private File m12680b(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            return m12676a(file, str);
        }
        File m12682c = m12682c(file, str);
        return m12682c == null ? m12676a(file, str) : m12682c;
    }

    /* renamed from: c */
    private File m12682c(File file, String str) {
        File[] m12679a = m12679a(file);
        if (m12679a == null || m12679a.length <= 0 || m12679a.length <= 0) {
            return null;
        }
        File file2 = m12679a[0];
        if (m12673a(file2.length()) > 32.0d) {
            return null;
        }
        return file2;
    }

    /* renamed from: d */
    private File m12683d(File file, String str) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return null;
        }
        return m12684e(file, str);
    }

    /* renamed from: e */
    private File m12684e(File file, String str) {
        File[] m12679a = m12679a(file);
        if (m12679a != null && m12679a.length > 0) {
            for (File file2 : m12679a) {
                if (m12673a(file2.length()) <= 40 && file2.getName().endsWith(str)) {
                    return file2;
                }
                String str2 = "getReadableFileFromFiles:file length don't legal" + file2.length();
                deleteFile(file2.getName());
            }
        }
        return null;
    }

    public double checkSize(String str) {
        File m12675a = m12675a();
        double d2 = 0.0d;
        if (m12675a != null && m12675a.isDirectory()) {
            File[] listFiles = m12675a.listFiles();
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (listFiles[i2] != null && listFiles[i2].getName().contains(str)) {
                    d2 += m12673a(listFiles[i2].length());
                }
            }
        }
        return d2;
    }

    public boolean deleteFile(String str) {
        File[] listFiles = m12675a().listFiles();
        boolean z = false;
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2] != null && listFiles[i2].getName().contains(str)) {
                z = listFiles[i2].delete();
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Class, java.lang.Class<T extends com.umeng.socialize.net.dplus.cache1.IReader>] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.umeng.socialize.net.dplus.cache1.CacheExector] */
    public <T extends IReader> T readFile(String str, Class<T> cls) {
        ?? r2;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        T t;
        int i2;
        File m12683d = m12683d(m12675a(), str);
        if (m12683d == null) {
            return null;
        }
        try {
            fileInputStream = new AtomicFile(m12683d).openRead();
        } catch (IOException e2) {
            r2 = UmengText.CACHE.CACHEFILE;
            SLog.error(r2, e2);
            deleteFile(m12683d.getName());
            fileInputStream = null;
        }
        try {
            if (fileInputStream == null) {
                return null;
            }
            try {
                t = (T) m12674a(m12683d.getName(), cls);
                cls = (Class<T>) new InputStreamReader(fileInputStream);
            } catch (IOException e3) {
                e = e3;
                cls = 0;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                cls = (Class<T>) null;
                r2 = 0;
            }
            try {
                bufferedReader = new BufferedReader(cls);
                i2 = 0;
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
                m12678a(fileInputStream);
                m12678a(cls);
                m12678a(r2);
                throw th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    i2++;
                    String str2 = "read file:" + i2 + readLine;
                    if (!TextUtils.isEmpty(readLine)) {
                        try {
                            sb.append(readLine);
                        } catch (Exception e5) {
                            SLog.error(UmengText.CACHE.CACHEFILE, e5);
                        }
                    }
                }
                if (t != null) {
                    t.create(sb.toString());
                }
                m12678a(fileInputStream);
                m12678a(cls);
                m12678a(bufferedReader);
                return t;
            } catch (IOException e6) {
                e = e6;
                SLog.error(UmengText.CACHE.CACHEFILE, e);
                m12678a(fileInputStream);
                m12678a(cls);
                m12678a(bufferedReader);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.OutputStreamWriter, java.io.Writer] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.umeng.socialize.net.dplus.cache1.CacheExector] */
    public boolean save(String str, String str2) {
        FileOutputStream fileOutputStream;
        File m12680b = m12680b(m12675a(), str2);
        boolean z = false;
        if (m12680b == null) {
            return false;
        }
        AtomicFile atomicFile = new AtomicFile(m12680b);
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = atomicFile.startWrite(true);
        } catch (IOException e2) {
            e = e2;
            SLog.error(UmengText.CACHE.CACHEFILE, e);
            deleteFile(m12680b.getName());
            fileOutputStream = null;
        }
        try {
            if (fileOutputStream == null) {
                return false;
            }
            try {
            } catch (IOException e3) {
                e = e3;
                e = 0;
            } catch (Throwable th) {
                th = th;
                e = 0;
            }
            if (TextUtils.isEmpty(str)) {
                e = 0;
                m12678a(bufferedWriter);
                m12678a(e);
                m12678a(fileOutputStream);
                return z;
            }
            e = new OutputStreamWriter(fileOutputStream);
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(e);
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.newLine();
                    bufferedWriter2.flush();
                    atomicFile.finishWrite(fileOutputStream);
                    bufferedWriter = bufferedWriter2;
                    z = true;
                    e = e;
                } catch (IOException e4) {
                    e = e4;
                    bufferedWriter = bufferedWriter2;
                    atomicFile.failWrite(fileOutputStream);
                    SLog.error(UmengText.CACHE.CACHEFILE, e);
                    e = e;
                    m12678a(bufferedWriter);
                    m12678a(e);
                    m12678a(fileOutputStream);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    m12678a(bufferedWriter);
                    m12678a(e);
                    m12678a(fileOutputStream);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            }
            m12678a(bufferedWriter);
            m12678a(e);
            m12678a(fileOutputStream);
            return z;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    private File m12676a(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        return new File(file, m12677a(str));
    }

    /* renamed from: b */
    private Comparator<File> m12681b() {
        return new Comparator<File>() { // from class: com.umeng.socialize.net.dplus.cache1.CacheExector.1
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                return Long.valueOf(file.length()).compareTo(Long.valueOf(file2.length()));
            }
        };
    }

    /* renamed from: a */
    private String m12677a(String str) {
        return String.valueOf(System.currentTimeMillis()) + str;
    }

    /* renamed from: a */
    private File[] m12679a(File file) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        Arrays.sort(listFiles, m12681b());
        return listFiles;
    }

    /* renamed from: a */
    private void m12678a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                SLog.error(UmengText.CACHE.CACHEFILE, e2);
            }
        }
    }

    /* renamed from: a */
    private <T extends IReader> T m12674a(String str, Class<T> cls) {
        try {
            return cls.getConstructor(String.class).newInstance(str);
        } catch (Throwable th) {
            SLog.error(UmengText.CACHE.CACHEFILE, th);
            return null;
        }
    }
}
