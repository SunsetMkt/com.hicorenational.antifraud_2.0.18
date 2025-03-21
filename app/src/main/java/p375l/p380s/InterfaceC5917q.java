package p375l.p380s;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Part.java */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: l.s.q */
/* loaded from: classes2.dex */
public @interface InterfaceC5917q {
    String encoding() default "binary";

    String value() default "";
}
