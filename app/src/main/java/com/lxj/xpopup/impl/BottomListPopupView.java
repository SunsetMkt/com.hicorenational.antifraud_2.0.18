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
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.p186e.InterfaceC2812f;
import com.lxj.xpopup.widget.CheckView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class BottomListPopupView extends BottomPopupView {

    /* renamed from: q */
    RecyclerView f8759q;

    /* renamed from: r */
    TextView f8760r;

    /* renamed from: s */
    protected int f8761s;

    /* renamed from: t */
    protected int f8762t;

    /* renamed from: u */
    String f8763u;

    /* renamed from: v */
    String[] f8764v;

    /* renamed from: w */
    int[] f8765w;

    /* renamed from: x */
    private InterfaceC2812f f8766x;

    /* renamed from: y */
    int f8767y;

    /* renamed from: com.lxj.xpopup.impl.BottomListPopupView$a */
    class C2822a extends EasyAdapter<String> {
        C2822a(List list, int i2) {
            super(list, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.lxj.easyadapter.EasyAdapter
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo8200a(@NonNull ViewHolder viewHolder, @NonNull String str, int i2) {
            viewHolder.m8233a(C2766R.id.tv_text, str);
            int[] iArr = BottomListPopupView.this.f8765w;
            if (iArr == null || iArr.length <= i2) {
                viewHolder.m8231a(C2766R.id.iv_image).setVisibility(8);
            } else {
                viewHolder.m8231a(C2766R.id.iv_image).setVisibility(0);
                viewHolder.m8231a(C2766R.id.iv_image).setBackgroundResource(BottomListPopupView.this.f8765w[i2]);
            }
            if (BottomListPopupView.this.f8767y != -1) {
                if (viewHolder.m8231a(C2766R.id.check_view) != null) {
                    viewHolder.m8231a(C2766R.id.check_view).setVisibility(i2 != BottomListPopupView.this.f8767y ? 8 : 0);
                    ((CheckView) viewHolder.m8231a(C2766R.id.check_view)).setColor(C2768b.m8296b());
                }
                TextView textView = (TextView) viewHolder.m8231a(C2766R.id.tv_text);
                BottomListPopupView bottomListPopupView = BottomListPopupView.this;
                textView.setTextColor(i2 == bottomListPopupView.f8767y ? C2768b.m8296b() : bottomListPopupView.getResources().getColor(C2766R.color._xpopup_title_color));
            }
        }
    }

    /* renamed from: com.lxj.xpopup.impl.BottomListPopupView$b */
    class C2823b extends MultiItemTypeAdapter.C2749c {

        /* renamed from: a */
        final /* synthetic */ EasyAdapter f8769a;

        /* renamed from: com.lxj.xpopup.impl.BottomListPopupView$b$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (BottomListPopupView.this.f8617a.f8691d.booleanValue()) {
                    BottomListPopupView.this.mo8378b();
                }
            }
        }

        C2823b(EasyAdapter easyAdapter) {
            this.f8769a = easyAdapter;
        }

        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.C2749c, com.lxj.easyadapter.MultiItemTypeAdapter.InterfaceC2748b
        /* renamed from: a */
        public void mo8228a(View view, RecyclerView.ViewHolder viewHolder, int i2) {
            if (BottomListPopupView.this.f8766x != null) {
                BottomListPopupView.this.f8766x.m8431a(i2, (String) this.f8769a.m8213a().get(i2));
            }
            BottomListPopupView bottomListPopupView = BottomListPopupView.this;
            if (bottomListPopupView.f8767y != -1) {
                bottomListPopupView.f8767y = i2;
                this.f8769a.notifyDataSetChanged();
            }
            BottomListPopupView.this.postDelayed(new a(), 100L);
        }
    }

    public BottomListPopupView(@NonNull Context context) {
        super(context);
        this.f8767y = -1;
    }

    /* renamed from: b */
    public BottomListPopupView m8485b(int i2) {
        this.f8761s = i2;
        return this;
    }

    /* renamed from: c */
    public BottomListPopupView m8486c(int i2) {
        this.f8767y = i2;
        return this;
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.f8761s;
        return i2 == 0 ? C2766R.layout._xpopup_center_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        this.f8759q = (RecyclerView) findViewById(C2766R.id.recyclerView);
        this.f8760r = (TextView) findViewById(C2766R.id.tv_title);
        if (this.f8760r != null) {
            if (TextUtils.isEmpty(this.f8763u)) {
                this.f8760r.setVisibility(8);
            } else {
                this.f8760r.setText(this.f8763u);
            }
        }
        List asList = Arrays.asList(this.f8764v);
        int i2 = this.f8762t;
        if (i2 == 0) {
            i2 = C2766R.layout._xpopup_adapter_text;
        }
        C2822a c2822a = new C2822a(asList, i2);
        c2822a.setOnItemClickListener(new C2823b(c2822a));
        this.f8759q.setAdapter(c2822a);
    }

    /* renamed from: a */
    public BottomListPopupView m8482a(int i2) {
        this.f8762t = i2;
        return this;
    }

    /* renamed from: a */
    public BottomListPopupView m8484a(String str, String[] strArr, int[] iArr) {
        this.f8763u = str;
        this.f8764v = strArr;
        this.f8765w = iArr;
        return this;
    }

    /* renamed from: a */
    public BottomListPopupView m8483a(InterfaceC2812f interfaceC2812f) {
        this.f8766x = interfaceC2812f;
        return this;
    }
}
