package p251g.p252a.p265v0;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import p251g.p252a.p263t0.InterfaceC4546f;

/* compiled from: CompositeException.java */
/* renamed from: g.a.v0.a */
/* loaded from: classes2.dex */
public final class C4560a extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    /* compiled from: CompositeException.java */
    /* renamed from: g.a.v0.a$a */
    static final class a extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        a() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return MESSAGE;
        }
    }

    /* compiled from: CompositeException.java */
    /* renamed from: g.a.v0.a$b */
    static abstract class b {
        b() {
        }

        /* renamed from: a */
        abstract void mo18197a(Object obj);
    }

    /* compiled from: CompositeException.java */
    /* renamed from: g.a.v0.a$c */
    static final class c extends b {

        /* renamed from: a */
        private final PrintStream f17470a;

        c(PrintStream printStream) {
            this.f17470a = printStream;
        }

        @Override // p251g.p252a.p265v0.C4560a.b
        /* renamed from: a */
        void mo18197a(Object obj) {
            this.f17470a.println(obj);
        }
    }

    /* compiled from: CompositeException.java */
    /* renamed from: g.a.v0.a$d */
    static final class d extends b {

        /* renamed from: a */
        private final PrintWriter f17471a;

        d(PrintWriter printWriter) {
            this.f17471a = printWriter;
        }

        @Override // p251g.p252a.p265v0.C4560a.b
        /* renamed from: a */
        void mo18197a(Object obj) {
            this.f17471a.println(obj);
        }
    }

    public C4560a(@InterfaceC4546f Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    /* renamed from: a */
    private void m18194a(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i2 = 1;
        for (Throwable th : this.exceptions) {
            sb.append("  ComposedException ");
            sb.append(i2);
            sb.append(" :\n");
            m18195a(sb, th, "\t");
            i2++;
        }
        bVar.mo18197a(sb.toString());
    }

    /* renamed from: b */
    private Throwable m18196b(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || this.cause == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }

    @Override // java.lang.Throwable
    @InterfaceC4546f
    public synchronized Throwable getCause() {
        if (this.cause == null) {
            a aVar = new a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.exceptions.iterator();
            Throwable th = aVar;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th2 : m18193a(next)) {
                        if (hashSet.contains(th2)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th2);
                        }
                    }
                    try {
                        th.initCause(next);
                    } catch (Throwable unused) {
                    }
                    th = m18196b(th);
                }
            }
            this.cause = aVar;
        }
        return this.cause;
    }

    @InterfaceC4546f
    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    @InterfaceC4546f
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public int size() {
        return this.exceptions.size();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        m18194a(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        m18194a(new d(printWriter));
    }

    public C4560a(@InterfaceC4546f Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof C4560a) {
                    linkedHashSet.addAll(((C4560a) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            this.exceptions = Collections.unmodifiableList(arrayList);
            this.message = this.exceptions.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    /* renamed from: a */
    private void m18195a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            m18195a(sb, th.getCause(), "");
        }
    }

    /* renamed from: a */
    private List<Throwable> m18193a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }
}
