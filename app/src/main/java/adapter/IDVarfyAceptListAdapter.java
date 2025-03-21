package adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.VerifyAcceptBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import p388ui.activity.HandleIDVerifyActivity;
import util.C7292k1;

/* loaded from: classes.dex */
public class IDVarfyAceptListAdapter extends BaseQuickAdapter<VerifyAcceptBean, BaseViewHolder> {

    /* renamed from: V */
    private List<VerifyAcceptBean> f234V;

    public IDVarfyAceptListAdapter(List<VerifyAcceptBean> list) {
        super(C2113R.layout.item_idvarfy_caept_list, list);
        this.f234V = list;
    }

    /* renamed from: G */
    public void m250G() {
        this.f234V.clear();
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m252a(List<VerifyAcceptBean> list) {
        this.f234V.clear();
        this.f234V.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, VerifyAcceptBean verifyAcceptBean) {
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_name);
        TextView textView2 = (TextView) baseViewHolder.m5224c(C2113R.id.tv_id_num);
        TextView textView3 = (TextView) baseViewHolder.m5224c(C2113R.id.tv_idvarfy_time);
        textView.setText(verifyAcceptBean.getInitiatorName() + "向你发起了“身份核实”请求");
        textView2.setText(verifyAcceptBean.getIntivedMobile());
        textView3.setText("过期时间：" + verifyAcceptBean.getDeadline());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((IDVarfyAceptListAdapter) baseViewHolder, i2);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_check_id_new);
        final VerifyAcceptBean verifyAcceptBean = this.f234V.get(i2);
        if (verifyAcceptBean != null) {
            if (verifyAcceptBean.getIsLookover() == 1) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
        }
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IDVarfyAceptListAdapter.this.m251a(verifyAcceptBean, view);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m251a(VerifyAcceptBean verifyAcceptBean, View view) {
        if (verifyAcceptBean != null) {
            Intent intent = new Intent(this.f5580x, (Class<?>) HandleIDVerifyActivity.class);
            intent.putExtra(C7292k1.f25392c0, verifyAcceptBean.getVerificationLogID());
            intent.putExtra(C7292k1.f25389b0, verifyAcceptBean.getInitiatorName());
            this.f5580x.startActivity(intent);
        }
    }
}
