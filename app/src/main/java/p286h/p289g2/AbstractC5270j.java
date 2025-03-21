package p286h.p289g2;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.analytics.pro.C3351bh;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: AbstractSet.kt */
@InterfaceC5610t0(version = "1.1")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b'\u0018\u0000 \u000b*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, m23546d2 = {"Lkotlin/collections/AbstractSet;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractCollection;", "", "()V", "equals", "", DispatchConstants.OTHER, "", "hashCode", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.g2.j */
/* loaded from: classes2.dex */
public abstract class AbstractC5270j<E> extends AbstractC5240a<E> implements Set<E>, InterfaceC5569a {

    /* renamed from: a */
    public static final a f20128a = new a(null);

    /* compiled from: AbstractSet.kt */
    /* renamed from: h.g2.j$a */
    public static final class a {
        private a() {
        }

        /* renamed from: a */
        public final int m19964a(@InterfaceC5816d Collection<?> collection) {
            C5544i0.m22546f(collection, C3351bh.f11584aI);
            Iterator<?> it = collection.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                i2 += next != null ? next.hashCode() : 0;
            }
            return i2;
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }

        /* renamed from: a */
        public final boolean m19965a(@InterfaceC5816d Set<?> set, @InterfaceC5816d Set<?> set2) {
            C5544i0.m22546f(set, C3351bh.f11584aI);
            C5544i0.m22546f(set2, DispatchConstants.OTHER);
            if (set.size() != set2.size()) {
                return false;
            }
            return set.containsAll(set2);
        }
    }

    protected AbstractC5270j() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            return f20128a.m19965a(this, (Set) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return f20128a.m19964a(this);
    }

    @Override // p286h.p289g2.AbstractC5240a, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
