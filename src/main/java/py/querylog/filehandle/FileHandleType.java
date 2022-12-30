/*
 * Copyright (c) 2022. PengYunNetWork
 *
 * This program is free software: you can use, redistribute, and/or modify it
 * under the terms of the GNU Affero General Public License, version 3 or later ("AGPL"),
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 *  You should have received a copy of the GNU Affero General Public License along with
 *  this program. If not, see <http://www.gnu.org/licenses/>.
 */

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
