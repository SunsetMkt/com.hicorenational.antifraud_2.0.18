package com.bumptech.glide.load.p123q.p124y;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p123q.C1688g;
import com.bumptech.glide.load.p123q.C1694m;
import com.bumptech.glide.load.p123q.InterfaceC1689h;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseGlideUrlLoader.java */
/* renamed from: com.bumptech.glide.load.q.y.a */
/* loaded from: classes.dex */
public abstract class AbstractC1706a<Model> implements InterfaceC1695n<Model, InputStream> {

    /* renamed from: a */
    private final InterfaceC1695n<C1688g, InputStream> f4771a;

    /* renamed from: b */
    @Nullable
    private final C1694m<Model, C1688g> f4772b;

    protected AbstractC1706a(InterfaceC1695n<C1688g, InputStream> interfaceC1695n) {
        this(interfaceC1695n, null);
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    @Nullable
    /* renamed from: a */
    public InterfaceC1695n.a<InputStream> mo4217a(@NonNull Model model, int i2, int i3, @NonNull C1596j c1596j) {
        C1694m<Model, C1688g> c1694m = this.f4772b;
        C1688g m4251a = c1694m != null ? c1694m.m4251a(model, i2, i3) : null;
        if (m4251a == null) {
            String m4295d = m4295d(model, i2, i3, c1596j);
            if (TextUtils.isEmpty(m4295d)) {
                return null;
            }
            C1688g c1688g = new C1688g(m4295d, m4294c(model, i2, i3, c1596j));
            C1694m<Model, C1688g> c1694m2 = this.f4772b;
            if (c1694m2 != null) {
                c1694m2.m4253a(model, i2, i3, c1688g);
            }
            m4251a = c1688g;
        }
        List<String> m4293b = m4293b(model, i2, i3, c1596j);
        InterfaceC1695n.a<InputStream> mo4217a = this.f4771a.mo4217a(m4251a, i2, i3, c1596j);
        return (mo4217a == null || m4293b.isEmpty()) ? mo4217a : new InterfaceC1695n.a<>(mo4217a.f4726a, m4292a((Collection<String>) m4293b), mo4217a.f4728c);
    }

    /* renamed from: b */
    protected List<String> m4293b(Model model, int i2, int i3, C1596j c1596j) {
        return Collections.emptyList();
    }

    @Nullable
    /* renamed from: c */
    protected InterfaceC1689h m4294c(Model model, int i2, int i3, C1596j c1596j) {
        return InterfaceC1689h.f4704b;
    }

    /* renamed from: d */
    protected abstract String m4295d(Model model, int i2, int i3, C1596j c1596j);

    protected AbstractC1706a(InterfaceC1695n<C1688g, InputStream> interfaceC1695n, @Nullable C1694m<Model, C1688g> c1694m) {
        this.f4771a = interfaceC1695n;
        this.f4772b = c1694m;
    }

    /* renamed from: a */
    private static List<InterfaceC1593g> m4292a(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new C1688g(it.next()));
        }
        return arrayList;
    }
}
