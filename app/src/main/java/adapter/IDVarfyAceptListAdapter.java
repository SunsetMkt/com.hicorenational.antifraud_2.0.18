package adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.VerifyAcceptBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.util.List;
import ui.activity.HandleIDVerifyActivity;
import util.p1;

/* JADX INFO: loaded from: classes.dex */
public class IDVarfyAceptListAdapter extends BaseQuickAdapter<VerifyAcceptBean, BaseViewHolder> {
    private List<VerifyAcceptBean> V;

    public IDVarfyAceptListAdapter(List<VerifyAcceptBean> list) {
        super(R.layout.item_idvarfy_caept_list, list);
        this.V = list;
    }

    public void G() {
        this.V.clear();
        notifyDataSetChanged();
    }

    public void a(List<VerifyAcceptBean> list) {
        this.V.clear();
        this.V.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, VerifyAcceptBean verifyAcceptBean) {
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_name);
        TextView textView2 = (TextView) baseViewHolder.c(R.id.tv_id_num);
        TextView textView3 = (TextView) baseViewHolder.c(R.id.tv_idvarfy_time);
        textView.setText(verifyAcceptBean.getInitiatorName() + "\u5411\u4f60\u53d1\u8d77\u4e86\u201c\u8eab\u4efd\u6838\u5b9e\u201d\u8bf7\u6c42");
        textView2.setText(verifyAcceptBean.getIntivedMobile());
        textView3.setText("\u8fc7\u671f\u65f6\u95f4\uff1a" + verifyAcceptBean.getDeadline());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder(baseViewHolder, i2);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.iv_check_id_new);
        final VerifyAcceptBean verifyAcceptBean = this.V.get(i2);
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
                this.a.a(verifyAcceptBean, view);
            }
        });
    }

    public /* synthetic */ void a(VerifyAcceptBean verifyAcceptBean, View view) {
        if (verifyAcceptBean != null) {
            Intent intent = new Intent(this.x, (Class<?>) HandleIDVerifyActivity.class);
            intent.putExtra(p1.c0, verifyAcceptBean.getVerificationLogID());
            intent.putExtra(p1.b0, verifyAcceptBean.getInitiatorName());
            this.x.startActivity(intent);
        }
    }
}
