package com.bumptech.glide.load.p118p.p119a0;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C1878l;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: SizeConfigStrategy.java */
@RequiresApi(19)
/* renamed from: com.bumptech.glide.load.p.a0.o */
/* loaded from: classes.dex */
public class C1636o implements InterfaceC1633l {

    /* renamed from: d */
    private static final int f4316d = 8;

    /* renamed from: e */
    private static final Bitmap.Config[] f4317e;

    /* renamed from: f */
    private static final Bitmap.Config[] f4318f;

    /* renamed from: g */
    private static final Bitmap.Config[] f4319g;

    /* renamed from: h */
    private static final Bitmap.Config[] f4320h;

    /* renamed from: i */
    private static final Bitmap.Config[] f4321i;

    /* renamed from: a */
    private final c f4322a = new c();

    /* renamed from: b */
    private final C1629h<b, Bitmap> f4323b = new C1629h<>();

    /* renamed from: c */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f4324c = new HashMap();

    /* compiled from: SizeConfigStrategy.java */
    /* renamed from: com.bumptech.glide.load.p.a0.o$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f4325a = new int[Bitmap.Config.values().length];

        static {
            try {
                f4325a[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4325a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4325a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4325a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.a0.o$c */
    static class c extends AbstractC1625d<b> {
        c() {
        }

        /* renamed from: a */
        public b m3974a(int i2, Bitmap.Config config) {
            b m3919b = m3919b();
            m3919b.m3973a(i2, config);
            return m3919b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.p118p.p119a0.AbstractC1625d
        /* renamed from: a, reason: avoid collision after fix types in other method */
        public b mo3916a() {
            return new b(this);
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, configArr.length + 1);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f4317e = configArr;
        f4318f = f4317e;
        f4319g = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f4320h = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f4321i = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    /* renamed from: b */
    private NavigableMap<Integer, Integer> m3972b(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f4324c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f4324c.put(config, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: a */
    public void mo3911a(Bitmap bitmap) {
        b m3974a = this.f4322a.m3974a(C1878l.m4995a(bitmap), bitmap.getConfig());
        this.f4323b.m3933a(m3974a, bitmap);
        NavigableMap<Integer, Integer> m3972b = m3972b(bitmap.getConfig());
        Integer num = (Integer) m3972b.get(Integer.valueOf(m3974a.f4327b));
        m3972b.put(Integer.valueOf(m3974a.f4327b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: c */
    public String mo3914c(Bitmap bitmap) {
        return m3971b(C1878l.m4995a(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    @Nullable
    public Bitmap removeLast() {
        Bitmap m3931a = this.f4323b.m3931a();
        if (m3931a != null) {
            m3969a(Integer.valueOf(C1878l.m4995a(m3931a)), m3931a);
        }
        return m3931a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f4323b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f4324c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f4324c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    /* compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.a0.o$b */
    static final class b implements InterfaceC1634m {

        /* renamed from: a */
        private final c f4326a;

        /* renamed from: b */
        int f4327b;

        /* renamed from: c */
        private Bitmap.Config f4328c;

        public b(c cVar) {
            this.f4326a = cVar;
        }

        /* renamed from: a */
        public void m3973a(int i2, Bitmap.Config config) {
            this.f4327b = i2;
            this.f4328c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f4327b == bVar.f4327b && C1878l.m5009b(this.f4328c, bVar.f4328c);
        }

        public int hashCode() {
            int i2 = this.f4327b * 31;
            Bitmap.Config config = this.f4328c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1634m
        public void offer() {
            this.f4326a.m3918a(this);
        }

        public String toString() {
            return C1636o.m3971b(this.f4327b, this.f4328c);
        }

        @VisibleForTesting
        b(c cVar, int i2, Bitmap.Config config) {
            this(cVar);
            m3973a(i2, config);
        }
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: b */
    public String mo3913b(int i2, int i3, Bitmap.Config config) {
        return m3971b(C1878l.m4993a(i2, i3, config), config);
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    /* renamed from: b */
    public int mo3912b(Bitmap bitmap) {
        return C1878l.m4995a(bitmap);
    }

    /* renamed from: b */
    static String m3971b(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    @Override // com.bumptech.glide.load.p118p.p119a0.InterfaceC1633l
    @Nullable
    /* renamed from: a */
    public Bitmap mo3910a(int i2, int i3, Bitmap.Config config) {
        b m3968a = m3968a(C1878l.m4993a(i2, i3, config), config);
        Bitmap m3932a = this.f4323b.m3932a((C1629h<b, Bitmap>) m3968a);
        if (m3932a != null) {
            m3969a(Integer.valueOf(m3968a.f4327b), m3932a);
            m3932a.reconfigure(i2, i3, config);
        }
        return m3932a;
    }

    /* renamed from: a */
    private b m3968a(int i2, Bitmap.Config config) {
        b m3974a = this.f4322a.m3974a(i2, config);
        for (Bitmap.Config config2 : m3970a(config)) {
            Integer ceilingKey = m3972b(config2).ceilingKey(Integer.valueOf(i2));
            if (ceilingKey != null && ceilingKey.intValue() <= i2 * 8) {
                if (ceilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return m3974a;
                        }
                    } else if (config2.equals(config)) {
                        return m3974a;
                    }
                }
                this.f4322a.m3918a(m3974a);
                return this.f4322a.m3974a(ceilingKey.intValue(), config2);
            }
        }
        return m3974a;
    }

    /* renamed from: a */
    private void m3969a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> m3972b = m3972b(bitmap.getConfig());
        Integer num2 = (Integer) m3972b.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                m3972b.remove(num);
                return;
            } else {
                m3972b.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + mo3914c(bitmap) + ", this: " + this);
    }

    /* renamed from: a */
    private static Bitmap.Config[] m3970a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f4318f;
        }
        int i2 = a.f4325a[config.ordinal()];
        if (i2 == 1) {
            return f4317e;
        }
        if (i2 == 2) {
            return f4319g;
        }
        if (i2 != 3) {
            return i2 != 4 ? new Bitmap.Config[]{config} : f4321i;
        }
        return f4320h;
    }
}
