package com.christian98gm.rsalogin.server.storage;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@OnlyIn(Dist.DEDICATED_SERVER)
public interface PlayerStorageProvider {
    boolean isRegistered(String name, String uuid, String key);
    void register(String name, String uuid, String key);
    void save();
}
