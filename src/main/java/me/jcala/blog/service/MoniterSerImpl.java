package me.jcala.blog.service;

import com.sun.management.OperatingSystemMXBean;
import me.jcala.blog.service.inter.MoniterSer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;

/**
 * Created by Administrator on 2016/9/13.
 */
@Service
public class MoniterSerImpl implements MoniterSer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoniterSerImpl.class);
    @Override
   public int getFreeMemery(){
           OperatingSystemMXBean osmxb = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
           long totalvirtualMemory = osmxb.getTotalPhysicalMemorySize();
           long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
           Double compare = (freePhysicalMemorySize * 1.0 / totalvirtualMemory) * 100;
           return compare.intValue();
   }
}
