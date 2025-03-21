package androidx.core.util;

import androidx.annotation.RestrictTo;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DebugUtils {
    private DebugUtils() {
    }

    public static void buildShortClassTag(Object obj, StringBuilder sb) {
        int lastIndexOf;
        if (obj == null) {
            sb.append(AbstractC1191a.f2571h);
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if ((simpleName == null || simpleName.length() <= 0) && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }
}
