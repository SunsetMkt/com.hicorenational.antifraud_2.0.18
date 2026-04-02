package i;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Metadata.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@t0(version = "1.3")
@i.f2.f(allowedTargets = {i.f2.b.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@i.f2.e(i.f2.a.RUNTIME)
public @interface y {
    @i.q2.e(name = "bv")
    int[] bv() default {};

    @i.q2.e(name = "d1")
    String[] d1() default {};

    @i.q2.e(name = "d2")
    String[] d2() default {};

    @i.q2.e(name = "k")
    int k() default 1;

    @i.q2.e(name = "mv")
    int[] mv() default {};

    @i.q2.e(name = "pn")
    String pn() default "";

    @i.q2.e(name = "xi")
    int xi() default 0;

    @i.q2.e(name = "xs")
    String xs() default "";
}
