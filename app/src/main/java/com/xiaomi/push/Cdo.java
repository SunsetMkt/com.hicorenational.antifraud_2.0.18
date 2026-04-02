package com.xiaomi.push;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.xiaomi.push.do, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public final class Cdo {

    /* JADX INFO: renamed from: com.xiaomi.push.do$a */
    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f334a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f335b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f8860d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f8861e;
        private int a = 0;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f336c = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8858b = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f8862f = false;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private List<String> f333a = Collections.emptyList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f8859c = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m275b() {
            return this.f336c;
        }

        public int c() {
            return this.a;
        }

        public int d() {
            return this.f8858b;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m278e() {
            return this.f8862f;
        }

        public boolean f() {
            return this.f8861e;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m274a() {
            return this.f334a;
        }

        public a b(int i2) {
            this.f8860d = true;
            this.f8858b = i2;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m276c() {
            return this.f335b;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m277d() {
            return this.f8860d;
        }

        public int e() {
            return this.f333a.size();
        }

        public a a(int i2) {
            this.f334a = true;
            this.a = i2;
            return this;
        }

        public a b(boolean z) {
            this.f8861e = true;
            this.f8862f = z;
            return this;
        }

        public a a(boolean z) {
            this.f335b = true;
            this.f336c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = 0;
            int iB = m274a() ? c.b(1, c()) + 0 : 0;
            if (m276c()) {
                iB += c.a(2, m275b());
            }
            if (m277d()) {
                iB += c.a(3, d());
            }
            if (f()) {
                iB += c.a(4, m278e());
            }
            Iterator<String> it = m273a().iterator();
            while (it.hasNext()) {
                iA += c.a(it.next());
            }
            int size = iB + iA + (m273a().size() * 1);
            this.f8859c = size;
            return size;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public List<String> m273a() {
            return this.f333a;
        }

        public a a(String str) {
            if (str != null) {
                if (this.f333a.isEmpty()) {
                    this.f333a = new ArrayList();
                }
                this.f333a.add(str);
                return this;
            }
            throw new NullPointerException();
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) throws IOException {
            if (m274a()) {
                cVar.m209b(1, c());
            }
            if (m276c()) {
                cVar.m201a(2, m275b());
            }
            if (m277d()) {
                cVar.m196a(3, d());
            }
            if (f()) {
                cVar.m201a(4, m278e());
            }
            Iterator<String> it = m273a().iterator();
            while (it.hasNext()) {
                cVar.m200a(5, it.next());
            }
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f8859c < 0) {
                b();
            }
            return this.f8859c;
        }

        @Override // com.xiaomi.push.e
        public a a(b bVar) throws d {
            while (true) {
                int iM160a = bVar.m160a();
                if (iM160a == 0) {
                    return this;
                }
                if (iM160a == 8) {
                    a(bVar.c());
                } else if (iM160a == 16) {
                    a(bVar.m166a());
                } else if (iM160a == 24) {
                    b(bVar.m169b());
                } else if (iM160a == 32) {
                    b(bVar.m166a());
                } else if (iM160a != 42) {
                    if (!a(bVar, iM160a)) {
                        return this;
                    }
                } else {
                    a(bVar.m163a());
                }
            }
        }

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }
    }
}
