package com.xiaomi.push;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class dp {

    public static final class a extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a */
        private boolean f339a;

        /* JADX INFO: renamed from: b */
        private boolean f342b;

        /* JADX INFO: renamed from: c */
        private boolean f345c;

        /* JADX INFO: renamed from: d */
        private boolean f347d;

        /* JADX INFO: renamed from: e */
        private boolean f349e;

        /* JADX INFO: renamed from: f */
        private boolean f350f;

        /* JADX INFO: renamed from: g */
        private boolean f8868g;

        /* JADX INFO: renamed from: h */
        private boolean f8869h;

        /* JADX INFO: renamed from: i */
        private boolean f8870i;

        /* JADX INFO: renamed from: j */
        private boolean f8871j;

        /* JADX INFO: renamed from: k */
        private boolean f8872k;

        /* JADX INFO: renamed from: l */
        private boolean f8873l;

        /* JADX INFO: renamed from: m */
        private boolean f8874m;
        private int a = 0;

        /* JADX INFO: renamed from: a */
        private long f337a = 0;

        /* JADX INFO: renamed from: a */
        private String f338a = "";

        /* JADX INFO: renamed from: b */
        private String f341b = "";

        /* JADX INFO: renamed from: c */
        private String f344c = "";

        /* JADX INFO: renamed from: d */
        private String f346d = "";

        /* JADX INFO: renamed from: e */
        private String f348e = "";

        /* JADX INFO: renamed from: b */
        private int f8863b = 1;

        /* JADX INFO: renamed from: c */
        private int f8864c = 0;

        /* JADX INFO: renamed from: d */
        private int f8865d = 0;

        /* JADX INFO: renamed from: f */
        private String f8867f = "";

        /* JADX INFO: renamed from: b */
        private long f340b = 0;

        /* JADX INFO: renamed from: c */
        private long f343c = 0;

        /* JADX INFO: renamed from: e */
        private int f8866e = -1;

        /* JADX INFO: renamed from: b */
        public boolean m285b() {
            return this.f342b;
        }

        public int c() {
            return this.a;
        }

        /* JADX INFO: renamed from: d */
        public boolean m290d() {
            return this.f347d;
        }

        /* JADX INFO: renamed from: e */
        public boolean m292e() {
            return this.f349e;
        }

        /* JADX INFO: renamed from: f */
        public boolean m294f() {
            return this.f350f;
        }

        public boolean g() {
            return this.f8868g;
        }

        public boolean h() {
            return this.f8869h;
        }

        public boolean i() {
            return this.f8870i;
        }

        public boolean j() {
            return this.f8871j;
        }

        public boolean k() {
            return this.f8872k;
        }

        public boolean l() {
            return this.f8873l;
        }

        public boolean m() {
            return this.f8874m;
        }

        /* JADX INFO: renamed from: a */
        public boolean m282a() {
            return this.f339a;
        }

        /* JADX INFO: renamed from: b */
        public String m284b() {
            return this.f341b;
        }

        /* JADX INFO: renamed from: c */
        public boolean m288c() {
            return this.f345c;
        }

        /* JADX INFO: renamed from: d */
        public String m289d() {
            return this.f346d;
        }

        /* JADX INFO: renamed from: e */
        public String m291e() {
            return this.f348e;
        }

        public int f() {
            return this.f8865d;
        }

        public a a(int i2) {
            this.f339a = true;
            this.a = i2;
            return this;
        }

        public a b(String str) {
            this.f347d = true;
            this.f341b = str;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public String m287c() {
            return this.f344c;
        }

        public a d(String str) {
            this.f350f = true;
            this.f346d = str;
            return this;
        }

        public a e(String str) {
            this.f8868g = true;
            this.f348e = str;
            return this;
        }

        /* JADX INFO: renamed from: f */
        public String m293f() {
            return this.f8867f;
        }

        public a c(String str) {
            this.f349e = true;
            this.f344c = str;
            return this;
        }

        public a f(String str) {
            this.f8872k = true;
            this.f8867f = str;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public long m279a() {
            return this.f337a;
        }

        public a b(int i2) {
            this.f8869h = true;
            this.f8863b = i2;
            return this;
        }

        public int d() {
            return this.f8863b;
        }

        public int e() {
            return this.f8864c;
        }

        public a a(long j2) {
            this.f342b = true;
            this.f337a = j2;
            return this;
        }

        public a c(int i2) {
            this.f8870i = true;
            this.f8864c = i2;
            return this;
        }

        public a d(int i2) {
            this.f8871j = true;
            this.f8865d = i2;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public long m283b() {
            return this.f340b;
        }

        /* JADX INFO: renamed from: a */
        public String m281a() {
            return this.f338a;
        }

        public a b(long j2) {
            this.f8873l = true;
            this.f340b = j2;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public long m286c() {
            return this.f343c;
        }

        public a a(String str) {
            this.f345c = true;
            this.f338a = str;
            return this;
        }

        public a c(long j2) {
            this.f8874m = true;
            this.f343c = j2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m282a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m285b()) {
                iA += com.xiaomi.push.c.b(2, m279a());
            }
            if (m288c()) {
                iA += com.xiaomi.push.c.a(3, m281a());
            }
            if (m290d()) {
                iA += com.xiaomi.push.c.a(4, m284b());
            }
            if (m292e()) {
                iA += com.xiaomi.push.c.a(5, m287c());
            }
            if (m294f()) {
                iA += com.xiaomi.push.c.a(6, m289d());
            }
            if (g()) {
                iA += com.xiaomi.push.c.a(7, m291e());
            }
            if (h()) {
                iA += com.xiaomi.push.c.a(8, d());
            }
            if (i()) {
                iA += com.xiaomi.push.c.a(9, e());
            }
            if (j()) {
                iA += com.xiaomi.push.c.a(10, f());
            }
            if (k()) {
                iA += com.xiaomi.push.c.a(11, m293f());
            }
            if (l()) {
                iA += com.xiaomi.push.c.b(12, m283b());
            }
            if (m()) {
                iA += com.xiaomi.push.c.b(13, m286c());
            }
            this.f8866e = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a */
        public a m280a() {
            this.f350f = false;
            this.f346d = "";
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m282a()) {
                cVar.m196a(1, c());
            }
            if (m285b()) {
                cVar.m210b(2, m279a());
            }
            if (m288c()) {
                cVar.m200a(3, m281a());
            }
            if (m290d()) {
                cVar.m200a(4, m284b());
            }
            if (m292e()) {
                cVar.m200a(5, m287c());
            }
            if (m294f()) {
                cVar.m200a(6, m289d());
            }
            if (g()) {
                cVar.m200a(7, m291e());
            }
            if (h()) {
                cVar.m196a(8, d());
            }
            if (i()) {
                cVar.m196a(9, e());
            }
            if (j()) {
                cVar.m196a(10, f());
            }
            if (k()) {
                cVar.m200a(11, m293f());
            }
            if (l()) {
                cVar.m210b(12, m283b());
            }
            if (m()) {
                cVar.m210b(13, m286c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f8866e < 0) {
                b();
            }
            return this.f8866e;
        }

        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM160a = bVar.m160a();
                switch (iM160a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m169b());
                        break;
                    case 16:
                        a(bVar.m170b());
                        break;
                    case 26:
                        a(bVar.m163a());
                        break;
                    case 34:
                        b(bVar.m163a());
                        break;
                    case 42:
                        c(bVar.m163a());
                        break;
                    case 50:
                        d(bVar.m163a());
                        break;
                    case 58:
                        e(bVar.m163a());
                        break;
                    case 64:
                        b(bVar.m169b());
                        break;
                    case 72:
                        c(bVar.m169b());
                        break;
                    case 80:
                        d(bVar.m169b());
                        break;
                    case 90:
                        f(bVar.m163a());
                        break;
                    case 96:
                        b(bVar.m170b());
                        break;
                    case 104:
                        c(bVar.m170b());
                        break;
                    default:
                        if (!a(bVar, iM160a)) {
                            return this;
                        }
                        break;
                        break;
                }
            }
        }
    }

    public static final class b extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a */
        private boolean f351a;

        /* JADX INFO: renamed from: c */
        private boolean f353c;

        /* JADX INFO: renamed from: d */
        private boolean f354d;

        /* JADX INFO: renamed from: e */
        private boolean f8878e;

        /* JADX INFO: renamed from: b */
        private boolean f352b = false;
        private int a = 0;

        /* JADX INFO: renamed from: b */
        private int f8875b = 0;

        /* JADX INFO: renamed from: c */
        private int f8876c = 0;

        /* JADX INFO: renamed from: d */
        private int f8877d = -1;

        /* JADX INFO: renamed from: b */
        public boolean m296b() {
            return this.f351a;
        }

        public int c() {
            return this.a;
        }

        public int d() {
            return this.f8875b;
        }

        public int e() {
            return this.f8876c;
        }

        /* JADX INFO: renamed from: a */
        public boolean m295a() {
            return this.f352b;
        }

        public b b(int i2) {
            this.f354d = true;
            this.f8875b = i2;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public boolean m297c() {
            return this.f353c;
        }

        /* JADX INFO: renamed from: d */
        public boolean m298d() {
            return this.f354d;
        }

        /* JADX INFO: renamed from: e */
        public boolean m299e() {
            return this.f8878e;
        }

        public b a(boolean z) {
            this.f351a = true;
            this.f352b = z;
            return this;
        }

        public b c(int i2) {
            this.f8878e = true;
            this.f8876c = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m296b() ? 0 + com.xiaomi.push.c.a(1, m295a()) : 0;
            if (m297c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            if (m298d()) {
                iA += com.xiaomi.push.c.a(4, d());
            }
            if (m299e()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            this.f8877d = iA;
            return iA;
        }

        public b a(int i2) {
            this.f353c = true;
            this.a = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m296b()) {
                cVar.m201a(1, m295a());
            }
            if (m297c()) {
                cVar.m196a(3, c());
            }
            if (m298d()) {
                cVar.m196a(4, d());
            }
            if (m299e()) {
                cVar.m196a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f8877d < 0) {
                b();
            }
            return this.f8877d;
        }

        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM160a = bVar.m160a();
                if (iM160a == 0) {
                    return this;
                }
                if (iM160a == 8) {
                    a(bVar.m166a());
                } else if (iM160a == 24) {
                    a(bVar.m169b());
                } else if (iM160a == 32) {
                    b(bVar.m169b());
                } else if (iM160a != 40) {
                    if (!a(bVar, iM160a)) {
                        return this;
                    }
                } else {
                    c(bVar.m169b());
                }
            }
        }

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }
    }

    public static final class c extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a */
        private boolean f356a;

        /* JADX INFO: renamed from: b */
        private boolean f357b;

        /* JADX INFO: renamed from: c */
        private boolean f358c;

        /* JADX INFO: renamed from: d */
        private boolean f359d;

        /* JADX INFO: renamed from: e */
        private boolean f360e;

        /* JADX INFO: renamed from: f */
        private boolean f361f;

        /* JADX INFO: renamed from: a */
        private String f355a = "";

        /* JADX INFO: renamed from: b */
        private String f8879b = "";

        /* JADX INFO: renamed from: c */
        private String f8880c = "";

        /* JADX INFO: renamed from: d */
        private String f8881d = "";

        /* JADX INFO: renamed from: e */
        private String f8882e = "";

        /* JADX INFO: renamed from: f */
        private String f8883f = "";
        private int a = -1;

        /* JADX INFO: renamed from: b */
        public String m302b() {
            return this.f8879b;
        }

        public String c() {
            return this.f8880c;
        }

        public String d() {
            return this.f8881d;
        }

        public String e() {
            return this.f8882e;
        }

        public String f() {
            return this.f8883f;
        }

        /* JADX INFO: renamed from: a */
        public String m300a() {
            return this.f355a;
        }

        /* JADX INFO: renamed from: b */
        public boolean m303b() {
            return this.f357b;
        }

        /* JADX INFO: renamed from: c */
        public boolean m304c() {
            return this.f358c;
        }

        /* JADX INFO: renamed from: d */
        public boolean m305d() {
            return this.f359d;
        }

        /* JADX INFO: renamed from: e */
        public boolean m306e() {
            return this.f360e;
        }

        /* JADX INFO: renamed from: f */
        public boolean m307f() {
            return this.f361f;
        }

        /* JADX INFO: renamed from: a */
        public boolean m301a() {
            return this.f356a;
        }

        public c b(String str) {
            this.f357b = true;
            this.f8879b = str;
            return this;
        }

        public c c(String str) {
            this.f358c = true;
            this.f8880c = str;
            return this;
        }

        public c d(String str) {
            this.f359d = true;
            this.f8881d = str;
            return this;
        }

        public c e(String str) {
            this.f360e = true;
            this.f8882e = str;
            return this;
        }

        public c f(String str) {
            this.f361f = true;
            this.f8883f = str;
            return this;
        }

        public c a(String str) {
            this.f356a = true;
            this.f355a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m301a() ? 0 + com.xiaomi.push.c.a(1, m300a()) : 0;
            if (m303b()) {
                iA += com.xiaomi.push.c.a(2, m302b());
            }
            if (m304c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            if (m305d()) {
                iA += com.xiaomi.push.c.a(4, d());
            }
            if (m306e()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            if (m307f()) {
                iA += com.xiaomi.push.c.a(6, f());
            }
            this.a = iA;
            return iA;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m301a()) {
                cVar.m200a(1, m300a());
            }
            if (m303b()) {
                cVar.m200a(2, m302b());
            }
            if (m304c()) {
                cVar.m200a(3, c());
            }
            if (m305d()) {
                cVar.m200a(4, d());
            }
            if (m306e()) {
                cVar.m200a(5, e());
            }
            if (m307f()) {
                cVar.m200a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM160a = bVar.m160a();
                if (iM160a == 0) {
                    return this;
                }
                if (iM160a == 10) {
                    a(bVar.m163a());
                } else if (iM160a == 18) {
                    b(bVar.m163a());
                } else if (iM160a == 26) {
                    c(bVar.m163a());
                } else if (iM160a == 34) {
                    d(bVar.m163a());
                } else if (iM160a == 42) {
                    e(bVar.m163a());
                } else if (iM160a != 50) {
                    if (!a(bVar, iM160a)) {
                        return this;
                    }
                } else {
                    f(bVar.m163a());
                }
            }
        }
    }

    public static final class d extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a */
        private boolean f363a;

        /* JADX INFO: renamed from: c */
        private boolean f365c;

        /* JADX INFO: renamed from: d */
        private boolean f8886d;

        /* JADX INFO: renamed from: e */
        private boolean f8887e;

        /* JADX INFO: renamed from: b */
        private boolean f364b = false;

        /* JADX INFO: renamed from: a */
        private String f362a = "";

        /* JADX INFO: renamed from: b */
        private String f8884b = "";

        /* JADX INFO: renamed from: c */
        private String f8885c = "";
        private int a = -1;

        /* JADX INFO: renamed from: b */
        public boolean m311b() {
            return this.f363a;
        }

        /* JADX INFO: renamed from: c */
        public boolean m312c() {
            return this.f365c;
        }

        public boolean d() {
            return this.f8886d;
        }

        public boolean e() {
            return this.f8887e;
        }

        /* JADX INFO: renamed from: a */
        public boolean m309a() {
            return this.f364b;
        }

        /* JADX INFO: renamed from: b */
        public String m310b() {
            return this.f8884b;
        }

        public String c() {
            return this.f8885c;
        }

        public d a(boolean z) {
            this.f363a = true;
            this.f364b = z;
            return this;
        }

        public d b(String str) {
            this.f8886d = true;
            this.f8884b = str;
            return this;
        }

        public d c(String str) {
            this.f8887e = true;
            this.f8885c = str;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public String m308a() {
            return this.f362a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m311b() ? 0 + com.xiaomi.push.c.a(1, m309a()) : 0;
            if (m312c()) {
                iA += com.xiaomi.push.c.a(2, m308a());
            }
            if (d()) {
                iA += com.xiaomi.push.c.a(3, m310b());
            }
            if (e()) {
                iA += com.xiaomi.push.c.a(4, c());
            }
            this.a = iA;
            return iA;
        }

        public d a(String str) {
            this.f365c = true;
            this.f362a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m311b()) {
                cVar.m201a(1, m309a());
            }
            if (m312c()) {
                cVar.m200a(2, m308a());
            }
            if (d()) {
                cVar.m200a(3, m310b());
            }
            if (e()) {
                cVar.m200a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM160a = bVar.m160a();
                if (iM160a == 0) {
                    return this;
                }
                if (iM160a == 8) {
                    a(bVar.m166a());
                } else if (iM160a == 18) {
                    a(bVar.m163a());
                } else if (iM160a == 26) {
                    b(bVar.m163a());
                } else if (iM160a != 34) {
                    if (!a(bVar, iM160a)) {
                        return this;
                    }
                } else {
                    c(bVar.m163a());
                }
            }
        }

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }
    }

    public static final class e extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a */
        private com.xiaomi.push.a f366a;

        /* JADX INFO: renamed from: a */
        private boolean f369a;

        /* JADX INFO: renamed from: b */
        private com.xiaomi.push.a f370b;

        /* JADX INFO: renamed from: b */
        private boolean f372b;

        /* JADX INFO: renamed from: c */
        private boolean f374c;

        /* JADX INFO: renamed from: d */
        private int f8890d;

        /* JADX INFO: renamed from: d */
        private boolean f376d;

        /* JADX INFO: renamed from: e */
        private int f8891e;

        /* JADX INFO: renamed from: e */
        private boolean f378e;

        /* JADX INFO: renamed from: f */
        private boolean f379f;

        /* JADX INFO: renamed from: g */
        private boolean f8893g;

        /* JADX INFO: renamed from: h */
        private boolean f8894h;

        /* JADX INFO: renamed from: i */
        private boolean f8895i;

        /* JADX INFO: renamed from: j */
        private boolean f8896j;

        /* JADX INFO: renamed from: k */
        private boolean f8897k;

        /* JADX INFO: renamed from: l */
        private boolean f8898l;

        /* JADX INFO: renamed from: m */
        private boolean f8899m;
        private int a = 0;

        /* JADX INFO: renamed from: a */
        private String f368a = "";

        /* JADX INFO: renamed from: b */
        private String f371b = "";

        /* JADX INFO: renamed from: c */
        private String f373c = "";

        /* JADX INFO: renamed from: b */
        private int f8888b = 0;

        /* JADX INFO: renamed from: d */
        private String f375d = "";

        /* JADX INFO: renamed from: e */
        private String f377e = "";

        /* JADX INFO: renamed from: f */
        private String f8892f = "";

        /* JADX INFO: renamed from: a */
        private b f367a = null;

        /* JADX INFO: renamed from: c */
        private int f8889c = 0;

        public e() {
            com.xiaomi.push.a aVar = com.xiaomi.push.a.a;
            this.f366a = aVar;
            this.f370b = aVar;
            this.f8890d = 0;
            this.f8891e = -1;
        }

        /* JADX INFO: renamed from: b */
        public boolean m319b() {
            return this.f372b;
        }

        public int c() {
            return this.a;
        }

        /* JADX INFO: renamed from: d */
        public boolean m323d() {
            return this.f376d;
        }

        /* JADX INFO: renamed from: e */
        public boolean m325e() {
            return this.f378e;
        }

        /* JADX INFO: renamed from: f */
        public boolean m327f() {
            return this.f379f;
        }

        public boolean g() {
            return this.f8893g;
        }

        public boolean h() {
            return this.f8894h;
        }

        public boolean i() {
            return this.f8895i;
        }

        public boolean j() {
            return this.f8896j;
        }

        public boolean k() {
            return this.f8897k;
        }

        public boolean l() {
            return this.f8898l;
        }

        public boolean m() {
            return this.f8899m;
        }

        /* JADX INFO: renamed from: a */
        public boolean m316a() {
            return this.f369a;
        }

        /* JADX INFO: renamed from: b */
        public String m318b() {
            return this.f371b;
        }

        /* JADX INFO: renamed from: c */
        public boolean m321c() {
            return this.f374c;
        }

        public int d() {
            return this.f8888b;
        }

        /* JADX INFO: renamed from: e */
        public String m324e() {
            return this.f377e;
        }

        /* JADX INFO: renamed from: f */
        public String m326f() {
            return this.f8892f;
        }

        public e a(int i2) {
            this.f369a = true;
            this.a = i2;
            return this;
        }

        public e b(String str) {
            this.f374c = true;
            this.f371b = str;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public String m320c() {
            return this.f373c;
        }

        /* JADX INFO: renamed from: d */
        public String m322d() {
            return this.f375d;
        }

        public e e(String str) {
            this.f8893g = true;
            this.f377e = str;
            return this;
        }

        public e f(String str) {
            this.f8894h = true;
            this.f8892f = str;
            return this;
        }

        public e c(String str) {
            this.f376d = true;
            this.f373c = str;
            return this;
        }

        public e d(String str) {
            this.f379f = true;
            this.f375d = str;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public String m315a() {
            return this.f368a;
        }

        public e b(int i2) {
            this.f378e = true;
            this.f8888b = i2;
            return this;
        }

        public int e() {
            return this.f8889c;
        }

        public int f() {
            return this.f8890d;
        }

        public e a(String str) {
            this.f372b = true;
            this.f368a = str;
            return this;
        }

        public e c(int i2) {
            this.f8896j = true;
            this.f8889c = i2;
            return this;
        }

        public e d(int i2) {
            this.f8899m = true;
            this.f8890d = i2;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public com.xiaomi.push.a m317b() {
            return this.f370b;
        }

        /* JADX INFO: renamed from: a */
        public b m314a() {
            return this.f367a;
        }

        public e b(com.xiaomi.push.a aVar) {
            this.f8898l = true;
            this.f370b = aVar;
            return this;
        }

        public e a(b bVar) {
            if (bVar != null) {
                this.f8895i = true;
                this.f367a = bVar;
                return this;
            }
            throw new NullPointerException();
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iB = m316a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (m319b()) {
                iB += com.xiaomi.push.c.a(2, m315a());
            }
            if (m321c()) {
                iB += com.xiaomi.push.c.a(3, m318b());
            }
            if (m323d()) {
                iB += com.xiaomi.push.c.a(4, m320c());
            }
            if (m325e()) {
                iB += com.xiaomi.push.c.a(5, d());
            }
            if (m327f()) {
                iB += com.xiaomi.push.c.a(6, m322d());
            }
            if (g()) {
                iB += com.xiaomi.push.c.a(7, m324e());
            }
            if (h()) {
                iB += com.xiaomi.push.c.a(8, m326f());
            }
            if (i()) {
                iB += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m314a());
            }
            if (j()) {
                iB += com.xiaomi.push.c.a(10, e());
            }
            if (k()) {
                iB += com.xiaomi.push.c.a(11, m313a());
            }
            if (l()) {
                iB += com.xiaomi.push.c.a(12, m317b());
            }
            if (m()) {
                iB += com.xiaomi.push.c.a(13, f());
            }
            this.f8891e = iB;
            return iB;
        }

        /* JADX INFO: renamed from: a */
        public com.xiaomi.push.a m313a() {
            return this.f366a;
        }

        public e a(com.xiaomi.push.a aVar) {
            this.f8897k = true;
            this.f366a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m316a()) {
                cVar.m209b(1, c());
            }
            if (m319b()) {
                cVar.m200a(2, m315a());
            }
            if (m321c()) {
                cVar.m200a(3, m318b());
            }
            if (m323d()) {
                cVar.m200a(4, m320c());
            }
            if (m325e()) {
                cVar.m196a(5, d());
            }
            if (m327f()) {
                cVar.m200a(6, m322d());
            }
            if (g()) {
                cVar.m200a(7, m324e());
            }
            if (h()) {
                cVar.m200a(8, m326f());
            }
            if (i()) {
                cVar.m199a(9, (com.xiaomi.push.e) m314a());
            }
            if (j()) {
                cVar.m196a(10, e());
            }
            if (k()) {
                cVar.m198a(11, m313a());
            }
            if (l()) {
                cVar.m198a(12, m317b());
            }
            if (m()) {
                cVar.m196a(13, f());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f8891e < 0) {
                b();
            }
            return this.f8891e;
        }

        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM160a = bVar.m160a();
                switch (iM160a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m163a());
                        break;
                    case 26:
                        b(bVar.m163a());
                        break;
                    case 34:
                        c(bVar.m163a());
                        break;
                    case 40:
                        b(bVar.m169b());
                        break;
                    case 50:
                        d(bVar.m163a());
                        break;
                    case 58:
                        e(bVar.m163a());
                        break;
                    case 66:
                        f(bVar.m163a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m169b());
                        break;
                    case 90:
                        a(bVar.m162a());
                        break;
                    case 98:
                        b(bVar.m162a());
                        break;
                    case 104:
                        d(bVar.m169b());
                        break;
                    default:
                        if (!a(bVar, iM160a)) {
                            return this;
                        }
                        break;
                        break;
                }
            }
        }
    }

    public static final class f extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a */
        private boolean f382a;

        /* JADX INFO: renamed from: b */
        private boolean f383b;

        /* JADX INFO: renamed from: c */
        private boolean f8901c;

        /* JADX INFO: renamed from: a */
        private String f381a = "";

        /* JADX INFO: renamed from: b */
        private String f8900b = "";

        /* JADX INFO: renamed from: a */
        private b f380a = null;
        private int a = -1;

        /* JADX INFO: renamed from: b */
        public String m331b() {
            return this.f8900b;
        }

        public boolean c() {
            return this.f8901c;
        }

        /* JADX INFO: renamed from: a */
        public String m329a() {
            return this.f381a;
        }

        /* JADX INFO: renamed from: b */
        public boolean m332b() {
            return this.f383b;
        }

        /* JADX INFO: renamed from: a */
        public boolean m330a() {
            return this.f382a;
        }

        public f b(String str) {
            this.f383b = true;
            this.f8900b = str;
            return this;
        }

        public f a(String str) {
            this.f382a = true;
            this.f381a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m330a() ? 0 + com.xiaomi.push.c.a(1, m329a()) : 0;
            if (m332b()) {
                iA += com.xiaomi.push.c.a(2, m331b());
            }
            if (c()) {
                iA += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m328a());
            }
            this.a = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a */
        public b m328a() {
            return this.f380a;
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.f8901c = true;
                this.f380a = bVar;
                return this;
            }
            throw new NullPointerException();
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m330a()) {
                cVar.m200a(1, m329a());
            }
            if (m332b()) {
                cVar.m200a(2, m331b());
            }
            if (c()) {
                cVar.m199a(3, (com.xiaomi.push.e) m328a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM160a = bVar.m160a();
                if (iM160a == 0) {
                    return this;
                }
                if (iM160a == 10) {
                    a(bVar.m163a());
                } else if (iM160a == 18) {
                    b(bVar.m163a());
                } else if (iM160a != 26) {
                    if (!a(bVar, iM160a)) {
                        return this;
                    }
                } else {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                }
            }
        }

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }
    }

    public static final class g extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a */
        private boolean f385a;

        /* JADX INFO: renamed from: b */
        private boolean f386b;

        /* JADX INFO: renamed from: c */
        private boolean f387c;

        /* JADX INFO: renamed from: a */
        private String f384a = "";

        /* JADX INFO: renamed from: b */
        private String f8902b = "";

        /* JADX INFO: renamed from: c */
        private String f8903c = "";
        private int a = -1;

        /* JADX INFO: renamed from: b */
        public String m335b() {
            return this.f8902b;
        }

        public String c() {
            return this.f8903c;
        }

        /* JADX INFO: renamed from: a */
        public String m333a() {
            return this.f384a;
        }

        /* JADX INFO: renamed from: b */
        public boolean m336b() {
            return this.f386b;
        }

        /* JADX INFO: renamed from: c */
        public boolean m337c() {
            return this.f387c;
        }

        /* JADX INFO: renamed from: a */
        public boolean m334a() {
            return this.f385a;
        }

        public g b(String str) {
            this.f386b = true;
            this.f8902b = str;
            return this;
        }

        public g c(String str) {
            this.f387c = true;
            this.f8903c = str;
            return this;
        }

        public g a(String str) {
            this.f385a = true;
            this.f384a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m334a() ? 0 + com.xiaomi.push.c.a(1, m333a()) : 0;
            if (m336b()) {
                iA += com.xiaomi.push.c.a(2, m335b());
            }
            if (m337c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            this.a = iA;
            return iA;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m334a()) {
                cVar.m200a(1, m333a());
            }
            if (m336b()) {
                cVar.m200a(2, m335b());
            }
            if (m337c()) {
                cVar.m200a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM160a = bVar.m160a();
                if (iM160a == 0) {
                    return this;
                }
                if (iM160a == 10) {
                    a(bVar.m163a());
                } else if (iM160a == 18) {
                    b(bVar.m163a());
                } else if (iM160a != 26) {
                    if (!a(bVar, iM160a)) {
                        return this;
                    }
                } else {
                    c(bVar.m163a());
                }
            }
        }

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }
    }

    public static final class h extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a */
        private boolean f389a;

        /* JADX INFO: renamed from: b */
        private boolean f390b;
        private int a = 0;

        /* JADX INFO: renamed from: a */
        private String f388a = "";

        /* JADX INFO: renamed from: b */
        private int f8904b = -1;

        /* JADX INFO: renamed from: b */
        public boolean m340b() {
            return this.f390b;
        }

        public int c() {
            return this.a;
        }

        /* JADX INFO: renamed from: a */
        public boolean m339a() {
            return this.f389a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m339a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m340b()) {
                iA += com.xiaomi.push.c.a(2, m338a());
            }
            this.f8904b = iA;
            return iA;
        }

        public h a(int i2) {
            this.f389a = true;
            this.a = i2;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public String m338a() {
            return this.f388a;
        }

        public h a(String str) {
            this.f390b = true;
            this.f388a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m339a()) {
                cVar.m196a(1, c());
            }
            if (m340b()) {
                cVar.m200a(2, m338a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f8904b < 0) {
                b();
            }
            return this.f8904b;
        }

        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM160a = bVar.m160a();
                if (iM160a == 0) {
                    return this;
                }
                if (iM160a == 8) {
                    a(bVar.m169b());
                } else if (iM160a != 18) {
                    if (!a(bVar, iM160a)) {
                        return this;
                    }
                } else {
                    a(bVar.m163a());
                }
            }
        }

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }
    }

    public static final class i extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a */
        private boolean f392a;

        /* JADX INFO: renamed from: a */
        private com.xiaomi.push.a f391a = com.xiaomi.push.a.a;
        private int a = -1;

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m342a() ? 0 + com.xiaomi.push.c.a(1, m341a()) : 0;
            this.a = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a */
        public com.xiaomi.push.a m341a() {
            return this.f391a;
        }

        /* JADX INFO: renamed from: a */
        public boolean m342a() {
            return this.f392a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f392a = true;
            this.f391a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m342a()) {
                cVar.m198a(1, m341a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM160a = bVar.m160a();
                if (iM160a == 0) {
                    return this;
                }
                if (iM160a != 10) {
                    if (!a(bVar, iM160a)) {
                        return this;
                    }
                } else {
                    a(bVar.m162a());
                }
            }
        }

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }
    }

    public static final class j extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a */
        private boolean f395a;

        /* JADX INFO: renamed from: b */
        private boolean f8905b;

        /* JADX INFO: renamed from: a */
        private com.xiaomi.push.a f393a = com.xiaomi.push.a.a;

        /* JADX INFO: renamed from: a */
        private b f394a = null;
        private int a = -1;

        /* JADX INFO: renamed from: b */
        public boolean m346b() {
            return this.f8905b;
        }

        /* JADX INFO: renamed from: a */
        public com.xiaomi.push.a m343a() {
            return this.f393a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m345a() ? 0 + com.xiaomi.push.c.a(1, m343a()) : 0;
            if (m346b()) {
                iA += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m344a());
            }
            this.a = iA;
            return iA;
        }

        /* JADX INFO: renamed from: a */
        public boolean m345a() {
            return this.f395a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f395a = true;
            this.f393a = aVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public b m344a() {
            return this.f394a;
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.f8905b = true;
                this.f394a = bVar;
                return this;
            }
            throw new NullPointerException();
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m345a()) {
                cVar.m198a(1, m343a());
            }
            if (m346b()) {
                cVar.m199a(2, (com.xiaomi.push.e) m344a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM160a = bVar.m160a();
                if (iM160a == 0) {
                    return this;
                }
                if (iM160a == 10) {
                    a(bVar.m162a());
                } else if (iM160a != 18) {
                    if (!a(bVar, iM160a)) {
                        return this;
                    }
                } else {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                }
            }
        }

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }
    }

    public static final class k extends com.xiaomi.push.e {

        /* JADX INFO: renamed from: a */
        private boolean f398a;

        /* JADX INFO: renamed from: b */
        private boolean f401b;

        /* JADX INFO: renamed from: c */
        private boolean f8907c;

        /* JADX INFO: renamed from: d */
        private boolean f8908d;

        /* JADX INFO: renamed from: e */
        private boolean f8909e;

        /* JADX INFO: renamed from: g */
        private boolean f8911g;

        /* JADX INFO: renamed from: a */
        private String f397a = "";

        /* JADX INFO: renamed from: b */
        private String f400b = "";

        /* JADX INFO: renamed from: a */
        private long f396a = 0;

        /* JADX INFO: renamed from: b */
        private long f399b = 0;

        /* JADX INFO: renamed from: f */
        private boolean f8910f = false;
        private int a = 0;

        /* JADX INFO: renamed from: b */
        private int f8906b = -1;

        /* JADX INFO: renamed from: b */
        public String m351b() {
            return this.f400b;
        }

        /* JADX INFO: renamed from: c */
        public boolean m353c() {
            return this.f8907c;
        }

        public boolean d() {
            return this.f8908d;
        }

        public boolean e() {
            return this.f8910f;
        }

        public boolean f() {
            return this.f8909e;
        }

        public boolean g() {
            return this.f8911g;
        }

        /* JADX INFO: renamed from: a */
        public String m348a() {
            return this.f397a;
        }

        /* JADX INFO: renamed from: b */
        public boolean m352b() {
            return this.f401b;
        }

        public int c() {
            return this.a;
        }

        /* JADX INFO: renamed from: a */
        public boolean m349a() {
            return this.f398a;
        }

        public k b(String str) {
            this.f401b = true;
            this.f400b = str;
            return this;
        }

        public k a(String str) {
            this.f398a = true;
            this.f397a = str;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public long m350b() {
            return this.f399b;
        }

        /* JADX INFO: renamed from: a */
        public long m347a() {
            return this.f396a;
        }

        public k b(long j2) {
            this.f8908d = true;
            this.f399b = j2;
            return this;
        }

        public k a(long j2) {
            this.f8907c = true;
            this.f396a = j2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m349a() ? 0 + com.xiaomi.push.c.a(1, m348a()) : 0;
            if (m352b()) {
                iA += com.xiaomi.push.c.a(2, m351b());
            }
            if (m353c()) {
                iA += com.xiaomi.push.c.a(3, m347a());
            }
            if (d()) {
                iA += com.xiaomi.push.c.a(4, m350b());
            }
            if (f()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            if (g()) {
                iA += com.xiaomi.push.c.a(6, c());
            }
            this.f8906b = iA;
            return iA;
        }

        public k a(boolean z) {
            this.f8909e = true;
            this.f8910f = z;
            return this;
        }

        public k a(int i2) {
            this.f8911g = true;
            this.a = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m349a()) {
                cVar.m200a(1, m348a());
            }
            if (m352b()) {
                cVar.m200a(2, m351b());
            }
            if (m353c()) {
                cVar.m197a(3, m347a());
            }
            if (d()) {
                cVar.m197a(4, m350b());
            }
            if (f()) {
                cVar.m201a(5, e());
            }
            if (g()) {
                cVar.m196a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f8906b < 0) {
                b();
            }
            return this.f8906b;
        }

        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM160a = bVar.m160a();
                if (iM160a == 0) {
                    return this;
                }
                if (iM160a == 10) {
                    a(bVar.m163a());
                } else if (iM160a == 18) {
                    b(bVar.m163a());
                } else if (iM160a == 24) {
                    a(bVar.m161a());
                } else if (iM160a == 32) {
                    b(bVar.m161a());
                } else if (iM160a == 40) {
                    a(bVar.m166a());
                } else if (iM160a != 48) {
                    if (!a(bVar, iM160a)) {
                        return this;
                    }
                } else {
                    a(bVar.m169b());
                }
            }
        }

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }
    }
}
