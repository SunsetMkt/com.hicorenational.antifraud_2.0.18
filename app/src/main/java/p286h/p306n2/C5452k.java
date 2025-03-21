package p286h.p306n2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import p286h.C5227e2;
import p286h.C5715y1;
import p286h.C5718z;
import p286h.InterfaceC5713y;
import p286h.p289g2.AbstractC5249c;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: FileTreeWalk.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m23546d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.n2.k */
/* loaded from: classes2.dex */
public final class C5452k implements InterfaceC5699m<File> {

    /* renamed from: a */
    private final File f20319a;

    /* renamed from: b */
    private final EnumC5454m f20320b;

    /* renamed from: c */
    private final InterfaceC5506l<File, Boolean> f20321c;

    /* renamed from: d */
    private final InterfaceC5506l<File, C5715y1> f20322d;

    /* renamed from: e */
    private final InterfaceC5510p<File, IOException, C5715y1> f20323e;

    /* renamed from: f */
    private final int f20324f;

    /* compiled from: FileTreeWalk.kt */
    /* renamed from: h.n2.k$a */
    private static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@InterfaceC5816d File file) {
            super(file);
            C5544i0.m22546f(file, "rootDir");
            if (C5227e2.f20082a) {
                boolean isDirectory = file.isDirectory();
                if (C5227e2.f20082a && !isDirectory) {
                    throw new AssertionError("rootDir must be verified to be directory beforehand.");
                }
            }
        }
    }

    /* compiled from: FileTreeWalk.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m23546d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
    /* renamed from: h.n2.k$b */
    private final class b extends AbstractC5249c<File> {

        /* renamed from: c */
        private final ArrayDeque<c> f20325c = new ArrayDeque<>();

        /* compiled from: FileTreeWalk.kt */
        /* renamed from: h.n2.k$b$a */
        private final class a extends a {

            /* renamed from: b */
            private boolean f20327b;

            /* renamed from: c */
            private File[] f20328c;

            /* renamed from: d */
            private int f20329d;

            /* renamed from: e */
            private boolean f20330e;

            /* renamed from: f */
            final /* synthetic */ b f20331f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@InterfaceC5816d b bVar, File file) {
                super(file);
                C5544i0.m22546f(file, "rootDir");
                this.f20331f = bVar;
            }

            @Override // p286h.p306n2.C5452k.c
            @InterfaceC5817e
            /* renamed from: b */
            public File mo22328b() {
                if (!this.f20330e && this.f20328c == null) {
                    InterfaceC5506l interfaceC5506l = C5452k.this.f20321c;
                    if (interfaceC5506l != null && !((Boolean) interfaceC5506l.invoke(m22329a())).booleanValue()) {
                        return null;
                    }
                    this.f20328c = m22329a().listFiles();
                    if (this.f20328c == null) {
                        InterfaceC5510p interfaceC5510p = C5452k.this.f20323e;
                        if (interfaceC5510p != null) {
                        }
                        this.f20330e = true;
                    }
                }
                File[] fileArr = this.f20328c;
                if (fileArr != null) {
                    int i2 = this.f20329d;
                    if (fileArr == null) {
                        C5544i0.m22545f();
                    }
                    if (i2 < fileArr.length) {
                        File[] fileArr2 = this.f20328c;
                        if (fileArr2 == null) {
                            C5544i0.m22545f();
                        }
                        int i3 = this.f20329d;
                        this.f20329d = i3 + 1;
                        return fileArr2[i3];
                    }
                }
                if (!this.f20327b) {
                    this.f20327b = true;
                    return m22329a();
                }
                InterfaceC5506l interfaceC5506l2 = C5452k.this.f20322d;
                if (interfaceC5506l2 != null) {
                }
                return null;
            }
        }

        /* compiled from: FileTreeWalk.kt */
        /* renamed from: h.n2.k$b$b, reason: collision with other inner class name */
        private final class C7431b extends c {

            /* renamed from: b */
            private boolean f20332b;

            /* renamed from: c */
            final /* synthetic */ b f20333c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C7431b(@InterfaceC5816d b bVar, File file) {
                super(file);
                C5544i0.m22546f(file, "rootFile");
                this.f20333c = bVar;
                if (C5227e2.f20082a) {
                    boolean isFile = file.isFile();
                    if (C5227e2.f20082a && !isFile) {
                        throw new AssertionError("rootFile must be verified to be file beforehand.");
                    }
                }
            }

            @Override // p286h.p306n2.C5452k.c
            @InterfaceC5817e
            /* renamed from: b */
            public File mo22328b() {
                if (this.f20332b) {
                    return null;
                }
                this.f20332b = true;
                return m22329a();
            }
        }

        /* compiled from: FileTreeWalk.kt */
        /* renamed from: h.n2.k$b$c */
        private final class c extends a {

            /* renamed from: b */
            private boolean f20334b;

            /* renamed from: c */
            private File[] f20335c;

            /* renamed from: d */
            private int f20336d;

            /* renamed from: e */
            final /* synthetic */ b f20337e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@InterfaceC5816d b bVar, File file) {
                super(file);
                C5544i0.m22546f(file, "rootDir");
                this.f20337e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:34:0x008b, code lost:
            
                if (r0.length == 0) goto L36;
             */
            @Override // p286h.p306n2.C5452k.c
            @p324i.p336c.p337a.InterfaceC5817e
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.io.File mo22328b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f20334b
                    r1 = 0
                    if (r0 != 0) goto L28
                    h.n2.k$b r0 = r10.f20337e
                    h.n2.k r0 = p286h.p306n2.C5452k.this
                    h.q2.s.l r0 = p286h.p306n2.C5452k.m22318c(r0)
                    if (r0 == 0) goto L20
                    java.io.File r2 = r10.m22329a()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L20
                    return r1
                L20:
                    r0 = 1
                    r10.f20334b = r0
                    java.io.File r0 = r10.m22329a()
                    return r0
                L28:
                    java.io.File[] r0 = r10.f20335c
                    if (r0 == 0) goto L4c
                    int r2 = r10.f20336d
                    if (r0 != 0) goto L33
                    p286h.p309q2.p311t.C5544i0.m22545f()
                L33:
                    int r0 = r0.length
                    if (r2 >= r0) goto L37
                    goto L4c
                L37:
                    h.n2.k$b r0 = r10.f20337e
                    h.n2.k r0 = p286h.p306n2.C5452k.this
                    h.q2.s.l r0 = p286h.p306n2.C5452k.m22320e(r0)
                    if (r0 == 0) goto L4b
                    java.io.File r2 = r10.m22329a()
                    java.lang.Object r0 = r0.invoke(r2)
                    h.y1 r0 = (p286h.C5715y1) r0
                L4b:
                    return r1
                L4c:
                    java.io.File[] r0 = r10.f20335c
                    if (r0 != 0) goto La2
                    java.io.File r0 = r10.m22329a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f20335c = r0
                    java.io.File[] r0 = r10.f20335c
                    if (r0 != 0) goto L81
                    h.n2.k$b r0 = r10.f20337e
                    h.n2.k r0 = p286h.p306n2.C5452k.this
                    h.q2.s.p r0 = p286h.p306n2.C5452k.m22319d(r0)
                    if (r0 == 0) goto L81
                    java.io.File r2 = r10.m22329a()
                    h.n2.a r9 = new h.n2.a
                    java.io.File r4 = r10.m22329a()
                    r5 = 0
                    r7 = 2
                    r8 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    java.lang.Object r0 = r0.invoke(r2, r9)
                    h.y1 r0 = (p286h.C5715y1) r0
                L81:
                    java.io.File[] r0 = r10.f20335c
                    if (r0 == 0) goto L8d
                    if (r0 != 0) goto L8a
                    p286h.p309q2.p311t.C5544i0.m22545f()
                L8a:
                    int r0 = r0.length
                    if (r0 != 0) goto La2
                L8d:
                    h.n2.k$b r0 = r10.f20337e
                    h.n2.k r0 = p286h.p306n2.C5452k.this
                    h.q2.s.l r0 = p286h.p306n2.C5452k.m22320e(r0)
                    if (r0 == 0) goto La1
                    java.io.File r2 = r10.m22329a()
                    java.lang.Object r0 = r0.invoke(r2)
                    h.y1 r0 = (p286h.C5715y1) r0
                La1:
                    return r1
                La2:
                    java.io.File[] r0 = r10.f20335c
                    if (r0 != 0) goto La9
                    p286h.p309q2.p311t.C5544i0.m22545f()
                La9:
                    int r1 = r10.f20336d
                    int r2 = r1 + 1
                    r10.f20336d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: p286h.p306n2.C5452k.b.c.mo22328b():java.io.File");
            }
        }

        public b() {
            if (C5452k.this.f20319a.isDirectory()) {
                this.f20325c.push(m22326a(C5452k.this.f20319a));
            } else if (C5452k.this.f20319a.isFile()) {
                this.f20325c.push(new C7431b(this, C5452k.this.f20319a));
            } else {
                m19569c();
            }
        }

        /* renamed from: a */
        private final a m22326a(File file) {
            int i2 = C5453l.f20339a[C5452k.this.f20320b.ordinal()];
            if (i2 == 1) {
                return new c(this, file);
            }
            if (i2 == 2) {
                return new a(this, file);
            }
            throw new C5718z();
        }

        /* renamed from: d */
        private final File m22327d() {
            File mo22328b;
            while (true) {
                c peek = this.f20325c.peek();
                if (peek == null) {
                    return null;
                }
                mo22328b = peek.mo22328b();
                if (mo22328b == null) {
                    this.f20325c.pop();
                } else {
                    if (C5544i0.m22531a(mo22328b, peek.m22329a()) || !mo22328b.isDirectory() || this.f20325c.size() >= C5452k.this.f20324f) {
                        break;
                    }
                    this.f20325c.push(m22326a(mo22328b));
                }
            }
            return mo22328b;
        }

        @Override // p286h.p289g2.AbstractC5249c
        /* renamed from: b */
        protected void mo19567b() {
            File m22327d = m22327d();
            if (m22327d != null) {
                m19568b(m22327d);
            } else {
                m19569c();
            }
        }
    }

    /* compiled from: FileTreeWalk.kt */
    /* renamed from: h.n2.k$c */
    private static abstract class c {

        /* renamed from: a */
        @InterfaceC5816d
        private final File f20338a;

        public c(@InterfaceC5816d File file) {
            C5544i0.m22546f(file, "root");
            this.f20338a = file;
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final File m22329a() {
            return this.f20338a;
        }

        @InterfaceC5817e
        /* renamed from: b */
        public abstract File mo22328b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private C5452k(File file, EnumC5454m enumC5454m, InterfaceC5506l<? super File, Boolean> interfaceC5506l, InterfaceC5506l<? super File, C5715y1> interfaceC5506l2, InterfaceC5510p<? super File, ? super IOException, C5715y1> interfaceC5510p, int i2) {
        this.f20319a = file;
        this.f20320b = enumC5454m;
        this.f20321c = interfaceC5506l;
        this.f20322d = interfaceC5506l2;
        this.f20323e = interfaceC5510p;
        this.f20324f = i2;
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<File> iterator() {
        return new b();
    }

    /* synthetic */ C5452k(File file, EnumC5454m enumC5454m, InterfaceC5506l interfaceC5506l, InterfaceC5506l interfaceC5506l2, InterfaceC5510p interfaceC5510p, int i2, int i3, C5586v c5586v) {
        this(file, (i3 & 2) != 0 ? EnumC5454m.TOP_DOWN : enumC5454m, interfaceC5506l, interfaceC5506l2, interfaceC5510p, (i3 & 32) != 0 ? Integer.MAX_VALUE : i2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final C5452k m22322a(@InterfaceC5816d InterfaceC5506l<? super File, Boolean> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5506l, "function");
        return new C5452k(this.f20319a, this.f20320b, interfaceC5506l, this.f20322d, this.f20323e, this.f20324f);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final C5452k m22324b(@InterfaceC5816d InterfaceC5506l<? super File, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5506l, "function");
        return new C5452k(this.f20319a, this.f20320b, this.f20321c, interfaceC5506l, this.f20323e, this.f20324f);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final C5452k m22325c(int i2) {
        if (i2 > 0) {
            return new C5452k(this.f20319a, this.f20320b, this.f20321c, this.f20322d, this.f20323e, i2);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i2 + '.');
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final C5452k m22323a(@InterfaceC5816d InterfaceC5510p<? super File, ? super IOException, C5715y1> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "function");
        return new C5452k(this.f20319a, this.f20320b, this.f20321c, this.f20322d, interfaceC5510p, this.f20324f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C5452k(@InterfaceC5816d File file, @InterfaceC5816d EnumC5454m enumC5454m) {
        this(file, enumC5454m, null, null, null, 0, 32, null);
        C5544i0.m22546f(file, "start");
        C5544i0.m22546f(enumC5454m, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
    }

    public /* synthetic */ C5452k(File file, EnumC5454m enumC5454m, int i2, C5586v c5586v) {
        this(file, (i2 & 2) != 0 ? EnumC5454m.TOP_DOWN : enumC5454m);
    }
}
