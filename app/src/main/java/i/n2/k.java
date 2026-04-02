package i.n2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import i.e2;
import i.q2.t.i0;
import i.y;
import i.y1;
import i.z;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class k implements i.x2.m<File> {
    private final File a;

    /* JADX INFO: renamed from: b */
    private final m f12172b;

    /* JADX INFO: renamed from: c */
    private final i.q2.s.l<File, Boolean> f12173c;

    /* JADX INFO: renamed from: d */
    private final i.q2.s.l<File, y1> f12174d;

    /* JADX INFO: renamed from: e */
    private final i.q2.s.p<File, IOException, y1> f12175e;

    /* JADX INFO: renamed from: f */
    private final int f12176f;

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    private static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@j.c.a.d File file) {
            super(file);
            i0.f(file, "rootDir");
            if (e2.a) {
                boolean zIsDirectory = file.isDirectory();
                if (e2.a && !zIsDirectory) {
                    throw new AssertionError("rootDir must be verified to be directory beforehand.");
                }
            }
        }
    }

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    private final class b extends i.g2.c<File> {

        /* JADX INFO: renamed from: c */
        private final ArrayDeque<c> f12177c = new ArrayDeque<>();

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        private final class a extends a {

            /* JADX INFO: renamed from: b */
            private boolean f12179b;

            /* JADX INFO: renamed from: c */
            private File[] f12180c;

            /* JADX INFO: renamed from: d */
            private int f12181d;

            /* JADX INFO: renamed from: e */
            private boolean f12182e;

            /* JADX INFO: renamed from: f */
            final /* synthetic */ b f12183f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@j.c.a.d b bVar, File file) {
                super(file);
                i0.f(file, "rootDir");
                this.f12183f = bVar;
            }

            @Override // i.n2.k.c
            @j.c.a.e
            public File b() {
                if (!this.f12182e && this.f12180c == null) {
                    i.q2.s.l lVar = k.this.f12173c;
                    if (lVar != null && !((Boolean) lVar.invoke(a())).booleanValue()) {
                        return null;
                    }
                    this.f12180c = a().listFiles();
                    if (this.f12180c == null) {
                        i.q2.s.p pVar = k.this.f12175e;
                        if (pVar != null) {
                        }
                        this.f12182e = true;
                    }
                }
                File[] fileArr = this.f12180c;
                if (fileArr != null) {
                    int i2 = this.f12181d;
                    if (fileArr == null) {
                        i0.f();
                    }
                    if (i2 < fileArr.length) {
                        File[] fileArr2 = this.f12180c;
                        if (fileArr2 == null) {
                            i0.f();
                        }
                        int i3 = this.f12181d;
                        this.f12181d = i3 + 1;
                        return fileArr2[i3];
                    }
                }
                if (!this.f12179b) {
                    this.f12179b = true;
                    return a();
                }
                i.q2.s.l lVar2 = k.this.f12174d;
                if (lVar2 != null) {
                }
                return null;
            }
        }

        /* JADX INFO: renamed from: i.n2.k$b$b */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        private final class C0248b extends c {

            /* JADX INFO: renamed from: b */
            private boolean f12184b;

            /* JADX INFO: renamed from: c */
            final /* synthetic */ b f12185c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0248b(@j.c.a.d b bVar, File file) {
                super(file);
                i0.f(file, "rootFile");
                this.f12185c = bVar;
                if (e2.a) {
                    boolean zIsFile = file.isFile();
                    if (e2.a && !zIsFile) {
                        throw new AssertionError("rootFile must be verified to be file beforehand.");
                    }
                }
            }

            @Override // i.n2.k.c
            @j.c.a.e
            public File b() {
                if (this.f12184b) {
                    return null;
                }
                this.f12184b = true;
                return a();
            }
        }

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        private final class c extends a {

            /* JADX INFO: renamed from: b */
            private boolean f12186b;

            /* JADX INFO: renamed from: c */
            private File[] f12187c;

            /* JADX INFO: renamed from: d */
            private int f12188d;

            /* JADX INFO: renamed from: e */
            final /* synthetic */ b f12189e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@j.c.a.d b bVar, File file) {
                super(file);
                i0.f(file, "rootDir");
                this.f12189e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:80:0x008b, code lost:
            
                if (r0.length == 0) goto L81;
             */
            @Override // i.n2.k.c
            @j.c.a.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public File b() {
                i.q2.s.p pVar;
                if (!this.f12186b) {
                    i.q2.s.l lVar = k.this.f12173c;
                    if (lVar != null && !((Boolean) lVar.invoke(a())).booleanValue()) {
                        return null;
                    }
                    this.f12186b = true;
                    return a();
                }
                File[] fileArr = this.f12187c;
                if (fileArr != null) {
                    int i2 = this.f12188d;
                    if (fileArr == null) {
                        i0.f();
                    }
                    if (i2 >= fileArr.length) {
                        i.q2.s.l lVar2 = k.this.f12174d;
                        if (lVar2 != null) {
                        }
                        return null;
                    }
                }
                if (this.f12187c == null) {
                    this.f12187c = a().listFiles();
                    if (this.f12187c == null && (pVar = k.this.f12175e) != null) {
                    }
                    File[] fileArr2 = this.f12187c;
                    if (fileArr2 != null) {
                        if (fileArr2 == null) {
                            i0.f();
                        }
                    }
                    i.q2.s.l lVar3 = k.this.f12174d;
                    if (lVar3 != null) {
                    }
                    return null;
                }
                File[] fileArr3 = this.f12187c;
                if (fileArr3 == null) {
                    i0.f();
                }
                int i3 = this.f12188d;
                this.f12188d = i3 + 1;
                return fileArr3[i3];
            }
        }

        public b() {
            if (k.this.a.isDirectory()) {
                this.f12177c.push(a(k.this.a));
            } else if (k.this.a.isFile()) {
                this.f12177c.push(new C0248b(this, k.this.a));
            } else {
                c();
            }
        }

        private final a a(File file) {
            int i2 = l.a[k.this.f12172b.ordinal()];
            if (i2 == 1) {
                return new c(this, file);
            }
            if (i2 == 2) {
                return new a(this, file);
            }
            throw new z();
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x003f, code lost:
        
            return r1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final File d() {
            while (true) {
                c cVarPeek = this.f12177c.peek();
                if (cVarPeek == null) {
                    return null;
                }
                File fileB = cVarPeek.b();
                if (fileB == null) {
                    this.f12177c.pop();
                } else {
                    if (i0.a(fileB, cVarPeek.a()) || !fileB.isDirectory() || this.f12177c.size() >= k.this.f12176f) {
                        break;
                    }
                    this.f12177c.push(a(fileB));
                }
            }
        }

        @Override // i.g2.c
        protected void b() {
            File fileD = d();
            if (fileD != null) {
                b(fileD);
            } else {
                c();
            }
        }
    }

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    private static abstract class c {

        @j.c.a.d
        private final File a;

        public c(@j.c.a.d File file) {
            i0.f(file, "root");
            this.a = file;
        }

        @j.c.a.d
        public final File a() {
            return this.a;
        }

        @j.c.a.e
        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private k(File file, m mVar, i.q2.s.l<? super File, Boolean> lVar, i.q2.s.l<? super File, y1> lVar2, i.q2.s.p<? super File, ? super IOException, y1> pVar, int i2) {
        this.a = file;
        this.f12172b = mVar;
        this.f12173c = lVar;
        this.f12174d = lVar2;
        this.f12175e = pVar;
        this.f12176f = i2;
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<File> iterator() {
        return new b();
    }

    /* synthetic */ k(File file, m mVar, i.q2.s.l lVar, i.q2.s.l lVar2, i.q2.s.p pVar, int i2, int i3, i.q2.t.v vVar) {
        this(file, (i3 & 2) != 0 ? m.TOP_DOWN : mVar, lVar, lVar2, pVar, (i3 & 32) != 0 ? Integer.MAX_VALUE : i2);
    }

    @j.c.a.d
    public final k a(@j.c.a.d i.q2.s.l<? super File, Boolean> lVar) {
        i0.f(lVar, "function");
        return new k(this.a, this.f12172b, lVar, this.f12174d, this.f12175e, this.f12176f);
    }

    @j.c.a.d
    public final k b(@j.c.a.d i.q2.s.l<? super File, y1> lVar) {
        i0.f(lVar, "function");
        return new k(this.a, this.f12172b, this.f12173c, lVar, this.f12175e, this.f12176f);
    }

    @j.c.a.d
    public final k c(int i2) {
        if (i2 > 0) {
            return new k(this.a, this.f12172b, this.f12173c, this.f12174d, this.f12175e, i2);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i2 + '.');
    }

    @j.c.a.d
    public final k a(@j.c.a.d i.q2.s.p<? super File, ? super IOException, y1> pVar) {
        i0.f(pVar, "function");
        return new k(this.a, this.f12172b, this.f12173c, this.f12174d, pVar, this.f12176f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(@j.c.a.d File file, @j.c.a.d m mVar) {
        this(file, mVar, null, null, null, 0, 32, null);
        i0.f(file, "start");
        i0.f(mVar, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
    }

    public /* synthetic */ k(File file, m mVar, int i2, i.q2.t.v vVar) {
        this(file, (i2 & 2) != 0 ? m.TOP_DOWN : mVar);
    }
}
