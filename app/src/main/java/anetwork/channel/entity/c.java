package anetwork.channel.entity;

import android.text.TextUtils;
import anet.channel.request.BodyEntry;
import anet.channel.util.ALog;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c implements b.a.h {

    @Deprecated
    private URI a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    private URL f1759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1760c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<b.a.a> f1762e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<b.a.g> f1764g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1769l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f1770m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f1771n;
    private Map<String, String> o;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1761d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f1763f = "GET";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1765h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f1766i = "utf-8";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BodyEntry f1767j = null;

    public c() {
    }

    @Override // b.a.h
    @Deprecated
    public void a(URI uri) {
        this.a = uri;
    }

    @Override // b.a.h
    public String b() {
        return this.f1760c;
    }

    @Override // b.a.h
    @Deprecated
    public b.a.b c() {
        return null;
    }

    @Override // b.a.h
    public b.a.a[] c(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f1762e == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.f1762e.size(); i2++) {
            if (this.f1762e.get(i2) != null && this.f1762e.get(i2).getName() != null && this.f1762e.get(i2).getName().equalsIgnoreCase(str)) {
                arrayList.add(this.f1762e.get(i2));
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        b.a.a[] aVarArr = new b.a.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return aVarArr;
    }

    @Override // b.a.h
    public void d(int i2) {
        this.f1765h = i2;
    }

    @Override // b.a.h
    public void e(String str) {
        this.f1763f = str;
    }

    @Override // b.a.h
    public String f() {
        return this.f1763f;
    }

    @Override // b.a.h
    public String g() {
        return this.f1766i;
    }

    @Override // b.a.h
    public int getConnectTimeout() {
        return this.f1768k;
    }

    @Override // b.a.h
    public List<b.a.g> getParams() {
        return this.f1764g;
    }

    @Override // b.a.h
    public int getReadTimeout() {
        return this.f1769l;
    }

    @Override // b.a.h
    public boolean h() {
        return this.f1761d;
    }

    @Override // b.a.h
    public BodyEntry i() {
        return this.f1767j;
    }

    @Override // b.a.h
    @Deprecated
    public URL j() {
        URL url = this.f1759b;
        if (url != null) {
            return url;
        }
        String str = this.f1760c;
        if (str != null) {
            try {
                this.f1759b = new URL(str);
            } catch (Exception e2) {
                ALog.e("anet.RequestImpl", "url error", this.f1771n, e2, new Object[0]);
            }
        }
        return this.f1759b;
    }

    @Override // b.a.h
    public int k() {
        return this.f1765h;
    }

    @Override // b.a.h
    public String l() {
        return this.f1771n;
    }

    @Override // b.a.h
    @Deprecated
    public URI m() {
        URI uri = this.a;
        if (uri != null) {
            return uri;
        }
        String str = this.f1760c;
        if (str != null) {
            try {
                this.a = new URI(str);
            } catch (Exception e2) {
                ALog.e("anet.RequestImpl", "uri error", this.f1771n, e2, new Object[0]);
            }
        }
        return this.a;
    }

    @Override // b.a.h
    public String n() {
        return this.f1770m;
    }

    @Deprecated
    public void a(URL url) {
        this.f1759b = url;
        this.f1760c = url.toString();
    }

    @Override // b.a.h
    public void b(boolean z) {
        this.f1761d = z;
    }

    @Override // b.a.h
    public void d(String str) {
        this.f1770m = str;
    }

    @Override // b.a.h
    @Deprecated
    public boolean e() {
        return !b.a.u.a.f1909k.equals(f(b.a.u.a.f1902d));
    }

    @Override // b.a.h
    public String f(String str) {
        Map<String, String> map = this.o;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // b.a.h
    public void b(List<b.a.a> list) {
        this.f1762e = list;
    }

    @Override // b.a.h
    public Map<String, String> d() {
        return this.o;
    }

    @Override // b.a.h
    public List<b.a.a> a() {
        return this.f1762e;
    }

    @Override // b.a.h
    public void b(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        if (this.f1762e == null) {
            this.f1762e = new ArrayList();
        }
        this.f1762e.add(new a(str, str2));
    }

    @Override // b.a.h
    public void a(b.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f1762e == null) {
            this.f1762e = new ArrayList();
        }
        int i2 = 0;
        int size = this.f1762e.size();
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (aVar.getName().equalsIgnoreCase(this.f1762e.get(i2).getName())) {
                this.f1762e.set(i2, aVar);
                break;
            }
            i2++;
        }
        if (i2 < this.f1762e.size()) {
            this.f1762e.add(aVar);
        }
    }

    @Deprecated
    public c(URI uri) {
        this.a = uri;
        this.f1760c = uri.toString();
    }

    @Override // b.a.h
    public void b(b.a.a aVar) {
        List<b.a.a> list = this.f1762e;
        if (list != null) {
            list.remove(aVar);
        }
    }

    @Override // b.a.h
    public void c(int i2) {
        this.f1769l = i2;
    }

    @Override // b.a.h
    public void b(String str) {
        this.f1766i = str;
    }

    @Override // b.a.h
    @Deprecated
    public void b(int i2) {
        this.f1770m = String.valueOf(i2);
    }

    @Override // b.a.h
    public void a(List<b.a.g> list) {
        this.f1764g = list;
    }

    @Override // b.a.h
    public void a(BodyEntry bodyEntry) {
        this.f1767j = bodyEntry;
    }

    @Deprecated
    public c(URL url) {
        this.f1759b = url;
        this.f1760c = url.toString();
    }

    @Override // b.a.h
    public void a(b.a.b bVar) {
        this.f1767j = new BodyHandlerEntry(bVar);
    }

    @Override // b.a.h
    public void a(int i2) {
        this.f1768k = i2;
    }

    @Override // b.a.h
    public void a(String str) {
        this.f1771n = str;
    }

    @Override // b.a.h
    @Deprecated
    public void a(boolean z) {
        a(b.a.u.a.f1902d, z ? b.a.u.a.f1908j : b.a.u.a.f1909k);
    }

    @Override // b.a.h
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.o == null) {
            this.o = new HashMap();
        }
        this.o.put(str, str2);
    }

    public c(String str) {
        this.f1760c = str;
    }
}
