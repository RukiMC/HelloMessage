package space.zlfn.hellomessage.language
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

public class LangManager(val path: String) {
    var conf: YamlConfiguration

    init {
        val file = File(path)
        conf = YamlConfiguration.loadConfiguration(file)
    }

    fun getMessage(path: String): String {
        val str = conf.getString(path)
            ?: throw NoLangStrException("Can not find ${path} in ${this.path}.")
        with(str) {
            return this
        }
    }
}