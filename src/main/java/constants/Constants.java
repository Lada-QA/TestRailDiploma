package constants;

import utils.PropertyReader;

public interface Constants {
    String BASE_URL = "https://kitty25.testrail.io/index.php?";
    String AUTH_LOGIN = BASE_URL + "/auth/login";
    String DASHBOARD_URL = BASE_URL + "/dashboard";
    String EMAIL = System.getenv().getOrDefault("vEmail", PropertyReader.getProperty("email"));
    String PASSWORD = System.getenv().getOrDefault("vPassword", PropertyReader.getProperty("password"));
    String INVALID_EMAIL = System.getenv().getOrDefault("inEmail", PropertyReader.getProperty("invalidEmail"));
    String INVALID_PASSWORD = System.getenv().getOrDefault("inPassword", PropertyReader.getProperty("invalidPassword"));
}
