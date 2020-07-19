package com.primus.application;

import com.techtrade.rads.framework.annotations.RadsPropertySet;
import com.techtrade.rads.framework.model.abstracts.ModelObject;

import javax.persistence.*;

@Entity
@Table(name ="APPLICATION_MENUS")
public class Menu extends ModelObject {

    private String title;
    private String htmlFile;
    private String displayClass;
    private Application application;


    protected int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  ="ID")
    @RadsPropertySet(isPK = true)
    public int getId() {
        return id;
    }

    @RadsPropertySet(isPK = true)
    public void setId(int id) {
        this.id = id;
    }


    @Column(name  ="MENU_TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name  ="HTML_FILE")
    public String getHtmlFile() {
        return htmlFile;
    }

    public void setHtmlFile(String htmlFile) {
        this.htmlFile = htmlFile;
    }

    @Column(name  ="DISPLAY_CLASS")
    public String getDisplayClass() {
        return displayClass;
    }

    public void setDisplayClass(String displayClass) {
        this.displayClass = displayClass;
    }

    @RadsPropertySet(excludeFromJSON = true,excludeFromMap = true,excludeFromXML = true)
    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name  ="APP_NAME")
    public Application getApplication() {
        return application;
    }

    @RadsPropertySet(excludeFromJSON = true, excludeFromMap = true,excludeFromXML = true)
    public void setApplication(Application application) {
        this.application = application;
    }
}
