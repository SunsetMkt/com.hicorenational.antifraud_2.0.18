package p000a.p001a.p006n;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import anet.channel.util.StringUtils;
import anetwork.channel.aidl.InterfaceC0865a;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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
import p000a.p001a.InterfaceC0000a;
import p000a.p001a.p007o.C0025c;

/* compiled from: Taobao */
/* renamed from: a.a.n.a */
/* loaded from: classes.dex */
public class C0021a {

    /* renamed from: e */
    public static final String f49e = "anet.DownloadManager";

    /* renamed from: f */
    public static final int f50f = -100;

    /* renamed from: g */
    public static final int f51g = -101;

    /* renamed from: h */
    public static final int f52h = -102;

    /* renamed from: i */
    public static final int f53i = -103;

    /* renamed from: j */
    public static final int f54j = -104;

    /* renamed from: k */
    public static final int f55k = -105;

    /* renamed from: l */
    public static final int f56l = -106;

    /* renamed from: a */
    SparseArray<c> f57a;

    /* renamed from: b */
    AtomicInteger f58b;

    /* renamed from: c */
    ThreadPoolExecutor f59c;

    /* renamed from: d */
    Context f60d;

    /* compiled from: Taobao */
    /* renamed from: a.a.n.a$a */
    public interface a {
        /* renamed from: a */
        void m138a(int i2, int i3, String str);

        /* renamed from: a */
        void m139a(int i2, long j2, long j3);

        /* renamed from: a */
        void m140a(int i2, String str);
    }

    /* compiled from: Taobao */
    /* renamed from: a.a.n.a$b */
    private static class b {

        /* renamed from: a */
        static C0021a f61a = new C0021a();

        private b() {
        }
    }

    /* renamed from: b */
    public static C0021a m133b() {
        return b.f61a;
    }

    /* compiled from: Taobao */
    /* renamed from: a.a.n.a$c */
    class c implements Runnable {

        /* renamed from: a */
        final int f62a;

        /* renamed from: b */
        final URL f63b;

        /* renamed from: c */
        private final String f64c;

        /* renamed from: d */
        private final CopyOnWriteArrayList<a> f65d;

        /* renamed from: e */
        private final AtomicBoolean f66e = new AtomicBoolean(false);

        /* renamed from: f */
        private final AtomicBoolean f67f = new AtomicBoolean(false);

        /* renamed from: g */
        private volatile InterfaceC0865a f68g = null;

        /* renamed from: h */
        private boolean f69h;

        c(URL url, String str, String str2, a aVar) {
            this.f69h = true;
            this.f62a = C0021a.this.f58b.getAndIncrement();
            this.f63b = url;
            str2 = TextUtils.isEmpty(str2) ? m142a(url) : str2;
            if (TextUtils.isEmpty(str)) {
                this.f64c = C0021a.this.m134b(str2);
            } else {
                if (str.endsWith("/")) {
                    this.f64c = str + str2;
                } else {
                    this.f64c = str + '/' + str2;
                }
                if (str.startsWith("/data/user") || str.startsWith("/data/data")) {
                    this.f69h = false;
                }
            }
            this.f65d = new CopyOnWriteArrayList<>();
            this.f65d.add(aVar);
        }

        /* renamed from: a */
        public boolean m148a(a aVar) {
            if (this.f67f.get()) {
                return false;
            }
            this.f65d.add(aVar);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:177:0x0260 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:185:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:189:0x0251 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:193:0x024a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:208:0x0288 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:216:0x0280 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:220:0x0279 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:224:0x0272 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 662
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p006n.C0021a.c.run():void");
        }

        /* renamed from: a */
        public void m147a() {
            this.f66e.set(true);
            m143a(-105, "download canceled.");
            if (this.f68g != null) {
                try {
                    this.f68g.cancel();
                } catch (RemoteException unused) {
                }
            }
        }

        /* renamed from: a */
        private void m145a(String str) {
            if (this.f67f.compareAndSet(false, true)) {
                Iterator<a> it = this.f65d.iterator();
                while (it.hasNext()) {
                    it.next().m140a(this.f62a, str);
                }
            }
        }

        /* renamed from: a */
        private void m143a(int i2, String str) {
            if (this.f67f.compareAndSet(false, true)) {
                Iterator<a> it = this.f65d.iterator();
                while (it.hasNext()) {
                    it.next().m138a(this.f62a, i2, str);
                }
            }
        }

        /* renamed from: a */
        private void m144a(long j2, long j3) {
            if (this.f67f.get()) {
                return;
            }
            Iterator<a> it = this.f65d.iterator();
            while (it.hasNext()) {
                it.next().m139a(this.f62a, j2, j3);
            }
        }

        /* renamed from: a */
        private long m141a(int i2, Map<String, List<String>> map, long j2) {
            int lastIndexOf;
            try {
                if (i2 == 200) {
                    return Long.parseLong(HttpHelper.getSingleHeaderFieldByKey(map, "Content-Length"));
                }
                if (i2 != 206) {
                    return 0L;
                }
                String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Range");
                long parseLong = (singleHeaderFieldByKey == null || (lastIndexOf = singleHeaderFieldByKey.lastIndexOf(47)) == -1) ? 0L : Long.parseLong(singleHeaderFieldByKey.substring(lastIndexOf + 1));
                if (parseLong == 0) {
                    try {
                        return Long.parseLong(HttpHelper.getSingleHeaderFieldByKey(map, "Content-Length")) + j2;
                    } catch (Exception unused) {
                    }
                }
                return parseLong;
            } catch (Exception unused2) {
                return 0L;
            }
        }

        /* renamed from: a */
        private void m146a(List<InterfaceC0000a> list) {
            if (list != null) {
                ListIterator<InterfaceC0000a> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (HttpHeaders.RANGE.equalsIgnoreCase(listIterator.next().getName())) {
                        listIterator.remove();
                        return;
                    }
                }
            }
        }

        /* renamed from: a */
        private String m142a(URL url) {
            String path = url.getPath();
            int lastIndexOf = path.lastIndexOf(47);
            String substring = lastIndexOf != -1 ? path.substring(lastIndexOf + 1, path.length()) : null;
            if (!TextUtils.isEmpty(substring)) {
                return substring;
            }
            String md5ToHex = StringUtils.md5ToHex(url.toString());
            return md5ToHex == null ? url.getFile() : md5ToHex;
        }
    }

    private C0021a() {
        this.f57a = new SparseArray<>(6);
        this.f58b = new AtomicInteger(0);
        this.f59c = new ThreadPoolExecutor(2, 2, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.f60d = null;
        this.f60d = C0025c.getContext();
        this.f59c.allowCoreThreadTimeOut(true);
        m131a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m134b(String str) {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f60d.getExternalFilesDir(null));
        sb.append("/");
        sb.append("downloads");
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public int m135a(String str, String str2, a aVar) {
        return m136a(str, null, str2, aVar);
    }

    /* renamed from: a */
    public int m136a(String str, String str2, String str3, a aVar) {
        int i2 = 0;
        if (ALog.isPrintLog(2)) {
            ALog.m716i(f49e, "enqueue", null, "folder", str2, "filename", str3, "url", str);
        }
        if (this.f60d == null) {
            ALog.m715e(f49e, "network sdk not initialized.", null, new Object[0]);
            return -1;
        }
        try {
            URL url = new URL(str);
            if (!TextUtils.isEmpty(str2) && !m132a(str2)) {
                ALog.m715e(f49e, "file folder invalid.", null, new Object[0]);
                if (aVar != null) {
                    aVar.m138a(-1, -101, "file folder path invalid");
                }
                return -1;
            }
            synchronized (this.f57a) {
                int size = this.f57a.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    c valueAt = this.f57a.valueAt(i2);
                    if (!url.equals(valueAt.f63b)) {
                        i2++;
                    } else if (valueAt.m148a(aVar)) {
                        return valueAt.f62a;
                    }
                }
                c cVar = new c(url, str2, str3, aVar);
                this.f57a.put(cVar.f62a, cVar);
                this.f59c.submit(cVar);
                return cVar.f62a;
            }
        } catch (MalformedURLException e2) {
            ALog.m714e(f49e, "url invalid.", null, e2, new Object[0]);
            if (aVar != null) {
                aVar.m138a(-1, -100, "url invalid");
            }
            return -1;
        }
    }

    /* renamed from: a */
    public void m137a(int i2) {
        synchronized (this.f57a) {
            c cVar = this.f57a.get(i2);
            if (cVar != null) {
                if (ALog.isPrintLog(2)) {
                    ALog.m716i(f49e, "try cancel task" + i2 + " url=" + cVar.f63b.toString(), null, new Object[0]);
                }
                this.f57a.remove(i2);
                cVar.m147a();
            }
        }
    }

    /* renamed from: a */
    private void m131a() {
        Context context = this.f60d;
        if (context != null) {
            File file = new File(context.getExternalFilesDir(null), "downloads");
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    /* renamed from: a */
    private boolean m132a(String str) {
        if (this.f60d != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    return true;
                }
                return file.mkdir();
            } catch (Exception unused) {
                ALog.m715e(f49e, "create folder failed", null, "folder", str);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public File m129a(String str, boolean z) {
        String md5ToHex = StringUtils.md5ToHex(str);
        if (md5ToHex != null) {
            str = md5ToHex;
        }
        if (z) {
            return new File(this.f60d.getExternalCacheDir(), str);
        }
        return new File(this.f60d.getCacheDir(), str);
    }
}
