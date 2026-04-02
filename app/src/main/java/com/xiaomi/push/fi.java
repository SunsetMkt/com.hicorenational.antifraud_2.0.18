package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class fi extends Exception {
    private fr a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fs f519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Throwable f520a;

    public fi() {
        this.a = null;
        this.f519a = null;
        this.f520a = null;
    }

    public Throwable a() {
        return this.f520a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        fr frVar;
        fs fsVar;
        String message = super.getMessage();
        return (message != null || (fsVar = this.f519a) == null) ? (message != null || (frVar = this.a) == null) ? message : frVar.toString() : fsVar.toString();
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
        fs fsVar = this.f519a;
        if (fsVar != null) {
            sb.append(fsVar);
        }
        fr frVar = this.a;
        if (frVar != null) {
            sb.append(frVar);
        }
        if (this.f520a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f520a);
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f520a != null) {
            printStream.println("Nested Exception: ");
            this.f520a.printStackTrace(printStream);
        }
    }

    public fi(String str) {
        super(str);
        this.a = null;
        this.f519a = null;
        this.f520a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f520a != null) {
            printWriter.println("Nested Exception: ");
            this.f520a.printStackTrace(printWriter);
        }
    }

    public fi(Throwable th) {
        this.a = null;
        this.f519a = null;
        this.f520a = null;
        this.f520a = th;
    }

    public fi(fr frVar) {
        this.a = null;
        this.f519a = null;
        this.f520a = null;
        this.a = frVar;
    }

    public fi(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f519a = null;
        this.f520a = null;
        this.f520a = th;
    }
}
