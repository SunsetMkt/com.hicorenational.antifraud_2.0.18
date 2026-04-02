package i.m2;

import i.t0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.f2.d
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@t0(version = "1.2")
@i.f2.f(allowedTargets = {i.f2.b.CLASS, i.f2.b.FUNCTION, i.f2.b.PROPERTY, i.f2.b.CONSTRUCTOR, i.f2.b.TYPEALIAS})
@Retention(RetentionPolicy.SOURCE)
@i.f2.e(i.f2.a.SOURCE)
public @interface o {
    int errorCode() default -1;

    i.d level() default i.d.ERROR;

    String message() default "";

    String version();

    p versionKind() default p.LANGUAGE_VERSION;
}
