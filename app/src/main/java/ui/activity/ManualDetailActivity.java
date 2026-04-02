package ui.activity;

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
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.util.ArrayList;
import manager.BaseDialog;
import ui.callview.ManualDetailView;
import ui.presenter.ManualDetailPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;

/* JADX INFO: compiled from: ManualDetailActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203J\b\u00105\u001a\u000203H\u0016J\u0006\u00106\u001a\u000203J\u0010\u00107\u001a\u0002032\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000203H\u0016J\b\u0010;\u001a\u000203H\u0016J\b\u0010<\u001a\u000203H\u0016J\u0006\u0010=\u001a\u000203J\b\u0010>\u001a\u00020\fH\u0016J\u0010\u0010?\u001a\u0002032\b\u0010@\u001a\u0004\u0018\u00010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lui/activity/ManualDetailActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/callview/ManualDetailView;", "()V", "checkBean", "Lbean/CheckUserBean;", "getCheckBean", "()Lbean/CheckUserBean;", "setCheckBean", "(Lbean/CheckUserBean;)V", "checkType", "", "getCheckType", "()Ljava/lang/Integer;", "setCheckType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "disAgreeStr", "", "getDisAgreeStr", "()Ljava/lang/String;", "setDisAgreeStr", "(Ljava/lang/String;)V", "dlg", "Lmanager/BaseDialog;", "getDlg", "()Lmanager/BaseDialog;", "setDlg", "(Lmanager/BaseDialog;)V", "mDlgRed", "getMDlgRed", "setMDlgRed", "mIvBack", "Landroid/widget/ImageView;", "mPicF", "mPicZ", "mPresenter", "Lui/presenter/ManualDetailPresenter;", "getMPresenter", "()Lui/presenter/ManualDetailPresenter;", "setMPresenter", "(Lui/presenter/ManualDetailPresenter;)V", "mTvArgee", "Landroid/widget/TextView;", "mTvDisAgree", "mTvIdNum", "mTvName", "mTvPhoneNum", "mTvTitle", "disAgreeResonDlg", "", "initListener", "initPage", "initViewData", "onClick", "view", "Landroid/view/View;", "onSuccess", "onSuccessOverrun", "onSuccessUnbind", "overrunDialog", "setLayoutView", "showPreviewPic", "path", "Companion", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class ManualDetailActivity extends BaseActivity implements View.OnClickListener, ManualDetailView {
    public static final a Companion = new a(null);

    @j.c.a.d
    public static final String Oauth_No = "0";

    @j.c.a.d
    public static final String Oauth_Pend = "2";

    @j.c.a.d
    public static final String Oauth_Succ = "1";

    @j.c.a.d
    public static final String Oauth_fail = "3";

    @j.c.a.e
    private CheckUserBean checkBean;

    @j.c.a.e
    private Integer checkType = 0;

    @j.c.a.e
    private String disAgreeStr;

    @j.c.a.e
    private BaseDialog dlg;

    @j.c.a.e
    private BaseDialog mDlgRed;
    private ImageView mIvBack;
    private ImageView mPicF;
    private ImageView mPicZ;

    @j.c.a.e
    private ManualDetailPresenter mPresenter;
    private TextView mTvArgee;
    private TextView mTvDisAgree;
    private TextView mTvIdNum;
    private TextView mTvName;
    private TextView mTvPhoneNum;
    private TextView mTvTitle;

    /* JADX INFO: compiled from: ManualDetailActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(i.q2.t.v vVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: ManualDetailActivity.kt */
    static final class b implements RadioGroup.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            switch (i2) {
                case R.id.rb_other /* 2131297273 */:
                    ManualDetailActivity.this.setCheckType(0);
                    break;
                case R.id.rb_pic_bf /* 2131297275 */:
                    ManualDetailActivity.this.setCheckType(2);
                    break;
                case R.id.rb_pic_mh /* 2131297276 */:
                    ManualDetailActivity.this.setCheckType(1);
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: ManualDetailActivity.kt */
    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f13498b;

        c(EditText editText) {
            this.f13498b = editText;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Integer checkType = ManualDetailActivity.this.getCheckType();
            if (checkType != null && checkType.intValue() == 1) {
                ManualDetailActivity.this.setDisAgreeStr("\u624b\u6301\u8bc1\u4ef6\u7167\u7247\u6a21\u7cca");
            } else {
                Integer checkType2 = ManualDetailActivity.this.getCheckType();
                if (checkType2 != null && checkType2.intValue() == 2) {
                    ManualDetailActivity.this.setDisAgreeStr("\u4eba\u50cf\u4e0e\u8bc1\u4ef6\u7167\u7247\u4e0d\u7b26");
                } else {
                    EditText editText = this.f13498b;
                    if (editText == null) {
                        i.q2.t.i0.f();
                    }
                    String string = editText.getText().toString();
                    if (TextUtils.isEmpty(string)) {
                        e2.a("\u8bf7\u8f93\u5165\u5176\u4ed6\u539f\u56e0~");
                        return;
                    }
                    ManualDetailActivity.this.setDisAgreeStr(string);
                }
            }
            ManualDetailPresenter mPresenter = ManualDetailActivity.this.getMPresenter();
            if (mPresenter != null) {
                CheckUserBean checkBean = ManualDetailActivity.this.getCheckBean();
                mPresenter.submitaudit("3", checkBean != null ? checkBean.getTelnumber() : null, ManualDetailActivity.this.getDisAgreeStr());
            }
            BaseDialog dlg = ManualDetailActivity.this.getDlg();
            if (dlg == null) {
                i.q2.t.i0.f();
            }
            dlg.dismiss();
        }
    }

    /* JADX INFO: compiled from: ManualDetailActivity.kt */
    public static final class d implements IClickListener {
        d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            ManualDetailPresenter mPresenter = ManualDetailActivity.this.getMPresenter();
            if (mPresenter != null) {
                CheckUserBean checkBean = ManualDetailActivity.this.getCheckBean();
                mPresenter.unbind("1", checkBean != null ? checkBean.getTelnumber() : null, "\u540c\u610f");
            }
        }
    }

    public final void disAgreeResonDlg() {
        this.dlg = new BaseDialog(this.mActivity, R.style.base_dialog_style);
        BaseDialog baseDialog = this.dlg;
        if (baseDialog == null) {
            i.q2.t.i0.f();
        }
        baseDialog.setContentView(R.layout.dis_agree_dlg);
        BaseDialog baseDialog2 = this.dlg;
        if (baseDialog2 == null) {
            i.q2.t.i0.f();
        }
        baseDialog2.setGravityLayout(2);
        BaseDialog baseDialog3 = this.dlg;
        if (baseDialog3 == null) {
            i.q2.t.i0.f();
        }
        baseDialog3.setWidthDialogdp(-2.0f);
        BaseDialog baseDialog4 = this.dlg;
        if (baseDialog4 == null) {
            i.q2.t.i0.f();
        }
        baseDialog4.setHeightDialogdp(-2.0f);
        BaseDialog baseDialog5 = this.dlg;
        if (baseDialog5 == null) {
            i.q2.t.i0.f();
        }
        baseDialog5.setCancelable(true);
        BaseDialog baseDialog6 = this.dlg;
        if (baseDialog6 == null) {
            i.q2.t.i0.f();
        }
        baseDialog6.setCanceledOnTouchOutside(true);
        BaseDialog baseDialog7 = this.dlg;
        if (baseDialog7 == null) {
            i.q2.t.i0.f();
        }
        baseDialog7.initOnCreate();
        BaseDialog baseDialog8 = this.dlg;
        if (baseDialog8 == null) {
            i.q2.t.i0.f();
        }
        baseDialog8.show();
        BaseDialog baseDialog9 = this.dlg;
        if (baseDialog9 == null) {
            i.q2.t.i0.f();
        }
        RadioGroup radioGroup = (RadioGroup) baseDialog9.findViewById(R.id.rg_group);
        BaseDialog baseDialog10 = this.dlg;
        if (baseDialog10 == null) {
            i.q2.t.i0.f();
        }
        EditText editText = (EditText) baseDialog10.findViewById(R.id.et_other_reson);
        BaseDialog baseDialog11 = this.dlg;
        if (baseDialog11 == null) {
            i.q2.t.i0.f();
        }
        Button button = (Button) baseDialog11.findViewById(R.id.confirm);
        radioGroup.setOnCheckedChangeListener(new b());
        button.setOnClickListener(new c(editText));
    }

    @j.c.a.e
    public final CheckUserBean getCheckBean() {
        return this.checkBean;
    }

    @j.c.a.e
    public final Integer getCheckType() {
        return this.checkType;
    }

    @j.c.a.e
    public final String getDisAgreeStr() {
        return this.disAgreeStr;
    }

    @j.c.a.e
    public final BaseDialog getDlg() {
        return this.dlg;
    }

    @j.c.a.e
    public final BaseDialog getMDlgRed() {
        return this.mDlgRed;
    }

    @j.c.a.e
    public final ManualDetailPresenter getMPresenter() {
        return this.mPresenter;
    }

    public final void initListener() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        if (imageView == null) {
            i.q2.t.i0.f();
        }
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.mPicZ;
        if (imageView2 == null) {
            i.q2.t.i0.k("mPicZ");
        }
        if (imageView2 == null) {
            i.q2.t.i0.f();
        }
        imageView2.setOnClickListener(this);
        ImageView imageView3 = this.mPicF;
        if (imageView3 == null) {
            i.q2.t.i0.k("mPicF");
        }
        if (imageView3 == null) {
            i.q2.t.i0.f();
        }
        imageView3.setOnClickListener(this);
        TextView textView = this.mTvArgee;
        if (textView == null) {
            i.q2.t.i0.k("mTvArgee");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.mTvDisAgree;
        if (textView2 == null) {
            i.q2.t.i0.k("mTvDisAgree");
        }
        if (textView2 == null) {
            i.q2.t.i0.f();
        }
        textView2.setOnClickListener(this);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        View viewFindViewById = findViewById(R.id.iv_back);
        i.q2.t.i0.a((Object) viewFindViewById, "findViewById(R.id.iv_back)");
        this.mIvBack = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.tv_title);
        i.q2.t.i0.a((Object) viewFindViewById2, "findViewById(R.id.tv_title)");
        this.mTvTitle = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.tv_name);
        i.q2.t.i0.a((Object) viewFindViewById3, "findViewById(R.id.tv_name)");
        this.mTvName = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.tv_id_num);
        i.q2.t.i0.a((Object) viewFindViewById4, "findViewById(R.id.tv_id_num)");
        this.mTvIdNum = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.tv_phone_num);
        i.q2.t.i0.a((Object) viewFindViewById5, "findViewById(R.id.tv_phone_num)");
        this.mTvPhoneNum = (TextView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.iv_upload_pic_z);
        i.q2.t.i0.a((Object) viewFindViewById6, "findViewById(R.id.iv_upload_pic_z)");
        this.mPicZ = (ImageView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.iv_upload_pic_f);
        i.q2.t.i0.a((Object) viewFindViewById7, "findViewById(R.id.iv_upload_pic_f)");
        this.mPicF = (ImageView) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.tv_agree);
        i.q2.t.i0.a((Object) viewFindViewById8, "findViewById(R.id.tv_agree)");
        this.mTvArgee = (TextView) viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.tv_disagree);
        i.q2.t.i0.a((Object) viewFindViewById9, "findViewById(R.id.tv_disagree)");
        this.mTvDisAgree = (TextView) viewFindViewById9;
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u5f85\u5ba1\u6838\u8be6\u60c5");
        this.mPresenter = new ManualDetailPresenter(this.mActivity, this);
        this.checkBean = (CheckUserBean) getIntent().getSerializableExtra(util.p1.f15011c);
        initListener();
        initViewData();
    }

    public final void initViewData() {
        TextView textView = this.mTvName;
        if (textView == null) {
            i.q2.t.i0.k("mTvName");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\u59d3\u540d\uff1a");
        CheckUserBean checkUserBean = this.checkBean;
        sb.append(checkUserBean != null ? checkUserBean.getName() : null);
        textView.setText(sb.toString());
        TextView textView2 = this.mTvIdNum;
        if (textView2 == null) {
            i.q2.t.i0.k("mTvIdNum");
        }
        if (textView2 == null) {
            i.q2.t.i0.f();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\u8bc1\u4ef6\u53f7\uff1a");
        CheckUserBean checkUserBean2 = this.checkBean;
        sb2.append(checkUserBean2 != null ? checkUserBean2.getIdNumber() : null);
        textView2.setText(sb2.toString());
        TextView textView3 = this.mTvPhoneNum;
        if (textView3 == null) {
            i.q2.t.i0.k("mTvPhoneNum");
        }
        if (textView3 == null) {
            i.q2.t.i0.f();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\u624b\u673a\u53f7\uff1a");
        CheckUserBean checkUserBean3 = this.checkBean;
        sb3.append(checkUserBean3 != null ? checkUserBean3.getTelnumber() : null);
        textView3.setText(sb3.toString());
        CheckUserBean checkUserBean4 = this.checkBean;
        String frontImg = checkUserBean4 != null ? checkUserBean4.getFrontImg() : null;
        ImageView imageView = this.mPicZ;
        if (imageView == null) {
            i.q2.t.i0.k("mPicZ");
        }
        k.d.a(frontImg, imageView, Integer.valueOf(R.drawable.iv_id_z_default));
        CheckUserBean checkUserBean5 = this.checkBean;
        String backImg = checkUserBean5 != null ? checkUserBean5.getBackImg() : null;
        ImageView imageView2 = this.mPicF;
        if (imageView2 == null) {
            i.q2.t.i0.k("mPicF");
        }
        k.d.a(backImg, imageView2, Integer.valueOf(R.drawable.iv_id_f_default));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296808 */:
                a();
                break;
            case R.id.iv_upload_pic_f /* 2131296903 */:
                CheckUserBean checkUserBean = this.checkBean;
                showPreviewPic(checkUserBean != null ? checkUserBean.getBackImg() : null);
                break;
            case R.id.iv_upload_pic_z /* 2131296904 */:
                CheckUserBean checkUserBean2 = this.checkBean;
                showPreviewPic(checkUserBean2 != null ? checkUserBean2.getFrontImg() : null);
                break;
            case R.id.tv_agree /* 2131297568 */:
                ManualDetailPresenter manualDetailPresenter = this.mPresenter;
                if (manualDetailPresenter != null) {
                    CheckUserBean checkUserBean3 = this.checkBean;
                    manualDetailPresenter.submitaudit("1", checkUserBean3 != null ? checkUserBean3.getTelnumber() : null, "\u540c\u610f");
                }
                break;
            case R.id.tv_disagree /* 2131297697 */:
                disAgreeResonDlg();
                break;
        }
    }

    @Override // ui.callview.ManualDetailView
    public void onSuccess() {
        e2.a("\u64cd\u4f5c\u6210\u529f");
        finish();
    }

    @Override // ui.callview.ManualDetailView
    public void onSuccessOverrun() {
        overrunDialog();
    }

    @Override // ui.callview.ManualDetailView
    public void onSuccessUnbind() {
        BaseDialog baseDialog = this.mDlgRed;
        if (baseDialog == null) {
            i.q2.t.i0.f();
        }
        baseDialog.dismiss();
        finish();
    }

    public final void overrunDialog() {
        this.mDlgRed = util.f1.c(this.mActivity, "\u5f53\u524d\u8eab\u4efd\u4fe1\u606f\u5df2\u5b9e\u540d\u5176\u4ed6\u8d26\u53f7\uff0c\u662f\u5426\u6362\u7ed1\u65b0\u8d26\u53f7\uff0c\u5e76\u6ce8\u9500\u8001\u8d26\u53f7\uff1f", "\u9700\u786e\u8ba4\u5f53\u524d\u8eab\u4efd\u4fe1\u606f\u4e0e\u672c\u4eba\u4e00\u81f4\uff0c\u8bf7\u8c28\u614e\u64cd\u4f5c\uff01", "\u53d6\u6d88", "\u786e\u5b9a", new d());
    }

    public final void setCheckBean(@j.c.a.e CheckUserBean checkUserBean) {
        this.checkBean = checkUserBean;
    }

    public final void setCheckType(@j.c.a.e Integer num) {
        this.checkType = num;
    }

    public final void setDisAgreeStr(@j.c.a.e String str) {
        this.disAgreeStr = str;
    }

    public final void setDlg(@j.c.a.e BaseDialog baseDialog) {
        this.dlg = baseDialog;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_manual_detail;
    }

    public final void setMDlgRed(@j.c.a.e BaseDialog baseDialog) {
        this.mDlgRed = baseDialog;
    }

    public final void setMPresenter(@j.c.a.e ManualDetailPresenter manualDetailPresenter) {
        this.mPresenter = manualDetailPresenter;
    }

    public final void showPreviewPic(@j.c.a.e String str) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        LocalMedia localMedia = new LocalMedia();
        localMedia.setPath(str);
        arrayList.add(localMedia);
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f13585f, arrayList);
        intent.putExtra(PreviewPictureActivity.f13586g, 0);
        intent.putExtra(PreviewPictureActivity.f13587h, arrayList.size());
        intent.putExtra(PreviewPictureActivity.f13588i, str);
        startActivity(intent);
    }
}
