package i.q2;

/* JADX INFO: compiled from: KotlinReflectionNotSupportedError.kt */
/* JADX INFO: loaded from: classes2.dex */
public class l extends Error {
    public l() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public l(@j.c.a.e String str) {
        super(str);
    }

    public l(@j.c.a.e String str, @j.c.a.e Throwable th) {
        super(str, th);
    }

    public l(@j.c.a.e Throwable th) {
        super(th);
    }
}
