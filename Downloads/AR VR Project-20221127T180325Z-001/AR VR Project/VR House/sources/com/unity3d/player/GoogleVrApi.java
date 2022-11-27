package com.unity3d.player;

import java.util.concurrent.atomic.AtomicReference;

public class GoogleVrApi {

    /* renamed from: a */
    private static AtomicReference f35a = new AtomicReference();

    private GoogleVrApi() {
    }

    /* renamed from: a */
    static void m20a() {
        f35a.set((Object) null);
    }

    /* renamed from: a */
    static void m21a(C0159f fVar) {
        f35a.compareAndSet((Object) null, new GoogleVrProxy(fVar));
    }

    /* renamed from: b */
    static GoogleVrProxy m22b() {
        return (GoogleVrProxy) f35a.get();
    }

    public static GoogleVrVideo getGoogleVrVideo() {
        return (GoogleVrVideo) f35a.get();
    }
}
