/*
 * Copyright (c) 2020 PANTHEON.tech s.r.o. All Rights Reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at https://www.eclipse.org/legal/epl-v10.html
 */
package io.lighty.netconf.device.toaster.processors;

import java.util.concurrent.Future;
import org.opendaylight.yang.gen.v1.http.netconfcentral.org.ns.toaster.rev201216.CancelToastInput;
import org.opendaylight.yang.gen.v1.http.netconfcentral.org.ns.toaster.rev201216.CancelToastOutput;
import org.opendaylight.yang.gen.v1.http.netconfcentral.org.ns.toaster.rev201216.ToasterService;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("checkstyle:MemberName")
public class ToasterServiceCancelToastProcessor extends ToasterServiceAbstractProcessor<CancelToastInput,
        CancelToastOutput> {

    private static final Logger LOG = LoggerFactory.getLogger(ToasterServiceCancelToastProcessor.class);

    private final ToasterService toasterService;
    private final QName qName = QName.create("http://netconfcentral.org/ns/toaster", "cancel-toast");

    public ToasterServiceCancelToastProcessor(final ToasterService toasterService) {
        this.toasterService = toasterService;
    }

    @Override
    public QName getIdentifier() {
        return this.qName;
    }

    @Override
    protected Future<RpcResult<CancelToastOutput>> execMethod(final CancelToastInput input) {
        LOG.info("execute RPC: cancel-toast");
        return this.toasterService.cancelToast(input);
    }

}
