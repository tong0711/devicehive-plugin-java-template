package com.devicehive.plugin;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.devicehive.core.dao.Notify;
import com.devicehive.core.dao.NotifyDao;
import com.devicehive.core.proxy.DhMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * {"b":
 *     {"a":10,
 *        "notification":
 *        {"deviceTypeId":5,
 *             "deviceId":"IOuDBdHnTT7gFCDdHiaKm1BfecZG2JDIPHSE",
 *             "notification":"info",
 *             "networkId":2,
 *             "id":343162032,
 *             "parameters":{"xx":123},
 *             "timestamp":"2020-07-10T14:35:41.248"
 *         }
 *     },
 *   "err":0,
 *   "l":false,
 *   "cId":"43c1e554-d38b-4175-94db-bdbd853e5356",
 *   "fld":false}
 *
 *
 *   {"b":{"a":21,
 *   "command":
 *   {"deviceTypeId":9,
 *   "lifetime":null,
 *   "isUpdated":false,
 *   "userId":1,
 *   "deviceId":"XrRLEuhBgIrP2FEcdYqyYTkJvf8e1TdlZYr5",
 *   "command":"open",
 *   "result":null,
 *   "lastUpdated":"2020-07-10T15:23:13.521",
 *   "networkId":2,
 *   "id":954787503,
 *   "parameters":null,
 *   "timestamp":"2020-07-10T15:23:13.521","status":null}},
 *   "err":0,"l":false,"cId":"3033bc89-588c-4382-82b3-311f1aac3e50","fld":false}
 */
@Service
public class PluginService implements DhMessageHandler {

    private static final Logger logger = LoggerFactory.getLogger(PluginService.class);
    @Autowired
    private NotifyDao notifyDao;
    /*
    Custom plugin logic goes here
     */
    public void handleMessage(String message) {

        JSONObject  object=JSONUtil.parseObj(message);
        Notify notify=new Notify();
        JSONObject b=(JSONObject)object.get("b");
        Integer a=(Integer)b.get("a");
        if(a.equals(10)){
            JSONObject notifyj=(JSONObject) b.get("notification");
            String timestr=(String)notifyj.get("timestamp");
            Date timestamp=DateUtil.parse(timestr,"yyyy-MM-dd'T'HH:mm:ss.SSS");
            DateTime r=  DateUtil.offset(timestamp, DateField.HOUR,+8);

            notify=notifyj.toBean(Notify.class);
            notify.setTimestamp(timestamp);
            logger.info("-----------------------------------------notify-:"+notify);
            notifyDao.save(notify);

        }



    }
}
