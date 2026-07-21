package util;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.StreamHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Level;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {
    
    private static final String LOG_FILE = "app.log";
    
    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    
    // Custom handler to output to System.out instead of System.err
    static class CustomConsoleHandler extends StreamHandler {
        public CustomConsoleHandler() {
            setOutputStream(System.out);
        }
        
        @Override
        public synchronized void publish(LogRecord record) {
            super.publish(record);
            flush();
        }
    }
    
    public static Logger getLogger(Class<?> clazz) {
        Logger logger = Logger.getLogger(clazz.getName());
        
        try {
            if (logger.getHandlers().length == 0) {
                logger.setLevel(Level.ALL);
                
                // Custom formatter with color support
                Formatter customFormatter = new Formatter() {
                    private static final DateTimeFormatter dateFormatter = 
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                    
                    @Override
                    public String format(LogRecord record) {
                        LocalDateTime time = LocalDateTime.now();
                        String color = getColor(record.getLevel());
                        return String.format("%s[%s] %s [%s] %s - %s%s%n",
                            color,
                            dateFormatter.format(time),
                            record.getLevel(),
                            record.getSourceClassName(),
                            record.getSourceMethodName(),
                            record.getMessage(),
                            RESET);
                    }
                    
                    private String getColor(Level level) {
                        if (level == Level.WARNING) {
                            return YELLOW;
                        } else if (level == Level.SEVERE) {
                            return RED;
                        }
                        return "";
                    }
                };
                
                // Console Handler - output to System.out with colors
                CustomConsoleHandler consoleHandler = new CustomConsoleHandler();
                consoleHandler.setLevel(Level.INFO);
                consoleHandler.setFormatter(customFormatter);
                logger.addHandler(consoleHandler);
                
                // File Handler (no colors in file)
                FileHandler fileHandler = new FileHandler(LOG_FILE, true);
                fileHandler.setLevel(Level.ALL);
                
                Formatter fileFormatter = new Formatter() {
                    private static final DateTimeFormatter dateFormatter = 
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                    
                    @Override
                    public String format(LogRecord record) {
                        LocalDateTime time = LocalDateTime.now();
                        return String.format("%s [%s] %s - %s%n",
                            dateFormatter.format(time),
                            record.getLevel(),
                            record.getSourceClassName(),
                            record.getMessage());
                    }
                };
                fileHandler.setFormatter(fileFormatter);
                logger.addHandler(fileHandler);
                
                logger.setUseParentHandlers(false);
            }
        } catch (IOException e) {
            logger.warning("Failed to configure file handler: " + e.getMessage());
        }
        
        return logger;
    }
}
