// package example;

// import _ch1.FileUtil;
// import java.io.*;
// import java.util.Arrays;

// /**
// * ■ 將output目錄內的所有檔案copy到output1目錄
// */
// public class Ch13_ex3 {

// public static void main(String[] args) {

// String root = FileUtil.getRootPath();

// String srcPath = root + File.separator + "output";
// File file = new File(srcPath);
// String[] files = file.list();
// System.out.println(Arrays.toString(files));

// String destSrc = root + File.separator + "output1";
// File newFile = new File(destSrc);

// if (!newFile.exists()) {
// newFile.mkdir();
// System.out.println("?桅?撱箇?摰!");
// }

// if (files.length > 0) {

// try {
// for (String f : files) {
// System.out.println(f + " 瑼??瑁?銝?.");
// FileInputStream fs = new FileInputStream(file.getPath() + "\\" + f);
// FileOutputStream fo = new FileOutputStream(newFile.getPath() + "\\" + f);
// int b = fs.read();
// while (b != -1) {
// fo.write(b);
// b = fs.read();
// }
// }
// } catch (FileNotFoundException ex) {
// ex.printStackTrace();
// } catch (IOException ex) {
// ex.printStackTrace();
// }
// }
// }
// }
