import java.io.*;

public class AudioTool {
    public static void main(String[] args) {


        // ===== PROJECT ROOT =====
        String projectRoot = System.getProperty("user.dir");
        System.out.println("Project Root: " + projectRoot);

        // ===== PATHS (ROOT RELATIVE) =====
        File ffmpegFile = new File(
                projectRoot + "/ffmpeg/bin/ffmpeg.exe"
        );
        File inputFolder = new File(projectRoot + "/input_videos");
        File outputFolder = new File(projectRoot + "/output");

        // ===== CHECK FFMPEG =====
        if (!ffmpegFile.exists()) {
            System.err.println("❌ FFmpeg not found: " + ffmpegFile.getAbsolutePath());
            return;
        }

        // ===== CHECK INPUT FOLDER =====
        if (!inputFolder.exists() || !inputFolder.isDirectory()) {
            System.err.println("❌ Input folder not found: " + inputFolder.getAbsolutePath());
            return;
        }

        // ===== CREATE OUTPUT FOLDER =====
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
            System.out.println("Created output folder: " + outputFolder.getAbsolutePath());
        }

        // ===== PROCESS ALL VIDEOS =====
        File[] videos = inputFolder.listFiles((dir, name) ->
                name.toLowerCase().endsWith(".mp4")
        );

        if (videos == null || videos.length == 0) {
            System.err.println("❌ No videos found in input_videos");
            return;
        }

        for (File video : videos) {
            try {
                String baseName = video.getName().substring(0, video.getName().lastIndexOf('.'));
                File outputAudio = new File(outputFolder, baseName + ".m4a");

                String[] cmd = {
                        ffmpegFile.getAbsolutePath(),
                        "-i", video.getAbsolutePath(),
                        "-vn",
                        "-acodec", "copy",
                        outputAudio.getAbsolutePath()
                };

                ProcessBuilder pb = new ProcessBuilder(cmd);
                pb.redirectErrorStream(true);
                Process process = pb.start();

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(process.getInputStream())
                );

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    System.out.println("✅ Audio created: " + outputAudio.getAbsolutePath());
                } else {
                    System.err.println("❌ FFmpeg failed. Exit code: " + exitCode);
                }System.out.println("--------------------------------------------------");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}