package i.q2.t;

/* JADX INFO: compiled from: PropertyReference1Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public class c1 extends b1 {
    private final String name;
    private final i.w2.f owner;
    private final String signature;

    public c1(i.w2.f fVar, String str, String str2) {
        this.owner = fVar;
        this.name = str;
        this.signature = str2;
    }

    @Override // i.w2.o
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    @Override // i.q2.t.p, i.w2.b
    public String getName() {
        return this.name;
    }

    @Override // i.q2.t.p
    public i.w2.f getOwner() {
        return this.owner;
    }

    @Override // i.q2.t.p
    public String getSignature() {
        return this.signature;
    }
}
