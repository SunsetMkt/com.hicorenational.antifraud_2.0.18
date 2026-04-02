package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.r.l.o;
import com.bumptech.glide.r.l.p;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: ListPreloader.java */
/* JADX INFO: loaded from: classes.dex */
public class e<T> implements AbsListView.OnScrollListener {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f2673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f2674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a<T> f2675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b<T> f2676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2678g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2680i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2679h = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2681j = true;

    /* JADX INFO: compiled from: ListPreloader.java */
    public interface a<U> {
        @Nullable
        j<?> a(@NonNull U u);

        @NonNull
        List<U> a(int i2);
    }

    /* JADX INFO: compiled from: ListPreloader.java */
    public interface b<T> {
        @Nullable
        int[] a(@NonNull T t, int i2, int i3);
    }

    /* JADX INFO: compiled from: ListPreloader.java */
    private static final class c implements p<Object> {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private com.bumptech.glide.r.d f2683c;

        c() {
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@Nullable com.bumptech.glide.r.d dVar) {
            this.f2683c = dVar;
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@NonNull o oVar) {
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@NonNull Object obj, @Nullable com.bumptech.glide.r.m.f<? super Object> fVar) {
        }

        @Override // com.bumptech.glide.r.l.p
        public void b(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.r.l.p
        public void b(@NonNull o oVar) {
            oVar.a(this.f2682b, this.a);
        }

        @Override // com.bumptech.glide.r.l.p
        public void c(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.manager.i
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.manager.i
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.i
        public void onStop() {
        }

        @Override // com.bumptech.glide.r.l.p
        @Nullable
        public com.bumptech.glide.r.d a() {
            return this.f2683c;
        }
    }

    /* JADX INFO: compiled from: ListPreloader.java */
    private static final class d {
        final Queue<c> a;

        d(int i2) {
            this.a = com.bumptech.glide.util.l.a(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                this.a.offer(new c());
            }
        }

        public c a(int i2, int i3) {
            c cVarPoll = this.a.poll();
            this.a.offer(cVarPoll);
            cVarPoll.f2682b = i2;
            cVarPoll.a = i3;
            return cVarPoll;
        }
    }

    public e(@NonNull k kVar, @NonNull a<T> aVar, @NonNull b<T> bVar, int i2) {
        this.f2674c = kVar;
        this.f2675d = aVar;
        this.f2676e = bVar;
        this.a = i2;
        this.f2673b = new d(i2 + 1);
    }

    private void a(int i2, boolean z) {
        if (this.f2681j != z) {
            this.f2681j = z;
            a();
        }
        a(i2, (z ? this.a : -this.a) + i2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.f2680i = i4;
        int i5 = this.f2679h;
        if (i2 > i5) {
            a(i3 + i2, true);
        } else if (i2 < i5) {
            a(i2, false);
        }
        this.f2679h = i2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }

    private void a(int i2, int i3) {
        int iMin;
        int iMax;
        if (i2 < i3) {
            iMax = Math.max(this.f2677f, i2);
            iMin = i3;
        } else {
            iMin = Math.min(this.f2678g, i2);
            iMax = i3;
        }
        int iMin2 = Math.min(this.f2680i, iMin);
        int iMin3 = Math.min(this.f2680i, Math.max(0, iMax));
        if (i2 < i3) {
            for (int i4 = iMin3; i4 < iMin2; i4++) {
                a((List) this.f2675d.a(i4), i4, true);
            }
        } else {
            for (int i5 = iMin2 - 1; i5 >= iMin3; i5--) {
                a((List) this.f2675d.a(i5), i5, false);
            }
        }
        this.f2678g = iMin3;
        this.f2677f = iMin2;
    }

    private void a(List<T> list, int i2, boolean z) {
        int size = list.size();
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                a(list.get(i3), i2, i3);
            }
            return;
        }
        for (int i4 = size - 1; i4 >= 0; i4--) {
            a(list.get(i4), i2, i4);
        }
    }

    private void a(@Nullable T t, int i2, int i3) {
        int[] iArrA;
        j<?> jVarA;
        if (t == null || (iArrA = this.f2676e.a(t, i2, i3)) == null || (jVarA = this.f2675d.a(t)) == null) {
            return;
        }
        jVarA.b(this.f2673b.a(iArrA[0], iArrA[1]));
    }

    private void a() {
        for (int i2 = 0; i2 < this.f2673b.a.size(); i2++) {
            this.f2674c.a((p<?>) this.f2673b.a(0, 0));
        }
    }
}
