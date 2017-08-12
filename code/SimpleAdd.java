/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.oracle.walnut.pld.examples;

class SimpleAdd extends Node {

    private Node left;
    private Node right;

    @Override
    public Object execute() {
        Object leftValue = left.execute();
        Object rightValue = right.execute();

        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            /* addition for integers */
            return (Integer) leftValue + (Integer) rightValue;
        } else if (leftValue instanceof Double && rightValue instanceof Double) {
            /* addition for doubles */
            return (Double) leftValue + (Double) rightValue;
        } else {
            /* for any other pair of values, concatenate their string value */
            return leftValue.toString() + rightValue.toString();
        }
    }

}
