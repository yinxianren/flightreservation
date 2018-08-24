package com.yilvtong.first.flightreservation;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // 该注解为了便于直接使用 log里的方法
public class LogTest {
    /**
     *   <p>
     *     日志打印级别  trace debug info warn error
     *   <p/>
     *   <p>
     *     如果要编写除控制台输出之外的日志文件，则需在application.properties中设置logging.file或logging.path属性。
     * logging.file，设置文件，可以是绝对路径，也可以是相对路径。如：logging.file=my.log
     * logging.path，设置目录，会在该目录下创建spring.log文件，并写入日志内容，如：logging.path=/var/log
     *    <p/>
     *    <p>如果只配置 logging.file，会在项目的当前路径下生成一个 xxx.log 日志文件。
     * 如果只配置 logging.path，在 /var/log文件夹生成一个日志文件为 spring.log
     * 注：二者不能同时使用，如若同时使用，则只有logging.file生效
     * 默认情况下，日志文件的大小达到10MB时会切分一次，产生新的日志文件，默认级别为：ERROR、WARN、INFO
     *    <p/>
     *
     *    级别控制
     *所有支持的日志记录系统都可以在Spring环境中设置记录级别（例如在application.properties中）
     *格式为：'logging.level.* = LEVEL'
     *logging.level：日志级别控制前缀，*为包名或Logger名
     *LEVEL：选项TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF
     *举例：
     *logging.level.com.dudu=DEBUG：com.dudu包下所有class以DEBUG级别输出
     *logging.level.root=WARN：root日志以WARN级别输出
     */
    private static void testLog(){

        log.trace("日志输出 trace 级别");
        log.debug("日志输出 debug 级别");
        log.info("日志输出 info 级别");
        log.warn("日志输出 warn 级别");
        log.error("日志输出 error 级别");

    }

    public static void main(String[] args) {
        testLog();
    }
}
