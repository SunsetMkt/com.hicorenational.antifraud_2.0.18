package p388ui.activity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import org.greenrobot.eventbus.C6049c;
import p388ui.callview.SocialTagsCallView;
import p388ui.presenter.TradAccEditPresenter;
import util.C7292k1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class TradAccountEditActivity extends BaseActivity implements SocialTagsCallView {
    private static final String FINATYPE = "其他类型";

    /* renamed from: bean, reason: collision with root package name */
    private SocialAccBean f25905bean;

    @BindView(C2113R.id.et_account)
    TextView mEtAccount;

    @BindView(C2113R.id.et_account_other)
    TextView mEtAccountOther;

    @BindView(C2113R.id.et_tag_other)
    TextView mEtTagOther;

    @BindView(C2113R.id.flow_layout)
    TagFlowLayout mFlowLayout;

    @BindView(C2113R.id.ll_acc_nomar)
    View mLlAccNorm;

    @BindView(C2113R.id.ll_acc_other)
    View mLlAccOther;
    private TradAccEditPresenter mPresenter;

    @BindView(C2113R.id.tv_acc_name)
    TextView mTvAccName;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private int pos;
    private int selectIndex;
    private AbstractC4439b mTagAdapter = null;
    private List<SocialTypeBean> socialTypeBeans = new ArrayList();
    private SocialTypeBean otherType = new SocialTypeBean(FINATYPE);

    /* renamed from: ui.activity.TradAccountEditActivity$a */
    class C6629a extends AbstractC4439b<SocialTypeBean> {
        C6629a(List list) {
            super(list);
        }

        @Override // com.zhy.view.flowlayout.AbstractC4439b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public View mo16383a(FlowLayout flowLayout, int i2, SocialTypeBean socialTypeBean) {
            TextView textView = (TextView) LayoutInflater.from(TradAccountEditActivity.this.mActivity).inflate(C2113R.layout.tag_flow_trad, (ViewGroup) TradAccountEditActivity.this.mFlowLayout, false);
            textView.setText(((SocialTypeBean) TradAccountEditActivity.this.socialTypeBeans.get(i2)).getText());
            textView.setTextColor(TradAccountEditActivity.this.getResources().getColorStateList(C2113R.color.text_choose_one));
            return textView;
        }
    }

    private int contains(List<SocialTypeBean> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.equals(list.get(i2).getText(), str)) {
                return i2;
            }
        }
        return -10;
    }

    private void getIntentData() {
        this.pos = getIntent().getIntExtra(C7292k1.f25438v, 0);
        this.f25905bean = (SocialAccBean) getIntent().getSerializableExtra(C7292k1.f25440w);
    }

    /* renamed from: a */
    public /* synthetic */ boolean m25384a(View view, int i2, FlowLayout flowLayout) {
        if (TextUtils.equals(FINATYPE, this.socialTypeBeans.get(i2).getText())) {
            this.mLlAccOther.setVisibility(0);
            this.mLlAccNorm.setVisibility(8);
        } else {
            this.mLlAccOther.setVisibility(8);
            this.mLlAccNorm.setVisibility(0);
        }
        this.selectIndex = i2;
        this.mTvAccName.setText(this.socialTypeBeans.get(i2).getText() + "账户");
        return true;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加诈骗交易账户");
        this.mPresenter = new TradAccEditPresenter(this.mActivity, this);
        getIntentData();
        initTagAdapter();
        this.mPresenter.getSocialTags();
    }

    protected void initTagAdapter() {
        this.mTagAdapter = new C6629a(this.socialTypeBeans);
        this.mFlowLayout.setAdapter(this.mTagAdapter);
        this.mFlowLayout.setOnTagClickListener(new TagFlowLayout.InterfaceC4437c() { // from class: ui.activity.g1
            @Override // com.zhy.view.flowlayout.TagFlowLayout.InterfaceC4437c
            /* renamed from: a */
            public final boolean mo16381a(View view, int i2, FlowLayout flowLayout) {
                return TradAccountEditActivity.this.m25384a(view, i2, flowLayout);
            }
        });
    }

    @Override // p388ui.callview.SocialTagsCallView
    public void onErrorRequest() {
    }

    @Override // p388ui.callview.SocialTagsCallView
    public void onSuccessRequest(List<SocialTypeBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.socialTypeBeans.clear();
        list.add(this.otherType);
        this.socialTypeBeans.addAll(list);
        this.mTagAdapter.m16391c();
        SocialAccBean socialAccBean = this.f25905bean;
        if (socialAccBean == null) {
            this.selectIndex = 0;
            this.mTagAdapter.m16387a(0);
            this.mTvAccName.setText(list.get(0).getText() + "账户");
            return;
        }
        int contains = contains(list, socialAccBean.getAccountName());
        if (contains >= 0) {
            this.selectIndex = contains;
            this.mTvAccName.setText(this.f25905bean.getAccountName());
            this.mEtAccount.setText(this.f25905bean.getAccountNum());
            this.mTagAdapter.m16387a(this.selectIndex);
            return;
        }
        this.selectIndex = list.size() - 1;
        this.mLlAccOther.setVisibility(0);
        this.mLlAccNorm.setVisibility(8);
        this.mEtTagOther.setText(this.f25905bean.getAccountName());
        this.mEtAccountOther.setText(this.f25905bean.getAccountNum());
        this.mTagAdapter.m16387a(this.selectIndex);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        String text;
        String charSequence;
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_commit) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        if (this.socialTypeBeans.size() > 0) {
            if (TextUtils.equals(FINATYPE, this.socialTypeBeans.get(this.selectIndex).getText())) {
                text = this.mEtTagOther.getText().toString();
                if (TextUtils.isEmpty(text)) {
                    C7331w1.m26688a("交易类型不能为空");
                    return;
                }
                charSequence = this.mEtAccountOther.getText().toString();
                if (TextUtils.isEmpty(charSequence)) {
                    C7331w1.m26688a("交易账户不能为空");
                    return;
                }
            } else {
                text = this.socialTypeBeans.get(this.selectIndex).getText();
                charSequence = this.mEtAccount.getText().toString();
                if (TextUtils.isEmpty(charSequence)) {
                    C7331w1.m26688a("交易账户不能为空");
                    return;
                }
            }
            SocialAccBean socialAccBean = new SocialAccBean();
            socialAccBean.setAccountName(text);
            socialAccBean.setAccountNum(charSequence);
            if (this.f25905bean != null) {
                C6049c.m24987f().m25000d(new C7265a(18, socialAccBean, Integer.valueOf(this.pos)));
            } else {
                C6049c.m24987f().m25000d(new C7265a(17, socialAccBean));
            }
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_trad_acc_edit;
    }
}
