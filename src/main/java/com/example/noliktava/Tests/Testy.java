package com.example.noliktava.Tests;
import org.junit.Test;

import static com.example.noliktava.LoginController.musicFile;
import static org.junit.Assert.assertEquals;
public class Testy {
    String filePath = "src/main/resources/com/example/noliktava/sound/utomp3.com - Windows Vista Startup Animation.mp3";


    @Test
    public void testFilePath() {
        assertEquals(filePath, musicFile);
    }
}
