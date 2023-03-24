FROM ${docker.acs.image}:${alfresco.platform.version}

ARG TOMCAT_DIR=/usr/local/tomcat
ARG USERNAME=${alfresco.platform.docker.user}

ARG JAVA_HOME=/usr/java/default/lib/security

USER root

# Copie du fichier Dockerfile pour éviter une erreurs si aucun JARS n'existe
COPY Dockerfile extensions/*.jar $TOMCAT_DIR/webapps/alfresco/WEB-INF/lib/

# Copie du certificat pour joindre Pastell
COPY certificates/intranet.cg59.fr.crt $JAVA_HOME/.
RUN keytool -import -alias intranetCG59FR -keystore $JAVA_HOME/cacerts -file $JAVA_HOME/intranet.cg59.fr.crt -storepass changeit

# Copy Dockerfile to avoid an error if no AMPs exist
COPY Dockerfile extensions/*.amp $TOMCAT_DIR/amps/

RUN java -jar $TOMCAT_DIR/alfresco-mmt/alfresco-mmt*.jar install \
         $TOMCAT_DIR/amps $TOMCAT_DIR/webapps/alfresco -directory -nobackup -force

COPY alfresco-global.properties $TOMCAT_DIR/shared/classes/alfresco-global.properties
COPY dev-log4j.properties $TOMCAT_DIR/shared/classes/alfresco/extension
COPY disable-webscript-caching-context.xml $TOMCAT_DIR/shared/classes/alfresco/extension

# Copy Dockerfile to avoid an error if no license file exists
COPY Dockerfile license/*.* $TOMCAT_DIR/webapps/alfresco/WEB-INF/classes/alfresco/extension/license/

USER ${USERNAME}