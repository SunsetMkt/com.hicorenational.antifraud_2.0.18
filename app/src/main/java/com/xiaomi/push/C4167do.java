package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.do */
/* loaded from: classes2.dex */
public final class C4167do {

    /* renamed from: com.xiaomi.push.do$a */
    public static final class a extends AbstractC4179e {

        /* renamed from: a */
        private boolean f14901a;

        /* renamed from: b */
        private boolean f14903b;

        /* renamed from: d */
        private boolean f14906d;

        /* renamed from: e */
        private boolean f14907e;

        /* renamed from: a */
        private int f14899a = 0;

        /* renamed from: c */
        private boolean f14905c = false;

        /* renamed from: b */
        private int f14902b = 0;

        /* renamed from: f */
        private boolean f14908f = false;

        /* renamed from: a */
        private List<String> f14900a = Collections.emptyList();

        /* renamed from: c */
        private int f14904c = -1;

        /* renamed from: b */
        public boolean m14325b() {
            return this.f14905c;
        }

        /* renamed from: c */
        public int m14326c() {
            return this.f14899a;
        }

        /* renamed from: d */
        public int m14328d() {
            return this.f14902b;
        }

        /* renamed from: e */
        public boolean m14331e() {
            return this.f14908f;
        }

        /* renamed from: f */
        public boolean m14332f() {
            return this.f14907e;
        }

        /* renamed from: a */
        public boolean m14321a() {
            return this.f14901a;
        }

        /* renamed from: b */
        public a m14323b(int i2) {
            this.f14906d = true;
            this.f14902b = i2;
            return this;
        }

        /* renamed from: c */
        public boolean m14327c() {
            return this.f14903b;
        }

        /* renamed from: d */
        public boolean m14329d() {
            return this.f14906d;
        }

        /* renamed from: e */
        public int m14330e() {
            return this.f14900a.size();
        }

        /* renamed from: a */
        public a m14315a(int i2) {
            this.f14901a = true;
            this.f14899a = i2;
            return this;
        }

        /* renamed from: b */
        public a m14324b(boolean z) {
            this.f14907e = true;
            this.f14908f = z;
            return this;
        }

        /* renamed from: a */
        public a m14318a(boolean z) {
            this.f14903b = true;
            this.f14905c = z;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC4179e
        /* renamed from: b */
        public int mo14322b() {
            int i2 = 0;
            int m13994b = m14321a() ? C4125c.m13994b(1, m14326c()) + 0 : 0;
            if (m14327c()) {
                m13994b += C4125c.m13984a(2, m14325b());
            }
            if (m14329d()) {
                m13994b += C4125c.m13979a(3, m14328d());
            }
            if (m14332f()) {
                m13994b += C4125c.m13984a(4, m14331e());
            }
            Iterator<String> it = m14319a().iterator();
            while (it.hasNext()) {
                i2 += C4125c.m13988a(it.next());
            }
            int size = m13994b + i2 + (m14319a().size() * 1);
            this.f14904c = size;
            return size;
        }

        /* renamed from: a */
        public List<String> m14319a() {
            return this.f14900a;
        }

        /* renamed from: a */
        public a m14317a(String str) {
            if (str != null) {
                if (this.f14900a.isEmpty()) {
                    this.f14900a = new ArrayList();
                }
                this.f14900a.add(str);
                return this;
            }
            throw new NullPointerException();
        }

        @Override // com.xiaomi.push.AbstractC4179e
        /* renamed from: a */
        public void mo14320a(C4125c c4125c) {
            if (m14321a()) {
                c4125c.m14020b(1, m14326c());
            }
            if (m14327c()) {
                c4125c.m14010a(2, m14325b());
            }
            if (m14329d()) {
                c4125c.m14005a(3, m14328d());
            }
            if (m14332f()) {
                c4125c.m14010a(4, m14331e());
            }
            Iterator<String> it = m14319a().iterator();
            while (it.hasNext()) {
                c4125c.m14009a(5, it.next());
            }
        }

        /* renamed from: b */
        public static a m14313b(C4098b c4098b) {
            return new a().mo14316a(c4098b);
        }

        @Override // com.xiaomi.push.AbstractC4179e
        /* renamed from: a */
        public int mo14314a() {
            if (this.f14904c < 0) {
                mo14322b();
            }
            return this.f14904c;
        }

        @Override // com.xiaomi.push.AbstractC4179e
        /* renamed from: a */
        public a mo14316a(C4098b c4098b) {
            while (true) {
                int m13853a = c4098b.m13853a();
                if (m13853a == 0) {
                    return this;
                }
                if (m13853a == 8) {
                    m14315a(c4098b.m13868c());
                } else if (m13853a == 16) {
                    m14318a(c4098b.m13861a());
                } else if (m13853a == 24) {
                    m14323b(c4098b.m13864b());
                } else if (m13853a == 32) {
                    m14324b(c4098b.m13861a());
                } else if (m13853a != 42) {
                    if (!m14589a(c4098b, m13853a)) {
                        return this;
                    }
                } else {
                    m14317a(c4098b.m13857a());
                }
            }
        }

        /* renamed from: a */
        public static a m14312a(byte[] bArr) {
            return (a) new a().m14586a(bArr);
        }
    }
}
