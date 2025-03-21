package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class IDVarfyFaceActivity extends BaseActivity {

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("");
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_firm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.iv_back) {
            finish();
        } else {
            if (id != C2113R.id.tv_firm) {
                return;
            }
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_id_varfy_face;
    }
}
