package io.github.flawgames.chatapi;

import io.papermc.paper.chat.ChatRenderer;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    /**
     * NOTE : YOU CAN USE IT ON AsyncChatEvent
     * e.renderer(ChatAPI.format(e.getPlayer(), "%player% " + ChatColor.WHITE + ": %format%"));
     * It can be used in this format.
     * This way, when a player with the nickname test enters hello,
     * “test: hello” will appear in the chat window.
     * @param chattedPlayer Texted Player. : e.getPlayer()
     * @param chat What did player say? : e.message()
     * @param format Form that appears in the chat window.
     * @return
     */
    public static ChatRenderer format(Player chattedPlayer, String chat, String format) {
        format = format.replaceAll("%player%", chattedPlayer.getName());
        format = format.replaceAll("%message%", chat);
        String finalF = format;
        return (source, sourceDisplay, message, viewer) -> Component.text().append(
                Component.text(),
                Component.text(finalF)
        ).build();
    }
}
