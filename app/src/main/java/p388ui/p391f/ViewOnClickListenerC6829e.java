package p388ui.p391f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import bean.ShareConfigBean;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.p137r.AbstractC1822a;
import com.bumptech.glide.p137r.C1829h;
import com.hicorenational.antifraud.C2113R;
import manager.BaseDialog;
import util.C7331w1;
import util.C7337y1;

/* compiled from: SharePicDialog.java */
/* renamed from: ui.f.e */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC6829e extends BaseDialog implements View.OnClickListener {

    /* renamed from: a */
    private Activity f23737a;

    /* renamed from: b */
    private ImageView f23738b;

    /* renamed from: c */
    private ShareConfigBean f23739c;

    public ViewOnClickListenerC6829e(Activity activity, ShareConfigBean shareConfigBean) {
        super(activity, C2113R.style.base_dialog_style);
        this.f23737a = activity;
        this.f23739c = shareConfigBean;
        m25528a();
    }

    @SuppressLint({"ResourceType"})
    /* renamed from: a */
    private void m25528a() {
        setContentView(C2113R.layout.share_save_pic_dlg);
        setGravityLayout(2);
        setWidthDialog(0.8d);
        setHeightDialog(-2.0d);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initOnCreate();
        this.f23738b = (ImageView) findViewById(C2113R.id.iv_img);
        ShareConfigBean shareConfigBean = this.f23739c;
        if (shareConfigBean != null) {
            m25529a(shareConfigBean.saveImgUrl, this.f23738b);
        } else {
            this.f23738b.setBackgroundResource(C2113R.drawable.iv_share_pic);
        }
        View findViewById = findViewById(C2113R.id.iv_close);
        View findViewById2 = findViewById(C2113R.id.ll_save);
        findViewById.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C2113R.id.iv_close) {
            dismiss();
        } else {
            if (id != C2113R.id.ll_save) {
                return;
            }
            C7337y1.m26733a(this.f23737a, this.f23738b);
            C7331w1.m26688a("海报已保存至相册");
            dismiss();
        }
    }

    /* renamed from: a */
    public void m25529a(String str, ImageView imageView) {
        try {
            ComponentCallbacks2C1576b.m3649e(imageView.getContext()).mo3719a(str).mo3763a((AbstractC1822a<?>) new C1829h().m4762b(C2113R.drawable.iv_share_pic)).m3768a(imageView);
        } catch (Exception unused) {
        }
    }
}
