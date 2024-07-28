package org.example.BookHubCode;

public enum JavaVersion {
    VERSION_22("22"),
    VERSION_21("21"),
    VERSION_17("17");

    private final String version;
    JavaVersion(String version){
        this.version=version;

    }
    public String getVersion() {
        return version;
    }

}
