package com.framework.common.ssh;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SshService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //ssh的root账号是很敏感的信息，不要暴露到配置文件中
    private static final String ip = "10.137.87.189";
    private static final int port = 22;
    private static final String user = "root";
    private static final String password = "iss_nnw123";

    public static Connection getConnect() {
        Connection conn=new Connection(ip, port);
        try {
            conn.connect();
            conn.authenticateWithPassword(user, password);
            System.out.println("ssh连接ok");
        }catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static String exeCmd(String cmd){
        String line=null;
        Connection connection=null;
        Session session=null;
        try {
            connection=getConnect();
            session=connection.openSession();
            session.execCommand(cmd);
            InputStream in = new StreamGobbler(session.getStdout());
            BufferedReader brs = new BufferedReader(new InputStreamReader(in));
            line = brs.readLine();
//	        logger.info(line);
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            connection.close();
        }
        return line;
    }
    // downLoadFile from Linux
    public static boolean scpUpload(String remoteFilePath,String localFilePath) {
        boolean bool=false;
        Connection connection=null;
        try {
            connection=getConnect();
            SCPClient scpClient = connection.createSCPClient();
            scpClient.put(localFilePath, remoteFilePath);
//            scpClient.pu

            bool=true;
        }catch(IOException ioe) {
            ioe.printStackTrace();
            bool =false;
        }finally {
            connection.close();
        }
        return bool;
    }

    public static boolean scpUpload(byte[] data, String name, String remoteFilePath) {
        boolean bool=false;
        Connection connection=null;
        try {
            connection=getConnect();
            SCPClient scpClient = connection.createSCPClient();
            scpClient.put(data, name, remoteFilePath);

            bool=true;
        }catch(IOException ioe) {
            ioe.printStackTrace();
            bool =false;
        }finally {
            connection.close();
        }
        return bool;
    }

    // uploadFile to Linux
    public static boolean scpDownload(String remoteFilePath,String localFilePath) {
        boolean bool=false;
        Connection connection=null;
        try {
            connection=getConnect();
            SCPClient scpClient = connection.createSCPClient();
            scpClient.get(remoteFilePath, localFilePath);
            bool=true;
        }catch(IOException ioe) {
            ioe.printStackTrace();
            bool =false;
        }finally {
            connection.close();
        }
        return bool;
    }

    public static void main(String[] args) {
        String out = SshService.exeCmd("df -m");
        SshService.scpUpload("/home/data/dataset", "d:/dfs/dis_category.csv");
        System.out.println(out);
    }
}
