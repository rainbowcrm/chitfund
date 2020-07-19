package com.primus.application;

import com.techtrade.rads.framework.annotations.RadsPropertySet;
import com.techtrade.rads.framework.model.abstracts.ModelObject;
import com.techtrade.rads.framework.utils.Utils;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name ="APPLICATION")
public class Application extends ModelObject {

    String appName;
    String appDisplayName ;

    @Column(name  ="APP_NAME")
    @Id
    @RadsPropertySet(isPK = true, isBK = true)
    public String getAppName() {
        return appName;
    }

    @RadsPropertySet(isPK = true, isBK = true)
    public
    void setAppName(String appName) {
        this.appName = appName;
    }

    @Column(name  ="APP_DISPLAY")
    public String getAppDisplayName() {
        return appDisplayName;
    }

    public void setAppDisplayName(String appDisplayName) {
        this.appDisplayName = appDisplayName;
    }

    private Set<Menu> menus;


    @OneToMany(mappedBy = "application")
    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public void addMenu(Menu menu) {
        if(Utils.isNullSet(menus))
        {
            menus = new TreeSet<>();
        }
        this.menus.add(menu);
    }
}
