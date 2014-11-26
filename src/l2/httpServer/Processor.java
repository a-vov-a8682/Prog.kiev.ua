package l2.httpServer;

import java.util.List;

public interface Processor {
    byte[] process(byte[] data, List<String> headers);
}