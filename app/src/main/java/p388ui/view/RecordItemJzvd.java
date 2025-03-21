package p388ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.jzvd.C1280v;
import cn.jzvd.C1283y;
import cn.jzvd.Jzvd;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class RecordItemJzvd extends Jzvd {

    /* renamed from: b1 */
    protected static Timer f24601b1;

    /* renamed from: A0 */
    public ImageView f24602A0;

    /* renamed from: B0 */
    public ProgressBar f24603B0;

    /* renamed from: C0 */
    public ProgressBar f24604C0;

    /* renamed from: D0 */
    public TextView f24605D0;

    /* renamed from: E0 */
    public ImageView f24606E0;

    /* renamed from: F0 */
    public ImageView f24607F0;

    /* renamed from: G0 */
    public TextView f24608G0;

    /* renamed from: H0 */
    public TextView f24609H0;

    /* renamed from: I0 */
    public PopupWindow f24610I0;

    /* renamed from: J0 */
    public TextView f24611J0;

    /* renamed from: K0 */
    public LinearLayout f24612K0;

    /* renamed from: L0 */
    protected C7189a f24613L0;

    /* renamed from: M0 */
    protected Dialog f24614M0;

    /* renamed from: N0 */
    protected ProgressBar f24615N0;

    /* renamed from: O0 */
    protected TextView f24616O0;

    /* renamed from: P0 */
    protected TextView f24617P0;

    /* renamed from: Q0 */
    protected ImageView f24618Q0;

    /* renamed from: R0 */
    protected Dialog f24619R0;

    /* renamed from: S0 */
    protected ProgressBar f24620S0;

    /* renamed from: T0 */
    protected TextView f24621T0;

    /* renamed from: U0 */
    protected ImageView f24622U0;

    /* renamed from: V0 */
    protected Dialog f24623V0;

    /* renamed from: W0 */
    protected ProgressBar f24624W0;

    /* renamed from: X0 */
    protected TextView f24625X0;

    /* renamed from: Y0 */
    private long f24626Y0;

    /* renamed from: Z0 */
    private long f24627Z0;

    /* renamed from: a1 */
    private ArrayDeque<Runnable> f24628a1;

    /* renamed from: ui.view.RecordItemJzvd$a */
    public class C7189a extends TimerTask {
        public C7189a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            RecordItemJzvd.this.m25819P();
        }
    }

    public RecordItemJzvd(Context context) {
        this(context, null);
    }

    /* renamed from: G */
    public void m25810G() {
        Timer timer = f24601b1;
        if (timer != null) {
            timer.cancel();
        }
        C7189a c7189a = this.f24613L0;
        if (c7189a != null) {
            c7189a.cancel();
        }
    }

    /* renamed from: H */
    public void m25811H() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m25827a(0, 4, 0, 4, 0, 4, 4);
            m25825V();
        } else {
            if (i2 != 1) {
                return;
            }
            m25827a(0, 4, 0, 4, 0, 4, 4);
            m25825V();
        }
    }

    /* renamed from: I */
    public void m25812I() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m25827a(4, 4, 0, 4, 4, 4, 0);
            m25825V();
        } else {
            if (i2 != 1) {
                return;
            }
            m25827a(0, 4, 0, 4, 4, 4, 0);
            m25825V();
        }
    }

    /* renamed from: J */
    public void m25813J() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m25827a(0, 4, 0, 4, 0, 4, 4);
            m25825V();
        } else {
            if (i2 != 1) {
                return;
            }
            m25827a(0, 4, 0, 4, 0, 4, 4);
            m25825V();
        }
    }

    /* renamed from: K */
    public void m25814K() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m25827a(4, 4, 4, 4, 4, 0, 4);
        } else {
            if (i2 != 1) {
                return;
            }
            m25827a(4, 4, 4, 4, 4, 0, 4);
        }
    }

    /* renamed from: L */
    public void m25815L() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m25827a(0, 0, 0, 4, 4, 4, 4);
            m25825V();
        } else {
            if (i2 != 1) {
                return;
            }
            m25827a(0, 0, 0, 4, 4, 4, 4);
            m25825V();
        }
    }

    /* renamed from: M */
    public void m25816M() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m25827a(4, 4, 4, 4, 4, 0, 4);
        } else {
            if (i2 != 1) {
                return;
            }
            m25827a(4, 4, 4, 4, 4, 0, 4);
        }
    }

    /* renamed from: N */
    public void m25817N() {
        int i2 = this.f2758b;
        if (i2 == 0) {
            m25827a(0, 0, 0, 4, 4, 0, 4);
            m25825V();
        } else {
            if (i2 != 1) {
                return;
            }
            m25827a(0, 0, 0, 4, 4, 4, 4);
            m25825V();
        }
    }

    /* renamed from: O */
    public void m25818O() {
        int i2 = this.f2758b;
        if (i2 == 0 || i2 == 1) {
            m25827a(4, 4, 4, 0, 0, 4, 4);
            m25825V();
        }
    }

    /* renamed from: P */
    public void m25819P() {
        int i2 = this.f2757a;
        if (i2 == 0 || i2 == 7 || i2 == 6) {
            return;
        }
        post(new Runnable() { // from class: ui.view.h
            @Override // java.lang.Runnable
            public final void run() {
                RecordItemJzvd.this.m25820Q();
            }
        });
    }

    /* renamed from: Q */
    public /* synthetic */ void m25820Q() {
        this.f2776t.setVisibility(4);
        this.f2775s.setVisibility(4);
        this.f2769m.setVisibility(4);
        PopupWindow popupWindow = this.f24610I0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (this.f2758b != 2) {
            this.f24603B0.setVisibility(0);
        }
    }

    /* renamed from: R */
    public /* synthetic */ void m25821R() {
        if (this.f2750E || this.f2749D) {
            return;
        }
        m25823T();
    }

    /* renamed from: S */
    public void m25822S() {
        int i2 = this.f2757a;
        if (i2 == 1) {
            if (this.f2776t.getVisibility() == 0) {
                m25818O();
            }
        } else if (i2 == 4) {
            if (this.f2776t.getVisibility() == 0) {
                m25816M();
            }
        } else if (i2 == 5) {
            if (this.f2776t.getVisibility() == 0) {
                m25814K();
            }
        } else if (i2 == 6 && this.f2776t.getVisibility() == 0) {
            m25811H();
        }
    }

    /* renamed from: T */
    public void m25823T() {
        int i2 = this.f2757a;
        if (i2 == 1) {
            m25818O();
            this.f2776t.getVisibility();
        } else if (i2 == 4) {
            m25817N();
        } else if (i2 == 5) {
            if (this.f2776t.getVisibility() == 0) {
                m25814K();
            } else {
                m25815L();
            }
        }
    }

    /* renamed from: U */
    public void m25824U() {
        m25810G();
        f24601b1 = new Timer();
        this.f24613L0 = new C7189a();
        f24601b1.schedule(this.f24613L0, 2500L);
    }

    /* renamed from: V */
    public void m25825V() {
        int i2 = this.f2757a;
        if (i2 == 4) {
            this.f2769m.setVisibility(0);
            this.f2769m.setImageResource(C2113R.drawable.jz_click_pause_selector);
            this.f24608G0.setVisibility(8);
        } else if (i2 == 7) {
            this.f2769m.setVisibility(4);
            this.f24608G0.setVisibility(8);
        } else if (i2 != 6) {
            this.f2769m.setImageResource(C2113R.drawable.jz_click_play_selector);
            this.f24608G0.setVisibility(8);
        } else {
            this.f2769m.setVisibility(0);
            this.f2769m.setImageResource(C2113R.drawable.jz_click_replay_selector);
            this.f24608G0.setVisibility(0);
        }
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2455a(Context context) {
        super.mo2455a(context);
        this.f24603B0 = (ProgressBar) findViewById(C2113R.id.bottom_progress);
        this.f24605D0 = (TextView) findViewById(C2113R.id.title);
        this.f24602A0 = (ImageView) findViewById(C2113R.id.back);
        this.f24606E0 = (ImageView) findViewById(C2113R.id.thumb);
        this.f24604C0 = (ProgressBar) findViewById(C2113R.id.loading);
        this.f24607F0 = (ImageView) findViewById(C2113R.id.back_tiny);
        this.f24608G0 = (TextView) findViewById(C2113R.id.replay_text);
        this.f24609H0 = (TextView) findViewById(C2113R.id.clarity);
        this.f24611J0 = (TextView) findViewById(C2113R.id.retry_btn);
        this.f24612K0 = (LinearLayout) findViewById(C2113R.id.retry_layout);
        this.f24606E0.setOnClickListener(this);
        this.f24602A0.setOnClickListener(this);
        this.f24607F0.setOnClickListener(this);
        this.f24609H0.setOnClickListener(this);
        this.f24611J0.setOnClickListener(this);
        this.f24608G0.setOnClickListener(this);
    }

    /* renamed from: b */
    public /* synthetic */ void m25830b(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        m2468d();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: e */
    public void mo2469e() {
        super.mo2469e();
        Dialog dialog = this.f24623V0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: f */
    public void mo2470f() {
        super.mo2470f();
        Dialog dialog = this.f24614M0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: g */
    public void mo2471g() {
        super.mo2471g();
        Dialog dialog = this.f24619R0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public int getLayoutId() {
        return C2113R.layout.record_layout_item;
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: j */
    public void mo2474j() {
        super.mo2474j();
        m25810G();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: m */
    public void mo2477m() {
        super.mo2477m();
        m25811H();
        m25810G();
        this.f24603B0.setProgress(100);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: n */
    public void mo2478n() {
        super.mo2478n();
        m25812I();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: o */
    public void mo2479o() {
        super.mo2479o();
        m25813J();
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == C2113R.id.thumb) {
            C1280v c1280v = this.f2759c;
            if (c1280v == null || c1280v.f2861b.isEmpty() || this.f2759c.m2522c() == null) {
                Toast.makeText(getContext(), getResources().getString(C2113R.string.no_url), 0).show();
                return;
            }
            int i2 = this.f2757a;
            if (i2 != 0) {
                if (i2 == 6) {
                    m25823T();
                    m2444A();
                    return;
                }
                return;
            }
            if (this.f2759c.m2522c().toString().startsWith("file") || this.f2759c.m2522c().toString().startsWith("/") || C1283y.m2557e(getContext()) || Jzvd.f2740u0) {
                m2444A();
                return;
            } else {
                mo2488x();
                return;
            }
        }
        if (id == C2113R.id.surface_container) {
            m25824U();
            return;
        }
        if (id == C2113R.id.back) {
            Jzvd.m2437C();
            return;
        }
        if (id == C2113R.id.back_tiny) {
            m2468d();
            return;
        }
        if (id != C2113R.id.clarity) {
            if (id == C2113R.id.retry_btn) {
                if (this.f2759c.f2861b.isEmpty() || this.f2759c.m2522c() == null) {
                    Toast.makeText(getContext(), getResources().getString(C2113R.string.no_url), 0).show();
                    return;
                }
                if (!this.f2759c.m2522c().toString().startsWith("file") && !this.f2759c.m2522c().toString().startsWith("/") && !C1283y.m2557e(getContext()) && !Jzvd.f2740u0) {
                    mo2488x();
                    return;
                } else {
                    m2446a();
                    mo2482r();
                    return;
                }
            }
            return;
        }
        final LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C2113R.layout.jz_layout_clarity, (ViewGroup) null);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ui.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RecordItemJzvd.this.m25829a(linearLayout, view2);
            }
        };
        for (int i3 = 0; i3 < this.f2759c.f2861b.size(); i3++) {
            String m2518a = this.f2759c.m2518a(i3);
            TextView textView = (TextView) View.inflate(getContext(), C2113R.layout.jz_layout_clarity_item, null);
            textView.setText(m2518a);
            textView.setTag(Integer.valueOf(i3));
            linearLayout.addView(textView, i3);
            textView.setOnClickListener(onClickListener);
            if (i3 == this.f2759c.f2860a) {
                textView.setTextColor(Color.parseColor("#fff85959"));
            }
        }
        this.f24610I0 = new PopupWindow((View) linearLayout, -2, -2, true);
        this.f24610I0.setContentView(linearLayout);
        this.f24610I0.showAsDropDown(this.f24609H0);
        linearLayout.measure(0, 0);
        this.f24610I0.update(this.f24609H0, -(this.f24609H0.getMeasuredWidth() / 3), -(this.f24609H0.getMeasuredHeight() / 3), Math.round(linearLayout.getMeasuredWidth() * 2), linearLayout.getMeasuredHeight());
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        m25810G();
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        m25824U();
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == C2113R.id.surface_container) {
            int action = motionEvent.getAction();
            if (action != 0 && action == 1) {
                m25824U();
                if (this.f2750E) {
                    long duration = getDuration();
                    long j2 = this.f2755J * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.f24603B0.setProgress((int) (j2 / duration));
                }
                Runnable runnable = new Runnable() { // from class: ui.view.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        RecordItemJzvd.this.m25821R();
                    }
                };
                view.postDelayed(runnable, this.f24627Z0 + 20);
                this.f24628a1.add(runnable);
                while (this.f24628a1.size() > 2) {
                    this.f24628a1.pollFirst();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f24626Y0 < this.f24627Z0) {
                    Iterator<Runnable> it = this.f24628a1.iterator();
                    while (it.hasNext()) {
                        view.removeCallbacks(it.next());
                    }
                    int i2 = this.f2757a;
                    if (i2 == 4 || i2 == 5) {
                        String str = "doublClick [" + hashCode() + "] ";
                        this.f2769m.performClick();
                    }
                }
                this.f24626Y0 = currentTimeMillis;
            }
        } else if (id == C2113R.id.bottom_seek_progress) {
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                m25810G();
            } else if (action2 == 1) {
                m25824U();
            }
        }
        return super.onTouch(view, motionEvent);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: p */
    public void mo2480p() {
        super.mo2480p();
        m25815L();
        m25810G();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: q */
    public void mo2481q() {
        super.mo2481q();
        m25816M();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: r */
    public void mo2482r() {
        super.mo2482r();
        m25818O();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: s */
    public void mo2483s() {
        super.mo2483s();
        m25810G();
        PopupWindow popupWindow = this.f24610I0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setBufferProgress(int i2) {
        super.setBufferProgress(i2);
        if (i2 != 0) {
            this.f24603B0.setSecondaryProgress(i2);
        }
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: t */
    public void mo2484t() {
        super.mo2484t();
        this.f24603B0.setProgress(0);
        this.f24603B0.setSecondaryProgress(0);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: u */
    public void mo2485u() {
        super.mo2485u();
        this.f2771o.setImageResource(C2113R.drawable.jz_shrink);
        this.f24602A0.setVisibility(0);
        this.f24607F0.setVisibility(4);
        if (this.f2759c.f2861b.size() == 1) {
            this.f24609H0.setVisibility(8);
        } else {
            this.f24609H0.setText(this.f2759c.m2520b().toString());
            this.f24609H0.setVisibility(0);
        }
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: v */
    public void mo2486v() {
        super.mo2486v();
        this.f2771o.setImageResource(C2113R.drawable.jz_enlarge);
        this.f24602A0.setVisibility(8);
        this.f24607F0.setVisibility(4);
        this.f24609H0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: w */
    public void mo2487w() {
        super.mo2487w();
        this.f24607F0.setVisibility(0);
        m25827a(4, 4, 4, 4, 4, 4, 4);
        this.f24609H0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: x */
    public void mo2488x() {
        super.mo2488x();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getResources().getString(C2113R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(C2113R.string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: ui.view.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                RecordItemJzvd.this.m25828a(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(getResources().getString(C2113R.string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: ui.view.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                RecordItemJzvd.this.m25830b(dialogInterface, i2);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ui.view.l
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public RecordItemJzvd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24626Y0 = 0L;
        this.f24627Z0 = 200L;
        this.f24628a1 = new ArrayDeque<>();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2458a(C1280v c1280v, int i2, Class cls) {
        super.mo2458a(c1280v, i2, cls);
        this.f24605D0.setText(c1280v.f2862c);
        setScreen(i2);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2453a(int i2, long j2) {
        super.mo2453a(i2, j2);
        this.f2769m.setVisibility(4);
        this.f24608G0.setVisibility(8);
        this.f24612K0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2459a(C1280v c1280v, long j2) {
        super.mo2459a(c1280v, j2);
        this.f24605D0.setText(c1280v.f2862c);
        this.f2769m.setVisibility(4);
        this.f24608G0.setVisibility(8);
        this.f24612K0.setVisibility(8);
    }

    /* renamed from: a */
    public /* synthetic */ void m25829a(LinearLayout linearLayout, View view) {
        mo2453a(((Integer) view.getTag()).intValue(), getCurrentPositionWhenPlaying());
        this.f24609H0.setText(this.f2759c.m2520b().toString());
        for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
            if (i2 == this.f2759c.f2860a) {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#fff85959"));
            } else {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#ffffff"));
            }
        }
        PopupWindow popupWindow = this.f24610I0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m25828a(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        m2444A();
        Jzvd.f2740u0 = true;
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2454a(int i2, long j2, long j3) {
        super.mo2454a(i2, j2, j3);
        if (i2 != 0) {
            this.f24603B0.setProgress(i2);
        }
    }

    /* renamed from: a */
    public void m25827a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f2775s.setVisibility(i2);
        this.f2776t.setVisibility(i3);
        this.f2769m.setVisibility(i4);
        this.f24604C0.setVisibility(i5);
        this.f24606E0.setVisibility(i6);
        this.f24603B0.setVisibility(i7);
        this.f24612K0.setVisibility(i8);
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2449a(float f2, String str, long j2, String str2, long j3) {
        super.mo2449a(f2, str, j2, str2, j3);
        if (this.f24614M0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(C2113R.layout.jz_dialog_progress, (ViewGroup) null);
            this.f24615N0 = (ProgressBar) inflate.findViewById(C2113R.id.duration_progressbar);
            this.f24616O0 = (TextView) inflate.findViewById(C2113R.id.tv_current);
            this.f24617P0 = (TextView) inflate.findViewById(C2113R.id.tv_duration);
            this.f24618Q0 = (ImageView) inflate.findViewById(C2113R.id.duration_image_tip);
            this.f24614M0 = m25826a(inflate);
        }
        if (!this.f24614M0.isShowing()) {
            this.f24614M0.show();
        }
        this.f24616O0.setText(str);
        this.f24617P0.setText(" / " + str2);
        this.f24615N0.setProgress(j3 <= 0 ? 0 : (int) ((j2 * 100) / j3));
        if (f2 > 0.0f) {
            this.f24618Q0.setBackgroundResource(C2113R.drawable.jz_forward_icon);
        } else {
            this.f24618Q0.setBackgroundResource(C2113R.drawable.jz_backward_icon);
        }
        m25822S();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2448a(float f2, int i2) {
        super.mo2448a(f2, i2);
        if (this.f24619R0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(C2113R.layout.jz_dialog_volume, (ViewGroup) null);
            this.f24622U0 = (ImageView) inflate.findViewById(C2113R.id.volume_image_tip);
            this.f24621T0 = (TextView) inflate.findViewById(C2113R.id.tv_volume);
            this.f24620S0 = (ProgressBar) inflate.findViewById(C2113R.id.volume_progressbar);
            this.f24619R0 = m25826a(inflate);
        }
        if (!this.f24619R0.isShowing()) {
            this.f24619R0.show();
        }
        if (i2 <= 0) {
            this.f24622U0.setBackgroundResource(C2113R.drawable.jz_close_volume);
        } else {
            this.f24622U0.setBackgroundResource(C2113R.drawable.jz_add_volume);
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.f24621T0.setText(i2 + "%");
        this.f24620S0.setProgress(i2);
        m25822S();
    }

    @Override // cn.jzvd.Jzvd
    /* renamed from: a */
    public void mo2450a(int i2) {
        super.mo2450a(i2);
        if (this.f24623V0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(C2113R.layout.jz_dialog_brightness, (ViewGroup) null);
            this.f24625X0 = (TextView) inflate.findViewById(C2113R.id.tv_brightness);
            this.f24624W0 = (ProgressBar) inflate.findViewById(C2113R.id.brightness_progressbar);
            this.f24623V0 = m25826a(inflate);
        }
        if (!this.f24623V0.isShowing()) {
            this.f24623V0.show();
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.f24625X0.setText(i2 + "%");
        this.f24624W0.setProgress(i2);
        m25822S();
    }

    /* renamed from: a */
    public Dialog m25826a(View view) {
        Dialog dialog = new Dialog(getContext(), C2113R.style.jz_style_dialog_progress);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }
}
