package com.example.helloworld.views;

import io.dropwizard.views.View;

public class CommandView extends View {
    //private final Person person;

    public enum Template {
        FREEMARKER("freemarker/refresh.ftl"),
        MUSTACHE("mustache/person.mustache");

        private String templateName;

        Template(String templateName) {
            this.templateName = templateName;
        }

        public String getTemplateName() {
            return templateName;
        }
    }

    public CommandView(CommandView.Template template) {
        super(template.getTemplateName());
        //this.person = person;
    }

    //public Person getPerson() {
    //    return person;
    //}
}
