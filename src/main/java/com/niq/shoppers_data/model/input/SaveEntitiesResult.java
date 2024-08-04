package com.niq.shoppers_data.model.input;

import java.util.List;

public class SaveEntitiesResult {
    private int savedEntitiesCount;
    private int failedEntitiesCount;
    private List<String> errors;

    public SaveEntitiesResult() {
    }

    public SaveEntitiesResult(int savedEntitiesCount, int failedEntitiesCount) {
        this.savedEntitiesCount = savedEntitiesCount;
        this.failedEntitiesCount = failedEntitiesCount;
    }

    public int getSavedEntitiesCount() {
        return savedEntitiesCount;
    }

    public void setSavedEntitiesCount(int savedEntitiesCount) {
        this.savedEntitiesCount = savedEntitiesCount;
    }

    public int getFailedEntitiesCount() {
        return failedEntitiesCount;
    }

    public void setFailedEntitiesCount(int failedEntitiesCount) {
        this.failedEntitiesCount = failedEntitiesCount;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
