package butterknife;

import androidx.annotation.IdRes;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p000a.p001a.p014u.C0052a;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(defaultReturn = C0052a.f158j, name = "onLongClick", parameters = {"android.view.View"}, returnType = "boolean")}, setter = "setOnLongClickListener", targetType = "android.view.View", type = "android.view.View.OnLongClickListener")
/* loaded from: classes.dex */
public @interface OnLongClick {
    @IdRes
    int[] value() default {-1};
}
