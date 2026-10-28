package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.io;

import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.io.File;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Class polls the project directory and hands every snapshot of relative paths to the listener on the EDT.
 *
 * @author pablo03
 */
@RequiredArgsConstructor
public class ProjectDiskWatcher {

    private static final long INTERVAL_MS = 1500;

    private final ProjectService projectService;
    private final Consumer<Set<String>> onSnapshot;

    private ScheduledExecutorService scheduler;

    /**
     * Method to start the poll
     *
     */
    public synchronized void start(File projectDir) {
        stop();
        scheduler = Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread(runnable, "project-disk-watcher");
            thread.setDaemon(true);
            return thread;
        });
        scheduler.scheduleWithFixedDelay(() -> poll(projectDir), INTERVAL_MS, INTERVAL_MS, TimeUnit.MILLISECONDS);
    }

    /**
     * Method to stop the poll
     *
     */
    public synchronized void stop() {
        if (scheduler != null) {
            scheduler.shutdownNow();
            scheduler = null;
        }
    }

    /**
     * Method to get the poll
     *
     */
    private void poll(File projectDir) {
        try {
            Set<String> snapshot = projectService.scanStructure(projectDir);
            SwingUtilities.invokeLater(() -> onSnapshot.accept(snapshot));
        } catch (RuntimeException ignored) {
            // the next poll retries
        }
    }
}