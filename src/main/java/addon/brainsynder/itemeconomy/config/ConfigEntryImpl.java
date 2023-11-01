package addon.brainsynder.itemeconomy.config;

import lib.brainsynder.utils.Colorize;
import org.bukkit.command.CommandSender;
import simplepets.brainsynder.addon.AddonConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigEntryImpl<T> implements ConfigEntry<T>{
    public static AddonConfig CONFIG;

    private final String PATH;
    private final T DEFAULT;
    private final String DESCRIPTION;
    private final List<String> PAST_PATHS = new ArrayList<>();

    private T value;

    public ConfigEntryImpl(String path, T defaultValue, String description) {
        PATH = path;
        DEFAULT = defaultValue;
        DESCRIPTION = description;
    }

    public ConfigEntryImpl(String path, T defaultValue) {
        this(path, defaultValue, null);
    }

    @Override
    public String getPath() {
        return PATH;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public T getDefault() {
        return DEFAULT;
    }

    @Override
    public T getValue() {
        if (value == null) return DEFAULT;
        return value;
    }

    @Override
    public void setValue(T value, boolean saveToFile) {
        this.value = value;
        if (saveToFile) {
            CONFIG.set(PATH, value);
            CONFIG.save();
        }
    }

    @Override
    public List<String> getPastPaths() {
        return PAST_PATHS;
    }

    @Override
    public ConfigEntry<T> setPastPaths(String... paths) {
        PAST_PATHS.addAll(Arrays.asList(paths));
        return this;
    }

    @Override
    public void sendMessage(CommandSender sender) {
        T value = getValue();
        List<String> messages = new ArrayList<>();
        if (value instanceof String string) {
            if (string.contains("\n")) {
                messages.addAll(Arrays.asList(string.split("\n")));
            } else {
                messages.add(string);
            }
        } else if (value instanceof List<?> list) {
            list.forEach(o -> messages.add(String.valueOf(o)));
        }

        messages.forEach(message -> sender.sendMessage(Colorize.translateBungeeHex(message)));
    }
}
