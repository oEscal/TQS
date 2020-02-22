package geocoding;

import java.io.IOException;

public interface TqsHttpClient {
    String get(String s) throws IOException;
}
