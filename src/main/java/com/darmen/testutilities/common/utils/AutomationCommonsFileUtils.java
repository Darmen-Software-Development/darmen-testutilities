package com.darmen.testutilities.common.utils;

import com.darmen.testutilities.customexceptions.AutomationCommonsRuntimeException;

import java.io.File;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;

import static com.darmen.testutilities.common.constants.DateConstants.YYYY_DD_MM_HH_MM_SS;

/**
 * This Class will be contain file manipulation methods extending the Apache Commons FileUtils
 * @author scottshea
 * @version 1.0
 * @since 1.0
 */
public class AutomationCommonsFileUtils extends FileUtils {

    private AutomationCommonsFileUtils() { }

    /**
     * Returns the file name of the newest file object created file in directory
     *
     * @param dirPath a directory path example "build/downloads"
     * @return Newest file name
     */
    public static String getLatestFileName(String dirPath) {
        return getLastestFile(dirPath).getName();
    }

    /**
     * Returns the File object that is the newest in the directory
     *
     * @param dirPath a directory path example "build/downloads"
     * @return Newest File Object
     */
    public static File getLastestFile(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            throw new AutomationCommonsRuntimeException("No files to return in " + dirPath);
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    /**
     * Gets the modified file date time returns empty string if no file is found.
     *
     * @param file File object
     * @return String MM/dd/yyyy HH:mm:ss
     */
    public static String getFileLastModifiedTime(File file) {
        String fileLastModifiedTime = "";
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_DD_MM_HH_MM_SS);

        if (file == null) {
            throw new AutomationCommonsRuntimeException("The file passed in is null");
        }

        fileLastModifiedTime = sdf.format(file.lastModified());

        return fileLastModifiedTime;
    }
}

