/*
 * Copyright (c) 2000, 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * @(#)TemporaryQueueImpl.java	1.14 06/27/07
 */ 

package com.sun.messaging.jmq.jmsclient;

import javax.jms.*;
import com.sun.messaging.AdministeredObject;
import com.sun.messaging.jmq.ClientConstants;

/** A TemporaryQueue is a unique Queue object created for the duration of a
  * Connection. It is a system defined queue that can only be consumed
  * by the Connection that created it.
  *
  * @see QueueSession#createTemporaryQueue()
  */
public class TemporaryQueueImpl extends TemporaryDestination implements TemporaryQueue {

    /**
     * Constructor used by createTemporaryQueue()
     */
    protected TemporaryQueueImpl (ConnectionImpl connection) throws JMSException {
        super(connection, ClientConstants.TEMPORARY_QUEUE_URI_NAME);
    }

    /**
     * Constructor used by MessageImpl.getJMSReplyTo()
     */
    protected TemporaryQueueImpl (String name) throws JMSException {
        super(name);
    }

    /**
     * Constructor used by MessageImpl.getJMSReplyTo()
     */
    protected TemporaryQueueImpl () throws JMSException {
        super();
    }

    public boolean isQueue() {
        return true;
    }

}
