package p031c.p035b.p036a.p037a;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: AutoValue.java */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* renamed from: c.b.a.a.c */
/* loaded from: classes.dex */
public @interface InterfaceC0950c {

    /* compiled from: AutoValue.java */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    /* renamed from: c.b.a.a.c$a */
    public @interface a {
    }

    /* compiled from: AutoValue.java */
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    /* renamed from: c.b.a.a.c$b */
    public @interface b {
        Class<? extends Annotation>[] exclude() default {};
    }
}
