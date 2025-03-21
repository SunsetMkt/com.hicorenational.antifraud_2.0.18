package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: com.xiaomi.push.fi */
/* loaded from: classes2.dex */
public class C4215fi extends Exception {

    /* renamed from: a */
    private C4224fr f15314a;

    /* renamed from: a */
    private C4225fs f15315a;

    /* renamed from: a */
    private Throwable f15316a;

    public C4215fi() {
        this.f15314a = null;
        this.f15315a = null;
        this.f15316a = null;
    }

    /* renamed from: a */
    public Throwable m14814a() {
        return this.f15316a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        C4224fr c4224fr;
        C4225fs c4225fs;
        String message = super.getMessage();
        return (message != null || (c4225fs = this.f15315a) == null) ? (message != null || (c4224fr = this.f15314a) == null) ? message : c4224fr.toString() : c4225fs.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        C4225fs c4225fs = this.f15315a;
        if (c4225fs != null) {
            sb.append(c4225fs);
        }
        C4224fr c4224fr = this.f15314a;
        if (c4224fr != null) {
            sb.append(c4224fr);
        }
        if (this.f15316a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f15316a);
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f15316a != null) {
            printStream.println("Nested Exception: ");
            this.f15316a.printStackTrace(printStream);
        }
    }

    public C4215fi(String str) {
        super(str);
        this.f15314a = null;
        this.f15315a = null;
        this.f15316a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f15316a != null) {
            printWriter.println("Nested Exception: ");
            this.f15316a.printStackTrace(printWriter);
        }
    }

    public C4215fi(Throwable th) {
        this.f15314a = null;
        this.f15315a = null;
        this.f15316a = null;
        this.f15316a = th;
    }

    public C4215fi(C4224fr c4224fr) {
        this.f15314a = null;
        this.f15315a = null;
        this.f15316a = null;
        this.f15314a = c4224fr;
    }

    public C4215fi(String str, Throwable th) {
        super(str);
        this.f15314a = null;
        this.f15315a = null;
        this.f15316a = null;
        this.f15316a = th;
    }
}
