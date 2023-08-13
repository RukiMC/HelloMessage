package space.zlfn.hellomessage

import io.github.monun.heartbeat.coroutines.HeartbeatScope
import io.github.monun.heartbeat.coroutines.Suspension
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.bukkit.plugin.java.JavaPlugin
import space.zlfn.hellomessage.language.LangManager
import space.zlfn.hellomessage.listener.JoinListener

public class HelloMessage : JavaPlugin() {
    companion object {
        lateinit var dataFolderPath: String

        //config
        var useUserLang: Boolean = false
        var pluginLang: String = "eng_usa"
    }
    override fun onEnable() {
        this.saveDefaultConfig()
        this.saveResource("lang/eng_usa.yml", true)
        this.saveResource("lang/kor_kor.yml", true)
        this.saveResource("motd.yml", false)
        server.pluginManager.registerEvents(JoinListener(), this)

        dataFolderPath = this.dataFolder.toString()
        pluginLang = this.config.get("Lang.lang") as String
        useUserLang = this.config.get("Option.use-user-lang") as Boolean

        val plLang = LangManager(this.dataFolder.toString() + "/lang/${pluginLang}.yml")
        logger.info(plLang.getMessage("Plugin.plugin-enabled"))
    }
}
