package org.cd59.dna.model.rgpd;

import org.alfresco.service.namespace.QName;

public class RgpdModel {
    /**
      * Le préfixe du type de contenu.
      */
    public final static String PREFIX = "rgpd";

    /**
     * L'URL du type de contenu.
     */
    public final static String URI = "http://www.cd59.fr/model/rgpd/1.0";

    /**
     * Le nom de l'aspect.
     */
    public final static QName NOM = QName.createQName( URI , "typeDonneeRgpd");

    /**
     * Le type RGPD de l'aspect.
     */
    public final static QName TYPE = QName.createQName( URI , "typeRgpd");
}
