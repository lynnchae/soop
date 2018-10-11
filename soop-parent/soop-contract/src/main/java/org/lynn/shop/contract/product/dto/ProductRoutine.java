package org.lynn.soop.contract.product.dto;

public enum ProductRoutine {
    A(1, "迪信通", 1, 2000, 1),
    B(2, "爱回收", 2, 2000, 1),
    C(3, "联科", 3, 2000, 1);
    private final int code;
    private final String displayName;
    private final int priority;
    private final int threshold;
    private final int step;

    ProductRoutine(int code, String displayName, int priority, int threshold, int step) {
        this.code = code;
        this.displayName = displayName;
        this.priority = priority;
        this.threshold = threshold;
        this.step = step;
    }

    public int getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPriority() {
        return priority;
    }

    public int getThreshold() {
        return threshold;
    }

    public int getStep() {
        return step;
    }

    public static ProductRoutine parse(Integer code) {
        if (code == null) {
            return A;
        }

        for (ProductRoutine productRoutine : ProductRoutine.values()) {
            if(productRoutine.getCode() == code) return productRoutine;
        }

        return A;
    }
}
