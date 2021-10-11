package com.josemarcellio.evelynresourcepack.utils;

import java.awt.Color;

import com.google.gson.JsonObject;

public class DiscordEmbed {

    private String title       = "Embed";
    private Color color        = Color.white;
    private String description = "This is an embed";
    private String thumbnail   = null;

    public DiscordEmbed setTitle(String title) {
        this.title = title != null ? title : "Embed";
        return this;
    }

    public DiscordEmbed setColor(Color color) {
        this.color = color != null ? color : Color.white;
        return this;
    }

    public DiscordEmbed setDescription(String description) {
        this.description = description != null ? description : "This is an embed";
        return this;
    }

    public DiscordEmbed setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public JsonObject toJSON() {
        JsonObject object = new JsonObject();

        // store title and description
        object.addProperty("title", this.title);
        object.addProperty("description", this.description);

        // store color
        long color = Util.getIntFromColor(this.color);
        object.addProperty("color", color);

        // store thumbnail
        if(this.thumbnail != null) {
            JsonObject thumbnailObj = new JsonObject();
            thumbnailObj.addProperty("url", this.thumbnail);
            object.add("thumbnail", thumbnailObj);
        }

        return object;
    }

}