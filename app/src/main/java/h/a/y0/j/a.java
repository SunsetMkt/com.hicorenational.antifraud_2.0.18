package h.a.y0.j;

import h.a.i0;

/* JADX INFO: compiled from: AppendOnlyLinkedArrayList.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<T> {
    final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f12031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object[] f12032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f12033d;

    /* JADX INFO: renamed from: h.a.y0.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppendOnlyLinkedArrayList.java */
    public interface InterfaceC0233a<T> extends h.a.x0.r<T> {
        @Override // h.a.x0.r
        boolean test(T t);
    }

    public a(int i2) {
        this.a = i2;
        this.f12031b = new Object[i2 + 1];
        this.f12032c = this.f12031b;
    }

    public void a(T t) {
        int i2 = this.a;
        int i3 = this.f12033d;
        if (i3 == i2) {
            Object[] objArr = new Object[i2 + 1];
            this.f12032c[i2] = objArr;
            this.f12032c = objArr;
            i3 = 0;
        }
        this.f12032c[i3] = t;
        this.f12033d = i3 + 1;
    }

    public void b(T t) {
        this.f12031b[0] = t;
    }

    public void a(InterfaceC0233a<? super T> interfaceC0233a) {
        int i2;
        int i3 = this.a;
        for (Object[] objArr = this.f12031b; objArr != null; objArr = (Object[]) objArr[i3]) {
            while (i2 < i3) {
                Object obj = objArr[i2];
                i2 = (obj == null || interfaceC0233a.test(obj)) ? 0 : i2 + 1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean a(j.d.c<? super U> cVar) {
        Object[] objArr = this.f12031b;
        int i2 = this.a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    break;
                }
                if (q.acceptFull(objArr2, cVar)) {
                    return true;
                }
            }
            objArr = objArr[i2];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean a(i0<? super U> i0Var) {
        Object[] objArr = this.f12031b;
        int i2 = this.a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    break;
                }
                if (q.acceptFull(objArr2, i0Var)) {
                    return true;
                }
            }
            objArr = objArr[i2];
        }
    }

    public <S> void a(S s, h.a.x0.d<? super S, ? super T> dVar) throws Exception {
        Object[] objArr = this.f12031b;
        int i2 = this.a;
        while (true) {
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = objArr[i3];
                if (obj == null || dVar.a(s, obj)) {
                    return;
                }
            }
            objArr = (Object[]) objArr[i2];
        }
    }
}
