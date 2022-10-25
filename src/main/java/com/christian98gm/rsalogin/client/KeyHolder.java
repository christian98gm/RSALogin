package com.christian98gm.rsalogin.client;

import com.christian98gm.rsalogin.RSALogin;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class KeyHolder
{
    private static KeyHolder INSTANCE;
    public static KeyHolder instance()
    {
        if(INSTANCE == null) {
            INSTANCE = new KeyHolder();
        }
        return INSTANCE;
    }

    private static final String BASE_PATH = ".";
    private static final String KEY_FILENAME = ".rsalogin_key";
    private static final Path KEY_PATH = Paths.get(BASE_PATH, KEY_FILENAME);

    private String key = "";

    private KeyHolder()
    {
        if(Files.exists(KEY_PATH)) {
            readKeyFromFile();
        } else {
            key = UUID.randomUUID().toString();
            writeKeyToFile();
        }
    }

    private void readKeyFromFile()
    {
        try {
            key = new String(Files.readAllBytes(KEY_PATH), StandardCharsets.UTF_8);
        } catch (IOException e) {
            RSALogin.LOGGER.error("Failed to read key from file", e);
        }
    }

    private void writeKeyToFile()
    {
        try {
            Files.write(KEY_PATH, key.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            RSALogin.LOGGER.error("Failed to read key from file", e);
        }
    }

    public String getKey()
    {
        return key;
    }
}
