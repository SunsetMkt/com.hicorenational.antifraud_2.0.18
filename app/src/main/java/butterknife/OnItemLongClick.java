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
@ListenerClass(method = {@ListenerMethod(defaultReturn = C0052a.f158j, name = "onItemLongClick", parameters = {"android.widget.AdapterView<?>", "android.view.View", "int", "long"}, returnType = "boolean")}, setter = "setOnItemLongClickListener", targetType = "android.widget.AdapterView<?>", type = "android.widget.AdapterView.OnItemLongClickListener")
/* loaded from: classes.dex */
public @interface OnItemLongClick {
    @IdRes
    int[] value() default {-1};
}
