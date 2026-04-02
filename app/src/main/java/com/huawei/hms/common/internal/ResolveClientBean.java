package com.huawei.hms.common.internal;

/* JADX INFO: loaded from: classes.dex */
public class ResolveClientBean {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnyClient f4570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4571c;

    public ResolveClientBean(AnyClient anyClient, int i2) {
        this.f4570b = anyClient;
        this.a = Objects.hashCode(anyClient);
        this.f4571c = i2;
    }

    public void clientReconnect() {
        this.f4570b.connect(this.f4571c, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResolveClientBean)) {
            return false;
        }
        return this.f4570b.equals(((ResolveClientBean) obj).f4570b);
    }

    public AnyClient getClient() {
        return this.f4570b;
    }

    public int hashCode() {
        return this.a;
    }
}
