package org.lynn.soop.controller.job;


import org.lynn.soop.contract.function.SysConfigContract;
import org.lynn.soop.contract.order.OrderServiceContract;
import org.lynn.soop.contract.stock.StockServiceContract;
import org.lynn.soop.controller.job.dto.JobResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@Path("/service/job")
public class JobController {
    private static final Logger log = Logger.getLogger(JobController.class);
    ExecutorService executorService;
    @Resource
    StockServiceContract stockServiceContract;

    @Resource
    OrderServiceContract orderServiceContract;

    @Resource
    SysConfigContract sysConfigContract;

    private static final int threadNo = 30;

    public JobController() {

        executorService = Executors.newFixedThreadPool(threadNo);
    }

    /**
     * 匹配订单和库存状态，可以每15分钟运行一次
     *
     * @return
     */
    @GET
    @Path("/order/deliverOrder")
    public String deliverOrder() {
        log.info("start execute job[deliverOrder]...");
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                stockServiceContract.deliverOrder();
            }
        });
        return JobResult.success.name();
    }

    /**
     * 物流快递状态查询同步
     *
     * @return
     */
    @GET
    @Path("/order/delivery/status")
    public String syncDeliveryStatus() {
        log.info("start execute job[syncDeliveryStatus]...");
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                orderServiceContract.syncDeliveryStatus();
            }
        });
        return JobResult.success.name();
    }

    @GET
    @Path("/common/sync/exchange/rate")
    public String syncExchangeRate() {
        log.info("start execute job[syncExchangeRate]...");
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                sysConfigContract.syncExchangeRate();
            }
        });
        return JobResult.success.name();
    }

}
