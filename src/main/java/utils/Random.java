package utils;

public class Random {

    public static String RANDOM_NAME;

    public Random() {
    }

    public static String createRandomName(){
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        java.util.Random random = new java.util.Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return RANDOM_NAME = buffer.toString();
    }
}