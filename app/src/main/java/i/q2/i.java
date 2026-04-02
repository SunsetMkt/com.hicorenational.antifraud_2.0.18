package i.q2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: JvmPlatformAnnotations.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD})
@i.f2.c
@i.f2.f(allowedTargets = {i.f2.b.CLASS, i.f2.b.FUNCTION, i.f2.b.PROPERTY, i.f2.b.TYPE})
@Documented
@Retention(RetentionPolicy.CLASS)
@i.f2.e(i.f2.a.BINARY)
public @interface i {
    boolean suppress() default true;
}
