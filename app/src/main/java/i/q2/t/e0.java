package i.q2.t;

/* JADX INFO: compiled from: FunctionReferenceImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class e0 extends d0 {
    private final String name;
    private final i.w2.f owner;
    private final String signature;

    public e0(int i2, i.w2.f fVar, String str, String str2) {
        super(i2);
        this.owner = fVar;
        this.name = str;
        this.signature = str2;
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
