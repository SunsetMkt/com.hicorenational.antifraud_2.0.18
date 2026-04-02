package i;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Experimental.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@i.f2.f(allowedTargets = {i.f2.b.CLASS, i.f2.b.PROPERTY, i.f2.b.CONSTRUCTOR, i.f2.b.FUNCTION, i.f2.b.TYPEALIAS})
@Retention(RetentionPolicy.CLASS)
@i.f2.e(i.f2.a.BINARY)
public @interface d2 {
    Class<? extends Annotation>[] markerClass();
}
