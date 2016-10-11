package google.android.com.myapplicationwservice_parsexml;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by mail on 10/11/2016.
 */

public class MyBufferedInputStream extends BufferedInputStream {
    public MyBufferedInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        return super.read();
    }

    public String readToEnd() throws IOException {
        int inChar;
        final StringBuilder readStr = new StringBuilder();
        while ((inChar = this.read()) != -1) {
            readStr.append((char) inChar);
        }
        return readStr.toString();
    }
}
