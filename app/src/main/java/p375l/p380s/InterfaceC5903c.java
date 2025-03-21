package p375l.p380s;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Field.java */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: l.s.c */
/* loaded from: classes2.dex */
public @interface InterfaceC5903c {
    boolean encoded() default false;

    String value();
}
