/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class ContextFactory {

    private static final Properties properties = new Properties();
    private static final String PATH = "/config/context.properties";
    private static final String CLASS_NAME = "CLASS_NAME";

    private static Context context;

    static {
        try (InputStream is = ContextFactory.class.getResourceAsStream(PATH)) {
            properties.load(is);
            context = (Context) Class
                    .forName(properties.getProperty(CLASS_NAME))
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception ex) {
            Logger.getLogger(ContextFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Context getRepository() {
        return context;
    }

}
