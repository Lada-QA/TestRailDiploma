package constants;

import utils.PropertyReader;

public interface Constants {
    String BASE_URL = "https://kitty25.testrail.io/index.php?";
    String AUTH_LOGIN = BASE_URL + "/auth/login";
    String DASHBOARD_URL = BASE_URL + "/dashboard";
    String EMAIL = System.getenv().getOrDefault(System.getProperty("email"), PropertyReader.getProperty("email"));
    String PASSWORD = System.getenv().getOrDefault(System.getProperty("password"), PropertyReader.getProperty("password"));
    String INVALID_EMAIL = System.getenv().getOrDefault(System.getProperty("invalidEmail"), PropertyReader.getProperty("invalidEmail"));
    String INVALID_PASSWORD = System.getenv().getOrDefault(System.getProperty("invalidPassword"), PropertyReader.getProperty("invalidPassword"));
}
