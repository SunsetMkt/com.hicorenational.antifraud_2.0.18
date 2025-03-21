package p388ui.activity;

import adapter.ReportPictureSelAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportWebsitBean;
import bean.UploadFileBean;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.taobao.agoo.p201a.p202a.AbstractC3059b;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5726c0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p357j.C5846e;
import p388ui.callview.ReporCriminalView;
import p388ui.presenter.ReportEdWebsitePresenter;
import p388ui.statusbarcompat.C7161b;
import util.C7257b1;
import util.C7268d1;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* compiled from: ReportWebsiteAddActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\r2\u0006\u0010Z\u001a\u00020[H\u0016J\u001e\u0010\\\u001a\u00020X2\u0006\u0010]\u001a\u00020\u00072\f\u0010^\u001a\b\u0012\u0004\u0012\u00020,0_H\u0002J\u0010\u0010`\u001a\u00020X2\u0006\u0010a\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020XH\u0016J<\u0010d\u001a\u00020\u00132\u0006\u0010N\u001a\u00020O2\u0006\u0010e\u001a\u0002092\u0016\u0010^\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0_J\b\u0010h\u001a\u00020XH\u0016J\"\u0010i\u001a\u00020X2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u00072\b\u0010k\u001a\u0004\u0018\u00010lH\u0016J\u0010\u0010m\u001a\u00020X2\u0006\u0010n\u001a\u00020oH\u0007J,\u0010p\u001a\u00020X2\u0010\u0010q\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010r2\b\u0010n\u001a\u0004\u0018\u00010o2\u0006\u0010s\u001a\u00020\u0007H\u0016J,\u0010t\u001a\u00020X2\u0006\u0010s\u001a\u00020\u00072\u001a\u0010u\u001a\u0016\u0012\u0004\u0012\u00020,\u0018\u00010+j\n\u0012\u0004\u0012\u00020,\u0018\u0001`-H\u0016J\u0018\u0010v\u001a\u00020[2\u0006\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020yH\u0016J\u0018\u0010z\u001a\u00020X2\u0006\u0010{\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\rH\u0016J\u0006\u0010|\u001a\u00020XJ\b\u0010}\u001a\u00020XH\u0014J\u0010\u0010~\u001a\u00020X2\u0006\u0010s\u001a\u00020\u0007H\u0016J\b\u0010\u007f\u001a\u00020\u0007H\u0016J$\u0010\u0080\u0001\u001a\u00020X2\u001b\u0010\u0081\u0001\u001a\u0016\u0012\u0004\u0012\u00020b\u0018\u00010+j\n\u0012\u0004\u0012\u00020b\u0018\u0001`-R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R!\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\tR\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00108\u001a\u0002098\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020A8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020A8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\u001c\u0010I\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010N\u001a\u00020O8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u000f\"\u0004\bV\u0010\u0011¨\u0006\u0082\u0001"}, m23546d2 = {"Lui/activity/ReportWebsiteAddActivity;", "Lui/activity/BasePicUploadActivity;", "Lui/callview/ReporCriminalView;", "Ladapter/ReportPictureSelAdapter$OnItemClickListener;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "()V", "CODE_PREVIEW", "", "getCODE_PREVIEW", "()I", "REQUEST_CODE_RECORD", "getREQUEST_CODE_RECORD", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mAdapter", "Ladapter/ReportPictureSelAdapter;", "getMAdapter", "()Ladapter/ReportPictureSelAdapter;", "setMAdapter", "(Ladapter/ReportPictureSelAdapter;)V", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mEtWebUrl", "Landroid/widget/EditText;", "getMEtWebUrl", "()Landroid/widget/EditText;", "setMEtWebUrl", "(Landroid/widget/EditText;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLocalMedia", "Ljava/util/ArrayList;", "Lcom/luck/picture/lib/entity/LocalMedia;", "Lkotlin/collections/ArrayList;", "getMLocalMedia", "()Ljava/util/ArrayList;", "mMaxSelectNum", "getMMaxSelectNum", "mPresenter", "Lui/presenter/ReportEdWebsitePresenter;", "getMPresenter", "()Lui/presenter/ReportEdWebsitePresenter;", "setMPresenter", "(Lui/presenter/ReportEdWebsitePresenter;)V", "mRecyView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mReqBean", "Lbean/ReportWebsitBean;", "mTvTip", "Landroid/widget/TextView;", "getMTvTip", "()Landroid/widget/TextView;", "setMTvTip", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "mWebBean", "getMWebBean", "()Lbean/ReportWebsitBean;", "setMWebBean", "(Lbean/ReportWebsitBean;)V", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScrollView", "()Landroidx/core/widget/NestedScrollView;", "setScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "suspFileId", "getSuspFileId", "setSuspFileId", "changeBtnCommit", "", "text", "enabled", "", "checkPermission", "requestCode", "localMediaList", "", "createUpLoadInfo", "bean", "Lbean/UploadFileBean;", "initPage", "initRecycle", "recyclerView", "uploadStateInfoList", "Lbean/UploadStateInfo;", "notifyAdapter", "onActivityResult", AbstractC3059b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onClick", "view", "Landroid/view/View;", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "position", "onItemClickListener", "myLiveList", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onSuccessHandle", "type", "onkeyback", "pageFileFinish", "removeLocalData", "setLayoutView", "transLocalMedia", "picBeans", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReportWebsiteAddActivity extends BasePicUploadActivity implements ReporCriminalView, ReportPictureSelAdapter.InterfaceC0069a, BaseQuickAdapter.InterfaceC1895i {

    @InterfaceC5817e
    private ReportPictureSelAdapter mAdapter;

    @BindView(C2113R.id.btn_commit)
    @InterfaceC5816d
    public Button mBtnCommit;

    @BindView(C2113R.id.et_weburl)
    @InterfaceC5816d
    public EditText mEtWebUrl;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @InterfaceC5817e
    private ReportEdWebsitePresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    @InterfaceC5816d
    public RecyclerView mRecyView;
    private ReportWebsitBean mReqBean;

    @BindView(C2113R.id.tv_tip)
    @InterfaceC5816d
    public TextView mTvTip;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @InterfaceC5817e
    private ReportWebsitBean mWebBean;

    @BindView(C2113R.id.ns_layout)
    @InterfaceC5816d
    public NestedScrollView scrollView;
    private final int CODE_PREVIEW = 1000;
    private final int REQUEST_CODE_RECORD = 1001;
    private final int mMaxSelectNum = 6;

    @InterfaceC5816d
    private String caseInfoId = "";

    @InterfaceC5816d
    private final ArrayList<LocalMedia> mLocalMedia = new ArrayList<>();

    @InterfaceC5816d
    private String suspFileId = "";

    /* compiled from: ReportWebsiteAddActivity.kt */
    /* renamed from: ui.activity.ReportWebsiteAddActivity$a */
    public static final class C6542a implements PermissionsListener {

        /* renamed from: b */
        final /* synthetic */ List f22992b;

        /* renamed from: c */
        final /* synthetic */ int f22993c;

        C6542a(List list, int i2) {
            this.f22992b = list;
            this.f22993c = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(@InterfaceC5816d List<String> list, boolean z) {
            C5544i0.m22546f(list, "deniedPermissions");
            C7310c.m26513a(ReportWebsiteAddActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(ReportWebsiteAddActivity.this.mActivity, 200L, PictureMimeType.ofImage(), ReportWebsiteAddActivity.this.getMMaxSelectNum() - this.f22992b.size()).forResult(this.f22993c);
        }
    }

    /* compiled from: ReportWebsiteAddActivity.kt */
    /* renamed from: ui.activity.ReportWebsiteAddActivity$b */
    public static final class C6543b implements IClickListener {
        C6543b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportWebsiteAddActivity.this.cancleUpLoad();
            ReportWebsiteAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* compiled from: ReportWebsiteAddActivity.kt */
    /* renamed from: ui.activity.ReportWebsiteAddActivity$c */
    static final class RunnableC6544c implements Runnable {
        RunnableC6544c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReportWebsiteAddActivity.access$getMReqBean$p(ReportWebsiteAddActivity.this).setUrlDetails(new ArrayList<>());
            ArrayList<UploadFileBean> arrayList = ReportWebsiteAddActivity.this.mUploadPicList;
            if (arrayList != null && arrayList.size() > 0) {
                ReportWebsiteAddActivity.access$getMReqBean$p(ReportWebsiteAddActivity.this).getUrlDetails().addAll(ReportWebsiteAddActivity.this.mUploadPicList);
            }
            if (ReportWebsiteAddActivity.this.getMWebBean() == null) {
                ReportEdWebsitePresenter mPresenter = ReportWebsiteAddActivity.this.getMPresenter();
                if (mPresenter != null) {
                    mPresenter.surveyAddCaseWebUrl(ReportWebsiteAddActivity.access$getMReqBean$p(ReportWebsiteAddActivity.this));
                    return;
                }
                return;
            }
            ReportWebsitBean access$getMReqBean$p = ReportWebsiteAddActivity.access$getMReqBean$p(ReportWebsiteAddActivity.this);
            ReportWebsitBean mWebBean = ReportWebsiteAddActivity.this.getMWebBean();
            access$getMReqBean$p.setUrlInfoID(mWebBean != null ? mWebBean.getUrlInfoID() : null);
            ReportEdWebsitePresenter mPresenter2 = ReportWebsiteAddActivity.this.getMPresenter();
            if (mPresenter2 != null) {
                mPresenter2.surveyAddCaseWebUrl(ReportWebsiteAddActivity.access$getMReqBean$p(ReportWebsiteAddActivity.this));
            }
        }
    }

    public static final /* synthetic */ ReportWebsitBean access$getMReqBean$p(ReportWebsiteAddActivity reportWebsiteAddActivity) {
        ReportWebsitBean reportWebsitBean = reportWebsiteAddActivity.mReqBean;
        if (reportWebsitBean == null) {
            C5544i0.m22554k("mReqBean");
        }
        return reportWebsitBean;
    }

    private final void checkPermission(int i2, List<? extends LocalMedia> list) {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6542a(list, i2));
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public void changeBtnCommit(@InterfaceC5816d String str, boolean z) {
        C5544i0.m22546f(str, "text");
        Button button = this.mBtnCommit;
        if (button == null) {
            C5544i0.m22554k("mBtnCommit");
        }
        button.setEnabled(z);
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public void createUpLoadInfo(@InterfaceC5816d UploadFileBean uploadFileBean) {
        C5544i0.m22546f(uploadFileBean, "bean");
        uploadFileBean.setId(this.caseInfoId);
        uploadFileBean.setUrlDetailID(this.suspFileId);
    }

    public final int getCODE_PREVIEW() {
        return this.CODE_PREVIEW;
    }

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @InterfaceC5817e
    public final ReportPictureSelAdapter getMAdapter() {
        return this.mAdapter;
    }

    @InterfaceC5816d
    public final Button getMBtnCommit() {
        Button button = this.mBtnCommit;
        if (button == null) {
            C5544i0.m22554k("mBtnCommit");
        }
        return button;
    }

    @InterfaceC5816d
    public final EditText getMEtWebUrl() {
        EditText editText = this.mEtWebUrl;
        if (editText == null) {
            C5544i0.m22554k("mEtWebUrl");
        }
        return editText;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ArrayList<LocalMedia> getMLocalMedia() {
        return this.mLocalMedia;
    }

    public final int getMMaxSelectNum() {
        return this.mMaxSelectNum;
    }

    @InterfaceC5817e
    public final ReportEdWebsitePresenter getMPresenter() {
        return this.mPresenter;
    }

    @InterfaceC5816d
    public final RecyclerView getMRecyView() {
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyView");
        }
        return recyclerView;
    }

    @InterfaceC5816d
    public final TextView getMTvTip() {
        TextView textView = this.mTvTip;
        if (textView == null) {
            C5544i0.m22554k("mTvTip");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @InterfaceC5817e
    public final ReportWebsitBean getMWebBean() {
        return this.mWebBean;
    }

    public final int getREQUEST_CODE_RECORD() {
        return this.REQUEST_CODE_RECORD;
    }

    @InterfaceC5816d
    public final NestedScrollView getScrollView() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            C5544i0.m22554k("scrollView");
        }
        return nestedScrollView;
    }

    @InterfaceC5816d
    public final String getSuspFileId() {
        return this.suspFileId;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, true);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("网址信息");
        TextView textView2 = this.mTvTip;
        if (textView2 == null) {
            C5544i0.m22554k("mTvTip");
        }
        if (textView2 == null) {
            C5544i0.m22545f();
        }
        textView2.setText("最多可选择" + this.mMaxSelectNum + "张图片");
        EditText editText = this.mEtWebUrl;
        if (editText == null) {
            C5544i0.m22554k("mEtWebUrl");
        }
        C7268d1.m26317c(editText);
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mWebBean = (ReportWebsitBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        this.mPresenter = new ReportEdWebsitePresenter(this.mActivity, this);
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            C5544i0.m22554k("scrollView");
        }
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyView");
        }
        ArrayList<LocalMedia> arrayList = this.mLocalMedia;
        ArrayList<UploadStateInfo> arrayList2 = this.mUploadStateList;
        C5544i0.m22521a((Object) arrayList2, "mUploadStateList");
        this.mAdapter = initRecycle(nestedScrollView, recyclerView, arrayList, arrayList2);
        if (this.mWebBean != null) {
            EditText editText2 = this.mEtWebUrl;
            if (editText2 == null) {
                C5544i0.m22554k("mEtWebUrl");
            }
            ReportWebsitBean reportWebsitBean = this.mWebBean;
            editText2.setText(reportWebsitBean != null ? reportWebsitBean.getUrl() : null);
            ReportWebsitBean reportWebsitBean2 = this.mWebBean;
            transLocalMedia(reportWebsitBean2 != null ? reportWebsitBean2.getUrlDetails() : null);
        }
    }

    @InterfaceC5816d
    public final ReportPictureSelAdapter initRecycle(@InterfaceC5816d NestedScrollView nestedScrollView, @InterfaceC5816d RecyclerView recyclerView, @InterfaceC5816d ArrayList<LocalMedia> arrayList, @InterfaceC5816d List<? extends UploadStateInfo> list) {
        C5544i0.m22546f(nestedScrollView, "scrollView");
        C5544i0.m22546f(recyclerView, "recyclerView");
        C5544i0.m22546f(arrayList, "localMediaList");
        C5544i0.m22546f(list, "uploadStateInfoList");
        recycleViewListener(nestedScrollView, recyclerView);
        ReportPictureSelAdapter m271a = ReportPictureSelAdapter.m271a(this.mActivity, recyclerView, this.mMaxSelectNum, this, this, arrayList, list);
        C5544i0.m22521a((Object) m271a, "ReportPictureSelAdapter.…List,uploadStateInfoList)");
        return m271a;
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public void notifyAdapter() {
        super.notifyAdapter();
        if (this.mLocalMedia == null || this.isScroll) {
            this.isScrollOver = true;
            return;
        }
        int i2 = this.mCurrentUploadIndex;
        if (i2 < 0) {
            ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
            if (reportPictureSelAdapter != null) {
                reportPictureSelAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (this.isScrollOver) {
            ReportPictureSelAdapter reportPictureSelAdapter2 = this.mAdapter;
            if (reportPictureSelAdapter2 != null) {
                reportPictureSelAdapter2.notifyItemRangeChanged(0, i2);
            }
            this.isScrollOver = false;
            return;
        }
        ReportPictureSelAdapter reportPictureSelAdapter3 = this.mAdapter;
        if (reportPictureSelAdapter3 != null) {
            reportPictureSelAdapter3.notifyItemChanged(i2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @InterfaceC5817e Intent intent) {
        List<LocalMedia> obtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != this.REQUEST_CODE_RECORD || (obtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || obtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(obtainMultipleResult);
        }
        List<LocalMedia> m26741a = C7337y1.m26741a(obtainMultipleResult);
        C5544i0.m22521a((Object) m26741a, "newList");
        int size = m26741a.size();
        for (int i4 = 0; i4 < size; i4++) {
            UploadFileBean uploadFileBean = new UploadFileBean();
            uploadFileBean.setLocalPath(m26741a.get(i4).getPath());
            uploadFileBean.setFileName(m26741a.get(i4).getFileName());
            this.mLocalMedia.add(m26741a.get(i4));
            this.mUploadStateList.add(new UploadStateInfo());
            this.mUploadPicList.add(uploadFileBean);
        }
        ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
        if (reportPictureSelAdapter != null) {
            reportPictureSelAdapter.notifyDataSetChanged();
        }
        changeBtnCommit("确定", true);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_commit})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_commit) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            onkeyback();
            return;
        }
        EditText editText = this.mEtWebUrl;
        if (editText == null) {
            C5544i0.m22554k("mEtWebUrl");
        }
        String obj = editText.getText().toString();
        if (obj == null) {
            throw new C5226e1("null cannot be cast to non-null type kotlin.CharSequence");
        }
        if (TextUtils.isEmpty(C5726c0.m23799l((CharSequence) obj).toString())) {
            C7331w1.m26688a("请填写涉诈网址/IP");
            return;
        }
        if (this.mLocalMedia.size() <= 0) {
            C7331w1.m26688a("请至少添加一张截图");
            return;
        }
        this.mReqBean = new ReportWebsitBean();
        ReportWebsitBean reportWebsitBean = this.mReqBean;
        if (reportWebsitBean == null) {
            C5544i0.m22554k("mReqBean");
        }
        reportWebsitBean.setUrl(obj);
        ReportWebsitBean reportWebsitBean2 = this.mReqBean;
        if (reportWebsitBean2 == null) {
            C5544i0.m22554k("mReqBean");
        }
        reportWebsitBean2.setCaseInfoID(this.caseInfoId);
        if (this.mLocalMedia.size() > 0) {
            commitDeal();
            return;
        }
        if (this.mWebBean == null) {
            ReportEdWebsitePresenter reportEdWebsitePresenter = this.mPresenter;
            if (reportEdWebsitePresenter != null) {
                ReportWebsitBean reportWebsitBean3 = this.mReqBean;
                if (reportWebsitBean3 == null) {
                    C5544i0.m22554k("mReqBean");
                }
                reportEdWebsitePresenter.surveyAddCaseWebUrl(reportWebsitBean3);
                return;
            }
            return;
        }
        ReportWebsitBean reportWebsitBean4 = this.mReqBean;
        if (reportWebsitBean4 == null) {
            C5544i0.m22554k("mReqBean");
        }
        ReportWebsitBean reportWebsitBean5 = this.mWebBean;
        reportWebsitBean4.setUrlInfoID(reportWebsitBean5 != null ? reportWebsitBean5.getUrlInfoID() : null);
        ReportEdWebsitePresenter reportEdWebsitePresenter2 = this.mPresenter;
        if (reportEdWebsitePresenter2 != null) {
            ReportWebsitBean reportWebsitBean6 = this.mReqBean;
            if (reportWebsitBean6 == null) {
                C5544i0.m22554k("mReqBean");
            }
            reportEdWebsitePresenter2.surveyAddCaseWebUrl(reportWebsitBean6);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(@InterfaceC5817e BaseQuickAdapter<?, ?> baseQuickAdapter, @InterfaceC5817e View view, int i2) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf == null || valueOf.intValue() != C2113R.id.iv_clear || rejuctOperation(false)) {
            return;
        }
        deleteDialog(i2);
    }

    @Override // adapter.ReportPictureSelAdapter.InterfaceC0069a
    public void onItemClickListener(int i2, @InterfaceC5817e ArrayList<LocalMedia> arrayList) {
        LocalMedia localMedia;
        if (isDouble()) {
            return;
        }
        if (arrayList != null && i2 == arrayList.size()) {
            if (rejuctOperation(false)) {
                return;
            }
            checkPermission(this.REQUEST_CODE_RECORD, this.mLocalMedia);
            return;
        }
        String path = (arrayList == null || (localMedia = arrayList.get(i2)) == null) ? null : localMedia.getPath();
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f22711f, arrayList);
        intent.putExtra(PreviewPictureActivity.f22712g, i2);
        intent.putExtra(PreviewPictureActivity.f22713h, arrayList != null ? Integer.valueOf(arrayList.size()) : null);
        intent.putExtra(PreviewPictureActivity.f22714i, path);
        startActivityForResult(intent, this.CODE_PREVIEW);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @InterfaceC5816d KeyEvent keyEvent) {
        C5544i0.m22546f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // p388ui.callview.ReporCriminalView
    public void onSuccessHandle(int i2, @InterfaceC5816d String str) {
        C5544i0.m22546f(str, "suspFileId");
        this.suspFileId = str;
        if (this.mWebBean != null) {
            C7331w1.m26688a("修改成功");
        } else {
            C7331w1.m26688a("添加成功");
        }
        finish();
    }

    public final void onkeyback() {
        C7257b1.m26211b(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", new C6543b());
    }

    @Override // p388ui.activity.BasePicUploadActivity
    protected void pageFileFinish() {
        super.pageFileFinish();
        runOnUiThread(new RunnableC6544c());
    }

    @Override // p388ui.activity.BasePicUploadActivity
    public void removeLocalData(int i2) {
        this.mLocalMedia.remove(i2);
        ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
        if (reportPictureSelAdapter != null) {
            reportPictureSelAdapter.notifyDataSetChanged();
        }
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_report_weburl_add;
    }

    public final void setMAdapter(@InterfaceC5817e ReportPictureSelAdapter reportPictureSelAdapter) {
        this.mAdapter = reportPictureSelAdapter;
    }

    public final void setMBtnCommit(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMEtWebUrl(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtWebUrl = editText;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@InterfaceC5817e ReportEdWebsitePresenter reportEdWebsitePresenter) {
        this.mPresenter = reportEdWebsitePresenter;
    }

    public final void setMRecyView(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecyView = recyclerView;
    }

    public final void setMTvTip(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTip = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMWebBean(@InterfaceC5817e ReportWebsitBean reportWebsitBean) {
        this.mWebBean = reportWebsitBean;
    }

    public final void setScrollView(@InterfaceC5816d NestedScrollView nestedScrollView) {
        C5544i0.m22546f(nestedScrollView, "<set-?>");
        this.scrollView = nestedScrollView;
    }

    public final void setSuspFileId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.suspFileId = str;
    }

    public final void transLocalMedia(@InterfaceC5817e ArrayList<UploadFileBean> arrayList) {
        if (arrayList != null) {
            this.mUploadPicList.clear();
            Iterator<UploadFileBean> it = arrayList.iterator();
            while (it.hasNext()) {
                UploadFileBean next = it.next();
                this.mUploadPicList.add(next);
                UploadStateInfo uploadStateInfo = new UploadStateInfo();
                uploadStateInfo.setUploadState(2);
                this.mUploadStateList.add(uploadStateInfo);
                LocalMedia localMedia = new LocalMedia();
                C5544i0.m22521a((Object) next, "bean");
                localMedia.setPath(next.getFilePath());
                localMedia.setFileName(next.getFileName());
                this.mLocalMedia.add(localMedia);
            }
            ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
            if (reportPictureSelAdapter != null) {
                reportPictureSelAdapter.notifyDataSetChanged();
            }
        }
    }
}
