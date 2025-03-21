package p324i.p336c.p337a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Contract.java */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
/* renamed from: i.c.a.a */
/* loaded from: classes2.dex */
public @interface InterfaceC5813a {
    boolean pure() default false;

    String value() default "";
}
