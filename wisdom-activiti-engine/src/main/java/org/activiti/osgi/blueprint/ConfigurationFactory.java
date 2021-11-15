/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.activiti.osgi.blueprint;

import javax.sql.DataSource;

import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;

/**
 *
 * @author guilhem
 */
public class ConfigurationFactory {
    DataSource dataSource;
    String databaseSchemaUpdate;
    boolean jobExecutorActivate = true;

    public StandaloneProcessEngineConfiguration getConfiguration() {

        String smtpPortStr = System.getProperty("mail.smtp.port", "25");
        int mailServerPort = Integer.parseInt(smtpPortStr);
        String mailServerHost = System.getProperty("mail.smtp.host", "localhost");
        String mailServerFrom = System.getProperty("mail.smtp.from", "activiti@activiti.org");
        String mailServerUsername = System.getProperty("mail.smtp.username");
        String mailServerPassword = System.getProperty("mail.smtp.password");
        String mailServerConnection = System.getProperty("mail.smtp.connection");

        boolean useSSL = "SSL".equalsIgnoreCase(mailServerConnection);
        boolean useTLS = "TLS".equalsIgnoreCase(mailServerConnection);

        StandaloneProcessEngineConfiguration conf = new StandaloneProcessEngineConfiguration();
        conf.setDataSource(dataSource);
        conf.setDatabaseSchemaUpdate(databaseSchemaUpdate);
        conf.setJobExecutorActivate(jobExecutorActivate);
        conf.setMailServerPort(mailServerPort);
        conf.setMailServerHost(mailServerHost);
        conf.setMailServerDefaultFrom(mailServerFrom);
        conf.setMailServerUsername(mailServerUsername);
        conf.setMailServerPassword(mailServerPassword);
        conf.setMailServerUseSSL(useSSL);
        conf.setMailServerUseTLS(useTLS);
        return conf;
    }

    public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
    }

    public void setDatabaseSchemaUpdate(String databaseSchemaUpdate) {
      this.databaseSchemaUpdate = databaseSchemaUpdate;
    }

    public void setJobExecutorActivate(boolean jobExecutorActivate) {
      this.jobExecutorActivate = jobExecutorActivate;
    }
}
