package p031c.p075c.p076a.p077a;

import com.hihonor.cloudservice.support.api.client.Status;

/* compiled from: ApiException.java */
/* renamed from: c.c.a.a.a */
/* loaded from: classes.dex */
public class C1182a extends Exception {

    /* renamed from: a */
    protected final Status f2469a;

    public C1182a(Status status) {
        super(status.m6012b());
        this.f2469a = status;
    }

    public int getStatusCode() {
        return this.f2469a.m6013c();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.f2469a.m6014d();
    }
}
