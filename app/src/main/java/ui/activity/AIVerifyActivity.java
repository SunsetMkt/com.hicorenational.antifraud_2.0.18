package ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import ui.callview.AIVerifyCountCallView;
import ui.fragment.AIVerifyAudioFragment;
import ui.fragment.AIVerifyFragmentAdapter;
import ui.fragment.AIVerifyImageFragment;
import ui.fragment.AIVerifyTextFragment;
import ui.fragment.AIVerifyVideoFragment;
import ui.presenter.AiVerifyCountPresenter;
import util.c2;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyActivity extends BaseActivity implements AIVerifyCountCallView {
    private ui.callview.a activityBroadCastFragment;
    public AiVerifyCountPresenter aiVerifyCountPresenter;

    @BindView(R.id.checkNum)
    TextView mCheckNum;
    private FragmentStateAdapter mFragmentAdapter;
    private List<Fragment> mFragmentList;

    @BindView(R.id.iv_right)
    ImageView mRightImage;

    @BindView(R.id.mTabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.rl_title)
    RelativeLayout mTitleBg;
    private final String[] mTitles = {"\u56fe\u50cf\u68c0\u6d4b", "\u89c6\u9891\u68c0\u6d4b", "\u6587\u672c\u68c0\u6d4b", "\u97f3\u9891\u68c0\u6d4b"};

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.mViewPager)
    ViewPager2 mViewPager;
    private TabLayoutMediator mediator;

    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            super.onPageSelected(i2);
            int tabCount = AIVerifyActivity.this.mTabLayout.getTabCount();
            for (int i3 = 0; i3 < tabCount; i3++) {
                TabLayout.Tab tabAt = AIVerifyActivity.this.mTabLayout.getTabAt(i3);
                if (tabAt != null && tabAt.getCustomView() != null) {
                    TextView textView = (TextView) tabAt.getCustomView();
                    if (tabAt.getPosition() == i2) {
                        textView.setTextSize(2, 16.0f);
                        textView.setTypeface(null, 1);
                    } else {
                        textView.setTextSize(2, 14.0f);
                        textView.setTypeface(null, 0);
                    }
                }
            }
        }
    }

    private void initView() {
        this.mTitleBg.setBackgroundColor(getResources().getColor(R.color.ai_verify_bg));
        this.mTvTitle.setText(getResources().getText(R.string.ai_verify_title));
        this.mTvTitle.setTextSize(2, 18.0f);
        this.mTvTitle.setTypeface(null, 1);
        this.mRightImage.setImageResource(R.drawable.ic_ai_record);
        RecyclerView recyclerView = (RecyclerView) this.mViewPager.getChildAt(0);
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().setItemPrefetchEnabled(false);
        }
        this.mFragmentList = new ArrayList();
        this.mFragmentList.add(new AIVerifyImageFragment());
        this.mFragmentList.add(new AIVerifyVideoFragment());
        this.mFragmentList.add(new AIVerifyTextFragment());
        this.mFragmentList.add(new AIVerifyAudioFragment());
        this.mFragmentAdapter = new AIVerifyFragmentAdapter(this, this.mFragmentList);
        this.mViewPager.setAdapter(this.mFragmentAdapter);
        this.mViewPager.setOffscreenPageLimit(4);
        this.mediator = new TabLayoutMediator(this.mTabLayout, this.mViewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: ui.activity.b
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i2) {
                this.a.a(tab, i2);
            }
        });
        this.mediator.attach();
        this.mViewPager.registerOnPageChangeCallback(new a());
    }

    private View makeTabView(int i2) {
        TextView textView = new TextView(this);
        textView.setTextColor(getResources().getColorStateList(R.color.shape_ai_verify_statelist));
        textView.setText(this.mTitles[i2]);
        textView.setGravity(80);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(null, 0);
        return textView;
    }

    public /* synthetic */ void a(TabLayout.Tab tab, int i2) {
        tab.setCustomView(makeTabView(i2));
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.aiVerifyCountPresenter = new AiVerifyCountPresenter(this.mActivity, this);
        initView();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mediator.detach();
    }

    @Override // ui.callview.AIVerifyCountCallView
    public void onError(String str) {
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.aiVerifyCountPresenter.checkAiVerifyCount();
    }

    @Override // ui.callview.AIVerifyCountCallView
    public void onSuccess(String str) {
        try {
            int iIntValue = ((Integer) new JSONObject(str).get("data")).intValue();
            if (iIntValue <= 0) {
                iIntValue = 0;
            }
            c2.b("verifyCount", "" + iIntValue);
            this.mCheckNum.setText("\u4eca\u65e5\u5269\u4f59\u68c0\u6d4b\u6b21\u6570:" + iIntValue);
            if (this.activityBroadCastFragment != null) {
                this.activityBroadCastFragment.refreshUiCount(iIntValue);
            }
        } catch (Exception unused) {
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_right})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
        } else {
            if (id != R.id.iv_right) {
                return;
            }
            startActivity(new Intent(this, (Class<?>) AIInspectRecordActivity.class));
        }
    }

    public void setActivityBroadCastFragment(ui.callview.a aVar) {
        this.activityBroadCastFragment = aVar;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_ai_verify;
    }
}
