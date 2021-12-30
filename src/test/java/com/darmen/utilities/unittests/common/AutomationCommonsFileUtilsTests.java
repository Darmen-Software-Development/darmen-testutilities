package com.darmen.utilities.unittests.common;

import com.darmen.testutilities.common.utils.CommonUtils;
import com.darmen.testutilities.customexceptions.AutomationCommonsRuntimeException;

import com.darmen.utilities.unittests.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import static com.darmen.testutilities.common.constants.DateConstants.YYYY_DD_MM_HH_MM_SS;

import static com.darmen.testutilities.common.utils.AutomationCommonsFileUtils.getFileLastModifiedTime;
import static com.darmen.testutilities.common.utils.AutomationCommonsFileUtils.getLastestFile;
import static com.darmen.testutilities.common.utils.AutomationCommonsFileUtils.getLatestFileName;
import static org.apache.commons.io.FileUtils.deleteDirectory;

public class AutomationCommonsFileUtilsTests extends TestBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutomationCommonsFileUtilsTests.class);

    private static final String TEST_DIR = "src/test/resources/testDirectory";
    private static final String EMPTY_DIR = "src/test/resources/emptyDirectory";
    private static final String FIRST_FILE = "first.txt";
    private static final String SECOND_FILE = "second.txt";
    private static final long FILE_CREATION_WAIT_TIME = 1000;

    @BeforeMethod
    public void initialize() throws InterruptedException {
        ensureDirectoryExists(TEST_DIR);
        try {
            createFileForTest(FIRST_FILE);
            ensureDirectoryExists(EMPTY_DIR);
            CommonUtils.pause(FILE_CREATION_WAIT_TIME);
            createFileForTest(SECOND_FILE);
        } catch (IOException e) {
            LOGGER.error("Error in initializing Automation Commons File Utils Test:", e);
        }
    }

    @AfterMethod
    public void cleanUp() {
        try {
            deleteTestDirectory(EMPTY_DIR);
            deleteTestDirectory(TEST_DIR);
        } catch (IOException e) {
            LOGGER.error("Error cleaning up from Automation Commons File Utils Test", e);
        }
    }

    @Test(expectedExceptions = { AutomationCommonsRuntimeException.class })
    public void getLatestFileNameEmptyDirectory() {
        getLatestFileName(EMPTY_DIR);
    }

    @Test
    public void getLatestFileNameTestDir() {
        String latest = getLatestFileName(TEST_DIR);
        assertContains(latest, SECOND_FILE);
    }

    @Test(expectedExceptions = { AutomationCommonsRuntimeException.class })
    public void getLatestFileNameEmptyDir() {
        getLatestFileName(EMPTY_DIR);
    }

    @Test(expectedExceptions = { AutomationCommonsRuntimeException.class })
    public void getLatestFileNameInvalidDirectory() {
        getLatestFileName("invalidDir");
    }

    @Test
    public void getLatestFileTestDir() {
        File latest = getLastestFile(TEST_DIR);
        File[] fileList = new File(TEST_DIR).listFiles();
        int i = 0;

        //There are two files in this folder checking which one is older
        if (fileList[0].lastModified() < fileList[1].lastModified()) {
            i = 1;
        }
        assertEquals(fileList[i].toString(), latest.toString());
    }

    @Test
    public void getFileLastModifiedTimeSecondFile() {
        File file = new File(TEST_DIR + File.separator + SECOND_FILE);
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_DD_MM_HH_MM_SS);

        String expectedFileLastModifiedDateTime = sdf.format(file.lastModified());

        String secondFileLastModifiedDateTime = getFileLastModifiedTime(file);

        assertEquals(expectedFileLastModifiedDateTime, secondFileLastModifiedDateTime);
    }

    @Test(expectedExceptions = { AutomationCommonsRuntimeException.class })
    public void getFileLastModifiedTimeNullFile() {
        File file = null;
        getFileLastModifiedTime(file);
    }

    private void ensureDirectoryExists(String expectedDir) {
        File directory = new File(expectedDir);
        if (!directory.exists()) {
            boolean success = directory.mkdir();
            String directoryCreateStatus = String.format("Directory %s/ created? %s/", expectedDir, success);
            LOGGER.info(directoryCreateStatus);
        }
    }

    private boolean createFileForTest(String fileName) throws IOException  {
        String path = TEST_DIR + File.separator + fileName;
        File newFile = new File(path);
        boolean fileCreated = false;

        fileCreated = newFile.createNewFile();

        return fileCreated;
    }

    private void deleteTestDirectory(String directoryToBeDeleted) throws IOException {
        File file = new File(directoryToBeDeleted);

        deleteDirectory(file);
    }
}

