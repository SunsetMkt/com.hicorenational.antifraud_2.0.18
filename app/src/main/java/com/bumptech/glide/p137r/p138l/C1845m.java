package com.bumptech.glide.p137r.p138l;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ComponentCallbacks2C1585k;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;

/* compiled from: PreloadTarget.java */
/* renamed from: com.bumptech.glide.r.l.m */
/* loaded from: classes.dex */
public final class C1845m<Z> extends AbstractC1837e<Z> {

    /* renamed from: e */
    private static final int f5413e = 1;

    /* renamed from: f */
    private static final Handler f5414f = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: d */
    private final ComponentCallbacks2C1585k f5415d;

    /* compiled from: PreloadTarget.java */
    /* renamed from: com.bumptech.glide.r.l.m$a */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((C1845m) message.obj).m4912b();
            return true;
        }
    }

    private C1845m(ComponentCallbacks2C1585k componentCallbacks2C1585k, int i2, int i3) {
        super(i2, i3);
        this.f5415d = componentCallbacks2C1585k;
    }

    /* renamed from: a */
    public static <Z> C1845m<Z> m4911a(ComponentCallbacks2C1585k componentCallbacks2C1585k, int i2, int i3) {
        return new C1845m<>(componentCallbacks2C1585k, i2, i3);
    }

    /* renamed from: b */
    void m4912b() {
        this.f5415d.m3783a((InterfaceC1848p<?>) this);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: c */
    public void mo3712c(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public void mo3709a(@NonNull Z z, @Nullable InterfaceC1856f<? super Z> interfaceC1856f) {
        f5414f.obtainMessage(1, this).sendToTarget();
    }
}
