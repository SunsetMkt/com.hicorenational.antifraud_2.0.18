package i;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@i.f2.f(allowedTargets = {i.f2.b.CLASS, i.f2.b.ANNOTATION_CLASS, i.f2.b.PROPERTY, i.f2.b.FIELD, i.f2.b.LOCAL_VARIABLE, i.f2.b.VALUE_PARAMETER, i.f2.b.CONSTRUCTOR, i.f2.b.FUNCTION, i.f2.b.PROPERTY_GETTER, i.f2.b.PROPERTY_SETTER, i.f2.b.TYPE, i.f2.b.EXPRESSION, i.f2.b.FILE, i.f2.b.TYPEALIAS})
@Retention(RetentionPolicy.SOURCE)
@i.f2.e(i.f2.a.SOURCE)
public @interface y0 {
    String[] names();
}
