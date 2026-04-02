package m;

import java.io.IOException;
import okhttp3.Request;

/* JADX INFO: compiled from: Call.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b<T> extends Cloneable {
    void a(d<T> dVar);

    void cancel();

    /* JADX INFO: renamed from: clone */
    b<T> mo785clone();

    m<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();
}
