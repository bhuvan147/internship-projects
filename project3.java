import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkShortener {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;
    private Map<String, String> urlMap;

    public LinkShortener() {
        this.urlMap = new HashMap<>();
    }

    public String shortenUrl(String originalUrl) {
        String shortUrl = generateShortUrl();
        urlMap.put(shortUrl, originalUrl);
        return shortUrl;
    }

    public String originalUrl(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    private String generateShortUrl() {
        StringBuilder shortUrl = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            char randomChar = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
            shortUrl.append(randomChar);
        }

        return shortUrl.toString();
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();

        String originalUrl = "https://www.example.com";
        String shortUrl = linkShortener.shortenUrl(originalUrl);

        System.out.println("Original URL: " + originalUrl);
        System.out.println("Shortened URL: " + shortUrl);

        String retrievedUrl = linkShortener.originalUrl(shortUrl);
        System.out.println("Retrieved URL: " + retrievedUrl);
    }
}
