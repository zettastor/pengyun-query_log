
package py.querylog.filehandle;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * file handle type.
 */
public enum FileHandleType {
  FILE_INPUT_STREAM(1, false);

  private static final Logger logger = LoggerFactory.getLogger(FileHandleType.class);
  private final int val;
  private final boolean isWrite;

  FileHandleType(int val, boolean isWrite) {
    this.val = val;
    this.isWrite = isWrite;
  }

  public boolean isWrite() {
    return isWrite;
  }

  public Object open(String filePath) throws Exception {
    return null;
  }

  public void close(Object fileHandle) throws Exception {
  }
}
