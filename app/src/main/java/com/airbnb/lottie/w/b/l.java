package com.airbnb.lottie.w.b;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.y.k.h;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: MergePathsContent.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public class l implements n, j {

    /* JADX INFO: renamed from: d */
    private final String f2301d;

    /* JADX INFO: renamed from: f */
    private final com.airbnb.lottie.y.k.h f2303f;
    private final Path a = new Path();

    /* JADX INFO: renamed from: b */
    private final Path f2299b = new Path();

    /* JADX INFO: renamed from: c */
    private final Path f2300c = new Path();

    /* JADX INFO: renamed from: e */
    private final List<n> f2302e = new ArrayList();

    /* JADX INFO: compiled from: MergePathsContent.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[h.a.values().length];

        static {
            try {
                a[h.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[h.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[h.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(com.airbnb.lottie.y.k.h hVar) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.f2301d = hVar.b();
        this.f2303f = hVar;
    }

    @Override // com.airbnb.lottie.w.b.j
    public void a(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVarPrevious = listIterator.previous();
            if (cVarPrevious instanceof n) {
                this.f2302e.add((n) cVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f2301d;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        this.f2300c.reset();
        if (this.f2303f.c()) {
            return this.f2300c;
        }
        int i2 = a.a[this.f2303f.a().ordinal()];
        if (i2 == 1) {
            a();
        } else if (i2 == 2) {
            a(Path.Op.UNION);
        } else if (i2 == 3) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i2 == 4) {
            a(Path.Op.INTERSECT);
        } else if (i2 == 5) {
            a(Path.Op.XOR);
        }
        return this.f2300c;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < this.f2302e.size(); i2++) {
            this.f2302e.get(i2).a(list, list2);
        }
    }

    private void a() {
        for (int i2 = 0; i2 < this.f2302e.size(); i2++) {
            this.f2300c.addPath(this.f2302e.get(i2).getPath());
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.f2299b.reset();
        this.a.reset();
        for (int size = this.f2302e.size() - 1; size >= 1; size--) {
            n nVar = this.f2302e.get(size);
            if (nVar instanceof d) {
                d dVar = (d) nVar;
                List<n> listB = dVar.b();
                for (int size2 = listB.size() - 1; size2 >= 0; size2--) {
                    Path path = listB.get(size2).getPath();
                    path.transform(dVar.c());
                    this.f2299b.addPath(path);
                }
            } else {
                this.f2299b.addPath(nVar.getPath());
            }
        }
        n nVar2 = this.f2302e.get(0);
        if (nVar2 instanceof d) {
            d dVar2 = (d) nVar2;
            List<n> listB2 = dVar2.b();
            for (int i2 = 0; i2 < listB2.size(); i2++) {
                Path path2 = listB2.get(i2).getPath();
                path2.transform(dVar2.c());
                this.a.addPath(path2);
            }
        } else {
            this.a.set(nVar2.getPath());
        }
        this.f2300c.op(this.a, this.f2299b, op);
    }
}
