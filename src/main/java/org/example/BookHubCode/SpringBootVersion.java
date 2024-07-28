package org.example.BookHubCode;

public enum SpringBootVersion {
    VERSION_3_4_0_SNAPSHOT("3.4.0-SNAPSHOT"),
    VERSION_3_4_0_M1("3.4.0-M1"),
    VERSION_3_3_3_SNAPSHOT("3.3.3-SNAPSHOT"),
    VERSION_3_3_2("3.3.2"),
    VERSION_3_2_9_SNAPSHOT("3.2.9-SNAPSHOT"),
    VERSION_3_2_8("3.2.8");

    private final String version;

    SpringBootVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}
