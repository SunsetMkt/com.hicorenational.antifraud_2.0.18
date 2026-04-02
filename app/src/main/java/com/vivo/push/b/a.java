package com.vivo.push.b;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import ui.activity.BaseProgressUploadActivity;

/* JADX INFO: compiled from: AliasCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {
    private ArrayList<String> a;

    public a(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2 : 2003, str);
        this.a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a(SocializeProtocolConstants.TAGS, this.a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.c(SocializeProtocolConstants.TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AliasCommand:" + b();
    }
}
