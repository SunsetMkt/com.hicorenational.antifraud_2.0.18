package j.a.a.a.m.k;

import j.a.a.a.i;

/* JADX INFO: compiled from: BeiderMorseEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements i {
    private e a = new e(d.GENERIC, h.APPROX, true);

    @Override // j.a.a.a.i
    public String a(String str) throws j.a.a.a.g {
        if (str == null) {
            return null;
        }
        return this.a.a(str);
    }

    public h b() {
        return this.a.c();
    }

    public boolean c() {
        return this.a.d();
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws j.a.a.a.g {
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new j.a.a.a.g("BeiderMorseEncoder encode parameter is not of type String");
    }

    public d a() {
        return this.a.b();
    }

    public void a(boolean z) {
        this.a = new e(this.a.b(), this.a.c(), z);
    }

    public void a(d dVar) {
        this.a = new e(dVar, this.a.c(), this.a.d());
    }

    public void a(h hVar) {
        this.a = new e(this.a.b(), hVar, this.a.d());
    }
}
