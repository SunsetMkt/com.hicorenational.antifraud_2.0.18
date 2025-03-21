package p388ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CheckFraudBean;
import bean.ReportPersonBean;
import bean.ReportZPEleBean;
import bean.SocialAccBean;
import bean.SocialTypeBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.zhy.view.flowlayout.AbstractC4439b;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import manager.BaseDialog;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.callview.TradFraudView;
import p388ui.presenter.TradFraudPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class TradFraudActivity extends BaseActivity implements TradFraudView {
    private static final String FINATYPE = "其他类型";
    private BaseDialog dlg;
    private ReportZPEleBean info;

    @BindView(C2113R.id.et_case_describe)
    EditText mEtCaseDescribe;

    @BindView(C2113R.id.et_tag_other)
    EditText mEtTagOther;
    private TagFlowLayout mFlowLayout;
    private TradFraudPresenter mPresenter;

    @BindView(C2113R.id.region)
    TextView mRegion;

    @BindView(C2113R.id.rl_other_acc)
    View mRlOtherAcc;

    @BindView(C2113R.id.tv_account_name)
    TextView mTvAccName;

    @BindView(C2113R.id.trad_fraud_num)
    TextView mTvAccNum;

    @BindView(C2113R.id.tv_dupery_type)
    TextView mTvDuperyType;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private int selectIndex;
    private SocialTypeBean tagBean;
    private AbstractC4439b mTagAdapter = null;
    private List<SocialTypeBean> socialTypeBeans = new ArrayList();
    private SocialTypeBean otherType = new SocialTypeBean(FINATYPE);
    public CheckFraudBean mCheckFraudBean = null;
    private int mDefraudCode = -1;

    /* renamed from: ui.activity.TradFraudActivity$a */
    class C6632a extends AbstractC4439b<SocialTypeBean> {
        C6632a(List list) {
            super(list);
        }

        @Override // com.zhy.view.flowlayout.AbstractC4439b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public View mo16383a(FlowLayout flowLayout, int i2, SocialTypeBean socialTypeBean) {
            TextView textView = (TextView) LayoutInflater.from(TradFraudActivity.this.mActivity).inflate(C2113R.layout.tag_flow_trad, (ViewGroup) TradFraudActivity.this.mFlowLayout, false);
            textView.setText(((SocialTypeBean) TradFraudActivity.this.socialTypeBeans.get(i2)).getText());
            textView.setTextColor(TradFraudActivity.this.getResources().getColorStateList(C2113R.color.text_choose_one));
            return textView;
        }
    }

    private void disDlog() {
        BaseDialog baseDialog = this.dlg;
        if (baseDialog == null || !baseDialog.isShowing()) {
            return;
        }
        this.dlg.dismiss();
    }

    private void getIntentData() {
        this.mCheckFraudBean = (CheckFraudBean) getIntent().getSerializableExtra(C7292k1.f25421m0);
        CheckFraudBean checkFraudBean = this.mCheckFraudBean;
        if (checkFraudBean != null) {
            this.mTvAccNum.setText(checkFraudBean.getContent());
        }
    }

    private void showTagData() {
        this.mTagAdapter.m16391c();
        if (this.socialTypeBeans.size() <= 0 || this.tagBean == null) {
            return;
        }
        this.tagBean = this.socialTypeBeans.get(this.selectIndex);
        this.mTagAdapter.m16387a(this.selectIndex);
        this.mTvAccName.setText(this.tagBean.getText());
    }

    private void submitReport() {
        String str = getmRegionId();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String charSequence = this.mRegion.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "";
        }
        String charSequence2 = this.mTvDuperyType.getText().toString();
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = "";
        }
        String obj = this.mEtCaseDescribe.getText().toString();
        String str2 = TextUtils.isEmpty(obj) ? "" : obj;
        ReportPersonBean reportPersonBean = new ReportPersonBean();
        reportPersonBean.setReportDic(str);
        reportPersonBean.setReportAdd(charSequence);
        reportPersonBean.setDupery(charSequence2);
        reportPersonBean.setDefraudType(this.mDefraudCode);
        reportPersonBean.setCaseDis(str2);
        String obj2 = this.mRlOtherAcc.isShown() ? this.mEtTagOther.getText().toString() : this.tagBean.getText();
        SocialAccBean socialAccBean = new SocialAccBean();
        socialAccBean.setAccountName(obj2);
        socialAccBean.setAccountNum(this.mTvAccNum.getText().toString());
        this.mPresenter.oneKeyReportTrad(socialAccBean, reportPersonBean);
    }

    /* renamed from: a */
    public /* synthetic */ void m25385a(View view) {
        this.dlg.dismiss();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("添加诈骗交易账户");
        this.mPresenter = new TradFraudPresenter(this.mActivity, this);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        getIntentData();
        this.mPresenter.getSocialTags();
    }

    protected void initTagAdapter() {
        this.mTagAdapter = new C6632a(this.socialTypeBeans);
        this.mFlowLayout.setAdapter(this.mTagAdapter);
        this.mFlowLayout.setOnTagClickListener(new TagFlowLayout.InterfaceC4437c() { // from class: ui.activity.h1
            @Override // com.zhy.view.flowlayout.TagFlowLayout.InterfaceC4437c
            /* renamed from: a */
            public final boolean mo16381a(View view, int i2, FlowLayout flowLayout) {
                return TradFraudActivity.this.m25386a(view, i2, flowLayout);
            }
        });
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @Override // p388ui.callview.TradFraudView
    public void onErrorRequest() {
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 3) {
            return;
        }
        this.info = (ReportZPEleBean) c7265a.m26300b();
        ReportZPEleBean reportZPEleBean = this.info;
        if (reportZPEleBean != null) {
            this.mTvDuperyType.setText(reportZPEleBean.getName());
            this.mDefraudCode = this.info.getCode();
        }
    }

    @Override // p388ui.callview.TradFraudView
    public void onSuccessRequest(List<SocialTypeBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.socialTypeBeans.clear();
        list.add(this.otherType);
        this.socialTypeBeans.addAll(list);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_account_name, C2113R.id.tv_dupery_type, C2113R.id.region, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                if (!TextUtils.isEmpty(this.mTvAccName.getText().toString())) {
                    if (!this.mRlOtherAcc.isShown() || !TextUtils.isEmpty(this.mEtTagOther.getText().toString())) {
                        if (!TextUtils.isEmpty(this.mTvDuperyType.getText().toString())) {
                            submitReport();
                            break;
                        } else {
                            C7331w1.m26688a("请选择诈骗类型");
                            break;
                        }
                    } else {
                        C7331w1.m26688a("请输入其他账户类型");
                        break;
                    }
                } else {
                    C7331w1.m26688a("请选择账户类型");
                    break;
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.region /* 2131297159 */:
                regionShow(this.mRegion, this.mActivity);
                break;
            case C2113R.id.tv_account_name /* 2131297399 */:
                showTagDlag();
                break;
            case C2113R.id.tv_dupery_type /* 2131297542 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) TagFlowLaoutActivity.class);
                ReportZPEleBean reportZPEleBean = this.info;
                if (reportZPEleBean != null) {
                    intent.putExtra(C7292k1.f25361O, reportZPEleBean);
                }
                startActivity(intent);
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_trad_fraud;
    }

    public void showTagDlag() {
        this.dlg = new BaseDialog(this.mActivity, C2113R.style.base_dialog_style);
        this.dlg.setContentView(C2113R.layout.layout_trad_type);
        this.dlg.setGravityLayout(0);
        this.dlg.setWidthDialog(-2.0d);
        this.dlg.setHeightDialogdp(-2.0f);
        this.dlg.setCancelable(false);
        this.dlg.setCanceledOnTouchOutside(false);
        this.dlg.initOnCreate();
        this.dlg.show();
        ImageView imageView = (ImageView) this.dlg.findViewById(C2113R.id.cancle);
        this.mFlowLayout = (TagFlowLayout) this.dlg.findViewById(C2113R.id.flow_layout);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ui.activity.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TradFraudActivity.this.m25385a(view);
            }
        });
        initTagAdapter();
        showTagData();
    }

    /* renamed from: a */
    public /* synthetic */ boolean m25386a(View view, int i2, FlowLayout flowLayout) {
        if (TextUtils.equals(FINATYPE, this.socialTypeBeans.get(i2).getText())) {
            this.mRlOtherAcc.setVisibility(0);
        } else {
            this.mRlOtherAcc.setVisibility(8);
        }
        this.selectIndex = i2;
        this.tagBean = this.socialTypeBeans.get(i2);
        this.mTvAccName.setText(this.tagBean.getText());
        disDlog();
        return true;
    }
}
