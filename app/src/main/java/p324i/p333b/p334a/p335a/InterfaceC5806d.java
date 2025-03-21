package p324i.p333b.p334a.p335a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p324i.p336c.p337a.InterfaceC5815c;

/* compiled from: Language.java */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
/* renamed from: i.b.a.a.d */
/* loaded from: classes2.dex */
public @interface InterfaceC5806d {
    @InterfaceC5815c
    String prefix() default "";

    @InterfaceC5815c
    String suffix() default "";

    @InterfaceC5815c
    String value();
}
