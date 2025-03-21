package com.bumptech.glide.load.p118p.p119a0;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C1878l;
import java.util.NavigableMap;

/* compiled from: SizeStrategy.java */
@RequiresApi(19)
/* renamed from: com.bumptech.glide.load.p.a0.p */
/* loaded from: classes.dex */
final class C1637p implements InterfaceC1633l {

    /* renamed from: d */
    private static final int f4329d = 8;

    /* renamed from: a */
    private final b f4330a = new b();

    /* renamed from: b */
    private final C1629h<a, Bitmap> f4331b = new C1629h<>();

    /* renamed from: c */
    private final NavigableMap<Integer, Integer> f4332c = new C1635n();

    /* compiled from: SizeStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.a0.p$a */
    static final class a implements InterfaceC1634m {

        /* renamed from: a */
        private final b f4333a;

        /* renamed from: b */
        int f4334b;

        a(b bVar) {
            this.f4333a = bVar;
        }

        /* renamed from: a */
        public void m3978a(int i2) {
            this.f4334b = i2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f4334b == ((a) obj).f4334b;
        }

        public int hashCode() {
            return this.f4334b;
        }

        @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1634m
        public void offer() {
            this.f4333a.m3918a((b) this);
        }

        public String toString() {
            return C1637p.m3975a(this.f4334b);
        }
    }

    /* compiled from: SizeStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.a0.p$b */
    static class b extends AbstractC1625d<a> {
        b() {
        }

        /* renamed from: a */
        public a m3979a(int i2) {
            a aVar = (a) super.m3919b();
            aVar.m3978a(i2);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.p118p.p119a0.AbstractC1625d
        /* renamed from: a, reason: avoid collision after fix types in other method */
        public a mo3916a() {
            return new a(this);
        }
    }

    C1637p() {
    }

    /* renamed from: d */
    private static String m3977d(Bitmap bitmap) {
        return m3975a(C1878l.m4995a(bitmap));
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: a */
    public void mo3911a(Bitmap bitmap) {
        a m3979a = this.f4330a.m3979a(C1878l.m4995a(bitmap));
        this.f4331b.m3933a(m3979a, bitmap);
        Integer num = (Integer) this.f4332c.get(Integer.valueOf(m3979a.f4334b));
        this.f4332c.put(Integer.valueOf(m3979a.f4334b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: b */
    public String mo3913b(int i2, int i3, Bitmap.Config config) {
        return m3975a(C1878l.m4993a(i2, i3, config));
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: c */
    public String mo3914c(Bitmap bitmap) {
        return m3977d(bitmap);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    @Nullable
    public Bitmap removeLast() {
        Bitmap m3931a = this.f4331b.m3931a();
        if (m3931a != null) {
            m3976a(Integer.valueOf(C1878l.m4995a(m3931a)));
        }
        return m3931a;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.f4331b + "\n  SortedSizes" + this.f4332c;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: b */
    public int mo3912b(Bitmap bitmap) {
        return C1878l.m4995a(bitmap);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    @Nullable
    /* renamed from: a */
    public Bitmap mo3910a(int i2, int i3, Bitmap.Config config) {
        int m4993a = C1878l.m4993a(i2, i3, config);
        a m3979a = this.f4330a.m3979a(m4993a);
        Integer ceilingKey = this.f4332c.ceilingKey(Integer.valueOf(m4993a));
        if (ceilingKey != null && ceilingKey.intValue() != m4993a && ceilingKey.intValue() <= m4993a * 8) {
            this.f4330a.m3918a((b) m3979a);
            m3979a = this.f4330a.m3979a(ceilingKey.intValue());
        }
        Bitmap m3932a = this.f4331b.m3932a((C1629h<a, Bitmap>) m3979a);
        if (m3932a != null) {
            m3932a.reconfigure(i2, i3, config);
            m3976a(ceilingKey);
        }
        return m3932a;
    }

    /* renamed from: a */
    private void m3976a(Integer num) {
        Integer num2 = (Integer) this.f4332c.get(num);
        if (num2.intValue() == 1) {
            this.f4332c.remove(num);
        } else {
            this.f4332c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    /* renamed from: a */
    static String m3975a(int i2) {
        return "[" + i2 + "]";
    }
}
