package com.josemarcellio.evelynresourcepack.utils;

import com.google.gson.JsonObject;

public class DiscordAuthor {

    public String name;
    public String avatarUrl;

    public DiscordAuthor(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public void export(JsonObject webhookData) {
        if(this.name != null) {
            webhookData.addProperty("username", this.name);
        }
        if(this.avatarUrl != null) {
            webhookData.addProperty("avatar_url", this.avatarUrl);
        }
    }

}