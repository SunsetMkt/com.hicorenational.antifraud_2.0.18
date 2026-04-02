package ui.activity;

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
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.List;
import ui.callview.ReporCriminalView;
import ui.presenter.ReportEdWebsitePresenter;
import util.e2;
import util.g2;

/* JADX INFO: compiled from: ReportWebsiteAddActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\r2\u0006\u0010Z\u001a\u00020[H\u0016J\u001e\u0010\\\u001a\u00020X2\u0006\u0010]\u001a\u00020\u00072\f\u0010^\u001a\b\u0012\u0004\u0012\u00020,0_H\u0002J\u0010\u0010`\u001a\u00020X2\u0006\u0010a\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020XH\u0016J<\u0010d\u001a\u00020\u00132\u0006\u0010N\u001a\u00020O2\u0006\u0010e\u001a\u0002092\u0016\u0010^\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0_J\b\u0010h\u001a\u00020XH\u0016J\"\u0010i\u001a\u00020X2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u00072\b\u0010k\u001a\u0004\u0018\u00010lH\u0016J\u0010\u0010m\u001a\u00020X2\u0006\u0010n\u001a\u00020oH\u0007J,\u0010p\u001a\u00020X2\u0010\u0010q\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010r2\b\u0010n\u001a\u0004\u0018\u00010o2\u0006\u0010s\u001a\u00020\u0007H\u0016J,\u0010t\u001a\u00020X2\u0006\u0010s\u001a\u00020\u00072\u001a\u0010u\u001a\u0016\u0012\u0004\u0012\u00020,\u0018\u00010+j\n\u0012\u0004\u0012\u00020,\u0018\u0001`-H\u0016J\u0018\u0010v\u001a\u00020[2\u0006\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020yH\u0016J\u0018\u0010z\u001a\u00020X2\u0006\u0010{\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\rH\u0016J\u0006\u0010|\u001a\u00020XJ\b\u0010}\u001a\u00020XH\u0014J\u0010\u0010~\u001a\u00020X2\u0006\u0010s\u001a\u00020\u0007H\u0016J\b\u0010\u007f\u001a\u00020\u0007H\u0016J$\u0010\u0080\u0001\u001a\u00020X2\u001b\u0010\u0081\u0001\u001a\u0016\u0012\u0004\u0012\u00020b\u0018\u00010+j\n\u0012\u0004\u0012\u00020b\u0018\u0001`-R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R!\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\tR\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00108\u001a\u0002098\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020A8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020A8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\u001c\u0010I\u001a\u0004\u0018\u00010?X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010N\u001a\u00020O8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u000f\"\u0004\bV\u0010\u0011\u00a8\u0006\u0082\u0001"}, d2 = {"Lui/activity/ReportWebsiteAddActivity;", "Lui/activity/BasePicUploadActivity;", "Lui/callview/ReporCriminalView;", "Ladapter/ReportPictureSelAdapter$OnItemClickListener;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "()V", "CODE_PREVIEW", "", "getCODE_PREVIEW", "()I", "REQUEST_CODE_RECORD", "getREQUEST_CODE_RECORD", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mAdapter", "Ladapter/ReportPictureSelAdapter;", "getMAdapter", "()Ladapter/ReportPictureSelAdapter;", "setMAdapter", "(Ladapter/ReportPictureSelAdapter;)V", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mEtWebUrl", "Landroid/widget/EditText;", "getMEtWebUrl", "()Landroid/widget/EditText;", "setMEtWebUrl", "(Landroid/widget/EditText;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLocalMedia", "Ljava/util/ArrayList;", "Lcom/luck/picture/lib/entity/LocalMedia;", "Lkotlin/collections/ArrayList;", "getMLocalMedia", "()Ljava/util/ArrayList;", "mMaxSelectNum", "getMMaxSelectNum", "mPresenter", "Lui/presenter/ReportEdWebsitePresenter;", "getMPresenter", "()Lui/presenter/ReportEdWebsitePresenter;", "setMPresenter", "(Lui/presenter/ReportEdWebsitePresenter;)V", "mRecyView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mReqBean", "Lbean/ReportWebsitBean;", "mTvTip", "Landroid/widget/TextView;", "getMTvTip", "()Landroid/widget/TextView;", "setMTvTip", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "mWebBean", "getMWebBean", "()Lbean/ReportWebsitBean;", "setMWebBean", "(Lbean/ReportWebsitBean;)V", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScrollView", "()Landroidx/core/widget/NestedScrollView;", "setScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "suspFileId", "getSuspFileId", "setSuspFileId", "changeBtnCommit", "", "text", "enabled", "", "checkPermission", "requestCode", "localMediaList", "", "createUpLoadInfo", "bean", "Lbean/UploadFileBean;", "initPage", "initRecycle", "recyclerView", "uploadStateInfoList", "Lbean/UploadStateInfo;", "notifyAdapter", "onActivityResult", com.taobao.agoo.a.a.b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onClick", "view", "Landroid/view/View;", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "position", "onItemClickListener", "myLiveList", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onSuccessHandle", "type", "onkeyback", "pageFileFinish", "removeLocalData", "setLayoutView", "transLocalMedia", "picBeans", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class ReportWebsiteAddActivity extends BasePicUploadActivity implements ReporCriminalView, ReportPictureSelAdapter.a, BaseQuickAdapter.i {

    @j.c.a.e
    private ReportPictureSelAdapter mAdapter;

    @BindView(R.id.btn_commit)
    @j.c.a.d
    public Button mBtnCommit;

    @BindView(R.id.et_weburl)
    @j.c.a.d
    public EditText mEtWebUrl;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @j.c.a.e
    private ReportEdWebsitePresenter mPresenter;

    @BindView(R.id.recyclerview)
    @j.c.a.d
    public RecyclerView mRecyView;
    private ReportWebsitBean mReqBean;

    @BindView(R.id.tv_tip)
    @j.c.a.d
    public TextView mTvTip;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @j.c.a.e
    private ReportWebsitBean mWebBean;

    @BindView(R.id.ns_layout)
    @j.c.a.d
    public NestedScrollView scrollView;
    private final int CODE_PREVIEW = 1000;
    private final int REQUEST_CODE_RECORD = 1001;
    private final int mMaxSelectNum = 6;

    @j.c.a.d
    private String caseInfoId = "";

    @j.c.a.d
    private final ArrayList<LocalMedia> mLocalMedia = new ArrayList<>();

    @j.c.a.d
    private String suspFileId = "";

    /* JADX INFO: compiled from: ReportWebsiteAddActivity.kt */
    public static final class a implements PermissionsListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f13740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f13741c;

        a(List list, int i2) {
            this.f13740b = list;
            this.f13741c = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(@j.c.a.d List<String> list, boolean z) {
            i.q2.t.i0.f(list, "deniedPermissions");
            util.permissionutil.c.a(ReportWebsiteAddActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            k.e.a(ReportWebsiteAddActivity.this.mActivity, 200L, PictureMimeType.ofImage(), ReportWebsiteAddActivity.this.getMMaxSelectNum() - this.f13740b.size()).forResult(this.f13741c);
        }
    }

    /* JADX INFO: compiled from: ReportWebsiteAddActivity.kt */
    public static final class b implements IClickListener {
        b() {
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

    /* JADX INFO: compiled from: ReportWebsiteAddActivity.kt */
    static final class c implements Runnable {
        c() {
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
            ReportWebsitBean reportWebsitBeanAccess$getMReqBean$p = ReportWebsiteAddActivity.access$getMReqBean$p(ReportWebsiteAddActivity.this);
            ReportWebsitBean mWebBean = ReportWebsiteAddActivity.this.getMWebBean();
            reportWebsitBeanAccess$getMReqBean$p.setUrlInfoID(mWebBean != null ? mWebBean.getUrlInfoID() : null);
            ReportEdWebsitePresenter mPresenter2 = ReportWebsiteAddActivity.this.getMPresenter();
            if (mPresenter2 != null) {
                mPresenter2.surveyAddCaseWebUrl(ReportWebsiteAddActivity.access$getMReqBean$p(ReportWebsiteAddActivity.this));
            }
        }
    }

    public static final /* synthetic */ ReportWebsitBean access$getMReqBean$p(ReportWebsiteAddActivity reportWebsiteAddActivity) {
        ReportWebsitBean reportWebsitBean = reportWebsiteAddActivity.mReqBean;
        if (reportWebsitBean == null) {
            i.q2.t.i0.k("mReqBean");
        }
        return reportWebsitBean;
    }

    private final void checkPermission(int i2, List<? extends LocalMedia> list) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new a(list, i2));
    }

    @Override // ui.activity.BasePicUploadActivity
    public void changeBtnCommit(@j.c.a.d String str, boolean z) {
        i.q2.t.i0.f(str, "text");
        Button button = this.mBtnCommit;
        if (button == null) {
            i.q2.t.i0.k("mBtnCommit");
        }
        button.setEnabled(z);
    }

    @Override // ui.activity.BasePicUploadActivity
    public void createUpLoadInfo(@j.c.a.d UploadFileBean uploadFileBean) {
        i.q2.t.i0.f(uploadFileBean, "bean");
        uploadFileBean.setId(this.caseInfoId);
        uploadFileBean.setUrlDetailID(this.suspFileId);
    }

    public final int getCODE_PREVIEW() {
        return this.CODE_PREVIEW;
    }

    @j.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @j.c.a.e
    public final ReportPictureSelAdapter getMAdapter() {
        return this.mAdapter;
    }

    @j.c.a.d
    public final Button getMBtnCommit() {
        Button button = this.mBtnCommit;
        if (button == null) {
            i.q2.t.i0.k("mBtnCommit");
        }
        return button;
    }

    @j.c.a.d
    public final EditText getMEtWebUrl() {
        EditText editText = this.mEtWebUrl;
        if (editText == null) {
            i.q2.t.i0.k("mEtWebUrl");
        }
        return editText;
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.d
    public final ArrayList<LocalMedia> getMLocalMedia() {
        return this.mLocalMedia;
    }

    public final int getMMaxSelectNum() {
        return this.mMaxSelectNum;
    }

    @j.c.a.e
    public final ReportEdWebsitePresenter getMPresenter() {
        return this.mPresenter;
    }

    @j.c.a.d
    public final RecyclerView getMRecyView() {
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            i.q2.t.i0.k("mRecyView");
        }
        return recyclerView;
    }

    @j.c.a.d
    public final TextView getMTvTip() {
        TextView textView = this.mTvTip;
        if (textView == null) {
            i.q2.t.i0.k("mTvTip");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @j.c.a.e
    public final ReportWebsitBean getMWebBean() {
        return this.mWebBean;
    }

    public final int getREQUEST_CODE_RECORD() {
        return this.REQUEST_CODE_RECORD;
    }

    @j.c.a.d
    public final NestedScrollView getScrollView() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            i.q2.t.i0.k("scrollView");
        }
        return nestedScrollView;
    }

    @j.c.a.d
    public final String getSuspFileId() {
        return this.suspFileId;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u7f51\u5740\u4fe1\u606f");
        TextView textView2 = this.mTvTip;
        if (textView2 == null) {
            i.q2.t.i0.k("mTvTip");
        }
        if (textView2 == null) {
            i.q2.t.i0.f();
        }
        textView2.setText("\u6700\u591a\u53ef\u9009\u62e9" + this.mMaxSelectNum + "\u5f20\u56fe\u7247");
        EditText editText = this.mEtWebUrl;
        if (editText == null) {
            i.q2.t.i0.k("mEtWebUrl");
        }
        util.h1.c(editText);
        String stringExtra = getIntent().getStringExtra(util.p1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mWebBean = (ReportWebsitBean) getIntent().getSerializableExtra(util.p1.f15011c);
        this.mPresenter = new ReportEdWebsitePresenter(this.mActivity, this);
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            i.q2.t.i0.k("scrollView");
        }
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            i.q2.t.i0.k("mRecyView");
        }
        ArrayList<LocalMedia> arrayList = this.mLocalMedia;
        ArrayList<UploadStateInfo> arrayList2 = this.mUploadStateList;
        i.q2.t.i0.a((Object) arrayList2, "mUploadStateList");
        this.mAdapter = initRecycle(nestedScrollView, recyclerView, arrayList, arrayList2);
        if (this.mWebBean != null) {
            EditText editText2 = this.mEtWebUrl;
            if (editText2 == null) {
                i.q2.t.i0.k("mEtWebUrl");
            }
            ReportWebsitBean reportWebsitBean = this.mWebBean;
            editText2.setText(reportWebsitBean != null ? reportWebsitBean.getUrl() : null);
            ReportWebsitBean reportWebsitBean2 = this.mWebBean;
            transLocalMedia(reportWebsitBean2 != null ? reportWebsitBean2.getUrlDetails() : null);
        }
    }

    @j.c.a.d
    public final ReportPictureSelAdapter initRecycle(@j.c.a.d NestedScrollView nestedScrollView, @j.c.a.d RecyclerView recyclerView, @j.c.a.d ArrayList<LocalMedia> arrayList, @j.c.a.d List<? extends UploadStateInfo> list) {
        i.q2.t.i0.f(nestedScrollView, "scrollView");
        i.q2.t.i0.f(recyclerView, "recyclerView");
        i.q2.t.i0.f(arrayList, "localMediaList");
        i.q2.t.i0.f(list, "uploadStateInfoList");
        recycleViewListener(nestedScrollView, recyclerView);
        ReportPictureSelAdapter reportPictureSelAdapterA = ReportPictureSelAdapter.a(this.mActivity, recyclerView, this.mMaxSelectNum, this, this, arrayList, list);
        i.q2.t.i0.a((Object) reportPictureSelAdapterA, "ReportPictureSelAdapter.\u2026List,uploadStateInfoList)");
        return reportPictureSelAdapterA;
    }

    @Override // ui.activity.BasePicUploadActivity
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
    public void onActivityResult(int i2, int i3, @j.c.a.e Intent intent) {
        List<LocalMedia> listObtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != this.REQUEST_CODE_RECORD || (listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || listObtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(listObtainMultipleResult);
        }
        List<LocalMedia> listA = g2.a(listObtainMultipleResult);
        i.q2.t.i0.a((Object) listA, "newList");
        int size = listA.size();
        for (int i4 = 0; i4 < size; i4++) {
            UploadFileBean uploadFileBean = new UploadFileBean();
            uploadFileBean.setLocalPath(listA.get(i4).getPath());
            uploadFileBean.setFileName(listA.get(i4).getFileName());
            this.mLocalMedia.add(listA.get(i4));
            this.mUploadStateList.add(new UploadStateInfo());
            this.mUploadPicList.add(uploadFileBean);
        }
        ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
        if (reportPictureSelAdapter != null) {
            reportPictureSelAdapter.notifyDataSetChanged();
        }
        changeBtnCommit("\u786e\u5b9a", true);
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_commit) {
            if (id != R.id.iv_back) {
                return;
            }
            onkeyback();
            return;
        }
        EditText editText = this.mEtWebUrl;
        if (editText == null) {
            i.q2.t.i0.k("mEtWebUrl");
        }
        String string = editText.getText().toString();
        if (string == null) {
            throw new i.e1("null cannot be cast to non-null type kotlin.CharSequence");
        }
        if (TextUtils.isEmpty(i.z2.c0.l((CharSequence) string).toString())) {
            e2.a("\u8bf7\u586b\u5199\u6d89\u8bc8\u7f51\u5740/IP");
            return;
        }
        if (this.mLocalMedia.size() <= 0) {
            e2.a("\u8bf7\u81f3\u5c11\u6dfb\u52a0\u4e00\u5f20\u622a\u56fe");
            return;
        }
        this.mReqBean = new ReportWebsitBean();
        ReportWebsitBean reportWebsitBean = this.mReqBean;
        if (reportWebsitBean == null) {
            i.q2.t.i0.k("mReqBean");
        }
        reportWebsitBean.setUrl(string);
        ReportWebsitBean reportWebsitBean2 = this.mReqBean;
        if (reportWebsitBean2 == null) {
            i.q2.t.i0.k("mReqBean");
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
                    i.q2.t.i0.k("mReqBean");
                }
                reportEdWebsitePresenter.surveyAddCaseWebUrl(reportWebsitBean3);
                return;
            }
            return;
        }
        ReportWebsitBean reportWebsitBean4 = this.mReqBean;
        if (reportWebsitBean4 == null) {
            i.q2.t.i0.k("mReqBean");
        }
        ReportWebsitBean reportWebsitBean5 = this.mWebBean;
        reportWebsitBean4.setUrlInfoID(reportWebsitBean5 != null ? reportWebsitBean5.getUrlInfoID() : null);
        ReportEdWebsitePresenter reportEdWebsitePresenter2 = this.mPresenter;
        if (reportEdWebsitePresenter2 != null) {
            ReportWebsitBean reportWebsitBean6 = this.mReqBean;
            if (reportWebsitBean6 == null) {
                i.q2.t.i0.k("mReqBean");
            }
            reportEdWebsitePresenter2.surveyAddCaseWebUrl(reportWebsitBean6);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(@j.c.a.e BaseQuickAdapter<?, ?> baseQuickAdapter, @j.c.a.e View view, int i2) {
        Integer numValueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (numValueOf == null || numValueOf.intValue() != R.id.iv_clear || rejuctOperation(false)) {
            return;
        }
        deleteDialog(i2);
    }

    @Override // adapter.ReportPictureSelAdapter.a
    public void onItemClickListener(int i2, @j.c.a.e ArrayList<LocalMedia> arrayList) {
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
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f13585f, arrayList);
        intent.putExtra(PreviewPictureActivity.f13586g, i2);
        intent.putExtra(PreviewPictureActivity.f13587h, arrayList != null ? Integer.valueOf(arrayList.size()) : null);
        intent.putExtra(PreviewPictureActivity.f13588i, path);
        startActivityForResult(intent, this.CODE_PREVIEW);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @j.c.a.d KeyEvent keyEvent) {
        i.q2.t.i0.f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // ui.callview.ReporCriminalView
    public void onSuccessHandle(int i2, @j.c.a.d String str) {
        i.q2.t.i0.f(str, "suspFileId");
        this.suspFileId = str;
        if (this.mWebBean != null) {
            e2.a("\u4fee\u6539\u6210\u529f");
        } else {
            e2.a("\u6dfb\u52a0\u6210\u529f");
        }
        finish();
    }

    public final void onkeyback() {
        util.f1.b(this.mActivity, "\u653e\u5f03\u672c\u6b21\u4fe1\u606f\u7f16\u8f91\uff1f", "", "\u786e\u5b9a", "\u53d6\u6d88", new b());
    }

    @Override // ui.activity.BasePicUploadActivity
    protected void pageFileFinish() {
        super.pageFileFinish();
        runOnUiThread(new c());
    }

    @Override // ui.activity.BasePicUploadActivity
    public void removeLocalData(int i2) {
        this.mLocalMedia.remove(i2);
        ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
        if (reportPictureSelAdapter != null) {
            reportPictureSelAdapter.notifyDataSetChanged();
        }
    }

    public final void setCaseInfoId(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_report_weburl_add;
    }

    public final void setMAdapter(@j.c.a.e ReportPictureSelAdapter reportPictureSelAdapter) {
        this.mAdapter = reportPictureSelAdapter;
    }

    public final void setMBtnCommit(@j.c.a.d Button button) {
        i.q2.t.i0.f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMEtWebUrl(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtWebUrl = editText;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@j.c.a.e ReportEdWebsitePresenter reportEdWebsitePresenter) {
        this.mPresenter = reportEdWebsitePresenter;
    }

    public final void setMRecyView(@j.c.a.d RecyclerView recyclerView) {
        i.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecyView = recyclerView;
    }

    public final void setMTvTip(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTip = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMWebBean(@j.c.a.e ReportWebsitBean reportWebsitBean) {
        this.mWebBean = reportWebsitBean;
    }

    public final void setScrollView(@j.c.a.d NestedScrollView nestedScrollView) {
        i.q2.t.i0.f(nestedScrollView, "<set-?>");
        this.scrollView = nestedScrollView;
    }

    public final void setSuspFileId(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.suspFileId = str;
    }

    public final void transLocalMedia(@j.c.a.e ArrayList<UploadFileBean> arrayList) {
        if (arrayList != null) {
            this.mUploadPicList.clear();
            for (UploadFileBean uploadFileBean : arrayList) {
                this.mUploadPicList.add(uploadFileBean);
                UploadStateInfo uploadStateInfo = new UploadStateInfo();
                uploadStateInfo.setUploadState(2);
                this.mUploadStateList.add(uploadStateInfo);
                LocalMedia localMedia = new LocalMedia();
                i.q2.t.i0.a((Object) uploadFileBean, "bean");
                localMedia.setPath(uploadFileBean.getFilePath());
                localMedia.setFileName(uploadFileBean.getFileName());
                this.mLocalMedia.add(localMedia);
            }
            ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
            if (reportPictureSelAdapter != null) {
                reportPictureSelAdapter.notifyDataSetChanged();
            }
        }
    }
}
