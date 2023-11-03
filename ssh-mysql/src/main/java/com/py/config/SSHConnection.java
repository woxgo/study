package com.py.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class SSHConnection {
    private static final Logger logger = LoggerFactory.getLogger(SSHConnection.class);
    private final static int LOCAl_PORT = 3307;
    private final static int REMOTE_PORT = 3306;
    private final static int SSH_REMOTE_PORT = 22;
    private final static String SSH_USER = "跳板机用户名";
    private final static String SSH_PASSWORD = "跳板机密码";
    private final static String SSH_REMOTE_SERVER = "跳板机IP";
    private final static String MYSQL_REMOTE_SERVER = "远程MysqlIP";

    private Session sesion; //represents each ssh session

    public void closeSSH ()
    {
        sesion.disconnect();
    }

    public SSHConnection() throws Throwable
    {
        logger.info("ssh begin");
        JSch jsch = null;

        jsch = new JSch();

        sesion = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);

        sesion.setPassword(SSH_PASSWORD);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        sesion.setConfig(config);

        sesion.connect(); //ssh connection established!

        //by security policy, you must connect through a fowarded port
        sesion.setPortForwardingL(LOCAl_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT);
        logger.info("ssh end");
    }
}
