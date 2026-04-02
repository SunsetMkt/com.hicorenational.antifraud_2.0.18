package ui.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import bean.ShareConfigBean;
import com.bumptech.glide.r.h;
import com.hicorenational.antifraud.R;
import manager.BaseDialog;
import util.e2;
import util.g2;

/* JADX INFO: compiled from: SharePicDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends BaseDialog implements View.OnClickListener {
    private Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f14122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ShareConfigBean f14123c;

    public e(Activity activity, ShareConfigBean shareConfigBean) {
        super(activity, R.style.base_dialog_style);
        this.a = activity;
        this.f14123c = shareConfigBean;
        a();
    }

    @SuppressLint({"ResourceType"})
    private void a() {
        setContentView(R.layout.share_save_pic_dlg);
        setGravityLayout(2);
        setWidthDialog(0.8d);
        setHeightDialog(-2.0d);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initOnCreate();
        this.f14122b = (ImageView) findViewById(R.id.iv_img);
        ShareConfigBean shareConfigBean = this.f14123c;
        if (shareConfigBean != null) {
            a(shareConfigBean.saveImgUrl, this.f14122b);
        } else {
            this.f14122b.setBackgroundResource(R.drawable.iv_share_pic);
        }
        View viewFindViewById = findViewById(R.id.iv_close);
        View viewFindViewById2 = findViewById(R.id.ll_save);
        viewFindViewById.setOnClickListener(this);
        viewFindViewById2.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_close) {
            dismiss();
        } else {
            if (id != R.id.ll_save) {
                return;
            }
            g2.a(this.a, this.f14122b);
            e2.a("\u6d77\u62a5\u5df2\u4fdd\u5b58\u81f3\u76f8\u518c");
            dismiss();
        }
    }

    public void a(String str, ImageView imageView) {
        try {
            com.bumptech.glide.b.e(imageView.getContext()).a(str).a((com.bumptech.glide.r.a<?>) new h().b(R.drawable.iv_share_pic)).a(imageView);
        } catch (Exception unused) {
        }
    }
}
