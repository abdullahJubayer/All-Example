package com.example.desing_pattern.behavioral.chain;

public class Uploader {
   private ImageHandler handler;

   public Uploader(ImageHandler handler){
       this.handler=handler;
   }

   public void upload(){
       handler.handle();
   }
}

abstract class ImageHandler{
    private  ImageHandler handler;

    public ImageHandler(ImageHandler handler){
        this.handler = handler;
    }

    public void handle(){
        if (completeHandle())
            return;
        if (handler != null)
            handler.handle();
    }

    protected abstract boolean completeHandle();
}

class ImagePicker extends ImageHandler{

    public ImagePicker(ImageHandler handler) {
        super(handler);
    }

    @Override
    public boolean completeHandle() {
        pickImage();
        return false;
    }

    private boolean pickImage(){
        return true;
    }
}

class ImageCompressor extends ImageHandler{

    public ImageCompressor(ImageHandler handler) {
        super(handler);
    }

    @Override
    public boolean completeHandle() {
        compress();
        return false;
    }

    private boolean compress(){
        return true;
    }
}

class ImageUploader extends ImageHandler{

    public ImageUploader(ImageHandler handler) {
        super(handler);
    }

    @Override
    public boolean completeHandle() {
        upload();
        return false;
    }

    private boolean upload(){
        return  true;
    }
}