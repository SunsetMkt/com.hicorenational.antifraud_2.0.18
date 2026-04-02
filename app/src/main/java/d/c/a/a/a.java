package d.c.a.a;

import com.hihonor.cloudservice.support.api.client.Status;

/* JADX INFO: compiled from: ApiException.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Exception {
    protected final Status a;

    public a(Status status) {
        super(status.b());
        this.a = status;
    }

    public int getStatusCode() {
        return this.a.c();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.a.d();
    }
}
