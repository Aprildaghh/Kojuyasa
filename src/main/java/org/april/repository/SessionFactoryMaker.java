package org.april.repository;

import org.april.model.Anime;
import org.april.model.Game;
import org.april.model.Movie;
import org.april.model.Series;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class SessionFactoryMaker {

    private static SessionFactory factory;

    private static final String URL = "jdbc:mysql://localhost:3306/kojuyasa";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "zxcasd45";

    private static void configureFactory()
    {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        Map<String, Object> settings = new HashMap<>();
        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
        settings.put("hibernate.connection.url", URL);
        settings.put("hibernate.connection.username", USERNAME);
        settings.put("hibernate.connection.password", PASSWORD);
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put("hibernate.show_sql", "false");
        settings.put("hibernate.format_sql", "false");
        settings.put("hibernate.generate_statistics", "false");
        settings.put("hibernate.logging.level", "off");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings).build();
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Anime.class);
        metadataSources.addAnnotatedClass(Movie.class);
        metadataSources.addAnnotatedClass(Series.class);
        metadataSources.addAnnotatedClass(Game.class);

        Metadata metadata = metadataSources.buildMetadata();

        factory = metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getFactory() {
        if(factory == null) configureFactory();
        return factory;
    }

}
