package p388ui.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CheckUserBean;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p357j.C5845d;
import p388ui.callview.ManualAlreadyDetailView;
import p388ui.presenter.ManualAlreadyDetailPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;

/* compiled from: ManualAlreadyDetailActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0006\u0010\u001d\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006("}, m23546d2 = {"Lui/activity/ManualAlreadyDetailActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/callview/ManualAlreadyDetailView;", "()V", "checkBean", "Lbean/CheckUserBean;", "getCheckBean", "()Lbean/CheckUserBean;", "setCheckBean", "(Lbean/CheckUserBean;)V", "mIvBack", "Landroid/widget/ImageView;", "mPicF", "mPicZ", "mPresenter", "Lui/presenter/ManualAlreadyDetailPresenter;", "getMPresenter", "()Lui/presenter/ManualAlreadyDetailPresenter;", "setMPresenter", "(Lui/presenter/ManualAlreadyDetailPresenter;)V", "mTvIdNum", "Landroid/widget/TextView;", "mTvName", "mTvPhoneNum", "mTvTitle", "initListener", "", "initPage", "initViewData", "onClick", "view", "Landroid/view/View;", "onSuccess", "result", "setLayoutView", "", "showPreviewPic", "path", "", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ManualAlreadyDetailActivity extends BaseActivity implements View.OnClickListener, ManualAlreadyDetailView {

    @InterfaceC5817e
    private CheckUserBean checkBean;
    private ImageView mIvBack;
    private ImageView mPicF;
    private ImageView mPicZ;

    @InterfaceC5817e
    private ManualAlreadyDetailPresenter mPresenter;
    private TextView mTvIdNum;
    private TextView mTvName;
    private TextView mTvPhoneNum;
    private TextView mTvTitle;

    @InterfaceC5817e
    public final CheckUserBean getCheckBean() {
        return this.checkBean;
    }

    @InterfaceC5817e
    public final ManualAlreadyDetailPresenter getMPresenter() {
        return this.mPresenter;
    }

    public final void initListener() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        if (imageView == null) {
            C5544i0.m22545f();
        }
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.mPicZ;
        if (imageView2 == null) {
            C5544i0.m22554k("mPicZ");
        }
        if (imageView2 == null) {
            C5544i0.m22545f();
        }
        imageView2.setOnClickListener(this);
        ImageView imageView3 = this.mPicF;
        if (imageView3 == null) {
            C5544i0.m22554k("mPicF");
        }
        if (imageView3 == null) {
            C5544i0.m22545f();
        }
        imageView3.setOnClickListener(this);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        View findViewById = findViewById(C2113R.id.iv_back);
        C5544i0.m22521a((Object) findViewById, "findViewById(R.id.iv_back)");
        this.mIvBack = (ImageView) findViewById;
        View findViewById2 = findViewById(C2113R.id.tv_title);
        C5544i0.m22521a((Object) findViewById2, "findViewById(R.id.tv_title)");
        this.mTvTitle = (TextView) findViewById2;
        View findViewById3 = findViewById(C2113R.id.tv_name);
        C5544i0.m22521a((Object) findViewById3, "findViewById(R.id.tv_name)");
        this.mTvName = (TextView) findViewById3;
        View findViewById4 = findViewById(C2113R.id.tv_id_num);
        C5544i0.m22521a((Object) findViewById4, "findViewById(R.id.tv_id_num)");
        this.mTvIdNum = (TextView) findViewById4;
        View findViewById5 = findViewById(C2113R.id.tv_phone_num);
        C5544i0.m22521a((Object) findViewById5, "findViewById(R.id.tv_phone_num)");
        this.mTvPhoneNum = (TextView) findViewById5;
        View findViewById6 = findViewById(C2113R.id.iv_upload_pic_z);
        C5544i0.m22521a((Object) findViewById6, "findViewById(R.id.iv_upload_pic_z)");
        this.mPicZ = (ImageView) findViewById6;
        View findViewById7 = findViewById(C2113R.id.iv_upload_pic_f);
        C5544i0.m22521a((Object) findViewById7, "findViewById(R.id.iv_upload_pic_f)");
        this.mPicF = (ImageView) findViewById7;
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("已审核详情");
        this.mPresenter = new ManualAlreadyDetailPresenter(this.mActivity, this);
        long longExtra = getIntent().getLongExtra(C7292k1.f25391c, -1L);
        ManualAlreadyDetailPresenter manualAlreadyDetailPresenter = this.mPresenter;
        if (manualAlreadyDetailPresenter != null) {
            manualAlreadyDetailPresenter.detail(Long.valueOf(longExtra));
        }
        initListener();
    }

    public final void initViewData() {
        TextView textView = this.mTvName;
        if (textView == null) {
            C5544i0.m22554k("mTvName");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：");
        CheckUserBean checkUserBean = this.checkBean;
        sb.append(checkUserBean != null ? checkUserBean.getName() : null);
        textView.setText(sb.toString());
        TextView textView2 = this.mTvIdNum;
        if (textView2 == null) {
            C5544i0.m22554k("mTvIdNum");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("证件号：");
        CheckUserBean checkUserBean2 = this.checkBean;
        sb2.append(checkUserBean2 != null ? checkUserBean2.getIdNumber() : null);
        textView2.setText(sb2.toString());
        TextView textView3 = this.mTvPhoneNum;
        if (textView3 == null) {
            C5544i0.m22554k("mTvPhoneNum");
        }
        if (textView3 == null) {
            C5544i0.m22545f();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("手机号：");
        CheckUserBean checkUserBean3 = this.checkBean;
        sb3.append(checkUserBean3 != null ? checkUserBean3.getTelnumber() : null);
        textView3.setText(sb3.toString());
        CheckUserBean checkUserBean4 = this.checkBean;
        String frontImg = checkUserBean4 != null ? checkUserBean4.getFrontImg() : null;
        ImageView imageView = this.mPicZ;
        if (imageView == null) {
            C5544i0.m22554k("mPicZ");
        }
        C5845d.m24610a(frontImg, imageView, Integer.valueOf(C2113R.drawable.iv_id_z_default));
        CheckUserBean checkUserBean5 = this.checkBean;
        String backImg = checkUserBean5 != null ? checkUserBean5.getBackImg() : null;
        ImageView imageView2 = this.mPicF;
        if (imageView2 == null) {
            C5544i0.m22554k("mPicF");
        }
        C5845d.m24610a(backImg, imageView2, Integer.valueOf(C2113R.drawable.iv_id_f_default));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.iv_back /* 2131296762 */:
                m8092a();
                break;
            case C2113R.id.iv_upload_pic_f /* 2131296855 */:
                CheckUserBean checkUserBean = this.checkBean;
                showPreviewPic(checkUserBean != null ? checkUserBean.getBackImg() : null);
                break;
            case C2113R.id.iv_upload_pic_z /* 2131296856 */:
                CheckUserBean checkUserBean2 = this.checkBean;
                showPreviewPic(checkUserBean2 != null ? checkUserBean2.getFrontImg() : null);
                break;
        }
    }

    @Override // p388ui.callview.ManualAlreadyDetailView
    public void onSuccess(@InterfaceC5817e CheckUserBean checkUserBean) {
        if (checkUserBean != null) {
            this.checkBean = checkUserBean;
            initViewData();
        }
    }

    public final void setCheckBean(@InterfaceC5817e CheckUserBean checkUserBean) {
        this.checkBean = checkUserBean;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_manual_already_detail;
    }

    public final void setMPresenter(@InterfaceC5817e ManualAlreadyDetailPresenter manualAlreadyDetailPresenter) {
        this.mPresenter = manualAlreadyDetailPresenter;
    }

    public final void showPreviewPic(@InterfaceC5817e String str) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        LocalMedia localMedia = new LocalMedia();
        localMedia.setPath(str);
        arrayList.add(localMedia);
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f22711f, arrayList);
        intent.putExtra(PreviewPictureActivity.f22712g, 0);
        intent.putExtra(PreviewPictureActivity.f22713h, arrayList.size());
        intent.putExtra(PreviewPictureActivity.f22714i, str);
        startActivity(intent);
    }
}
