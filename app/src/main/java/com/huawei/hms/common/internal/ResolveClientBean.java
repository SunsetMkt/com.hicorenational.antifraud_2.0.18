package com.huawei.hms.common.internal;

/* loaded from: classes.dex */
public class ResolveClientBean {

    /* renamed from: a */
    private final int f7292a;

    /* renamed from: b */
    private final AnyClient f7293b;

    /* renamed from: c */
    private int f7294c;

    public ResolveClientBean(AnyClient anyClient, int i2) {
        this.f7293b = anyClient;
        this.f7292a = Objects.hashCode(anyClient);
        this.f7294c = i2;
    }

    public void clientReconnect() {
        this.f7293b.connect(this.f7294c, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResolveClientBean)) {
            return false;
        }
        return this.f7293b.equals(((ResolveClientBean) obj).f7293b);
    }

    public AnyClient getClient() {
        return this.f7293b;
    }

    public int hashCode() {
        return this.f7292a;
    }
}
