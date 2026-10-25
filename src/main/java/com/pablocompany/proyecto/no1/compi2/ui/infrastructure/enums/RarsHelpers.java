package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Principal RARS helper enums for the running terminal generation code
 *
 */
@Getter
@AllArgsConstructor
public enum RarsHelpers {

    /**
     * Constant to runs the RARS resource without freeze the terminal
     *
     */
    RARS_RUN_SOURCE("""
            import java.io.BufferedWriter;
            import java.lang.reflect.Field;
            
            public class RarsRun {
                public static void main(String[] args) throws Exception {
                    Field f = Class.forName("rars.util.SystemIO$FileIOData").getDeclaredField("outputWriter");
                    f.setAccessible(true);
                    Thread flusher = new Thread(() -> {
                        while (true) {
                            try {
                                BufferedWriter w = (BufferedWriter) f.get(null);
                                if (w != null) w.flush();
                                Thread.sleep(15);
                            } catch (InterruptedException e) {
                                return;
                            } catch (Throwable ignored) {
                            }
                        }
                    });
                    flusher.setDaemon(true);
                    flusher.start();
                    rars.Launch.main(args);
                }
            }
            """);

    private final String value;

}
