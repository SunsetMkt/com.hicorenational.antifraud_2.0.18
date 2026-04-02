package com.bumptech.glide.load.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LazyHeaders.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, List<i>> f3076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Map<String, String> f3077d;

    /* JADX INFO: compiled from: LazyHeaders.java */
    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f3078d = "User-Agent";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f3079e = d();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Map<String, List<i>> f3080f;
        private boolean a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, List<i>> f3081b = f3080f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3082c = true;

        static {
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(f3079e)) {
                map.put("User-Agent", Collections.singletonList(new b(f3079e)));
            }
            f3080f = Collections.unmodifiableMap(map);
        }

        private void c() {
            if (this.a) {
                this.a = false;
                this.f3081b = b();
            }
        }

        @VisibleForTesting
        static String d() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = property.charAt(i2);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < '\u007f') {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public a a(@NonNull String str, @NonNull String str2) {
            return a(str, new b(str2));
        }

        public a b(@NonNull String str, @Nullable String str2) {
            return b(str, str2 == null ? null : new b(str2));
        }

        public a a(@NonNull String str, @NonNull i iVar) {
            if (this.f3082c && "User-Agent".equalsIgnoreCase(str)) {
                return b(str, iVar);
            }
            c();
            a(str).add(iVar);
            return this;
        }

        public a b(@NonNull String str, @Nullable i iVar) {
            c();
            if (iVar == null) {
                this.f3081b.remove(str);
            } else {
                List<i> listA = a(str);
                listA.clear();
                listA.add(iVar);
            }
            if (this.f3082c && "User-Agent".equalsIgnoreCase(str)) {
                this.f3082c = false;
            }
            return this;
        }

        private List<i> a(String str) {
            List<i> list = this.f3081b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f3081b.put(str, arrayList);
            return arrayList;
        }

        private Map<String, List<i>> b() {
            HashMap map = new HashMap(this.f3081b.size());
            for (Map.Entry<String, List<i>> entry : this.f3081b.entrySet()) {
                map.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return map;
        }

        public j a() {
            this.a = true;
            return new j(this.f3081b);
        }
    }

    /* JADX INFO: compiled from: LazyHeaders.java */
    static final class b implements i {

        @NonNull
        private final String a;

        b(@NonNull String str) {
            this.a = str;
        }

        @Override // com.bumptech.glide.load.q.i
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.f3076c = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f3076c.entrySet()) {
            String strA = a(entry.getValue());
            if (!TextUtils.isEmpty(strA)) {
                map.put(entry.getKey(), strA);
            }
        }
        return map;
    }

    @Override // com.bumptech.glide.load.q.h
    public Map<String, String> a() {
        if (this.f3077d == null) {
            synchronized (this) {
                if (this.f3077d == null) {
                    this.f3077d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f3077d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f3076c.equals(((j) obj).f3076c);
        }
        return false;
    }

    public int hashCode() {
        return this.f3076c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f3076c + '}';
    }

    @NonNull
    private String a(@NonNull List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strA = list.get(i2).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }
}
