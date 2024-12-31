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

package py.querylog.eventdatautil;

import java.util.Map;
import py.common.PyService;


public class EventDataWorker {


  

  public EventDataWorker(PyService applicationName, Map<String, String> defaultNameValues) {

  }

  

  public EventDataWorker(PyService applicationName, Map<String, String> defaultNameValues,
      String hostName, String remoteAddr) {

  }

  

  public EventDataWorker(PyService pyService, String eventDataFileName,
      Map<String, String> defaultNameValues) {

  }

  

  public EventDataWorker(String applicationName, String rootPath,
      Map<String, String> defaultNameValues) {
  }

  public String work(String operationName, String counterName, long counterValue, long interval) {
    return "";
  }

  

  public String work(String operationName, String counterName, long counterValue, long interval,
      boolean instant) {
    return "";
  }

  public String work(String operationName, Map<String, Long> counters) {
    return "";
  }
  

  public String work(String operationName, Map<String, Long> counters, boolean instant) {
    return "";
  }

  public void addToDefaultNameValues(String userDefName, String value) {
  }

}
