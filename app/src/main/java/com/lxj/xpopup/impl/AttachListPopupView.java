package com.lxj.xpopup.impl;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.MultiItemTypeAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.p186e.InterfaceC2812f;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class AttachListPopupView extends AttachPopupView {

    /* renamed from: A */
    protected int f8750A;

    /* renamed from: B */
    protected int f8751B;

    /* renamed from: C */
    String[] f8752C;

    /* renamed from: D */
    int[] f8753D;

    /* renamed from: E */
    private InterfaceC2812f f8754E;

    /* renamed from: z */
    RecyclerView f8755z;

    /* renamed from: com.lxj.xpopup.impl.AttachListPopupView$a */
    class C2820a extends EasyAdapter<String> {
        C2820a(List list, int i2) {
            super(list, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.lxj.easyadapter.EasyAdapter
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo8200a(@NonNull ViewHolder viewHolder, @NonNull String str, int i2) {
            viewHolder.m8233a(C2766R.id.tv_text, str);
            int[] iArr = AttachListPopupView.this.f8753D;
            if (iArr == null || iArr.length <= i2) {
                viewHolder.m8231a(C2766R.id.iv_image).setVisibility(8);
            } else {
                viewHolder.m8231a(C2766R.id.iv_image).setVisibility(0);
                viewHolder.m8231a(C2766R.id.iv_image).setBackgroundResource(AttachListPopupView.this.f8753D[i2]);
            }
        }
    }

    /* renamed from: com.lxj.xpopup.impl.AttachListPopupView$b */
    class C2821b extends MultiItemTypeAdapter.C2749c {

        /* renamed from: a */
        final /* synthetic */ EasyAdapter f8757a;

        C2821b(EasyAdapter easyAdapter) {
            this.f8757a = easyAdapter;
        }

        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.C2749c, com.lxj.easyadapter.MultiItemTypeAdapter.InterfaceC2748b
        /* renamed from: a */
        public void mo8228a(View view, RecyclerView.ViewHolder viewHolder, int i2) {
            if (AttachListPopupView.this.f8754E != null) {
                AttachListPopupView.this.f8754E.m8431a(i2, (String) this.f8757a.m8213a().get(i2));
            }
            if (AttachListPopupView.this.f8617a.f8691d.booleanValue()) {
                AttachListPopupView.this.mo8378b();
            }
        }
    }

    public AttachListPopupView(@NonNull Context context) {
        super(context);
    }

    /* renamed from: b */
    public AttachListPopupView m8480b(int i2) {
        this.f8750A = i2;
        return this;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.f8750A;
        return i2 == 0 ? C2766R.layout._xpopup_attach_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        this.f8755z = (RecyclerView) findViewById(C2766R.id.recyclerView);
        List asList = Arrays.asList(this.f8752C);
        int i2 = this.f8751B;
        if (i2 == 0) {
            i2 = C2766R.layout._xpopup_adapter_text;
        }
        C2820a c2820a = new C2820a(asList, i2);
        c2820a.setOnItemClickListener(new C2821b(c2820a));
        this.f8755z.setAdapter(c2820a);
    }

    /* renamed from: a */
    public AttachListPopupView m8476a(int i2) {
        this.f8751B = i2;
        return this;
    }

    /* renamed from: a */
    public AttachListPopupView m8479a(String[] strArr, int[] iArr) {
        this.f8752C = strArr;
        this.f8753D = iArr;
        return this;
    }

    /* renamed from: a */
    public AttachListPopupView m8477a(int i2, int i3) {
        this.f8603q += i2;
        this.f8602p += i3;
        return this;
    }

    /* renamed from: a */
    public AttachListPopupView m8478a(InterfaceC2812f interfaceC2812f) {
        this.f8754E = interfaceC2812f;
        return this;
    }
}
