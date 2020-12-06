package com.primus;

import com.primus.common.ObjectFactory;
import com.primus.generic.BusinessContext;
import com.primus.scheme.service.SchemeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Scheduled(fixedRate = 10000, )
    public void scheduleTaskWithFixedRate() {
        BusinessContext context = BusinessContext.createSchedulerContext();
        SchemeService schemeService = (SchemeService)ObjectFactory.getInstance().getServiceInstance("SchemeService",context);
        schemeService.updateSchemeStatus(context);

    }
}
