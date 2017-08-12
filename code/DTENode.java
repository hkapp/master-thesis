/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.oracle.walnut.pld.examples;

abstract class Node extends com.oracle.truffle.api.nodes.Node {

    /* Special Truffle method */
    abstract Object execute();

}
