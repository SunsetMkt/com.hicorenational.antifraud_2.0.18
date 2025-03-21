package com.lxj.xpopup.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.MultiItemTypeAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.p186e.InterfaceC2812f;
import com.lxj.xpopup.widget.CheckView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class CenterListPopupView extends CenterPopupView {

    /* renamed from: s */
    RecyclerView f8772s;

    /* renamed from: t */
    TextView f8773t;

    /* renamed from: u */
    String f8774u;

    /* renamed from: v */
    String[] f8775v;

    /* renamed from: w */
    int[] f8776w;

    /* renamed from: x */
    private InterfaceC2812f f8777x;

    /* renamed from: y */
    int f8778y;

    /* renamed from: com.lxj.xpopup.impl.CenterListPopupView$a */
    class C2824a extends EasyAdapter<String> {
        C2824a(List list, int i2) {
            super(list, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.lxj.easyadapter.EasyAdapter
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo8200a(@NonNull ViewHolder viewHolder, @NonNull String str, int i2) {
            viewHolder.m8233a(C2766R.id.tv_text, str);
            int[] iArr = CenterListPopupView.this.f8776w;
            if (iArr == null || iArr.length <= i2) {
                viewHolder.m8231a(C2766R.id.iv_image).setVisibility(8);
            } else {
                viewHolder.m8231a(C2766R.id.iv_image).setVisibility(0);
                viewHolder.m8231a(C2766R.id.iv_image).setBackgroundResource(CenterListPopupView.this.f8776w[i2]);
            }
            if (CenterListPopupView.this.f8778y != -1) {
                if (viewHolder.m8231a(C2766R.id.check_view) != null) {
                    viewHolder.m8231a(C2766R.id.check_view).setVisibility(i2 != CenterListPopupView.this.f8778y ? 8 : 0);
                    ((CheckView) viewHolder.m8231a(C2766R.id.check_view)).setColor(C2768b.m8296b());
                }
                TextView textView = (TextView) viewHolder.m8231a(C2766R.id.tv_text);
                CenterListPopupView centerListPopupView = CenterListPopupView.this;
                textView.setTextColor(i2 == centerListPopupView.f8778y ? C2768b.m8296b() : centerListPopupView.getResources().getColor(C2766R.color._xpopup_title_color));
            }
        }
    }

    /* renamed from: com.lxj.xpopup.impl.CenterListPopupView$b */
    class C2825b extends MultiItemTypeAdapter.C2749c {

        /* renamed from: a */
        final /* synthetic */ EasyAdapter f8780a;

        C2825b(EasyAdapter easyAdapter) {
            this.f8780a = easyAdapter;
        }

        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.C2749c, com.lxj.easyadapter.MultiItemTypeAdapter.InterfaceC2748b
        /* renamed from: a */
        public void mo8228a(View view, RecyclerView.ViewHolder viewHolder, int i2) {
            if (CenterListPopupView.this.f8777x != null && i2 >= 0 && i2 < this.f8780a.m8213a().size()) {
                CenterListPopupView.this.f8777x.m8431a(i2, (String) this.f8780a.m8213a().get(i2));
            }
            CenterListPopupView centerListPopupView = CenterListPopupView.this;
            if (centerListPopupView.f8778y != -1) {
                centerListPopupView.f8778y = i2;
                this.f8780a.notifyDataSetChanged();
            }
            if (CenterListPopupView.this.f8617a.f8691d.booleanValue()) {
                CenterListPopupView.this.mo8378b();
            }
        }
    }

    public CenterListPopupView(@NonNull Context context) {
        super(context);
        this.f8778y = -1;
    }

    /* renamed from: b */
    public CenterListPopupView m8491b(int i2) {
        this.f8646q = i2;
        return this;
    }

    /* renamed from: c */
    public CenterListPopupView m8492c(int i2) {
        this.f8778y = i2;
        return this;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.f8646q;
        return i2 == 0 ? C2766R.layout._xpopup_center_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        int i2 = this.f8617a.f8698k;
        return i2 == 0 ? (int) (super.getMaxWidth() * 0.8f) : i2;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        this.f8772s = (RecyclerView) findViewById(C2766R.id.recyclerView);
        this.f8773t = (TextView) findViewById(C2766R.id.tv_title);
        if (this.f8773t != null) {
            if (TextUtils.isEmpty(this.f8774u)) {
                this.f8773t.setVisibility(8);
            } else {
                this.f8773t.setText(this.f8774u);
            }
        }
        List asList = Arrays.asList(this.f8775v);
        int i2 = this.f8647r;
        if (i2 == 0) {
            i2 = C2766R.layout._xpopup_adapter_text;
        }
        C2824a c2824a = new C2824a(asList, i2);
        c2824a.setOnItemClickListener(new C2825b(c2824a));
        this.f8772s.setAdapter(c2824a);
    }

    /* renamed from: a */
    public CenterListPopupView m8488a(int i2) {
        this.f8647r = i2;
        return this;
    }

    /* renamed from: a */
    public CenterListPopupView m8490a(String str, String[] strArr, int[] iArr) {
        this.f8774u = str;
        this.f8775v = strArr;
        this.f8776w = iArr;
        return this;
    }

    /* renamed from: a */
    public CenterListPopupView m8489a(InterfaceC2812f interfaceC2812f) {
        this.f8777x = interfaceC2812f;
        return this;
    }
}
