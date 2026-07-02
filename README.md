# 🎵 Audio Extractor Tool (Java + FFmpeg)

 
---

## ✨ Features

- 🎬 Extract audio from video files
- ⚡ Batch processing (multiple videos)
- 🎵 High-quality audio extraction using FFmpeg(install ffmpeg)
- 📁 Automatic input and output folder management
- 💻 Simple and lightweight Java application
- 🚀 Easy to run with Maven or IntelliJ IDEA

---

## 📂 Project Structure

```
AudioExtractor/
│
├── src/
│   └── main/
│       └── java/
│           ├── AudioTool.java
│           └── org/example/Main.java
│
├── input_videos/
│   └── (Place your videos here)
│
├── output/
│   └── (Generated audio files)
│
├── ffmpeg/
│   └── bin/
│       ├── ffmpeg.exe
│       ├── ffplay.exe
│       └── ffprobe.exe
│
├── pom.xml
├── .gitignore
└── README.md
```

---

## 🛠 Technologies Used

- Java
- Maven
- FFmpeg
- ProcessBuilder API
- IntelliJ IDEA

---

## 📥 Input

Place your video files inside:

```
input_videos/
```

Supported formats include:

- MP4
- MKV
- AVI
- MOV
- FLV
- WMV

---

## 📤 Output

Extracted audio files will be saved inside:

```
output/
```



## 📦 Requirements

- Java 17 or later
- Maven
- Windows OS
- FFmpeg (already included in this project)

---


---

## 🚀 Future Improvements

- Support for selecting output audio format (MP3, WAV, AAC)
- Custom output directory
- GUI using Java Swing / JavaFX
- Progress bar for extraction
- Drag & Drop support
- Multi-threaded processing

---

## 👨‍💻 Author

**Amandeep Kaur**

Junior Java Backend Developer
