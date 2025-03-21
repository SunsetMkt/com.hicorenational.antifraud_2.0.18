package com.scwang.smartrefresh.layout.p189b;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.scwang.smartrefresh.layout.p190c.EnumC2880c;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2886f;

/* compiled from: RefreshInternal.java */
/* renamed from: com.scwang.smartrefresh.layout.b.h */
/* loaded from: classes.dex */
public interface InterfaceC2874h extends InterfaceC2886f {
    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* renamed from: a */
    int mo8713a(@NonNull InterfaceC2876j interfaceC2876j, boolean z);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* renamed from: a */
    void mo8714a(float f2, int i2, int i3);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* renamed from: a */
    void mo8715a(@NonNull InterfaceC2875i interfaceC2875i, int i2, int i3);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* renamed from: a */
    void mo8716a(@NonNull InterfaceC2876j interfaceC2876j, int i2, int i3);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* renamed from: a */
    void mo8717a(boolean z, float f2, int i2, int i3, int i4);

    /* renamed from: a */
    boolean mo8718a();

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* renamed from: b */
    void mo8719b(@NonNull InterfaceC2876j interfaceC2876j, int i2, int i3);

    @NonNull
    EnumC2880c getSpinnerStyle();

    @NonNull
    View getView();

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    void setPrimaryColors(@ColorInt int... iArr);
}
