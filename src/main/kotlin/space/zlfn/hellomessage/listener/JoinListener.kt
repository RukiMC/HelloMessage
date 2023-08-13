package space.zlfn.hellomessage.listener

import io.github.monun.heartbeat.coroutines.HeartbeatScope
import io.github.monun.heartbeat.coroutines.Suspension
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.PluginClassLoader
import space.zlfn.hellomessage.HelloMessage
import space.zlfn.hellomessage.language.LangManager
import java.io.File


class JoinListener : Listener {

    @EventHandler
    public fun onPlayerJoin(e: PlayerJoinEvent) {
        HeartbeatScope().launch {
            delay(500L) //locale 확인 대기
            val lang = e.player.locale().isO3Language + "_" + e.player.locale().isO3Country.lowercase()
            val file = File(HelloMessage.dataFolderPath + "/motd.yml")
            val conf = YamlConfiguration.loadConfiguration(file)

            if(HelloMessage.useUserLang) {
                conf.getString(lang)?.let {
                    e.player.sendRichMessage(it)
                } ?: run {
                    conf.getString(HelloMessage.pluginLang)?.let {
                        e.player.sendRichMessage(conf.getString(HelloMessage.pluginLang)!!)
                    } ?: run {
                        e.player.sendRichMessage(conf.getString("default")!!)
                    }
                }
            }

            else {
                e.player.sendRichMessage(conf.getString("default")!!)
            }
        }
    }

}