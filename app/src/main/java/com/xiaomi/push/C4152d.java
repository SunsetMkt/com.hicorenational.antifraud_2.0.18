package com.xiaomi.push;

import java.io.IOException;

/* renamed from: com.xiaomi.push.d */
/* loaded from: classes2.dex */
public class C4152d extends IOException {
    public C4152d(String str) {
        super(str);
    }

    /* renamed from: a */
    static C4152d m14246a() {
        return new C4152d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static C4152d m14247b() {
        return new C4152d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static C4152d m14248c() {
        return new C4152d("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static C4152d m14249d() {
        return new C4152d("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static C4152d m14250e() {
        return new C4152d("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static C4152d m14251f() {
        return new C4152d("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static C4152d m14252g() {
        return new C4152d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: h */
    static C4152d m14253h() {
        return new C4152d("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
