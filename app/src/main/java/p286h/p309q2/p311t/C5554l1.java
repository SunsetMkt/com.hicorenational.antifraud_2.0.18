package p286h.p309q2.p311t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: SpreadBuilder.java */
/* renamed from: h.q2.t.l1 */
/* loaded from: classes2.dex */
public class C5554l1 {

    /* renamed from: a */
    private final ArrayList<Object> f20393a;

    public C5554l1(int i2) {
        this.f20393a = new ArrayList<>(i2);
    }

    /* renamed from: a */
    public int m22575a() {
        return this.f20393a.size();
    }

    /* renamed from: b */
    public void m22578b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f20393a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f20393a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f20393a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f20393a.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.f20393a.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    /* renamed from: a */
    public void m22576a(Object obj) {
        this.f20393a.add(obj);
    }

    /* renamed from: a */
    public Object[] m22577a(Object[] objArr) {
        return this.f20393a.toArray(objArr);
    }
}
