package web;

import org.hibernate.cfg.Configuration;
import web.model.User;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(User.class);
    }
}
