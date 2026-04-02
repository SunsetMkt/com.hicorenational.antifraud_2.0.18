package i.q2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: PurelyImplements.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@i.f2.c
@i.f2.f(allowedTargets = {i.f2.b.CLASS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@i.f2.e(i.f2.a.RUNTIME)
public @interface m {
    String value();
}
