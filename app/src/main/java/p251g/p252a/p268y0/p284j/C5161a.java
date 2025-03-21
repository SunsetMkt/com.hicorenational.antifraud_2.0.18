package p251g.p252a.p268y0.p284j;

import p251g.p252a.p267x0.InterfaceC4573d;
import p251g.p252a.p267x0.InterfaceC4587r;

/* compiled from: AppendOnlyLinkedArrayList.java */
/* renamed from: g.a.y0.j.a */
/* loaded from: classes2.dex */
public class C5161a<T> {

    /* renamed from: a */
    final int f20022a;

    /* renamed from: b */
    final Object[] f20023b;

    /* renamed from: c */
    Object[] f20024c;

    /* renamed from: d */
    int f20025d;

    /* compiled from: AppendOnlyLinkedArrayList.java */
    /* renamed from: g.a.y0.j.a$a */
    public interface a<T> extends InterfaceC4587r<T> {
        @Override // p251g.p252a.p267x0.InterfaceC4587r
        boolean test(T t);
    }

    public C5161a(int i2) {
        this.f20022a = i2;
        this.f20023b = new Object[i2 + 1];
        this.f20024c = this.f20023b;
    }

    /* renamed from: a */
    public void m18601a(T t) {
        int i2 = this.f20022a;
        int i3 = this.f20025d;
        if (i3 == i2) {
            Object[] objArr = new Object[i2 + 1];
            this.f20024c[i2] = objArr;
            this.f20024c = objArr;
            i3 = 0;
        }
        this.f20024c[i3] = t;
        this.f20025d = i3 + 1;
    }

    /* renamed from: b */
    public void m18605b(T t) {
        this.f20023b[0] = t;
    }

    /* renamed from: a */
    public void m18600a(a<? super T> aVar) {
        int i2;
        int i3 = this.f20022a;
        for (Object[] objArr = this.f20023b; objArr != null; objArr = (Object[]) objArr[i3]) {
            while (i2 < i3) {
                Object obj = objArr[i2];
                i2 = (obj == null || aVar.test(obj)) ? 0 : i2 + 1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        continue;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean m18604a(p324i.p338d.InterfaceC5822c<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f20023b
            int r1 = r4.f20022a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = p251g.p252a.p268y0.p284j.EnumC5177q.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p284j.C5161a.m18604a(i.d.c):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        continue;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean m18603a(p251g.p252a.InterfaceC4514i0<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f20023b
            int r1 = r4.f20022a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = p251g.p252a.p268y0.p284j.EnumC5177q.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p251g.p252a.p268y0.p284j.C5161a.m18603a(g.a.i0):boolean");
    }

    /* renamed from: a */
    public <S> void m18602a(S s, InterfaceC4573d<? super S, ? super T> interfaceC4573d) throws Exception {
        Object[] objArr = this.f20023b;
        int i2 = this.f20022a;
        while (true) {
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = objArr[i3];
                if (obj == null || interfaceC4573d.mo18210a(s, obj)) {
                    return;
                }
            }
            objArr = (Object[]) objArr[i2];
        }
    }
}
