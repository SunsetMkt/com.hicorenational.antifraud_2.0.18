package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.r.l.o;
import com.bumptech.glide.r.l.p;
import java.util.List;
import java.util.Queue;

/* compiled from: ListPreloader.java */
/* loaded from: classes.dex */
public class e<T> implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    private final int f4187a;

    /* renamed from: b, reason: collision with root package name */
    private final d f4188b;

    /* renamed from: c, reason: collision with root package name */
    private final k f4189c;

    /* renamed from: d, reason: collision with root package name */
    private final a<T> f4190d;

    /* renamed from: e, reason: collision with root package name */
    private final b<T> f4191e;

    /* renamed from: f, reason: collision with root package name */
    private int f4192f;

    /* renamed from: g, reason: collision with root package name */
    private int f4193g;

    /* renamed from: i, reason: collision with root package name */
    private int f4195i;

    /* renamed from: h, reason: collision with root package name */
    private int f4194h = -1;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4196j = true;

    /* compiled from: ListPreloader.java */
    public interface a<U> {
        @Nullable
        j<?> a(@NonNull U u);

        @NonNull
        List<U> a(int i2);
    }

    /* compiled from: ListPreloader.java */
    public interface b<T> {
        @Nullable
        int[] a(@NonNull T t, int i2, int i3);
    }

    /* compiled from: ListPreloader.java */
    private static final class c implements p<Object> {

        /* renamed from: a, reason: collision with root package name */
        int f4197a;

        /* renamed from: b, reason: collision with root package name */
        int f4198b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private com.bumptech.glide.r.d f4199c;

        c() {
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.r.l.p
        public void a(@Nullable com.bumptech.glide.r.d dVar) {
            this.f4199c = dVar;
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
            oVar.a(this.f4198b, this.f4197a);
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
            return this.f4199c;
        }
    }

    /* compiled from: ListPreloader.java */
    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        final Queue<c> f4200a;

        d(int i2) {
            this.f4200a = com.bumptech.glide.util.l.a(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                this.f4200a.offer(new c());
            }
        }

        public c a(int i2, int i3) {
            c poll = this.f4200a.poll();
            this.f4200a.offer(poll);
            poll.f4198b = i2;
            poll.f4197a = i3;
            return poll;
        }
    }

    public e(@NonNull k kVar, @NonNull a<T> aVar, @NonNull b<T> bVar, int i2) {
        this.f4189c = kVar;
        this.f4190d = aVar;
        this.f4191e = bVar;
        this.f4187a = i2;
        this.f4188b = new d(i2 + 1);
    }

    private void a(int i2, boolean z) {
        if (this.f4196j != z) {
            this.f4196j = z;
            a();
        }
        a(i2, (z ? this.f4187a : -this.f4187a) + i2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.f4195i = i4;
        int i5 = this.f4194h;
        if (i2 > i5) {
            a(i3 + i2, true);
        } else if (i2 < i5) {
            a(i2, false);
        }
        this.f4194h = i2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }

    private void a(int i2, int i3) {
        int min;
        int i4;
        if (i2 < i3) {
            i4 = Math.max(this.f4192f, i2);
            min = i3;
        } else {
            min = Math.min(this.f4193g, i2);
            i4 = i3;
        }
        int min2 = Math.min(this.f4195i, min);
        int min3 = Math.min(this.f4195i, Math.max(0, i4));
        if (i2 < i3) {
            for (int i5 = min3; i5 < min2; i5++) {
                a((List) this.f4190d.a(i5), i5, true);
            }
        } else {
            for (int i6 = min2 - 1; i6 >= min3; i6--) {
                a((List) this.f4190d.a(i6), i6, false);
            }
        }
        this.f4193g = min3;
        this.f4192f = min2;
    }

    private void a(List<T> list, int i2, boolean z) {
        int size = list.size();
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                a((e<T>) list.get(i3), i2, i3);
            }
            return;
        }
        for (int i4 = size - 1; i4 >= 0; i4--) {
            a((e<T>) list.get(i4), i2, i4);
        }
    }

    private void a(@Nullable T t, int i2, int i3) {
        int[] a2;
        j<?> a3;
        if (t == null || (a2 = this.f4191e.a(t, i2, i3)) == null || (a3 = this.f4190d.a((a<T>) t)) == null) {
            return;
        }
        a3.b((j<?>) this.f4188b.a(a2[0], a2[1]));
    }

    private void a() {
        for (int i2 = 0; i2 < this.f4188b.f4200a.size(); i2++) {
            this.f4189c.a((p<?>) this.f4188b.a(0, 0));
        }
    }
}
