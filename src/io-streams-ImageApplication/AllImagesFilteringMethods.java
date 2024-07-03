import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class AllImagesFilteringMethods {

    public static ArrayList<String> listAllImages(String directoryPath) {


        ArrayList<String> imageFiles = new ArrayList<>();
        File directory = new File(directoryPath); // we will suppose that the directory contains images and file
        if (directory.isDirectory()) {
//            هي دي الحسنة اللي في الموضوع كله يت علاء دالة تطلع كل اسماء كل الملفات اللي في المجلد
            File[] allFilesIncludingImages = directory.listFiles();
            // we need to check the file type if it was an image we will add it
            // to some location or to a list
            if (allFilesIncludingImages != null) {
                for (File singleFile : allFilesIncludingImages) {
                    String completeFileNameWithExtension = singleFile.getName();
                    if (completeFileNameWithExtension.endsWith(".jpg")
                            || completeFileNameWithExtension.endsWith(".png")
                            || completeFileNameWithExtension.endsWith(".bmp")
                            || completeFileNameWithExtension.endsWith(".gif")
                            || completeFileNameWithExtension.endsWith(".avif")
                            || completeFileNameWithExtension.endsWith(".jpeg")
                            || completeFileNameWithExtension.endsWith(".svg")
                    ) {
                        imageFiles.add(completeFileNameWithExtension);
                    }
                }
            }

        } else {
            System.out.println("This is not a Directory This is just a file ");
        }
        return imageFiles;
    }


    /*
     * This method will be used to list all images recursively that are in the directory and subdirectories
     * عاوزين نجيب كل اللي جوا يا علاء ==== سهلة
     *
     * */
    // List image in the parent and subDirectories uaAlaa
    public static void listAllImagesRecursively(String directoryPath) {

        ArrayList<String> imagesFiles = new ArrayList<>();
        ArrayList<String> textFiles = new ArrayList<>();
        File directory = new File(directoryPath); // we will suppose that the directory contains images and file
//            هي دي الحسنة اللي في الموضوع كله يت علاء دالة تطلع كل اسماء كل الملفات اللي في المجلد
        if (directory.isDirectory()) {
            File[] allFilesIncludingImages = directory.listFiles();
            // we need to check the file type if it was an image we will add it
            // to some location or to a list
            if (allFilesIncludingImages != null) {
                for (File singleFile : allFilesIncludingImages) {
                    if (singleFile.isFile()) {
                        String completeFileNameWithExtension = singleFile.getName();
                        if (completeFileNameWithExtension.endsWith(".jpg")
                                || completeFileNameWithExtension.endsWith(".png")
                                || completeFileNameWithExtension.endsWith(".bmp")
                                || completeFileNameWithExtension.endsWith(".gif")
                                || completeFileNameWithExtension.endsWith(".avif")
                                || completeFileNameWithExtension.endsWith(".jpeg")
                                || completeFileNameWithExtension.endsWith(".svg")
                        ) {
                            imagesFiles.add(completeFileNameWithExtension);
                        } else if (completeFileNameWithExtension.endsWith(".txt")) {
                            textFiles.add(completeFileNameWithExtension);

                        }
                    } else if (singleFile.isDirectory()) {
                        // This just recursion Step ===> we need to make the function call itself because you
                        // do not know how many Directories that we have
                        listAllImagesRecursively(singleFile.getAbsolutePath()); // You have to use the Absolute path here uaAlaa or you will get Null result
                    }

                }
            }
        } else {
            System.out.println("This is not a directory please Check you path .. Thanks very much");
        }
        System.out.println(imagesFiles);
        System.out.println(textFiles);
    }


}
