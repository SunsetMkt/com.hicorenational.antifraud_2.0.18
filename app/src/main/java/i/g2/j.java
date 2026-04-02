package i.g2;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.analytics.pro.bh;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: AbstractSet.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.t0(version = "1.1")
@i.y(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b'\u0018\u0000 \u000b*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u000bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"Lkotlin/collections/AbstractSet;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractCollection;", "", "()V", "equals", "", DispatchConstants.OTHER, "", "hashCode", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public abstract class j<E> extends i.g2.a<E> implements Set<E>, i.q2.t.q1.a {
    public static final a a = new a(null);

    /* JADX INFO: compiled from: AbstractSet.kt */
    public static final class a {
        private a() {
        }

        public final int a(@j.c.a.d Collection<?> collection) {
            i.q2.t.i0.f(collection, bh.aI);
            Iterator<?> it = collection.iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode += next != null ? next.hashCode() : 0;
            }
            return iHashCode;
        }

        public /* synthetic */ a(i.q2.t.v vVar) {
            this();
        }

        public final boolean a(@j.c.a.d Set<?> set, @j.c.a.d Set<?> set2) {
            i.q2.t.i0.f(set, bh.aI);
            i.q2.t.i0.f(set2, DispatchConstants.OTHER);
            if (set.size() != set2.size()) {
                return false;
            }
            return set.containsAll(set2);
        }
    }

    protected j() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@j.c.a.e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            return a.a(this, (Set) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return a.a(this);
    }

    @Override // i.g2.a, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
