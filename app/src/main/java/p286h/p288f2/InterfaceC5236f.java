package p286h.p288f2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Annotations.kt */
@Target({ElementType.ANNOTATION_TYPE})
@InterfaceC5233c
@InterfaceC5236f(allowedTargets = {EnumC5232b.ANNOTATION_CLASS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: h.f2.f */
/* loaded from: classes2.dex */
public @interface InterfaceC5236f {
    EnumC5232b[] allowedTargets();
}
