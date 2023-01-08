package ch1;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderCallback {
    Integer doSomethingWithReader(BufferedReader bufferedReader) throws IOException;

}
