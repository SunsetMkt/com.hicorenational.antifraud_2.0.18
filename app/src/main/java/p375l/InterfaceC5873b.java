package p375l;

import java.io.IOException;
import okhttp3.Request;

/* compiled from: Call.java */
/* renamed from: l.b */
/* loaded from: classes2.dex */
public interface InterfaceC5873b<T> extends Cloneable {
    /* renamed from: a */
    void mo24747a(InterfaceC5875d<T> interfaceC5875d);

    void cancel();

    /* renamed from: clone */
    InterfaceC5873b<T> mo26864clone();

    C5884m<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();
}
