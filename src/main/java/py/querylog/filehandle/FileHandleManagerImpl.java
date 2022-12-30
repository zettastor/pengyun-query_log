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

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;


public class FileHandleManagerImpl implements FileHandleManager {

  private static final Logger logger = LoggerFactory.getLogger(FileHandleManagerImpl.class);
  private static volatile FileHandleManagerImpl singleInstance;
  private AtomicBoolean stop;

  private FileHandleManagerImpl() {
    this.stop = new AtomicBoolean(false);
  }

  
  public static FileHandleManagerImpl getInstance() {
    if (singleInstance == null) {
      synchronized (FileHandleManagerImpl.class) {
        if (singleInstance == null) {
          singleInstance = new FileHandleManagerImpl();
        }
      }
    }
    return singleInstance;
  }


  public int getFileHandleKey(FileHandleType fileHandleType, String appName, String filePath) {
    Validate.notNull(fileHandleType);
    Validate.notNull(filePath);

    int result = ((appName != null) ? appName.hashCode() : 0);
    result = 31 * result + filePath.hashCode();
    result = 31 * result + fileHandleType.hashCode();
    return result;
  }



  @Override
  public void closeAllFile() {
    logger.warn("all files closed");
  }

  @Override
  public void stop() {
    boolean update = this.stop.compareAndSet(false, true);
    if (!update) {
      logger.error("file handle manager is stopping now");
    }


      try {
        closeAllFile();
      } catch (Exception e) {
        logger.error("caught an exception", e);
      }
    }

  }


