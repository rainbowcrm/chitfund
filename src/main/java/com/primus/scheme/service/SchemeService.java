package com.primus.scheme.service;

import com.primus.generic.BusinessContext;
import com.primus.generic.GenericService;
import com.primus.scheme.dao.SchemeDAO;
import com.primus.scheme.model.Scheme;
import com.techtrade.rads.framework.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SchemeService extends GenericService {

    @Autowired
    SchemeDAO schemeDAO ;
    public void  updateSchemeStatus(BusinessContext context)
    {


    }

    private String getFormattedDate(Date date)
    {
        try {
            return Utils.dateToString(date, "yyyy-MM-dd hh:mm");
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return "2020-12-12 11:00";
    }
    public List<Map> getSnapshot(BusinessContext context)
    {
        List<Map> snapShot = new ArrayList<>();
        List<Scheme> schemes = schemeDAO.getAllActiveSchemes(context);
        schemes.forEach( scheme ->  {
            Map m1 = new HashMap<>();
            m1.put("id",scheme.getId());
            m1.put("start",getFormattedDate(scheme.getStartDate()));
            m1.put("allDay",false);
            m1.put("className","planned");
            snapShot.add(m1);

            Map m2 = new HashMap<>();
            m2.put("id",scheme.getId()+"A");
            m2.put("start",getFormattedDate(scheme.getNextAuctionDate()));
            m2.put("allDay",false);
            m2.put("className","scheduled");
            snapShot.add(m2);

        });
        return snapShot;

    }
}
