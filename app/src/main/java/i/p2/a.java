package i.p2;

import i.f2.b;
import i.f2.f;
import i.h0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: JsAnnotationsH.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@f(allowedTargets = {b.CLASS, b.FUNCTION, b.PROPERTY, b.CONSTRUCTOR, b.PROPERTY_GETTER, b.PROPERTY_SETTER})
@Retention(RetentionPolicy.RUNTIME)
@h0
@interface a {
    String name();
}
