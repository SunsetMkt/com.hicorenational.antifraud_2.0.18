package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.p137r.InterfaceC1825d;
import com.bumptech.glide.p137r.p138l.InterfaceC1847o;
import com.bumptech.glide.p137r.p138l.InterfaceC1848p;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;
import com.bumptech.glide.util.C1878l;
import java.util.List;
import java.util.Queue;

/* compiled from: ListPreloader.java */
/* renamed from: com.bumptech.glide.e */
/* loaded from: classes.dex */
public class C1579e<T> implements AbsListView.OnScrollListener {

    /* renamed from: a */
    private final int f4110a;

    /* renamed from: b */
    private final d f4111b;

    /* renamed from: c */
    private final ComponentCallbacks2C1585k f4112c;

    /* renamed from: d */
    private final a<T> f4113d;

    /* renamed from: e */
    private final b<T> f4114e;

    /* renamed from: f */
    private int f4115f;

    /* renamed from: g */
    private int f4116g;

    /* renamed from: i */
    private int f4118i;

    /* renamed from: h */
    private int f4117h = -1;

    /* renamed from: j */
    private boolean f4119j = true;

    /* compiled from: ListPreloader.java */
    /* renamed from: com.bumptech.glide.e$a */
    public interface a<U> {
        @Nullable
        /* renamed from: a */
        C1584j<?> m3702a(@NonNull U u);

        @NonNull
        /* renamed from: a */
        List<U> m3703a(int i2);
    }

    /* compiled from: ListPreloader.java */
    /* renamed from: com.bumptech.glide.e$b */
    public interface b<T> {
        @Nullable
        /* renamed from: a */
        int[] mo3704a(@NonNull T t, int i2, int i3);
    }

    /* compiled from: ListPreloader.java */
    /* renamed from: com.bumptech.glide.e$c */
    private static final class c implements InterfaceC1848p<Object> {

        /* renamed from: a */
        int f4120a;

        /* renamed from: b */
        int f4121b;

        /* renamed from: c */
        @Nullable
        private InterfaceC1825d f4122c;

        c() {
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: a */
        public void mo3706a(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: a */
        public void mo3707a(@Nullable InterfaceC1825d interfaceC1825d) {
            this.f4122c = interfaceC1825d;
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: a */
        public void mo3708a(@NonNull InterfaceC1847o interfaceC1847o) {
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: a */
        public void mo3709a(@NonNull Object obj, @Nullable InterfaceC1856f<? super Object> interfaceC1856f) {
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: b */
        public void mo3710b(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: b */
        public void mo3711b(@NonNull InterfaceC1847o interfaceC1847o) {
            interfaceC1847o.mo4867a(this.f4121b, this.f4120a);
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        /* renamed from: c */
        public void mo3712c(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.manager.InterfaceC1795i
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.manager.InterfaceC1795i
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.InterfaceC1795i
        public void onStop() {
        }

        @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
        @Nullable
        /* renamed from: a */
        public InterfaceC1825d mo3705a() {
            return this.f4122c;
        }
    }

    /* compiled from: ListPreloader.java */
    /* renamed from: com.bumptech.glide.e$d */
    private static final class d {

        /* renamed from: a */
        final Queue<c> f4123a;

        d(int i2) {
            this.f4123a = C1878l.m5002a(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                this.f4123a.offer(new c());
            }
        }

        /* renamed from: a */
        public c m3713a(int i2, int i3) {
            c poll = this.f4123a.poll();
            this.f4123a.offer(poll);
            poll.f4121b = i2;
            poll.f4120a = i3;
            return poll;
        }
    }

    public C1579e(@NonNull ComponentCallbacks2C1585k componentCallbacks2C1585k, @NonNull a<T> aVar, @NonNull b<T> bVar, int i2) {
        this.f4112c = componentCallbacks2C1585k;
        this.f4113d = aVar;
        this.f4114e = bVar;
        this.f4110a = i2;
        this.f4111b = new d(i2 + 1);
    }

    /* renamed from: a */
    private void m3699a(int i2, boolean z) {
        if (this.f4119j != z) {
            this.f4119j = z;
            m3697a();
        }
        m3698a(i2, (z ? this.f4110a : -this.f4110a) + i2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.f4118i = i4;
        int i5 = this.f4117h;
        if (i2 > i5) {
            m3699a(i3 + i2, true);
        } else if (i2 < i5) {
            m3699a(i2, false);
        }
        this.f4117h = i2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }

    /* renamed from: a */
    private void m3698a(int i2, int i3) {
        int min;
        int i4;
        if (i2 < i3) {
            i4 = Math.max(this.f4115f, i2);
            min = i3;
        } else {
            min = Math.min(this.f4116g, i2);
            i4 = i3;
        }
        int min2 = Math.min(this.f4118i, min);
        int min3 = Math.min(this.f4118i, Math.max(0, i4));
        if (i2 < i3) {
            for (int i5 = min3; i5 < min2; i5++) {
                m3701a((List) this.f4113d.m3703a(i5), i5, true);
            }
        } else {
            for (int i6 = min2 - 1; i6 >= min3; i6--) {
                m3701a((List) this.f4113d.m3703a(i6), i6, false);
            }
        }
        this.f4116g = min3;
        this.f4115f = min2;
    }

    /* renamed from: a */
    private void m3701a(List<T> list, int i2, boolean z) {
        int size = list.size();
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                m3700a((C1579e<T>) list.get(i3), i2, i3);
            }
            return;
        }
        for (int i4 = size - 1; i4 >= 0; i4--) {
            m3700a((C1579e<T>) list.get(i4), i2, i4);
        }
    }

    /* renamed from: a */
    private void m3700a(@Nullable T t, int i2, int i3) {
        int[] mo3704a;
        C1584j<?> m3702a;
        if (t == null || (mo3704a = this.f4114e.mo3704a(t, i2, i3)) == null || (m3702a = this.f4113d.m3702a((a<T>) t)) == null) {
            return;
        }
        m3702a.m3773b((C1584j<?>) this.f4111b.m3713a(mo3704a[0], mo3704a[1]));
    }

    /* renamed from: a */
    private void m3697a() {
        for (int i2 = 0; i2 < this.f4111b.f4123a.size(); i2++) {
            this.f4112c.m3783a((InterfaceC1848p<?>) this.f4111b.m3713a(0, 0));
        }
    }
}
