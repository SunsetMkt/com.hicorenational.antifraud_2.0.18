package i.q2.t;

/* JADX INFO: compiled from: MutablePropertyReference2Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public class v0 extends u0 {
    private final String name;
    private final i.w2.f owner;
    private final String signature;

    public v0(i.w2.f fVar, String str, String str2) {
        this.owner = fVar;
        this.name = str;
        this.signature = str2;
    }

    @Override // i.w2.p
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
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

    @Override // i.w2.k
    public void set(Object obj, Object obj2, Object obj3) {
        getSetter().call(obj, obj2, obj3);
    }
}
