package com.pablocompany.proyecto.no1.compi2.ui.application.mediator;

/**
 * Progress callback interface
 */
public interface ProgressCallback {
    void onProgress(int current, int total, String fileName);

    void onComplete();
}