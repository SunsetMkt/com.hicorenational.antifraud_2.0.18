package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hicorenational.antifraud.C2113R;
import util.C7264c1;

/* loaded from: classes.dex */
public class HRecyclerViewAdapter extends RecyclerView.Adapter<HImageHolder> {

    /* renamed from: f */
    private static String[] f201f;

    /* renamed from: g */
    private static int[] f202g;

    /* renamed from: a */
    private Context f203a;

    /* renamed from: b */
    private int f204b;

    /* renamed from: c */
    private InterfaceC0062a f205c;

    /* renamed from: d */
    private int f206d;

    /* renamed from: e */
    private int f207e = C2113R.drawable.iv_share_download;

    public class HImageHolder extends RecyclerView.ViewHolder {

        /* renamed from: a */
        public FrameLayout f208a;

        /* renamed from: b */
        public ImageView f209b;

        /* renamed from: c */
        public TextView f210c;

        public HImageHolder(View view) {
            super(view);
            this.f208a = (FrameLayout) view.findViewById(C2113R.id.fl_share_item);
            this.f209b = (ImageView) view.findViewById(C2113R.id.image);
            this.f210c = (TextView) view.findViewById(C2113R.id.tv_name);
            if (HRecyclerViewAdapter.this.f204b == 5) {
                HRecyclerViewAdapter.this.m234a(this.f208a);
            }
        }
    }

    /* renamed from: adapter.HRecyclerViewAdapter$a */
    public interface InterfaceC0062a {
        /* renamed from: a */
        void mo237a(int i2, String str);
    }

    public HRecyclerViewAdapter(Context context, int i2) {
        this.f206d = context.getResources().getDisplayMetrics().widthPixels;
        this.f203a = context;
        this.f204b = i2;
        if (this.f204b == 5) {
            f201f = new String[]{"微信好友", "QQ好友", "钉钉", "复制链接"};
            f202g = new int[]{C2113R.drawable.iv_share_wx, C2113R.drawable.iv_login_qq, C2113R.drawable.iv_share_dding, C2113R.drawable.iv_share_copy};
        } else {
            f201f = new String[]{"微信好友", "朋友圈", "QQ好友", "QQ空间", "微博", "钉钉", "复制链接"};
            f202g = new int[]{C2113R.drawable.iv_share_wx, C2113R.drawable.iv_share_wxcicle, C2113R.drawable.iv_login_qq, C2113R.drawable.iv_share_qzone, C2113R.drawable.iv_share_sina, C2113R.drawable.iv_share_dding, C2113R.drawable.iv_share_copy};
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return f201f.length;
    }

    public void setOnItemClickListener(InterfaceC0062a interfaceC0062a) {
        this.f205c = interfaceC0062a;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public HImageHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new HImageHolder(LayoutInflater.from(this.f203a).inflate(C2113R.layout.item_hrecyclerview, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final HImageHolder hImageHolder, final int i2) {
        hImageHolder.f210c.setText(f201f[i2]);
        hImageHolder.f209b.setImageResource(f202g[i2]);
        if (this.f204b == 1 && i2 == f201f.length - 1) {
            hImageHolder.f210c.setText("生成海报");
            hImageHolder.f209b.setImageResource(this.f207e);
        }
        if (this.f205c != null) {
            hImageHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: adapter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HRecyclerViewAdapter.this.m236a(hImageHolder, i2, view);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m236a(HImageHolder hImageHolder, int i2, View view) {
        this.f205c.mo237a(hImageHolder.getLayoutPosition(), f201f[i2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m234a(FrameLayout frameLayout) {
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.width = (this.f206d - C7264c1.m26285a(this.f203a, 16.0f)) / f201f.length;
        frameLayout.setLayoutParams(layoutParams);
    }
}
