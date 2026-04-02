package i.f2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.ANNOTATION_TYPE})
@c
@f(allowedTargets = {b.ANNOTATION_CLASS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface f {
    b[] allowedTargets();
}
