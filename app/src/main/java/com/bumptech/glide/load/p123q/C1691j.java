package com.bumptech.glide.load.p123q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders.java */
/* renamed from: com.bumptech.glide.load.q.j */
/* loaded from: classes.dex */
public final class C1691j implements InterfaceC1689h {

    /* renamed from: c */
    private final Map<String, List<InterfaceC1690i>> f4705c;

    /* renamed from: d */
    private volatile Map<String, String> f4706d;

    /* compiled from: LazyHeaders.java */
    /* renamed from: com.bumptech.glide.load.q.j$a */
    public static final class a {

        /* renamed from: d */
        private static final String f4707d = "User-Agent";

        /* renamed from: e */
        private static final String f4708e = m4244d();

        /* renamed from: f */
        private static final Map<String, List<InterfaceC1690i>> f4709f;

        /* renamed from: a */
        private boolean f4710a = true;

        /* renamed from: b */
        private Map<String, List<InterfaceC1690i>> f4711b = f4709f;

        /* renamed from: c */
        private boolean f4712c = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f4708e)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(f4708e)));
            }
            f4709f = Collections.unmodifiableMap(hashMap);
        }

        /* renamed from: c */
        private void m4243c() {
            if (this.f4710a) {
                this.f4710a = false;
                this.f4711b = m4242b();
            }
        }

        @VisibleForTesting
        /* renamed from: d */
        static String m4244d() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        /* renamed from: a */
        public a m4246a(@NonNull String str, @NonNull String str2) {
            return m4245a(str, new b(str2));
        }

        /* renamed from: b */
        public a m4249b(@NonNull String str, @Nullable String str2) {
            return m4248b(str, str2 == null ? null : new b(str2));
        }

        /* renamed from: a */
        public a m4245a(@NonNull String str, @NonNull InterfaceC1690i interfaceC1690i) {
            if (this.f4712c && "User-Agent".equalsIgnoreCase(str)) {
                return m4248b(str, interfaceC1690i);
            }
            m4243c();
            m4241a(str).add(interfaceC1690i);
            return this;
        }

        /* renamed from: b */
        public a m4248b(@NonNull String str, @Nullable InterfaceC1690i interfaceC1690i) {
            m4243c();
            if (interfaceC1690i == null) {
                this.f4711b.remove(str);
            } else {
                List<InterfaceC1690i> m4241a = m4241a(str);
                m4241a.clear();
                m4241a.add(interfaceC1690i);
            }
            if (this.f4712c && "User-Agent".equalsIgnoreCase(str)) {
                this.f4712c = false;
            }
            return this;
        }

        /* renamed from: a */
        private List<InterfaceC1690i> m4241a(String str) {
            List<InterfaceC1690i> list = this.f4711b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f4711b.put(str, arrayList);
            return arrayList;
        }

        /* renamed from: b */
        private Map<String, List<InterfaceC1690i>> m4242b() {
            HashMap hashMap = new HashMap(this.f4711b.size());
            for (Map.Entry<String, List<InterfaceC1690i>> entry : this.f4711b.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return hashMap;
        }

        /* renamed from: a */
        public C1691j m4247a() {
            this.f4710a = true;
            return new C1691j(this.f4711b);
        }
    }

    /* compiled from: LazyHeaders.java */
    /* renamed from: com.bumptech.glide.load.q.j$b */
    static final class b implements InterfaceC1690i {

        /* renamed from: a */
        @NonNull
        private final String f4713a;

        b(@NonNull String str) {
            this.f4713a = str;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1690i
        /* renamed from: a */
        public String mo4238a() {
            return this.f4713a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f4713a.equals(((b) obj).f4713a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4713a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f4713a + "'}";
        }
    }

    C1691j(Map<String, List<InterfaceC1690i>> map) {
        this.f4705c = Collections.unmodifiableMap(map);
    }

    /* renamed from: b */
    private Map<String, String> m4240b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<InterfaceC1690i>> entry : this.f4705c.entrySet()) {
            String m4239a = m4239a(entry.getValue());
            if (!TextUtils.isEmpty(m4239a)) {
                hashMap.put(entry.getKey(), m4239a);
            }
        }
        return hashMap;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1689h
    /* renamed from: a */
    public Map<String, String> mo4237a() {
        if (this.f4706d == null) {
            synchronized (this) {
                if (this.f4706d == null) {
                    this.f4706d = Collections.unmodifiableMap(m4240b());
                }
            }
        }
        return this.f4706d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1691j) {
            return this.f4705c.equals(((C1691j) obj).f4705c);
        }
        return false;
    }

    public int hashCode() {
        return this.f4705c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f4705c + '}';
    }

    @NonNull
    /* renamed from: a */
    private String m4239a(@NonNull List<InterfaceC1690i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String mo4238a = list.get(i2).mo4238a();
            if (!TextUtils.isEmpty(mo4238a)) {
                sb.append(mo4238a);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }
}
