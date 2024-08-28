package hr.algebra.parsers.rss;

import hr.algebra.factory.ParserFactory;
import hr.algebra.factory.UrlConnectionFactory;
import hr.algebra.model.Conservation;
import hr.algebra.model.Family;
import hr.algebra.model.Light;
import hr.algebra.model.Plant;
import hr.algebra.model.Zone;
import hr.algebra.utilities.FileUtils;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author lorena
 */
public class PlantParser {

    private static final String RSS_URL = "http://localhost:7032/Plant/GetPlants";
    private static final String ATTRIBUTE_URL = "url";
    private static final String EXT = ".jpg";
    private static final String DIR = "assets";

    public static List<Plant> parse() throws IOException, XMLStreamException {
        List<Plant> plants = new ArrayList<>();
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL);
        try (InputStream is = con.getInputStream()) { // stream will close the connection
            XMLEventReader reader = ParserFactory.createStaxParser(is);

            Optional<TagType> tagType = Optional.empty();
            Plant plant = null;
            StartElement startElement = null;
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT -> {
                        startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        tagType = TagType.from(qName);
                        // put breakpoint here
                        if (tagType.isPresent() && tagType.get().equals(TagType.PLANT)) {
                            plant = new Plant();
                            plants.add(plant);
                        }
                    }
                    case XMLStreamConstants.CHARACTERS -> {
                        if (tagType.isPresent() && plant != null) {
                            Characters characters = event.asCharacters();
                            String data = characters.getData().trim();
                            switch (tagType.get()) {
                                case COMMON -> {
                                    if (!data.isEmpty()) {
                                        plant.setCommon_name(data);
                                    }
                                }
                                case BOTANICAL -> {
                                    if (!data.isEmpty()) {
                                        plant.setBotanical_name(data);
                                    }
                                }
                                case FAMILY -> {
                                    if (!data.isEmpty()) {
                                        plant.setFamily(new Family(data));
                                    }
                                }
                                case CONSERVATION -> {
                                    if (!data.isEmpty()) {
                                        plant.setConservation_status(new Conservation(data));
                                    }
                                }
                                case DESCRIPTION -> {
                                    if (!data.isEmpty()) {
                                        plant.setDescription(data);
                                    }
                                }                                
                                case PICTURE -> {
                                    if (startElement != null && plant.getPicture_path()== null) {
                                        Attribute urlAttribute = startElement.getAttributeByName(new QName(ATTRIBUTE_URL));
                                        if (urlAttribute != null) {
                                            handlePicture(plant, urlAttribute.getValue());
                                        }
                                    }
                                }
                                case LIGHT -> {
                                    if (!data.isEmpty()) {
                                        plant.setLight(new Light(data));
                                    }
                                }
                                case ZONE -> {
                                    if (!data.isEmpty()) {
                                        plant.setZone(new Zone(data));
                                    }
                                }
                                case PRICE -> {
                                    if (!data.isEmpty()) {
                                        plant.setPrice(Double.parseDouble(data));
                                    }
                                }
                                case AVAILABILITY -> {
                                    if (!data.isEmpty()) {
                                        plant.setAvailability(Integer.parseInt(data));
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return plants;

    }

    private static void handlePicture(Plant plant, String pictureUrl) {
        // if picture is not ok, we must continue!!!
        try {
            String ext = pictureUrl.substring(pictureUrl.lastIndexOf("."));
            if (ext.length() > 4) {
                ext = EXT;
            }
            String pictureName = UUID.randomUUID() + ext;
            String localPicturePath = DIR + File.separator + pictureName;

            FileUtils.copyFromUrl(pictureUrl, localPicturePath);
            // put breakpoint
            plant.setPicture_path(localPicturePath);
        } catch (IOException ex) {
            Logger.getLogger(PlantParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private enum TagType {

        PLANT("PLANT"),
        COMMON("COMMON"),
        BOTANICAL("BOTANICAL"),
        FAMILY("FAMILY"),
        CONSERVATION("CONSERVATION"),
        DESCRIPTION("DESCRIPTION"),
        PICTURE("PICTURE"),
        ZONE("ZONE"),
        LIGHT("LIGHT"),
        PRICE("PRICE"),
        AVAILABILITY("AVAILABILITY");

        private final String name;

        private TagType(String name) {
            this.name = name;
        }

        private static Optional<TagType> from(String name) {
            for (TagType value : values()) {
                if (value.name.equals(name)) {
                    return Optional.of(value);
                }
            }
            return Optional.empty();
        }
    }

}

