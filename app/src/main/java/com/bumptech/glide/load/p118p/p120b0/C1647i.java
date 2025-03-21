package com.bumptech.glide.load.p118p.p120b0;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1648j;
import com.bumptech.glide.util.C1873g;

/* compiled from: LruResourceCache.java */
/* renamed from: com.bumptech.glide.load.p.b0.i */
/* loaded from: classes.dex */
public class C1647i extends C1873g<InterfaceC1593g, InterfaceC1677v<?>> implements InterfaceC1648j {

    /* renamed from: e */
    private InterfaceC1648j.a f4363e;

    public C1647i(long j2) {
        super(j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.C1873g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo3999a(@NonNull InterfaceC1593g interfaceC1593g, @Nullable InterfaceC1677v<?> interfaceC1677v) {
        InterfaceC1648j.a aVar = this.f4363e;
        if (aVar == null || interfaceC1677v == null) {
            return;
        }
        aVar.mo4005a(interfaceC1677v);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p118p.p120b0.InterfaceC1648j
    @Nullable
    /* renamed from: a */
    public /* bridge */ /* synthetic */ InterfaceC1677v mo3996a(@NonNull InterfaceC1593g interfaceC1593g, @Nullable InterfaceC1677v interfaceC1677v) {
        return (InterfaceC1677v) super.m4978b((C1647i) interfaceC1593g, (InterfaceC1593g) interfaceC1677v);
    }

    @Override // com.bumptech.glide.load.p118p.p120b0.InterfaceC1648j
    @Nullable
    /* renamed from: a */
    public /* bridge */ /* synthetic */ InterfaceC1677v mo3995a(@NonNull InterfaceC1593g interfaceC1593g) {
        return (InterfaceC1677v) super.m4980d(interfaceC1593g);
    }

    @Override // com.bumptech.glide.load.p118p.p120b0.InterfaceC1648j
    /* renamed from: a */
    public void mo3998a(@NonNull InterfaceC1648j.a aVar) {
        this.f4363e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.C1873g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo4001c(@Nullable InterfaceC1677v<?> interfaceC1677v) {
        if (interfaceC1677v == null) {
            return super.mo4001c(null);
        }
        return interfaceC1677v.mo4183a();
    }

    @Override // com.bumptech.glide.load.p118p.p120b0.InterfaceC1648j
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo3997a(int i2) {
        if (i2 >= 40) {
            m4972a();
        } else if (i2 >= 20 || i2 == 15) {
            m4974a(m4976b() / 2);
        }
    }
}
