package i.q2.t;

/* JADX INFO: compiled from: PropertyReference0Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public class a1 extends z0 {
    private final String name;
    private final i.w2.f owner;
    private final String signature;

    public a1(i.w2.f fVar, String str, String str2) {
        this.owner = fVar;
        this.name = str;
        this.signature = str2;
    }

    @Override // i.w2.n
    public Object get() {
        return getGetter().call(new Object[0]);
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
