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
import p000a.p001a.InterfaceC0000a;
import p000a.p001a.InterfaceC0001b;
import p000a.p001a.InterfaceC0006g;
import p000a.p001a.InterfaceC0007h;
import p000a.p001a.p014u.C0052a;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.entity.c */
/* loaded from: classes.dex */
public class C0891c implements InterfaceC0007h {

    /* renamed from: a */
    @Deprecated
    private URI f1323a;

    /* renamed from: b */
    @Deprecated
    private URL f1324b;

    /* renamed from: c */
    private String f1325c;

    /* renamed from: e */
    private List<InterfaceC0000a> f1327e;

    /* renamed from: g */
    private List<InterfaceC0006g> f1329g;

    /* renamed from: k */
    private int f1333k;

    /* renamed from: l */
    private int f1334l;

    /* renamed from: m */
    private String f1335m;

    /* renamed from: n */
    private String f1336n;

    /* renamed from: o */
    private Map<String, String> f1337o;

    /* renamed from: d */
    private boolean f1326d = true;

    /* renamed from: f */
    private String f1328f = "GET";

    /* renamed from: h */
    private int f1330h = 2;

    /* renamed from: i */
    private String f1331i = "utf-8";

    /* renamed from: j */
    private BodyEntry f1332j = null;

    public C0891c() {
    }

    @Override // p000a.p001a.InterfaceC0007h
    @Deprecated
    /* renamed from: a */
    public void mo23a(URI uri) {
        this.f1323a = uri;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: b */
    public String mo26b() {
        return this.f1325c;
    }

    @Override // p000a.p001a.InterfaceC0007h
    @Deprecated
    /* renamed from: c */
    public InterfaceC0001b mo33c() {
        return null;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: c */
    public InterfaceC0000a[] mo35c(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f1327e == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.f1327e.size(); i2++) {
            if (this.f1327e.get(i2) != null && this.f1327e.get(i2).getName() != null && this.f1327e.get(i2).getName().equalsIgnoreCase(str)) {
                arrayList.add(this.f1327e.get(i2));
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        InterfaceC0000a[] interfaceC0000aArr = new InterfaceC0000a[arrayList.size()];
        arrayList.toArray(interfaceC0000aArr);
        return interfaceC0000aArr;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: d */
    public void mo37d(int i2) {
        this.f1330h = i2;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: e */
    public void mo39e(String str) {
        this.f1328f = str;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: f */
    public String mo41f() {
        return this.f1328f;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: g */
    public String mo43g() {
        return this.f1331i;
    }

    @Override // p000a.p001a.InterfaceC0007h
    public int getConnectTimeout() {
        return this.f1333k;
    }

    @Override // p000a.p001a.InterfaceC0007h
    public List<InterfaceC0006g> getParams() {
        return this.f1329g;
    }

    @Override // p000a.p001a.InterfaceC0007h
    public int getReadTimeout() {
        return this.f1334l;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: h */
    public boolean mo44h() {
        return this.f1326d;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: i */
    public BodyEntry mo45i() {
        return this.f1332j;
    }

    @Override // p000a.p001a.InterfaceC0007h
    @Deprecated
    /* renamed from: j */
    public URL mo46j() {
        URL url = this.f1324b;
        if (url != null) {
            return url;
        }
        String str = this.f1325c;
        if (str != null) {
            try {
                this.f1324b = new URL(str);
            } catch (Exception e2) {
                ALog.m714e("anet.RequestImpl", "url error", this.f1336n, e2, new Object[0]);
            }
        }
        return this.f1324b;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: k */
    public int mo47k() {
        return this.f1330h;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: l */
    public String mo48l() {
        return this.f1336n;
    }

    @Override // p000a.p001a.InterfaceC0007h
    @Deprecated
    /* renamed from: m */
    public URI mo49m() {
        URI uri = this.f1323a;
        if (uri != null) {
            return uri;
        }
        String str = this.f1325c;
        if (str != null) {
            try {
                this.f1323a = new URI(str);
            } catch (Exception e2) {
                ALog.m714e("anet.RequestImpl", "uri error", this.f1336n, e2, new Object[0]);
            }
        }
        return this.f1323a;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: n */
    public String mo50n() {
        return this.f1335m;
    }

    @Deprecated
    /* renamed from: a */
    public void m811a(URL url) {
        this.f1324b = url;
        this.f1325c = url.toString();
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: b */
    public void mo32b(boolean z) {
        this.f1326d = z;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: d */
    public void mo38d(String str) {
        this.f1335m = str;
    }

    @Override // p000a.p001a.InterfaceC0007h
    @Deprecated
    /* renamed from: e */
    public boolean mo40e() {
        return !C0052a.f159k.equals(mo42f(C0052a.f152d));
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: f */
    public String mo42f(String str) {
        Map<String, String> map = this.f1337o;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: b */
    public void mo31b(List<InterfaceC0000a> list) {
        this.f1327e = list;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: d */
    public Map<String, String> mo36d() {
        return this.f1337o;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: a */
    public List<InterfaceC0000a> mo16a() {
        return this.f1327e;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: b */
    public void mo30b(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        if (this.f1327e == null) {
            this.f1327e = new ArrayList();
        }
        this.f1327e.add(new C0889a(str, str2));
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: a */
    public void mo18a(InterfaceC0000a interfaceC0000a) {
        if (interfaceC0000a == null) {
            return;
        }
        if (this.f1327e == null) {
            this.f1327e = new ArrayList();
        }
        int i2 = 0;
        int size = this.f1327e.size();
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (interfaceC0000a.getName().equalsIgnoreCase(this.f1327e.get(i2).getName())) {
                this.f1327e.set(i2, interfaceC0000a);
                break;
            }
            i2++;
        }
        if (i2 < this.f1327e.size()) {
            this.f1327e.add(interfaceC0000a);
        }
    }

    @Deprecated
    public C0891c(URI uri) {
        this.f1323a = uri;
        this.f1325c = uri.toString();
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: b */
    public void mo28b(InterfaceC0000a interfaceC0000a) {
        List<InterfaceC0000a> list = this.f1327e;
        if (list != null) {
            list.remove(interfaceC0000a);
        }
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: c */
    public void mo34c(int i2) {
        this.f1334l = i2;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: b */
    public void mo29b(String str) {
        this.f1331i = str;
    }

    @Override // p000a.p001a.InterfaceC0007h
    @Deprecated
    /* renamed from: b */
    public void mo27b(int i2) {
        this.f1335m = String.valueOf(i2);
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: a */
    public void mo24a(List<InterfaceC0006g> list) {
        this.f1329g = list;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: a */
    public void mo20a(BodyEntry bodyEntry) {
        this.f1332j = bodyEntry;
    }

    @Deprecated
    public C0891c(URL url) {
        this.f1324b = url;
        this.f1325c = url.toString();
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: a */
    public void mo19a(InterfaceC0001b interfaceC0001b) {
        this.f1332j = new BodyHandlerEntry(interfaceC0001b);
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: a */
    public void mo17a(int i2) {
        this.f1333k = i2;
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: a */
    public void mo21a(String str) {
        this.f1336n = str;
    }

    @Override // p000a.p001a.InterfaceC0007h
    @Deprecated
    /* renamed from: a */
    public void mo25a(boolean z) {
        mo22a(C0052a.f152d, z ? C0052a.f158j : C0052a.f159k);
    }

    @Override // p000a.p001a.InterfaceC0007h
    /* renamed from: a */
    public void mo22a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f1337o == null) {
            this.f1337o = new HashMap();
        }
        this.f1337o.put(str, str2);
    }

    public C0891c(String str) {
        this.f1325c = str;
    }
}
