package p388ui.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.ReportZPBean;
import bean.ReportZPEleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.xiaomi.mipush.sdk.Constants;
import com.zhy.view.flowlayout.AbstractC4439b;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import p388ui.Hicore;
import p388ui.callview.TagFlowLayoutCallView;
import p388ui.presenter.TagFlowLayoutPresenter;
import p388ui.view.MyScrollView;
import util.C7292k1;
import util.C7313q1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class TagFlowLaoutActivity extends BaseActivity implements TagFlowLayoutCallView {
    public static final int CASE_PAGE = 2;
    public static final int DK_PAGE = 1;
    private int childPost = 0;
    protected List<ReportZPBean> mFlowString = new ArrayList();

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.ll_network_no)
    View mLlNetworkNo;

    @BindView(C2113R.id.ll_praent)
    LinearLayout mLlPraent;
    TagFlowLayoutPresenter mPresenter;
    private AbstractC4439b mTagAdapter;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.myScrollView)
    MyScrollView myScrollView;
    private int pageType;
    private ReportZPEleBean tagBean;

    /* renamed from: ui.activity.TagFlowLaoutActivity$a */
    class C6621a extends AbstractC4439b<ReportZPEleBean> {

        /* renamed from: d */
        final /* synthetic */ TagFlowLayout f23267d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C6621a(List list, TagFlowLayout tagFlowLayout) {
            super(list);
            this.f23267d = tagFlowLayout;
        }

        @Override // com.zhy.view.flowlayout.AbstractC4439b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public View mo16383a(FlowLayout flowLayout, int i2, ReportZPEleBean reportZPEleBean) {
            TextView textView = (TextView) LayoutInflater.from(TagFlowLaoutActivity.this.mActivity).inflate(C2113R.layout.tag_flow_item, (ViewGroup) this.f23267d, false);
            textView.setText(reportZPEleBean.getName());
            textView.setTextColor(TagFlowLaoutActivity.this.getResources().getColorStateList(C2113R.color.text_choose_one));
            if (TagFlowLaoutActivity.this.tagBean != null) {
                if (TagFlowLaoutActivity.this.pageType == 2) {
                    if (TagFlowLaoutActivity.this.tagBean.getId() == reportZPEleBean.getId()) {
                        TagFlowLaoutActivity.this.childPost = i2;
                        TagFlowLaoutActivity.this.mTagAdapter = this;
                    }
                } else if (TagFlowLaoutActivity.this.tagBean.getCode() == reportZPEleBean.getCode()) {
                    TagFlowLaoutActivity.this.childPost = i2;
                    TagFlowLaoutActivity.this.mTagAdapter = this;
                }
            }
            return textView;
        }
    }

    /* renamed from: ui.activity.TagFlowLaoutActivity$b */
    class ViewOnClickListenerC6622b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ TagFlowLayout f23269a;

        /* renamed from: b */
        final /* synthetic */ ImageView f23270b;

        ViewOnClickListenerC6622b(TagFlowLayout tagFlowLayout, ImageView imageView) {
            this.f23269a = tagFlowLayout;
            this.f23270b = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f23269a.getTag() == null || !((Boolean) this.f23269a.getTag()).booleanValue()) {
                this.f23269a.setVisibility(0);
                this.f23269a.setTag(true);
                this.f23270b.setImageResource(C2113R.drawable.iv_tag_ar_up);
            } else {
                this.f23269a.setVisibility(8);
                this.f23269a.setTag(false);
                this.f23270b.setImageResource(C2113R.drawable.iv_tag_ar_down);
            }
        }
    }

    private void getIntentData() {
        try {
            this.tagBean = (ReportZPEleBean) getIntent().getSerializableExtra(C7292k1.f25361O);
            this.pageType = getIntent().getIntExtra(C7292k1.f25394d, 0);
        } catch (Exception unused) {
        }
    }

    private boolean networkStateDeal() {
        if (C7313q1.m26534f()) {
            this.mLlNetworkNo.setVisibility(8);
            this.myScrollView.setVisibility(0);
            return true;
        }
        this.mLlNetworkNo.setVisibility(0);
        this.myScrollView.setVisibility(8);
        return false;
    }

    /* renamed from: a */
    public /* synthetic */ boolean m25382a(AbstractC4439b abstractC4439b, ReportZPBean reportZPBean, View view, int i2, FlowLayout flowLayout) {
        abstractC4439b.m16387a(i2);
        ReportZPEleBean reportZPEleBean = reportZPBean.getChildren().get(i2);
        if (this.pageType == 2) {
            reportZPEleBean.setName(reportZPBean.getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + reportZPEleBean.getName());
        }
        C6049c.m24987f().m25000d(new C7265a(3, reportZPEleBean));
        finish();
        return true;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("诈骗类型");
        this.mPresenter = new TagFlowLayoutPresenter(this, this);
        getIntentData();
        this.mPresenter.getReportMarkData(this.pageType);
    }

    protected void initTagAdapter(final ReportZPBean reportZPBean, int i2) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(C2113R.layout.layout_tag_flow, (ViewGroup) null, false);
        this.mLlPraent.addView(inflate);
        TextView textView = (TextView) inflate.findViewById(C2113R.id.tv_div_bg);
        TextView textView2 = (TextView) inflate.findViewById(C2113R.id.tag_title);
        ImageView imageView = (ImageView) inflate.findViewById(C2113R.id.iv_arrow);
        TagFlowLayout tagFlowLayout = (TagFlowLayout) inflate.findViewById(C2113R.id.flow_layout);
        textView2.setText(reportZPBean.getName());
        if (i2 % 4 == 0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        if (reportZPBean.getChildren() == null || reportZPBean.getChildren().size() == 0) {
            ArrayList arrayList = new ArrayList();
            ReportZPEleBean reportZPEleBean = new ReportZPEleBean();
            reportZPEleBean.setId(reportZPBean.getId());
            reportZPEleBean.setCode(reportZPBean.getCode());
            reportZPEleBean.setName(reportZPBean.getName());
            reportZPEleBean.setClusterID(reportZPBean.getClusterID());
            reportZPEleBean.setParentClusterID(reportZPBean.getParentClusterID());
            reportZPEleBean.setIsShow(reportZPBean.getIsShow());
            reportZPEleBean.setSort(reportZPBean.getSort());
            reportZPEleBean.setTopClass(reportZPBean.getTopClass());
            arrayList.add(reportZPEleBean);
            reportZPBean.setChildren(arrayList);
        }
        final C6621a c6621a = new C6621a(reportZPBean.getChildren(), tagFlowLayout);
        tagFlowLayout.setAdapter(c6621a);
        tagFlowLayout.setOnTagClickListener(new TagFlowLayout.InterfaceC4437c() { // from class: ui.activity.f1
            @Override // com.zhy.view.flowlayout.TagFlowLayout.InterfaceC4437c
            /* renamed from: a */
            public final boolean mo16381a(View view, int i3, FlowLayout flowLayout) {
                return TagFlowLaoutActivity.this.m25382a(c6621a, reportZPBean, view, i3, flowLayout);
            }
        });
        List<ReportZPEleBean> children = reportZPBean.getChildren();
        if (this.pageType == 2) {
            for (int i3 = 0; i3 < children.size(); i3++) {
                ReportZPEleBean reportZPEleBean2 = this.tagBean;
                if (reportZPEleBean2 != null && reportZPEleBean2.getId() == children.get(i3).getId()) {
                    tagFlowLayout.setVisibility(0);
                    tagFlowLayout.setTag(true);
                    imageView.setImageResource(C2113R.drawable.iv_tag_ar_up);
                }
            }
        } else {
            for (int i4 = 0; i4 < children.size(); i4++) {
                ReportZPEleBean reportZPEleBean3 = this.tagBean;
                if (reportZPEleBean3 != null && reportZPEleBean3.getCode() == children.get(i4).getCode()) {
                    tagFlowLayout.setVisibility(0);
                    tagFlowLayout.setTag(true);
                    imageView.setImageResource(C2113R.drawable.iv_tag_ar_up);
                }
            }
        }
        imageView.setOnClickListener(new ViewOnClickListenerC6622b(tagFlowLayout, imageView));
        c6621a.m16391c();
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        networkStateDeal();
    }

    @Override // p388ui.callview.TagFlowLayoutCallView
    public void onSuccessRequest(List<ReportZPBean> list) {
        AbstractC4439b abstractC4439b;
        this.mLlNetworkNo.setVisibility(8);
        this.myScrollView.setVisibility(0);
        this.mFlowString.clear();
        this.mFlowString.addAll(list);
        for (int i2 = 0; i2 < this.mFlowString.size(); i2++) {
            initTagAdapter(this.mFlowString.get(i2), i2);
        }
        if (this.tagBean == null || (abstractC4439b = this.mTagAdapter) == null) {
            return;
        }
        abstractC4439b.m16387a(this.childPost);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_network_no})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            finish();
        } else {
            if (id != C2113R.id.ll_network_no) {
                return;
            }
            this.mPresenter.getReportMarkData(this.pageType);
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_tagflow;
    }
}
