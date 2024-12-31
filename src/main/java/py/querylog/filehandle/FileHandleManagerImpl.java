/**
* Copyright (C) 2013-2024 Nanjing Pengyun Network Technology Co., Ltd.
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/ 

package py.querylog.filehandle;

import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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


