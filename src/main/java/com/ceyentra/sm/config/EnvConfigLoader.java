package com.ceyentra.sm.config;

import io.github.cdimascio.dotenv.Dotenv;


public class EnvConfigLoader {
    public static void loadEnv() {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("ACCESS_KEY", dotenv.get("ACCESS_KEY"));
        System.setProperty("SECRET_KEY", dotenv.get("SECRET_KEY"));
        System.setProperty("REGION", dotenv.get("REGION"));
        System.setProperty("BUCKET_NAME", dotenv.get("BUCKET_NAME"));
        System.setProperty("BUCKET_URL", dotenv.get("BUCKET_URL"));
        System.setProperty("DOMAIN", dotenv.get("DOMAIN"));
    }
}
