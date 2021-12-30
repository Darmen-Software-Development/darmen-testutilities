package com.darmen.testutilities.common.constants;

public enum Browsers {
    CHROME("chrome"),
    FIREFOX("firefox"),
    SAFARI("safari"),
    IE("ie"),
    EDGE("edge");

    private String browser;

    Browsers(String aBrowser) {
        this.browser = aBrowser;
    }

    public String getBrowser() {
        return browser;
    }
}
