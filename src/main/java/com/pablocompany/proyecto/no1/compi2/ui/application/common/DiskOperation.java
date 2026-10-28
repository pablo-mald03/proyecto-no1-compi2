package com.pablocompany.proyecto.no1.compi2.ui.application.common;

import java.io.IOException;

/**
 * Principal interface for the disk operations
 *
 */
@FunctionalInterface
public interface DiskOperation {
    void run() throws IOException;
}