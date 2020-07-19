package com.primus.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrimusEntityFactory {


    public String getEntityClass(String entityName)
    {
        switch (entityName)
        {
            case "Brand" : return "com.primus.brands.model.Brand";

        }
        return "";
    }
}
