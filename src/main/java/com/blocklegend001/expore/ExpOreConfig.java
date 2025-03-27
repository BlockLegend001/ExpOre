package com.blocklegend001.expore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExpOreConfig {
    private static final File CONFIG_FILE = new File("config/expore-common.toml");

    // Overworld Ores
    public static int expOreMinExperience = 50;
    public static int expOreMaxExperience = 80;
    public static int deepslateExpOreMinExperience = 50;
    public static int deepslateExpOreMaxExperience = 80;

    // Nether Ore
    public static int netherExpOreMinExperience = 50;
    public static int netherExpOreMaxExperience = 80;

    // End Ore
    public static int endExpOreMinExperience = 50;
    public static int endExpOreMaxExperience = 80;

    public static void loadConfig() {
        if (!CONFIG_FILE.exists()) {
            saveConfig();
        } else {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                JsonObject config = JsonParser.parseReader(reader).getAsJsonObject();

                // Overworld Ores
                JsonObject expOreConfig = config.getAsJsonObject("expOre");
                expOreMinExperience = expOreConfig.get("minExperience").getAsInt();
                expOreMaxExperience = expOreConfig.get("maxExperience").getAsInt();

                JsonObject deepslateExpOreConfig = config.getAsJsonObject("deepslateExpOre");
                deepslateExpOreMinExperience = deepslateExpOreConfig.get("minExperience").getAsInt();
                deepslateExpOreMaxExperience = deepslateExpOreConfig.get("maxExperience").getAsInt();

                // Nether Ore
                JsonObject netherExpOreConfig = config.getAsJsonObject("netherExpOre");
                netherExpOreMinExperience = netherExpOreConfig.get("minExperience").getAsInt();
                netherExpOreMaxExperience = netherExpOreConfig.get("maxExperience").getAsInt();

                // End Ore
                JsonObject endExpOreConfig = config.getAsJsonObject("endExpOre");
                endExpOreMinExperience = endExpOreConfig.get("minExperience").getAsInt();
                endExpOreMaxExperience = endExpOreConfig.get("maxExperience").getAsInt();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveConfig() {
        JsonObject config = new JsonObject();

        // Overworld Ores
        JsonObject expOreConfig = new JsonObject();
        expOreConfig.addProperty("minExperience", expOreMinExperience);
        expOreConfig.addProperty("maxExperience", expOreMaxExperience);
        config.add("expOre", expOreConfig);

        JsonObject deepslateExpOreConfig = new JsonObject();
        deepslateExpOreConfig.addProperty("minExperience", deepslateExpOreMinExperience);
        deepslateExpOreConfig.addProperty("maxExperience", deepslateExpOreMaxExperience);
        config.add("deepslateExpOre", deepslateExpOreConfig);

        // Nether Ore
        JsonObject netherExpOreConfig = new JsonObject();
        netherExpOreConfig.addProperty("minExperience", netherExpOreMinExperience);
        netherExpOreConfig.addProperty("maxExperience", netherExpOreMaxExperience);
        config.add("netherExpOre", netherExpOreConfig);

        // End Ore
        JsonObject endExpOreConfig = new JsonObject();
        endExpOreConfig.addProperty("minExperience", endExpOreMinExperience);
        endExpOreConfig.addProperty("maxExperience", endExpOreMaxExperience);
        config.add("endExpOre", endExpOreConfig);

        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            writer.write(config.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            writer.write(gson.toJson(config));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}