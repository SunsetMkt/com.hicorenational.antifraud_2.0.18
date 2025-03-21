package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.taobao.agoo.p201a.p202a.AbstractC3059b;
import interfaces.IClickListener;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p286h.C5190a0;
import p286h.C5226e1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p357j.C5844c;
import p357j.C5845d;
import p388ui.callview.ReportAppView;
import p388ui.presenter.ReportAppPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.SwitchButton;
import util.C7257b1;
import util.C7292k1;
import util.C7316r1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;

/* compiled from: ReportAppAddActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001J\n\u0010\u009a\u0001\u001a\u00030\u0099\u0001H\u0016J\b\u0010\u009b\u0001\u001a\u00030\u0099\u0001J(\u0010\u009c\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009d\u0001\u001a\u00020$2\u0007\u0010\u009e\u0001\u001a\u00020$2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001H\u0016J\u0013\u0010¡\u0001\u001a\u00030\u0099\u00012\u0007\u0010¢\u0001\u001a\u00020KH\u0016J\n\u0010£\u0001\u001a\u00030\u0099\u0001H\u0014J\u0014\u0010¤\u0001\u001a\u00030\u0099\u00012\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0007J\n\u0010§\u0001\u001a\u00030\u0099\u0001H\u0016J\u0013\u0010¨\u0001\u001a\u00030\u0099\u00012\u0007\u0010©\u0001\u001a\u00020$H\u0016J\u001d\u0010ª\u0001\u001a\u00030«\u00012\u0007\u0010¬\u0001\u001a\u00020$2\b\u0010\u00ad\u0001\u001a\u00030®\u0001H\u0016J%\u0010¯\u0001\u001a\u00030\u0099\u00012\u0007\u0010°\u0001\u001a\u00020$2\u0010\u0010±\u0001\u001a\u000b\u0012\u0004\u0012\u00020-\u0018\u00010²\u0001H\u0016J\b\u0010³\u0001\u001a\u00030\u0099\u0001J\t\u0010´\u0001\u001a\u00020$H\u0016J\b\u0010µ\u0001\u001a\u00030«\u0001J\b\u0010¶\u0001\u001a\u00030«\u0001J\b\u0010·\u0001\u001a\u00030«\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010A\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u001e\u0010D\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R\u001e\u0010G\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010>\"\u0004\bI\u0010@R\u001e\u0010J\u001a\u00020K8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001e\u0010P\u001a\u00020K8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010OR\u001e\u0010S\u001a\u00020T8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001e\u0010Y\u001a\u00020T8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR\u001e\u0010\\\u001a\u00020T8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010V\"\u0004\b^\u0010XR\u001e\u0010_\u001a\u00020T8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010V\"\u0004\ba\u0010XR\u001e\u0010b\u001a\u00020K8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010M\"\u0004\bd\u0010OR\u001e\u0010e\u001a\u00020K8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010M\"\u0004\bg\u0010OR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001e\u0010n\u001a\u00020o8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001e\u0010t\u001a\u00020o8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010q\"\u0004\bv\u0010sR\u001e\u0010w\u001a\u00020K8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010M\"\u0004\by\u0010OR\u001e\u0010z\u001a\u00020{8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR!\u0010\u0080\u0001\u001a\u00020{8\u0006@\u0006X\u0087.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010}\"\u0005\b\u0082\u0001\u0010\u007fR!\u0010\u0083\u0001\u001a\u00020{8\u0006@\u0006X\u0087.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010}\"\u0005\b\u0085\u0001\u0010\u007fR!\u0010\u0086\u0001\u001a\u00020{8\u0006@\u0006X\u0087.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010}\"\u0005\b\u0088\u0001\u0010\u007fR\"\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u008c\u0001\"\u0006\b\u0091\u0001\u0010\u008e\u0001R$\u0010\u0092\u0001\u001a\u00030\u0093\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001¨\u0006¸\u0001"}, m23546d2 = {"Lui/activity/ReportAppAddActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/callview/ReportAppView;", "()V", "appInfo", "Lbean/AppInfoBean;", "getAppInfo", "()Lbean/AppInfoBean;", "setAppInfo", "(Lbean/AppInfoBean;)V", "appLogoName", "", "getAppLogoName", "()Ljava/lang/String;", "setAppLogoName", "(Ljava/lang/String;)V", "appLogoPath", "getAppLogoPath", "setAppLogoPath", "appName", "getAppName", "setAppName", "appPkgPath", "getAppPkgPath", "setAppPkgPath", "appZXingName", "getAppZXingName", "setAppZXingName", "appZXingPath", "getAppZXingPath", "setAppZXingPath", "caseInfoId", "getCaseInfoId", "setCaseInfoId", "imgType", "", "getImgType", "()I", "setImgType", "(I)V", "listItem", "getListItem", "setListItem", "mAddAppBean", "Lbean/SurveyAppBean;", "getMAddAppBean", "()Lbean/SurveyAppBean;", "setMAddAppBean", "(Lbean/SurveyAppBean;)V", "mAppBean", "getMAppBean", "setMAppBean", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mEtAppName", "Landroid/widget/EditText;", "getMEtAppName", "()Landroid/widget/EditText;", "setMEtAppName", "(Landroid/widget/EditText;)V", "mEtInvitationCode", "getMEtInvitationCode", "setMEtInvitationCode", "mEtVictimAccount", "getMEtVictimAccount", "setMEtVictimAccount", "mEtVictimPwd", "getMEtVictimPwd", "setMEtVictimPwd", "mFlAppInfo", "Landroid/view/View;", "getMFlAppInfo", "()Landroid/view/View;", "setMFlAppInfo", "(Landroid/view/View;)V", "mFlAppZxing", "getMFlAppZxing", "setMFlAppZxing", "mIvAppIcon", "Landroid/widget/ImageView;", "getMIvAppIcon", "()Landroid/widget/ImageView;", "setMIvAppIcon", "(Landroid/widget/ImageView;)V", "mIvAppLogo", "getMIvAppLogo", "setMIvAppLogo", "mIvAppZxingPic", "getMIvAppZxingPic", "setMIvAppZxingPic", "mIvBack", "getMIvBack", "setMIvBack", "mLlAddAppLogo", "getMLlAddAppLogo", "setMLlAddAppLogo", "mLlAddAppName", "getMLlAddAppName", "setMLlAddAppName", "mPresenter", "Lui/presenter/ReportAppPresenter;", "getMPresenter", "()Lui/presenter/ReportAppPresenter;", "setMPresenter", "(Lui/presenter/ReportAppPresenter;)V", "mSwitchApp", "Lui/view/SwitchButton;", "getMSwitchApp", "()Lui/view/SwitchButton;", "setMSwitchApp", "(Lui/view/SwitchButton;)V", "mSwitchZxing", "getMSwitchZxing", "setMSwitchZxing", "mTvAddApp", "getMTvAddApp", "setMTvAddApp", "mTvAppName", "Landroid/widget/TextView;", "getMTvAppName", "()Landroid/widget/TextView;", "setMTvAppName", "(Landroid/widget/TextView;)V", "mTvAppPkg", "getMTvAppPkg", "setMTvAppPkg", "mTvAppVers", "getMTvAppVers", "setMTvAppVers", "mTvTitle", "getMTvTitle", "setMTvTitle", "mediaPic", "Lcom/luck/picture/lib/entity/LocalMedia;", "getMediaPic", "()Lcom/luck/picture/lib/entity/LocalMedia;", "setMediaPic", "(Lcom/luck/picture/lib/entity/LocalMedia;)V", "mediaPicLogo", "getMediaPicLogo", "setMediaPicLogo", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScrollView", "()Landroidx/core/widget/NestedScrollView;", "setScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "initListener", "", "initPage", "initViewData", "onActivityResult", "requestCode", AbstractC3059b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onClick", "view", "onDestroy", "onEventMainThread", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onFailRequest", "onItemDelet", "itemPos", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onSuccessHandle", "type", "list", "", "onkeyback", "setLayoutView", "upLoadApp", "upLoadLogo", "upLoadZXing", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReportAppAddActivity extends BaseActivity implements View.OnClickListener, ReportAppView {

    @InterfaceC5817e
    private AppInfoBean appInfo;
    private int imgType;
    private int listItem;

    @InterfaceC5817e
    private SurveyAppBean mAddAppBean;

    @InterfaceC5817e
    private SurveyAppBean mAppBean;

    @BindView(C2113R.id.btn_commit)
    @InterfaceC5816d
    public Button mBtnCommit;

    @BindView(C2113R.id.et_app_name)
    @InterfaceC5816d
    public EditText mEtAppName;

    @BindView(C2113R.id.et_app_invitationCode)
    @InterfaceC5816d
    public EditText mEtInvitationCode;

    @BindView(C2113R.id.et_app_victimAccount)
    @InterfaceC5816d
    public EditText mEtVictimAccount;

    @BindView(C2113R.id.et_app_victimPwd)
    @InterfaceC5816d
    public EditText mEtVictimPwd;

    @BindView(C2113R.id.fl_app_view)
    @InterfaceC5816d
    public View mFlAppInfo;

    @BindView(C2113R.id.fl_app_zxing)
    @InterfaceC5816d
    public View mFlAppZxing;

    @BindView(C2113R.id.iv_icon)
    @InterfaceC5816d
    public ImageView mIvAppIcon;

    @BindView(C2113R.id.iv_add_logo)
    @InterfaceC5816d
    public ImageView mIvAppLogo;

    @BindView(C2113R.id.iv_add_zxing)
    @InterfaceC5816d
    public ImageView mIvAppZxingPic;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.fl_app_logo)
    @InterfaceC5816d
    public View mLlAddAppLogo;

    @BindView(C2113R.id.fl_add_name)
    @InterfaceC5816d
    public View mLlAddAppName;

    @InterfaceC5817e
    private ReportAppPresenter mPresenter;

    @BindView(C2113R.id.switchShow_app)
    @InterfaceC5816d
    public SwitchButton mSwitchApp;

    @BindView(C2113R.id.switchShow_zxing)
    @InterfaceC5816d
    public SwitchButton mSwitchZxing;

    @BindView(C2113R.id.fl_add_app)
    @InterfaceC5816d
    public View mTvAddApp;

    @BindView(C2113R.id.tv_app_name)
    @InterfaceC5816d
    public TextView mTvAppName;

    @BindView(C2113R.id.tv_app_pkg)
    @InterfaceC5816d
    public TextView mTvAppPkg;

    @BindView(C2113R.id.tv_app_vers)
    @InterfaceC5816d
    public TextView mTvAppVers;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @InterfaceC5817e
    private LocalMedia mediaPic;

    @InterfaceC5817e
    private LocalMedia mediaPicLogo;

    @BindView(C2113R.id.scrollView)
    @InterfaceC5816d
    public NestedScrollView scrollView;

    @InterfaceC5816d
    private String caseInfoId = "";

    @InterfaceC5816d
    private String appPkgPath = "";

    @InterfaceC5816d
    private String appName = "";

    @InterfaceC5816d
    private String appZXingPath = "";

    @InterfaceC5816d
    private String appZXingName = "";

    @InterfaceC5816d
    private String appLogoPath = "";

    @InterfaceC5816d
    private String appLogoName = "";

    /* compiled from: ReportAppAddActivity.kt */
    /* renamed from: ui.activity.ReportAppAddActivity$a */
    static final class C6490a implements CompoundButton.OnCheckedChangeListener {
        C6490a() {
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

    /* compiled from: ReportAppAddActivity.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, m23546d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, m23547k = 3, m23548mv = {1, 1, 16})
    /* renamed from: ui.activity.ReportAppAddActivity$b */
    static final class C6491b implements CompoundButton.OnCheckedChangeListener {

        /* compiled from: ReportAppAddActivity.kt */
        /* renamed from: ui.activity.ReportAppAddActivity$b$a */
        public static final class a implements IClickListener {
            a() {
            }

            @Override // interfaces.IClickListener
            public void cancelBtn() {
                ReportAppAddActivity.this.getMFlAppZxing().setVisibility(8);
                ReportAppAddActivity.this.getMSwitchZxing().setChecked(false);
                ReportAppAddActivity.this.setMediaPic(null);
                ReportAppAddActivity.this.setAppZXingPath("");
                C5845d.m24613b(ReportAppAddActivity.this.getMIvAppZxingPic(), ReportAppAddActivity.this.getAppZXingPath());
            }

            @Override // interfaces.IClickListener
            public void clickOKBtn() {
                ReportAppAddActivity.this.getMSwitchZxing().setChecked(true);
            }
        }

        C6491b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                ReportAppAddActivity.this.getMFlAppZxing().setVisibility(0);
            } else if (TextUtils.isEmpty(ReportAppAddActivity.this.getAppZXingPath())) {
                ReportAppAddActivity.this.getMFlAppZxing().setVisibility(8);
            } else {
                C7257b1.m26184a(ReportAppAddActivity.this.mActivity, "关闭按钮将不保留信息？", "", "确定", "取消", -1, -1, true, (IClickListener) new a());
            }
        }
    }

    /* compiled from: ReportAppAddActivity.kt */
    /* renamed from: ui.activity.ReportAppAddActivity$c */
    public static final class C6492c implements IClickListener {
        C6492c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportAppAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @InterfaceC5817e
    public final AppInfoBean getAppInfo() {
        return this.appInfo;
    }

    @InterfaceC5816d
    public final String getAppLogoName() {
        return this.appLogoName;
    }

    @InterfaceC5816d
    public final String getAppLogoPath() {
        return this.appLogoPath;
    }

    @InterfaceC5816d
    public final String getAppName() {
        return this.appName;
    }

    @InterfaceC5816d
    public final String getAppPkgPath() {
        return this.appPkgPath;
    }

    @InterfaceC5816d
    public final String getAppZXingName() {
        return this.appZXingName;
    }

    @InterfaceC5816d
    public final String getAppZXingPath() {
        return this.appZXingPath;
    }

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getImgType() {
        return this.imgType;
    }

    public final int getListItem() {
        return this.listItem;
    }

    @InterfaceC5817e
    public final SurveyAppBean getMAddAppBean() {
        return this.mAddAppBean;
    }

    @InterfaceC5817e
    public final SurveyAppBean getMAppBean() {
        return this.mAppBean;
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
    public final EditText getMEtAppName() {
        EditText editText = this.mEtAppName;
        if (editText == null) {
            C5544i0.m22554k("mEtAppName");
        }
        return editText;
    }

    @InterfaceC5816d
    public final EditText getMEtInvitationCode() {
        EditText editText = this.mEtInvitationCode;
        if (editText == null) {
            C5544i0.m22554k("mEtInvitationCode");
        }
        return editText;
    }

    @InterfaceC5816d
    public final EditText getMEtVictimAccount() {
        EditText editText = this.mEtVictimAccount;
        if (editText == null) {
            C5544i0.m22554k("mEtVictimAccount");
        }
        return editText;
    }

    @InterfaceC5816d
    public final EditText getMEtVictimPwd() {
        EditText editText = this.mEtVictimPwd;
        if (editText == null) {
            C5544i0.m22554k("mEtVictimPwd");
        }
        return editText;
    }

    @InterfaceC5816d
    public final View getMFlAppInfo() {
        View view = this.mFlAppInfo;
        if (view == null) {
            C5544i0.m22554k("mFlAppInfo");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMFlAppZxing() {
        View view = this.mFlAppZxing;
        if (view == null) {
            C5544i0.m22554k("mFlAppZxing");
        }
        return view;
    }

    @InterfaceC5816d
    public final ImageView getMIvAppIcon() {
        ImageView imageView = this.mIvAppIcon;
        if (imageView == null) {
            C5544i0.m22554k("mIvAppIcon");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvAppLogo() {
        ImageView imageView = this.mIvAppLogo;
        if (imageView == null) {
            C5544i0.m22554k("mIvAppLogo");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvAppZxingPic() {
        ImageView imageView = this.mIvAppZxingPic;
        if (imageView == null) {
            C5544i0.m22554k("mIvAppZxingPic");
        }
        return imageView;
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
    public final View getMLlAddAppLogo() {
        View view = this.mLlAddAppLogo;
        if (view == null) {
            C5544i0.m22554k("mLlAddAppLogo");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlAddAppName() {
        View view = this.mLlAddAppName;
        if (view == null) {
            C5544i0.m22554k("mLlAddAppName");
        }
        return view;
    }

    @InterfaceC5817e
    public final ReportAppPresenter getMPresenter() {
        return this.mPresenter;
    }

    @InterfaceC5816d
    public final SwitchButton getMSwitchApp() {
        SwitchButton switchButton = this.mSwitchApp;
        if (switchButton == null) {
            C5544i0.m22554k("mSwitchApp");
        }
        return switchButton;
    }

    @InterfaceC5816d
    public final SwitchButton getMSwitchZxing() {
        SwitchButton switchButton = this.mSwitchZxing;
        if (switchButton == null) {
            C5544i0.m22554k("mSwitchZxing");
        }
        return switchButton;
    }

    @InterfaceC5816d
    public final View getMTvAddApp() {
        View view = this.mTvAddApp;
        if (view == null) {
            C5544i0.m22554k("mTvAddApp");
        }
        return view;
    }

    @InterfaceC5816d
    public final TextView getMTvAppName() {
        TextView textView = this.mTvAppName;
        if (textView == null) {
            C5544i0.m22554k("mTvAppName");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvAppPkg() {
        TextView textView = this.mTvAppPkg;
        if (textView == null) {
            C5544i0.m22554k("mTvAppPkg");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvAppVers() {
        TextView textView = this.mTvAppVers;
        if (textView == null) {
            C5544i0.m22554k("mTvAppVers");
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
    public final LocalMedia getMediaPic() {
        return this.mediaPic;
    }

    @InterfaceC5817e
    public final LocalMedia getMediaPicLogo() {
        return this.mediaPicLogo;
    }

    @InterfaceC5816d
    public final NestedScrollView getScrollView() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            C5544i0.m22554k("scrollView");
        }
        return nestedScrollView;
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
        View view = this.mTvAddApp;
        if (view == null) {
            C5544i0.m22554k("mTvAddApp");
        }
        if (view == null) {
            C5544i0.m22545f();
        }
        view.setOnClickListener(this);
        ImageView imageView2 = this.mIvAppZxingPic;
        if (imageView2 == null) {
            C5544i0.m22554k("mIvAppZxingPic");
        }
        if (imageView2 == null) {
            C5544i0.m22545f();
        }
        imageView2.setOnClickListener(this);
        ImageView imageView3 = this.mIvAppLogo;
        if (imageView3 == null) {
            C5544i0.m22554k("mIvAppLogo");
        }
        if (imageView3 == null) {
            C5544i0.m22545f();
        }
        imageView3.setOnClickListener(this);
        Button button = this.mBtnCommit;
        if (button == null) {
            C5544i0.m22554k("mBtnCommit");
        }
        if (button == null) {
            C5544i0.m22545f();
        }
        button.setOnClickListener(this);
        SwitchButton switchButton = this.mSwitchApp;
        if (switchButton == null) {
            C5544i0.m22554k("mSwitchApp");
        }
        switchButton.setOnCheckedChangeListener(new C6490a());
        SwitchButton switchButton2 = this.mSwitchZxing;
        if (switchButton2 == null) {
            C5544i0.m22554k("mSwitchZxing");
        }
        switchButton2.setOnCheckedChangeListener(new C6491b());
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        C7161b.m25698a((Activity) this, true, true);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("添加诈骗APP");
        initViewData();
        initListener();
        this.mPresenter = new ReportAppPresenter(this.mActivity, this.caseInfoId, this);
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            C5544i0.m22554k("scrollView");
        }
        C7337y1.m26754a(nestedScrollView, this.mActivity);
    }

    public final void initViewData() {
        this.listItem = getIntent().getIntExtra(C7292k1.f25344F0, 0);
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mAppBean = (SurveyAppBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        SurveyAppBean surveyAppBean = this.mAppBean;
        if (surveyAppBean == null) {
            View view = this.mFlAppZxing;
            if (view == null) {
                C5544i0.m22554k("mFlAppZxing");
            }
            view.setVisibility(8);
            SwitchButton switchButton = this.mSwitchZxing;
            if (switchButton == null) {
                C5544i0.m22554k("mSwitchZxing");
            }
            switchButton.setChecked(false);
            return;
        }
        if (TextUtils.isEmpty(surveyAppBean != null ? surveyAppBean.getPackageFileUrl() : null)) {
            View view2 = this.mFlAppInfo;
            if (view2 == null) {
                C5544i0.m22554k("mFlAppInfo");
            }
            view2.setVisibility(8);
            View view3 = this.mTvAddApp;
            if (view3 == null) {
                C5544i0.m22554k("mTvAddApp");
            }
            view3.setVisibility(8);
            View view4 = this.mLlAddAppName;
            if (view4 == null) {
                C5544i0.m22554k("mLlAddAppName");
            }
            view4.setVisibility(0);
            View view5 = this.mLlAddAppLogo;
            if (view5 == null) {
                C5544i0.m22554k("mLlAddAppLogo");
            }
            view5.setVisibility(0);
            EditText editText = this.mEtAppName;
            if (editText == null) {
                C5544i0.m22554k("mEtAppName");
            }
            SurveyAppBean surveyAppBean2 = this.mAppBean;
            editText.setText(surveyAppBean2 != null ? surveyAppBean2.getAppName() : null);
        } else {
            SwitchButton switchButton2 = this.mSwitchApp;
            if (switchButton2 == null) {
                C5544i0.m22554k("mSwitchApp");
            }
            switchButton2.setChecked(true);
            View view6 = this.mTvAddApp;
            if (view6 == null) {
                C5544i0.m22554k("mTvAddApp");
            }
            view6.setVisibility(0);
            View view7 = this.mFlAppInfo;
            if (view7 == null) {
                C5544i0.m22554k("mFlAppInfo");
            }
            view7.setVisibility(0);
            View view8 = this.mLlAddAppName;
            if (view8 == null) {
                C5544i0.m22554k("mLlAddAppName");
            }
            view8.setVisibility(8);
            View view9 = this.mLlAddAppLogo;
            if (view9 == null) {
                C5544i0.m22554k("mLlAddAppLogo");
            }
            view9.setVisibility(8);
            TextView textView = this.mTvAppName;
            if (textView == null) {
                C5544i0.m22554k("mTvAppName");
            }
            SurveyAppBean surveyAppBean3 = this.mAppBean;
            textView.setText(surveyAppBean3 != null ? surveyAppBean3.getAppName() : null);
            TextView textView2 = this.mTvAppVers;
            if (textView2 == null) {
                C5544i0.m22554k("mTvAppVers");
            }
            SurveyAppBean surveyAppBean4 = this.mAppBean;
            textView2.setText(surveyAppBean4 != null ? surveyAppBean4.getAppVersion() : null);
            TextView textView3 = this.mTvAppPkg;
            if (textView3 == null) {
                C5544i0.m22554k("mTvAppPkg");
            }
            SurveyAppBean surveyAppBean5 = this.mAppBean;
            textView3.setText(surveyAppBean5 != null ? surveyAppBean5.getPackageName() : null);
            SurveyAppBean surveyAppBean6 = this.mAppBean;
            String packageFileUrl = surveyAppBean6 != null ? surveyAppBean6.getPackageFileUrl() : null;
            if (packageFileUrl == null) {
                C5544i0.m22545f();
            }
            this.appPkgPath = packageFileUrl;
            SurveyAppBean surveyAppBean7 = this.mAppBean;
            String appName = surveyAppBean7 != null ? surveyAppBean7.getAppName() : null;
            SurveyAppBean surveyAppBean8 = this.mAppBean;
            Bitmap m24589a = C5844c.m24589a(appName, surveyAppBean8 != null ? surveyAppBean8.getAppVersion() : null, C5844c.f21117f);
            ImageView imageView = this.mIvAppIcon;
            if (imageView == null) {
                C5544i0.m22554k("mIvAppIcon");
            }
            imageView.setImageBitmap(m24589a);
        }
        SurveyAppBean surveyAppBean9 = this.mAppBean;
        if (!TextUtils.isEmpty(surveyAppBean9 != null ? surveyAppBean9.getAppLogoFileUrl() : null)) {
            ImageView imageView2 = this.mIvAppLogo;
            if (imageView2 == null) {
                C5544i0.m22554k("mIvAppLogo");
            }
            SurveyAppBean surveyAppBean10 = this.mAppBean;
            C5845d.m24613b(imageView2, surveyAppBean10 != null ? surveyAppBean10.getAppLogoFileUrl() : null);
        }
        SurveyAppBean surveyAppBean11 = this.mAppBean;
        if (!TextUtils.isEmpty(surveyAppBean11 != null ? surveyAppBean11.getQrCodeFileUrl() : null)) {
            ImageView imageView3 = this.mIvAppZxingPic;
            if (imageView3 == null) {
                C5544i0.m22554k("mIvAppZxingPic");
            }
            SurveyAppBean surveyAppBean12 = this.mAppBean;
            C5845d.m24613b(imageView3, surveyAppBean12 != null ? surveyAppBean12.getQrCodeFileUrl() : null);
            View view10 = this.mFlAppZxing;
            if (view10 == null) {
                C5544i0.m22554k("mFlAppZxing");
            }
            view10.setVisibility(0);
            SwitchButton switchButton3 = this.mSwitchZxing;
            if (switchButton3 == null) {
                C5544i0.m22554k("mSwitchZxing");
            }
            switchButton3.setChecked(true);
        }
        SurveyAppBean surveyAppBean13 = this.mAppBean;
        if (!TextUtils.isEmpty(surveyAppBean13 != null ? surveyAppBean13.getVictimAccount() : null)) {
            EditText editText2 = this.mEtVictimAccount;
            if (editText2 == null) {
                C5544i0.m22554k("mEtVictimAccount");
            }
            SurveyAppBean surveyAppBean14 = this.mAppBean;
            editText2.setText(surveyAppBean14 != null ? surveyAppBean14.getVictimAccount() : null);
        }
        SurveyAppBean surveyAppBean15 = this.mAppBean;
        if (!TextUtils.isEmpty(surveyAppBean15 != null ? surveyAppBean15.getVictimPwd() : null)) {
            EditText editText3 = this.mEtVictimPwd;
            if (editText3 == null) {
                C5544i0.m22554k("mEtVictimPwd");
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
            C5544i0.m22554k("mEtInvitationCode");
        }
        SurveyAppBean surveyAppBean18 = this.mAppBean;
        editText4.setText(surveyAppBean18 != null ? surveyAppBean18.getInvitationCode() : null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @InterfaceC5817e Intent intent) {
        List obtainMultipleResult;
        String fileName;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 188 || (obtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || obtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            C7337y1.m26751a(this.mActivity, (List<LocalMedia>) obtainMultipleResult);
        }
        List<LocalMedia> m26741a = C7337y1.m26741a((List<LocalMedia>) obtainMultipleResult);
        if (this.imgType == 1) {
            this.mediaPic = m26741a.get(0);
            ImageView imageView = this.mIvAppZxingPic;
            if (imageView == null) {
                C5544i0.m22554k("mIvAppZxingPic");
            }
            LocalMedia localMedia = this.mediaPic;
            C5845d.m24613b(imageView, localMedia != null ? localMedia.getPath() : null);
            LocalMedia localMedia2 = this.mediaPic;
            String path = localMedia2 != null ? localMedia2.getPath() : null;
            if (path == null) {
                C5544i0.m22545f();
            }
            this.appZXingPath = path;
            LocalMedia localMedia3 = this.mediaPic;
            fileName = localMedia3 != null ? localMedia3.getFileName() : null;
            if (fileName == null) {
                C5544i0.m22545f();
            }
            this.appZXingName = fileName;
            SurveyAppBean surveyAppBean = this.mAppBean;
            if (surveyAppBean != null) {
                if (surveyAppBean == null) {
                    C5544i0.m22545f();
                }
                surveyAppBean.setQrCodeFileID("");
                SurveyAppBean surveyAppBean2 = this.mAppBean;
                if (surveyAppBean2 == null) {
                    C5544i0.m22545f();
                }
                surveyAppBean2.setQrCodeFileUrl("");
                return;
            }
            return;
        }
        this.mediaPicLogo = m26741a.get(0);
        ImageView imageView2 = this.mIvAppLogo;
        if (imageView2 == null) {
            C5544i0.m22554k("mIvAppLogo");
        }
        LocalMedia localMedia4 = this.mediaPicLogo;
        C5845d.m24613b(imageView2, localMedia4 != null ? localMedia4.getPath() : null);
        LocalMedia localMedia5 = this.mediaPicLogo;
        String path2 = localMedia5 != null ? localMedia5.getPath() : null;
        if (path2 == null) {
            C5544i0.m22545f();
        }
        this.appLogoPath = path2;
        LocalMedia localMedia6 = this.mediaPicLogo;
        fileName = localMedia6 != null ? localMedia6.getFileName() : null;
        if (fileName == null) {
            C5544i0.m22545f();
        }
        this.appLogoName = fileName;
        SurveyAppBean surveyAppBean3 = this.mAppBean;
        if (surveyAppBean3 != null) {
            if (surveyAppBean3 == null) {
                C5544i0.m22545f();
            }
            surveyAppBean3.setAppLogoFileID("");
            SurveyAppBean surveyAppBean4 = this.mAppBean;
            if (surveyAppBean4 == null) {
                C5544i0.m22545f();
            }
            surveyAppBean4.setAppLogoFileUrl("");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@InterfaceC5816d View view) {
        SurveyAppBean surveyAppBean;
        SurveyAppBean surveyAppBean2;
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                TextView textView = this.mTvAppName;
                if (textView == null) {
                    C5544i0.m22554k("mTvAppName");
                }
                String obj = textView.getText().toString();
                TextView textView2 = this.mTvAppPkg;
                if (textView2 == null) {
                    C5544i0.m22554k("mTvAppPkg");
                }
                String obj2 = textView2.getText().toString();
                TextView textView3 = this.mTvAppVers;
                if (textView3 == null) {
                    C5544i0.m22554k("mTvAppVers");
                }
                String obj3 = textView3.getText().toString();
                EditText editText = this.mEtAppName;
                if (editText == null) {
                    C5544i0.m22554k("mEtAppName");
                }
                String obj4 = editText.getText().toString();
                EditText editText2 = this.mEtVictimAccount;
                if (editText2 == null) {
                    C5544i0.m22554k("mEtVictimAccount");
                }
                String obj5 = editText2.getText().toString();
                EditText editText3 = this.mEtVictimPwd;
                if (editText3 == null) {
                    C5544i0.m22554k("mEtVictimPwd");
                }
                String obj6 = editText3.getText().toString();
                EditText editText4 = this.mEtInvitationCode;
                if (editText4 == null) {
                    C5544i0.m22554k("mEtInvitationCode");
                }
                String obj7 = editText4.getText().toString();
                SwitchButton switchButton = this.mSwitchApp;
                if (switchButton == null) {
                    C5544i0.m22554k("mSwitchApp");
                }
                if (switchButton.isChecked()) {
                    if (TextUtils.isEmpty(this.appPkgPath)) {
                        C7331w1.m26688a("请添加诈骗APP");
                        break;
                    } else {
                        this.appLogoPath = "";
                    }
                } else if (TextUtils.isEmpty(obj4)) {
                    C7331w1.m26688a("请添加诈骗APP名称");
                    break;
                } else {
                    this.appPkgPath = "";
                    obj = obj4;
                    obj2 = "";
                    obj3 = obj2;
                }
                SwitchButton switchButton2 = this.mSwitchZxing;
                if (switchButton2 == null) {
                    C5544i0.m22554k("mSwitchZxing");
                }
                if (!switchButton2.isChecked()) {
                    this.appZXingPath = "";
                    this.appZXingName = "";
                } else if (TextUtils.isEmpty(this.appZXingPath)) {
                    SurveyAppBean surveyAppBean3 = this.mAppBean;
                    if (surveyAppBean3 != null) {
                        if (surveyAppBean3 == null) {
                            C5544i0.m22545f();
                        }
                        if (TextUtils.isEmpty(surveyAppBean3.getQrCodeFileUrl())) {
                            C7331w1.m26688a("请添加下载二维码");
                            break;
                        }
                    } else {
                        C7331w1.m26688a("请添加下载二维码");
                        break;
                    }
                }
                if (!TextUtils.isEmpty(obj5)) {
                    if (!TextUtils.isEmpty(obj6)) {
                        boolean upLoadApp = upLoadApp();
                        boolean upLoadZXing = upLoadZXing();
                        boolean upLoadLogo = upLoadLogo();
                        SurveyAppBean surveyAppBean4 = this.mAppBean;
                        if (surveyAppBean4 != null) {
                            if (surveyAppBean4 != null) {
                                surveyAppBean4.setUpdateTime(C7337y1.m26773d());
                            }
                            SurveyAppBean surveyAppBean5 = this.mAppBean;
                            if (surveyAppBean5 != null) {
                                surveyAppBean5.setCaseInfoID(this.caseInfoId);
                            }
                            SurveyAppBean surveyAppBean6 = this.mAppBean;
                            if (surveyAppBean6 != null) {
                                surveyAppBean6.setAppName(obj);
                            }
                            SurveyAppBean surveyAppBean7 = this.mAppBean;
                            if (surveyAppBean7 != null) {
                                surveyAppBean7.setPackageName(obj2);
                            }
                            SurveyAppBean surveyAppBean8 = this.mAppBean;
                            if (surveyAppBean8 != null) {
                                surveyAppBean8.setAppVersion(obj3);
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
                                surveyAppBean16.setVictimAccount(obj5);
                            }
                            SurveyAppBean surveyAppBean17 = this.mAppBean;
                            if (surveyAppBean17 != null) {
                                surveyAppBean17.setVictimPwd(obj6);
                            }
                            SurveyAppBean surveyAppBean18 = this.mAppBean;
                            if (surveyAppBean18 != null) {
                                surveyAppBean18.setInvitationCode(obj7);
                            }
                            SwitchButton switchButton3 = this.mSwitchApp;
                            if (switchButton3 == null) {
                                C5544i0.m22554k("mSwitchApp");
                            }
                            if (switchButton3.isChecked() && (surveyAppBean2 = this.mAppBean) != null) {
                                surveyAppBean2.setAppLogoFileID("");
                            }
                            SwitchButton switchButton4 = this.mSwitchZxing;
                            if (switchButton4 == null) {
                                C5544i0.m22554k("mSwitchZxing");
                            }
                            if (!switchButton4.isChecked() && (surveyAppBean = this.mAppBean) != null) {
                                surveyAppBean.setQrCodeFileID("");
                            }
                            ReportAppPresenter reportAppPresenter = this.mPresenter;
                            if (reportAppPresenter != null) {
                                reportAppPresenter.handleUpdate(this.mAppBean, upLoadApp, upLoadZXing, upLoadLogo);
                            }
                        } else {
                            this.mAddAppBean = new SurveyAppBean();
                            SurveyAppBean surveyAppBean19 = this.mAddAppBean;
                            if (surveyAppBean19 != null) {
                                surveyAppBean19.setCreateTime(C7337y1.m26773d());
                            }
                            SurveyAppBean surveyAppBean20 = this.mAddAppBean;
                            if (surveyAppBean20 != null) {
                                surveyAppBean20.setCaseInfoID(this.caseInfoId);
                            }
                            SurveyAppBean surveyAppBean21 = this.mAddAppBean;
                            if (surveyAppBean21 != null) {
                                surveyAppBean21.setAppName(obj);
                            }
                            SurveyAppBean surveyAppBean22 = this.mAddAppBean;
                            if (surveyAppBean22 != null) {
                                surveyAppBean22.setPackageName(obj2);
                            }
                            SurveyAppBean surveyAppBean23 = this.mAddAppBean;
                            if (surveyAppBean23 != null) {
                                surveyAppBean23.setAppVersion(obj3);
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
                                surveyAppBean29.setVictimAccount(obj5);
                            }
                            SurveyAppBean surveyAppBean30 = this.mAddAppBean;
                            if (surveyAppBean30 != null) {
                                surveyAppBean30.setVictimPwd(obj6);
                            }
                            SurveyAppBean surveyAppBean31 = this.mAddAppBean;
                            if (surveyAppBean31 != null) {
                                surveyAppBean31.setInvitationCode(obj7);
                            }
                            ReportAppPresenter reportAppPresenter2 = this.mPresenter;
                            if (reportAppPresenter2 != null) {
                                reportAppPresenter2.handleUpdate(this.mAddAppBean, upLoadApp, upLoadZXing, upLoadLogo);
                            }
                        }
                        showProgressDialog("上传中...", true);
                        break;
                    } else {
                        C7331w1.m26688a("请输入受害人的APP密码");
                        break;
                    }
                } else {
                    C7331w1.m26688a("请输入受害人的APP账号");
                    break;
                }
            case C2113R.id.fl_add_app /* 2131296613 */:
                ReportAppPresenter reportAppPresenter3 = this.mPresenter;
                if (reportAppPresenter3 != null) {
                    reportAppPresenter3.addAppCheck();
                    break;
                }
                break;
            case C2113R.id.iv_add_logo /* 2131296742 */:
                this.imgType = 0;
                ReportAppPresenter reportAppPresenter4 = this.mPresenter;
                if (reportAppPresenter4 != null) {
                    reportAppPresenter4.addPicCheck();
                    break;
                }
                break;
            case C2113R.id.iv_add_zxing /* 2131296744 */:
                this.imgType = 1;
                ReportAppPresenter reportAppPresenter5 = this.mPresenter;
                if (reportAppPresenter5 != null) {
                    reportAppPresenter5.addPicCheck();
                    break;
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onkeyback();
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@InterfaceC5816d C7265a c7265a) {
        C5544i0.m22546f(c7265a, "refreshUIEvent");
        if (c7265a.m26297a() != 30) {
            return;
        }
        Object m26300b = c7265a.m26300b();
        if (m26300b == null) {
            throw new C5226e1("null cannot be cast to non-null type bean.AppInfoBean");
        }
        this.appInfo = (AppInfoBean) m26300b;
        if (this.appInfo != null) {
            View view = this.mFlAppInfo;
            if (view == null) {
                C5544i0.m22554k("mFlAppInfo");
            }
            view.setVisibility(0);
            TextView textView = this.mTvAppName;
            if (textView == null) {
                C5544i0.m22554k("mTvAppName");
            }
            AppInfoBean appInfoBean = this.appInfo;
            textView.setText(appInfoBean != null ? appInfoBean.getName() : null);
            TextView textView2 = this.mTvAppVers;
            if (textView2 == null) {
                C5544i0.m22554k("mTvAppVers");
            }
            AppInfoBean appInfoBean2 = this.appInfo;
            textView2.setText(appInfoBean2 != null ? appInfoBean2.getVersionCode() : null);
            TextView textView3 = this.mTvAppPkg;
            if (textView3 == null) {
                C5544i0.m22554k("mTvAppPkg");
            }
            AppInfoBean appInfoBean3 = this.appInfo;
            textView3.setText(appInfoBean3 != null ? appInfoBean3.getPkgName() : null);
            ImageView imageView = this.mIvAppIcon;
            if (imageView == null) {
                C5544i0.m22554k("mIvAppIcon");
            }
            AppInfoBean appInfoBean4 = this.appInfo;
            imageView.setImageDrawable(appInfoBean4 != null ? appInfoBean4.getAppIcon() : null);
            AppInfoBean appInfoBean5 = this.appInfo;
            Bitmap m24588a = C5844c.m24588a(appInfoBean5 != null ? appInfoBean5.getAppIcon() : null);
            AppInfoBean appInfoBean6 = this.appInfo;
            String name = appInfoBean6 != null ? appInfoBean6.getName() : null;
            AppInfoBean appInfoBean7 = this.appInfo;
            C5844c.m24592a(m24588a, name, appInfoBean7 != null ? appInfoBean7.getVersionCode() : null, C5844c.f21117f);
            AppInfoBean appInfoBean8 = this.appInfo;
            if ((appInfoBean8 != null ? appInfoBean8.getPkgPath() : null) != null) {
                AppInfoBean appInfoBean9 = this.appInfo;
                String pkgPath = appInfoBean9 != null ? appInfoBean9.getPkgPath() : null;
                if (pkgPath == null) {
                    C5544i0.m22545f();
                }
                this.appPkgPath = pkgPath;
                AppInfoBean appInfoBean10 = this.appInfo;
                String name2 = appInfoBean10 != null ? appInfoBean10.getName() : null;
                if (name2 == null) {
                    C5544i0.m22545f();
                }
                this.appName = name2;
            }
        }
    }

    @Override // p388ui.callview.ReportAppView
    public void onFailRequest() {
        hideProgressDialog();
    }

    @Override // p388ui.callview.ReportAppView
    public void onItemDelet(int i2) {
        throw new C5190a0("An operation is not implemented: not implemented");
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

    @Override // p388ui.callview.ReportAppView
    public void onSuccessHandle(int i2, @InterfaceC5817e List<SurveyAppBean> list) {
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
                    C7331w1.m26688a("添加成功");
                    hideProgressDialog();
                    finish();
                    return;
                } else {
                    if (i2 == 3) {
                        C7331w1.m26688a("修改成功");
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
            C5544i0.m22554k("mSwitchApp");
        }
        if (switchButton.isChecked()) {
            ReportAppPresenter reportAppPresenter4 = this.mPresenter;
            if (reportAppPresenter4 != null) {
                reportAppPresenter4.addSurveyApp("", this.appPkgPath, this.appName + C7316r1.f25586d);
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
                C5544i0.m22554k("mTvAppName");
            }
            sb.append(textView.getText().toString());
            sb.append(C7316r1.f25586d);
            reportAppPresenter5.addSurveyApp("", str, sb.toString());
        }
    }

    public final void onkeyback() {
        C7257b1.m26184a(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", -1, -1, true, (IClickListener) new C6492c());
    }

    public final void setAppInfo(@InterfaceC5817e AppInfoBean appInfoBean) {
        this.appInfo = appInfoBean;
    }

    public final void setAppLogoName(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.appLogoName = str;
    }

    public final void setAppLogoPath(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.appLogoPath = str;
    }

    public final void setAppName(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.appName = str;
    }

    public final void setAppPkgPath(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.appPkgPath = str;
    }

    public final void setAppZXingName(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.appZXingName = str;
    }

    public final void setAppZXingPath(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.appZXingPath = str;
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setImgType(int i2) {
        this.imgType = i2;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_report_app_add;
    }

    public final void setListItem(int i2) {
        this.listItem = i2;
    }

    public final void setMAddAppBean(@InterfaceC5817e SurveyAppBean surveyAppBean) {
        this.mAddAppBean = surveyAppBean;
    }

    public final void setMAppBean(@InterfaceC5817e SurveyAppBean surveyAppBean) {
        this.mAppBean = surveyAppBean;
    }

    public final void setMBtnCommit(@InterfaceC5816d Button button) {
        C5544i0.m22546f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMEtAppName(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtAppName = editText;
    }

    public final void setMEtInvitationCode(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtInvitationCode = editText;
    }

    public final void setMEtVictimAccount(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtVictimAccount = editText;
    }

    public final void setMEtVictimPwd(@InterfaceC5816d EditText editText) {
        C5544i0.m22546f(editText, "<set-?>");
        this.mEtVictimPwd = editText;
    }

    public final void setMFlAppInfo(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mFlAppInfo = view;
    }

    public final void setMFlAppZxing(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mFlAppZxing = view;
    }

    public final void setMIvAppIcon(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvAppIcon = imageView;
    }

    public final void setMIvAppLogo(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvAppLogo = imageView;
    }

    public final void setMIvAppZxingPic(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvAppZxingPic = imageView;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlAddAppLogo(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlAddAppLogo = view;
    }

    public final void setMLlAddAppName(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlAddAppName = view;
    }

    public final void setMPresenter(@InterfaceC5817e ReportAppPresenter reportAppPresenter) {
        this.mPresenter = reportAppPresenter;
    }

    public final void setMSwitchApp(@InterfaceC5816d SwitchButton switchButton) {
        C5544i0.m22546f(switchButton, "<set-?>");
        this.mSwitchApp = switchButton;
    }

    public final void setMSwitchZxing(@InterfaceC5816d SwitchButton switchButton) {
        C5544i0.m22546f(switchButton, "<set-?>");
        this.mSwitchZxing = switchButton;
    }

    public final void setMTvAddApp(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mTvAddApp = view;
    }

    public final void setMTvAppName(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAppName = textView;
    }

    public final void setMTvAppPkg(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAppPkg = textView;
    }

    public final void setMTvAppVers(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAppVers = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMediaPic(@InterfaceC5817e LocalMedia localMedia) {
        this.mediaPic = localMedia;
    }

    public final void setMediaPicLogo(@InterfaceC5817e LocalMedia localMedia) {
        this.mediaPicLogo = localMedia;
    }

    public final void setScrollView(@InterfaceC5816d NestedScrollView nestedScrollView) {
        C5544i0.m22546f(nestedScrollView, "<set-?>");
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
