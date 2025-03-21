package p388ui.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import bean.CheckUserBean;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.util.ArrayList;
import manager.BaseDialog;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p357j.C5845d;
import p388ui.callview.ManualDetailView;
import p388ui.presenter.ManualDetailPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;

/* compiled from: ManualDetailActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0005¢\u0006\u0002\u0010\u0004J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203J\b\u00105\u001a\u000203H\u0016J\u0006\u00106\u001a\u000203J\u0010\u00107\u001a\u0002032\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000203H\u0016J\b\u0010;\u001a\u000203H\u0016J\b\u0010<\u001a\u000203H\u0016J\u0006\u0010=\u001a\u000203J\b\u0010>\u001a\u00020\fH\u0016J\u0010\u0010?\u001a\u0002032\b\u0010@\u001a\u0004\u0018\u00010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000¨\u0006B"}, m23546d2 = {"Lui/activity/ManualDetailActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/callview/ManualDetailView;", "()V", "checkBean", "Lbean/CheckUserBean;", "getCheckBean", "()Lbean/CheckUserBean;", "setCheckBean", "(Lbean/CheckUserBean;)V", "checkType", "", "getCheckType", "()Ljava/lang/Integer;", "setCheckType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "disAgreeStr", "", "getDisAgreeStr", "()Ljava/lang/String;", "setDisAgreeStr", "(Ljava/lang/String;)V", "dlg", "Lmanager/BaseDialog;", "getDlg", "()Lmanager/BaseDialog;", "setDlg", "(Lmanager/BaseDialog;)V", "mDlgRed", "getMDlgRed", "setMDlgRed", "mIvBack", "Landroid/widget/ImageView;", "mPicF", "mPicZ", "mPresenter", "Lui/presenter/ManualDetailPresenter;", "getMPresenter", "()Lui/presenter/ManualDetailPresenter;", "setMPresenter", "(Lui/presenter/ManualDetailPresenter;)V", "mTvArgee", "Landroid/widget/TextView;", "mTvDisAgree", "mTvIdNum", "mTvName", "mTvPhoneNum", "mTvTitle", "disAgreeResonDlg", "", "initListener", "initPage", "initViewData", "onClick", "view", "Landroid/view/View;", "onSuccess", "onSuccessOverrun", "onSuccessUnbind", "overrunDialog", "setLayoutView", "showPreviewPic", "path", "Companion", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ManualDetailActivity extends BaseActivity implements View.OnClickListener, ManualDetailView {
    public static final C6380a Companion = new C6380a(null);

    @InterfaceC5816d
    public static final String Oauth_No = "0";

    @InterfaceC5816d
    public static final String Oauth_Pend = "2";

    @InterfaceC5816d
    public static final String Oauth_Succ = "1";

    @InterfaceC5816d
    public static final String Oauth_fail = "3";

    @InterfaceC5817e
    private CheckUserBean checkBean;

    @InterfaceC5817e
    private Integer checkType = 0;

    @InterfaceC5817e
    private String disAgreeStr;

    @InterfaceC5817e
    private BaseDialog dlg;

    @InterfaceC5817e
    private BaseDialog mDlgRed;
    private ImageView mIvBack;
    private ImageView mPicF;
    private ImageView mPicZ;

    @InterfaceC5817e
    private ManualDetailPresenter mPresenter;
    private TextView mTvArgee;
    private TextView mTvDisAgree;
    private TextView mTvIdNum;
    private TextView mTvName;
    private TextView mTvPhoneNum;
    private TextView mTvTitle;

    /* compiled from: ManualDetailActivity.kt */
    /* renamed from: ui.activity.ManualDetailActivity$a */
    public static final class C6380a {
        private C6380a() {
        }

        public /* synthetic */ C6380a(C5586v c5586v) {
            this();
        }
    }

    /* compiled from: ManualDetailActivity.kt */
    /* renamed from: ui.activity.ManualDetailActivity$b */
    static final class C6381b implements RadioGroup.OnCheckedChangeListener {
        C6381b() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            switch (i2) {
                case C2113R.id.rb_other /* 2131297133 */:
                    ManualDetailActivity.this.setCheckType(0);
                    break;
                case C2113R.id.rb_pic_bf /* 2131297135 */:
                    ManualDetailActivity.this.setCheckType(2);
                    break;
                case C2113R.id.rb_pic_mh /* 2131297136 */:
                    ManualDetailActivity.this.setCheckType(1);
                    break;
            }
        }
    }

    /* compiled from: ManualDetailActivity.kt */
    /* renamed from: ui.activity.ManualDetailActivity$c */
    static final class ViewOnClickListenerC6382c implements View.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ EditText f22550b;

        ViewOnClickListenerC6382c(EditText editText) {
            this.f22550b = editText;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Integer checkType = ManualDetailActivity.this.getCheckType();
            if (checkType != null && checkType.intValue() == 1) {
                ManualDetailActivity.this.setDisAgreeStr("手持证件照片模糊");
            } else {
                Integer checkType2 = ManualDetailActivity.this.getCheckType();
                if (checkType2 != null && checkType2.intValue() == 2) {
                    ManualDetailActivity.this.setDisAgreeStr("人像与证件照片不符");
                } else {
                    EditText editText = this.f22550b;
                    if (editText == null) {
                        C5544i0.m22545f();
                    }
                    String obj = editText.getText().toString();
                    if (TextUtils.isEmpty(obj)) {
                        C7331w1.m26688a("请输入其他原因~");
                        return;
                    }
                    ManualDetailActivity.this.setDisAgreeStr(obj);
                }
            }
            ManualDetailPresenter mPresenter = ManualDetailActivity.this.getMPresenter();
            if (mPresenter != null) {
                CheckUserBean checkBean = ManualDetailActivity.this.getCheckBean();
                mPresenter.submitaudit("3", checkBean != null ? checkBean.getTelnumber() : null, ManualDetailActivity.this.getDisAgreeStr());
            }
            BaseDialog dlg = ManualDetailActivity.this.getDlg();
            if (dlg == null) {
                C5544i0.m22545f();
            }
            dlg.dismiss();
        }
    }

    /* compiled from: ManualDetailActivity.kt */
    /* renamed from: ui.activity.ManualDetailActivity$d */
    public static final class C6383d implements IClickListener {
        C6383d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            ManualDetailPresenter mPresenter = ManualDetailActivity.this.getMPresenter();
            if (mPresenter != null) {
                CheckUserBean checkBean = ManualDetailActivity.this.getCheckBean();
                mPresenter.unbind("1", checkBean != null ? checkBean.getTelnumber() : null, "同意");
            }
        }
    }

    public final void disAgreeResonDlg() {
        this.dlg = new BaseDialog(this.mActivity, C2113R.style.base_dialog_style);
        BaseDialog baseDialog = this.dlg;
        if (baseDialog == null) {
            C5544i0.m22545f();
        }
        baseDialog.setContentView(C2113R.layout.dis_agree_dlg);
        BaseDialog baseDialog2 = this.dlg;
        if (baseDialog2 == null) {
            C5544i0.m22545f();
        }
        baseDialog2.setGravityLayout(2);
        BaseDialog baseDialog3 = this.dlg;
        if (baseDialog3 == null) {
            C5544i0.m22545f();
        }
        baseDialog3.setWidthDialogdp(-2.0f);
        BaseDialog baseDialog4 = this.dlg;
        if (baseDialog4 == null) {
            C5544i0.m22545f();
        }
        baseDialog4.setHeightDialogdp(-2.0f);
        BaseDialog baseDialog5 = this.dlg;
        if (baseDialog5 == null) {
            C5544i0.m22545f();
        }
        baseDialog5.setCancelable(true);
        BaseDialog baseDialog6 = this.dlg;
        if (baseDialog6 == null) {
            C5544i0.m22545f();
        }
        baseDialog6.setCanceledOnTouchOutside(true);
        BaseDialog baseDialog7 = this.dlg;
        if (baseDialog7 == null) {
            C5544i0.m22545f();
        }
        baseDialog7.initOnCreate();
        BaseDialog baseDialog8 = this.dlg;
        if (baseDialog8 == null) {
            C5544i0.m22545f();
        }
        baseDialog8.show();
        BaseDialog baseDialog9 = this.dlg;
        if (baseDialog9 == null) {
            C5544i0.m22545f();
        }
        RadioGroup radioGroup = (RadioGroup) baseDialog9.findViewById(C2113R.id.rg_group);
        BaseDialog baseDialog10 = this.dlg;
        if (baseDialog10 == null) {
            C5544i0.m22545f();
        }
        EditText editText = (EditText) baseDialog10.findViewById(C2113R.id.et_other_reson);
        BaseDialog baseDialog11 = this.dlg;
        if (baseDialog11 == null) {
            C5544i0.m22545f();
        }
        Button button = (Button) baseDialog11.findViewById(C2113R.id.confirm);
        radioGroup.setOnCheckedChangeListener(new C6381b());
        button.setOnClickListener(new ViewOnClickListenerC6382c(editText));
    }

    @InterfaceC5817e
    public final CheckUserBean getCheckBean() {
        return this.checkBean;
    }

    @InterfaceC5817e
    public final Integer getCheckType() {
        return this.checkType;
    }

    @InterfaceC5817e
    public final String getDisAgreeStr() {
        return this.disAgreeStr;
    }

    @InterfaceC5817e
    public final BaseDialog getDlg() {
        return this.dlg;
    }

    @InterfaceC5817e
    public final BaseDialog getMDlgRed() {
        return this.mDlgRed;
    }

    @InterfaceC5817e
    public final ManualDetailPresenter getMPresenter() {
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
        TextView textView = this.mTvArgee;
        if (textView == null) {
            C5544i0.m22554k("mTvArgee");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.mTvDisAgree;
        if (textView2 == null) {
            C5544i0.m22554k("mTvDisAgree");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        textView2.setOnClickListener(this);
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
        View findViewById8 = findViewById(C2113R.id.tv_agree);
        C5544i0.m22521a((Object) findViewById8, "findViewById(R.id.tv_agree)");
        this.mTvArgee = (TextView) findViewById8;
        View findViewById9 = findViewById(C2113R.id.tv_disagree);
        C5544i0.m22521a((Object) findViewById9, "findViewById(R.id.tv_disagree)");
        this.mTvDisAgree = (TextView) findViewById9;
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("待审核详情");
        this.mPresenter = new ManualDetailPresenter(this.mActivity, this);
        this.checkBean = (CheckUserBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        initListener();
        initViewData();
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
            case C2113R.id.tv_agree /* 2131297410 */:
                ManualDetailPresenter manualDetailPresenter = this.mPresenter;
                if (manualDetailPresenter != null) {
                    CheckUserBean checkUserBean3 = this.checkBean;
                    manualDetailPresenter.submitaudit("1", checkUserBean3 != null ? checkUserBean3.getTelnumber() : null, "同意");
                    break;
                }
                break;
            case C2113R.id.tv_disagree /* 2131297538 */:
                disAgreeResonDlg();
                break;
        }
    }

    @Override // p388ui.callview.ManualDetailView
    public void onSuccess() {
        C7331w1.m26688a("操作成功");
        finish();
    }

    @Override // p388ui.callview.ManualDetailView
    public void onSuccessOverrun() {
        overrunDialog();
    }

    @Override // p388ui.callview.ManualDetailView
    public void onSuccessUnbind() {
        BaseDialog baseDialog = this.mDlgRed;
        if (baseDialog == null) {
            C5544i0.m22545f();
        }
        baseDialog.dismiss();
        finish();
    }

    public final void overrunDialog() {
        this.mDlgRed = C7257b1.m26219c(this.mActivity, "当前身份信息已实名其他账号，是否换绑新账号，并注销老账号？", "需确认当前身份信息与本人一致，请谨慎操作！", "取消", "确定", new C6383d());
    }

    public final void setCheckBean(@InterfaceC5817e CheckUserBean checkUserBean) {
        this.checkBean = checkUserBean;
    }

    public final void setCheckType(@InterfaceC5817e Integer num) {
        this.checkType = num;
    }

    public final void setDisAgreeStr(@InterfaceC5817e String str) {
        this.disAgreeStr = str;
    }

    public final void setDlg(@InterfaceC5817e BaseDialog baseDialog) {
        this.dlg = baseDialog;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_manual_detail;
    }

    public final void setMDlgRed(@InterfaceC5817e BaseDialog baseDialog) {
        this.mDlgRed = baseDialog;
    }

    public final void setMPresenter(@InterfaceC5817e ManualDetailPresenter manualDetailPresenter) {
        this.mPresenter = manualDetailPresenter;
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
