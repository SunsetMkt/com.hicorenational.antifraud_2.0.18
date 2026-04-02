package i.k2.n.a;

import com.umeng.analytics.pro.bh;
import i.t0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@t0(version = "1.3")
@i.f2.f(allowedTargets = {i.f2.b.CLASS})
@Retention(RetentionPolicy.RUNTIME)
public @interface f {
    @i.q2.e(name = bh.aI)
    String c() default "";

    @i.q2.e(name = "f")
    String f() default "";

    @i.q2.e(name = bh.aF)
    int[] i() default {};

    @i.q2.e(name = "l")
    int[] l() default {};

    @i.q2.e(name = "m")
    String m() default "";

    @i.q2.e(name = "n")
    String[] n() default {};

    @i.q2.e(name = bh.aE)
    String[] s() default {};

    @i.q2.e(name = "v")
    int v() default 1;
}
