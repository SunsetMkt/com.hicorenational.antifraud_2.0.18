package i.q2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: JvmPlatformAnnotations.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@i.f2.f(allowedTargets = {i.f2.b.FUNCTION, i.f2.b.PROPERTY_GETTER, i.f2.b.PROPERTY_SETTER, i.f2.b.CONSTRUCTOR})
@Retention(RetentionPolicy.SOURCE)
@i.f2.e(i.f2.a.SOURCE)
public @interface p {
    Class<? extends Throwable>[] exceptionClasses();
}
