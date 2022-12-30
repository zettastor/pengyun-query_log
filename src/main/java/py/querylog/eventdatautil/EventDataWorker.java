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
