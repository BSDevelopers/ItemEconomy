package addon.brainsynder.itemeconomy.config;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface ConfigEntry<T> {
    /**
     * The function `getPath()` returns a string representing the path of a file or directory.
     *
     * @return A string representing the path.
     */
    String getPath();
    /**
     * The function returns a string that describes something.
     *
     * @return A string value representing the description of something.
     */
    String getDescription();

    /**
     * This function returns the default value of a generic type T.
     *
     * @return The method `getDefault()` is returning an object of type `T`. The specific type of `T` is not specified in
     * the method signature and will depend on the implementation of the method.
     */
    T getDefault();
    /**
     * The function "getValue" returns a value of type T.
     *
     * @return A value of type T is being returned. The specific type of T will depend on the implementation of the method
     * or function.
     */
    T getValue ();

    /**
     * This is a default method in Java that sets a value and takes a boolean parameter to indicate whether the value was
     * set.
     *
     * @param value The value parameter is of type T, which means it can be any data type. It is the value that needs to be
     * set.
     */
    default void setValue (T value) {
        setValue(value, false);
    }
    /**
     * This function sets a value of type T and optionally saves it to a file.
     *
     * @param value The value parameter is of type T, which means it can be any data type (such as int, double, String,
     * etc.) depending on how the method is defined. This parameter is used to set the value of a variable or object
     * property.
     * @param saveToFile The "saveToFile" parameter is a boolean value that determines whether or not the "value" parameter
     * should be saved to a file. If "saveToFile" is true, then the "value" parameter will be saved to a file. If
     * "saveToFile" is false, then the "value
     */
    void setValue (T value, boolean saveToFile);

    /**
     * The function returns a list of past paths.
     *
     * @return A list of strings representing past paths.
     */
    List<String> getPastPaths();
    /**
     * The function sets the past paths for a configuration entry in Java.
     *
     * @return The method does not return anything (void). It sets the past paths for a ConfigEntry object and updates its
     * state.
     */
    ConfigEntry<T> setPastPaths (String... paths);

    /**
     * This Java function returns example values based on the default value's data type.
     *
     * @return The method is returning a string that represents an example value for a given data type. The specific
     * example value depends on the data type of the object returned by the getDefault() method. If the data type is
     * boolean, the method returns "true or false". If the data type is double, the method returns "1.0". If the data type
     * is integer, the method returns "1,
     */
    default String getExamples () {
        String className = getDefault().getClass().getSimpleName();
        if (className.equalsIgnoreCase("boolean")) return "true or false";
        if (className.equalsIgnoreCase("double")) return "1.0";
        if (className.equalsIgnoreCase("integer")) return "1, 2, 3";
        if (className.equalsIgnoreCase("String")) return "\"im a string\"";
        return null;
    }

    /**
     * The function checks if the value is a string or an array list.
     * It will then send the value as message(s) to the target
     *
     * @param sender The parameter "sender" is of type CommandSender, which represents the target entity. It
     * could be a player, console, or command block.
     */
    void sendMessage (CommandSender sender);
}

