package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.ProgressCallback;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Service for importing and exporting projects with ZIP support
 *
 * @author pablo03
 */
public class ProjectImporterExporterService {

    /**
     * Export a project to ZIP file
     */
    public void exportToZip(File sourceDir, File zipFile) throws IOException {
        // Normalize paths for cross-platform compatibility
        Path sourcePath = sourceDir.toPath().normalize();

        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            Files.walk(sourcePath)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        String entryName = sourcePath.relativize(path).toString()
                                .replace(File.separatorChar, '/');

                        ZipEntry zipEntry = new ZipEntry(entryName);
                        try {
                            zos.putNextEntry(zipEntry);
                            Files.copy(path, zos);
                            zos.closeEntry();
                        } catch (IOException e) {
                            throw new RuntimeException("Error adding file to ZIP: " + path, e);
                        }
                    });
        }
    }

    /**
     * Import a project from ZIP file
     */
    public void importFromZip(File zipFile, File targetDir) throws IOException {
        if (!targetDir.exists()) {
            if (!targetDir.mkdirs()) {
                throw new IOException("Failed to create target directory: " + targetDir.getPath());
            }
        }

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                // Create file with proper path for current OS
                String entryName = entry.getName().replace('/', File.separatorChar);
                File file = new File(targetDir, entryName);

                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    // Ensure parent directories exist
                    File parentDir = file.getParentFile();
                    if (parentDir != null && !parentDir.exists()) {
                        parentDir.mkdirs();
                    }

                    // Write file
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        byte[] buffer = new byte[8192];
                        int length;
                        while ((length = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                }
                zis.closeEntry();
            }
        }
    }

    /**
     * Import a project from ZIP file with progress callback
     */
    public void importFromZip(File zipFile, File targetDir, ProgressCallback callback) throws IOException {
        if (!targetDir.exists()) {
            if (!targetDir.mkdirs()) {
                throw new IOException("Failed to create target directory: " + targetDir.getPath());
            }
        }

        int totalEntries = 0;
        int processedEntries = 0;

        // First pass: count total entries
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            while (zis.getNextEntry() != null) {
                totalEntries++;
                zis.closeEntry();
            }
        }

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                processedEntries++;

                if (callback != null) {
                    callback.onProgress(processedEntries, totalEntries, entry.getName());
                }

                String entryName = entry.getName().replace('/', File.separatorChar);
                File file = new File(targetDir, entryName);

                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    File parentDir = file.getParentFile();
                    if (parentDir != null && !parentDir.exists()) {
                        parentDir.mkdirs();
                    }

                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        byte[] buffer = new byte[8192];
                        int length;
                        while ((length = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                }
                zis.closeEntry();
            }
        }

        if (callback != null) {
            callback.onComplete();
        }
    }


}