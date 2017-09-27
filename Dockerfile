#Caso voce deseje utilizar o payara full
FROM payara/server-full
ENV DOMAIN domain1
ENV LIB /opt/payara41/glassfish/domains/${DOMAIN}/lib/
ENV DEPLOY ${PAYARA_PATH}/glassfish/domains/${DOMAIN}/autodeploy/
ADD target/SessionBean/WEB-INF/lib/ ${LIB}
ENTRYPOINT $PAYARA_PATH/bin/asadmin start-domain --verbose ${DOMAIN}
ADD target/SessionBean.war  ${DEPLOY}