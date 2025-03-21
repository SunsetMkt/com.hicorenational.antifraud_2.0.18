package p324i.p333b.p334a.p335a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: RegExp.java */
@InterfaceC5806d("RegExp")
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
/* renamed from: i.b.a.a.i */
/* loaded from: classes2.dex */
public @interface InterfaceC5811i {
    String prefix() default "";

    String suffix() default "";
}
