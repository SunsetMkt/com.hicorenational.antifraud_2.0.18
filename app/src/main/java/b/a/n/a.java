package b.a.n;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import anet.channel.util.StringUtils;
import anetwork.channel.aidl.f;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f1826e = "anet.DownloadManager";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f1827f = -100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1828g = -101;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f1829h = -102;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f1830i = -103;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f1831j = -104;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f1832k = -105;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f1833l = -106;
    SparseArray<c> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    AtomicInteger f1834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ThreadPoolExecutor f1835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Context f1836d;

    /* JADX INFO: renamed from: b.a.n.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    public interface InterfaceC0024a {
        void a(int i2, int i3, String str);

        void a(int i2, long j2, long j3);

        void a(int i2, String str);
    }

    /* JADX INFO: compiled from: Taobao */
    private static class b {
        static a a = new a();

        private b() {
        }
    }

    public static a b() {
        return b.a;
    }

    /* JADX INFO: compiled from: Taobao */
    class c implements Runnable {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final URL f1837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f1838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CopyOnWriteArrayList<InterfaceC0024a> f1839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AtomicBoolean f1840e = new AtomicBoolean(false);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicBoolean f1841f = new AtomicBoolean(false);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile anetwork.channel.aidl.a f1842g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f1843h;

        c(URL url, String str, String str2, InterfaceC0024a interfaceC0024a) {
            this.f1843h = true;
            this.a = a.this.f1834b.getAndIncrement();
            this.f1837b = url;
            str2 = TextUtils.isEmpty(str2) ? a(url) : str2;
            if (TextUtils.isEmpty(str)) {
                this.f1838c = a.this.b(str2);
            } else {
                if (str.endsWith("/")) {
                    this.f1838c = str + str2;
                } else {
                    this.f1838c = str + '/' + str2;
                }
                if (str.startsWith("/data/user") || str.startsWith("/data/data")) {
                    this.f1843h = false;
                }
            }
            this.f1839d = new CopyOnWriteArrayList<>();
            this.f1839d.add(interfaceC0024a);
        }

        public boolean a(InterfaceC0024a interfaceC0024a) {
            if (this.f1841f.get()) {
                return false;
            }
            this.f1839d.add(interfaceC0024a);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:208:0x0272 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:212:0x0260 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:220:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:224:0x024a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:234:0x0251 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:244:0x0288 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:246:0x0279 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:258:0x0280 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            f fVar;
            RandomAccessFile randomAccessFile;
            BufferedOutputStream bufferedOutputStream;
            f fVarK;
            long jA;
            if (this.f1840e.get()) {
                return;
            }
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    File fileA = a.this.a(this.f1837b.toString(), this.f1843h);
                    boolean zExists = fileA.exists();
                    anetwork.channel.entity.c cVar = new anetwork.channel.entity.c(this.f1837b);
                    cVar.d(0);
                    cVar.b(true);
                    if (zExists) {
                        cVar.b(HttpHeaders.RANGE, "bytes=" + fileA.length() + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                    b.a.m.a aVar = new b.a.m.a(a.this.f1836d);
                    this.f1842g = aVar.b(cVar, null);
                    int statusCode = this.f1842g.getStatusCode();
                    if (statusCode > 0 && (statusCode == 200 || statusCode == 206 || statusCode == 416)) {
                        if (zExists) {
                            if (statusCode == 416) {
                                a(cVar.a());
                                if (this.f1840e.get()) {
                                    synchronized (a.this.a) {
                                        a.this.a.remove(this.a);
                                    }
                                    return;
                                }
                                this.f1842g = aVar.b(cVar, null);
                                zExists = false;
                            }
                            if (statusCode == 200) {
                                zExists = false;
                            }
                        }
                        if (this.f1840e.get()) {
                            synchronized (a.this.a) {
                                a.this.a.remove(this.a);
                            }
                            return;
                        }
                        long length = 0;
                        if (zExists) {
                            RandomAccessFile randomAccessFile2 = new RandomAccessFile(fileA, "rw");
                            try {
                                length = randomAccessFile2.length();
                                randomAccessFile2.seek(length);
                                randomAccessFile = randomAccessFile2;
                                bufferedOutputStream = new BufferedOutputStream(Channels.newOutputStream(randomAccessFile2.getChannel()));
                            } catch (Exception e2) {
                                e = e2;
                                fVarK = null;
                                randomAccessFile = randomAccessFile2;
                                bufferedOutputStream = null;
                                ALog.e(a.f1826e, "file download failed!", null, e, new Object[0]);
                                a(a.f1831j, e.toString());
                                if (bufferedOutputStream != null) {
                                }
                                if (randomAccessFile != null) {
                                }
                                if (fVarK != null) {
                                }
                                synchronized (a.this.a) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                fVar = null;
                                randomAccessFile = randomAccessFile2;
                                if (bufferedOutputStream2 != null) {
                                }
                                if (randomAccessFile != null) {
                                }
                                if (fVar != null) {
                                }
                                synchronized (a.this.a) {
                                }
                            }
                        } else {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileA));
                            randomAccessFile = null;
                        }
                        try {
                            jA = a(statusCode, this.f1842g.f(), length);
                            fVarK = this.f1842g.k();
                        } catch (Exception e3) {
                            e = e3;
                            fVarK = null;
                        } catch (Throwable th2) {
                            th = th2;
                            fVar = null;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (fVar != null) {
                                try {
                                    fVar.close();
                                } catch (Exception unused3) {
                                }
                            }
                            synchronized (a.this.a) {
                                a.this.a.remove(this.a);
                            }
                            throw th;
                        }
                        try {
                            if (fVarK == null) {
                                a(-103, "input stream is null.");
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception unused4) {
                                }
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception unused5) {
                                    }
                                }
                                if (fVarK != null) {
                                    try {
                                        fVarK.close();
                                    } catch (Exception unused6) {
                                    }
                                }
                                synchronized (a.this.a) {
                                    a.this.a.remove(this.a);
                                }
                                return;
                            }
                            byte[] bArr = new byte[2048];
                            int i2 = 0;
                            while (true) {
                                int i3 = fVarK.read(bArr);
                                if (i3 == -1) {
                                    bufferedOutputStream.flush();
                                    if (this.f1840e.get()) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (Exception unused7) {
                                        }
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                            } catch (Exception unused8) {
                                            }
                                        }
                                        if (fVarK != null) {
                                            try {
                                                fVarK.close();
                                            } catch (Exception unused9) {
                                            }
                                        }
                                        synchronized (a.this.a) {
                                            a.this.a.remove(this.a);
                                        }
                                        return;
                                    }
                                    if (fileA.renameTo(new File(this.f1838c))) {
                                        a(this.f1838c);
                                    } else {
                                        a(a.f1833l, "file rename to " + this.f1838c + " failed");
                                    }
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception unused10) {
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (Exception unused11) {
                                        }
                                    }
                                    if (fVarK != null) {
                                        try {
                                            fVarK.close();
                                        } catch (Exception unused12) {
                                        }
                                    }
                                    synchronized (a.this.a) {
                                        a.this.a.remove(this.a);
                                    }
                                    return;
                                }
                                if (this.f1840e.get()) {
                                    this.f1842g.cancel();
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception unused13) {
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (Exception unused14) {
                                        }
                                    }
                                    if (fVarK != null) {
                                        try {
                                            fVarK.close();
                                        } catch (Exception unused15) {
                                        }
                                    }
                                    synchronized (a.this.a) {
                                        a.this.a.remove(this.a);
                                    }
                                    return;
                                }
                                i2 += i3;
                                bufferedOutputStream.write(bArr, 0, i3);
                                a(((long) i2) + length, jA);
                            }
                        } catch (Exception e4) {
                            e = e4;
                            ALog.e(a.f1826e, "file download failed!", null, e, new Object[0]);
                            a(a.f1831j, e.toString());
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception unused16) {
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception unused17) {
                                }
                            }
                            if (fVarK != null) {
                                try {
                                    fVarK.close();
                                } catch (Exception unused18) {
                                }
                            }
                            synchronized (a.this.a) {
                                a.this.a.remove(this.a);
                            }
                            return;
                        }
                    }
                    a(-102, "ResponseCode:" + statusCode);
                    synchronized (a.this.a) {
                        a.this.a.remove(this.a);
                    }
                } catch (Exception e5) {
                    e = e5;
                    bufferedOutputStream = null;
                    fVarK = null;
                    randomAccessFile = null;
                } catch (Throwable th3) {
                    th = th3;
                    fVar = null;
                    randomAccessFile = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }

        public void a() {
            this.f1840e.set(true);
            a(-105, "download canceled.");
            if (this.f1842g != null) {
                try {
                    this.f1842g.cancel();
                } catch (RemoteException unused) {
                }
            }
        }

        private void a(String str) {
            if (this.f1841f.compareAndSet(false, true)) {
                Iterator<InterfaceC0024a> it = this.f1839d.iterator();
                while (it.hasNext()) {
                    it.next().a(this.a, str);
                }
            }
        }

        private void a(int i2, String str) {
            if (this.f1841f.compareAndSet(false, true)) {
                Iterator<InterfaceC0024a> it = this.f1839d.iterator();
                while (it.hasNext()) {
                    it.next().a(this.a, i2, str);
                }
            }
        }

        private void a(long j2, long j3) {
            if (this.f1841f.get()) {
                return;
            }
            Iterator<InterfaceC0024a> it = this.f1839d.iterator();
            while (it.hasNext()) {
                it.next().a(this.a, j2, j3);
            }
        }

        private long a(int i2, Map<String, List<String>> map, long j2) {
            int iLastIndexOf;
            try {
                if (i2 == 200) {
                    return Long.parseLong(HttpHelper.getSingleHeaderFieldByKey(map, "Content-Length"));
                }
                if (i2 != 206) {
                    return 0L;
                }
                String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Range");
                long j3 = (singleHeaderFieldByKey == null || (iLastIndexOf = singleHeaderFieldByKey.lastIndexOf(47)) == -1) ? 0L : Long.parseLong(singleHeaderFieldByKey.substring(iLastIndexOf + 1));
                if (j3 == 0) {
                    try {
                        return Long.parseLong(HttpHelper.getSingleHeaderFieldByKey(map, "Content-Length")) + j2;
                    } catch (Exception unused) {
                    }
                }
                return j3;
            } catch (Exception unused2) {
                return 0L;
            }
        }

        private void a(List<b.a.a> list) {
            if (list != null) {
                ListIterator<b.a.a> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (HttpHeaders.RANGE.equalsIgnoreCase(listIterator.next().getName())) {
                        listIterator.remove();
                        return;
                    }
                }
            }
        }

        private String a(URL url) {
            String path = url.getPath();
            int iLastIndexOf = path.lastIndexOf(47);
            String strSubstring = iLastIndexOf != -1 ? path.substring(iLastIndexOf + 1, path.length()) : null;
            if (!TextUtils.isEmpty(strSubstring)) {
                return strSubstring;
            }
            String strMd5ToHex = StringUtils.md5ToHex(url.toString());
            return strMd5ToHex == null ? url.getFile() : strMd5ToHex;
        }
    }

    private a() {
        this.a = new SparseArray<>(6);
        this.f1834b = new AtomicInteger(0);
        this.f1835c = new ThreadPoolExecutor(2, 2, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.f1836d = null;
        this.f1836d = b.a.o.c.getContext();
        this.f1835c.allowCoreThreadTimeOut(true);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f1836d.getExternalFilesDir(null));
        sb.append("/");
        sb.append("downloads");
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public int a(String str, String str2, InterfaceC0024a interfaceC0024a) {
        return a(str, null, str2, interfaceC0024a);
    }

    public int a(String str, String str2, String str3, InterfaceC0024a interfaceC0024a) {
        int i2 = 0;
        if (ALog.isPrintLog(2)) {
            ALog.i(f1826e, "enqueue", null, "folder", str2, "filename", str3, "url", str);
        }
        if (this.f1836d == null) {
            ALog.e(f1826e, "network sdk not initialized.", null, new Object[0]);
            return -1;
        }
        try {
            URL url = new URL(str);
            if (!TextUtils.isEmpty(str2) && !a(str2)) {
                ALog.e(f1826e, "file folder invalid.", null, new Object[0]);
                if (interfaceC0024a != null) {
                    interfaceC0024a.a(-1, -101, "file folder path invalid");
                }
                return -1;
            }
            synchronized (this.a) {
                int size = this.a.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    c cVarValueAt = this.a.valueAt(i2);
                    if (!url.equals(cVarValueAt.f1837b)) {
                        i2++;
                    } else if (cVarValueAt.a(interfaceC0024a)) {
                        return cVarValueAt.a;
                    }
                }
                c cVar = new c(url, str2, str3, interfaceC0024a);
                this.a.put(cVar.a, cVar);
                this.f1835c.submit(cVar);
                return cVar.a;
            }
        } catch (MalformedURLException e2) {
            ALog.e(f1826e, "url invalid.", null, e2, new Object[0]);
            if (interfaceC0024a != null) {
                interfaceC0024a.a(-1, -100, "url invalid");
            }
            return -1;
        }
    }

    public void a(int i2) {
        synchronized (this.a) {
            c cVar = this.a.get(i2);
            if (cVar != null) {
                if (ALog.isPrintLog(2)) {
                    ALog.i(f1826e, "try cancel task" + i2 + " url=" + cVar.f1837b.toString(), null, new Object[0]);
                }
                this.a.remove(i2);
                cVar.a();
            }
        }
    }

    private void a() {
        Context context = this.f1836d;
        if (context != null) {
            File file = new File(context.getExternalFilesDir(null), "downloads");
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    private boolean a(String str) {
        if (this.f1836d != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    return true;
                }
                return file.mkdir();
            } catch (Exception unused) {
                ALog.e(f1826e, "create folder failed", null, "folder", str);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File a(String str, boolean z) {
        String strMd5ToHex = StringUtils.md5ToHex(str);
        if (strMd5ToHex != null) {
            str = strMd5ToHex;
        }
        if (z) {
            return new File(this.f1836d.getExternalCacheDir(), str);
        }
        return new File(this.f1836d.getCacheDir(), str);
    }
}
