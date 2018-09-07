// MP3Converter.java
package com.chillyfacts.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tunde Michael
 * 
 */

public class MP3Converter {

    private static final Logger LOG = Logger.getLogger(MP3Converter.class.getName());
    
    public static void main(String[] args) {

        try {
            String line;
            String mp4File = "C:\\Users\\anina\\OneDrive\\Dokumente\\Youtube-dl\\ohrwurm.mp4";
            String mp3File = "C:\\Users\\anina\\Music\\ohrwurm.mp3";

            // ffmpeg -i input.mp4 output.avi as it's on www.ffmpeg.org
            String cmd = "ffmpeg -i " + mp4File + " " + mp3File;
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getErrorStream()));
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
            System.out.println("Video converted successfully!");
            in.close();
        } catch (IOException | InterruptedException e) {
            LOG.log(Level.SEVERE, null, e);
        }

    }

}