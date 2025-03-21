package com.airbnb.lottie.p102w.p103b;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.p106y.p108k.C1466h;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* renamed from: com.airbnb.lottie.w.b.l */
/* loaded from: classes.dex */
public class C1404l implements InterfaceC1406n, InterfaceC1402j {

    /* renamed from: d */
    private final String f3456d;

    /* renamed from: f */
    private final C1466h f3458f;

    /* renamed from: a */
    private final Path f3453a = new Path();

    /* renamed from: b */
    private final Path f3454b = new Path();

    /* renamed from: c */
    private final Path f3455c = new Path();

    /* renamed from: e */
    private final List<InterfaceC1406n> f3457e = new ArrayList();

    /* compiled from: MergePathsContent.java */
    /* renamed from: com.airbnb.lottie.w.b.l$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3459a = new int[C1466h.a.values().length];

        static {
            try {
                f3459a[C1466h.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3459a[C1466h.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3459a[C1466h.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3459a[C1466h.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3459a[C1466h.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public C1404l(C1466h c1466h) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.f3456d = c1466h.m3271b();
        this.f3458f = c1466h;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1402j
    /* renamed from: a */
    public void mo3117a(ListIterator<InterfaceC1395c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            InterfaceC1395c previous = listIterator.previous();
            if (previous instanceof InterfaceC1406n) {
                this.f3457e.add((InterfaceC1406n) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3456d;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1406n
    public Path getPath() {
        this.f3455c.reset();
        if (this.f3458f.m3272c()) {
            return this.f3455c;
        }
        int i2 = a.f3459a[this.f3458f.m3270a().ordinal()];
        if (i2 == 1) {
            m3118a();
        } else if (i2 == 2) {
            m3119a(Path.Op.UNION);
        } else if (i2 == 3) {
            m3119a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i2 == 4) {
            m3119a(Path.Op.INTERSECT);
        } else if (i2 == 5) {
            m3119a(Path.Op.XOR);
        }
        return this.f3455c;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
        for (int i2 = 0; i2 < this.f3457e.size(); i2++) {
            this.f3457e.get(i2).mo3098a(list, list2);
        }
    }

    /* renamed from: a */
    private void m3118a() {
        for (int i2 = 0; i2 < this.f3457e.size(); i2++) {
            this.f3455c.addPath(this.f3457e.get(i2).getPath());
        }
    }

    @TargetApi(19)
    /* renamed from: a */
    private void m3119a(Path.Op op) {
        this.f3454b.reset();
        this.f3453a.reset();
        for (int size = this.f3457e.size() - 1; size >= 1; size--) {
            InterfaceC1406n interfaceC1406n = this.f3457e.get(size);
            if (interfaceC1406n instanceof C1396d) {
                C1396d c1396d = (C1396d) interfaceC1406n;
                List<InterfaceC1406n> m3106b = c1396d.m3106b();
                for (int size2 = m3106b.size() - 1; size2 >= 0; size2--) {
                    Path path = m3106b.get(size2).getPath();
                    path.transform(c1396d.m3107c());
                    this.f3454b.addPath(path);
                }
            } else {
                this.f3454b.addPath(interfaceC1406n.getPath());
            }
        }
        InterfaceC1406n interfaceC1406n2 = this.f3457e.get(0);
        if (interfaceC1406n2 instanceof C1396d) {
            C1396d c1396d2 = (C1396d) interfaceC1406n2;
            List<InterfaceC1406n> m3106b2 = c1396d2.m3106b();
            for (int i2 = 0; i2 < m3106b2.size(); i2++) {
                Path path2 = m3106b2.get(i2).getPath();
                path2.transform(c1396d2.m3107c());
                this.f3453a.addPath(path2);
            }
        } else {
            this.f3453a.set(interfaceC1406n2.getPath());
        }
        this.f3455c.op(this.f3453a, this.f3454b, op);
    }
}
