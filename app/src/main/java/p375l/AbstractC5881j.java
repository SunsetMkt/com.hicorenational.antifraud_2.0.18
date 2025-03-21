package p375l;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: ParameterHandler.java */
/* renamed from: l.j */
/* loaded from: classes2.dex */
abstract class AbstractC5881j<T> {

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$a */
    class a extends AbstractC5881j<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // p375l.AbstractC5881j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo24762a(C5883l c5883l, @Nullable Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                AbstractC5881j.this.mo24762a(c5883l, it.next());
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$b */
    class b extends AbstractC5881j<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p375l.AbstractC5881j
        /* renamed from: a */
        void mo24762a(C5883l c5883l, @Nullable Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                AbstractC5881j.this.mo24762a(c5883l, Array.get(obj, i2));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$c */
    static final class c<T> extends AbstractC5881j<T> {

        /* renamed from: a */
        private final InterfaceC5876e<T, RequestBody> f21227a;

        c(InterfaceC5876e<T, RequestBody> interfaceC5876e) {
            this.f21227a = interfaceC5876e;
        }

        @Override // p375l.AbstractC5881j
        /* renamed from: a */
        void mo24762a(C5883l c5883l, @Nullable T t) {
            if (t == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                c5883l.m24783a(this.f21227a.mo24746a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$d */
    static final class d<T> extends AbstractC5881j<T> {

        /* renamed from: a */
        private final String f21228a;

        /* renamed from: b */
        private final InterfaceC5876e<T, String> f21229b;

        /* renamed from: c */
        private final boolean f21230c;

        d(String str, InterfaceC5876e<T, String> interfaceC5876e, boolean z) {
            this.f21228a = (String) C5887p.m24845a(str, "name == null");
            this.f21229b = interfaceC5876e;
            this.f21230c = z;
        }

        @Override // p375l.AbstractC5881j
        /* renamed from: a */
        void mo24762a(C5883l c5883l, @Nullable T t) throws IOException {
            String mo24746a;
            if (t == null || (mo24746a = this.f21229b.mo24746a(t)) == null) {
                return;
            }
            c5883l.m24780a(this.f21228a, mo24746a, this.f21230c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$e */
    static final class e<T> extends AbstractC5881j<Map<String, T>> {

        /* renamed from: a */
        private final InterfaceC5876e<T, String> f21231a;

        /* renamed from: b */
        private final boolean f21232b;

        e(InterfaceC5876e<T, String> interfaceC5876e, boolean z) {
            this.f21231a = interfaceC5876e;
            this.f21232b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // p375l.AbstractC5881j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo24762a(C5883l c5883l, @Nullable Map<String, T> map) throws IOException {
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
                String mo24746a = this.f21231a.mo24746a(value);
                if (mo24746a == null) {
                    throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.f21231a.getClass().getName() + " for key '" + key + "'.");
                }
                c5883l.m24780a(key, mo24746a, this.f21232b);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$f */
    static final class f<T> extends AbstractC5881j<T> {

        /* renamed from: a */
        private final String f21233a;

        /* renamed from: b */
        private final InterfaceC5876e<T, String> f21234b;

        f(String str, InterfaceC5876e<T, String> interfaceC5876e) {
            this.f21233a = (String) C5887p.m24845a(str, "name == null");
            this.f21234b = interfaceC5876e;
        }

        @Override // p375l.AbstractC5881j
        /* renamed from: a */
        void mo24762a(C5883l c5883l, @Nullable T t) throws IOException {
            String mo24746a;
            if (t == null || (mo24746a = this.f21234b.mo24746a(t)) == null) {
                return;
            }
            c5883l.m24779a(this.f21233a, mo24746a);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$g */
    static final class g<T> extends AbstractC5881j<Map<String, T>> {

        /* renamed from: a */
        private final InterfaceC5876e<T, String> f21235a;

        g(InterfaceC5876e<T, String> interfaceC5876e) {
            this.f21235a = interfaceC5876e;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // p375l.AbstractC5881j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo24762a(C5883l c5883l, @Nullable Map<String, T> map) throws IOException {
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
                c5883l.m24779a(key, this.f21235a.mo24746a(value));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$h */
    static final class h<T> extends AbstractC5881j<T> {

        /* renamed from: a */
        private final Headers f21236a;

        /* renamed from: b */
        private final InterfaceC5876e<T, RequestBody> f21237b;

        h(Headers headers, InterfaceC5876e<T, RequestBody> interfaceC5876e) {
            this.f21236a = headers;
            this.f21237b = interfaceC5876e;
        }

        @Override // p375l.AbstractC5881j
        /* renamed from: a */
        void mo24762a(C5883l c5883l, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                c5883l.m24781a(this.f21236a, this.f21237b.mo24746a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$i */
    static final class i<T> extends AbstractC5881j<Map<String, T>> {

        /* renamed from: a */
        private final InterfaceC5876e<T, RequestBody> f21238a;

        /* renamed from: b */
        private final String f21239b;

        i(InterfaceC5876e<T, RequestBody> interfaceC5876e, String str) {
            this.f21238a = interfaceC5876e;
            this.f21239b = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // p375l.AbstractC5881j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo24762a(C5883l c5883l, @Nullable Map<String, T> map) throws IOException {
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
                c5883l.m24781a(Headers.m24924of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f21239b), this.f21238a.mo24746a(value));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$j */
    static final class j<T> extends AbstractC5881j<T> {

        /* renamed from: a */
        private final String f21240a;

        /* renamed from: b */
        private final InterfaceC5876e<T, String> f21241b;

        /* renamed from: c */
        private final boolean f21242c;

        j(String str, InterfaceC5876e<T, String> interfaceC5876e, boolean z) {
            this.f21240a = (String) C5887p.m24845a(str, "name == null");
            this.f21241b = interfaceC5876e;
            this.f21242c = z;
        }

        @Override // p375l.AbstractC5881j
        /* renamed from: a */
        void mo24762a(C5883l c5883l, @Nullable T t) throws IOException {
            if (t != null) {
                c5883l.m24784b(this.f21240a, this.f21241b.mo24746a(t), this.f21242c);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.f21240a + "\" value must not be null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$k */
    static final class k<T> extends AbstractC5881j<T> {

        /* renamed from: a */
        private final String f21243a;

        /* renamed from: b */
        private final InterfaceC5876e<T, String> f21244b;

        /* renamed from: c */
        private final boolean f21245c;

        k(String str, InterfaceC5876e<T, String> interfaceC5876e, boolean z) {
            this.f21243a = (String) C5887p.m24845a(str, "name == null");
            this.f21244b = interfaceC5876e;
            this.f21245c = z;
        }

        @Override // p375l.AbstractC5881j
        /* renamed from: a */
        void mo24762a(C5883l c5883l, @Nullable T t) throws IOException {
            String mo24746a;
            if (t == null || (mo24746a = this.f21244b.mo24746a(t)) == null) {
                return;
            }
            c5883l.m24785c(this.f21243a, mo24746a, this.f21245c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$l */
    static final class l<T> extends AbstractC5881j<Map<String, T>> {

        /* renamed from: a */
        private final InterfaceC5876e<T, String> f21246a;

        /* renamed from: b */
        private final boolean f21247b;

        l(InterfaceC5876e<T, String> interfaceC5876e, boolean z) {
            this.f21246a = interfaceC5876e;
            this.f21247b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // p375l.AbstractC5881j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo24762a(C5883l c5883l, @Nullable Map<String, T> map) throws IOException {
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
                String mo24746a = this.f21246a.mo24746a(value);
                if (mo24746a == null) {
                    throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.f21246a.getClass().getName() + " for key '" + key + "'.");
                }
                c5883l.m24785c(key, mo24746a, this.f21247b);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$m */
    static final class m<T> extends AbstractC5881j<T> {

        /* renamed from: a */
        private final InterfaceC5876e<T, String> f21248a;

        /* renamed from: b */
        private final boolean f21249b;

        m(InterfaceC5876e<T, String> interfaceC5876e, boolean z) {
            this.f21248a = interfaceC5876e;
            this.f21249b = z;
        }

        @Override // p375l.AbstractC5881j
        /* renamed from: a */
        void mo24762a(C5883l c5883l, @Nullable T t) throws IOException {
            if (t == null) {
                return;
            }
            c5883l.m24785c(this.f21248a.mo24746a(t), null, this.f21249b);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$n */
    static final class n extends AbstractC5881j<MultipartBody.Part> {

        /* renamed from: a */
        static final n f21250a = new n();

        private n() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // p375l.AbstractC5881j
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo24762a(C5883l c5883l, @Nullable MultipartBody.Part part) {
            if (part != null) {
                c5883l.m24782a(part);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: l.j$o */
    static final class o extends AbstractC5881j<Object> {
        o() {
        }

        @Override // p375l.AbstractC5881j
        /* renamed from: a */
        void mo24762a(C5883l c5883l, @Nullable Object obj) {
            C5887p.m24845a(obj, "@Url parameter is null.");
            c5883l.m24778a(obj);
        }
    }

    AbstractC5881j() {
    }

    /* renamed from: a */
    final AbstractC5881j<Object> m24761a() {
        return new b();
    }

    /* renamed from: a */
    abstract void mo24762a(C5883l c5883l, @Nullable T t) throws IOException;

    /* renamed from: b */
    final AbstractC5881j<Iterable<T>> m24763b() {
        return new a();
    }
}
