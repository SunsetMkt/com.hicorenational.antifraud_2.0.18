package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import bean.AppInfoBean;
import bean.SurveyAppBean;
import butterknife.BindView;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.ReportAppView;
import ui.presenter.ReportAppPresenter;
import ui.view.SwitchButton;
import util.e2;
import util.g2;
import util.x1;

/* JADX INFO: compiled from: ReportAppAddActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001J\n\u0010\u009a\u0001\u001a\u00030\u0099\u0001H\u0016J\b\u0010\u009b\u0001\u001a\u00030\u0099\u0001J(\u0010\u009c\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009d\u0001\u001a\u00020$2\u0007\u0010\u009e\u0001\u001a\u00020$2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u00a0\u0001H\u0016J\u0013\u0010\u00a1\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u00a2\u0001\u001a\u00020KH\u0016J\n\u0010\u00a3\u0001\u001a\u00030\u0099\u0001H\u0014J\u0014\u0010\u00a4\u0001\u001a\u00030\u0099\u00012\b\u0010\u00a5\u0001\u001a\u00030\u00a6\u0001H\u0007J\n\u0010\u00a7\u0001\u001a\u00030\u0099\u0001H\u0016J\u0013\u0010\u00a8\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u00a9\u0001\u001a\u00020$H\u0016J\u001d\u0010\u00aa\u0001\u001a\u00030\u00ab\u00012\u0007\u0010\u00ac\u0001\u001a\u00020$2\b\u0010\u00ad\u0001\u001a\u00030\u00ae\u0001H\u0016J%\u0010\u00af\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u00b0\u0001\u001a\u00020$2\u0010\u0010\u00b1\u0001\u001a\u000b\u0012\u0004\u0012\u00020-\u0018\u00010\u00b2\u0001H\u0016J\b\u0010\u00b3\u0001\u001a\u00030\u0099\u0001J\t\u0010\u00b4\u0001\u001a\u00020$H\u0016J\b\u0010\u00b5\u0001\u001a\u00030\u00ab\u0001J\b\u0010\u00b6\u0001\u001a\u00030\u00ab\u0001J\b\u0010\u00b7\u0001\u001a\u00030\u00ab\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u00020<8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010A\u001a\u00020<8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u001e\u0010D\u001a\u00020<8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R\u001e\u0010G\u001a\u00020<8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010>\"\u0004\bI\u0010@R\u001e\u0010J\u001a\u00020K8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001e\u0010P\u001a\u00020K8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010OR\u001e\u0010S\u001a\u00020T8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001e\u0010Y\u001a\u00020T8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR\u001e\u0010\\\u001a\u00020T8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010V\"\u0004\b^\u0010XR\u001e\u0010_\u001a\u00020T8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010V\"\u0004\ba\u0010XR\u001e\u0010b\u001a\u00020K8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010M\"\u0004\bd\u0010OR\u001e\u0010e\u001a\u00020K8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010M\"\u0004\bg\u0010OR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001e\u0010n\u001a\u00020o8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001e\u0010t\u001a\u00020o8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010q\"\u0004\bv\u0010sR\u001e\u0010w\u001a\u00020K8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010M\"\u0004\by\u0010OR\u001e\u0010z\u001a\u00020{8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR!\u0010\u0080\u0001\u001a\u00020{8\u0006@\u0006X\u0087.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010}\"\u0005\b\u0082\u0001\u0010\u007fR!\u0010\u0083\u0001\u001a\u00020{8\u0006@\u0006X\u0087.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010}\"\u0005\b\u0085\u0001\u0010\u007fR!\u0010\u0086\u0001\u001a\u00020{8\u0006@\u0006X\u0087.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010}\"\u0005\b\u0088\u0001\u0010\u007fR\"\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u008c\u0001\"\u0006\b\u0091\u0001\u0010\u008e\u0001R$\u0010\u0092\u0001\u001a\u00030\u0093\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001\u00a8\u0006\u00b8\u0001"}, d2 = {"Lui/activity/ReportAppAddActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/callview/ReportAppView;", "()V", "appInfo", "Lbean/AppInfoBean;", "getAppInfo", "()Lbean/AppInfoBean;", "setAppInfo", "(Lbean/AppInfoBean;)V", "appLogoName", "", "getAppLogoName", "()Ljava/lang/String;", "setAppLogoName", "(Ljava/lang/String;)V", "appLogoPath", "getAppLogoPath", "setAppLogoPath", "appName", "getAppName", "setAppName", "appPkgPath", "getAppPkgPath", "setAppPkgPath", "appZXingName", "getAppZXingName", "setAppZXingName", "appZXingPath", "getAppZXingPath", "setAppZXingPath", "caseInfoId", "getCaseInfoId", "setCaseInfoId", "imgType", "", "getImgType", "()I", "setImgType", "(I)V", "listItem", "getListItem", "setListItem", "mAddAppBean", "Lbean/SurveyAppBean;", "getMAddAppBean", "()Lbean/SurveyAppBean;", "setMAddAppBean", "(Lbean/SurveyAppBean;)V", "mAppBean", "getMAppBean", "setMAppBean", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mEtAppName", "Landroid/widget/EditText;", "getMEtAppName", "()Landroid/widget/EditText;", "setMEtAppName", "(Landroid/widget/EditText;)V", "mEtInvitationCode", "getMEtInvitationCode", "setMEtInvitationCode", "mEtVictimAccount", "getMEtVictimAccount", "setMEtVictimAccount", "mEtVictimPwd", "getMEtVictimPwd", "setMEtVictimPwd", "mFlAppInfo", "Landroid/view/View;", "getMFlAppInfo", "()Landroid/view/View;", "setMFlAppInfo", "(Landroid/view/View;)V", "mFlAppZxing", "getMFlAppZxing", "setMFlAppZxing", "mIvAppIcon", "Landroid/widget/ImageView;", "getMIvAppIcon", "()Landroid/widget/ImageView;", "setMIvAppIcon", "(Landroid/widget/ImageView;)V", "mIvAppLogo", "getMIvAppLogo", "setMIvAppLogo", "mIvAppZxingPic", "getMIvAppZxingPic", "setMIvAppZxingPic", "mIvBack", "getMIvBack", "setMIvBack", "mLlAddAppLogo", "getMLlAddAppLogo", "setMLlAddAppLogo", "mLlAddAppName", "getMLlAddAppName", "setMLlAddAppName", "mPresenter", "Lui/presenter/ReportAppPresenter;", "getMPresenter", "()Lui/presenter/ReportAppPresenter;", "setMPresenter", "(Lui/presenter/ReportAppPresenter;)V", "mSwitchApp", "Lui/view/SwitchButton;", "getMSwitchApp", "()Lui/view/SwitchButton;", "setMSwitchApp", "(Lui/view/SwitchButton;)V", "mSwitchZxing", "getMSwitchZxing", "setMSwitchZxing", "mTvAddApp", "getMTvAddApp", "setMTvAddApp", "mTvAppName", "Landroid/widget/TextView;", "getMTvAppName", "()Landroid/widget/TextView;", "setMTvAppName", "(Landroid/widget/TextView;)V", "mTvAppPkg", "getMTvAppPkg", "setMTvAppPkg", "mTvAppVers", "getMTvAppVers", "setMTvAppVers", "mTvTitle", "getMTvTitle", "setMTvTitle", "mediaPic", "Lcom/luck/picture/lib/entity/LocalMedia;", "getMediaPic", "()Lcom/luck/picture/lib/entity/LocalMedia;", "setMediaPic", "(Lcom/luck/picture/lib/entity/LocalMedia;)V", "mediaPicLogo", "getMediaPicLogo", "setMediaPicLogo", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScrollView", "()Landroidx/core/widget/NestedScrollView;", "setScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "initListener", "", "initPage", "initViewData", "onActivityResult", "requestCode", com.taobao.agoo.a.a.b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onClick", "view", "onDestroy", "onEventMainThread", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onFailRequest", "onItemDelet", "itemPos", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onSuccessHandle", "type", "list", "", "onkeyback", "setLayoutView", "upLoadApp", "upLoadLogo", "upLoadZXing", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class ReportAppAddActivity extends BaseActivity implements View.OnClickListener, ReportAppView {

    @j.c.a.e
    private AppInfoBean appInfo;
    private int imgType;
    private int listItem;

    @j.c.a.e
    private SurveyAppBean mAddAppBean;

    @j.c.a.e
    private SurveyAppBean mAppBean;

    @BindView(R.id.btn_commit)
    @j.c.a.d
    public Button mBtnCommit;

    @BindView(R.id.et_app_name)
    @j.c.a.d
    public EditText mEtAppName;

    @BindView(R.id.et_app_invitationCode)
    @j.c.a.d
    public EditText mEtInvitationCode;

    @BindView(R.id.et_app_victimAccount)
    @j.c.a.d
    public EditText mEtVictimAccount;

    @BindView(R.id.et_app_victimPwd)
    @j.c.a.d
    public EditText mEtVictimPwd;

    @BindView(R.id.fl_app_view)
    @j.c.a.d
    public View mFlAppInfo;

    @BindView(R.id.fl_app_zxing)
    @j.c.a.d
    public View mFlAppZxing;

    @BindView(R.id.iv_icon)
    @j.c.a.d
    public ImageView mIvAppIcon;

    @BindView(R.id.iv_add_logo)
    @j.c.a.d
    public ImageView mIvAppLogo;

    @BindView(R.id.iv_add_zxing)
    @j.c.a.d
    public ImageView mIvAppZxingPic;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.fl_app_logo)
    @j.c.a.d
    public View mLlAddAppLogo;

    @BindView(R.id.fl_add_name)
    @j.c.a.d
    public View mLlAddAppName;

    @j.c.a.e
    private ReportAppPresenter mPresenter;

    @BindView(R.id.switchShow_app)
    @j.c.a.d
    public SwitchButton mSwitchApp;

    @BindView(R.id.switchShow_zxing)
    @j.c.a.d
    public SwitchButton mSwitchZxing;

    @BindView(R.id.fl_add_app)
    @j.c.a.d
    public View mTvAddApp;

    @BindView(R.id.tv_app_name)
    @j.c.a.d
    public TextView mTvAppName;

    @BindView(R.id.tv_app_pkg)
    @j.c.a.d
    public TextView mTvAppPkg;

    @BindView(R.id.tv_app_vers)
    @j.c.a.d
    public TextView mTvAppVers;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @j.c.a.e
    private LocalMedia mediaPic;

    @j.c.a.e
    private LocalMedia mediaPicLogo;

    @BindView(R.id.scrollView)
    @j.c.a.d
    public NestedScrollView scrollView;

    @j.c.a.d
    private String caseInfoId = "";

    @j.c.a.d
    private String appPkgPath = "";

    @j.c.a.d
    private String appName = "";

    @j.c.a.d
    private String appZXingPath = "";

    @j.c.a.d
    private String appZXingName = "";

    @j.c.a.d
    private String appLogoPath = "";

    @j.c.a.d
    private String appLogoName = "";

    /* JADX INFO: compiled from: ReportAppAddActivity.kt */
    static final class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!z) {
                ReportAppAddActivity.this.getMTvAddApp().setVisibility(8);
                ReportAppAddActivity.this.getMFlAppInfo().setVisibility(8);
                ReportAppAddActivity.this.getMLlAddAppName().setVisibility(0);
                ReportAppAddActivity.this.getMLlAddAppLogo().setVisibility(0);
                ReportAppAddActivity.this.getMSwitchApp().setChecked(false);
                return;
            }
            ReportAppAddActivity.this.getMTvAddApp().setVisibility(0);
            ReportAppAddActivity.this.getMLlAddAppName().setVisibility(8);
            ReportAppAddActivity.this.getMLlAddAppLogo().setVisibility(8);
            if (TextUtils.isEmpty(ReportAppAddActivity.this.getAppPkgPath())) {
                ReportAppAddActivity.this.getMFlAppInfo().setVisibility(8);
            } else {
                ReportAppAddActivity.this.getMFlAppInfo().setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: ReportAppAddActivity.kt */
    @i.y(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 1, 16})
    static final class b implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: compiled from: ReportAppAddActivity.kt */
        public static final class a implements IClickListener {
            a() {
            }

            @Override // interfaces.IClickListener
            public void cancelBtn() {
                ReportAppAddActivity.this.getMFlAppZxing().setVisibility(8);
                ReportAppAddActivity.this.getMSwitchZxing().setChecked(false);
                ReportAppAddActivity.this.setMediaPic(null);
                ReportAppAddActivity.this.setAppZXingPath("");
                k.d.b(ReportAppAddActivity.this.getMIvAppZxingPic(), ReportAppAddActivity.this.getAppZXingPath());
            }

            @Override // interfaces.IClickListener
            public void clickOKBtn() {
                ReportAppAddActivity.this.getMSwitchZxing().setChecked(true);
            }
        }

        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                ReportAppAddActivity.this.getMFlAppZxing().setVisibility(0);
            } else if (TextUtils.isEmpty(ReportAppAddActivity.this.getAppZXingPath())) {
                ReportAppAddActivity.this.getMFlAppZxing().setVisibility(8);
            } else {
                util.f1.a(ReportAppAddActivity.this.mActivity, "\u5173\u95ed\u6309\u94ae\u5c06\u4e0d\u4fdd\u7559\u4fe1\u606f\uff1f", "", "\u786e\u5b9a", "\u53d6\u6d88", -1, -1, true, (IClickListener) new a());
            }
        }
    }

    /* JADX INFO: compiled from: ReportAppAddActivity.kt */
    public static final class c implements IClickListener {
        c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportAppAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @j.c.a.e
    public final AppInfoBean getAppInfo() {
        return this.appInfo;
    }

    @j.c.a.d
    public final String getAppLogoName() {
        return this.appLogoName;
    }

    @j.c.a.d
    public final String getAppLogoPath() {
        return this.appLogoPath;
    }

    @j.c.a.d
    public final String getAppName() {
        return this.appName;
    }

    @j.c.a.d
    public final String getAppPkgPath() {
        return this.appPkgPath;
    }

    @j.c.a.d
    public final String getAppZXingName() {
        return this.appZXingName;
    }

    @j.c.a.d
    public final String getAppZXingPath() {
        return this.appZXingPath;
    }

    @j.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getImgType() {
        return this.imgType;
    }

    public final int getListItem() {
        return this.listItem;
    }

    @j.c.a.e
    public final SurveyAppBean getMAddAppBean() {
        return this.mAddAppBean;
    }

    @j.c.a.e
    public final SurveyAppBean getMAppBean() {
        return this.mAppBean;
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
    public final EditText getMEtAppName() {
        EditText editText = this.mEtAppName;
        if (editText == null) {
            i.q2.t.i0.k("mEtAppName");
        }
        return editText;
    }

    @j.c.a.d
    public final EditText getMEtInvitationCode() {
        EditText editText = this.mEtInvitationCode;
        if (editText == null) {
            i.q2.t.i0.k("mEtInvitationCode");
        }
        return editText;
    }

    @j.c.a.d
    public final EditText getMEtVictimAccount() {
        EditText editText = this.mEtVictimAccount;
        if (editText == null) {
            i.q2.t.i0.k("mEtVictimAccount");
        }
        return editText;
    }

    @j.c.a.d
    public final EditText getMEtVictimPwd() {
        EditText editText = this.mEtVictimPwd;
        if (editText == null) {
            i.q2.t.i0.k("mEtVictimPwd");
        }
        return editText;
    }

    @j.c.a.d
    public final View getMFlAppInfo() {
        View view = this.mFlAppInfo;
        if (view == null) {
            i.q2.t.i0.k("mFlAppInfo");
        }
        return view;
    }

    @j.c.a.d
    public final View getMFlAppZxing() {
        View view = this.mFlAppZxing;
        if (view == null) {
            i.q2.t.i0.k("mFlAppZxing");
        }
        return view;
    }

    @j.c.a.d
    public final ImageView getMIvAppIcon() {
        ImageView imageView = this.mIvAppIcon;
        if (imageView == null) {
            i.q2.t.i0.k("mIvAppIcon");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvAppLogo() {
        ImageView imageView = this.mIvAppLogo;
        if (imageView == null) {
            i.q2.t.i0.k("mIvAppLogo");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvAppZxingPic() {
        ImageView imageView = this.mIvAppZxingPic;
        if (imageView == null) {
            i.q2.t.i0.k("mIvAppZxingPic");
        }
        return imageView;
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
    public final View getMLlAddAppLogo() {
        View view = this.mLlAddAppLogo;
        if (view == null) {
            i.q2.t.i0.k("mLlAddAppLogo");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlAddAppName() {
        View view = this.mLlAddAppName;
        if (view == null) {
            i.q2.t.i0.k("mLlAddAppName");
        }
        return view;
    }

    @j.c.a.e
    public final ReportAppPresenter getMPresenter() {
        return this.mPresenter;
    }

    @j.c.a.d
    public final SwitchButton getMSwitchApp() {
        SwitchButton switchButton = this.mSwitchApp;
        if (switchButton == null) {
            i.q2.t.i0.k("mSwitchApp");
        }
        return switchButton;
    }

    @j.c.a.d
    public final SwitchButton getMSwitchZxing() {
        SwitchButton switchButton = this.mSwitchZxing;
        if (switchButton == null) {
            i.q2.t.i0.k("mSwitchZxing");
        }
        return switchButton;
    }

    @j.c.a.d
    public final View getMTvAddApp() {
        View view = this.mTvAddApp;
        if (view == null) {
            i.q2.t.i0.k("mTvAddApp");
        }
        return view;
    }

    @j.c.a.d
    public final TextView getMTvAppName() {
        TextView textView = this.mTvAppName;
        if (textView == null) {
            i.q2.t.i0.k("mTvAppName");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvAppPkg() {
        TextView textView = this.mTvAppPkg;
        if (textView == null) {
            i.q2.t.i0.k("mTvAppPkg");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvAppVers() {
        TextView textView = this.mTvAppVers;
        if (textView == null) {
            i.q2.t.i0.k("mTvAppVers");
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
    public final LocalMedia getMediaPic() {
        return this.mediaPic;
    }

    @j.c.a.e
    public final LocalMedia getMediaPicLogo() {
        return this.mediaPicLogo;
    }

    @j.c.a.d
    public final NestedScrollView getScrollView() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            i.q2.t.i0.k("scrollView");
        }
        return nestedScrollView;
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
        View view = this.mTvAddApp;
        if (view == null) {
            i.q2.t.i0.k("mTvAddApp");
        }
        if (view == null) {
            i.q2.t.i0.f();
        }
        view.setOnClickListener(this);
        ImageView imageView2 = this.mIvAppZxingPic;
        if (imageView2 == null) {
            i.q2.t.i0.k("mIvAppZxingPic");
        }
        if (imageView2 == null) {
            i.q2.t.i0.f();
        }
        imageView2.setOnClickListener(this);
        ImageView imageView3 = this.mIvAppLogo;
        if (imageView3 == null) {
            i.q2.t.i0.k("mIvAppLogo");
        }
        if (imageView3 == null) {
            i.q2.t.i0.f();
        }
        imageView3.setOnClickListener(this);
        Button button = this.mBtnCommit;
        if (button == null) {
            i.q2.t.i0.k("mBtnCommit");
        }
        if (button == null) {
            i.q2.t.i0.f();
        }
        button.setOnClickListener(this);
        SwitchButton switchButton = this.mSwitchApp;
        if (switchButton == null) {
            i.q2.t.i0.k("mSwitchApp");
        }
        switchButton.setOnCheckedChangeListener(new a());
        SwitchButton switchButton2 = this.mSwitchZxing;
        if (switchButton2 == null) {
            i.q2.t.i0.k("mSwitchZxing");
        }
        switchButton2.setOnCheckedChangeListener(new b());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        ui.statusbarcompat.b.a((Activity) this, true, true);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u6dfb\u52a0\u8bc8\u9a97APP");
        initViewData();
        initListener();
        this.mPresenter = new ReportAppPresenter(this.mActivity, this.caseInfoId, this);
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            i.q2.t.i0.k("scrollView");
        }
        g2.a(nestedScrollView, this.mActivity);
    }

    public final void initViewData() {
        this.listItem = getIntent().getIntExtra(util.p1.F0, 0);
        String stringExtra = getIntent().getStringExtra(util.p1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mAppBean = (SurveyAppBean) getIntent().getSerializableExtra(util.p1.f15011c);
        SurveyAppBean surveyAppBean = this.mAppBean;
        if (surveyAppBean == null) {
            View view = this.mFlAppZxing;
            if (view == null) {
                i.q2.t.i0.k("mFlAppZxing");
            }
            view.setVisibility(8);
            SwitchButton switchButton = this.mSwitchZxing;
            if (switchButton == null) {
                i.q2.t.i0.k("mSwitchZxing");
            }
            switchButton.setChecked(false);
            return;
        }
        if (TextUtils.isEmpty(surveyAppBean != null ? surveyAppBean.getPackageFileUrl() : null)) {
            View view2 = this.mFlAppInfo;
            if (view2 == null) {
                i.q2.t.i0.k("mFlAppInfo");
            }
            view2.setVisibility(8);
            View view3 = this.mTvAddApp;
            if (view3 == null) {
                i.q2.t.i0.k("mTvAddApp");
            }
            view3.setVisibility(8);
            View view4 = this.mLlAddAppName;
            if (view4 == null) {
                i.q2.t.i0.k("mLlAddAppName");
            }
            view4.setVisibility(0);
            View view5 = this.mLlAddAppLogo;
            if (view5 == null) {
                i.q2.t.i0.k("mLlAddAppLogo");
            }
            view5.setVisibility(0);
            EditText editText = this.mEtAppName;
            if (editText == null) {
                i.q2.t.i0.k("mEtAppName");
            }
            SurveyAppBean surveyAppBean2 = this.mAppBean;
            editText.setText(surveyAppBean2 != null ? surveyAppBean2.getAppName() : null);
        } else {
            SwitchButton switchButton2 = this.mSwitchApp;
            if (switchButton2 == null) {
                i.q2.t.i0.k("mSwitchApp");
            }
            switchButton2.setChecked(true);
            View view6 = this.mTvAddApp;
            if (view6 == null) {
                i.q2.t.i0.k("mTvAddApp");
            }
            view6.setVisibility(0);
            View view7 = this.mFlAppInfo;
            if (view7 == null) {
                i.q2.t.i0.k("mFlAppInfo");
            }
            view7.setVisibility(0);
            View view8 = this.mLlAddAppName;
            if (view8 == null) {
                i.q2.t.i0.k("mLlAddAppName");
            }
            view8.setVisibility(8);
            View view9 = this.mLlAddAppLogo;
            if (view9 == null) {
                i.q2.t.i0.k("mLlAddAppLogo");
            }
            view9.setVisibility(8);
            TextView textView = this.mTvAppName;
            if (textView == null) {
                i.q2.t.i0.k("mTvAppName");
            }
            SurveyAppBean surveyAppBean3 = this.mAppBean;
            textView.setText(surveyAppBean3 != null ? surveyAppBean3.getAppName() : null);
            TextView textView2 = this.mTvAppVers;
            if (textView2 == null) {
                i.q2.t.i0.k("mTvAppVers");
            }
            SurveyAppBean surveyAppBean4 = this.mAppBean;
            textView2.setText(surveyAppBean4 != null ? surveyAppBean4.getAppVersion() : null);
            TextView textView3 = this.mTvAppPkg;
            if (textView3 == null) {
                i.q2.t.i0.k("mTvAppPkg");
            }
            SurveyAppBean surveyAppBean5 = this.mAppBean;
            textView3.setText(surveyAppBean5 != null ? surveyAppBean5.getPackageName() : null);
            SurveyAppBean surveyAppBean6 = this.mAppBean;
            String packageFileUrl = surveyAppBean6 != null ? surveyAppBean6.getPackageFileUrl() : null;
            if (packageFileUrl == null) {
                i.q2.t.i0.f();
            }
            this.appPkgPath = packageFileUrl;
            SurveyAppBean surveyAppBean7 = this.mAppBean;
            String appName = surveyAppBean7 != null ? surveyAppBean7.getAppName() : null;
            SurveyAppBean surveyAppBean8 = this.mAppBean;
            Bitmap bitmapA = k.c.a(appName, surveyAppBean8 != null ? surveyAppBean8.getAppVersion() : null, k.c.f12653f);
            ImageView imageView = this.mIvAppIcon;
            if (imageView == null) {
                i.q2.t.i0.k("mIvAppIcon");
            }
            imageView.setImageBitmap(bitmapA);
        }
        SurveyAppBean surveyAppBean9 = this.mAppBean;
        if (!TextUtils.isEmpty(surveyAppBean9 != null ? surveyAppBean9.getAppLogoFileUrl() : null)) {
            ImageView imageView2 = this.mIvAppLogo;
            if (imageView2 == null) {
                i.q2.t.i0.k("mIvAppLogo");
            }
            SurveyAppBean surveyAppBean10 = this.mAppBean;
            k.d.b(imageView2, surveyAppBean10 != null ? surveyAppBean10.getAppLogoFileUrl() : null);
        }
        SurveyAppBean surveyAppBean11 = this.mAppBean;
        if (!TextUtils.isEmpty(surveyAppBean11 != null ? surveyAppBean11.getQrCodeFileUrl() : null)) {
            ImageView imageView3 = this.mIvAppZxingPic;
            if (imageView3 == null) {
                i.q2.t.i0.k("mIvAppZxingPic");
            }
            SurveyAppBean surveyAppBean12 = this.mAppBean;
            k.d.b(imageView3, surveyAppBean12 != null ? surveyAppBean12.getQrCodeFileUrl() : null);
            View view10 = this.mFlAppZxing;
            if (view10 == null) {
                i.q2.t.i0.k("mFlAppZxing");
            }
            view10.setVisibility(0);
            SwitchButton switchButton3 = this.mSwitchZxing;
            if (switchButton3 == null) {
                i.q2.t.i0.k("mSwitchZxing");
            }
            switchButton3.setChecked(true);
        }
        SurveyAppBean surveyAppBean13 = this.mAppBean;
        if (!TextUtils.isEmpty(surveyAppBean13 != null ? surveyAppBean13.getVictimAccount() : null)) {
            EditText editText2 = this.mEtVictimAccount;
            if (editText2 == null) {
                i.q2.t.i0.k("mEtVictimAccount");
            }
            SurveyAppBean surveyAppBean14 = this.mAppBean;
            editText2.setText(surveyAppBean14 != null ? surveyAppBean14.getVictimAccount() : null);
        }
        SurveyAppBean surveyAppBean15 = this.mAppBean;
        if (!TextUtils.isEmpty(surveyAppBean15 != null ? surveyAppBean15.getVictimPwd() : null)) {
            EditText editText3 = this.mEtVictimPwd;
            if (editText3 == null) {
                i.q2.t.i0.k("mEtVictimPwd");
            }
            SurveyAppBean surveyAppBean16 = this.mAppBean;
            editText3.setText(surveyAppBean16 != null ? surveyAppBean16.getVictimPwd() : null);
        }
        SurveyAppBean surveyAppBean17 = this.mAppBean;
        if (TextUtils.isEmpty(surveyAppBean17 != null ? surveyAppBean17.getInvitationCode() : null)) {
            return;
        }
        EditText editText4 = this.mEtInvitationCode;
        if (editText4 == null) {
            i.q2.t.i0.k("mEtInvitationCode");
        }
        SurveyAppBean surveyAppBean18 = this.mAppBean;
        editText4.setText(surveyAppBean18 != null ? surveyAppBean18.getInvitationCode() : null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @j.c.a.e Intent intent) {
        List listObtainMultipleResult;
        String fileName;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 188 || (listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || listObtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            g2.a(this.mActivity, (List<LocalMedia>) listObtainMultipleResult);
        }
        List<LocalMedia> listA = g2.a((List<LocalMedia>) listObtainMultipleResult);
        if (this.imgType == 1) {
            this.mediaPic = listA.get(0);
            ImageView imageView = this.mIvAppZxingPic;
            if (imageView == null) {
                i.q2.t.i0.k("mIvAppZxingPic");
            }
            LocalMedia localMedia = this.mediaPic;
            k.d.b(imageView, localMedia != null ? localMedia.getPath() : null);
            LocalMedia localMedia2 = this.mediaPic;
            String path = localMedia2 != null ? localMedia2.getPath() : null;
            if (path == null) {
                i.q2.t.i0.f();
            }
            this.appZXingPath = path;
            LocalMedia localMedia3 = this.mediaPic;
            fileName = localMedia3 != null ? localMedia3.getFileName() : null;
            if (fileName == null) {
                i.q2.t.i0.f();
            }
            this.appZXingName = fileName;
            SurveyAppBean surveyAppBean = this.mAppBean;
            if (surveyAppBean != null) {
                if (surveyAppBean == null) {
                    i.q2.t.i0.f();
                }
                surveyAppBean.setQrCodeFileID("");
                SurveyAppBean surveyAppBean2 = this.mAppBean;
                if (surveyAppBean2 == null) {
                    i.q2.t.i0.f();
                }
                surveyAppBean2.setQrCodeFileUrl("");
                return;
            }
            return;
        }
        this.mediaPicLogo = listA.get(0);
        ImageView imageView2 = this.mIvAppLogo;
        if (imageView2 == null) {
            i.q2.t.i0.k("mIvAppLogo");
        }
        LocalMedia localMedia4 = this.mediaPicLogo;
        k.d.b(imageView2, localMedia4 != null ? localMedia4.getPath() : null);
        LocalMedia localMedia5 = this.mediaPicLogo;
        String path2 = localMedia5 != null ? localMedia5.getPath() : null;
        if (path2 == null) {
            i.q2.t.i0.f();
        }
        this.appLogoPath = path2;
        LocalMedia localMedia6 = this.mediaPicLogo;
        fileName = localMedia6 != null ? localMedia6.getFileName() : null;
        if (fileName == null) {
            i.q2.t.i0.f();
        }
        this.appLogoName = fileName;
        SurveyAppBean surveyAppBean3 = this.mAppBean;
        if (surveyAppBean3 != null) {
            if (surveyAppBean3 == null) {
                i.q2.t.i0.f();
            }
            surveyAppBean3.setAppLogoFileID("");
            SurveyAppBean surveyAppBean4 = this.mAppBean;
            if (surveyAppBean4 == null) {
                i.q2.t.i0.f();
            }
            surveyAppBean4.setAppLogoFileUrl("");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@j.c.a.d View view) {
        SurveyAppBean surveyAppBean;
        SurveyAppBean surveyAppBean2;
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296407 */:
                TextView textView = this.mTvAppName;
                if (textView == null) {
                    i.q2.t.i0.k("mTvAppName");
                }
                String string = textView.getText().toString();
                TextView textView2 = this.mTvAppPkg;
                if (textView2 == null) {
                    i.q2.t.i0.k("mTvAppPkg");
                }
                String string2 = textView2.getText().toString();
                TextView textView3 = this.mTvAppVers;
                if (textView3 == null) {
                    i.q2.t.i0.k("mTvAppVers");
                }
                String string3 = textView3.getText().toString();
                EditText editText = this.mEtAppName;
                if (editText == null) {
                    i.q2.t.i0.k("mEtAppName");
                }
                String string4 = editText.getText().toString();
                EditText editText2 = this.mEtVictimAccount;
                if (editText2 == null) {
                    i.q2.t.i0.k("mEtVictimAccount");
                }
                String string5 = editText2.getText().toString();
                EditText editText3 = this.mEtVictimPwd;
                if (editText3 == null) {
                    i.q2.t.i0.k("mEtVictimPwd");
                }
                String string6 = editText3.getText().toString();
                EditText editText4 = this.mEtInvitationCode;
                if (editText4 == null) {
                    i.q2.t.i0.k("mEtInvitationCode");
                }
                String string7 = editText4.getText().toString();
                SwitchButton switchButton = this.mSwitchApp;
                if (switchButton == null) {
                    i.q2.t.i0.k("mSwitchApp");
                }
                if (switchButton.isChecked()) {
                    if (TextUtils.isEmpty(this.appPkgPath)) {
                        e2.a("\u8bf7\u6dfb\u52a0\u8bc8\u9a97APP");
                    } else {
                        this.appLogoPath = "";
                    }
                } else if (TextUtils.isEmpty(string4)) {
                    e2.a("\u8bf7\u6dfb\u52a0\u8bc8\u9a97APP\u540d\u79f0");
                } else {
                    this.appPkgPath = "";
                    string = string4;
                    string2 = "";
                    string3 = string2;
                }
                SwitchButton switchButton2 = this.mSwitchZxing;
                if (switchButton2 == null) {
                    i.q2.t.i0.k("mSwitchZxing");
                }
                if (!switchButton2.isChecked()) {
                    this.appZXingPath = "";
                    this.appZXingName = "";
                } else if (TextUtils.isEmpty(this.appZXingPath)) {
                    SurveyAppBean surveyAppBean3 = this.mAppBean;
                    if (surveyAppBean3 != null) {
                        if (surveyAppBean3 == null) {
                            i.q2.t.i0.f();
                        }
                        if (TextUtils.isEmpty(surveyAppBean3.getQrCodeFileUrl())) {
                            e2.a("\u8bf7\u6dfb\u52a0\u4e0b\u8f7d\u4e8c\u7ef4\u7801");
                        }
                    } else {
                        e2.a("\u8bf7\u6dfb\u52a0\u4e0b\u8f7d\u4e8c\u7ef4\u7801");
                    }
                }
                if (TextUtils.isEmpty(string5)) {
                    e2.a("\u8bf7\u8f93\u5165\u53d7\u5bb3\u4eba\u7684APP\u8d26\u53f7");
                } else if (!TextUtils.isEmpty(string6)) {
                    boolean zUpLoadApp = upLoadApp();
                    boolean zUpLoadZXing = upLoadZXing();
                    boolean zUpLoadLogo = upLoadLogo();
                    SurveyAppBean surveyAppBean4 = this.mAppBean;
                    if (surveyAppBean4 != null) {
                        if (surveyAppBean4 != null) {
                            surveyAppBean4.setUpdateTime(g2.d());
                        }
                        SurveyAppBean surveyAppBean5 = this.mAppBean;
                        if (surveyAppBean5 != null) {
                            surveyAppBean5.setCaseInfoID(this.caseInfoId);
                        }
                        SurveyAppBean surveyAppBean6 = this.mAppBean;
                        if (surveyAppBean6 != null) {
                            surveyAppBean6.setAppName(string);
                        }
                        SurveyAppBean surveyAppBean7 = this.mAppBean;
                        if (surveyAppBean7 != null) {
                            surveyAppBean7.setPackageName(string2);
                        }
                        SurveyAppBean surveyAppBean8 = this.mAppBean;
                        if (surveyAppBean8 != null) {
                            surveyAppBean8.setAppVersion(string3);
                        }
                        SurveyAppBean surveyAppBean9 = this.mAppBean;
                        if (surveyAppBean9 != null) {
                            surveyAppBean9.setPkgPath(this.appPkgPath);
                        }
                        SurveyAppBean surveyAppBean10 = this.mAppBean;
                        if (surveyAppBean10 != null) {
                            surveyAppBean10.setAppLogoFileID(surveyAppBean10 != null ? surveyAppBean10.getAppLogoFileID() : null);
                        }
                        SurveyAppBean surveyAppBean11 = this.mAppBean;
                        if (surveyAppBean11 != null) {
                            surveyAppBean11.setAppLogoPath(this.appLogoPath);
                        }
                        SurveyAppBean surveyAppBean12 = this.mAppBean;
                        if (surveyAppBean12 != null) {
                            surveyAppBean12.setAppLogoName(this.appLogoName);
                        }
                        SurveyAppBean surveyAppBean13 = this.mAppBean;
                        if (surveyAppBean13 != null) {
                            surveyAppBean13.setPackageFileID(surveyAppBean13 != null ? surveyAppBean13.getPackageFileID() : null);
                        }
                        SurveyAppBean surveyAppBean14 = this.mAppBean;
                        if (surveyAppBean14 != null) {
                            surveyAppBean14.setQrCodePath(this.appZXingPath);
                        }
                        SurveyAppBean surveyAppBean15 = this.mAppBean;
                        if (surveyAppBean15 != null) {
                            surveyAppBean15.setQrCodeName(this.appZXingName);
                        }
                        SurveyAppBean surveyAppBean16 = this.mAppBean;
                        if (surveyAppBean16 != null) {
                            surveyAppBean16.setVictimAccount(string5);
                        }
                        SurveyAppBean surveyAppBean17 = this.mAppBean;
                        if (surveyAppBean17 != null) {
                            surveyAppBean17.setVictimPwd(string6);
                        }
                        SurveyAppBean surveyAppBean18 = this.mAppBean;
                        if (surveyAppBean18 != null) {
                            surveyAppBean18.setInvitationCode(string7);
                        }
                        SwitchButton switchButton3 = this.mSwitchApp;
                        if (switchButton3 == null) {
                            i.q2.t.i0.k("mSwitchApp");
                        }
                        if (switchButton3.isChecked() && (surveyAppBean2 = this.mAppBean) != null) {
                            surveyAppBean2.setAppLogoFileID("");
                        }
                        SwitchButton switchButton4 = this.mSwitchZxing;
                        if (switchButton4 == null) {
                            i.q2.t.i0.k("mSwitchZxing");
                        }
                        if (!switchButton4.isChecked() && (surveyAppBean = this.mAppBean) != null) {
                            surveyAppBean.setQrCodeFileID("");
                        }
                        ReportAppPresenter reportAppPresenter = this.mPresenter;
                        if (reportAppPresenter != null) {
                            reportAppPresenter.handleUpdate(this.mAppBean, zUpLoadApp, zUpLoadZXing, zUpLoadLogo);
                        }
                    } else {
                        this.mAddAppBean = new SurveyAppBean();
                        SurveyAppBean surveyAppBean19 = this.mAddAppBean;
                        if (surveyAppBean19 != null) {
                            surveyAppBean19.setCreateTime(g2.d());
                        }
                        SurveyAppBean surveyAppBean20 = this.mAddAppBean;
                        if (surveyAppBean20 != null) {
                            surveyAppBean20.setCaseInfoID(this.caseInfoId);
                        }
                        SurveyAppBean surveyAppBean21 = this.mAddAppBean;
                        if (surveyAppBean21 != null) {
                            surveyAppBean21.setAppName(string);
                        }
                        SurveyAppBean surveyAppBean22 = this.mAddAppBean;
                        if (surveyAppBean22 != null) {
                            surveyAppBean22.setPackageName(string2);
                        }
                        SurveyAppBean surveyAppBean23 = this.mAddAppBean;
                        if (surveyAppBean23 != null) {
                            surveyAppBean23.setAppVersion(string3);
                        }
                        SurveyAppBean surveyAppBean24 = this.mAddAppBean;
                        if (surveyAppBean24 != null) {
                            surveyAppBean24.setPkgPath(this.appPkgPath);
                        }
                        SurveyAppBean surveyAppBean25 = this.mAddAppBean;
                        if (surveyAppBean25 != null) {
                            surveyAppBean25.setAppLogoPath(this.appLogoPath);
                        }
                        SurveyAppBean surveyAppBean26 = this.mAddAppBean;
                        if (surveyAppBean26 != null) {
                            surveyAppBean26.setAppLogoName(this.appLogoName);
                        }
                        SurveyAppBean surveyAppBean27 = this.mAddAppBean;
                        if (surveyAppBean27 != null) {
                            surveyAppBean27.setQrCodePath(this.appZXingPath);
                        }
                        SurveyAppBean surveyAppBean28 = this.mAddAppBean;
                        if (surveyAppBean28 != null) {
                            surveyAppBean28.setQrCodeName(this.appZXingName);
                        }
                        SurveyAppBean surveyAppBean29 = this.mAddAppBean;
                        if (surveyAppBean29 != null) {
                            surveyAppBean29.setVictimAccount(string5);
                        }
                        SurveyAppBean surveyAppBean30 = this.mAddAppBean;
                        if (surveyAppBean30 != null) {
                            surveyAppBean30.setVictimPwd(string6);
                        }
                        SurveyAppBean surveyAppBean31 = this.mAddAppBean;
                        if (surveyAppBean31 != null) {
                            surveyAppBean31.setInvitationCode(string7);
                        }
                        ReportAppPresenter reportAppPresenter2 = this.mPresenter;
                        if (reportAppPresenter2 != null) {
                            reportAppPresenter2.handleUpdate(this.mAddAppBean, zUpLoadApp, zUpLoadZXing, zUpLoadLogo);
                        }
                    }
                    showProgressDialog("\u4e0a\u4f20\u4e2d...", true);
                } else {
                    e2.a("\u8bf7\u8f93\u5165\u53d7\u5bb3\u4eba\u7684APP\u5bc6\u7801");
                }
                break;
            case R.id.fl_add_app /* 2131296649 */:
                ReportAppPresenter reportAppPresenter3 = this.mPresenter;
                if (reportAppPresenter3 != null) {
                    reportAppPresenter3.addAppCheck();
                }
                break;
            case R.id.iv_add_logo /* 2131296788 */:
                this.imgType = 0;
                ReportAppPresenter reportAppPresenter4 = this.mPresenter;
                if (reportAppPresenter4 != null) {
                    reportAppPresenter4.addPicCheck();
                }
                break;
            case R.id.iv_add_zxing /* 2131296790 */:
                this.imgType = 1;
                ReportAppPresenter reportAppPresenter5 = this.mPresenter;
                if (reportAppPresenter5 != null) {
                    reportAppPresenter5.addPicCheck();
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                onkeyback();
                break;
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@j.c.a.d util.n2.a aVar) {
        i.q2.t.i0.f(aVar, "refreshUIEvent");
        if (aVar.a() != 30) {
            return;
        }
        Object objB = aVar.b();
        if (objB == null) {
            throw new i.e1("null cannot be cast to non-null type bean.AppInfoBean");
        }
        this.appInfo = (AppInfoBean) objB;
        if (this.appInfo != null) {
            View view = this.mFlAppInfo;
            if (view == null) {
                i.q2.t.i0.k("mFlAppInfo");
            }
            view.setVisibility(0);
            TextView textView = this.mTvAppName;
            if (textView == null) {
                i.q2.t.i0.k("mTvAppName");
            }
            AppInfoBean appInfoBean = this.appInfo;
            textView.setText(appInfoBean != null ? appInfoBean.getName() : null);
            TextView textView2 = this.mTvAppVers;
            if (textView2 == null) {
                i.q2.t.i0.k("mTvAppVers");
            }
            AppInfoBean appInfoBean2 = this.appInfo;
            textView2.setText(appInfoBean2 != null ? appInfoBean2.getVersionCode() : null);
            TextView textView3 = this.mTvAppPkg;
            if (textView3 == null) {
                i.q2.t.i0.k("mTvAppPkg");
            }
            AppInfoBean appInfoBean3 = this.appInfo;
            textView3.setText(appInfoBean3 != null ? appInfoBean3.getPkgName() : null);
            ImageView imageView = this.mIvAppIcon;
            if (imageView == null) {
                i.q2.t.i0.k("mIvAppIcon");
            }
            AppInfoBean appInfoBean4 = this.appInfo;
            imageView.setImageDrawable(appInfoBean4 != null ? appInfoBean4.getAppIcon() : null);
            AppInfoBean appInfoBean5 = this.appInfo;
            Bitmap bitmapA = k.c.a(appInfoBean5 != null ? appInfoBean5.getAppIcon() : null);
            AppInfoBean appInfoBean6 = this.appInfo;
            String name = appInfoBean6 != null ? appInfoBean6.getName() : null;
            AppInfoBean appInfoBean7 = this.appInfo;
            k.c.a(bitmapA, name, appInfoBean7 != null ? appInfoBean7.getVersionCode() : null, k.c.f12653f);
            AppInfoBean appInfoBean8 = this.appInfo;
            if ((appInfoBean8 != null ? appInfoBean8.getPkgPath() : null) != null) {
                AppInfoBean appInfoBean9 = this.appInfo;
                String pkgPath = appInfoBean9 != null ? appInfoBean9.getPkgPath() : null;
                if (pkgPath == null) {
                    i.q2.t.i0.f();
                }
                this.appPkgPath = pkgPath;
                AppInfoBean appInfoBean10 = this.appInfo;
                String name2 = appInfoBean10 != null ? appInfoBean10.getName() : null;
                if (name2 == null) {
                    i.q2.t.i0.f();
                }
                this.appName = name2;
            }
        }
    }

    @Override // ui.callview.ReportAppView
    public void onFailRequest() {
        hideProgressDialog();
    }

    @Override // ui.callview.ReportAppView
    public void onItemDelet(int i2) {
        throw new i.a0("An operation is not implemented: not implemented");
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

    @Override // ui.callview.ReportAppView
    public void onSuccessHandle(int i2, @j.c.a.e List<SurveyAppBean> list) {
        if (i2 == 10) {
            ReportAppPresenter reportAppPresenter = this.mPresenter;
            if (reportAppPresenter != null) {
                reportAppPresenter.addSurveyQrcode("", this.appZXingPath, this.appZXingName);
                return;
            }
            return;
        }
        if (i2 != 11) {
            if (i2 != 12) {
                if (i2 == 2) {
                    e2.a("\u6dfb\u52a0\u6210\u529f");
                    hideProgressDialog();
                    finish();
                    return;
                } else {
                    if (i2 == 3) {
                        e2.a("\u4fee\u6539\u6210\u529f");
                        hideProgressDialog();
                        finish();
                        return;
                    }
                    return;
                }
            }
            SurveyAppBean surveyAppBean = this.mAppBean;
            if (surveyAppBean != null) {
                ReportAppPresenter reportAppPresenter2 = this.mPresenter;
                if (reportAppPresenter2 != null) {
                    reportAppPresenter2.handleAppInfo(surveyAppBean, 3);
                    return;
                }
                return;
            }
            ReportAppPresenter reportAppPresenter3 = this.mPresenter;
            if (reportAppPresenter3 != null) {
                reportAppPresenter3.handleAppInfo(this.mAddAppBean, 2);
                return;
            }
            return;
        }
        SwitchButton switchButton = this.mSwitchApp;
        if (switchButton == null) {
            i.q2.t.i0.k("mSwitchApp");
        }
        if (switchButton.isChecked()) {
            ReportAppPresenter reportAppPresenter4 = this.mPresenter;
            if (reportAppPresenter4 != null) {
                reportAppPresenter4.addSurveyApp("", this.appPkgPath, this.appName + x1.f15111d);
                return;
            }
            return;
        }
        ReportAppPresenter reportAppPresenter5 = this.mPresenter;
        if (reportAppPresenter5 != null) {
            String str = this.appPkgPath;
            StringBuilder sb = new StringBuilder();
            TextView textView = this.mTvAppName;
            if (textView == null) {
                i.q2.t.i0.k("mTvAppName");
            }
            sb.append(textView.getText().toString());
            sb.append(x1.f15111d);
            reportAppPresenter5.addSurveyApp("", str, sb.toString());
        }
    }

    public final void onkeyback() {
        util.f1.a(this.mActivity, "\u653e\u5f03\u672c\u6b21\u4fe1\u606f\u7f16\u8f91\uff1f", "", "\u786e\u5b9a", "\u53d6\u6d88", -1, -1, true, (IClickListener) new c());
    }

    public final void setAppInfo(@j.c.a.e AppInfoBean appInfoBean) {
        this.appInfo = appInfoBean;
    }

    public final void setAppLogoName(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.appLogoName = str;
    }

    public final void setAppLogoPath(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.appLogoPath = str;
    }

    public final void setAppName(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.appName = str;
    }

    public final void setAppPkgPath(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.appPkgPath = str;
    }

    public final void setAppZXingName(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.appZXingName = str;
    }

    public final void setAppZXingPath(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.appZXingPath = str;
    }

    public final void setCaseInfoId(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setImgType(int i2) {
        this.imgType = i2;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_report_app_add;
    }

    public final void setListItem(int i2) {
        this.listItem = i2;
    }

    public final void setMAddAppBean(@j.c.a.e SurveyAppBean surveyAppBean) {
        this.mAddAppBean = surveyAppBean;
    }

    public final void setMAppBean(@j.c.a.e SurveyAppBean surveyAppBean) {
        this.mAppBean = surveyAppBean;
    }

    public final void setMBtnCommit(@j.c.a.d Button button) {
        i.q2.t.i0.f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMEtAppName(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtAppName = editText;
    }

    public final void setMEtInvitationCode(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtInvitationCode = editText;
    }

    public final void setMEtVictimAccount(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtVictimAccount = editText;
    }

    public final void setMEtVictimPwd(@j.c.a.d EditText editText) {
        i.q2.t.i0.f(editText, "<set-?>");
        this.mEtVictimPwd = editText;
    }

    public final void setMFlAppInfo(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mFlAppInfo = view;
    }

    public final void setMFlAppZxing(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mFlAppZxing = view;
    }

    public final void setMIvAppIcon(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvAppIcon = imageView;
    }

    public final void setMIvAppLogo(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvAppLogo = imageView;
    }

    public final void setMIvAppZxingPic(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvAppZxingPic = imageView;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlAddAppLogo(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlAddAppLogo = view;
    }

    public final void setMLlAddAppName(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlAddAppName = view;
    }

    public final void setMPresenter(@j.c.a.e ReportAppPresenter reportAppPresenter) {
        this.mPresenter = reportAppPresenter;
    }

    public final void setMSwitchApp(@j.c.a.d SwitchButton switchButton) {
        i.q2.t.i0.f(switchButton, "<set-?>");
        this.mSwitchApp = switchButton;
    }

    public final void setMSwitchZxing(@j.c.a.d SwitchButton switchButton) {
        i.q2.t.i0.f(switchButton, "<set-?>");
        this.mSwitchZxing = switchButton;
    }

    public final void setMTvAddApp(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mTvAddApp = view;
    }

    public final void setMTvAppName(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppName = textView;
    }

    public final void setMTvAppPkg(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppPkg = textView;
    }

    public final void setMTvAppVers(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppVers = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMediaPic(@j.c.a.e LocalMedia localMedia) {
        this.mediaPic = localMedia;
    }

    public final void setMediaPicLogo(@j.c.a.e LocalMedia localMedia) {
        this.mediaPicLogo = localMedia;
    }

    public final void setScrollView(@j.c.a.d NestedScrollView nestedScrollView) {
        i.q2.t.i0.f(nestedScrollView, "<set-?>");
        this.scrollView = nestedScrollView;
    }

    public final boolean upLoadApp() {
        AppInfoBean appInfoBean = this.appInfo;
        if (appInfoBean == null) {
            return false;
        }
        String pkgPath = appInfoBean != null ? appInfoBean.getPkgPath() : null;
        SurveyAppBean surveyAppBean = this.mAppBean;
        return !TextUtils.equals(pkgPath, surveyAppBean != null ? surveyAppBean.getPkgPath() : null);
    }

    public final boolean upLoadLogo() {
        LocalMedia localMedia = this.mediaPicLogo;
        if (localMedia == null) {
            return false;
        }
        String path = localMedia != null ? localMedia.getPath() : null;
        SurveyAppBean surveyAppBean = this.mAppBean;
        return !TextUtils.equals(path, surveyAppBean != null ? surveyAppBean.getAppLogoPath() : null);
    }

    public final boolean upLoadZXing() {
        LocalMedia localMedia = this.mediaPic;
        if (localMedia == null) {
            return false;
        }
        String path = localMedia != null ? localMedia.getPath() : null;
        SurveyAppBean surveyAppBean = this.mAppBean;
        return !TextUtils.equals(path, surveyAppBean != null ? surveyAppBean.getQrCodePath() : null);
    }
}
