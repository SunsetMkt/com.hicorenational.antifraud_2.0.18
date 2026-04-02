package j.b.a.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Flow.java */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface a {

    @j.c.a.c
    public static final String o = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    @j.c.a.c
    public static final String p = "this";

    @j.c.a.c
    public static final String q = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    @j.c.a.c
    public static final String r = "The return value of this method";

    @j.c.a.c
    public static final String s = "this";

    String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    boolean sourceIsContainer() default false;

    String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    boolean targetIsContainer() default false;
}
