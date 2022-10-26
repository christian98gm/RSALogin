package com.christian98gm.rsalogin.server.storage;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;

@OnlyIn(Dist.DEDICATED_SERVER)
public class RSALoginPlayer {

    public String name;
    public String uuid;
    public String key;

    public RSALoginPlayer(String name, String uuid, String key)
    {
        this.name = name;
        this.uuid = uuid;
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        RSALoginPlayer that = (RSALoginPlayer) o;
        return Objects.equals(name, that.name) && Objects.equals(uuid, that.uuid)
                && Objects.equals(key, that.key);
    }
}
