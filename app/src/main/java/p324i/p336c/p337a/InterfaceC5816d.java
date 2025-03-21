package p324i.p336c.p337a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: NotNull.java */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
@Documented
@Retention(RetentionPolicy.CLASS)
/* renamed from: i.c.a.d */
/* loaded from: classes2.dex */
public @interface InterfaceC5816d {
    String value() default "";
}
