package i;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@i.f2.c
@i.f2.f(allowedTargets = {i.f2.b.CLASS, i.f2.b.PROPERTY, i.f2.b.FIELD, i.f2.b.CONSTRUCTOR, i.f2.b.FUNCTION, i.f2.b.PROPERTY_GETTER, i.f2.b.PROPERTY_SETTER, i.f2.b.TYPEALIAS})
@Documented
@Retention(RetentionPolicy.CLASS)
@i.f2.e(i.f2.a.BINARY)
public @interface t0 {
    String version();
}
