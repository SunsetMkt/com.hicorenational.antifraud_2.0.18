package com.bumptech.glide.load.p118p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.InterfaceC1593g;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: GlideException.java */
/* renamed from: com.bumptech.glide.load.p.q */
/* loaded from: classes.dex */
public final class C1672q extends Exception {

    /* renamed from: a */
    private static final StackTraceElement[] f4618a = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private EnumC1587a dataSource;
    private String detailMessage;

    @Nullable
    private Exception exception;
    private InterfaceC1593g key;

    public C1672q(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    /* renamed from: a */
    private void m4191a(Throwable th, List<Throwable> list) {
        if (!(th instanceof C1672q)) {
            list.add(th);
            return;
        }
        Iterator<Throwable> it = ((C1672q) th).getCauses().iterator();
        while (it.hasNext()) {
            m4191a(it.next(), list);
        }
    }

    /* renamed from: b */
    private static void m4193b(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof C1672q) {
                ((C1672q) th).m4189a(appendable);
            } else {
                m4190a(th, appendable);
            }
            i2 = i3;
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        sb.append(this.dataClass != null ? ", " + this.dataClass : "");
        sb.append(this.dataSource != null ? ", " + this.dataSource : "");
        sb.append(this.key != null ? ", " + this.key : "");
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            sb.append(" causes:");
        }
        for (Throwable th : rootCauses) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Nullable
    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        m4191a(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            sb.toString();
            rootCauses.get(i2);
            i2 = i3;
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    void setLoggingDetails(InterfaceC1593g interfaceC1593g, EnumC1587a enumC1587a) {
        setLoggingDetails(interfaceC1593g, enumC1587a, null);
    }

    public void setOrigin(@Nullable Exception exc) {
        this.exception = exc;
    }

    public C1672q(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        m4189a(printStream);
    }

    void setLoggingDetails(InterfaceC1593g interfaceC1593g, EnumC1587a enumC1587a, Class<?> cls) {
        this.key = interfaceC1593g;
        this.dataSource = enumC1587a;
        this.dataClass = cls;
    }

    public C1672q(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(f4618a);
        this.causes = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        m4189a(printWriter);
    }

    /* compiled from: GlideException.java */
    /* renamed from: com.bumptech.glide.load.p.q$a */
    private static final class a implements Appendable {

        /* renamed from: c */
        private static final String f4619c = "";

        /* renamed from: d */
        private static final String f4620d = "  ";

        /* renamed from: a */
        private final Appendable f4621a;

        /* renamed from: b */
        private boolean f4622b = true;

        a(Appendable appendable) {
            this.f4621a = appendable;
        }

        @NonNull
        /* renamed from: a */
        private CharSequence m4194a(@Nullable CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c2) throws IOException {
            if (this.f4622b) {
                this.f4622b = false;
                this.f4621a.append(f4620d);
            }
            this.f4622b = c2 == '\n';
            this.f4621a.append(c2);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence) throws IOException {
            CharSequence m4194a = m4194a(charSequence);
            return append(m4194a, 0, m4194a.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence, int i2, int i3) throws IOException {
            CharSequence m4194a = m4194a(charSequence);
            boolean z = false;
            if (this.f4622b) {
                this.f4622b = false;
                this.f4621a.append(f4620d);
            }
            if (m4194a.length() > 0 && m4194a.charAt(i3 - 1) == '\n') {
                z = true;
            }
            this.f4622b = z;
            this.f4621a.append(m4194a, i2, i3);
            return this;
        }
    }

    /* renamed from: a */
    private void m4189a(Appendable appendable) {
        m4190a(this, appendable);
        m4192a(getCauses(), new a(appendable));
    }

    /* renamed from: a */
    private static void m4190a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    /* renamed from: a */
    private static void m4192a(List<Throwable> list, Appendable appendable) {
        try {
            m4193b(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
