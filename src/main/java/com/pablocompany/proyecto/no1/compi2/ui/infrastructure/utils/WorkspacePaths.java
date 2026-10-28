package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.utils;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Helper class for the relative
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WorkspacePaths {

    /**
     * Method to know if the file is the same or inside
     *
     */
    public static boolean isSameOrInside(String candidate, String base) {
        return candidate.equals(base) || candidate.startsWith(base + "/");
    }

    /**
     * Method to know if the file replace the prefix
     *
     */
    public static String replacePrefix(String candidate, String oldBase, String newBase) {
        return newBase + candidate.substring(oldBase.length());
    }

    /**
     * Method to know if name of the file
     *
     */
    public static String nameOf(String path) {
        return path.substring(path.lastIndexOf('/') + 1);
    }
}