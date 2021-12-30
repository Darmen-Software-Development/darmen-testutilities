package com.darmen.utilities.unittests.common.dataproviders;

import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.darmen.testutilities.common.utils.StringUtils.capitalize;

public class CommonUtilsDataProvider {
    private CommonUtilsDataProvider() { }

    @DataProvider(name = "dateTimeFormats")
    public static Object[][] dateTimeFormats() {
        int theYear = LocalDateTime.now().getYear();
        String dayOfWeek = String.valueOf(LocalDate.now().getDayOfWeek()).toLowerCase();
        return new Object[][]{
                {"yyyy", Integer.toString(theYear)},
                {"yyyy-MM-dd", LocalDate.now().toString()},
                {"EEEE", capitalize(dayOfWeek)},
                {"", ""}
        };
    }
}
