package m;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class j<T> {

    /* JADX INFO: compiled from: ParameterHandler.java */
    class a extends j<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // m.j
        public void a(m.l lVar, @Nullable Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                j.this.a(lVar, it.next());
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    class b extends j<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // m.j
        void a(m.l lVar, @Nullable Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                j.this.a(lVar, Array.get(obj, i2));
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class c<T> extends j<T> {
        private final m.e<T, RequestBody> a;

        c(m.e<T, RequestBody> eVar) {
            this.a = eVar;
        }

        @Override // m.j
        void a(m.l lVar, @Nullable T t) {
            if (t == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                lVar.a(this.a.a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class d<T> extends j<T> {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m.e<T, String> f12722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f12723c;

        d(String str, m.e<T, String> eVar, boolean z) {
            this.a = (String) p.a(str, "name == null");
            this.f12722b = eVar;
            this.f12723c = z;
        }

        @Override // m.j
        void a(m.l lVar, @Nullable T t) throws IOException {
            String strA;
            if (t == null || (strA = this.f12722b.a(t)) == null) {
                return;
            }
            lVar.a(this.a, strA, this.f12723c);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class e<T> extends j<Map<String, T>> {
        private final m.e<T, String> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12724b;

        e(m.e<T, String> eVar, boolean z) {
            this.a = eVar;
            this.f12724b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // m.j
        public void a(m.l lVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Field map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                }
                String strA = this.a.a(value);
                if (strA == null) {
                    throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.a.getClass().getName() + " for key '" + key + "'.");
                }
                lVar.a(key, strA, this.f12724b);
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class f<T> extends j<T> {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m.e<T, String> f12725b;

        f(String str, m.e<T, String> eVar) {
            this.a = (String) p.a(str, "name == null");
            this.f12725b = eVar;
        }

        @Override // m.j
        void a(m.l lVar, @Nullable T t) throws IOException {
            String strA;
            if (t == null || (strA = this.f12725b.a(t)) == null) {
                return;
            }
            lVar.a(this.a, strA);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class g<T> extends j<Map<String, T>> {
        private final m.e<T, String> a;

        g(m.e<T, String> eVar) {
            this.a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // m.j
        public void a(m.l lVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Header map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Header map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Header map contained null value for key '" + key + "'.");
                }
                lVar.a(key, this.a.a(value));
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class h<T> extends j<T> {
        private final Headers a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m.e<T, RequestBody> f12726b;

        h(Headers headers, m.e<T, RequestBody> eVar) {
            this.a = headers;
            this.f12726b = eVar;
        }

        @Override // m.j
        void a(m.l lVar, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                lVar.a(this.a, this.f12726b.a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class i<T> extends j<Map<String, T>> {
        private final m.e<T, RequestBody> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12727b;

        i(m.e<T, RequestBody> eVar, String str) {
            this.a = eVar;
            this.f12727b = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // m.j
        public void a(m.l lVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                }
                lVar.a(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f12727b), this.a.a(value));
            }
        }
    }

    /* JADX INFO: renamed from: m.j$j, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class C0272j<T> extends j<T> {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m.e<T, String> f12728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f12729c;

        C0272j(String str, m.e<T, String> eVar, boolean z) {
            this.a = (String) p.a(str, "name == null");
            this.f12728b = eVar;
            this.f12729c = z;
        }

        @Override // m.j
        void a(m.l lVar, @Nullable T t) throws IOException {
            if (t != null) {
                lVar.b(this.a, this.f12728b.a(t), this.f12729c);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.a + "\" value must not be null.");
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class k<T> extends j<T> {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m.e<T, String> f12730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f12731c;

        k(String str, m.e<T, String> eVar, boolean z) {
            this.a = (String) p.a(str, "name == null");
            this.f12730b = eVar;
            this.f12731c = z;
        }

        @Override // m.j
        void a(m.l lVar, @Nullable T t) throws IOException {
            String strA;
            if (t == null || (strA = this.f12730b.a(t)) == null) {
                return;
            }
            lVar.c(this.a, strA, this.f12731c);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class l<T> extends j<Map<String, T>> {
        private final m.e<T, String> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12732b;

        l(m.e<T, String> eVar, boolean z) {
            this.a = eVar;
            this.f12732b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // m.j
        public void a(m.l lVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Query map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                }
                String strA = this.a.a(value);
                if (strA == null) {
                    throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.a.getClass().getName() + " for key '" + key + "'.");
                }
                lVar.c(key, strA, this.f12732b);
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class m<T> extends j<T> {
        private final m.e<T, String> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12733b;

        m(m.e<T, String> eVar, boolean z) {
            this.a = eVar;
            this.f12733b = z;
        }

        @Override // m.j
        void a(m.l lVar, @Nullable T t) throws IOException {
            if (t == null) {
                return;
            }
            lVar.c(this.a.a(t), null, this.f12733b);
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class n extends j<MultipartBody.Part> {
        static final n a = new n();

        private n() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // m.j
        public void a(m.l lVar, @Nullable MultipartBody.Part part) {
            if (part != null) {
                lVar.a(part);
            }
        }
    }

    /* JADX INFO: compiled from: ParameterHandler.java */
    static final class o extends j<Object> {
        o() {
        }

        @Override // m.j
        void a(m.l lVar, @Nullable Object obj) {
            p.a(obj, "@Url parameter is null.");
            lVar.a(obj);
        }
    }

    j() {
    }

    final j<Object> a() {
        return new b();
    }

    abstract void a(m.l lVar, @Nullable T t) throws IOException;

    final j<Iterable<T>> b() {
        return new a();
    }
}
