package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class compressor {
    public static void compressIt(File file) throws IOException{
        String path=file.getParent();

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos= new FileOutputStream(path+"/compressedFile.gz");
        GZIPOutputStream gzip=new GZIPOutputStream(fos);
        byte []buffer= new byte[1024];
        int len;

        while((len=fis.read(buffer))!=-1) {
            gzip.write(buffer,0,len);
        }

        fis.close();
        gzip.close();//why this is a problem.
        fos.close();


    }

    public static void main(String []args) throws IOException {
        File file=new File("C:/Users/SUBHENDU/Desktop/COMPRESSOR_DECOMPRESSOR/src/comp_decomp/test1.mp4");
        compressIt(file);
    }

}
