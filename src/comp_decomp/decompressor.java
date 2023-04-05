package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
    public static void decompressIt(File file) throws IOException {
        String path=file.getParent();

        FileInputStream fis=new FileInputStream(file);
        GZIPInputStream gzip= new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(path+"decompressedFile.mp4");
        byte []buffer = new byte[1024];
        int len;
        while((len=gzip.read(buffer))!=-1) {
            fos.write(buffer,0,len);
        }

        fis.close();
        fos.close();
        gzip.close();
    }
    //Just for testing purpose.
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/SUBHENDU/Desktop/COMPRESSOR_DECOMPRESSOR/src/comp_decomp/compressedFile.gz");
        decompressIt(file);
    }
}
