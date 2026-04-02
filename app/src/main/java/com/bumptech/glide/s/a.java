package com.bumptech.glide.s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: AndroidResourceSignature.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f3546d;

    private a(int i2, g gVar) {
        this.f3545c = i2;
        this.f3546d = gVar;
    }

    @NonNull
    public static g a(@NonNull Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.b(context));
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f3545c == aVar.f3545c && this.f3546d.equals(aVar.f3546d);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return l.a(this.f3546d, this.f3545c);
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        this.f3546d.a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f3545c).array());
    }
}
